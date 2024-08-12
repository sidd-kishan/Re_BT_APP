/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.operators.flowable.FlowableDelay$DelaySubscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.operators.flowable.FlowableDelay;

final class FlowableDelay.DelaySubscriber.OnError
implements Runnable {
    private final Throwable t;
    final FlowableDelay.DelaySubscriber this$0;

    FlowableDelay.DelaySubscriber.OnError(FlowableDelay.DelaySubscriber delaySubscriber, Throwable throwable) {
        this.this$0 = delaySubscriber;
        this.t = throwable;
    }

    @Override
    public void run() {
        try {
            this.this$0.downstream.onError(this.t);
            return;
        }
        finally {
            this.this$0.w.dispose();
        }
    }
}
