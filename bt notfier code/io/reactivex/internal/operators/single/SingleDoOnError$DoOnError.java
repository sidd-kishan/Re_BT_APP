/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.SingleObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.CompositeException
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.internal.operators.single.SingleDoOnError
 */
package io.reactivex.internal.operators.single;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.operators.single.SingleDoOnError;

final class SingleDoOnError.DoOnError
implements SingleObserver<T> {
    private final SingleObserver<? super T> downstream;
    final SingleDoOnError this$0;

    SingleDoOnError.DoOnError(SingleDoOnError singleDoOnError, SingleObserver<? super T> singleObserver) {
        this.this$0 = singleDoOnError;
        this.downstream = singleObserver;
    }

    public void onError(Throwable throwable) {
        try {
            this.this$0.onError.accept((Object)throwable);
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
        this.downstream.onSuccess(t);
    }
}
