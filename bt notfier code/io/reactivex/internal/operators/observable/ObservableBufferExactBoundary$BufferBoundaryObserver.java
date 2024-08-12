/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.operators.observable.ObservableBufferExactBoundary$BufferExactBoundaryObserver
 *  io.reactivex.observers.DisposableObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.internal.operators.observable.ObservableBufferExactBoundary;
import io.reactivex.observers.DisposableObserver;
import java.util.Collection;

static final class ObservableBufferExactBoundary.BufferBoundaryObserver<T, U extends Collection<? super T>, B>
extends DisposableObserver<B> {
    final ObservableBufferExactBoundary.BufferExactBoundaryObserver<T, U, B> parent;

    ObservableBufferExactBoundary.BufferBoundaryObserver(ObservableBufferExactBoundary.BufferExactBoundaryObserver<T, U, B> bufferExactBoundaryObserver) {
        this.parent = bufferExactBoundaryObserver;
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
