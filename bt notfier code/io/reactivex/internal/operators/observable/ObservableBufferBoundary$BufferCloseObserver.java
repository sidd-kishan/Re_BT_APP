/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.operators.observable.ObservableBufferBoundary$BufferBoundaryObserver
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableBufferBoundary;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicReference;

static final class ObservableBufferBoundary.BufferCloseObserver<T, C extends Collection<? super T>>
extends AtomicReference<Disposable>
implements Observer<Object>,
Disposable {
    private static final long serialVersionUID = -8498650778633225126L;
    final long index;
    final ObservableBufferBoundary.BufferBoundaryObserver<T, C, ?, ?> parent;

    ObservableBufferBoundary.BufferCloseObserver(ObservableBufferBoundary.BufferBoundaryObserver<T, C, ?, ?> bufferBoundaryObserver, long l) {
        this.parent = bufferBoundaryObserver;
        this.index = l;
    }

    public void dispose() {
        DisposableHelper.dispose((AtomicReference)this);
    }

    public boolean isDisposed() {
        boolean bl = this.get() == DisposableHelper.DISPOSED;
        return bl;
    }

    public void onComplete() {
        if (this.get() == DisposableHelper.DISPOSED) return;
        this.lazySet(DisposableHelper.DISPOSED);
        this.parent.close(this, this.index);
    }

    public void onError(Throwable throwable) {
        if (this.get() != DisposableHelper.DISPOSED) {
            this.lazySet(DisposableHelper.DISPOSED);
            this.parent.boundaryError((Disposable)this, throwable);
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void onNext(Object object) {
        object = (Disposable)this.get();
        if (object == DisposableHelper.DISPOSED) return;
        this.lazySet(DisposableHelper.DISPOSED);
        object.dispose();
        this.parent.close(this, this.index);
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce((AtomicReference)this, (Disposable)disposable);
    }
}
