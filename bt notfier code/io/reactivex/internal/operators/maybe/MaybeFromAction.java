/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Maybe
 *  io.reactivex.MaybeObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.disposables.Disposables
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Action
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

public final class MaybeFromAction<T>
extends Maybe<T>
implements Callable<T> {
    final Action action;

    public MaybeFromAction(Action action) {
        this.action = action;
    }

    @Override
    public T call() throws Exception {
        this.action.run();
        return null;
    }

    protected void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        block4: {
            Disposable disposable = Disposables.empty();
            maybeObserver.onSubscribe(disposable);
            if (disposable.isDisposed()) return;
            try {
                this.action.run();
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
