/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Completable
 *  io.reactivex.CompletableObserver
 *  io.reactivex.internal.operators.completable.CompletableFromPublisher$FromPublisherSubscriber
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.internal.operators.completable.CompletableFromPublisher;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class CompletableFromPublisher<T>
extends Completable {
    final Publisher<T> flowable;

    public CompletableFromPublisher(Publisher<T> publisher) {
        this.flowable = publisher;
    }

    protected void subscribeActual(CompletableObserver completableObserver) {
        this.flowable.subscribe((Subscriber)new FromPublisherSubscriber(completableObserver));
    }
}
