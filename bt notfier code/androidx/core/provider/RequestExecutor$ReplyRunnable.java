/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  androidx.core.util.Consumer
 */
package androidx.core.provider;

import android.os.Handler;
import androidx.core.util.Consumer;
import java.util.concurrent.Callable;

private static class RequestExecutor.ReplyRunnable<T>
implements Runnable {
    private Callable<T> mCallable;
    private Consumer<T> mConsumer;
    private Handler mHandler;

    RequestExecutor.ReplyRunnable(Handler handler, Callable<T> callable, Consumer<T> consumer) {
        this.mCallable = callable;
        this.mConsumer = consumer;
        this.mHandler = handler;
    }

    @Override
    public void run() {
        T t;
        try {
            t = this.mCallable.call();
        }
        catch (Exception exception) {
            t = null;
        }
        Consumer<T> consumer = this.mConsumer;
        this.mHandler.post((Runnable)new /* Unavailable Anonymous Inner Class!! */);
    }
}
