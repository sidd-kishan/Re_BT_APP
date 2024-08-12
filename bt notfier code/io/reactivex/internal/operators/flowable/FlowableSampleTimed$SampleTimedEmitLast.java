/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Scheduler
 *  io.reactivex.internal.operators.flowable.FlowableSampleTimed$SampleTimedSubscriber
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Scheduler;
import io.reactivex.internal.operators.flowable.FlowableSampleTimed;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscriber;

static final class FlowableSampleTimed.SampleTimedEmitLast<T>
extends FlowableSampleTimed.SampleTimedSubscriber<T> {
    private static final long serialVersionUID = -7139995637533111443L;
    final AtomicInteger wip = new AtomicInteger(1);

    FlowableSampleTimed.SampleTimedEmitLast(Subscriber<? super T> subscriber, long l, TimeUnit timeUnit, Scheduler scheduler) {
        super(subscriber, l, timeUnit, scheduler);
    }

    void complete() {
        this.emit();
        if (this.wip.decrementAndGet() != 0) return;
        this.downstream.onComplete();
    }

    public void run() {
        if (this.wip.incrementAndGet() != 2) return;
        this.emit();
        if (this.wip.decrementAndGet() != 0) return;
        this.downstream.onComplete();
    }
}
