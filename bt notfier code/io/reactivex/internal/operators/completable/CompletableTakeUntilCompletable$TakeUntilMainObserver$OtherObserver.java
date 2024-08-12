/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.CompletableObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.operators.completable.CompletableTakeUntilCompletable$TakeUntilMainObserver
 */
package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.completable.CompletableTakeUntilCompletable;
import java.util.concurrent.atomic.AtomicReference;

static final class CompletableTakeUntilCompletable.TakeUntilMainObserver.OtherObserver
extends AtomicReference<Disposable>
implements CompletableObserver {
    private static final long serialVersionUID = 5176264485428790318L;
    final CompletableTakeUntilCompletable.TakeUntilMainObserver parent;

    CompletableTakeUntilCompletable.TakeUntilMainObserver.OtherObserver(CompletableTakeUntilCompletable.TakeUntilMainObserver takeUntilMainObserver) {
        this.parent = takeUntilMainObserver;
    }

    public void onComplete() {
        this.parent.innerComplete();
    }

    public void onError(Throwable throwable) {
        this.parent.innerError(throwable);
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce((AtomicReference)this, (Disposable)disposable);
    }
}
