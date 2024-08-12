/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.CompletableObserver
 *  io.reactivex.SingleObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.internal.operators.completable.CompletableToSingle
 */
package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.operators.completable.CompletableToSingle;

final class CompletableToSingle.ToSingle
implements CompletableObserver {
    private final SingleObserver<? super T> observer;
    final CompletableToSingle this$0;

    CompletableToSingle.ToSingle(CompletableToSingle completableToSingle, SingleObserver<? super T> singleObserver) {
        this.this$0 = completableToSingle;
        this.observer = singleObserver;
    }

    public void onComplete() {
        Object object;
        if (this.this$0.completionValueSupplier != null) {
            try {
                object = this.this$0.completionValueSupplier.call();
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                this.observer.onError(throwable);
                return;
            }
        } else {
            object = this.this$0.completionValue;
        }
        if (object == null) {
            this.observer.onError((Throwable)new NullPointerException("The value supplied is null"));
        } else {
            this.observer.onSuccess(object);
        }
    }

    public void onError(Throwable throwable) {
        this.observer.onError(throwable);
    }

    public void onSubscribe(Disposable disposable) {
        this.observer.onSubscribe(disposable);
    }
}
