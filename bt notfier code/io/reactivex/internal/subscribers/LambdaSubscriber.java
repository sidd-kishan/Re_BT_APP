/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.CompositeException
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Action
 *  io.reactivex.functions.Consumer
 *  io.reactivex.internal.functions.Functions
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.observers.LambdaConsumerIntrospection
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.observers.LambdaConsumerIntrospection;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class LambdaSubscriber<T>
extends AtomicReference<Subscription>
implements FlowableSubscriber<T>,
Subscription,
Disposable,
LambdaConsumerIntrospection {
    private static final long serialVersionUID = -7251123623727029452L;
    final Action onComplete;
    final Consumer<? super Throwable> onError;
    final Consumer<? super T> onNext;
    final Consumer<? super Subscription> onSubscribe;

    public LambdaSubscriber(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Consumer<? super Subscription> consumer3) {
        this.onNext = consumer;
        this.onError = consumer2;
        this.onComplete = action;
        this.onSubscribe = consumer3;
    }

    public void cancel() {
        SubscriptionHelper.cancel((AtomicReference)this);
    }

    public void dispose() {
        this.cancel();
    }

    public boolean hasCustomOnError() {
        boolean bl = this.onError != Functions.ON_ERROR_MISSING;
        return bl;
    }

    public boolean isDisposed() {
        boolean bl = this.get() == SubscriptionHelper.CANCELLED;
        return bl;
    }

    public void onComplete() {
        if (this.get() == SubscriptionHelper.CANCELLED) return;
        this.lazySet(SubscriptionHelper.CANCELLED);
        try {
            this.onComplete.run();
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void onError(Throwable throwable) {
        if (this.get() != SubscriptionHelper.CANCELLED) {
            this.lazySet(SubscriptionHelper.CANCELLED);
            try {
                this.onError.accept((Object)throwable);
            }
            catch (Throwable throwable2) {
                Exceptions.throwIfFatal((Throwable)throwable2);
                RxJavaPlugins.onError((Throwable)new CompositeException(new Throwable[]{throwable, throwable2}));
            }
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void onNext(T t) {
        if (this.isDisposed()) return;
        try {
            this.onNext.accept(t);
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            ((Subscription)this.get()).cancel();
            this.onError(throwable);
        }
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.setOnce((AtomicReference)this, (Subscription)subscription)) return;
        try {
            this.onSubscribe.accept((Object)this);
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            subscription.cancel();
            this.onError(throwable);
        }
    }

    public void request(long l) {
        ((Subscription)this.get()).request(l);
    }
}
