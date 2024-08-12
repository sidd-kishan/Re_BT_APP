/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.work.Configuration
 *  androidx.work.Data
 *  androidx.work.ForegroundUpdater
 *  androidx.work.ListenableWorker
 *  androidx.work.ListenableWorker$Result
 *  androidx.work.ListenableWorker$Result$Failure
 *  androidx.work.ListenableWorker$Result$Retry
 *  androidx.work.ListenableWorker$Result$Success
 *  androidx.work.Logger
 *  androidx.work.ProgressUpdater
 *  androidx.work.WorkInfo$State
 *  androidx.work.WorkerParameters
 *  androidx.work.WorkerParameters$RuntimeExtras
 *  androidx.work.impl.Scheduler
 *  androidx.work.impl.Schedulers
 *  androidx.work.impl.WorkDatabase
 *  androidx.work.impl.WorkerWrapper$Builder
 *  androidx.work.impl.background.systemalarm.RescheduleReceiver
 *  androidx.work.impl.foreground.ForegroundProcessor
 *  androidx.work.impl.model.DependencyDao
 *  androidx.work.impl.model.WorkSpec
 *  androidx.work.impl.model.WorkSpecDao
 *  androidx.work.impl.model.WorkTagDao
 *  androidx.work.impl.utils.PackageManagerHelper
 *  androidx.work.impl.utils.WorkForegroundRunnable
 *  androidx.work.impl.utils.WorkForegroundUpdater
 *  androidx.work.impl.utils.WorkProgressUpdater
 *  androidx.work.impl.utils.futures.SettableFuture
 *  androidx.work.impl.utils.taskexecutor.TaskExecutor
 */
package androidx.work.impl;

import android.content.Context;
import androidx.work.Configuration;
import androidx.work.Data;
import androidx.work.ForegroundUpdater;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.ProgressUpdater;
import androidx.work.WorkInfo;
import androidx.work.WorkerParameters;
import androidx.work.impl.Scheduler;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkerWrapper;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkTagDao;
import androidx.work.impl.utils.PackageManagerHelper;
import androidx.work.impl.utils.WorkForegroundRunnable;
import androidx.work.impl.utils.WorkForegroundUpdater;
import androidx.work.impl.utils.WorkProgressUpdater;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executor;

