/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.BiFunction
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.functions.ObjectHelper
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;

static final class MaybeFlatMapBiSelector.FlatMapBiMainObserver.InnerObserver<T, U, R>
extends AtomicReference<Disposable>
implements MaybeObserver<U> {
    private static final long serialVersionUID = -2897979525538174559L;
    final MaybeObserver<? super R> downstream;
    final BiFunction<? super T, ? super U, ? extends R> resultSelector;
    T value;

    MaybeFlatMapBiSelector.FlatMapBiMainObserver.InnerObserver(MaybeObserver<? super R> maybeObserver, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        this.downstream = maybeObserver;
        this.resultSelector = biFunction;
    }

    public void onComplete() {
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce((AtomicReference)this, (Disposable)disposable);
    }

    public void onSuccess(U object) {
        T t = this.value;
        this.value = null;
        try {
            object = ObjectHelper.requireNonNull((Object)this.resultSelector.apply(t, object), (String)"The resultSelector returned a null value");
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            this.downstream.onError(throwable);
            return;
        }
        this.downstream.onSuccess(object);
    }
}
