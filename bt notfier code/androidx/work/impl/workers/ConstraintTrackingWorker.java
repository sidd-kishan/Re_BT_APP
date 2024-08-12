/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  androidx.work.ListenableWorker
 *  androidx.work.ListenableWorker$Result
 *  androidx.work.Logger
 *  androidx.work.WorkerParameters
 *  androidx.work.impl.WorkDatabase
 *  androidx.work.impl.WorkManagerImpl
 *  androidx.work.impl.constraints.WorkConstraintsCallback
 *  androidx.work.impl.constraints.WorkConstraintsTracker
 *  androidx.work.impl.utils.futures.SettableFuture
 *  androidx.work.impl.utils.taskexecutor.TaskExecutor
 */
package androidx.work.impl.workers;

import android.content.Context;
import android.text.TextUtils;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.List;

public class ConstraintTrackingWorker
extends ListenableWorker
implements WorkConstraintsCallback {
    public static final String ARGUMENT_CLASS_NAME = "androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME";
    private static final String TAG = Logger.tagWithPrefix((String)"ConstraintTrkngWrkr");
    volatile boolean mAreConstraintsUnmet;
    private ListenableWorker mDelegate;
    SettableFuture<ListenableWorker.Result> mFuture;
    final Object mLock;
    private WorkerParameters mWorkerParameters;

    public ConstraintTrackingWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.mWorkerParameters = workerParameters;
        this.mLock = new Object();
        this.mAreConstraintsUnmet = false;
        this.mFuture = SettableFuture.create();
    }

    public ListenableWorker getDelegate() {
        return this.mDelegate;
    }

    public TaskExecutor getTaskExecutor() {
        return WorkManagerImpl.getInstance((Context)this.getApplicationContext()).getWorkTaskExecutor();
    }

    public WorkDatabase getWorkDatabase() {
        return WorkManagerImpl.getInstance((Context)this.getApplicationContext()).getWorkDatabase();
    }

    public boolean isRunInForeground() {
        ListenableWorker listenableWorker = this.mDelegate;
        boolean bl = listenableWorker != null && listenableWorker.isRunInForeground();
        return bl;
    }

    public void onAllConstraintsMet(List<String> list) {
    }

    public void onAllConstraintsNotMet(List<String> list) {
        Logger.get().debug(TAG, String.format("Constraints changed for %s", list), new Throwable[0]);
        Object object = this.mLock;
        synchronized (object) {
            this.mAreConstraintsUnmet = true;
            return;
        }
    }

    public void onStopped() {
        super.onStopped();
        ListenableWorker listenableWorker = this.mDelegate;
        if (listenableWorker == null) return;
        if (listenableWorker.isStopped()) return;
        this.mDelegate.stop();
    }

    void setFutureFailed() {
        this.mFuture.set((Object)ListenableWorker.Result.failure());
    }

    void setFutureRetry() {
        this.mFuture.set((Object)ListenableWorker.Result.retry());
    }

    void setupAndRunConstraintTrackingWork() {
        ListenableWorker listenableWorker;
        Object object = this.getInputData().getString(ARGUMENT_CLASS_NAME);
        if (TextUtils.isEmpty((CharSequence)object)) {
            Logger.get().error(TAG, "No worker to delegate to.", new Throwable[0]);
            this.setFutureFailed();
            return;
        }
        this.mDelegate = listenableWorker = this.getWorkerFactory().createWorkerWithDefaultFallback(this.getApplicationContext(), (String)object, this.mWorkerParameters);
        if (listenableWorker == null) {
            Logger.get().debug(TAG, "No worker to delegate to.", new Throwable[0]);
            this.setFutureFailed();
            return;
        }
        Object object2 = this.getWorkDatabase().workSpecDao().getWorkSpec(this.getId().toString());
        if (object2 == null) {
            this.setFutureFailed();
            return;
        }
        listenableWorker = new WorkConstraintsTracker(this.getApplicationContext(), this.getTaskExecutor(), (WorkConstraintsCallback)this);
        listenableWorker.replace(Collections.singletonList(object2));
        if (listenableWorker.areAllConstraintsMet(this.getId().toString())) {
            Logger.get().debug(TAG, String.format("Constraints met for delegate %s", object), new Throwable[0]);
            try {
                object2 = this.mDelegate.startWork();
                listenableWorker = new /* Unavailable Anonymous Inner Class!! */;
                object2.addListener((Runnable)listenableWorker, this.getBackgroundExecutor());
            }
            catch (Throwable throwable) {
                Logger.get().debug(TAG, String.format("Delegated worker %s threw exception in startWork.", object), new Throwable[]{throwable});
                object = this.mLock;
                synchronized (object) {
                    if (this.mAreConstraintsUnmet) {
                        Logger.get().debug(TAG, "Constraints were unmet, Retrying.", new Throwable[0]);
                        this.setFutureRetry();
                    } else {
                        this.setFutureFailed();
                    }
                }
            }
        } else {
            Logger.get().debug(TAG, String.format("Constraints not met for delegate %s. Requesting retry.", object), new Throwable[0]);
            this.setFutureRetry();
        }
    }

    public ListenableFuture<ListenableWorker.Result> startWork() {
        this.getBackgroundExecutor().execute((Runnable)new /* Unavailable Anonymous Inner Class!! */);
        return this.mFuture;
    }
}
