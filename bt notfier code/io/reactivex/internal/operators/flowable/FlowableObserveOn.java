/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.Scheduler
 *  io.reactivex.Scheduler$Worker
 *  io.reactivex.internal.fuseable.ConditionalSubscriber
 *  io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream
 *  io.reactivex.internal.operators.flowable.FlowableObserveOn$ObserveOnConditionalSubscriber
 *  io.reactivex.internal.operators.flowable.FlowableObserveOn$ObserveOnSubscriber
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream;
import io.reactivex.internal.operators.flowable.FlowableObserveOn;
import org.reactivestreams.Subscriber;

public final class FlowableObserveOn<T>
extends AbstractFlowableWithUpstream<T, T> {
    final boolean delayError;
    final int prefetch;
    final Scheduler scheduler;

    public FlowableObserveOn(Flowable<T> flowable, Scheduler scheduler, boolean bl, int n) {
        super(flowable);
        this.scheduler = scheduler;
        this.delayError = bl;
        this.prefetch = n;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        Scheduler.Worker worker = this.scheduler.createWorker();
        if (subscriber instanceof ConditionalSubscriber) {
            this.source.subscribe((FlowableSubscriber)new ObserveOnConditionalSubscriber((ConditionalSubscriber)subscriber, worker, this.delayError, this.prefetch));
        } else {
            this.source.subscribe((FlowableSubscriber)new ObserveOnSubscriber(subscriber, worker, this.delayError, this.prefetch));
        }
    }
}
