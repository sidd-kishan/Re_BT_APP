/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.SingleObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Consumer
 *  io.reactivex.internal.disposables.EmptyDisposable
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.single;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;

static final class SingleDoOnSubscribe.DoOnSubscribeSingleObserver<T>
implements SingleObserver<T> {
    boolean done;
    final SingleObserver<? super T> downstream;
    final Consumer<? super Disposable> onSubscribe;

    SingleDoOnSubscribe.DoOnSubscribeSingleObserver(SingleObserver<? super T> singleObserver, Consumer<? super Disposable> consumer) {
        this.downstream = singleObserver;
        this.onSubscribe = consumer;
    }

    public void onError(Throwable throwable) {
        if (this.done) {
            RxJavaPlugins.onError((Throwable)throwable);
            return;
        }
        this.downstream.onError(throwable);
    }

    public void onSubscribe(Disposable disposable) {
        try {
            this.onSubscribe.accept((Object)disposable);
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            this.done = true;
            disposable.dispose();
            EmptyDisposable.error((Throwable)throwable, this.downstream);
            return;
        }
        this.downstream.onSubscribe(disposable);
    }

    public void onSuccess(T t) {
        if (this.done) {
            return;
        }
        this.downstream.onSuccess(t);
    }
}
