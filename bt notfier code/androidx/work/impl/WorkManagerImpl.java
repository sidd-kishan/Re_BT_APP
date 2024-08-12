/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.content.BroadcastReceiver$PendingResult
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 *  androidx.arch.core.util.Function
 *  androidx.core.os.BuildCompat
 *  androidx.lifecycle.LiveData
 *  androidx.work.Configuration
 *  androidx.work.Configuration$Provider
 *  androidx.work.ExistingPeriodicWorkPolicy
 *  androidx.work.ExistingWorkPolicy
 *  androidx.work.Logger
 *  androidx.work.Logger$LogcatLogger
 *  androidx.work.OneTimeWorkRequest
 *  androidx.work.Operation
 *  androidx.work.PeriodicWorkRequest
 *  androidx.work.R$bool
 *  androidx.work.WorkContinuation
 *  androidx.work.WorkInfo
 *  androidx.work.WorkManager
 *  androidx.work.WorkQuery
 *  androidx.work.WorkRequest
 *  androidx.work.WorkerParameters$RuntimeExtras
 *  androidx.work.impl.Processor
 *  androidx.work.impl.Scheduler
 *  androidx.work.impl.Schedulers
 *  androidx.work.impl.WorkContinuationImpl
 *  androidx.work.impl.WorkDatabase
 *  androidx.work.impl.background.greedy.GreedyScheduler
 *  androidx.work.impl.background.systemjob.SystemJobScheduler
 *  androidx.work.impl.foreground.SystemForegroundDispatcher
 *  androidx.work.impl.model.WorkSpec
 *  androidx.work.impl.utils.CancelWorkRunnable
 *  androidx.work.impl.utils.ForceStopRunnable
 *  androidx.work.impl.utils.LiveDataUtils
 *  androidx.work.impl.utils.PreferenceUtils
 *  androidx.work.impl.utils.PruneWorkRunnable
 *  androidx.work.impl.utils.RawQueries
 *  androidx.work.impl.utils.StartWorkRunnable
 *  androidx.work.impl.utils.StatusRunnable
 *  androidx.work.impl.utils.StopWorkRunnable
 *  androidx.work.impl.utils.futures.SettableFuture
 *  androidx.work.impl.utils.taskexecutor.TaskExecutor
 *  androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor
 *  androidx.work.multiprocess.RemoteWorkManager
 */
package androidx.work.impl;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import androidx.arch.core.util.Function;
import androidx.core.os.BuildCompat;
import androidx.lifecycle.LiveData;
import androidx.work.Configuration;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ExistingWorkPolicy;
import androidx.work.Logger;
import androidx.work.OneTimeWorkRequest;
import androidx.work.Operation;
import androidx.work.PeriodicWorkRequest;
import androidx.work.R;
import androidx.work.WorkContinuation;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.WorkQuery;
import androidx.work.WorkRequest;
import androidx.work.WorkerParameters;
import androidx.work.impl.Processor;
import androidx.work.impl.Scheduler;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkContinuationImpl;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.greedy.GreedyScheduler;
import androidx.work.impl.background.systemjob.SystemJobScheduler;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.CancelWorkRunnable;
import androidx.work.impl.utils.ForceStopRunnable;
import androidx.work.impl.utils.LiveDataUtils;
import androidx.work.impl.utils.PreferenceUtils;
import androidx.work.impl.utils.PruneWorkRunnable;
import androidx.work.impl.utils.RawQueries;
import androidx.work.impl.utils.StartWorkRunnable;
import androidx.work.impl.utils.StatusRunnable;
import androidx.work.impl.utils.StopWorkRunnable;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import androidx.work.multiprocess.RemoteWorkManager;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executor;

