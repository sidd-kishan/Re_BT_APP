/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.SingleObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.internal.operators.single.SingleDoOnSuccess
 */
package io.reactivex.internal.operators.single;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.operators.single.SingleDoOnSuccess;

final class SingleDoOnSuccess.DoOnSuccess
implements SingleObserver<T> {
    final SingleObserver<? super T> downstream;
    final SingleDoOnSuccess this$0;

    SingleDoOnSuccess.DoOnSuccess(SingleDoOnSuccess singleDoOnSuccess, SingleObserver<? super T> singleObserver) {
        this.this$0 = singleDoOnSuccess;
        this.downstream = singleObserver;
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
    }

    public void onSubscribe(Disposable disposable) {
        this.downstream.onSubscribe(disposable);
    }

    public void onSuccess(T t) {
        try {
            this.this$0.onSuccess.accept(t);
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            this.downstream.onError(throwable);
            return;
        }
        this.downstream.onSuccess(t);
    }
}
