/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.BiFunction
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableZipIterable.ZipIterableSubscriber<T, U, V>
implements FlowableSubscriber<T>,
Subscription {
    boolean done;
    final Subscriber<? super V> downstream;
    final Iterator<U> iterator;
    Subscription upstream;
    final BiFunction<? super T, ? super U, ? extends V> zipper;

    FlowableZipIterable.ZipIterableSubscriber(Subscriber<? super V> subscriber, Iterator<U> iterator, BiFunction<? super T, ? super U, ? extends V> biFunction) {
        this.downstream = subscriber;
        this.iterator = iterator;
        this.zipper = biFunction;
    }

    public void cancel() {
        this.upstream.cancel();
    }

    void error(Throwable throwable) {
        Exceptions.throwIfFatal((Throwable)throwable);
        this.done = true;
        this.upstream.cancel();
        this.downstream.onError(throwable);
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
        Object object2;
        if (this.done) {
            return;
        }
        try {
            object2 = ObjectHelper.requireNonNull(this.iterator.next(), (String)"The iterator returned a null value");
        }
        catch (Throwable throwable) {
            this.error(throwable);
            return;
        }
        try {
            object = ObjectHelper.requireNonNull((Object)this.zipper.apply(object, object2), (String)"The zipper function returned a null value");
        }
        catch (Throwable throwable) {
            this.error(throwable);
            return;
        }
        this.downstream.onNext(object);
        try {
            boolean bl = this.iterator.hasNext();
            if (bl) return;
            this.done = true;
        }
        catch (Throwable throwable) {
            this.error(throwable);
            return;
        }
        this.upstream.cancel();
        this.downstream.onComplete();
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
