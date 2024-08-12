/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.internal.operators.flowable.FlowableSkipUntil$SkipUntilMainSubscriber
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.AtomicThrowable
 *  io.reactivex.internal.util.HalfSerializer
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.operators.flowable.FlowableSkipUntil;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

final class FlowableSkipUntil.SkipUntilMainSubscriber.OtherSubscriber
extends AtomicReference<Subscription>
implements FlowableSubscriber<Object> {
    private static final long serialVersionUID = -5592042965931999169L;
    final FlowableSkipUntil.SkipUntilMainSubscriber this$0;

    FlowableSkipUntil.SkipUntilMainSubscriber.OtherSubscriber(FlowableSkipUntil.SkipUntilMainSubscriber skipUntilMainSubscriber) {
        this.this$0 = skipUntilMainSubscriber;
    }

    public void onComplete() {
        this.this$0.gate = true;
    }

    public void onError(Throwable throwable) {
        SubscriptionHelper.cancel((AtomicReference)this.this$0.upstream);
        Subscriber subscriber = this.this$0.downstream;
        FlowableSkipUntil.SkipUntilMainSubscriber skipUntilMainSubscriber = this.this$0;
        HalfSerializer.onError((Subscriber)subscriber, (Throwable)throwable, (AtomicInteger)skipUntilMainSubscriber, (AtomicThrowable)skipUntilMainSubscriber.error);
    }

    public void onNext(Object object) {
        this.this$0.gate = true;
        ((Subscription)this.get()).cancel();
    }

    public void onSubscribe(Subscription subscription) {
        SubscriptionHelper.setOnce((AtomicReference)this, (Subscription)subscription, (long)Long.MAX_VALUE);
    }
}
