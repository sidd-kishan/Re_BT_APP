/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.Scheduler
 *  io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream
 *  io.reactivex.internal.operators.flowable.FlowableThrottleFirstTimed$DebounceTimedSubscriber
 *  io.reactivex.subscribers.SerializedSubscriber
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream;
import io.reactivex.internal.operators.flowable.FlowableThrottleFirstTimed;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;

public final class FlowableThrottleFirstTimed<T>
extends AbstractFlowableWithUpstream<T, T> {
    final Scheduler scheduler;
    final long timeout;
    final TimeUnit unit;

    public FlowableThrottleFirstTimed(Flowable<T> flowable, long l, TimeUnit timeUnit, Scheduler scheduler) {
        super(flowable);
        this.timeout = l;
        this.unit = timeUnit;
        this.scheduler = scheduler;
    }

    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber)new DebounceTimedSubscriber((Subscriber)new SerializedSubscriber(subscriber), this.timeout, this.unit, this.scheduler.createWorker()));
    }
}
