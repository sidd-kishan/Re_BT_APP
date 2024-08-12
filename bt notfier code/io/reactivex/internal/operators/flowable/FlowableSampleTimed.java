/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.Scheduler
 *  io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream
 *  io.reactivex.internal.operators.flowable.FlowableSampleTimed$SampleTimedEmitLast
 *  io.reactivex.internal.operators.flowable.FlowableSampleTimed$SampleTimedNoLast
 *  io.reactivex.subscribers.SerializedSubscriber
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream;
import io.reactivex.internal.operators.flowable.FlowableSampleTimed;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;

public final class FlowableSampleTimed<T>
extends AbstractFlowableWithUpstream<T, T> {
    final boolean emitLast;
    final long period;
    final Scheduler scheduler;
    final TimeUnit unit;

    public FlowableSampleTimed(Flowable<T> flowable, long l, TimeUnit timeUnit, Scheduler scheduler, boolean bl) {
        super(flowable);
        this.period = l;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.emitLast = bl;
    }

    protected void subscribeActual(Subscriber<? super T> serializedSubscriber) {
        serializedSubscriber = new SerializedSubscriber(serializedSubscriber);
        if (this.emitLast) {
            this.source.subscribe((FlowableSubscriber)new SampleTimedEmitLast((Subscriber)serializedSubscriber, this.period, this.unit, this.scheduler));
        } else {
            this.source.subscribe((FlowableSubscriber)new SampleTimedNoLast((Subscriber)serializedSubscriber, this.period, this.unit, this.scheduler));
        }
    }
}
