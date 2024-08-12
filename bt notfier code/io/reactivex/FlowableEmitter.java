/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Emitter
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.functions.Cancellable
 */
package io.reactivex;

import io.reactivex.Emitter;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Cancellable;

public interface FlowableEmitter<T>
extends Emitter<T> {
    public boolean isCancelled();

    public long requested();

    public FlowableEmitter<T> serialize();

    public void setCancellable(Cancellable var1);

    public void setDisposable(Disposable var1);

    public boolean tryOnError(Throwable var1);
}
