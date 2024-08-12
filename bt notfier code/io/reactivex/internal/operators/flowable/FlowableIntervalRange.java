/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.Scheduler
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.operators.flowable.FlowableIntervalRange$IntervalRangeSubscriber
 *  io.reactivex.internal.schedulers.TrampolineScheduler
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.flowable.FlowableIntervalRange;
import io.reactivex.internal.schedulers.TrampolineScheduler;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableIntervalRange
extends Flowable<Long> {
    final long end;
    final long initialDelay;
    final long period;
    final Scheduler scheduler;
    final long start;
    final TimeUnit unit;

    public FlowableIntervalRange(long l, long l2, long l3, long l4, TimeUnit timeUnit, Scheduler scheduler) {
        this.initialDelay = l3;
        this.period = l4;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.start = l;
        this.end = l2;
    }

    public void subscribeActual(Subscriber<? super Long> scheduler) {
        IntervalRangeSubscriber intervalRangeSubscriber = new IntervalRangeSubscriber(scheduler, this.start, this.end);
        scheduler.onSubscribe((Subscription)intervalRangeSubscriber);
        scheduler = this.scheduler;
        if (scheduler instanceof TrampolineScheduler) {
            scheduler = scheduler.createWorker();
            intervalRangeSubscriber.setResource((Disposable)scheduler);
            scheduler.schedulePeriodically((Runnable)intervalRangeSubscriber, this.initialDelay, this.period, this.unit);
        } else {
            intervalRangeSubscriber.setResource(scheduler.schedulePeriodicallyDirect((Runnable)intervalRangeSubscriber, this.initialDelay, this.period, this.unit));
        }
    }
}
