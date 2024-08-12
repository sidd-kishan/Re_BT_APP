/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.CompletableObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.operators.completable.CompletableTakeUntilCompletable$TakeUntilMainObserver$OtherObserver
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.completable.CompletableTakeUntilCompletable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

static final class CompletableTakeUntilCompletable.TakeUntilMainObserver
extends AtomicReference<Disposable>
implements CompletableObserver,
Disposable {
    private static final long serialVersionUID = 3533011714830024923L;
    final CompletableObserver downstream;
    final AtomicBoolean once;
    final OtherObserver other;

    CompletableTakeUntilCompletable.TakeUntilMainObserver(CompletableObserver completableObserver) {
        this.downstream = completableObserver;
        this.other = new OtherObserver(this);
        this.once = new AtomicBoolean();
    }

    public void dispose() {
        if (!this.once.compareAndSet(false, true)) return;
        DisposableHelper.dispose((AtomicReference)this);
        DisposableHelper.dispose((AtomicReference)this.other);
    }

    void innerComplete() {
        if (!this.once.compareAndSet(false, true)) return;
        DisposableHelper.dispose((AtomicReference)this);
        this.downstream.onComplete();
    }

    void innerError(Throwable throwable) {
        if (this.once.compareAndSet(false, true)) {
            DisposableHelper.dispose((AtomicReference)this);
            this.downstream.onError(throwable);
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public boolean isDisposed() {
        return this.once.get();
    }

    public void onComplete() {
        if (!this.once.compareAndSet(false, true)) return;
        DisposableHelper.dispose((AtomicReference)this.other);
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        if (this.once.compareAndSet(false, true)) {
            DisposableHelper.dispose((AtomicReference)this.other);
            this.downstream.onError(throwable);
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce((AtomicReference)this, (Disposable)disposable);
    }
}
