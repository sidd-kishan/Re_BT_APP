/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.exceptions.CompositeException
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.internal.subscriptions.EmptySubscription
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class SafeSubscriber<T>
implements FlowableSubscriber<T>,
Subscription {
    boolean done;
    final Subscriber<? super T> downstream;
    Subscription upstream;

    public SafeSubscriber(Subscriber<? super T> subscriber) {
        this.downstream = subscriber;
    }

    public void cancel() {
        try {
            this.upstream.cancel();
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        if (this.upstream == null) {
            this.onCompleteNoSubscription();
            return;
        }
        try {
            this.downstream.onComplete();
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    void onCompleteNoSubscription() {
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.downstream.onSubscribe((Subscription)EmptySubscription.INSTANCE);
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            RxJavaPlugins.onError((Throwable)new CompositeException(new Throwable[]{nullPointerException, throwable}));
            return;
        }
        try {
            this.downstream.onError((Throwable)nullPointerException);
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            RxJavaPlugins.onError((Throwable)new CompositeException(new Throwable[]{nullPointerException, throwable}));
        }
    }

    public void onError(Throwable throwable) {
        if (this.done) {
            RxJavaPlugins.onError((Throwable)throwable);
            return;
        }
        this.done = true;
        if (this.upstream == null) {
            NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
            try {
                this.downstream.onSubscribe((Subscription)EmptySubscription.INSTANCE);
            }
            catch (Throwable throwable2) {
                Exceptions.throwIfFatal((Throwable)throwable2);
                RxJavaPlugins.onError((Throwable)new CompositeException(new Throwable[]{throwable, nullPointerException, throwable2}));
                return;
            }
            try {
                Subscriber<? super T> subscriber = this.downstream;
                CompositeException compositeException = new CompositeException(new Throwable[]{throwable, nullPointerException});
                subscriber.onError((Throwable)compositeException);
            }
            catch (Throwable throwable3) {
                Exceptions.throwIfFatal((Throwable)throwable3);
                RxJavaPlugins.onError((Throwable)new CompositeException(new Throwable[]{throwable, nullPointerException, throwable3}));
            }
            return;
        }
        Throwable throwable4 = throwable;
        if (throwable == null) {
            throwable4 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        try {
            this.downstream.onError(throwable4);
        }
        catch (Throwable throwable5) {
            Exceptions.throwIfFatal((Throwable)throwable5);
            RxJavaPlugins.onError((Throwable)new CompositeException(new Throwable[]{throwable4, throwable5}));
        }
    }

    public void onNext(T object) {
        if (this.done) {
            return;
        }
        if (this.upstream == null) {
            this.onNextNoSubscription();
            return;
        }
        if (object == null) {
            object = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
            try {
                this.upstream.cancel();
                this.onError((Throwable)object);
                return;
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                this.onError((Throwable)new CompositeException(new Throwable[]{object, throwable}));
                return;
            }
        }
        try {
            this.downstream.onNext(object);
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            try {
                this.upstream.cancel();
                this.onError(throwable);
            }
            catch (Throwable throwable2) {
                Exceptions.throwIfFatal((Throwable)throwable2);
                this.onError((Throwable)new CompositeException(new Throwable[]{throwable, throwable2}));
                return;
            }
        }
    }

    void onNextNoSubscription() {
        this.done = true;
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.downstream.onSubscribe((Subscription)EmptySubscription.INSTANCE);
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            RxJavaPlugins.onError((Throwable)new CompositeException(new Throwable[]{nullPointerException, throwable}));
            return;
        }
        try {
            this.downstream.onError((Throwable)nullPointerException);
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            RxJavaPlugins.onError((Throwable)new CompositeException(new Throwable[]{nullPointerException, throwable}));
        }
    }

    public void onSubscribe(Subscription subscription) {
        block4: {
            if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
            this.upstream = subscription;
            try {
                this.downstream.onSubscribe((Subscription)this);
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                this.done = true;
                try {
                    subscription.cancel();
                }
                catch (Throwable throwable2) {
                    Exceptions.throwIfFatal((Throwable)throwable2);
                    RxJavaPlugins.onError((Throwable)new CompositeException(new Throwable[]{throwable, throwable2}));
                    break block4;
                }
                RxJavaPlugins.onError((Throwable)throwable);
            }
        }
    }

    public void request(long l) {
        try {
            this.upstream.request(l);
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            try {
                this.upstream.cancel();
            }
            catch (Throwable throwable2) {
                Exceptions.throwIfFatal((Throwable)throwable2);
                RxJavaPlugins.onError((Throwable)new CompositeException(new Throwable[]{throwable, throwable2}));
                return;
            }
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }
}
