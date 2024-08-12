/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.operators.observable.ObservableTimeout$TimeoutSelectorSupport
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableTimeout;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

static final class ObservableTimeout.TimeoutConsumer
extends AtomicReference<Disposable>
implements Observer<Object>,
Disposable {
    private static final long serialVersionUID = 8708641127342403073L;
    final long idx;
    final ObservableTimeout.TimeoutSelectorSupport parent;

    ObservableTimeout.TimeoutConsumer(long l, ObservableTimeout.TimeoutSelectorSupport timeoutSelectorSupport) {
        this.idx = l;
        this.parent = timeoutSelectorSupport;
    }

    public void dispose() {
        DisposableHelper.dispose((AtomicReference)this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable)((Disposable)this.get()));
    }

    public void onComplete() {
        if (this.get() == DisposableHelper.DISPOSED) return;
        this.lazySet(DisposableHelper.DISPOSED);
        this.parent.onTimeout(this.idx);
    }

    public void onError(Throwable throwable) {
        if (this.get() != DisposableHelper.DISPOSED) {
            this.lazySet(DisposableHelper.DISPOSED);
            this.parent.onTimeoutError(this.idx, throwable);
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void onNext(Object object) {
        object = (Disposable)this.get();
        if (object == DisposableHelper.DISPOSED) return;
        object.dispose();
        this.lazySet(DisposableHelper.DISPOSED);
        this.parent.onTimeout(this.idx);
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce((AtomicReference)this, (Disposable)disposable);
    }
}
