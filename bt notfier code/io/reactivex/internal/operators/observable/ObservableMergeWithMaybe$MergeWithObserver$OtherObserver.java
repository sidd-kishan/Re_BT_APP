/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.operators.observable.ObservableMergeWithMaybe$MergeWithObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableMergeWithMaybe;
import java.util.concurrent.atomic.AtomicReference;

static final class ObservableMergeWithMaybe.MergeWithObserver.OtherObserver<T>
extends AtomicReference<Disposable>
implements MaybeObserver<T> {
    private static final long serialVersionUID = -2935427570954647017L;
    final ObservableMergeWithMaybe.MergeWithObserver<T> parent;

    ObservableMergeWithMaybe.MergeWithObserver.OtherObserver(ObservableMergeWithMaybe.MergeWithObserver<T> mergeWithObserver) {
        this.parent = mergeWithObserver;
    }

    public void onComplete() {
        this.parent.otherComplete();
    }

    public void onError(Throwable throwable) {
        this.parent.otherError(throwable);
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce((AtomicReference)this, (Disposable)disposable);
    }

    public void onSuccess(T t) {
        this.parent.otherSuccess(t);
    }
}
