/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.operators.flowable.FlowableDelay$DelaySubscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.operators.flowable.FlowableDelay;

final class FlowableDelay.DelaySubscriber.OnComplete
implements Runnable {
    final FlowableDelay.DelaySubscriber this$0;

    FlowableDelay.DelaySubscriber.OnComplete(FlowableDelay.DelaySubscriber delaySubscriber) {
        this.this$0 = delaySubscriber;
    }

    @Override
    public void run() {
        try {
            this.this$0.downstream.onComplete();
            return;
        }
        finally {
            this.this$0.w.dispose();
        }
    }
}
