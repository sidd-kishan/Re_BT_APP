/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.Scheduler
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.operators.flowable.FlowableInterval$IntervalSubscriber
 *  io.reactivex.internal.schedulers.TrampolineScheduler
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.flowable.FlowableInterval;
import io.reactivex.internal.schedulers.TrampolineScheduler;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableInterval
extends Flowable<Long> {
    final long initialDelay;
    final long period;
    final Scheduler scheduler;
    final TimeUnit unit;

    public FlowableInterval(long l, long l2, TimeUnit timeUnit, Scheduler scheduler) {
        this.initialDelay = l;
        this.period = l2;
        this.unit = timeUnit;
        this.scheduler = scheduler;
    }

    public void subscribeActual(Subscriber<? super Long> scheduler) {
        IntervalSubscriber intervalSubscriber = new IntervalSubscriber(scheduler);
        scheduler.onSubscribe((Subscription)intervalSubscriber);
        scheduler = this.scheduler;
        if (scheduler instanceof TrampolineScheduler) {
            scheduler = scheduler.createWorker();
            intervalSubscriber.setResource((Disposable)scheduler);
            scheduler.schedulePeriodically((Runnable)intervalSubscriber, this.initialDelay, this.period, this.unit);
        } else {
            intervalSubscriber.setResource(scheduler.schedulePeriodicallyDirect((Runnable)intervalSubscriber, this.initialDelay, this.period, this.unit));
        }
    }
}
