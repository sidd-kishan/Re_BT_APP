/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.Scheduler
 *  io.reactivex.Scheduler$Worker
 *  io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream
 *  io.reactivex.internal.operators.flowable.FlowableDelay$DelaySubscriber
 *  io.reactivex.subscribers.SerializedSubscriber
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream;
import io.reactivex.internal.operators.flowable.FlowableDelay;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;

public final class FlowableDelay<T>
extends AbstractFlowableWithUpstream<T, T> {
    final long delay;
    final boolean delayError;
    final Scheduler scheduler;
    final TimeUnit unit;

    public FlowableDelay(Flowable<T> flowable, long l, TimeUnit timeUnit, Scheduler scheduler, boolean bl) {
        super(flowable);
        this.delay = l;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.delayError = bl;
    }

    protected void subscribeActual(Subscriber<? super T> serializedSubscriber) {
        if (!this.delayError) {
            serializedSubscriber = new SerializedSubscriber(serializedSubscriber);
        }
        Scheduler.Worker worker = this.scheduler.createWorker();
        this.source.subscribe((FlowableSubscriber)new DelaySubscriber((Subscriber)serializedSubscriber, this.delay, this.unit, worker, this.delayError));
    }
}
