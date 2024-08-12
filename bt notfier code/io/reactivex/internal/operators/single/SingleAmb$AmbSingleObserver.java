/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.SingleObserver
 *  io.reactivex.disposables.CompositeDisposable
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.single;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;

static final class SingleAmb.AmbSingleObserver<T>
implements SingleObserver<T> {
    final SingleObserver<? super T> downstream;
    final CompositeDisposable set;
    Disposable upstream;
    final AtomicBoolean winner;

    SingleAmb.AmbSingleObserver(SingleObserver<? super T> singleObserver, CompositeDisposable compositeDisposable, AtomicBoolean atomicBoolean) {
        this.downstream = singleObserver;
        this.set = compositeDisposable;
        this.winner = atomicBoolean;
    }

    public void onError(Throwable throwable) {
        if (this.winner.compareAndSet(false, true)) {
            this.set.delete(this.upstream);
            this.set.dispose();
            this.downstream.onError(throwable);
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void onSubscribe(Disposable disposable) {
        this.upstream = disposable;
        this.set.add(disposable);
    }

    public void onSuccess(T t) {
        if (!this.winner.compareAndSet(false, true)) return;
        this.set.delete(this.upstream);
        this.set.dispose();
        this.downstream.onSuccess(t);
    }
}
