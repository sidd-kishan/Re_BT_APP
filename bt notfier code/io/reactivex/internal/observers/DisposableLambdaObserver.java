/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Action
 *  io.reactivex.functions.Consumer
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.disposables.EmptyDisposable
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;

public final class DisposableLambdaObserver<T>
implements Observer<T>,
Disposable {
    final Observer<? super T> downstream;
    final Action onDispose;
    final Consumer<? super Disposable> onSubscribe;
    Disposable upstream;

    public DisposableLambdaObserver(Observer<? super T> observer, Consumer<? super Disposable> consumer, Action action) {
        this.downstream = observer;
        this.onSubscribe = consumer;
        this.onDispose = action;
    }

    public void dispose() {
        Disposable disposable = this.upstream;
        if (disposable == DisposableHelper.DISPOSED) return;
        this.upstream = DisposableHelper.DISPOSED;
        try {
            this.onDispose.run();
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            RxJavaPlugins.onError((Throwable)throwable);
        }
        disposable.dispose();
    }

    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    public void onComplete() {
        if (this.upstream == DisposableHelper.DISPOSED) return;
        this.upstream = DisposableHelper.DISPOSED;
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        if (this.upstream != DisposableHelper.DISPOSED) {
            this.upstream = DisposableHelper.DISPOSED;
            this.downstream.onError(throwable);
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void onNext(T t) {
        this.downstream.onNext(t);
    }

    public void onSubscribe(Disposable disposable) {
        try {
            this.onSubscribe.accept((Object)disposable);
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            disposable.dispose();
            this.upstream = DisposableHelper.DISPOSED;
            EmptyDisposable.error((Throwable)throwable, this.downstream);
            return;
        }
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.downstream.onSubscribe((Disposable)this);
    }
}
