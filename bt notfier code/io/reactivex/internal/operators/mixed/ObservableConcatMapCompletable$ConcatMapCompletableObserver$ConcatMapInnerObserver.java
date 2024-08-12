/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.CompletableObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.operators.mixed.ObservableConcatMapCompletable$ConcatMapCompletableObserver
 */
package io.reactivex.internal.operators.mixed;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.mixed.ObservableConcatMapCompletable;
import java.util.concurrent.atomic.AtomicReference;

static final class ObservableConcatMapCompletable.ConcatMapCompletableObserver.ConcatMapInnerObserver
extends AtomicReference<Disposable>
implements CompletableObserver {
    private static final long serialVersionUID = 5638352172918776687L;
    final ObservableConcatMapCompletable.ConcatMapCompletableObserver<?> parent;

    ObservableConcatMapCompletable.ConcatMapCompletableObserver.ConcatMapInnerObserver(ObservableConcatMapCompletable.ConcatMapCompletableObserver<?> concatMapCompletableObserver) {
        this.parent = concatMapCompletableObserver;
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
}
