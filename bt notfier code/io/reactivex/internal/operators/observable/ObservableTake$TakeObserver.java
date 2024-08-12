/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.disposables.EmptyDisposable
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;

static final class ObservableTake.TakeObserver<T>
implements Observer<T>,
Disposable {
    boolean done;
    final Observer<? super T> downstream;
    long remaining;
    Disposable upstream;

    ObservableTake.TakeObserver(Observer<? super T> observer, long l) {
        this.downstream = observer;
        this.remaining = l;
    }

    public void dispose() {
        this.upstream.dispose();
    }

    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    public void onComplete() {
        if (this.done) return;
        this.done = true;
        this.upstream.dispose();
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        if (this.done) {
            RxJavaPlugins.onError((Throwable)throwable);
            return;
        }
        this.done = true;
        this.upstream.dispose();
        this.downstream.onError(throwable);
    }

    public void onNext(T t) {
        long l;
        if (this.done) return;
        long l2 = this.remaining;
        this.remaining = l = l2 - 1L;
        if (l2 <= 0L) return;
        boolean bl = l == 0L;
        this.downstream.onNext(t);
        if (!bl) return;
        this.onComplete();
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        if (this.remaining == 0L) {
            this.done = true;
            disposable.dispose();
            EmptyDisposable.complete(this.downstream);
        } else {
            this.downstream.onSubscribe((Disposable)this);
        }
    }
}
