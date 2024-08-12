/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.CompletableObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.operators.completable.CompletableMerge$CompletableMergeSubscriber
 */
package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.completable.CompletableMerge;
import java.util.concurrent.atomic.AtomicReference;

final class CompletableMerge.CompletableMergeSubscriber.MergeInnerObserver
extends AtomicReference<Disposable>
implements CompletableObserver,
Disposable {
    private static final long serialVersionUID = 251330541679988317L;
    final CompletableMerge.CompletableMergeSubscriber this$0;

    CompletableMerge.CompletableMergeSubscriber.MergeInnerObserver(CompletableMerge.CompletableMergeSubscriber completableMergeSubscriber) {
        this.this$0 = completableMergeSubscriber;
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
}
