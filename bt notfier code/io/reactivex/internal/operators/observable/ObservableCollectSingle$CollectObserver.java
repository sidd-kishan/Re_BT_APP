/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.SingleObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.functions.BiConsumer
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

static final class ObservableCollectSingle.CollectObserver<T, U>
implements Observer<T>,
Disposable {
    final BiConsumer<? super U, ? super T> collector;
    boolean done;
    final SingleObserver<? super U> downstream;
    final U u;
    Disposable upstream;

    ObservableCollectSingle.CollectObserver(SingleObserver<? super U> singleObserver, U u, BiConsumer<? super U, ? super T> biConsumer) {
        this.downstream = singleObserver;
        this.collector = biConsumer;
        this.u = u;
    }

    public void dispose() {
        this.upstream.dispose();
    }

    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        this.downstream.onSuccess(this.u);
    }

    public void onError(Throwable throwable) {
        if (this.done) {
            RxJavaPlugins.onError((Throwable)throwable);
            return;
        }
        this.done = true;
        this.downstream.onError(throwable);
    }

    public void onNext(T t) {
        if (this.done) {
            return;
        }
        try {
            this.collector.accept(this.u, t);
        }
        catch (Throwable throwable) {
            this.upstream.dispose();
            this.onError(throwable);
        }
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.downstream.onSubscribe((Disposable)this);
    }
}
