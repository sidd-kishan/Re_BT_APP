/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.Logger
 *  androidx.camera.core.impl.utils.futures.ImmediateFuture$ImmediateSuccessfulFuture
 *  androidx.core.util.Preconditions
 */
package androidx.camera.core.impl.utils.futures;

import androidx.camera.core.Logger;
import androidx.camera.core.impl.utils.futures.ImmediateFuture;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

abstract class ImmediateFuture<V>
implements ListenableFuture<V> {
    private static final String TAG = "ImmediateFuture";

    ImmediateFuture() {
    }

    public static <V> ListenableFuture<V> nullFuture() {
        return ImmediateSuccessfulFuture.NULL_FUTURE;
    }

    @Override
    public void addListener(Runnable runnable, Executor executor) {
        Preconditions.checkNotNull((Object)runnable);
        Preconditions.checkNotNull((Object)executor);
        try {
            executor.execute(runnable);
        }
        catch (RuntimeException runtimeException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Experienced RuntimeException while attempting to notify ");
            stringBuilder.append(runnable);
            stringBuilder.append(" on Executor ");
            stringBuilder.append(executor);
            Logger.e((String)TAG, (String)stringBuilder.toString(), (Throwable)runtimeException);
        }
    }

    @Override
    public boolean cancel(boolean bl) {
        return false;
    }

    @Override
    public abstract V get() throws ExecutionException;

    @Override
    public V get(long l, TimeUnit timeUnit) throws ExecutionException {
        Preconditions.checkNotNull((Object)((Object)timeUnit));
        return this.get();
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public boolean isDone() {
        return true;
    }
}
