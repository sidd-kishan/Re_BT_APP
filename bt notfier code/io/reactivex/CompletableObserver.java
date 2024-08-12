/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.disposables.Disposable
 */
package io.reactivex;

import io.reactivex.disposables.Disposable;

public interface CompletableObserver {
    public void onComplete();

    public void onError(Throwable var1);

    public void onSubscribe(Disposable var1);
}
