/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.MaybeSource
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.BiFunction
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.maybe.MaybeFlatMapBiSelector$FlatMapBiMainObserver$InnerObserver
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.maybe.MaybeFlatMapBiSelector;

static final class MaybeFlatMapBiSelector.FlatMapBiMainObserver<T, U, R>
implements MaybeObserver<T>,
Disposable {
    final InnerObserver<T, U, R> inner;
    final Function<? super T, ? extends MaybeSource<? extends U>> mapper;

    MaybeFlatMapBiSelector.FlatMapBiMainObserver(MaybeObserver<? super R> maybeObserver, Function<? super T, ? extends MaybeSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        this.inner = new InnerObserver(maybeObserver, biFunction);
        this.mapper = function;
    }

    public void dispose() {
        DisposableHelper.dispose(this.inner);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable)((Disposable)this.inner.get()));
    }

    public void onComplete() {
        this.inner.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        this.inner.downstream.onError(throwable);
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.setOnce(this.inner, (Disposable)disposable)) return;
        this.inner.downstream.onSubscribe((Disposable)this);
    }

    public void onSuccess(T t) {
        MaybeSource maybeSource;
        try {
            maybeSource = (MaybeSource)ObjectHelper.requireNonNull((Object)this.mapper.apply(t), (String)"The mapper returned a null MaybeSource");
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            this.inner.downstream.onError(throwable);
            return;
        }
        if (!DisposableHelper.replace(this.inner, null)) return;
        this.inner.value = t;
        maybeSource.subscribe(this.inner);
    }
}
