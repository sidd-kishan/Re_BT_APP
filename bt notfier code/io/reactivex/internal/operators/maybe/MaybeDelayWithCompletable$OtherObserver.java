/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.CompletableObserver
 *  io.reactivex.MaybeObserver
 *  io.reactivex.MaybeSource
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.operators.maybe.MaybeDelayWithCompletable$DelayWithMainObserver
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.CompletableObserver;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.maybe.MaybeDelayWithCompletable;
import java.util.concurrent.atomic.AtomicReference;

static final class MaybeDelayWithCompletable.OtherObserver<T>
extends AtomicReference<Disposable>
implements CompletableObserver,
Disposable {
    private static final long serialVersionUID = 703409937383992161L;
    final MaybeObserver<? super T> downstream;
    final MaybeSource<T> source;

    MaybeDelayWithCompletable.OtherObserver(MaybeObserver<? super T> maybeObserver, MaybeSource<T> maybeSource) {
        this.downstream = maybeObserver;
        this.source = maybeSource;
    }

    public void dispose() {
        DisposableHelper.dispose((AtomicReference)this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable)((Disposable)this.get()));
    }

    public void onComplete() {
        this.source.subscribe((MaybeObserver)new MaybeDelayWithCompletable.DelayWithMainObserver((AtomicReference)this, this.downstream));
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.setOnce((AtomicReference)this, (Disposable)disposable)) return;
        this.downstream.onSubscribe((Disposable)this);
    }
}
