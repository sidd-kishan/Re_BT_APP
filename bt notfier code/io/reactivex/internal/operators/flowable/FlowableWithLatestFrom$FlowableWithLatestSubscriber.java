/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.internal.operators.flowable.FlowableWithLatestFrom
 *  io.reactivex.internal.operators.flowable.FlowableWithLatestFrom$WithLatestFromSubscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.operators.flowable.FlowableWithLatestFrom;
import org.reactivestreams.Subscription;

final class FlowableWithLatestFrom.FlowableWithLatestSubscriber
implements FlowableSubscriber<U> {
    final FlowableWithLatestFrom this$0;
    private final FlowableWithLatestFrom.WithLatestFromSubscriber<T, U, R> wlf;

    FlowableWithLatestFrom.FlowableWithLatestSubscriber(FlowableWithLatestFrom flowableWithLatestFrom, FlowableWithLatestFrom.WithLatestFromSubscriber<T, U, R> withLatestFromSubscriber) {
        this.this$0 = flowableWithLatestFrom;
        this.wlf = withLatestFromSubscriber;
    }

    public void onComplete() {
    }

    public void onError(Throwable throwable) {
        this.wlf.otherError(throwable);
    }

    public void onNext(U u) {
        this.wlf.lazySet(u);
    }

    public void onSubscribe(Subscription subscription) {
        if (!this.wlf.setOther(subscription)) return;
        subscription.request(Long.MAX_VALUE);
    }
}
