/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.work.Logger
 *  androidx.work.impl.constraints.ConstraintListener
 *  androidx.work.impl.constraints.trackers.ConstraintTracker$1
 *  androidx.work.impl.utils.taskexecutor.TaskExecutor
 */
package androidx.work.impl.constraints.trackers;

import android.content.Context;
import androidx.work.Logger;
import androidx.work.impl.constraints.ConstraintListener;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Executor;

public abstract class ConstraintTracker<T> {
    private static final String TAG = Logger.tagWithPrefix((String)"ConstraintTracker");
    protected final Context mAppContext;
    T mCurrentState;
    private final Set<ConstraintListener<T>> mListeners;
    private final Object mLock = new Object();
    protected final TaskExecutor mTaskExecutor;

    ConstraintTracker(Context context, TaskExecutor taskExecutor) {
        this.mListeners = new LinkedHashSet<ConstraintListener<T>>();
        this.mAppContext = context.getApplicationContext();
        this.mTaskExecutor = taskExecutor;
    }

    public void addListener(ConstraintListener<T> constraintListener) {
        Object object = this.mLock;
        synchronized (object) {
            if (!this.mListeners.add(constraintListener)) return;
            if (this.mListeners.size() == 1) {
                this.mCurrentState = this.getInitialState();
                Logger.get().debug(TAG, String.format("%s: initial state = %s", this.getClass().getSimpleName(), this.mCurrentState), new Throwable[0]);
                this.startTracking();
            }
            constraintListener.onConstraintChanged(this.mCurrentState);
            return;
        }
    }

    public abstract T getInitialState();

    public void removeListener(ConstraintListener<T> constraintListener) {
        Object object = this.mLock;
        synchronized (object) {
            if (!this.mListeners.remove(constraintListener)) return;
            if (!this.mListeners.isEmpty()) return;
            this.stopTracking();
            return;
        }
    }

    public void setState(T object) {
        Object object2 = this.mLock;
        synchronized (object2) {
            if (this.mCurrentState == object) return;
            if (this.mCurrentState != null && this.mCurrentState.equals(object)) {
                return;
            }
            this.mCurrentState = object;
            object = new Object(this.mListeners);
            Executor executor = this.mTaskExecutor.getMainThreadExecutor();
            1 var3_5 = new /* Unavailable Anonymous Inner Class!! */;
            executor.execute((Runnable)var3_5);
            return;
        }
    }

    public abstract void startTracking();

    public abstract void stopTracking();
}
