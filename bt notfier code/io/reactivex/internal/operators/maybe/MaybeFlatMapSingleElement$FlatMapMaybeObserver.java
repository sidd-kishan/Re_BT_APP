/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.SingleObserver
 *  io.reactivex.SingleSource
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.maybe.MaybeFlatMapSingleElement$FlatMapSingleObserver
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.maybe.MaybeFlatMapSingleElement;
import java.util.concurrent.atomic.AtomicReference;

static final class MaybeFlatMapSingleElement.FlatMapMaybeObserver<T, R>
extends AtomicReference<Disposable>
implements MaybeObserver<T>,
Disposable {
    private static final long serialVersionUID = 4827726964688405508L;
    final MaybeObserver<? super R> downstream;
    final Function<? super T, ? extends SingleSource<? extends R>> mapper;

    MaybeFlatMapSingleElement.FlatMapMaybeObserver(MaybeObserver<? super R> maybeObserver, Function<? super T, ? extends SingleSource<? extends R>> function) {
        this.downstream = maybeObserver;
        this.mapper = function;
    }

    public void dispose() {
        DisposableHelper.dispose((AtomicReference)this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable)((Disposable)this.get()));
    }

    public void onComplete() {
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.setOnce((AtomicReference)this, (Disposable)disposable)) return;
        this.downstream.onSubscribe((Disposable)this);
    }

    public void onSuccess(T object) {
        try {
            object = (SingleSource)ObjectHelper.requireNonNull((Object)this.mapper.apply(object), (String)"The mapper returned a null SingleSource");
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            this.onError(throwable);
            return;
        }
        object.subscribe((SingleObserver)new MaybeFlatMapSingleElement.FlatMapSingleObserver((AtomicReference)this, this.downstream));
    }
}
