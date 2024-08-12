/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.operators.flowable.FlowableWindowBoundarySelector$WindowBoundaryMainSubscriber
 *  io.reactivex.subscribers.DisposableSubscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.operators.flowable.FlowableWindowBoundarySelector;
import io.reactivex.subscribers.DisposableSubscriber;

static final class FlowableWindowBoundarySelector.OperatorWindowBoundaryOpenSubscriber<T, B>
extends DisposableSubscriber<B> {
    final FlowableWindowBoundarySelector.WindowBoundaryMainSubscriber<T, B, ?> parent;

    FlowableWindowBoundarySelector.OperatorWindowBoundaryOpenSubscriber(FlowableWindowBoundarySelector.WindowBoundaryMainSubscriber<T, B, ?> windowBoundaryMainSubscriber) {
        this.parent = windowBoundaryMainSubscriber;
    }

    public void onComplete() {
        this.parent.onComplete();
    }

    public void onError(Throwable throwable) {
        this.parent.error(throwable);
    }

    public void onNext(B b) {
        this.parent.open(b);
    }
}
