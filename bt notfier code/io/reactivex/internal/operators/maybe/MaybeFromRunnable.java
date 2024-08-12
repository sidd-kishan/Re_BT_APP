/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Maybe
 *  io.reactivex.MaybeObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.disposables.Disposables
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

public final class MaybeFromRunnable<T>
extends Maybe<T>
implements Callable<T> {
    final Runnable runnable;

    public MaybeFromRunnable(Runnable runnable) {
        this.runnable = runnable;
    }

    @Override
    public T call() throws Exception {
        this.runnable.run();
        return null;
    }

    protected void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        block4: {
            Disposable disposable = Disposables.empty();
            maybeObserver.onSubscribe(disposable);
            if (disposable.isDisposed()) return;
            try {
                this.runnable.run();
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                if (!disposable.isDisposed()) {
                    maybeObserver.onError(throwable);
                } else {
                    RxJavaPlugins.onError((Throwable)throwable);
                }
                break block4;
            }
            if (disposable.isDisposed()) return;
            maybeObserver.onComplete();
        }
    }
}
