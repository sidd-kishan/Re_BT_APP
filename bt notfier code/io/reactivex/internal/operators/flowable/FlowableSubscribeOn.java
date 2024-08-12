/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.Scheduler
 *  io.reactivex.Scheduler$Worker
 *  io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream
 *  io.reactivex.internal.operators.flowable.FlowableSubscribeOn$SubscribeOnSubscriber
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream;
import io.reactivex.internal.operators.flowable.FlowableSubscribeOn;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSubscribeOn<T>
extends AbstractFlowableWithUpstream<T, T> {
    final boolean nonScheduledRequests;
    final Scheduler scheduler;

    public FlowableSubscribeOn(Flowable<T> flowable, Scheduler scheduler, boolean bl) {
        super(flowable);
        this.scheduler = scheduler;
        this.nonScheduledRequests = bl;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        Scheduler.Worker worker = this.scheduler.createWorker();
        SubscribeOnSubscriber subscribeOnSubscriber = new SubscribeOnSubscriber(subscriber, worker, (Publisher)this.source, this.nonScheduledRequests);
        subscriber.onSubscribe((Subscription)subscribeOnSubscriber);
        worker.schedule((Runnable)subscribeOnSubscriber);
    }
}
