/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.MaybeSource
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.maybe.MaybeFlatten$FlatMapMaybeObserver$InnerObserver
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.maybe.MaybeFlatten;
import java.util.concurrent.atomic.AtomicReference;

static final class MaybeFlatten.FlatMapMaybeObserver<T, R>
extends AtomicReference<Disposable>
implements MaybeObserver<T>,
Disposable {
    private static final long serialVersionUID = 4375739915521278546L;
    final MaybeObserver<? super R> downstream;
    final Function<? super T, ? extends MaybeSource<? extends R>> mapper;
    Disposable upstream;

    MaybeFlatten.FlatMapMaybeObserver(MaybeObserver<? super R> maybeObserver, Function<? super T, ? extends MaybeSource<? extends R>> function) {
        this.downstream = maybeObserver;
        this.mapper = function;
    }

    public void dispose() {
        DisposableHelper.dispose((AtomicReference)this);
        this.upstream.dispose();
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
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.downstream.onSubscribe((Disposable)this);
    }

    public void onSuccess(T object) {
        try {
            object = (MaybeSource)ObjectHelper.requireNonNull((Object)this.mapper.apply(object), (String)"The mapper returned a null MaybeSource");
            if (this.isDisposed()) return;
        }
        catch (Exception exception) {
            Exceptions.throwIfFatal((Throwable)exception);
            this.downstream.onError((Throwable)exception);
            return;
        }
        object.subscribe((MaybeObserver)new InnerObserver(this));
    }
}
