/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.Scheduler
 *  io.reactivex.internal.operators.flowable.FlowableTimer$TimerSubscriber
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.internal.operators.flowable.FlowableTimer;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableTimer
extends Flowable<Long> {
    final long delay;
    final Scheduler scheduler;
    final TimeUnit unit;

    public FlowableTimer(long l, TimeUnit timeUnit, Scheduler scheduler) {
        this.delay = l;
        this.unit = timeUnit;
        this.scheduler = scheduler;
    }

    public void subscribeActual(Subscriber<? super Long> subscriber) {
        TimerSubscriber timerSubscriber = new TimerSubscriber(subscriber);
        subscriber.onSubscribe((Subscription)timerSubscriber);
        timerSubscriber.setResource(this.scheduler.scheduleDirect((Runnable)timerSubscriber, this.delay, this.unit));
    }
}
