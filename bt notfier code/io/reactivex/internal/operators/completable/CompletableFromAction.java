/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Completable
 *  io.reactivex.CompletableObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.disposables.Disposables
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Action
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.plugins.RxJavaPlugins;

public final class CompletableFromAction
extends Completable {
    final Action run;

    public CompletableFromAction(Action action) {
        this.run = action;
    }

    protected void subscribeActual(CompletableObserver completableObserver) {
        Disposable disposable = Disposables.empty();
        completableObserver.onSubscribe(disposable);
        try {
            this.run.run();
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
