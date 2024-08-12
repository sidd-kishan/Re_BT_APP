/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.operators.flowable.FlowableCreate$BaseEmitter
 *  io.reactivex.internal.util.BackpressureHelper
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.operators.flowable.FlowableCreate;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;

static abstract class FlowableCreate.NoOverflowBaseAsyncEmitter<T>
extends FlowableCreate.BaseEmitter<T> {
    private static final long serialVersionUID = 4127754106204442833L;

    FlowableCreate.NoOverflowBaseAsyncEmitter(Subscriber<? super T> subscriber) {
        super(subscriber);
    }

    public final void onNext(T t) {
        if (this.isCancelled()) {
            return;
        }
        if (t == null) {
            this.onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        if (this.get() != 0L) {
            this.downstream.onNext(t);
            BackpressureHelper.produced((AtomicLong)((Object)this), (long)1L);
        } else {
            this.onOverflow();
        }
    }

    abstract void onOverflow();
}
