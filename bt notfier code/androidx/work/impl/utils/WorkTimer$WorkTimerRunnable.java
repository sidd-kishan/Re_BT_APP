/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.Logger
 *  androidx.work.impl.utils.WorkTimer
 *  androidx.work.impl.utils.WorkTimer$TimeLimitExceededListener
 */
package androidx.work.impl.utils;

import androidx.work.Logger;
import androidx.work.impl.utils.WorkTimer;

public static class WorkTimer.WorkTimerRunnable
implements Runnable {
    static final String TAG = "WrkTimerRunnable";
    private final String mWorkSpecId;
    private final WorkTimer mWorkTimer;

    WorkTimer.WorkTimerRunnable(WorkTimer workTimer, String string) {
        this.mWorkTimer = workTimer;
        this.mWorkSpecId = string;
    }

    @Override
    public void run() {
        Object object = this.mWorkTimer.mLock;
        synchronized (object) {
            if ((WorkTimer.WorkTimerRunnable)this.mWorkTimer.mTimerMap.remove(this.mWorkSpecId) != null) {
                WorkTimer.TimeLimitExceededListener timeLimitExceededListener = (WorkTimer.TimeLimitExceededListener)this.mWorkTimer.mListeners.remove(this.mWorkSpecId);
                if (timeLimitExceededListener == null) return;
                timeLimitExceededListener.onTimeLimitExceeded(this.mWorkSpecId);
            } else {
                Logger.get().debug(TAG, String.format("Timer with %s is already marked as complete.", this.mWorkSpecId), new Throwable[0]);
            }
            return;
        }
    }
}
