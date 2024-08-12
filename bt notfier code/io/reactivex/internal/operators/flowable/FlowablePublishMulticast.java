/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream
 *  io.reactivex.internal.operators.flowable.FlowablePublishMulticast$MulticastProcessor
 *  io.reactivex.internal.operators.flowable.FlowablePublishMulticast$OutputCanceller
 *  io.reactivex.internal.subscriptions.EmptySubscription
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream;
import io.reactivex.internal.operators.flowable.FlowablePublishMulticast;
import io.reactivex.internal.subscriptions.EmptySubscription;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class FlowablePublishMulticast<T, R>
extends AbstractFlowableWithUpstream<T, R> {
    final boolean delayError;
    final int prefetch;
    final Function<? super Flowable<T>, ? extends Publisher<? extends R>> selector;

    public FlowablePublishMulticast(Flowable<T> flowable, Function<? super Flowable<T>, ? extends Publisher<? extends R>> function, int n, boolean bl) {
        super(flowable);
        this.selector = function;
        this.prefetch = n;
        this.delayError = bl;
    }

    protected void subscribeActual(Subscriber<? super R> subscriber) {
        Publisher publisher;
        MulticastProcessor multicastProcessor = new MulticastProcessor(this.prefetch, this.delayError);
        try {
            publisher = (Publisher)ObjectHelper.requireNonNull((Object)this.selector.apply((Object)multicastProcessor), (String)"selector returned a null Publisher");
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            EmptySubscription.error((Throwable)throwable, subscriber);
            return;
        }
        publisher.subscribe((Subscriber)new OutputCanceller(subscriber, multicastProcessor));
        this.source.subscribe((FlowableSubscriber)multicastProcessor);
    }
}
