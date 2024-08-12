/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.Observable
 *  io.reactivex.Observer
 *  io.reactivex.internal.operators.flowable.FlowableFromObservable$SubscriberObserver
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.internal.operators.flowable.FlowableFromObservable;
import org.reactivestreams.Subscriber;

public final class FlowableFromObservable<T>
extends Flowable<T> {
    private final Observable<T> upstream;

    public FlowableFromObservable(Observable<T> observable) {
        this.upstream = observable;
    }

    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.upstream.subscribe((Observer)new SubscriberObserver(subscriber));
    }
}
