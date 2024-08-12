/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Single
 *  io.reactivex.SingleObserver
 *  io.reactivex.internal.operators.flowable.FlowableLastSingle$LastSubscriber
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.internal.operators.flowable.FlowableLastSingle;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class FlowableLastSingle<T>
extends Single<T> {
    final T defaultItem;
    final Publisher<T> source;

    public FlowableLastSingle(Publisher<T> publisher, T t) {
        this.source = publisher;
        this.defaultItem = t;
    }

    protected void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.source.subscribe((Subscriber)new LastSubscriber(singleObserver, this.defaultItem));
    }
}
