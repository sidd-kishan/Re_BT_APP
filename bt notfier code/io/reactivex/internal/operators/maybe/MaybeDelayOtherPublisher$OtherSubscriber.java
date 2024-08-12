/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.MaybeObserver
 *  io.reactivex.exceptions.CompositeException
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

static final class MaybeDelayOtherPublisher.OtherSubscriber<T>
extends AtomicReference<Subscription>
implements FlowableSubscriber<Object> {
    private static final long serialVersionUID = -1215060610805418006L;
    final MaybeObserver<? super T> downstream;
    Throwable error;
    T value;

    MaybeDelayOtherPublisher.OtherSubscriber(MaybeObserver<? super T> maybeObserver) {
        this.downstream = maybeObserver;
    }

    public void onComplete() {
        Throwable throwable = this.error;
        if (throwable != null) {
            this.downstream.onError(throwable);
        } else {
            throwable = this.value;
            if (throwable != null) {
                this.downstream.onSuccess((Object)throwable);
            } else {
                this.downstream.onComplete();
            }
        }
    }

    public void onError(Throwable throwable) {
        Throwable throwable2 = this.error;
        if (throwable2 == null) {
            this.downstream.onError(throwable);
        } else {
            this.downstream.onError((Throwable)new CompositeException(new Throwable[]{throwable2, throwable}));
        }
    }

    public void onNext(Object object) {
        object = (Subscription)this.get();
        if (object == SubscriptionHelper.CANCELLED) return;
        this.lazySet(SubscriptionHelper.CANCELLED);
        object.cancel();
        this.onComplete();
    }

    public void onSubscribe(Subscription subscription) {
        SubscriptionHelper.setOnce((AtomicReference)this, (Subscription)subscription, (long)Long.MAX_VALUE);
    }
}
