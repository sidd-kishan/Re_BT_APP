/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.Consumer
 *  io.reactivex.internal.subscribers.BasicFuseableSubscriber
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.functions.Consumer;
import io.reactivex.internal.subscribers.BasicFuseableSubscriber;
import org.reactivestreams.Subscriber;

static final class FlowableDoAfterNext.DoAfterSubscriber<T>
extends BasicFuseableSubscriber<T, T> {
    final Consumer<? super T> onAfterNext;

    FlowableDoAfterNext.DoAfterSubscriber(Subscriber<? super T> subscriber, Consumer<? super T> consumer) {
        super(subscriber);
        this.onAfterNext = consumer;
    }

    public void onNext(T t) {
        if (this.done) {
            return;
        }
        this.downstream.onNext(t);
        if (this.sourceMode != 0) return;
        try {
            this.onAfterNext.accept(t);
        }
        catch (Throwable throwable) {
            this.fail(throwable);
        }
    }

    public T poll() throws Exception {
        Object object = this.qs.poll();
        if (object == null) return (T)object;
        this.onAfterNext.accept(object);
        return (T)object;
    }

    public int requestFusion(int n) {
        return this.transitiveBoundaryFusion(n);
    }
}