public class WorkerWrapper
implements Runnable {
    static final String TAG = Logger.tagWithPrefix((String)"WorkerWrapper");
    Context mAppContext;
    private Configuration mConfiguration;
    private DependencyDao mDependencyDao;
    private ForegroundProcessor mForegroundProcessor;
    SettableFuture<Boolean> mFuture;
    ListenableFuture<ListenableWorker.Result> mInnerFuture = null;
    private volatile boolean mInterrupted;
    ListenableWorker.Result mResult = ListenableWorker.Result.failure();
    private WorkerParameters.RuntimeExtras mRuntimeExtras;
    private List<Scheduler> mSchedulers;
    private List<String> mTags;
    private WorkDatabase mWorkDatabase;
    private String mWorkDescription;
    WorkSpec mWorkSpec;
    private WorkSpecDao mWorkSpecDao;
    private String mWorkSpecId;
    private WorkTagDao mWorkTagDao;
    TaskExecutor mWorkTaskExecutor;
    ListenableWorker mWorker;

    WorkerWrapper(Builder builder) {
        this.mFuture = SettableFuture.create();
        this.mAppContext = builder.mAppContext;
        this.mWorkTaskExecutor = builder.mWorkTaskExecutor;
        this.mForegroundProcessor = builder.mForegroundProcessor;
        this.mWorkSpecId = builder.mWorkSpecId;
        this.mSchedulers = builder.mSchedulers;
        this.mRuntimeExtras = builder.mRuntimeExtras;
        this.mWorker = builder.mWorker;
        this.mConfiguration = builder.mConfiguration;
        builder = builder.mWorkDatabase;
        this.mWorkDatabase = builder;
        this.mWorkSpecDao = builder.workSpecDao();
        this.mDependencyDao = this.mWorkDatabase.dependencyDao();
        this.mWorkTagDao = this.mWorkDatabase.workTagDao();
    }

    private String createWorkDescription(List<String> object) {
        StringBuilder stringBuilder = new StringBuilder("Work [ id=");
        stringBuilder.append(this.mWorkSpecId);
        stringBuilder.append(", tags={ ");
        object = object.iterator();
        boolean bl = true;
        while (true) {
            if (!object.hasNext()) {
                stringBuilder.append(" } ]");
                return stringBuilder.toString();
            }
            String string = (String)object.next();
            if (bl) {
                bl = false;
            } else {
                stringBuilder.append(", ");
            }
            stringBuilder.append(string);
        }
    }

    private void handleResult(ListenableWorker.Result result) {
        if (result instanceof ListenableWorker.Result.Success) {
            Logger.get().info(TAG, String.format("Worker result SUCCESS for %s", this.mWorkDescription), new Throwable[0]);
            if (this.mWorkSpec.isPeriodic()) {
                this.resetPeriodicAndResolve();
            } else {
                this.setSucceededAndResolve();
            }
        } else if (result instanceof ListenableWorker.Result.Retry) {
            Logger.get().info(TAG, String.format("Worker result RETRY for %s", this.mWorkDescription), new Throwable[0]);
            this.rescheduleAndResolve();
        } else {
            Logger.get().info(TAG, String.format("Worker result FAILURE for %s", this.mWorkDescription), new Throwable[0]);
            if (this.mWorkSpec.isPeriodic()) {
                this.resetPeriodicAndResolve();
            } else {
                this.setFailedAndResolve();
            }
        }
    }

    private void iterativelyFailWorkAndDependents(String string) {
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add(string);
        while (!linkedList.isEmpty()) {
            string = (String)linkedList.remove();
            if (this.mWorkSpecDao.getState(string) != WorkInfo.State.CANCELLED) {
                this.mWorkSpecDao.setState(WorkInfo.State.FAILED, new String[]{string});
            }
            linkedList.addAll(this.mDependencyDao.getDependentWorkIds(string));
        }
    }

    private void rescheduleAndResolve() {
        this.mWorkDatabase.beginTransaction();
        try {
            this.mWorkSpecDao.setState(WorkInfo.State.ENQUEUED, new String[]{this.mWorkSpecId});
            this.mWorkSpecDao.setPeriodStartTime(this.mWorkSpecId, System.currentTimeMillis());
            this.mWorkSpecDao.markWorkSpecScheduled(this.mWorkSpecId, -1L);
            this.mWorkDatabase.setTransactionSuccessful();
            return;
        }
        finally {
            this.mWorkDatabase.endTransaction();
            this.resolve(true);
        }
    }

    private void resetPeriodicAndResolve() {
        this.mWorkDatabase.beginTransaction();
        try {
            this.mWorkSpecDao.setPeriodStartTime(this.mWorkSpecId, System.currentTimeMillis());
            this.mWorkSpecDao.setState(WorkInfo.State.ENQUEUED, new String[]{this.mWorkSpecId});
            this.mWorkSpecDao.resetWorkSpecRunAttemptCount(this.mWorkSpecId);
            this.mWorkSpecDao.markWorkSpecScheduled(this.mWorkSpecId, -1L);
            this.mWorkDatabase.setTransactionSuccessful();
            return;
        }
        finally {
            this.mWorkDatabase.endTransaction();
            this.resolve(false);
        }
    }

    private void resolve(boolean bl) {
        this.mWorkDatabase.beginTransaction();
        if (!this.mWorkDatabase.workSpecDao().hasUnfinishedWork()) {
            PackageManagerHelper.setComponentEnabled((Context)this.mAppContext, RescheduleReceiver.class, (boolean)false);
        }
        if (bl) {
            this.mWorkSpecDao.setState(WorkInfo.State.ENQUEUED, new String[]{this.mWorkSpecId});
            this.mWorkSpecDao.markWorkSpecScheduled(this.mWorkSpecId, -1L);
        }
        if (this.mWorkSpec != null && this.mWorker != null && this.mWorker.isRunInForeground()) {
            this.mForegroundProcessor.stopForeground(this.mWorkSpecId);
        }
        this.mWorkDatabase.setTransactionSuccessful();
        this.mFuture.set((Object)bl);
        return;
        finally {
            this.mWorkDatabase.endTransaction();
        }
    }

    private void resolveIncorrectStatus() {
        WorkInfo.State state = this.mWorkSpecDao.getState(this.mWorkSpecId);
        if (state == WorkInfo.State.RUNNING) {
            Logger.get().debug(TAG, String.format("Status for %s is RUNNING;not doing any work and rescheduling for later execution", this.mWorkSpecId), new Throwable[0]);
            this.resolve(true);
        } else {
            Logger.get().debug(TAG, String.format("Status for %s is %s; not doing any work", this.mWorkSpecId, state), new Throwable[0]);
            this.resolve(false);
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    private void runWorker() {
        Object object;
        Object object2;
        block18: {
            block17: {
                if (this.tryCheckForInterruptionAndResolve()) {
                    return;
                }
                this.mWorkDatabase.beginTransaction();
                object2 = this.mWorkSpecDao.getWorkSpec(this.mWorkSpecId);
                this.mWorkSpec = object2;
                if (object2 == null) {
                    Logger.get().error(TAG, String.format("Didn't find WorkSpec for id %s", this.mWorkSpecId), new Throwable[0]);
                    this.resolve(false);
                    this.mWorkDatabase.setTransactionSuccessful();
                    return;
                }
                if (((WorkSpec)object2).state != WorkInfo.State.ENQUEUED) {
                    this.resolveIncorrectStatus();
                    this.mWorkDatabase.setTransactionSuccessful();
                    Logger.get().debug(TAG, String.format("%s is not in ENQUEUED state. Nothing more to do.", this.mWorkSpec.workerClassName), new Throwable[0]);
                    return;
                }
                if (this.mWorkSpec.isPeriodic() || this.mWorkSpec.isBackedOff()) {
                    long l = System.currentTimeMillis();
                    boolean bl = this.mWorkSpec.periodStartTime == 0L;
                    if (!bl && l < this.mWorkSpec.calculateNextRunTime()) {
                        Logger.get().debug(TAG, String.format("Delaying execution for %s because it is being executed before schedule.", this.mWorkSpec.workerClassName), new Throwable[0]);
                        this.resolve(true);
                        this.mWorkDatabase.setTransactionSuccessful();
                        return;
                    }
                }
                this.mWorkDatabase.setTransactionSuccessful();
                if (!this.mWorkSpec.isPeriodic()) break block17;
                object2 = this.mWorkSpec.input;
                break block18;
            }
            object = this.mConfiguration.getInputMergerFactory().createInputMergerWithDefaultFallback(this.mWorkSpec.inputMergerClassName);
            if (object == null) {
                Logger.get().error(TAG, String.format("Could not create Input Merger %s", this.mWorkSpec.inputMergerClassName), new Throwable[0]);
                this.setFailedAndResolve();
                return;
            }
            object2 = new ArrayList();
            object2.add(this.mWorkSpec.input);
            object2.addAll(this.mWorkSpecDao.getInputsFromPrerequisites(this.mWorkSpecId));
            object2 = object.merge((List)object2);
        }
        object = new WorkerParameters(UUID.fromString(this.mWorkSpecId), (Data)object2, this.mTags, this.mRuntimeExtras, this.mWorkSpec.runAttemptCount, this.mConfiguration.getExecutor(), this.mWorkTaskExecutor, this.mConfiguration.getWorkerFactory(), (ProgressUpdater)new WorkProgressUpdater(this.mWorkDatabase, this.mWorkTaskExecutor), (ForegroundUpdater)new WorkForegroundUpdater(this.mWorkDatabase, this.mForegroundProcessor, this.mWorkTaskExecutor));
        if (this.mWorker == null) {
            this.mWorker = this.mConfiguration.getWorkerFactory().createWorkerWithDefaultFallback(this.mAppContext, this.mWorkSpec.workerClassName, (WorkerParameters)object);
        }
        if ((object2 = this.mWorker) == null) {
            Logger.get().error(TAG, String.format("Could not create Worker %s", this.mWorkSpec.workerClassName), new Throwable[0]);
            this.setFailedAndResolve();
            return;
        }
        if (object2.isUsed()) {
            Logger.get().error(TAG, String.format("Received an already-used Worker %s; WorkerFactory should return new instances", this.mWorkSpec.workerClassName), new Throwable[0]);
            this.setFailedAndResolve();
            return;
        }
        this.mWorker.setUsed();
        if (!this.trySetRunning()) {
            this.resolveIncorrectStatus();
            return;
        }
        if (this.tryCheckForInterruptionAndResolve()) {
            return;
        }
        object2 = SettableFuture.create();
        object = new WorkForegroundRunnable(this.mAppContext, this.mWorkSpec, this.mWorker, object.getForegroundUpdater(), this.mWorkTaskExecutor);
        this.mWorkTaskExecutor.getMainThreadExecutor().execute((Runnable)object);
        object = object.getFuture();
        object.addListener((Runnable)new /* Unavailable Anonymous Inner Class!! */, this.mWorkTaskExecutor.getMainThreadExecutor());
        object2.addListener((Runnable)new /* Unavailable Anonymous Inner Class!! */, (Executor)this.mWorkTaskExecutor.getBackgroundExecutor());
        return;
        finally {
            this.mWorkDatabase.endTransaction();
        }
    }

    private void setSucceededAndResolve() {
        this.mWorkDatabase.beginTransaction();
        try {
            this.mWorkSpecDao.setState(WorkInfo.State.SUCCEEDED, new String[]{this.mWorkSpecId});
            Object object2 = ((ListenableWorker.Result.Success)this.mResult).getOutputData();
            this.mWorkSpecDao.setOutput(this.mWorkSpecId, object2);
            long l = System.currentTimeMillis();
            for (Object object2 : this.mDependencyDao.getDependentWorkIds(this.mWorkSpecId)) {
                if (this.mWorkSpecDao.getState((String)object2) != WorkInfo.State.BLOCKED || !this.mDependencyDao.hasCompletedAllPrerequisites((String)object2)) continue;
                Logger.get().info(TAG, String.format("Setting status to enqueued for %s", object2), new Throwable[0]);
                this.mWorkSpecDao.setState(WorkInfo.State.ENQUEUED, new String[]{object2});
                this.mWorkSpecDao.setPeriodStartTime((String)object2, l);
            }
            this.mWorkDatabase.setTransactionSuccessful();
        }
        finally {
            this.mWorkDatabase.endTransaction();
            this.resolve(false);
        }
    }

    private boolean tryCheckForInterruptionAndResolve() {
        if (!this.mInterrupted) return false;
        Logger.get().debug(TAG, String.format("Work interrupted for %s", this.mWorkDescription), new Throwable[0]);
        WorkInfo.State state = this.mWorkSpecDao.getState(this.mWorkSpecId);
        if (state == null) {
            this.resolve(false);
        } else {
            this.resolve(state.isFinished() ^ true);
        }
        return true;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    private boolean trySetRunning() {
        this.mWorkDatabase.beginTransaction();
        WorkInfo.State state = this.mWorkSpecDao.getState(this.mWorkSpecId);
        WorkInfo.State state2 = WorkInfo.State.ENQUEUED;
        boolean bl = true;
        if (state == state2) {
            this.mWorkSpecDao.setState(WorkInfo.State.RUNNING, new String[]{this.mWorkSpecId});
            this.mWorkSpecDao.incrementWorkSpecRunAttemptCount(this.mWorkSpecId);
        } else {
            bl = false;
        }
        this.mWorkDatabase.setTransactionSuccessful();
        return bl;
    }

    public ListenableFuture<Boolean> getFuture() {
        return this.mFuture;
    }

    public void interrupt() {
        boolean bl;
        this.mInterrupted = true;
        this.tryCheckForInterruptionAndResolve();
        Object object = this.mInnerFuture;
        if (object != null) {
            bl = object.isDone();
            this.mInnerFuture.cancel(true);
        } else {
            bl = false;
        }
        object = this.mWorker;
        if (object != null && !bl) {
            object.stop();
        } else {
            object = String.format("WorkSpec %s is already done. Not interrupting.", this.mWorkSpec);
            Logger.get().debug(TAG, (String)object, new Throwable[0]);
        }
    }

    void onWorkFinished() {
        Object object;
        if (!this.tryCheckForInterruptionAndResolve()) {
            this.mWorkDatabase.beginTransaction();
            try {
                object = this.mWorkSpecDao.getState(this.mWorkSpecId);
                this.mWorkDatabase.workProgressDao().delete(this.mWorkSpecId);
                if (object == null) {
                    this.resolve(false);
                } else if (object == WorkInfo.State.RUNNING) {
                    this.handleResult(this.mResult);
                } else if (!object.isFinished()) {
                    this.rescheduleAndResolve();
                }
                this.mWorkDatabase.setTransactionSuccessful();
            }
            finally {
                this.mWorkDatabase.endTransaction();
            }
        }
        if ((object = this.mSchedulers) == null) return;
        object = object.iterator();
        while (true) {
            if (!object.hasNext()) {
                Schedulers.schedule((Configuration)this.mConfiguration, (WorkDatabase)this.mWorkDatabase, this.mSchedulers);
                return;
            }
            ((Scheduler)object.next()).cancel(this.mWorkSpecId);
        }
    }

    @Override
    public void run() {
        List list;
        this.mTags = list = this.mWorkTagDao.getTagsForWorkSpecId(this.mWorkSpecId);
        this.mWorkDescription = this.createWorkDescription(list);
        this.runWorker();
    }

    void setFailedAndResolve() {
        this.mWorkDatabase.beginTransaction();
        try {
            this.iterativelyFailWorkAndDependents(this.mWorkSpecId);
            Data data = ((ListenableWorker.Result.Failure)this.mResult).getOutputData();
            this.mWorkSpecDao.setOutput(this.mWorkSpecId, data);
            this.mWorkDatabase.setTransactionSuccessful();
            return;
        }
        finally {
            this.mWorkDatabase.endTransaction();
            this.resolve(false);
        }
    }
}
