/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.operators.observable.ObservableBufferBoundary$BufferBoundaryObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableBufferBoundary;
import java.util.concurrent.atomic.AtomicReference;

static final class ObservableBufferBoundary.BufferBoundaryObserver.BufferOpenObserver<Open>
extends AtomicReference<Disposable>
implements Observer<Open>,
Disposable {
    private static final long serialVersionUID = -8498650778633225126L;
    final ObservableBufferBoundary.BufferBoundaryObserver<?, ?, Open, ?> parent;

    ObservableBufferBoundary.BufferBoundaryObserver.BufferOpenObserver(ObservableBufferBoundary.BufferBoundaryObserver<?, ?, Open, ?> bufferBoundaryObserver) {
        this.parent = bufferBoundaryObserver;
    }

    public void dispose() {
        DisposableHelper.dispose((AtomicReference)this);
    }

    public boolean isDisposed() {
        boolean bl = this.get() == DisposableHelper.DISPOSED;
        return bl;
    }

    public void onComplete() {
        this.lazySet(DisposableHelper.DISPOSED);
        this.parent.openComplete(this);
    }

    public void onError(Throwable throwable) {
        this.lazySet(DisposableHelper.DISPOSED);
        this.parent.boundaryError((Disposable)this, throwable);
    }

    public void onNext(Open Open) {
        this.parent.open(Open);
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce((AtomicReference)this, (Disposable)disposable);
    }
}
