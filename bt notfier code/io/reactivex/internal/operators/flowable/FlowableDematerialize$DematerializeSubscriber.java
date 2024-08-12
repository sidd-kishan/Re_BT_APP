/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.Notification
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Notification;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableDematerialize.DematerializeSubscriber<T, R>
implements FlowableSubscriber<T>,
Subscription {
    boolean done;
    final Subscriber<? super R> downstream;
    final Function<? super T, ? extends Notification<R>> selector;
    Subscription upstream;

    FlowableDematerialize.DematerializeSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends Notification<R>> function) {
        this.downstream = subscriber;
        this.selector = function;
    }

    public void cancel() {
        this.upstream.cancel();
    }

    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        if (this.done) {
            RxJavaPlugins.onError((Throwable)throwable);
            return;
        }
        this.done = true;
        this.downstream.onError(throwable);
    }

    public void onNext(T object) {
        if (this.done) {
            if (!(object instanceof Notification)) return;
            if (!(object = (Notification)object).isOnError()) return;
            RxJavaPlugins.onError((Throwable)object.getError());
            return;
        }
        try {
            object = (Notification)ObjectHelper.requireNonNull((Object)this.selector.apply(object), (String)"The selector returned a null Notification");
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            this.upstream.cancel();
            this.onError(throwable);
            return;
        }
        if (object.isOnError()) {
            this.upstream.cancel();
            this.onError(object.getError());
        } else if (object.isOnComplete()) {
            this.upstream.cancel();
            this.onComplete();
        } else {
            this.downstream.onNext(object.getValue());
        }
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
        this.upstream = subscription;
        this.downstream.onSubscribe((Subscription)this);
    }

    public void request(long l) {
        this.upstream.request(l);
    }
}
