/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.Predicate
 *  io.reactivex.internal.fuseable.ConditionalSubscriber
 *  io.reactivex.internal.fuseable.QueueSubscription
 *  io.reactivex.internal.subscribers.BasicFuseableSubscriber
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.functions.Predicate;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.subscribers.BasicFuseableSubscriber;
import org.reactivestreams.Subscriber;

static final class FlowableFilter.FilterSubscriber<T>
extends BasicFuseableSubscriber<T, T>
implements ConditionalSubscriber<T> {
    final Predicate<? super T> filter;

    FlowableFilter.FilterSubscriber(Subscriber<? super T> subscriber, Predicate<? super T> predicate) {
        super(subscriber);
        this.filter = predicate;
    }

    public void onNext(T t) {
        if (this.tryOnNext(t)) return;
        this.upstream.request(1L);
    }

    public T poll() throws Exception {
        QueueSubscription queueSubscription = this.qs;
        Predicate<? super T> predicate = this.filter;
        Object object;
        while ((object = queueSubscription.poll()) != null) {
            if (predicate.test(object)) {
                return (T)object;
            }
            if (this.sourceMode != 2) continue;
            queueSubscription.request(1L);
        }
        return null;
    }

    public int requestFusion(int n) {
        return this.transitiveBoundaryFusion(n);
    }

    public boolean tryOnNext(T t) {
        boolean bl;
        if (this.done) {
            return false;
        }
        if (this.sourceMode != 0) {
            this.downstream.onNext(null);
            return true;
        }
        try {
            bl = this.filter.test(t);
            if (!bl) return bl;
        }
        catch (Throwable throwable) {
            this.fail(throwable);
            return true;
        }
        this.downstream.onNext(t);
        return bl;
    }
}
