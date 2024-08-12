/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 *  androidx.work.Configuration
 *  androidx.work.Logger
 *  androidx.work.WorkInfo$State
 *  androidx.work.impl.ExecutionListener
 *  androidx.work.impl.Scheduler
 *  androidx.work.impl.WorkManagerImpl
 *  androidx.work.impl.background.greedy.DelayedWorkTracker
 *  androidx.work.impl.constraints.WorkConstraintsCallback
 *  androidx.work.impl.constraints.WorkConstraintsTracker
 *  androidx.work.impl.model.WorkSpec
 *  androidx.work.impl.utils.ProcessUtils
 *  androidx.work.impl.utils.taskexecutor.TaskExecutor
 */
package androidx.work.impl.background.greedy;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.Configuration;
import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.Scheduler;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.background.greedy.DelayedWorkTracker;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.ProcessUtils;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class GreedyScheduler
implements Scheduler,
WorkConstraintsCallback,
ExecutionListener {
    private static final String TAG = Logger.tagWithPrefix((String)"GreedyScheduler");
    private final Set<WorkSpec> mConstrainedWorkSpecs = new HashSet<WorkSpec>();
    private final Context mContext;
    private DelayedWorkTracker mDelayedWorkTracker;
    Boolean mInDefaultProcess;
    private final Object mLock;
    private boolean mRegisteredExecutionListener;
    private final WorkConstraintsTracker mWorkConstraintsTracker;
    private final WorkManagerImpl mWorkManagerImpl;

    public GreedyScheduler(Context context, Configuration configuration, TaskExecutor taskExecutor, WorkManagerImpl workManagerImpl) {
        this.mContext = context;
        this.mWorkManagerImpl = workManagerImpl;
        this.mWorkConstraintsTracker = new WorkConstraintsTracker(context, taskExecutor, (WorkConstraintsCallback)this);
        this.mDelayedWorkTracker = new DelayedWorkTracker(this, configuration.getRunnableScheduler());
        this.mLock = new Object();
    }

    public GreedyScheduler(Context context, WorkManagerImpl workManagerImpl, WorkConstraintsTracker workConstraintsTracker) {
        this.mContext = context;
        this.mWorkManagerImpl = workManagerImpl;
        this.mWorkConstraintsTracker = workConstraintsTracker;
        this.mLock = new Object();
    }

    private void checkDefaultProcess() {
        Configuration configuration = this.mWorkManagerImpl.getConfiguration();
        this.mInDefaultProcess = ProcessUtils.isDefaultProcess((Context)this.mContext, (Configuration)configuration);
    }

    private void registerExecutionListenerIfNeeded() {
        if (this.mRegisteredExecutionListener) return;
        this.mWorkManagerImpl.getProcessor().addExecutionListener((ExecutionListener)this);
        this.mRegisteredExecutionListener = true;
    }

    private void removeConstraintTrackingFor(String string) {
        Object object = this.mLock;
        synchronized (object) {
            try {
                WorkSpec workSpec;
                Iterator<WorkSpec> iterator = this.mConstrainedWorkSpecs.iterator();
                do {
                    if (!iterator.hasNext()) return;
                    workSpec = iterator.next();
                } while (!workSpec.id.equals(string));
                Logger.get().debug(TAG, String.format("Stopping tracking for %s", string), new Throwable[0]);
                this.mConstrainedWorkSpecs.remove(workSpec);
                this.mWorkConstraintsTracker.replace(this.mConstrainedWorkSpecs);
                return;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    public void cancel(String string) {
        if (this.mInDefaultProcess == null) {
            this.checkDefaultProcess();
        }
        if (!this.mInDefaultProcess.booleanValue()) {
            Logger.get().info(TAG, "Ignoring schedule request in non-main process", new Throwable[0]);
            return;
        }
        this.registerExecutionListenerIfNeeded();
        Logger.get().debug(TAG, String.format("Cancelling work ID %s", string), new Throwable[0]);
        DelayedWorkTracker delayedWorkTracker = this.mDelayedWorkTracker;
        if (delayedWorkTracker != null) {
            delayedWorkTracker.unschedule(string);
        }
        this.mWorkManagerImpl.stopWork(string);
    }

    public boolean hasLimitedSchedulingSlots() {
        return false;
    }

    public void onAllConstraintsMet(List<String> object) {
        Iterator<String> iterator = object.iterator();
        while (iterator.hasNext()) {
            object = iterator.next();
            Logger.get().debug(TAG, String.format("Constraints met: Scheduling work ID %s", object), new Throwable[0]);
            this.mWorkManagerImpl.startWork((String)object);
        }
    }

    public void onAllConstraintsNotMet(List<String> object) {
        Iterator<String> iterator = object.iterator();
        while (iterator.hasNext()) {
            object = iterator.next();
            Logger.get().debug(TAG, String.format("Constraints not met: Cancelling work ID %s", object), new Throwable[0]);
            this.mWorkManagerImpl.stopWork((String)object);
        }
    }

    public void onExecuted(String string, boolean bl) {
        this.removeConstraintTrackingFor(string);
    }

    public void schedule(WorkSpec ... object) {
        if (this.mInDefaultProcess == null) {
            this.checkDefaultProcess();
        }
        if (!this.mInDefaultProcess.booleanValue()) {
            Logger.get().info(TAG, "Ignoring schedule request in a secondary process", new Throwable[0]);
            return;
        }
        this.registerExecutionListenerIfNeeded();
        HashSet<Object> throwable = new HashSet<Object>();
        HashSet<String> hashSet = new HashSet<String>();
        for (Object object2 : object) {
            long l = object2.calculateNextRunTime();
            long l2 = System.currentTimeMillis();
            if (((WorkSpec)object2).state != WorkInfo.State.ENQUEUED) continue;
            if (l2 < l) {
                DelayedWorkTracker delayedWorkTracker = this.mDelayedWorkTracker;
                if (delayedWorkTracker == null) continue;
                delayedWorkTracker.schedule((WorkSpec)object2);
                continue;
            }
            if (object2.hasConstraints()) {
                if (Build.VERSION.SDK_INT >= 23 && ((WorkSpec)object2).constraints.requiresDeviceIdle()) {
                    Logger.get().debug(TAG, String.format("Ignoring WorkSpec %s, Requires device idle.", object2), new Throwable[0]);
                    continue;
                }
                if (Build.VERSION.SDK_INT >= 24 && ((WorkSpec)object2).constraints.hasContentUriTriggers()) {
                    Logger.get().debug(TAG, String.format("Ignoring WorkSpec %s, Requires ContentUri triggers.", object2), new Throwable[0]);
                    continue;
                }
                throwable.add(object2);
                hashSet.add(((WorkSpec)object2).id);
                continue;
            }
            Logger.get().debug(TAG, String.format("Starting work for %s", ((WorkSpec)object2).id), new Throwable[0]);
            this.mWorkManagerImpl.startWork(((WorkSpec)object2).id);
        }
        Object object3 = this.mLock;
        synchronized (object3) {
            try {
                if (throwable.isEmpty()) return;
                Logger.get().debug(TAG, String.format("Starting tracking for [%s]", TextUtils.join((CharSequence)",", hashSet)), new Throwable[0]);
                this.mConstrainedWorkSpecs.addAll(throwable);
                this.mWorkConstraintsTracker.replace(this.mConstrainedWorkSpecs);
                return;
            }
            catch (Throwable throwable2) {
                throw throwable2;
            }
        }
    }

    public void setDelayedWorkTracker(DelayedWorkTracker delayedWorkTracker) {
        this.mDelayedWorkTracker = delayedWorkTracker;
    }
}
