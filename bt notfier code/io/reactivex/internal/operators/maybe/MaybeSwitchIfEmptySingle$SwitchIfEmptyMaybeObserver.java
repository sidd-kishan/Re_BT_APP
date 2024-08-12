/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.SingleObserver
 *  io.reactivex.SingleSource
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.operators.maybe.MaybeSwitchIfEmptySingle$SwitchIfEmptyMaybeObserver$OtherSingleObserver
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.maybe.MaybeSwitchIfEmptySingle;
import java.util.concurrent.atomic.AtomicReference;

static final class MaybeSwitchIfEmptySingle.SwitchIfEmptyMaybeObserver<T>
extends AtomicReference<Disposable>
implements MaybeObserver<T>,
Disposable {
    private static final long serialVersionUID = 4603919676453758899L;
    final SingleObserver<? super T> downstream;
    final SingleSource<? extends T> other;

    MaybeSwitchIfEmptySingle.SwitchIfEmptyMaybeObserver(SingleObserver<? super T> singleObserver, SingleSource<? extends T> singleSource) {
        this.downstream = singleObserver;
        this.other = singleSource;
    }

    public void dispose() {
        DisposableHelper.dispose((AtomicReference)this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable)((Disposable)this.get()));
    }

    public void onComplete() {
        Disposable disposable = (Disposable)this.get();
        if (disposable == DisposableHelper.DISPOSED) return;
        if (!this.compareAndSet(disposable, null)) return;
        this.other.subscribe((SingleObserver)new OtherSingleObserver(this.downstream, (AtomicReference)this));
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.setOnce((AtomicReference)this, (Disposable)disposable)) return;
        this.downstream.onSubscribe((Disposable)this);
    }

    public void onSuccess(T t) {
        this.downstream.onSuccess(t);
    }
}
