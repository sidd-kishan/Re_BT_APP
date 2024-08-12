/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.SingleObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.CompositeException
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.internal.operators.single.SingleOnErrorReturn
 */
package io.reactivex.internal.operators.single;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.operators.single.SingleOnErrorReturn;

final class SingleOnErrorReturn.OnErrorReturn
implements SingleObserver<T> {
    private final SingleObserver<? super T> observer;
    final SingleOnErrorReturn this$0;

    SingleOnErrorReturn.OnErrorReturn(SingleOnErrorReturn singleOnErrorReturn, SingleObserver<? super T> singleObserver) {
        this.this$0 = singleOnErrorReturn;
        this.observer = singleObserver;
    }

    public void onError(Throwable throwable) {
        Object object;
        if (this.this$0.valueSupplier != null) {
            try {
                object = this.this$0.valueSupplier.apply((Object)throwable);
            }
            catch (Throwable throwable2) {
                Exceptions.throwIfFatal((Throwable)throwable2);
                this.observer.onError((Throwable)new CompositeException(new Throwable[]{throwable, throwable2}));
                return;
            }
        } else {
            object = this.this$0.value;
        }
        if (object == null) {
            object = new NullPointerException("Value supplied was null");
            ((Throwable)object).initCause(throwable);
            this.observer.onError((Throwable)object);
            return;
        }
        this.observer.onSuccess(object);
    }

    public void onSubscribe(Disposable disposable) {
        this.observer.onSubscribe(disposable);
    }

    public void onSuccess(T t) {
        this.observer.onSuccess(t);
    }
}
