/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.CompletableObserver
 *  io.reactivex.CompletableSource
 *  io.reactivex.Flowable
 *  io.reactivex.internal.operators.mixed.CompletableAndThenPublisher$AndThenPublisherSubscriber
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.mixed;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.internal.operators.mixed.CompletableAndThenPublisher;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class CompletableAndThenPublisher<R>
extends Flowable<R> {
    final Publisher<? extends R> other;
    final CompletableSource source;

    public CompletableAndThenPublisher(CompletableSource completableSource, Publisher<? extends R> publisher) {
        this.source = completableSource;
        this.other = publisher;
    }

    protected void subscribeActual(Subscriber<? super R> subscriber) {
        this.source.subscribe((CompletableObserver)new AndThenPublisherSubscriber(subscriber, this.other));
    }
}
