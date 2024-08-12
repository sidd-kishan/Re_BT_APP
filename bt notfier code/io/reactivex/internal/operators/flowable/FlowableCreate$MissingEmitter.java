/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.operators.flowable.FlowableCreate$BaseEmitter
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.operators.flowable.FlowableCreate;
import org.reactivestreams.Subscriber;

static final class FlowableCreate.MissingEmitter<T>
extends FlowableCreate.BaseEmitter<T> {
    private static final long serialVersionUID = 3776720187248809713L;

    FlowableCreate.MissingEmitter(Subscriber<? super T> subscriber) {
        super(subscriber);
    }

    public void onNext(T t) {
        long l;
        if (this.isCancelled()) {
            return;
        }
        if (t == null) {
            this.onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        this.downstream.onNext(t);
        do {
            if ((l = this.get()) == 0L) return;
        } while (!this.compareAndSet(l, l - 1L));
    }
}
