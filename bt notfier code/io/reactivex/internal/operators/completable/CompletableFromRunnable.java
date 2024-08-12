/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Completable
 *  io.reactivex.CompletableObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.disposables.Disposables
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;

public final class CompletableFromRunnable
extends Completable {
    final Runnable runnable;

    public CompletableFromRunnable(Runnable runnable) {
        this.runnable = runnable;
    }

    protected void subscribeActual(CompletableObserver completableObserver) {
        Disposable disposable = Disposables.empty();
        completableObserver.onSubscribe(disposable);
        try {
            this.runnable.run();
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            if (!disposable.isDisposed()) {
                completableObserver.onError(throwable);
            } else {
                RxJavaPlugins.onError((Throwable)throwable);
            }
            return;
        }
        if (disposable.isDisposed()) return;
        completableObserver.onComplete();
    }
}
