/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Flowable
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream
 *  io.reactivex.internal.operators.flowable.FlowableWindowBoundarySupplier$WindowBoundaryMainSubscriber
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.operators.flowable.AbstractFlowableWithUpstream;
import io.reactivex.internal.operators.flowable.FlowableWindowBoundarySupplier;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class FlowableWindowBoundarySupplier<T, B>
extends AbstractFlowableWithUpstream<T, Flowable<T>> {
    final int capacityHint;
    final Callable<? extends Publisher<B>> other;

    public FlowableWindowBoundarySupplier(Flowable<T> flowable, Callable<? extends Publisher<B>> callable, int n) {
        super(flowable);
        this.other = callable;
        this.capacityHint = n;
    }

    protected void subscribeActual(Subscriber<? super Flowable<T>> windowBoundaryMainSubscriber) {
        windowBoundaryMainSubscriber = new WindowBoundaryMainSubscriber(windowBoundaryMainSubscriber, this.capacityHint, this.other);
        this.source.subscribe((FlowableSubscriber)windowBoundaryMainSubscriber);
    }
}
