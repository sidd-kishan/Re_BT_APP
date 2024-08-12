/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.internal.operators.flowable.FlowableTakeUntil$TakeUntilMainSubscriber
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.AtomicThrowable
 *  io.reactivex.internal.util.HalfSerializer
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.operators.flowable.FlowableTakeUntil;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

final class FlowableTakeUntil.TakeUntilMainSubscriber.OtherSubscriber
extends AtomicReference<Subscription>
implements FlowableSubscriber<Object> {
    private static final long serialVersionUID = -3592821756711087922L;
    final FlowableTakeUntil.TakeUntilMainSubscriber this$0;

    FlowableTakeUntil.TakeUntilMainSubscriber.OtherSubscriber(FlowableTakeUntil.TakeUntilMainSubscriber takeUntilMainSubscriber) {
        this.this$0 = takeUntilMainSubscriber;
    }

    public void onComplete() {
        SubscriptionHelper.cancel((AtomicReference)this.this$0.upstream);
        Subscriber subscriber = this.this$0.downstream;
        FlowableTakeUntil.TakeUntilMainSubscriber takeUntilMainSubscriber = this.this$0;
        HalfSerializer.onComplete((Subscriber)subscriber, (AtomicInteger)takeUntilMainSubscriber, (AtomicThrowable)takeUntilMainSubscriber.error);
    }

    public void onError(Throwable throwable) {
        SubscriptionHelper.cancel((AtomicReference)this.this$0.upstream);
        Subscriber subscriber = this.this$0.downstream;
        FlowableTakeUntil.TakeUntilMainSubscriber takeUntilMainSubscriber = this.this$0;
        HalfSerializer.onError((Subscriber)subscriber, (Throwable)throwable, (AtomicInteger)takeUntilMainSubscriber, (AtomicThrowable)takeUntilMainSubscriber.error);
    }

    public void onNext(Object object) {
        SubscriptionHelper.cancel((AtomicReference)this);
        this.onComplete();
    }

    public void onSubscribe(Subscription subscription) {
        SubscriptionHelper.setOnce((AtomicReference)this, (Subscription)subscription, (long)Long.MAX_VALUE);
    }
}
