/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.CompletableObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.operators.completable.CompletableConcat$CompletableConcatSubscriber
 */
package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.completable.CompletableConcat;
import java.util.concurrent.atomic.AtomicReference;

static final class CompletableConcat.CompletableConcatSubscriber.ConcatInnerObserver
extends AtomicReference<Disposable>
implements CompletableObserver {
    private static final long serialVersionUID = -5454794857847146511L;
    final CompletableConcat.CompletableConcatSubscriber parent;

    CompletableConcat.CompletableConcatSubscriber.ConcatInnerObserver(CompletableConcat.CompletableConcatSubscriber completableConcatSubscriber) {
        this.parent = completableConcatSubscriber;
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
