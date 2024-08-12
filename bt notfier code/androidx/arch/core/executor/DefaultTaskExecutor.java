/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Looper
 *  androidx.arch.core.executor.TaskExecutor
 */
package androidx.arch.core.executor;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.arch.core.executor.TaskExecutor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class DefaultTaskExecutor
extends TaskExecutor {
    private final ExecutorService mDiskIO;
    private final Object mLock = new Object();
    private volatile Handler mMainHandler;

    public DefaultTaskExecutor() {
        this.mDiskIO = Executors.newFixedThreadPool(4, (ThreadFactory)new /* Unavailable Anonymous Inner Class!! */);
    }

    private static Handler createAsync(Looper looper) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Handler.createAsync((Looper)looper);
        }
        if (Build.VERSION.SDK_INT < 16) return new Handler(looper);
        try {
            Handler handler = (Handler)Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, true);
            return handler;
        }
        catch (InvocationTargetException invocationTargetException) {
            return new Handler(looper);
        }
        catch (IllegalAccessException | InstantiationException | NoSuchMethodException reflectiveOperationException) {
        }
        return new Handler(looper);
    }

    public void executeOnDiskIO(Runnable runnable) {
        this.mDiskIO.execute(runnable);
    }

    public boolean isMainThread() {
        boolean bl = Looper.getMainLooper().getThread() == Thread.currentThread();
        return bl;
    }

    public void postToMainThread(Runnable runnable) {
        if (this.mMainHandler == null) {
            Object object = this.mLock;
            synchronized (object) {
                if (this.mMainHandler == null) {
                    this.mMainHandler = DefaultTaskExecutor.createAsync(Looper.getMainLooper());
                }
            }
        }
        this.mMainHandler.post(runnable);
    }
}
