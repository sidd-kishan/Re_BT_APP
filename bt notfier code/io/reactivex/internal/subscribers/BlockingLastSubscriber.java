/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.subscribers.BlockingBaseSubscriber
 */
package io.reactivex.internal.subscribers;

import io.reactivex.internal.subscribers.BlockingBaseSubscriber;

public final class BlockingLastSubscriber<T>
extends BlockingBaseSubscriber<T> {
    public void onError(Throwable throwable) {
        this.value = null;
        this.error = throwable;
        this.countDown();
    }

    public void onNext(T t) {
        this.value = t;
    }
}