public class WorkManagerImpl
extends WorkManager {
    public static final int MAX_PRE_JOB_SCHEDULER_API_LEVEL = 22;
    public static final int MIN_JOB_SCHEDULER_API_LEVEL = 23;
    public static final String REMOTE_WORK_MANAGER_CLIENT = "androidx.work.multiprocess.RemoteWorkManagerClient";
    private static final String TAG = Logger.tagWithPrefix((String)"WorkManagerImpl");
    private static WorkManagerImpl sDefaultInstance;
    private static WorkManagerImpl sDelegatedInstance;
    private static final Object sLock;
    private Configuration mConfiguration;
    private Context mContext;
    private boolean mForceStopRunnableCompleted;
    private PreferenceUtils mPreferenceUtils;
    private Processor mProcessor;
    private volatile RemoteWorkManager mRemoteWorkManager;
    private BroadcastReceiver.PendingResult mRescheduleReceiverResult;
    private List<Scheduler> mSchedulers;
    private WorkDatabase mWorkDatabase;
    private TaskExecutor mWorkTaskExecutor;

    static {
        sDelegatedInstance = null;
        sDefaultInstance = null;
        sLock = new Object();
    }

    public WorkManagerImpl(Context context, Configuration configuration, TaskExecutor taskExecutor) {
        this(context, configuration, taskExecutor, context.getResources().getBoolean(R.bool.workmanager_test_configuration));
    }

    public WorkManagerImpl(Context context, Configuration configuration, TaskExecutor taskExecutor, WorkDatabase workDatabase) {
        Object object = context.getApplicationContext();
        Logger.setLogger((Logger)new Logger.LogcatLogger(configuration.getMinimumLoggingLevel()));
        object = this.createSchedulers((Context)object, configuration, taskExecutor);
        this.internalInit(context, configuration, taskExecutor, workDatabase, (List<Scheduler>)object, new Processor(context, configuration, taskExecutor, workDatabase, (List)object));
    }

    public WorkManagerImpl(Context context, Configuration configuration, TaskExecutor taskExecutor, WorkDatabase workDatabase, List<Scheduler> list, Processor processor) {
        this.internalInit(context, configuration, taskExecutor, workDatabase, list, processor);
    }

    public WorkManagerImpl(Context context, Configuration configuration, TaskExecutor taskExecutor, boolean bl) {
        this(context, configuration, taskExecutor, WorkDatabase.create((Context)context.getApplicationContext(), (Executor)taskExecutor.getBackgroundExecutor(), (boolean)bl));
    }

    @Deprecated
    public static WorkManagerImpl getInstance() {
        Object object = sLock;
        synchronized (object) {
            if (sDelegatedInstance != null) {
                WorkManagerImpl workManagerImpl = sDelegatedInstance;
                return workManagerImpl;
            }
            WorkManagerImpl workManagerImpl = sDefaultInstance;
            return workManagerImpl;
        }
    }

    public static WorkManagerImpl getInstance(Context object) {
        Object object2 = sLock;
        synchronized (object2) {
            WorkManagerImpl workManagerImpl;
            WorkManagerImpl workManagerImpl2 = workManagerImpl = WorkManagerImpl.getInstance();
            if (workManagerImpl != null) return workManagerImpl2;
            if ((object = object.getApplicationContext()) instanceof Configuration.Provider) {
                WorkManagerImpl.initialize(object, ((Configuration.Provider)object).getWorkManagerConfiguration());
                workManagerImpl2 = WorkManagerImpl.getInstance(object);
                return workManagerImpl2;
            }
            object = new IllegalStateException("WorkManager is not initialized properly.  You have explicitly disabled WorkManagerInitializer in your manifest, have not manually called WorkManager#initialize at this point, and your Application does not implement Configuration.Provider.");
            throw object;
        }
    }

    public static void initialize(Context object, Configuration configuration) {
        Object object2 = sLock;
        synchronized (object2) {
            if (sDelegatedInstance != null && sDefaultInstance != null) {
                object = new IllegalStateException("WorkManager is already initialized.  Did you try to initialize it manually without disabling WorkManagerInitializer? See WorkManager#initialize(Context, Configuration) or the class level Javadoc for more information.");
                throw object;
            }
            if (sDelegatedInstance != null) return;
            object = object.getApplicationContext();
            if (sDefaultInstance == null) {
                WorkManagerImpl workManagerImpl;
                WorkManagerTaskExecutor workManagerTaskExecutor = new WorkManagerTaskExecutor(configuration.getTaskExecutor());
                sDefaultInstance = workManagerImpl = new WorkManagerImpl((Context)object, configuration, (TaskExecutor)workManagerTaskExecutor);
            }
            sDelegatedInstance = sDefaultInstance;
            return;
        }
    }

    private void internalInit(Context context, Configuration configuration, TaskExecutor taskExecutor, WorkDatabase workDatabase, List<Scheduler> list, Processor processor) {
        this.mContext = context = context.getApplicationContext();
        this.mConfiguration = configuration;
        this.mWorkTaskExecutor = taskExecutor;
        this.mWorkDatabase = workDatabase;
        this.mSchedulers = list;
        this.mProcessor = processor;
        this.mPreferenceUtils = new PreferenceUtils(workDatabase);
        this.mForceStopRunnableCompleted = false;
        if (Build.VERSION.SDK_INT >= 24) {
            if (context.isDeviceProtectedStorage()) throw new IllegalStateException("Cannot initialize WorkManager in direct boot mode");
        }
        this.mWorkTaskExecutor.executeOnBackgroundThread((Runnable)new ForceStopRunnable(context, this));
    }

    public static void setDelegate(WorkManagerImpl workManagerImpl) {
        Object object = sLock;
        synchronized (object) {
            sDelegatedInstance = workManagerImpl;
            return;
        }
    }

    private void tryInitializeMultiProcessSupport() {
        try {
            this.mRemoteWorkManager = (RemoteWorkManager)Class.forName(REMOTE_WORK_MANAGER_CLIENT).getConstructor(Context.class, WorkManagerImpl.class).newInstance(new Object[]{this.mContext, this});
        }
        catch (Throwable throwable) {
            Logger.get().debug(TAG, "Unable to initialize multi-process support", new Throwable[]{throwable});
        }
    }

    public WorkContinuation beginUniqueWork(String string, ExistingWorkPolicy existingWorkPolicy, List<OneTimeWorkRequest> list) {
        if (list.isEmpty()) throw new IllegalArgumentException("beginUniqueWork needs at least one OneTimeWorkRequest.");
        return new WorkContinuationImpl(this, string, existingWorkPolicy, list);
    }

    public WorkContinuation beginWith(List<OneTimeWorkRequest> list) {
        if (list.isEmpty()) throw new IllegalArgumentException("beginWith needs at least one OneTimeWorkRequest.");
        return new WorkContinuationImpl(this, list);
    }

    public Operation cancelAllWork() {
        CancelWorkRunnable cancelWorkRunnable = CancelWorkRunnable.forAll((WorkManagerImpl)this);
        this.mWorkTaskExecutor.executeOnBackgroundThread((Runnable)cancelWorkRunnable);
        return cancelWorkRunnable.getOperation();
    }

    public Operation cancelAllWorkByTag(String string) {
        string = CancelWorkRunnable.forTag((String)string, (WorkManagerImpl)this);
        this.mWorkTaskExecutor.executeOnBackgroundThread((Runnable)((Object)string));
        return string.getOperation();
    }

    public Operation cancelUniqueWork(String string) {
        string = CancelWorkRunnable.forName((String)string, (WorkManagerImpl)this, (boolean)true);
        this.mWorkTaskExecutor.executeOnBackgroundThread((Runnable)((Object)string));
        return string.getOperation();
    }

    public Operation cancelWorkById(UUID uUID) {
        uUID = CancelWorkRunnable.forId((UUID)uUID, (WorkManagerImpl)this);
        this.mWorkTaskExecutor.executeOnBackgroundThread((Runnable)((Object)uUID));
        return uUID.getOperation();
    }

    public PendingIntent createCancelPendingIntent(UUID uUID) {
        uUID = SystemForegroundDispatcher.createCancelWorkIntent((Context)this.mContext, (String)uUID.toString());
        int n = BuildCompat.isAtLeastS() ? 0xA000000 : 0x8000000;
        return PendingIntent.getService((Context)this.mContext, (int)0, (Intent)uUID, (int)n);
    }

    public List<Scheduler> createSchedulers(Context context, Configuration configuration, TaskExecutor taskExecutor) {
        return Arrays.asList(Schedulers.createBestAvailableBackgroundScheduler((Context)context, (WorkManagerImpl)this), new GreedyScheduler(context, configuration, taskExecutor, this));
    }

    public WorkContinuationImpl createWorkContinuationForUniquePeriodicWork(String string, ExistingPeriodicWorkPolicy existingPeriodicWorkPolicy, PeriodicWorkRequest periodicWorkRequest) {
        existingPeriodicWorkPolicy = existingPeriodicWorkPolicy == ExistingPeriodicWorkPolicy.KEEP ? ExistingWorkPolicy.KEEP : ExistingWorkPolicy.REPLACE;
        return new WorkContinuationImpl(this, string, (ExistingWorkPolicy)existingPeriodicWorkPolicy, Collections.singletonList(periodicWorkRequest));
    }

    public Operation enqueue(List<? extends WorkRequest> list) {
        if (list.isEmpty()) throw new IllegalArgumentException("enqueue needs at least one WorkRequest.");
        return new WorkContinuationImpl(this, list).enqueue();
    }

    public Operation enqueueUniquePeriodicWork(String string, ExistingPeriodicWorkPolicy existingPeriodicWorkPolicy, PeriodicWorkRequest periodicWorkRequest) {
        return this.createWorkContinuationForUniquePeriodicWork(string, existingPeriodicWorkPolicy, periodicWorkRequest).enqueue();
    }

    public Operation enqueueUniqueWork(String string, ExistingWorkPolicy existingWorkPolicy, List<OneTimeWorkRequest> list) {
        return new WorkContinuationImpl(this, string, existingWorkPolicy, list).enqueue();
    }

    public Context getApplicationContext() {
        return this.mContext;
    }

    public Configuration getConfiguration() {
        return this.mConfiguration;
    }

    public ListenableFuture<Long> getLastCancelAllTimeMillis() {
        SettableFuture settableFuture = SettableFuture.create();
        PreferenceUtils preferenceUtils = this.mPreferenceUtils;
        this.mWorkTaskExecutor.executeOnBackgroundThread((Runnable)new /* Unavailable Anonymous Inner Class!! */);
        return settableFuture;
    }

    public LiveData<Long> getLastCancelAllTimeMillisLiveData() {
        return this.mPreferenceUtils.getLastCancelAllTimeMillisLiveData();
    }

    public PreferenceUtils getPreferenceUtils() {
        return this.mPreferenceUtils;
    }

    public Processor getProcessor() {
        return this.mProcessor;
    }

    public RemoteWorkManager getRemoteWorkManager() {
        if (this.mRemoteWorkManager != null) return this.mRemoteWorkManager;
        Object object = sLock;
        synchronized (object) {
            if (this.mRemoteWorkManager != null) return this.mRemoteWorkManager;
            this.tryInitializeMultiProcessSupport();
            if (this.mRemoteWorkManager != null) return this.mRemoteWorkManager;
            if (TextUtils.isEmpty((CharSequence)this.mConfiguration.getDefaultProcessName())) return this.mRemoteWorkManager;
            IllegalStateException illegalStateException = new IllegalStateException("Invalid multiprocess configuration. Define an `implementation` dependency on :work:work-multiprocess library");
            throw illegalStateException;
        }
    }

    public List<Scheduler> getSchedulers() {
        return this.mSchedulers;
    }

    public WorkDatabase getWorkDatabase() {
        return this.mWorkDatabase;
    }

    public ListenableFuture<WorkInfo> getWorkInfoById(UUID uUID) {
        uUID = StatusRunnable.forUUID((WorkManagerImpl)this, (UUID)uUID);
        this.mWorkTaskExecutor.getBackgroundExecutor().execute((Runnable)((Object)uUID));
        return uUID.getFuture();
    }

    public LiveData<WorkInfo> getWorkInfoByIdLiveData(UUID uUID) {
        return LiveDataUtils.dedupedMappedLiveDataFor((LiveData)this.mWorkDatabase.workSpecDao().getWorkStatusPojoLiveDataForIds(Collections.singletonList(uUID.toString())), (Function)new /* Unavailable Anonymous Inner Class!! */, (TaskExecutor)this.mWorkTaskExecutor);
    }

    public ListenableFuture<List<WorkInfo>> getWorkInfos(WorkQuery workQuery) {
        workQuery = StatusRunnable.forWorkQuerySpec((WorkManagerImpl)this, (WorkQuery)workQuery);
        this.mWorkTaskExecutor.getBackgroundExecutor().execute((Runnable)workQuery);
        return workQuery.getFuture();
    }

    LiveData<List<WorkInfo>> getWorkInfosById(List<String> list) {
        return LiveDataUtils.dedupedMappedLiveDataFor((LiveData)this.mWorkDatabase.workSpecDao().getWorkStatusPojoLiveDataForIds(list), (Function)WorkSpec.WORK_INFO_MAPPER, (TaskExecutor)this.mWorkTaskExecutor);
    }

    public ListenableFuture<List<WorkInfo>> getWorkInfosByTag(String string) {
        string = StatusRunnable.forTag((WorkManagerImpl)this, (String)string);
        this.mWorkTaskExecutor.getBackgroundExecutor().execute((Runnable)((Object)string));
        return string.getFuture();
    }

    public LiveData<List<WorkInfo>> getWorkInfosByTagLiveData(String string) {
        return LiveDataUtils.dedupedMappedLiveDataFor((LiveData)this.mWorkDatabase.workSpecDao().getWorkStatusPojoLiveDataForTag(string), (Function)WorkSpec.WORK_INFO_MAPPER, (TaskExecutor)this.mWorkTaskExecutor);
    }

    public ListenableFuture<List<WorkInfo>> getWorkInfosForUniqueWork(String string) {
        string = StatusRunnable.forUniqueWork((WorkManagerImpl)this, (String)string);
        this.mWorkTaskExecutor.getBackgroundExecutor().execute((Runnable)((Object)string));
        return string.getFuture();
    }

    public LiveData<List<WorkInfo>> getWorkInfosForUniqueWorkLiveData(String string) {
        return LiveDataUtils.dedupedMappedLiveDataFor((LiveData)this.mWorkDatabase.workSpecDao().getWorkStatusPojoLiveDataForName(string), (Function)WorkSpec.WORK_INFO_MAPPER, (TaskExecutor)this.mWorkTaskExecutor);
    }

    public LiveData<List<WorkInfo>> getWorkInfosLiveData(WorkQuery workQuery) {
        return LiveDataUtils.dedupedMappedLiveDataFor((LiveData)this.mWorkDatabase.rawWorkInfoDao().getWorkInfoPojosLiveData(RawQueries.workQueryToRawQuery((WorkQuery)workQuery)), (Function)WorkSpec.WORK_INFO_MAPPER, (TaskExecutor)this.mWorkTaskExecutor);
    }

    public TaskExecutor getWorkTaskExecutor() {
        return this.mWorkTaskExecutor;
    }

    public void onForceStopRunnableCompleted() {
        Object object = sLock;
        synchronized (object) {
            this.mForceStopRunnableCompleted = true;
            if (this.mRescheduleReceiverResult == null) return;
            this.mRescheduleReceiverResult.finish();
            this.mRescheduleReceiverResult = null;
            return;
        }
    }

    public Operation pruneWork() {
        PruneWorkRunnable pruneWorkRunnable = new PruneWorkRunnable(this);
        this.mWorkTaskExecutor.executeOnBackgroundThread((Runnable)pruneWorkRunnable);
        return pruneWorkRunnable.getOperation();
    }

    public void rescheduleEligibleWork() {
        if (Build.VERSION.SDK_INT >= 23) {
            SystemJobScheduler.cancelAll((Context)this.getApplicationContext());
        }
        this.getWorkDatabase().workSpecDao().resetScheduledState();
        Schedulers.schedule((Configuration)this.getConfiguration(), (WorkDatabase)this.getWorkDatabase(), this.getSchedulers());
    }

    public void setReschedulePendingResult(BroadcastReceiver.PendingResult pendingResult) {
        Object object = sLock;
        synchronized (object) {
            this.mRescheduleReceiverResult = pendingResult;
            if (!this.mForceStopRunnableCompleted) return;
            pendingResult.finish();
            this.mRescheduleReceiverResult = null;
            return;
        }
    }

    public void startWork(String string) {
        this.startWork(string, null);
    }

    public void startWork(String string, WorkerParameters.RuntimeExtras runtimeExtras) {
        this.mWorkTaskExecutor.executeOnBackgroundThread((Runnable)new StartWorkRunnable(this, string, runtimeExtras));
    }

    public void stopForegroundWork(String string) {
        this.mWorkTaskExecutor.executeOnBackgroundThread((Runnable)new StopWorkRunnable(this, string, true));
    }

    public void stopWork(String string) {
        this.mWorkTaskExecutor.executeOnBackgroundThread((Runnable)new StopWorkRunnable(this, string, false));
    }
}
