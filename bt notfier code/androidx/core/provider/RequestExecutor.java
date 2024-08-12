/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  androidx.core.provider.CalleeHandler
 *  androidx.core.provider.RequestExecutor$DefaultThreadFactory
 *  androidx.core.provider.RequestExecutor$HandlerExecutor
 *  androidx.core.provider.RequestExecutor$ReplyRunnable
 *  androidx.core.util.Consumer
 */
package androidx.core.provider;

import android.os.Handler;
import androidx.core.provider.CalleeHandler;
import androidx.core.provider.RequestExecutor;
import androidx.core.util.Consumer;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class RequestExecutor {
    private RequestExecutor() {
    }

    static ThreadPoolExecutor createDefaultExecutor(String object, int n, int n2) {
        object = new DefaultThreadFactory((String)object, n);
        object = new ThreadPoolExecutor(0, 1, (long)n2, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<Runnable>(), (ThreadFactory)object);
        ((ThreadPoolExecutor)object).allowCoreThreadTimeOut(true);
        return object;
    }

    static Executor createHandlerExecutor(Handler handler) {
        return new HandlerExecutor(handler);
    }

    static <T> void execute(Executor executor, Callable<T> callable, Consumer<T> consumer) {
        executor.execute((Runnable)new ReplyRunnable(CalleeHandler.create(), callable, consumer));
    }

    static <T> T submit(ExecutorService object, Callable<T> callable, int n) throws InterruptedException {
        object = object.submit(callable);
        long l = n;
        try {
            object = object.get(l, TimeUnit.MILLISECONDS);
        }
        catch (TimeoutException timeoutException) {
            throw new InterruptedException("timeout");
        }
        catch (InterruptedException interruptedException) {
            throw interruptedException;
        }
        catch (ExecutionException executionException) {
            throw new RuntimeException(executionException);
        }
        return (T)object;
    }
}
