/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.operators.flowable.FlowableDebounceTimed$DebounceTimedSubscriber
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.flowable.FlowableDebounceTimed;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

static final class FlowableDebounceTimed.DebounceEmitter<T>
extends AtomicReference<Disposable>
implements Runnable,
Disposable {
    private static final long serialVersionUID = 6812032969491025141L;
    final long idx;
    final AtomicBoolean once = new AtomicBoolean();
    final FlowableDebounceTimed.DebounceTimedSubscriber<T> parent;
    final T value;

    FlowableDebounceTimed.DebounceEmitter(T t, long l, FlowableDebounceTimed.DebounceTimedSubscriber<T> debounceTimedSubscriber) {
        this.value = t;
        this.idx = l;
        this.parent = debounceTimedSubscriber;
    }

    public void dispose() {
        DisposableHelper.dispose((AtomicReference)this);
    }

    void emit() {
        if (!this.once.compareAndSet(false, true)) return;
        this.parent.emit(this.idx, this.value, this);
    }

    public boolean isDisposed() {
        boolean bl = this.get() == DisposableHelper.DISPOSED;
        return bl;
    }

    @Override
    public void run() {
        this.emit();
    }

    public void setResource(Disposable disposable) {
        DisposableHelper.replace((AtomicReference)this, (Disposable)disposable);
    }
}
