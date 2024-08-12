/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.flowables.ConnectableFlowable
 *  io.reactivex.functions.Consumer
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.flowable.FlowableReplay$MulticastFlowable$DisposableConsumer
 *  io.reactivex.internal.subscribers.SubscriberResourceWrapper
 *  io.reactivex.internal.subscriptions.EmptySubscription
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.flowable.FlowableReplay;
import io.reactivex.internal.subscribers.SubscriberResourceWrapper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

static final class FlowableReplay.MulticastFlowable<R, U>
extends Flowable<R> {
    private final Callable<? extends ConnectableFlowable<U>> connectableFactory;
    private final Function<? super Flowable<U>, ? extends Publisher<R>> selector;

    FlowableReplay.MulticastFlowable(Callable<? extends ConnectableFlowable<U>> callable, Function<? super Flowable<U>, ? extends Publisher<R>> function) {
        this.connectableFactory = callable;
        this.selector = function;
    }

    protected void subscribeActual(Subscriber<? super R> subscriberResourceWrapper) {
        Publisher publisher;
        ConnectableFlowable connectableFlowable;
        try {
            connectableFlowable = (ConnectableFlowable)ObjectHelper.requireNonNull(this.connectableFactory.call(), (String)"The connectableFactory returned null");
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            EmptySubscription.error((Throwable)throwable, subscriberResourceWrapper);
            return;
        }
        try {
            publisher = (Publisher)ObjectHelper.requireNonNull((Object)this.selector.apply((Object)connectableFlowable), (String)"The selector returned a null Publisher");
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            EmptySubscription.error((Throwable)throwable, subscriberResourceWrapper);
            return;
        }
        subscriberResourceWrapper = new SubscriberResourceWrapper(subscriberResourceWrapper);
        publisher.subscribe((Subscriber)subscriberResourceWrapper);
        connectableFlowable.connect((Consumer)new DisposableConsumer(this, subscriberResourceWrapper));
    }
}
