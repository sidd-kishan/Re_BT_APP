/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.Predicate
 *  io.reactivex.internal.fuseable.ConditionalSubscriber
 *  io.reactivex.internal.fuseable.QueueSubscription
 *  io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.functions.Predicate;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber;

static final class FlowableFilter.FilterConditionalSubscriber<T>
extends BasicFuseableConditionalSubscriber<T, T> {
    final Predicate<? super T> filter;

    FlowableFilter.FilterConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, Predicate<? super T> predicate) {
        super(conditionalSubscriber);
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
        boolean bl = this.done;
        boolean bl2 = false;
        if (bl) {
            return false;
        }
        if (this.sourceMode != 0) {
            return this.downstream.tryOnNext(null);
        }
        try {
            boolean bl3 = this.filter.test(t);
            bl = bl2;
            if (!bl3) return bl;
            bl = bl2;
        }
        catch (Throwable throwable) {
            this.fail(throwable);
            return true;
        }
        if (!this.downstream.tryOnNext(t)) return bl;
        bl = true;
        return bl;
    }
}
