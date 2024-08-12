/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.functions.Action
 *  io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream
 *  io.reactivex.internal.operators.flowable.FlowableOnBackpressureBuffer$BackpressureBufferSubscriber
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.functions.Action;
import io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureBuffer;
import org.reactivestreams.Subscriber;

public final class FlowableOnBackpressureBuffer<T>
extends AbstractFlowableWithUpstream<T, T> {
    final int bufferSize;
    final boolean delayError;
    final Action onOverflow;
    final boolean unbounded;

    public FlowableOnBackpressureBuffer(Flowable<T> flowable, int n, boolean bl, boolean bl2, Action action) {
        super(flowable);
        this.bufferSize = n;
        this.unbounded = bl;
        this.delayError = bl2;
        this.onOverflow = action;
    }

    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber)new BackpressureBufferSubscriber(subscriber, this.bufferSize, this.unbounded, this.delayError, this.onOverflow));
    }
}
