/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.Scheduler
 *  io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream
 *  io.reactivex.internal.operators.flowable.FlowableTakeLastTimed$TakeLastTimedSubscriber
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream;
import io.reactivex.internal.operators.flowable.FlowableTakeLastTimed;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;

public final class FlowableTakeLastTimed<T>
extends AbstractFlowableWithUpstream<T, T> {
    final int bufferSize;
    final long count;
    final boolean delayError;
    final Scheduler scheduler;
    final long time;
    final TimeUnit unit;

    public FlowableTakeLastTimed(Flowable<T> flowable, long l, long l2, TimeUnit timeUnit, Scheduler scheduler, int n, boolean bl) {
        super(flowable);
        this.count = l;
        this.time = l2;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.bufferSize = n;
        this.delayError = bl;
    }

    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber)new TakeLastTimedSubscriber(subscriber, this.count, this.time, this.unit, this.scheduler, this.bufferSize, this.delayError));
    }
}
