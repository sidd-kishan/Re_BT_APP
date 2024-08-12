/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.internal.operators.flowable.FlowableConcatMap$ConcatMapSupport
 *  io.reactivex.internal.subscriptions.SubscriptionArbiter
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.operators.flowable.FlowableConcatMap;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import org.reactivestreams.Subscription;

static final class FlowableConcatMap.ConcatMapInner<R>
extends SubscriptionArbiter
implements FlowableSubscriber<R> {
    private static final long serialVersionUID = 897683679971470653L;
    final FlowableConcatMap.ConcatMapSupport<R> parent;
    long produced;

    FlowableConcatMap.ConcatMapInner(FlowableConcatMap.ConcatMapSupport<R> concatMapSupport) {
        super(false);
        this.parent = concatMapSupport;
    }

    public void onComplete() {
        long l = this.produced;
        if (l != 0L) {
            this.produced = 0L;
            this.produced(l);
        }
        this.parent.innerComplete();
    }

    public void onError(Throwable throwable) {
        long l = this.produced;
        if (l != 0L) {
            this.produced = 0L;
            this.produced(l);
        }
        this.parent.innerError(throwable);
    }

    public void onNext(R r) {
        ++this.produced;
        this.parent.innerNext(r);
    }

    public void onSubscribe(Subscription subscription) {
        this.setSubscription(subscription);
    }
}
