/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.concurrent.futures.CallbackToFutureAdapter$FutureGarbageCollectedException
 *  androidx.concurrent.futures.CallbackToFutureAdapter$SafeFuture
 *  androidx.concurrent.futures.ResolvableFuture
 */
package androidx.concurrent.futures;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.concurrent.futures.ResolvableFuture;
import java.util.concurrent.Executor;

public static final class CallbackToFutureAdapter.Completer<T> {
    private boolean attemptedSetting;
    private ResolvableFuture<Void> cancellationFuture = ResolvableFuture.create();
    CallbackToFutureAdapter.SafeFuture<T> future;
    Object tag;

    CallbackToFutureAdapter.Completer() {
    }

    private void setCompletedNormally() {
        this.tag = null;
        this.future = null;
        this.cancellationFuture = null;
    }

    public void addCancellationListener(Runnable runnable, Executor executor) {
        ResolvableFuture<Void> resolvableFuture = this.cancellationFuture;
        if (resolvableFuture == null) return;
        resolvableFuture.addListener(runnable, executor);
    }

    protected void finalize() {
        CallbackToFutureAdapter.SafeFuture<T> safeFuture = this.future;
        if (safeFuture != null && !safeFuture.isDone()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("The completer object was garbage collected - this future would otherwise never complete. The tag was: ");
            stringBuilder.append(this.tag);
            safeFuture.setException((Throwable)new CallbackToFutureAdapter.FutureGarbageCollectedException(stringBuilder.toString()));
        }
        if (this.attemptedSetting) return;
        safeFuture = this.cancellationFuture;
        if (safeFuture == null) return;
        safeFuture.set(null);
    }

    void fireCancellationListeners() {
        this.tag = null;
        this.future = null;
        this.cancellationFuture.set(null);
    }

    public boolean set(T t) {
        boolean bl = true;
        this.attemptedSetting = true;
        CallbackToFutureAdapter.SafeFuture<T> safeFuture = this.future;
        if (safeFuture == null || !safeFuture.set(t)) {
            bl = false;
        }
        if (!bl) return bl;
        this.setCompletedNormally();
        return bl;
    }

    public boolean setCancelled() {
        boolean bl = true;
        this.attemptedSetting = true;
        CallbackToFutureAdapter.SafeFuture<T> safeFuture = this.future;
        if (safeFuture == null || !safeFuture.cancelWithoutNotifyingCompleter(true)) {
            bl = false;
        }
        if (!bl) return bl;
        this.setCompletedNormally();
        return bl;
    }

    public boolean setException(Throwable throwable) {
        boolean bl = true;
        this.attemptedSetting = true;
        CallbackToFutureAdapter.SafeFuture<T> safeFuture = this.future;
        if (safeFuture == null || !safeFuture.setException(throwable)) {
            bl = false;
        }
        if (!bl) return bl;
        this.setCompletedNormally();
        return bl;
    }
}
