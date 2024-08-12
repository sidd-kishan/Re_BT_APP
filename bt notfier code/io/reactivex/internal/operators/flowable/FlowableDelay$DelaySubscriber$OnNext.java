/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.operators.flowable.FlowableDelay$DelaySubscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.operators.flowable.FlowableDelay;

final class FlowableDelay.DelaySubscriber.OnNext
implements Runnable {
    private final T t;
    final FlowableDelay.DelaySubscriber this$0;

    FlowableDelay.DelaySubscriber.OnNext(FlowableDelay.DelaySubscriber delaySubscriber, T t) {
        this.this$0 = delaySubscriber;
        this.t = t;
    }

    @Override
    public void run() {
        this.this$0.downstream.onNext(this.t);
    }
}
