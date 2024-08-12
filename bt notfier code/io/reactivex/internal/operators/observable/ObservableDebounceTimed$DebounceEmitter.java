/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.operators.observable.ObservableDebounceTimed$DebounceTimedObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableDebounceTimed;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

static final class ObservableDebounceTimed.DebounceEmitter<T>
extends AtomicReference<Disposable>
implements Runnable,
Disposable {
    private static final long serialVersionUID = 6812032969491025141L;
    final long idx;
    final AtomicBoolean once = new AtomicBoolean();
    final ObservableDebounceTimed.DebounceTimedObserver<T> parent;
    final T value;

    ObservableDebounceTimed.DebounceEmitter(T t, long l, ObservableDebounceTimed.DebounceTimedObserver<T> debounceTimedObserver) {
        this.value = t;
        this.idx = l;
        this.parent = debounceTimedObserver;
    }

    public void dispose() {
        DisposableHelper.dispose((AtomicReference)this);
    }

    public boolean isDisposed() {
        boolean bl = this.get() == DisposableHelper.DISPOSED;
        return bl;
    }

    @Override
    public void run() {
        if (!this.once.compareAndSet(false, true)) return;
        this.parent.emit(this.idx, this.value, this);
    }

    public void setResource(Disposable disposable) {
        DisposableHelper.replace((AtomicReference)this, (Disposable)disposable);
    }
}
