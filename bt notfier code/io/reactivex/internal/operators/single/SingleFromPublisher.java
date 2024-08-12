/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Single
 *  io.reactivex.SingleObserver
 *  io.reactivex.internal.operators.single.SingleFromPublisher$ToSingleObserver
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.internal.operators.single.SingleFromPublisher;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class SingleFromPublisher<T>
extends Single<T> {
    final Publisher<? extends T> publisher;

    public SingleFromPublisher(Publisher<? extends T> publisher) {
        this.publisher = publisher;
    }

    protected void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.publisher.subscribe((Subscriber)new ToSingleObserver(singleObserver));
    }
}
