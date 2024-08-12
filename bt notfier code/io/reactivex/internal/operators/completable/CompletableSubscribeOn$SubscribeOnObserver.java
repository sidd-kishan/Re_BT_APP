/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.CompletableObserver
 *  io.reactivex.CompletableSource
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.disposables.SequentialDisposable
 */
package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicReference;

static final class CompletableSubscribeOn.SubscribeOnObserver
extends AtomicReference<Disposable>
implements CompletableObserver,
Disposable,
Runnable {
    private static final long serialVersionUID = 7000911171163930287L;
    final CompletableObserver downstream;
    final CompletableSource source;
    final SequentialDisposable task;

    CompletableSubscribeOn.SubscribeOnObserver(CompletableObserver completableObserver, CompletableSource completableSource) {
        this.downstream = completableObserver;
        this.source = completableSource;
        this.task = new SequentialDisposable();
    }

    public void dispose() {
        DisposableHelper.dispose((AtomicReference)this);
        this.task.dispose();
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable)((Disposable)this.get()));
    }

    public void onComplete() {
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce((AtomicReference)this, (Disposable)disposable);
    }

    @Override
    public void run() {
        this.source.subscribe((CompletableObserver)this);
    }
}
