/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.operators.mixed.ObservableConcatMapMaybe$ConcatMapMaybeMainObserver
 */
package io.reactivex.internal.operators.mixed;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.mixed.ObservableConcatMapMaybe;
import java.util.concurrent.atomic.AtomicReference;

static final class ObservableConcatMapMaybe.ConcatMapMaybeMainObserver.ConcatMapMaybeObserver<R>
extends AtomicReference<Disposable>
implements MaybeObserver<R> {
    private static final long serialVersionUID = -3051469169682093892L;
    final ObservableConcatMapMaybe.ConcatMapMaybeMainObserver<?, R> parent;

    ObservableConcatMapMaybe.ConcatMapMaybeMainObserver.ConcatMapMaybeObserver(ObservableConcatMapMaybe.ConcatMapMaybeMainObserver<?, R> concatMapMaybeMainObserver) {
        this.parent = concatMapMaybeMainObserver;
    }

    void dispose() {
        DisposableHelper.dispose((AtomicReference)this);
    }

    public void onComplete() {
        this.parent.innerComplete();
    }

    public void onError(Throwable throwable) {
        this.parent.innerError(throwable);
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.replace((AtomicReference)this, (Disposable)disposable);
    }

    public void onSuccess(R r) {
        this.parent.innerSuccess(r);
    }
}
