/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.BlockingHelper
 *  io.reactivex.internal.util.ExceptionHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class FutureSubscriber<T>
extends CountDownLatch
implements FlowableSubscriber<T>,
Future<T>,
Subscription {
    Throwable error;
    final AtomicReference<Subscription> upstream = new AtomicReference();
    T value;

    public FutureSubscriber() {
        super(1);
    }

    public void cancel() {
    }

    @Override
    public boolean cancel(boolean bl) {
        Subscription subscription;
        do {
            if ((subscription = this.upstream.get()) == this) return false;
            if (subscription != SubscriptionHelper.CANCELLED) continue;
            return false;
        } while (!this.upstream.compareAndSet(subscription, (Subscription)SubscriptionHelper.CANCELLED));
        if (subscription != null) {
            subscription.cancel();
        }
        this.countDown();
        return true;
    }

    @Override
    public T get() throws InterruptedException, ExecutionException {
        if (this.getCount() != 0L) {
            BlockingHelper.verifyNonBlocking();
            this.await();
        }
        if (this.isCancelled()) throw new CancellationException();
        Throwable throwable = this.error;
        if (throwable != null) throw new ExecutionException(throwable);
        return this.value;
    }

    @Override
    public T get(long l, TimeUnit object) throws InterruptedException, ExecutionException, TimeoutException {
        if (this.getCount() != 0L) {
            BlockingHelper.verifyNonBlocking();
            if (!this.await(l, (TimeUnit)((Object)object))) throw new TimeoutException(ExceptionHelper.timeoutMessage((long)l, (TimeUnit)((Object)object)));
        }
        if (this.isCancelled()) throw new CancellationException();
        object = this.error;
        if (object != null) throw new ExecutionException((Throwable)object);
        return this.value;
    }

    @Override
    public boolean isCancelled() {
        boolean bl = this.upstream.get() == SubscriptionHelper.CANCELLED;
        return bl;
    }

    @Override
    public boolean isDone() {
        boolean bl = this.getCount() == 0L;
        return bl;
    }

    public void onComplete() {
        Subscription subscription;
        if (this.value == null) {
            this.onError(new NoSuchElementException("The source is empty"));
            return;
        }
        do {
            if ((subscription = this.upstream.get()) == this) return;
            if (subscription == SubscriptionHelper.CANCELLED) return;
        } while (!this.upstream.compareAndSet(subscription, this));
        this.countDown();
    }

    public void onError(Throwable throwable) {
        Subscription subscription;
        while ((subscription = this.upstream.get()) != this && subscription != SubscriptionHelper.CANCELLED) {
            this.error = throwable;
            if (!this.upstream.compareAndSet(subscription, this)) continue;
            this.countDown();
            return;
        }
        RxJavaPlugins.onError((Throwable)throwable);
    }

    public void onNext(T t) {
        if (this.value != null) {
            this.upstream.get().cancel();
            this.onError(new IndexOutOfBoundsException("More than one element received"));
            return;
        }
        this.value = t;
    }

    public void onSubscribe(Subscription subscription) {
        SubscriptionHelper.setOnce(this.upstream, (Subscription)subscription, (long)Long.MAX_VALUE);
    }

    public void request(long l) {
    }
}
