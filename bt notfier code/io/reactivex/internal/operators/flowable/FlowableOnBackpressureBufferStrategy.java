/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.BackpressureOverflowStrategy
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.functions.Action
 *  io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream
 *  io.reactivex.internal.operators.flowable.FlowableOnBackpressureBufferStrategy$OnBackpressureBufferStrategySubscriber
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.BackpressureOverflowStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.Action;
import io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureBufferStrategy;
import org.reactivestreams.Subscriber;

public final class FlowableOnBackpressureBufferStrategy<T>
extends AbstractFlowableWithUpstream<T, T> {
    final long bufferSize;
    final Action onOverflow;
    final BackpressureOverflowStrategy strategy;

    public FlowableOnBackpressureBufferStrategy(Flowable<T> flowable, long l, Action action, BackpressureOverflowStrategy backpressureOverflowStrategy) {
        super(flowable);
        this.bufferSize = l;
        this.onOverflow = action;
        this.strategy = backpressureOverflowStrategy;
    }

    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber)new OnBackpressureBufferStrategySubscriber(subscriber, this.onOverflow, this.strategy, this.bufferSize));
    }
}
