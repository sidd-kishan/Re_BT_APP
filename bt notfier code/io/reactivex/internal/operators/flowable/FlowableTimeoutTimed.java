/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.Scheduler
 *  io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream
 *  io.reactivex.internal.operators.flowable.FlowableTimeoutTimed$TimeoutFallbackSubscriber
 *  io.reactivex.internal.operators.flowable.FlowableTimeoutTimed$TimeoutSubscriber
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream;
import io.reactivex.internal.operators.flowable.FlowableTimeoutTimed;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableTimeoutTimed<T>
extends AbstractFlowableWithUpstream<T, T> {
    final Publisher<? extends T> other;
    final Scheduler scheduler;
    final long timeout;
    final TimeUnit unit;

    public FlowableTimeoutTimed(Flowable<T> flowable, long l, TimeUnit timeUnit, Scheduler scheduler, Publisher<? extends T> publisher) {
        super(flowable);
        this.timeout = l;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.other = publisher;
    }

    protected void subscribeActual(Subscriber<? super T> subscriber) {
        if (this.other == null) {
            TimeoutSubscriber timeoutSubscriber = new TimeoutSubscriber(subscriber, this.timeout, this.unit, this.scheduler.createWorker());
            subscriber.onSubscribe((Subscription)timeoutSubscriber);
            timeoutSubscriber.startTimeout(0L);
            this.source.subscribe((FlowableSubscriber)timeoutSubscriber);
        } else {
            TimeoutFallbackSubscriber timeoutFallbackSubscriber = new TimeoutFallbackSubscriber(subscriber, this.timeout, this.unit, this.scheduler.createWorker(), this.other);
            subscriber.onSubscribe((Subscription)timeoutFallbackSubscriber);
            timeoutFallbackSubscriber.startTimeout(0L);
            this.source.subscribe((FlowableSubscriber)timeoutFallbackSubscriber);
        }
    }
}
