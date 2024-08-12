/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.observers.BlockingBaseObserver
 */
package io.reactivex.internal.observers;

import io.reactivex.internal.observers.BlockingBaseObserver;

public final class BlockingLastObserver<T>
extends BlockingBaseObserver<T> {
    public void onError(Throwable throwable) {
        this.value = null;
        this.error = throwable;
        this.countDown();
    }

    public void onNext(T t) {
        this.value = t;
    }
}
