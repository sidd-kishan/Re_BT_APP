/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.MaybeSource
 *  io.reactivex.SingleObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.single.SingleFlatMapMaybe$FlatMapMaybeObserver
 */
package io.reactivex.internal.operators.single;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.single.SingleFlatMapMaybe;
import java.util.concurrent.atomic.AtomicReference;

static final class SingleFlatMapMaybe.FlatMapSingleObserver<T, R>
extends AtomicReference<Disposable>
implements SingleObserver<T>,
Disposable {
    private static final long serialVersionUID = -5843758257109742742L;
    final MaybeObserver<? super R> downstream;
    final Function<? super T, ? extends MaybeSource<? extends R>> mapper;

    SingleFlatMapMaybe.FlatMapSingleObserver(MaybeObserver<? super R> maybeObserver, Function<? super T, ? extends MaybeSource<? extends R>> function) {
        this.downstream = maybeObserver;
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
            object = (MaybeSource)ObjectHelper.requireNonNull((Object)this.mapper.apply(object), (String)"The mapper returned a null MaybeSource");
            if (this.isDisposed()) return;
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            this.onError(throwable);
            return;
        }
        object.subscribe((MaybeObserver)new SingleFlatMapMaybe.FlatMapMaybeObserver((AtomicReference)this, this.downstream));
    }
}
