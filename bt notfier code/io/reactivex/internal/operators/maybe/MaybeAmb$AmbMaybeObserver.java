/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.disposables.CompositeDisposable
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;

static final class MaybeAmb.AmbMaybeObserver<T>
implements MaybeObserver<T> {
    final MaybeObserver<? super T> downstream;
    final CompositeDisposable set;
    Disposable upstream;
    final AtomicBoolean winner;

    MaybeAmb.AmbMaybeObserver(MaybeObserver<? super T> maybeObserver, CompositeDisposable compositeDisposable, AtomicBoolean atomicBoolean) {
        this.downstream = maybeObserver;
        this.set = compositeDisposable;
        this.winner = atomicBoolean;
    }

    public void onComplete() {
        if (!this.winner.compareAndSet(false, true)) return;
        this.set.delete(this.upstream);
        this.set.dispose();
        this.downstream.onComplete();
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
