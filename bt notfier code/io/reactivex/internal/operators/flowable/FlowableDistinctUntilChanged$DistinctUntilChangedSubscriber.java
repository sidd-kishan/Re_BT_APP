/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.BiPredicate
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.fuseable.ConditionalSubscriber
 *  io.reactivex.internal.subscribers.BasicFuseableSubscriber
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.Function;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableSubscriber;
import org.reactivestreams.Subscriber;

static final class FlowableDistinctUntilChanged.DistinctUntilChangedSubscriber<T, K>
extends BasicFuseableSubscriber<T, T>
implements ConditionalSubscriber<T> {
    final BiPredicate<? super K, ? super K> comparer;
    boolean hasValue;
    final Function<? super T, K> keySelector;
    K last;

    FlowableDistinctUntilChanged.DistinctUntilChangedSubscriber(Subscriber<? super T> subscriber, Function<? super T, K> function, BiPredicate<? super K, ? super K> biPredicate) {
        super(subscriber);
        this.keySelector = function;
        this.comparer = biPredicate;
    }

    public void onNext(T t) {
        if (this.tryOnNext(t)) return;
        this.upstream.request(1L);
    }

    public T poll() throws Exception {
        Object object;
        while ((object = this.qs.poll()) != null) {
            Object object2 = this.keySelector.apply(object);
            if (!this.hasValue) {
                this.hasValue = true;
                this.last = object2;
                return (T)object;
            }
            if (!this.comparer.test(this.last, object2)) {
                this.last = object2;
                return (T)object;
            }
            this.last = object2;
            if (this.sourceMode == 1) continue;
            this.upstream.request(1L);
        }
        return null;
    }

    public int requestFusion(int n) {
        return this.transitiveBoundaryFusion(n);
    }

    public boolean tryOnNext(T t) {
        if (this.done) {
            return false;
        }
        if (this.sourceMode != 0) {
            this.downstream.onNext(t);
            return true;
        }
        try {
            Object object = this.keySelector.apply(t);
            if (this.hasValue) {
                boolean bl = this.comparer.test(this.last, object);
                this.last = object;
                if (bl) {
                    return false;
                }
            } else {
                this.hasValue = true;
                this.last = object;
            }
        }
        catch (Throwable throwable) {
            this.fail(throwable);
            return true;
        }
        this.downstream.onNext(t);
        return true;
    }
}
