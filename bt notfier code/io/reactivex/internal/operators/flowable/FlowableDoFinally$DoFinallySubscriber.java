/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Action
 *  io.reactivex.internal.fuseable.QueueSubscription
 *  io.reactivex.internal.subscriptions.BasicIntQueueSubscription
 *  io.reactivex.internal.subscriptions.SubscriptionHelper
 *  io.reactivex.plugins.RxJavaPlugins
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableDoFinally.DoFinallySubscriber<T>
extends BasicIntQueueSubscription<T>
implements FlowableSubscriber<T> {
    private static final long serialVersionUID = 4109457741734051389L;
    final Subscriber<? super T> downstream;
    final Action onFinally;
    QueueSubscription<T> qs;
    boolean syncFused;
    Subscription upstream;

    FlowableDoFinally.DoFinallySubscriber(Subscriber<? super T> subscriber, Action action) {
        this.downstream = subscriber;
        this.onFinally = action;
    }

    public void cancel() {
        this.upstream.cancel();
        this.runFinally();
    }

    public void clear() {
        this.qs.clear();
    }

    public boolean isEmpty() {
        return this.qs.isEmpty();
    }

    public void onComplete() {
        this.downstream.onComplete();
        this.runFinally();
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
        this.runFinally();
    }

    public void onNext(T t) {
        this.downstream.onNext(t);
    }

    public void onSubscribe(Subscription subscription) {
        if (!SubscriptionHelper.validate((Subscription)this.upstream, (Subscription)subscription)) return;
        this.upstream = subscription;
        if (subscription instanceof QueueSubscription) {
            this.qs = (QueueSubscription)subscription;
        }
        this.downstream.onSubscribe((Subscription)this);
    }

    public T poll() throws Exception {
        Object object = this.qs.poll();
        if (object != null) return (T)object;
        if (!this.syncFused) return (T)object;
        this.runFinally();
        return (T)object;
    }

    public void request(long l) {
        this.upstream.request(l);
    }

    public int requestFusion(int n) {
        QueueSubscription<T> queueSubscription = this.qs;
        boolean bl = false;
        if (queueSubscription == null) return 0;
        if ((n & 4) != 0) return 0;
        if ((n = queueSubscription.requestFusion(n)) == 0) return n;
        if (n == 1) {
            bl = true;
        }
        this.syncFused = bl;
        return n;
    }

    void runFinally() {
        if (!this.compareAndSet(0, 1)) return;
        try {
            this.onFinally.run();
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }
}
