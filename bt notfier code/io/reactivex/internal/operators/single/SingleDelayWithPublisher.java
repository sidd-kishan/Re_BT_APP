/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Single
 *  io.reactivex.SingleObserver
 *  io.reactivex.SingleSource
 *  io.reactivex.internal.operators.single.SingleDelayWithPublisher$OtherSubscriber
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.internal.operators.single.SingleDelayWithPublisher;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class SingleDelayWithPublisher<T, U>
extends Single<T> {
    final Publisher<U> other;
    final SingleSource<T> source;

    public SingleDelayWithPublisher(SingleSource<T> singleSource, Publisher<U> publisher) {
        this.source = singleSource;
        this.other = publisher;
    }

    protected void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.other.subscribe((Subscriber)new OtherSubscriber(singleObserver, this.source));
    }
}
