/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.luck.picture.lib.thread.PictureThreadUtils
 *  com.luck.picture.lib.thread.PictureThreadUtils$Task$2
 *  com.luck.picture.lib.thread.PictureThreadUtils$Task$3
 *  com.luck.picture.lib.thread.PictureThreadUtils$Task$OnTimeoutListener
 */
package com.luck.picture.lib.thread;

import android.util.Log;
import com.luck.picture.lib.thread.PictureThreadUtils;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/*
 * Exception performing whole class analysis ignored.
 */
public static abstract class PictureThreadUtils.Task<T>
implements Runnable {
    private static final int CANCELLED = 4;
    private static final int COMPLETING = 3;
    private static final int EXCEPTIONAL = 2;
    private static final int INTERRUPTED = 5;
    private static final int NEW = 0;
    private static final int RUNNING = 1;
    private static final int TIMEOUT = 6;
    private Executor deliver;
    private volatile boolean isSchedule;
    private OnTimeoutListener mTimeoutListener;
    private long mTimeoutMillis;
    private Timer mTimer;
    private volatile Thread runner;
    private final AtomicInteger state = new AtomicInteger(0);

    static /* synthetic */ void access$000(PictureThreadUtils.Task task, boolean bl) {
        task.setSchedule(bl);
    }

    static /* synthetic */ OnTimeoutListener access$400(PictureThreadUtils.Task task) {
        return task.mTimeoutListener;
    }

    static /* synthetic */ void access$500(PictureThreadUtils.Task task) {
        task.timeout();
    }

    private Executor getDeliver() {
        Executor executor;
        Executor executor2 = executor = this.deliver;
        if (executor != null) return executor2;
        executor2 = PictureThreadUtils.access$600();
        return executor2;
    }

    private void setSchedule(boolean bl) {
        this.isSchedule = bl;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    private void timeout() {
        AtomicInteger atomicInteger = this.state;
        synchronized (atomicInteger) {
            if (this.state.get() > 1) {
                return;
            }
            this.state.set(6);
        }
        if (this.runner == null) return;
        this.runner.interrupt();
    }

    public void cancel() {
        this.cancel(true);
    }

    /*
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    public void cancel(boolean bl) {
        AtomicInteger atomicInteger = this.state;
        // MONITORENTER : atomicInteger
        if (this.state.get() > 1) {
            // MONITOREXIT : atomicInteger
            return;
        }
        this.state.set(4);
        // MONITOREXIT : atomicInteger
        if (bl && this.runner != null) {
            this.runner.interrupt();
        }
        this.getDeliver().execute((Runnable)new /* Unavailable Anonymous Inner Class!! */);
    }

    public abstract T doInBackground() throws Throwable;

    public boolean isCanceled() {
        boolean bl = this.state.get() >= 4;
        return bl;
    }

    public boolean isDone() {
        int n = this.state.get();
        boolean bl = true;
        if (n > 1) return bl;
        bl = false;
        return bl;
    }

    public abstract void onCancel();

    protected void onDone() {
        PictureThreadUtils.access$700().remove(this);
        Timer timer = this.mTimer;
        if (timer == null) return;
        timer.cancel();
        this.mTimer = null;
        this.mTimeoutListener = null;
    }

    public abstract void onFail(Throwable var1);

    public abstract void onSuccess(T var1);

    @Override
    public void run() {
        Object object;
        if (this.isSchedule) {
            if (this.runner == null) {
                if (!this.state.compareAndSet(0, 1)) {
                    return;
                }
                this.runner = Thread.currentThread();
                if (this.mTimeoutListener != null) {
                    Log.w((String)"ThreadUtils", (String)"Scheduled task doesn't support timeout.");
                }
            } else if (this.state.get() != 1) {
                return;
            }
        } else {
            if (!this.state.compareAndSet(0, 1)) {
                return;
            }
            this.runner = Thread.currentThread();
            if (this.mTimeoutListener != null) {
                object = new Timer();
                this.mTimer = object;
                ((Timer)object).schedule((TimerTask)new /* Unavailable Anonymous Inner Class!! */, this.mTimeoutMillis);
            }
        }
        try {
            object = this.doInBackground();
            if (this.isSchedule) {
                if (this.state.get() != 1) {
                    return;
                }
                Executor executor = this.getDeliver();
                2 var3_6 = new /* Unavailable Anonymous Inner Class!! */;
                executor.execute((Runnable)var3_6);
            } else {
                if (!this.state.compareAndSet(1, 3)) {
                    return;
                }
                Executor executor = this.getDeliver();
                3 var3_7 = new /* Unavailable Anonymous Inner Class!! */;
                executor.execute((Runnable)var3_7);
            }
        }
        catch (Throwable throwable) {
            if (!this.state.compareAndSet(1, 2)) {
                return;
            }
            this.getDeliver().execute((Runnable)new /* Unavailable Anonymous Inner Class!! */);
        }
        catch (InterruptedException interruptedException) {
            this.state.compareAndSet(4, 5);
        }
    }

    public PictureThreadUtils.Task<T> setDeliver(Executor executor) {
        this.deliver = executor;
        return this;
    }

    public PictureThreadUtils.Task<T> setTimeout(long l, OnTimeoutListener onTimeoutListener) {
        this.mTimeoutMillis = l;
        this.mTimeoutListener = onTimeoutListener;
        return this;
    }
}
