/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.operators.flowable.FlowableCreate$NoOverflowBaseAsyncEmitter
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.operators.flowable.FlowableCreate;
import org.reactivestreams.Subscriber;

static final class FlowableCreate.DropAsyncEmitter<T>
extends FlowableCreate.NoOverflowBaseAsyncEmitter<T> {
    private static final long serialVersionUID = 8360058422307496563L;

    FlowableCreate.DropAsyncEmitter(Subscriber<? super T> subscriber) {
        super(subscriber);
    }

    void onOverflow() {
    }
}
