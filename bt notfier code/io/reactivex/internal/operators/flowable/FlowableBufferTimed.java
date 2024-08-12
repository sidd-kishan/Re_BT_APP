/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.Scheduler
 *  io.reactivex.Scheduler$Worker
 *  io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream
 *  io.reactivex.internal.operators.flowable.FlowableBufferTimed$BufferExactBoundedSubscriber
 *  io.reactivex.internal.operators.flowable.FlowableBufferTimed$BufferExactUnboundedSubscriber
 *  io.reactivex.internal.operators.flowable.FlowableBufferTimed$BufferSkipBoundedSubscriber
 *  io.reactivex.subscribers.SerializedSubscriber
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream;
import io.reactivex.internal.operators.flowable.FlowableBufferTimed;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;

public final class FlowableBufferTimed<T, U extends Collection<? super T>>
extends AbstractFlowableWithUpstream<T, U> {
    final Callable<U> bufferSupplier;
    final int maxSize;
    final boolean restartTimerOnMaxSize;
    final Scheduler scheduler;
    final long timeskip;
    final long timespan;
    final TimeUnit unit;

    public FlowableBufferTimed(Flowable<T> flowable, long l, long l2, TimeUnit timeUnit, Scheduler scheduler, Callable<U> callable, int n, boolean bl) {
        super(flowable);
        this.timespan = l;
        this.timeskip = l2;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.bufferSupplier = callable;
        this.maxSize = n;
        this.restartTimerOnMaxSize = bl;
    }

    protected void subscribeActual(Subscriber<? super U> subscriber) {
        if (this.timespan == this.timeskip && this.maxSize == Integer.MAX_VALUE) {
            this.source.subscribe((FlowableSubscriber)new BufferExactUnboundedSubscriber((Subscriber)new SerializedSubscriber(subscriber), this.bufferSupplier, this.timespan, this.unit, this.scheduler));
            return;
        }
        Scheduler.Worker worker = this.scheduler.createWorker();
        if (this.timespan == this.timeskip) {
            this.source.subscribe((FlowableSubscriber)new BufferExactBoundedSubscriber((Subscriber)new SerializedSubscriber(subscriber), this.bufferSupplier, this.timespan, this.unit, this.maxSize, this.restartTimerOnMaxSize, worker));
            return;
        }
        this.source.subscribe((FlowableSubscriber)new BufferSkipBoundedSubscriber((Subscriber)new SerializedSubscriber(subscriber), this.bufferSupplier, this.timespan, this.timeskip, this.unit, worker));
    }
}
