/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.exceptions.CompositeException
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.internal.operators.parallel.ParallelPeek
 *  io.reactivex.internal.subscriptions.EmptySubscription
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.parallel;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.operators.parallel.ParallelPeek;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class ParallelPeek.ParallelPeekSubscriber<T>
implements FlowableSubscriber<T>,
Subscription {
    boolean done;
    final Subscriber<? super T> downstream;
    final ParallelPeek<T> parent;
    Subscription upstream;

    ParallelPeek.ParallelPeekSubscriber(Subscriber<? super T> subscriber, ParallelPeek<T> parallelPeek) {
        this.downstream = subscriber;
        this.parent = parallelPeek;
    }

    public void cancel() {
        try {
            this.parent.onCancel.run();
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            RxJavaPlugins.onError((Throwable)throwable);
        }
        this.upstream.cancel();
    }

    public void onComplete() {
        block4: {
            if (this.done) return;
            this.done = true;
            try {
                this.parent.onComplete.run();
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                this.downstream.onError(throwable);
                break block4;
            }
            this.downstream.onComplete();
            try {
                this.parent.onAfterTerminated.run();
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                RxJavaPlugins.onError((Throwable)throwable);
            }
        }
    }

    public void onError(Throwable throwable) {
        if (this.done) {
            RxJavaPlugins.onError((Throwable)throwable);
            return;
        }
        this.done = true;
        try {
            this.parent.onError.accept((Object)throwable);
        }
        catch (Throwable throwable2) {
            Exceptions.throwIfFatal((Throwable)throwable2);
            throwable = new CompositeException(new Throwable[]{throwable, throwable2});
        }
        this.downstream.onError(throwable);
        try {
            this.parent.onAfterTerminated.run();
        }
        catch (Throwable throwable3) {
            Exceptions.throwIfFatal((Throwable)throwable3);
            RxJavaPlugins.onError((Throwable)throwable3);
        }
    }

    public void onNext(T t) {
        block4: {
            if (this.done) return;
            try {
                this.parent.onNext.accept(t);
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                this.onError(throwable);
                break block4;
            }
            this.downstream.onNext(t);
            try {
                this.parent.onAfterNext.accept(t);
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                this.onError(throwable);
            }
        }
    }

    public void onSubscribe(Subscription subscription) {
        block2: {
            if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
            this.upstream = subscription;
            try {
                this.parent.onSubscribe.accept((Object)subscription);
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                subscription.cancel();
                this.downstream.onSubscribe((Subscription)EmptySubscription.INSTANCE);
                this.onError(throwable);
                break block2;
            }
            this.downstream.onSubscribe((Subscription)this);
        }
    }

    public void request(long l) {
        try {
            this.parent.onRequest.accept(l);
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            RxJavaPlugins.onError((Throwable)throwable);
        }
        this.upstream.request(l);
    }
}
