/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream
 *  io.reactivex.internal.operators.flowable.FlowableRepeatWhen$RepeatWhenSubscriber
 *  io.reactivex.internal.operators.flowable.FlowableRepeatWhen$WhenReceiver
 *  io.reactivex.internal.subscriptions.EmptySubscription
 *  io.reactivex.processors.FlowableProcessor
 *  io.reactivex.processors.UnicastProcessor
 *  io.reactivex.subscribers.SerializedSubscriber
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream;
import io.reactivex.internal.operators.flowable.FlowableRepeatWhen;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.processors.FlowableProcessor;
import io.reactivex.processors.UnicastProcessor;
import io.reactivex.subscribers.SerializedSubscriber;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableRepeatWhen<T>
extends AbstractFlowableWithUpstream<T, T> {
    final Function<? super Flowable<Object>, ? extends Publisher<?>> handler;

    public FlowableRepeatWhen(Flowable<T> flowable, Function<? super Flowable<Object>, ? extends Publisher<?>> function) {
        super(flowable);
        this.handler = function;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        Publisher publisher;
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        FlowableProcessor flowableProcessor = UnicastProcessor.create((int)8).toSerialized();
        try {
            publisher = (Publisher)ObjectHelper.requireNonNull((Object)this.handler.apply((Object)flowableProcessor), (String)"handler returned a null Publisher");
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            EmptySubscription.error((Throwable)throwable, subscriber);
            return;
        }
        WhenReceiver whenReceiver = new WhenReceiver((Publisher)this.source);
        serializedSubscriber = new RepeatWhenSubscriber((Subscriber)serializedSubscriber, flowableProcessor, (Subscription)whenReceiver);
        whenReceiver.subscriber = serializedSubscriber;
        subscriber.onSubscribe((Subscription)serializedSubscriber);
        publisher.subscribe((Subscriber)whenReceiver);
        whenReceiver.onNext((Object)0);
    }
}
