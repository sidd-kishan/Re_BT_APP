/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.operators.flowable.BlockingFlowableMostRecent$MostRecentSubscriber$Iterator
 *  io.reactivex.internal.util.NotificationLite
 *  io.reactivex.subscribers.DefaultSubscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.operators.flowable.BlockingFlowableMostRecent;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.subscribers.DefaultSubscriber;

static final class BlockingFlowableMostRecent.MostRecentSubscriber<T>
extends DefaultSubscriber<T> {
    volatile Object value;

    BlockingFlowableMostRecent.MostRecentSubscriber(T t) {
        this.value = NotificationLite.next(t);
    }

    public Iterator getIterable() {
        return new Iterator(this);
    }

    public void onComplete() {
        this.value = NotificationLite.complete();
    }

    public void onError(Throwable throwable) {
        this.value = NotificationLite.error((Throwable)throwable);
    }

    public void onNext(T t) {
        this.value = NotificationLite.next(t);
    }
}
