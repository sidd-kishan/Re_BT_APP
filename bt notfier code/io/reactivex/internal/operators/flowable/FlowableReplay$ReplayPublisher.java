/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.internal.operators.flowable.FlowableReplay$InnerSubscription
 *  io.reactivex.internal.operators.flowable.FlowableReplay$ReplayBuffer
 *  io.reactivex.internal.operators.flowable.FlowableReplay$ReplaySubscriber
 *  io.reactivex.internal.subscriptions.EmptySubscription
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.operators.flowable.FlowableReplay;
import io.reactivex.internal.subscriptions.EmptySubscription;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableReplay.ReplayPublisher<T>
implements Publisher<T> {
    private final Callable<? extends FlowableReplay.ReplayBuffer<T>> bufferFactory;
    private final AtomicReference<FlowableReplay.ReplaySubscriber<T>> curr;

    FlowableReplay.ReplayPublisher(AtomicReference<FlowableReplay.ReplaySubscriber<T>> atomicReference, Callable<? extends FlowableReplay.ReplayBuffer<T>> callable) {
        this.curr = atomicReference;
        this.bufferFactory = callable;
    }

    public void subscribe(Subscriber<? super T> subscriber) {
        FlowableReplay.InnerSubscription innerSubscription;
        FlowableReplay.InnerSubscription innerSubscription2;
        do {
            innerSubscription2 = innerSubscription = this.curr.get();
            if (innerSubscription != null) break;
            try {
                innerSubscription2 = this.bufferFactory.call();
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                EmptySubscription.error((Throwable)throwable, subscriber);
                return;
            }
            innerSubscription2 = new FlowableReplay.ReplaySubscriber((FlowableReplay.ReplayBuffer)innerSubscription2);
        } while (!this.curr.compareAndSet((FlowableReplay.ReplaySubscriber<T>)null, (FlowableReplay.ReplaySubscriber<T>)innerSubscription2));
        innerSubscription = new FlowableReplay.InnerSubscription(innerSubscription2, subscriber);
        subscriber.onSubscribe((Subscription)innerSubscription);
        innerSubscription2.add(innerSubscription);
        if (innerSubscription.isDisposed()) {
            innerSubscription2.remove(innerSubscription);
            return;
        }
        innerSubscription2.manageRequests();
        innerSubscription2.buffer.replay(innerSubscription);
    }
}
