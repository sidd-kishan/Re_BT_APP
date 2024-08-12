/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.Scheduler
 *  io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream
 *  io.reactivex.internal.operators.flowable.FlowableSkipLastTimed$SkipLastTimedSubscriber
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream;
import io.reactivex.internal.operators.flowable.FlowableSkipLastTimed;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;

public final class FlowableSkipLastTimed<T>
extends AbstractFlowableWithUpstream<T, T> {
    final int bufferSize;
    final boolean delayError;
    final Scheduler scheduler;
    final long time;
    final TimeUnit unit;

    public FlowableSkipLastTimed(Flowable<T> flowable, long l, TimeUnit timeUnit, Scheduler scheduler, int n, boolean bl) {
        super(flowable);
        this.time = l;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.bufferSize = n;
        this.delayError = bl;
    }

    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber)new SkipLastTimedSubscriber(subscriber, this.time, this.unit, this.scheduler, this.bufferSize, this.delayError));
    }
}
