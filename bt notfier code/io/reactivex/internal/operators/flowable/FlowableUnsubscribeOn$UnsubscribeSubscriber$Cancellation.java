/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.operators.flowable.FlowableUnsubscribeOn$UnsubscribeSubscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.operators.flowable.FlowableUnsubscribeOn;

final class FlowableUnsubscribeOn.UnsubscribeSubscriber.Cancellation
implements Runnable {
    final FlowableUnsubscribeOn.UnsubscribeSubscriber this$0;

    FlowableUnsubscribeOn.UnsubscribeSubscriber.Cancellation(FlowableUnsubscribeOn.UnsubscribeSubscriber unsubscribeSubscriber) {
        this.this$0 = unsubscribeSubscriber;
    }

    @Override
    public void run() {
        this.this$0.upstream.cancel();
    }
}
