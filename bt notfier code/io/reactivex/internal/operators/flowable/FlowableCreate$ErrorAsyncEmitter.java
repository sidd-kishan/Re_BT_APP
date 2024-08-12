/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.exceptions.MissingBackpressureException
 *  io.reactivex.internal.operators.flowable.FlowableCreate$NoOverflowBaseAsyncEmitter
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.operators.flowable.FlowableCreate;
import org.reactivestreams.Subscriber;

static final class FlowableCreate.ErrorAsyncEmitter<T>
extends FlowableCreate.NoOverflowBaseAsyncEmitter<T> {
    private static final long serialVersionUID = 338953216916120960L;

    FlowableCreate.ErrorAsyncEmitter(Subscriber<? super T> subscriber) {
        super(subscriber);
    }

    void onOverflow() {
        this.onError((Throwable)new MissingBackpressureException("create: could not emit value due to lack of requests"));
    }
}
