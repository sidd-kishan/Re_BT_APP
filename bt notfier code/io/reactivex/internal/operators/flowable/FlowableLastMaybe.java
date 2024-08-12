/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Maybe
 *  io.reactivex.MaybeObserver
 *  io.reactivex.internal.operators.flowable.FlowableLastMaybe$LastSubscriber
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.internal.operators.flowable.FlowableLastMaybe;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class FlowableLastMaybe<T>
extends Maybe<T> {
    final Publisher<T> source;

    public FlowableLastMaybe(Publisher<T> publisher) {
        this.source = publisher;
    }

    protected void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.source.subscribe((Subscriber)new LastSubscriber(maybeObserver));
    }
}
