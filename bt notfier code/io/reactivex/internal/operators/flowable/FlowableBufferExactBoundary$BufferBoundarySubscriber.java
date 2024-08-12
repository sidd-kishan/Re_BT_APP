/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.operators.flowable.FlowableBufferExactBoundary$BufferExactBoundarySubscriber
 *  io.reactivex.subscribers.DisposableSubscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.operators.flowable.FlowableBufferExactBoundary;
import io.reactivex.subscribers.DisposableSubscriber;
import java.util.Collection;

static final class FlowableBufferExactBoundary.BufferBoundarySubscriber<T, U extends Collection<? super T>, B>
extends DisposableSubscriber<B> {
    final FlowableBufferExactBoundary.BufferExactBoundarySubscriber<T, U, B> parent;

    FlowableBufferExactBoundary.BufferBoundarySubscriber(FlowableBufferExactBoundary.BufferExactBoundarySubscriber<T, U, B> bufferExactBoundarySubscriber) {
        this.parent = bufferExactBoundarySubscriber;
    }

    public void onComplete() {
        this.parent.onComplete();
    }

    public void onError(Throwable throwable) {
        this.parent.onError(throwable);
    }

    public void onNext(B b) {
        this.parent.next();
    }
}
