/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.internal.operators.flowable.FlowableDelaySubscriptionOther$MainSubscriber
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.operators.flowable.FlowableDelaySubscriptionOther;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

final class FlowableDelaySubscriptionOther.MainSubscriber.OtherSubscriber
extends AtomicReference<Subscription>
implements FlowableSubscriber<Object> {
    private static final long serialVersionUID = -3892798459447644106L;
    final FlowableDelaySubscriptionOther.MainSubscriber this$0;

    FlowableDelaySubscriptionOther.MainSubscriber.OtherSubscriber(FlowableDelaySubscriptionOther.MainSubscriber mainSubscriber) {
        this.this$0 = mainSubscriber;
    }

    public void onComplete() {
        if ((Subscription)this.get() == SubscriptionHelper.CANCELLED) return;
        this.this$0.next();
    }

    public void onError(Throwable throwable) {
        if ((Subscription)this.get() != SubscriptionHelper.CANCELLED) {
            this.this$0.downstream.onError(throwable);
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void onNext(Object object) {
        object = (Subscription)this.get();
        if (object == SubscriptionHelper.CANCELLED) return;
        this.lazySet(SubscriptionHelper.CANCELLED);
        object.cancel();
        this.this$0.next();
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.setOnce((AtomicReference)this, (Subscription)subscription)) return;
        subscription.request(Long.MAX_VALUE);
    }
}
