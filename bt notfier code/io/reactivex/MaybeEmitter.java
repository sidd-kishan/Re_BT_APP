/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.functions.Cancellable
 */
package io.reactivex;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Cancellable;

public interface MaybeEmitter<T> {
    public boolean isDisposed();

    public void onComplete();

    public void onError(Throwable var1);

    public void onSuccess(T var1);

    public void setCancellable(Cancellable var1);

    public void setDisposable(Disposable var1);

    public boolean tryOnError(Throwable var1);
}
