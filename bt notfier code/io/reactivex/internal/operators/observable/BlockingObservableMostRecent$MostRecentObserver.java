/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.operators.observable.BlockingObservableMostRecent$MostRecentObserver$Iterator
 *  io.reactivex.internal.util.NotificationLite
 *  io.reactivex.observers.DefaultObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.internal.operators.observable.BlockingObservableMostRecent;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.observers.DefaultObserver;

static final class BlockingObservableMostRecent.MostRecentObserver<T>
extends DefaultObserver<T> {
    volatile Object value;

    BlockingObservableMostRecent.MostRecentObserver(T t) {
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
