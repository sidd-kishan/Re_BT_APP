/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableFromObservable.SubscriberObserver<T>
implements Observer<T>,
Subscription {
    final Subscriber<? super T> downstream;
    Disposable upstream;

    FlowableFromObservable.SubscriberObserver(Subscriber<? super T> subscriber) {
        this.downstream = subscriber;
    }

    public void cancel() {
        this.upstream.dispose();
    }

    public void onComplete() {
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
    }

    public void onNext(T t) {
        this.downstream.onNext(t);
    }

    public void onSubscribe(Disposable disposable) {
        this.upstream = disposable;
        this.downstream.onSubscribe((Subscription)this);
    }

    public void request(long l) {
    }
}
