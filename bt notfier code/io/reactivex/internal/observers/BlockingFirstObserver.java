/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.observers.BlockingBaseObserver
 */
package io.reactivex.internal.observers;

import io.reactivex.internal.observers.BlockingBaseObserver;

public final class BlockingFirstObserver<T>
extends BlockingBaseObserver<T> {
    public void onError(Throwable throwable) {
        if (this.value == null) {
            this.error = throwable;
        }
        this.countDown();
    }

    public void onNext(T t) {
        if (this.value != null) return;
        this.value = t;
        this.upstream.dispose();
        this.countDown();
    }
}
