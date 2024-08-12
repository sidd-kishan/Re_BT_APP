/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.FlowableSubscriber
 *  io.reactivex.exceptions.CompositeException
 *  io.reactivex.internal.subscriptions.SubscriptionArbiter
 *  org.reactivestreams.Publisher
 *  org.reactivestreams.Subscriber
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

static final class FlowableConcatArray.ConcatArraySubscriber<T>
extends SubscriptionArbiter
implements FlowableSubscriber<T> {
    private static final long serialVersionUID = -8158322871608889516L;
    final boolean delayError;
    final Subscriber<? super T> downstream;
    List<Throwable> errors;
    int index;
    long produced;
    final Publisher<? extends T>[] sources;
    final AtomicInteger wip;

    FlowableConcatArray.ConcatArraySubscriber(Publisher<? extends T>[] publisherArray, boolean bl, Subscriber<? super T> subscriber) {
        super(false);
        this.downstream = subscriber;
        this.sources = publisherArray;
        this.delayError = bl;
        this.wip = new AtomicInteger();
    }

    public void onComplete() {
        if (this.wip.getAndIncrement() != 0) return;
        Publisher<? extends T>[] publisherArray = this.sources;
        int n = publisherArray.length;
        int n2 = this.index;
        while (true) {
            List<Throwable> list;
            if (n2 == n) {
                list = this.errors;
                if (list != null) {
                    if (list.size() == 1) {
                        this.downstream.onError(list.get(0));
                        break;
                    }
                    this.downstream.onError((Throwable)new CompositeException(list));
                    break;
                }
                this.downstream.onComplete();
                break;
            }
            list = publisherArray[n2];
            if (list == null) {
                List<Throwable> list2;
                NullPointerException nullPointerException = new NullPointerException("A Publisher entry is null");
                if (!this.delayError) {
                    this.downstream.onError((Throwable)nullPointerException);
                    return;
                }
                list = list2 = this.errors;
                if (list2 == null) {
                    this.errors = list = new ArrayList<Throwable>(n - n2 + 1);
                }
                list.add(nullPointerException);
                ++n2;
                continue;
            }
            long l = this.produced;
            if (l != 0L) {
                this.produced = 0L;
                this.produced(l);
            }
            list.subscribe((Subscriber)this);
            this.index = ++n2;
            if (this.wip.decrementAndGet() == 0) return;
        }
    }

    public void onError(Throwable throwable) {
        if (this.delayError) {
            List<Throwable> list;
            List<Throwable> list2 = list = this.errors;
            if (list == null) {
                this.errors = list2 = new ArrayList<Throwable>(this.sources.length - this.index + 1);
            }
            list2.add(throwable);
            this.onComplete();
        } else {
            this.downstream.onError(throwable);
        }
    }

    public void onNext(T t) {
        ++this.produced;
        this.downstream.onNext(t);
    }

    public void onSubscribe(Subscription subscription) {
        this.setSubscription(subscription);
    }
}
