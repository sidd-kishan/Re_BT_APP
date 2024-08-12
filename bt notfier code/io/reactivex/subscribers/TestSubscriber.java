/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.functions.Consumer
 *  io.reactivex.internal.fuseable.QueueSubscription
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.internal.util.ExceptionHelper
 *  io.reactivex.observers.BaseTestConsumer
 *  io.reactivex.subscribers.TestSubscriber$EmptySubscriber
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observers.BaseTestConsumer;
import io.reactivex.subscribers.TestSubscriber;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class TestSubscriber<T>
extends BaseTestConsumer<T, TestSubscriber<T>>
implements FlowableSubscriber<T>,
Subscription,
Disposable {
    private volatile boolean cancelled;
    private final Subscriber<? super T> downstream;
    private final AtomicLong missedRequested;
    private QueueSubscription<T> qs;
    private final AtomicReference<Subscription> upstream;

    public TestSubscriber() {
        this((Subscriber<T>)EmptySubscriber.INSTANCE, Long.MAX_VALUE);
    }

    public TestSubscriber(long l) {
        this((Subscriber<T>)EmptySubscriber.INSTANCE, l);
    }

    public TestSubscriber(Subscriber<? super T> subscriber) {
        this(subscriber, Long.MAX_VALUE);
    }

    public TestSubscriber(Subscriber<? super T> subscriber, long l) {
        if (l < 0L) throw new IllegalArgumentException("Negative initial request not allowed");
        this.downstream = subscriber;
        this.upstream = new AtomicReference();
        this.missedRequested = new AtomicLong(l);
    }

    public static <T> TestSubscriber<T> create() {
        return new TestSubscriber<T>();
    }

    public static <T> TestSubscriber<T> create(long l) {
        return new TestSubscriber<T>(l);
    }

    public static <T> TestSubscriber<T> create(Subscriber<? super T> subscriber) {
        return new TestSubscriber<T>(subscriber);
    }

    static String fusionModeToString(int n) {
        if (n == 0) return "NONE";
        if (n == 1) return "SYNC";
        if (n == 2) return "ASYNC";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown(");
        stringBuilder.append(n);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    final TestSubscriber<T> assertFuseable() {
        if (this.qs == null) throw new AssertionError((Object)"Upstream is not fuseable.");
        return this;
    }

    final TestSubscriber<T> assertFusionMode(int n) {
        int n2 = this.establishedFusionMode;
        if (n2 == n) return this;
        if (this.qs == null) throw this.fail("Upstream is not fuseable");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fusion mode different. Expected: ");
        stringBuilder.append(TestSubscriber.fusionModeToString(n));
        stringBuilder.append(", actual: ");
        stringBuilder.append(TestSubscriber.fusionModeToString(n2));
        throw new AssertionError((Object)stringBuilder.toString());
    }

    final TestSubscriber<T> assertNotFuseable() {
        if (this.qs != null) throw new AssertionError((Object)"Upstream is fuseable.");
        return this;
    }

    public final TestSubscriber<T> assertNotSubscribed() {
        if (this.upstream.get() != null) throw this.fail("Subscribed!");
        if (!this.errors.isEmpty()) throw this.fail("Not subscribed but errors found");
        return this;
    }

    public final TestSubscriber<T> assertOf(Consumer<? super TestSubscriber<T>> consumer) {
        try {
            consumer.accept((Object)this);
            return this;
        }
        catch (Throwable throwable) {
            throw ExceptionHelper.wrapOrThrow((Throwable)throwable);
        }
    }

    public final TestSubscriber<T> assertSubscribed() {
        if (this.upstream.get() == null) throw this.fail("Not subscribed!");
        return this;
    }

    public final void cancel() {
        if (this.cancelled) return;
        this.cancelled = true;
        SubscriptionHelper.cancel(this.upstream);
    }

    public final void dispose() {
        this.cancel();
    }

    public final boolean hasSubscription() {
        boolean bl = this.upstream.get() != null;
        return bl;
    }

    public final boolean isCancelled() {
        return this.cancelled;
    }

    public final boolean isDisposed() {
        return this.cancelled;
    }

    public void onComplete() {
        if (!this.checkSubscriptionOnce) {
            this.checkSubscriptionOnce = true;
            if (this.upstream.get() == null) {
                this.errors.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.lastThread = Thread.currentThread();
            ++this.completions;
            this.downstream.onComplete();
            return;
        }
        finally {
            this.done.countDown();
        }
    }

    public void onError(Throwable throwable) {
        if (!this.checkSubscriptionOnce) {
            this.checkSubscriptionOnce = true;
            if (this.upstream.get() == null) {
                this.errors.add(new NullPointerException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.lastThread = Thread.currentThread();
            this.errors.add(throwable);
            if (throwable == null) {
                List list = this.errors;
                IllegalStateException illegalStateException = new IllegalStateException("onError received a null Throwable");
                list.add(illegalStateException);
            }
            this.downstream.onError(throwable);
            return;
        }
        finally {
            this.done.countDown();
        }
    }

    public void onNext(T object) {
        if (!this.checkSubscriptionOnce) {
            this.checkSubscriptionOnce = true;
            if (this.upstream.get() == null) {
                this.errors.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        this.lastThread = Thread.currentThread();
        if (this.establishedFusionMode == 2) {
            try {
                while ((object = this.qs.poll()) != null) {
                    this.values.add(object);
                }
                return;
            }
            catch (Throwable throwable) {
                this.errors.add(throwable);
                this.qs.cancel();
            }
            return;
        }
        this.values.add(object);
        if (object == null) {
            this.errors.add(new NullPointerException("onNext received a null value"));
        }
        this.downstream.onNext(object);
    }

    protected void onStart() {
    }

    public void onSubscribe(Subscription object) {
        this.lastThread = Thread.currentThread();
        if (object == null) {
            this.errors.add(new NullPointerException("onSubscribe received a null Subscription"));
            return;
        }
        if (!this.upstream.compareAndSet((Subscription)null, (Subscription)object)) {
            object.cancel();
            if (this.upstream.get() == SubscriptionHelper.CANCELLED) return;
            List list = this.errors;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onSubscribe received multiple subscriptions: ");
            stringBuilder.append(object);
            list.add(new IllegalStateException(stringBuilder.toString()));
            return;
        }
        if (this.initialFusionMode != 0 && object instanceof QueueSubscription) {
            int n;
            QueueSubscription queueSubscription;
            this.qs = queueSubscription = (QueueSubscription)object;
            this.establishedFusionMode = n = queueSubscription.requestFusion(this.initialFusionMode);
            if (n == 1) {
                this.checkSubscriptionOnce = true;
                this.lastThread = Thread.currentThread();
                try {
                    while ((object = this.qs.poll()) != null) {
                        this.values.add(object);
                    }
                    ++this.completions;
                }
                catch (Throwable throwable) {
                    this.errors.add(throwable);
                }
                return;
            }
        }
        this.downstream.onSubscribe(object);
        long l = this.missedRequested.getAndSet(0L);
        if (l != 0L) {
            object.request(l);
        }
        this.onStart();
    }

    public final void request(long l) {
        SubscriptionHelper.deferredRequest(this.upstream, (AtomicLong)this.missedRequested, (long)l);
    }

    public final TestSubscriber<T> requestMore(long l) {
        this.request(l);
        return this;
    }

    final TestSubscriber<T> setInitialFusionMode(int n) {
        this.initialFusionMode = n;
        return this;
    }
}
