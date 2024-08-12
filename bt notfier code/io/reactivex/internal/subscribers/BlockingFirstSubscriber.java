/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.subscribers.BlockingBaseSubscriber
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.subscribers;

import io.reactivex.internal.subscribers.BlockingBaseSubscriber;
import io.reactivex.plugins.RxJavaPlugins;

public final class BlockingFirstSubscriber<T>
extends BlockingBaseSubscriber<T> {
    public void onError(Throwable throwable) {
        if (this.value == null) {
            this.error = throwable;
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
        this.countDown();
    }

    public void onNext(T t) {
        if (this.value != null) return;
        this.value = t;
        this.upstream.cancel();
        this.countDown();
    }
}
