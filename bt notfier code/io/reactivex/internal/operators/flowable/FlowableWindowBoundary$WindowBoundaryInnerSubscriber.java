/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.operators.flowable.FlowableWindowBoundary$WindowBoundaryMainSubscriber
 *  io.reactivex.plugins.RxJavaPlugins
 *  io.reactivex.subscribers.DisposableSubscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.operators.flowable.FlowableWindowBoundary;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subscribers.DisposableSubscriber;

static final class FlowableWindowBoundary.WindowBoundaryInnerSubscriber<T, B>
extends DisposableSubscriber<B> {
    boolean done;
    final FlowableWindowBoundary.WindowBoundaryMainSubscriber<T, B> parent;

    FlowableWindowBoundary.WindowBoundaryInnerSubscriber(FlowableWindowBoundary.WindowBoundaryMainSubscriber<T, B> windowBoundaryMainSubscriber) {
        this.parent = windowBoundaryMainSubscriber;
    }

    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        this.parent.innerComplete();
    }

    public void onError(Throwable throwable) {
        if (this.done) {
            RxJavaPlugins.onError((Throwable)throwable);
            return;
        }
        this.done = true;
        this.parent.innerError(throwable);
    }

    public void onNext(B b) {
        if (this.done) {
            return;
        }
        this.parent.innerNext();
    }
}
