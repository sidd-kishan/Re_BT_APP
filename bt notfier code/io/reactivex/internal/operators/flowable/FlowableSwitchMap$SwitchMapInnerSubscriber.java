/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.exceptions.MissingBackpressureException
 *  io.reactivex.internal.fuseable.QueueSubscription
 *  io.reactivex.internal.fuseable.SimpleQueue
 *  io.reactivex.internal.operators.flowable.FlowableSwitchMap$SwitchMapSubscriber
 *  io.reactivex.internal.queue.SpscArrayQueue
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.operators.flowable.FlowableSwitchMap;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

static final class FlowableSwitchMap.SwitchMapInnerSubscriber<T, R>
extends AtomicReference<Subscription>
implements FlowableSubscriber<R> {
    private static final long serialVersionUID = 3837284832786408377L;
    final int bufferSize;
    volatile boolean done;
    int fusionMode;
    final long index;
    final FlowableSwitchMap.SwitchMapSubscriber<T, R> parent;
    volatile SimpleQueue<R> queue;

    FlowableSwitchMap.SwitchMapInnerSubscriber(FlowableSwitchMap.SwitchMapSubscriber<T, R> switchMapSubscriber, long l, int n) {
        this.parent = switchMapSubscriber;
        this.index = l;
        this.bufferSize = n;
    }

    public void cancel() {
        SubscriptionHelper.cancel((AtomicReference)this);
    }

    public void onComplete() {
        FlowableSwitchMap.SwitchMapSubscriber<T, R> switchMapSubscriber = this.parent;
        if (this.index != switchMapSubscriber.unique) return;
        this.done = true;
        switchMapSubscriber.drain();
    }

    public void onError(Throwable throwable) {
        FlowableSwitchMap.SwitchMapSubscriber<T, R> switchMapSubscriber = this.parent;
        if (this.index == switchMapSubscriber.unique && switchMapSubscriber.error.addThrowable(throwable)) {
            if (!switchMapSubscriber.delayErrors) {
                switchMapSubscriber.upstream.cancel();
            }
            this.done = true;
            switchMapSubscriber.drain();
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void onNext(R r) {
        FlowableSwitchMap.SwitchMapSubscriber<T, R> switchMapSubscriber = this.parent;
        if (this.index != switchMapSubscriber.unique) return;
        if (this.fusionMode == 0 && !this.queue.offer(r)) {
            this.onError((Throwable)new MissingBackpressureException("Queue full?!"));
            return;
        }
        switchMapSubscriber.drain();
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.setOnce((AtomicReference)this, (Subscription)subscription)) return;
        if (subscription instanceof QueueSubscription) {
            QueueSubscription queueSubscription = (QueueSubscription)subscription;
            int n = queueSubscription.requestFusion(7);
            if (n == 1) {
                this.fusionMode = n;
                this.queue = queueSubscription;
                this.done = true;
                this.parent.drain();
                return;
            }
            if (n == 2) {
                this.fusionMode = n;
                this.queue = queueSubscription;
                subscription.request((long)this.bufferSize);
                return;
            }
        }
        this.queue = new SpscArrayQueue(this.bufferSize);
        subscription.request((long)this.bufferSize);
    }
}
