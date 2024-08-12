/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.Scheduler
 *  io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream
 *  io.reactivex.internal.operators.flowable.FlowableWindowTimed$WindowExactBoundedSubscriber
 *  io.reactivex.internal.operators.flowable.FlowableWindowTimed$WindowExactUnboundedSubscriber
 *  io.reactivex.internal.operators.flowable.FlowableWindowTimed$WindowSkipSubscriber
 *  io.reactivex.subscribers.SerializedSubscriber
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream;
import io.reactivex.internal.operators.flowable.FlowableWindowTimed;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;

public final class FlowableWindowTimed<T>
extends AbstractFlowableWithUpstream<T, Flowable<T>> {
    final int bufferSize;
    final long maxSize;
    final boolean restartTimerOnMaxSize;
    final Scheduler scheduler;
    final long timeskip;
    final long timespan;
    final TimeUnit unit;

    public FlowableWindowTimed(Flowable<T> flowable, long l, long l2, TimeUnit timeUnit, Scheduler scheduler, long l3, int n, boolean bl) {
        super(flowable);
        this.timespan = l;
        this.timeskip = l2;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.maxSize = l3;
        this.bufferSize = n;
        this.restartTimerOnMaxSize = bl;
    }

    protected void subscribeActual(Subscriber<? super Flowable<T>> serializedSubscriber) {
        serializedSubscriber = new SerializedSubscriber(serializedSubscriber);
        if (this.timespan != this.timeskip) {
            this.source.subscribe((FlowableSubscriber)new WindowSkipSubscriber((Subscriber)serializedSubscriber, this.timespan, this.timeskip, this.unit, this.scheduler.createWorker(), this.bufferSize));
            return;
        }
        if (this.maxSize == Long.MAX_VALUE) {
            this.source.subscribe((FlowableSubscriber)new WindowExactUnboundedSubscriber((Subscriber)serializedSubscriber, this.timespan, this.unit, this.scheduler, this.bufferSize));
            return;
        }
        this.source.subscribe((FlowableSubscriber)new WindowExactBoundedSubscriber((Subscriber)serializedSubscriber, this.timespan, this.unit, this.scheduler, this.bufferSize, this.maxSize, this.restartTimerOnMaxSize));
    }
}
