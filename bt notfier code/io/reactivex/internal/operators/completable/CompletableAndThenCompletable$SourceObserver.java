/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.CompletableObserver
 *  io.reactivex.CompletableSource
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.operators.completable.CompletableAndThenCompletable$NextObserver
 */
package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.completable.CompletableAndThenCompletable;
import java.util.concurrent.atomic.AtomicReference;

static final class CompletableAndThenCompletable.SourceObserver
extends AtomicReference<Disposable>
implements CompletableObserver,
Disposable {
    private static final long serialVersionUID = -4101678820158072998L;
    final CompletableObserver actualObserver;
    final CompletableSource next;

    CompletableAndThenCompletable.SourceObserver(CompletableObserver completableObserver, CompletableSource completableSource) {
        this.actualObserver = completableObserver;
        this.next = completableSource;
    }

    public void dispose() {
        DisposableHelper.dispose((AtomicReference)this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable)((Disposable)this.get()));
    }

    public void onComplete() {
        this.next.subscribe((CompletableObserver)new CompletableAndThenCompletable.NextObserver((AtomicReference)this, this.actualObserver));
    }

    public void onError(Throwable throwable) {
        this.actualObserver.onError(throwable);
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.setOnce((AtomicReference)this, (Disposable)disposable)) return;
        this.actualObserver.onSubscribe((Disposable)this);
    }
}
