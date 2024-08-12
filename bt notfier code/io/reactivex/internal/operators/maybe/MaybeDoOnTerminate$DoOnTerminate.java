/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.CompositeException
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.internal.operators.maybe.MaybeDoOnTerminate
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.operators.maybe.MaybeDoOnTerminate;

final class MaybeDoOnTerminate.DoOnTerminate
implements MaybeObserver<T> {
    final MaybeObserver<? super T> downstream;
    final MaybeDoOnTerminate this$0;

    MaybeDoOnTerminate.DoOnTerminate(MaybeDoOnTerminate maybeDoOnTerminate, MaybeObserver<? super T> maybeObserver) {
        this.this$0 = maybeDoOnTerminate;
        this.downstream = maybeObserver;
    }

    public void onComplete() {
        try {
            this.this$0.onTerminate.run();
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            this.downstream.onError(throwable);
            return;
        }
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        try {
            this.this$0.onTerminate.run();
        }
        catch (Throwable throwable2) {
            Exceptions.throwIfFatal((Throwable)throwable2);
            throwable = new CompositeException(new Throwable[]{throwable, throwable2});
        }
        this.downstream.onError(throwable);
    }

    public void onSubscribe(Disposable disposable) {
        this.downstream.onSubscribe(disposable);
    }

    public void onSuccess(T t) {
        try {
            this.this$0.onTerminate.run();
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            this.downstream.onError(throwable);
            return;
        }
        this.downstream.onSuccess(t);
    }
}
