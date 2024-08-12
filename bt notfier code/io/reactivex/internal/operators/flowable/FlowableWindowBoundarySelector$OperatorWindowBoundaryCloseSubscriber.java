/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.operators.flowable.FlowableWindowBoundarySelector$WindowBoundaryMainSubscriber
 *  io.reactivex.plugins.RxJavaPlugins
 *  io.reactivex.processors.UnicastProcessor
 *  io.reactivex.subscribers.DisposableSubscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.operators.flowable.FlowableWindowBoundarySelector;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.processors.UnicastProcessor;
import io.reactivex.subscribers.DisposableSubscriber;

static final class FlowableWindowBoundarySelector.OperatorWindowBoundaryCloseSubscriber<T, V>
extends DisposableSubscriber<V> {
    boolean done;
    final FlowableWindowBoundarySelector.WindowBoundaryMainSubscriber<T, ?, V> parent;
    final UnicastProcessor<T> w;

    FlowableWindowBoundarySelector.OperatorWindowBoundaryCloseSubscriber(FlowableWindowBoundarySelector.WindowBoundaryMainSubscriber<T, ?, V> windowBoundaryMainSubscriber, UnicastProcessor<T> unicastProcessor) {
        this.parent = windowBoundaryMainSubscriber;
        this.w = unicastProcessor;
    }

    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        this.parent.close(this);
    }

    public void onError(Throwable throwable) {
        if (this.done) {
            RxJavaPlugins.onError((Throwable)throwable);
            return;
        }
        this.done = true;
        this.parent.error(throwable);
    }

    public void onNext(V v) {
        this.cancel();
        this.onComplete();
    }
}
