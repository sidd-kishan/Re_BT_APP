/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.Scheduler
 *  io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream
 *  io.reactivex.internal.operators.flowable.FlowableThrottleLatest$ThrottleLatestSubscriber
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream;
import io.reactivex.internal.operators.flowable.FlowableThrottleLatest;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;

public final class FlowableThrottleLatest<T>
extends AbstractFlowableWithUpstream<T, T> {
    final boolean emitLast;
    final Scheduler scheduler;
    final long timeout;
    final TimeUnit unit;

    public FlowableThrottleLatest(Flowable<T> flowable, long l, TimeUnit timeUnit, Scheduler scheduler, boolean bl) {
        super(flowable);
        this.timeout = l;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.emitLast = bl;
    }

    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber)new ThrottleLatestSubscriber(subscriber, this.timeout, this.unit, this.scheduler.createWorker(), this.emitLast));
    }
}
