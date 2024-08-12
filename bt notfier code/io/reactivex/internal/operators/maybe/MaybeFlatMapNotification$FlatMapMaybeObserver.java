/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.MaybeSource
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.CompositeException
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.maybe.MaybeFlatMapNotification$FlatMapMaybeObserver$InnerObserver
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.maybe.MaybeFlatMapNotification;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

static final class MaybeFlatMapNotification.FlatMapMaybeObserver<T, R>
extends AtomicReference<Disposable>
implements MaybeObserver<T>,
Disposable {
    private static final long serialVersionUID = 4375739915521278546L;
    final MaybeObserver<? super R> downstream;
    final Callable<? extends MaybeSource<? extends R>> onCompleteSupplier;
    final Function<? super Throwable, ? extends MaybeSource<? extends R>> onErrorMapper;
    final Function<? super T, ? extends MaybeSource<? extends R>> onSuccessMapper;
    Disposable upstream;

    MaybeFlatMapNotification.FlatMapMaybeObserver(MaybeObserver<? super R> maybeObserver, Function<? super T, ? extends MaybeSource<? extends R>> function, Function<? super Throwable, ? extends MaybeSource<? extends R>> function2, Callable<? extends MaybeSource<? extends R>> callable) {
        this.downstream = maybeObserver;
        this.onSuccessMapper = function;
        this.onErrorMapper = function2;
        this.onCompleteSupplier = callable;
    }

    public void dispose() {
        DisposableHelper.dispose((AtomicReference)this);
        this.upstream.dispose();
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((Disposable)((Disposable)this.get()));
    }

    public void onComplete() {
        MaybeSource maybeSource;
        try {
            maybeSource = (MaybeSource)ObjectHelper.requireNonNull(this.onCompleteSupplier.call(), (String)"The onCompleteSupplier returned a null MaybeSource");
        }
        catch (Exception exception) {
            Exceptions.throwIfFatal((Throwable)exception);
            this.downstream.onError((Throwable)exception);
            return;
        }
        maybeSource.subscribe((MaybeObserver)new InnerObserver(this));
    }

    public void onError(Throwable throwable) {
        MaybeSource maybeSource;
        try {
            maybeSource = (MaybeSource)ObjectHelper.requireNonNull((Object)this.onErrorMapper.apply((Object)throwable), (String)"The onErrorMapper returned a null MaybeSource");
        }
        catch (Exception exception) {
            Exceptions.throwIfFatal((Throwable)exception);
            this.downstream.onError((Throwable)new CompositeException(new Throwable[]{throwable, exception}));
            return;
        }
        maybeSource.subscribe((MaybeObserver)new InnerObserver(this));
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.downstream.onSubscribe((Disposable)this);
    }

    public void onSuccess(T object) {
        try {
            object = (MaybeSource)ObjectHelper.requireNonNull((Object)this.onSuccessMapper.apply(object), (String)"The onSuccessMapper returned a null MaybeSource");
        }
        catch (Exception exception) {
            Exceptions.throwIfFatal((Throwable)exception);
            this.downstream.onError((Throwable)exception);
            return;
        }
        object.subscribe((MaybeObserver)new InnerObserver(this));
    }
}
