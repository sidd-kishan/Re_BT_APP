/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.SingleObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.functions.ObjectHelper
 */
package io.reactivex.internal.operators.single;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;

static final class SingleMap.MapSingleObserver<T, R>
implements SingleObserver<T> {
    final Function<? super T, ? extends R> mapper;
    final SingleObserver<? super R> t;

    SingleMap.MapSingleObserver(SingleObserver<? super R> singleObserver, Function<? super T, ? extends R> function) {
        this.t = singleObserver;
        this.mapper = function;
    }

    public void onError(Throwable throwable) {
        this.t.onError(throwable);
    }

    public void onSubscribe(Disposable disposable) {
        this.t.onSubscribe(disposable);
    }

    public void onSuccess(T object) {
        try {
            object = ObjectHelper.requireNonNull((Object)this.mapper.apply(object), (String)"The mapper function returned a null value.");
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            this.onError(throwable);
            return;
        }
        this.t.onSuccess(object);
    }
}
