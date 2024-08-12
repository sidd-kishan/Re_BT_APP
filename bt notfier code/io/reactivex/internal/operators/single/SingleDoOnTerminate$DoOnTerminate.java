/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.SingleObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.CompositeException
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.internal.operators.single.SingleDoOnTerminate
 */
package io.reactivex.internal.operators.single;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.operators.single.SingleDoOnTerminate;

final class SingleDoOnTerminate.DoOnTerminate
implements SingleObserver<T> {
    final SingleObserver<? super T> downstream;
    final SingleDoOnTerminate this$0;

    SingleDoOnTerminate.DoOnTerminate(SingleDoOnTerminate singleDoOnTerminate, SingleObserver<? super T> singleObserver) {
        this.this$0 = singleDoOnTerminate;
        this.downstream = singleObserver;
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
