/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 *  io.reactivex.Observer
 *  io.reactivex.internal.operators.observable.ObservableFromPublisher$PublisherSubscriber
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.internal.operators.observable.ObservableFromPublisher;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class ObservableFromPublisher<T>
extends Observable<T> {
    final Publisher<? extends T> source;

    public ObservableFromPublisher(Publisher<? extends T> publisher) {
        this.source = publisher;
    }

    protected void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe((Subscriber)new PublisherSubscriber(observer));
    }
}
