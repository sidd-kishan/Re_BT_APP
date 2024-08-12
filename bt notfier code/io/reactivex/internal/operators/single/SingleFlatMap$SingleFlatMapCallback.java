/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.SingleObserver
 *  io.reactivex.SingleSource
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.single.SingleFlatMap$SingleFlatMapCallback$FlatMapSingleObserver
 */
package io.reactivex.internal.operators.single;

import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.single.SingleFlatMap;
import java.util.concurrent.atomic.AtomicReference;

static final class SingleFlatMap.SingleFlatMapCallback<T, R>
extends AtomicReference<Disposable>
implements SingleObserver<T>,
Disposable {
    private static final long serialVersionUID = 3258103020495908596L;
    final SingleObserver<? super R> downstream;
    final Function<? super T, ? extends SingleSource<? extends R>> mapper;

    SingleFlatMap.SingleFlatMapCallback(SingleObserver<? super R> singleObserver, Function<? super T, ? extends SingleSource<? extends R>> function) {
        this.downstream = singleObserver;
        this.mapper = function;
    }

    public void dispose() {
        DisposableHelper.dispose((AtomicReference)this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable)((Disposable)this.get()));
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
            object = (SingleSource)ObjectHelper.requireNonNull((Object)this.mapper.apply(object), (String)"The single returned by the mapper is null");
            if (this.isDisposed()) return;
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            this.downstream.onError(throwable);
            return;
        }
        object.subscribe((SingleObserver)new FlatMapSingleObserver((AtomicReference)this, this.downstream));
    }
}
