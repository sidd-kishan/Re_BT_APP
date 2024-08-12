/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.MaybeSource
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.operators.maybe.MaybeSwitchIfEmpty$SwitchIfEmptyMaybeObserver$OtherMaybeObserver
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.maybe.MaybeSwitchIfEmpty;
import java.util.concurrent.atomic.AtomicReference;

static final class MaybeSwitchIfEmpty.SwitchIfEmptyMaybeObserver<T>
extends AtomicReference<Disposable>
implements MaybeObserver<T>,
Disposable {
    private static final long serialVersionUID = -2223459372976438024L;
    final MaybeObserver<? super T> downstream;
    final MaybeSource<? extends T> other;

    MaybeSwitchIfEmpty.SwitchIfEmptyMaybeObserver(MaybeObserver<? super T> maybeObserver, MaybeSource<? extends T> maybeSource) {
        this.downstream = maybeObserver;
        this.other = maybeSource;
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
        this.other.subscribe((MaybeObserver)new OtherMaybeObserver(this.downstream, (AtomicReference)this));
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
