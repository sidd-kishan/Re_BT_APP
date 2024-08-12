/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.SingleObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.CompositeException
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.internal.operators.single.SingleDoOnEvent
 */
package io.reactivex.internal.operators.single;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.operators.single.SingleDoOnEvent;

final class SingleDoOnEvent.DoOnEvent
implements SingleObserver<T> {
    private final SingleObserver<? super T> downstream;
    final SingleDoOnEvent this$0;

    SingleDoOnEvent.DoOnEvent(SingleDoOnEvent singleDoOnEvent, SingleObserver<? super T> singleObserver) {
        this.this$0 = singleDoOnEvent;
        this.downstream = singleObserver;
    }

    public void onError(Throwable throwable) {
        try {
            this.this$0.onEvent.accept(null, (Object)throwable);
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
            this.this$0.onEvent.accept(t, null);
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            this.downstream.onError(throwable);
            return;
        }
        this.downstream.onSuccess(t);
    }
}
