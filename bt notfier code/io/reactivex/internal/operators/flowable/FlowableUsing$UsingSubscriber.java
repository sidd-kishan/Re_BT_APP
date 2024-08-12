/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.exceptions.CompositeException
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Consumer
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableUsing.UsingSubscriber<T, D>
extends AtomicBoolean
implements FlowableSubscriber<T>,
Subscription {
    private static final long serialVersionUID = 5904473792286235046L;
    final Consumer<? super D> disposer;
    final Subscriber<? super T> downstream;
    final boolean eager;
    final D resource;
    Subscription upstream;

    FlowableUsing.UsingSubscriber(Subscriber<? super T> subscriber, D d, Consumer<? super D> consumer, boolean bl) {
        this.downstream = subscriber;
        this.resource = d;
        this.disposer = consumer;
        this.eager = bl;
    }

    public void cancel() {
        this.disposeAfter();
        this.upstream.cancel();
    }

    void disposeAfter() {
        if (!this.compareAndSet(false, true)) return;
        try {
            this.disposer.accept(this.resource);
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void onComplete() {
        if (this.eager) {
            if (this.compareAndSet(false, true)) {
                try {
                    this.disposer.accept(this.resource);
                }
                catch (Throwable throwable) {
                    Exceptions.throwIfFatal((Throwable)throwable);
                    this.downstream.onError(throwable);
                    return;
                }
            }
            this.upstream.cancel();
            this.downstream.onComplete();
        } else {
            this.downstream.onComplete();
            this.upstream.cancel();
            this.disposeAfter();
        }
    }

    public void onError(Throwable throwable) {
        if (this.eager) {
            Object var3_2;
            Object var2_3 = var3_2 = null;
            if (this.compareAndSet(false, true)) {
                try {
                    this.disposer.accept(this.resource);
                    var2_3 = var3_2;
                }
                catch (Throwable throwable2) {
                    Exceptions.throwIfFatal((Throwable)throwable2);
                }
            }
            this.upstream.cancel();
            if (var2_3 != null) {
                this.downstream.onError((Throwable)new CompositeException(new Throwable[]{throwable, var2_3}));
            } else {
                this.downstream.onError(throwable);
            }
        } else {
            this.downstream.onError(throwable);
            this.upstream.cancel();
            this.disposeAfter();
        }
    }

    public void onNext(T t) {
        this.downstream.onNext(t);
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
