/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.operators.observable.ObservableFlatMapMaybe$FlatMapMaybeObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableFlatMapMaybe;
import java.util.concurrent.atomic.AtomicReference;

final class ObservableFlatMapMaybe.FlatMapMaybeObserver.InnerObserver
extends AtomicReference<Disposable>
implements MaybeObserver<R>,
Disposable {
    private static final long serialVersionUID = -502562646270949838L;
    final ObservableFlatMapMaybe.FlatMapMaybeObserver this$0;

    ObservableFlatMapMaybe.FlatMapMaybeObserver.InnerObserver(ObservableFlatMapMaybe.FlatMapMaybeObserver flatMapMaybeObserver) {
        this.this$0 = flatMapMaybeObserver;
    }

    public void dispose() {
        DisposableHelper.dispose((AtomicReference)this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable)((Disposable)this.get()));
    }

    public void onComplete() {
        this.this$0.innerComplete(this);
    }

    public void onError(Throwable throwable) {
        this.this$0.innerError(this, throwable);
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce((AtomicReference)this, (Disposable)disposable);
    }

    public void onSuccess(R r) {
        this.this$0.innerSuccess(this, r);
    }
}
