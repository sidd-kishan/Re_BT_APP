/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.HandlerThread
 *  androidx.core.provider.SelfDestructiveThread$ReplyCallback
 */
package androidx.core.provider;

import android.os.Handler;
import android.os.HandlerThread;
import androidx.core.provider.SelfDestructiveThread;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;

@Deprecated
public class SelfDestructiveThread {
    private static final int MSG_DESTRUCTION = 0;
    private static final int MSG_INVOKE_RUNNABLE = 1;
    private Handler.Callback mCallback;
    private final int mDestructAfterMillisec;
    private int mGeneration;
    private Handler mHandler;
    private final Object mLock = new Object();
    private final int mPriority;
    private HandlerThread mThread;
    private final String mThreadName;

    public SelfDestructiveThread(String string, int n, int n2) {
        this.mCallback = new /* Unavailable Anonymous Inner Class!! */;
        this.mThreadName = string;
        this.mPriority = n;
        this.mDestructAfterMillisec = n2;
        this.mGeneration = 0;
    }

    private void post(Runnable runnable) {
        Object object = this.mLock;
        synchronized (object) {
            if (this.mThread == null) {
                HandlerThread handlerThread;
                this.mThread = handlerThread = new HandlerThread(this.mThreadName, this.mPriority);
                handlerThread.start();
                handlerThread = new Handler(this.mThread.getLooper(), this.mCallback);
                this.mHandler = handlerThread;
                ++this.mGeneration;
            }
            this.mHandler.removeMessages(0);
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, (Object)runnable));
            return;
        }
    }

    public int getGeneration() {
        Object object = this.mLock;
        synchronized (object) {
            int n = this.mGeneration;
            return n;
        }
    }

    public boolean isRunning() {
        Object object = this.mLock;
        synchronized (object) {
            boolean bl = this.mThread != null;
            return bl;
        }
    }

    void onDestruction() {
        Object object = this.mLock;
        synchronized (object) {
            if (this.mHandler.hasMessages(1)) {
                return;
            }
            this.mThread.quit();
            this.mThread = null;
            this.mHandler = null;
            return;
        }
    }

    void onInvokeRunnable(Runnable object) {
        object.run();
        object = this.mLock;
        synchronized (object) {
            this.mHandler.removeMessages(0);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0), (long)this.mDestructAfterMillisec);
            return;
        }
    }

    public <T> void postAndReply(Callable<T> callable, ReplyCallback<T> replyCallback) {
        this.post((Runnable)new /* Unavailable Anonymous Inner Class!! */);
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    public <T> T postAndWait(Callable<T> var1_1, int var2_4) throws InterruptedException {
        block8: {
            var7_5 = new ReentrantLock();
            var9_6 = var7_5.newCondition();
            var10_7 = new AtomicReference<V>();
            var8_8 = new AtomicBoolean(true);
            this.post((Runnable)new /* Unavailable Anonymous Inner Class!! */);
            var7_5.lock();
            if (var8_8.get()) break block8;
            var1_1 = var10_7.get();
            var7_5.unlock();
            return (T)var1_1;
        }
        try {
            var3_9 = TimeUnit.MILLISECONDS.toNanos(var2_4);
            try {
                block6: while (true) {
                    var3_9 = var5_10 = var9_6.awaitNanos(var3_9);
lbl18:
                    // 2 sources

                    while (true) {
                        if (var8_8.get()) continue block6;
                        var1_1 = var10_7.get();
                        var7_5.unlock();
                        return (T)var1_1;
                        if (var3_9 > 0L) continue block6;
                        break;
                    }
                    break;
                }
            }
            catch (InterruptedException var1_3) {
                ** continue;
            }
            {
                var1_1 = new InterruptedException("timeout");
                throw var1_1;
            }
        }
        catch (Throwable var1_2) {
            var7_5.unlock();
            throw var1_2;
        }
    }
}
