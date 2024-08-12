/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream
 *  io.reactivex.internal.operators.flowable.FlowableWindow$WindowExactSubscriber
 *  io.reactivex.internal.operators.flowable.FlowableWindow$WindowOverlapSubscriber
 *  io.reactivex.internal.operators.flowable.FlowableWindow$WindowSkipSubscriber
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream;
import io.reactivex.internal.operators.flowable.FlowableWindow;
import org.reactivestreams.Subscriber;

public final class FlowableWindow<T>
extends AbstractFlowableWithUpstream<T, Flowable<T>> {
    final int bufferSize;
    final long size;
    final long skip;

    public FlowableWindow(Flowable<T> flowable, long l, long l2, int n) {
        super(flowable);
        this.size = l;
        this.skip = l2;
        this.bufferSize = n;
    }

    public void subscribeActual(Subscriber<? super Flowable<T>> subscriber) {
        long l = this.skip;
        long l2 = this.size;
        if (l == l2) {
            this.source.subscribe((FlowableSubscriber)new WindowExactSubscriber(subscriber, this.size, this.bufferSize));
        } else if (l > l2) {
            this.source.subscribe((FlowableSubscriber)new WindowSkipSubscriber(subscriber, this.size, this.skip, this.bufferSize));
        } else {
            this.source.subscribe((FlowableSubscriber)new WindowOverlapSubscriber(subscriber, this.size, this.skip, this.bufferSize));
        }
    }
}
