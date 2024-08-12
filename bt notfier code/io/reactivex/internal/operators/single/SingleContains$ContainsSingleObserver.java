/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.SingleObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.internal.operators.single.SingleContains
 */
package io.reactivex.internal.operators.single;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.operators.single.SingleContains;

final class SingleContains.ContainsSingleObserver
implements SingleObserver<T> {
    private final SingleObserver<? super Boolean> downstream;
    final SingleContains this$0;

    SingleContains.ContainsSingleObserver(SingleContains singleContains, SingleObserver<? super Boolean> singleObserver) {
        this.this$0 = singleContains;
        this.downstream = singleObserver;
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
    }

    public void onSubscribe(Disposable disposable) {
        this.downstream.onSubscribe(disposable);
    }

    public void onSuccess(T t) {
        boolean bl;
        try {
            bl = this.this$0.comparer.test(t, this.this$0.value);
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            this.downstream.onError(throwable);
            return;
        }
        this.downstream.onSuccess((Object)bl);
    }
}
