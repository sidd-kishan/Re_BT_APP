/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.CompletableObserver
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.observers.BasicQueueDisposable
 */
package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.BasicQueueDisposable;

static final class CompletableToObservable.ObserverCompletableObserver
extends BasicQueueDisposable<Void>
implements CompletableObserver {
    final Observer<?> observer;
    Disposable upstream;

    CompletableToObservable.ObserverCompletableObserver(Observer<?> observer) {
        this.observer = observer;
    }

    public void clear() {
    }

    public void dispose() {
        this.upstream.dispose();
    }

    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    public boolean isEmpty() {
        return true;
    }

    public void onComplete() {
        this.observer.onComplete();
    }

    public void onError(Throwable throwable) {
        this.observer.onError(throwable);
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.observer.onSubscribe((Disposable)this);
    }

    public Void poll() throws Exception {
        return null;
    }

    public int requestFusion(int n) {
        return n & 2;
    }
}
