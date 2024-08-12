/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.Logger
 *  androidx.work.impl.utils.WorkTimer$TimeLimitExceededListener
 *  androidx.work.impl.utils.WorkTimer$WorkTimerRunnable
 */
package androidx.work.impl.utils;

import androidx.work.Logger;
import androidx.work.impl.utils.WorkTimer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class WorkTimer {
    private static final String TAG = Logger.tagWithPrefix((String)"WorkTimer");
    private final ThreadFactory mBackgroundThreadFactory = new /* Unavailable Anonymous Inner Class!! */;
    private final ScheduledExecutorService mExecutorService;
    final Map<String, TimeLimitExceededListener> mListeners;
    final Object mLock;
    final Map<String, WorkTimerRunnable> mTimerMap = new HashMap<String, WorkTimerRunnable>();

    public WorkTimer() {
        this.mListeners = new HashMap<String, TimeLimitExceededListener>();
        this.mLock = new Object();
        this.mExecutorService = Executors.newSingleThreadScheduledExecutor(this.mBackgroundThreadFactory);
    }

    public ScheduledExecutorService getExecutorService() {
        return this.mExecutorService;
    }

    public Map<String, TimeLimitExceededListener> getListeners() {
        synchronized (this) {
            Map<String, TimeLimitExceededListener> map = this.mListeners;
            return map;
        }
    }

    public Map<String, WorkTimerRunnable> getTimerMap() {
        synchronized (this) {
            Map<String, WorkTimerRunnable> map = this.mTimerMap;
            return map;
        }
    }

    public void onDestroy() {
        if (this.mExecutorService.isShutdown()) return;
        this.mExecutorService.shutdownNow();
    }

    public void startTimer(String string, long l, TimeLimitExceededListener timeLimitExceededListener) {
        Object object = this.mLock;
        synchronized (object) {
            Logger.get().debug(TAG, String.format("Starting timer for %s", string), new Throwable[0]);
            this.stopTimer(string);
            WorkTimerRunnable workTimerRunnable = new WorkTimerRunnable(this, string);
            this.mTimerMap.put(string, workTimerRunnable);
            this.mListeners.put(string, timeLimitExceededListener);
            this.mExecutorService.schedule((Runnable)workTimerRunnable, l, TimeUnit.MILLISECONDS);
            return;
        }
    }

    public void stopTimer(String string) {
        Object object = this.mLock;
        synchronized (object) {
            if (this.mTimerMap.remove(string) == null) return;
            Logger.get().debug(TAG, String.format("Stopping timer for %s", string), new Throwable[0]);
            this.mListeners.remove(string);
            return;
        }
    }
}
