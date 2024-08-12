/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.operators.observable.ObservableReplay$BufferSupplier
 *  io.reactivex.internal.operators.observable.ObservableReplay$InnerDisposable
 *  io.reactivex.internal.operators.observable.ObservableReplay$ReplayObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.observable.ObservableReplay;
import java.util.concurrent.atomic.AtomicReference;

static final class ObservableReplay.ReplaySource<T>
implements ObservableSource<T> {
    private final ObservableReplay.BufferSupplier<T> bufferFactory;
    private final AtomicReference<ObservableReplay.ReplayObserver<T>> curr;

    ObservableReplay.ReplaySource(AtomicReference<ObservableReplay.ReplayObserver<T>> atomicReference, ObservableReplay.BufferSupplier<T> bufferSupplier) {
        this.curr = atomicReference;
        this.bufferFactory = bufferSupplier;
    }

    public void subscribe(Observer<? super T> observer) {
        ObservableReplay.InnerDisposable innerDisposable;
        ObservableReplay.InnerDisposable innerDisposable2;
        do {
            innerDisposable = innerDisposable2 = this.curr.get();
        } while (innerDisposable2 == null && !this.curr.compareAndSet((ObservableReplay.ReplayObserver<T>)null, (ObservableReplay.ReplayObserver<T>)(innerDisposable = new ObservableReplay.ReplayObserver(this.bufferFactory.call()))));
        innerDisposable2 = new ObservableReplay.InnerDisposable(innerDisposable, observer);
        observer.onSubscribe((Disposable)innerDisposable2);
        innerDisposable.add(innerDisposable2);
        if (innerDisposable2.isDisposed()) {
            innerDisposable.remove(innerDisposable2);
            return;
        }
        innerDisposable.buffer.replay(innerDisposable2);
    }
}
