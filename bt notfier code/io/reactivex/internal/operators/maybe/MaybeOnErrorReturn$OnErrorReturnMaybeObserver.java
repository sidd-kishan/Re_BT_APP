/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.CompositeException
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.functions.ObjectHelper
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;

static final class MaybeOnErrorReturn.OnErrorReturnMaybeObserver<T>
implements MaybeObserver<T>,
Disposable {
    final MaybeObserver<? super T> downstream;
    Disposable upstream;
    final Function<? super Throwable, ? extends T> valueSupplier;

    MaybeOnErrorReturn.OnErrorReturnMaybeObserver(MaybeObserver<? super T> maybeObserver, Function<? super Throwable, ? extends T> function) {
        this.downstream = maybeObserver;
        this.valueSupplier = function;
    }

    public void dispose() {
        this.upstream.dispose();
    }

    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    public void onComplete() {
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        Object object;
        try {
            object = ObjectHelper.requireNonNull((Object)this.valueSupplier.apply((Object)throwable), (String)"The valueSupplier returned a null value");
        }
        catch (Throwable throwable2) {
            Exceptions.throwIfFatal((Throwable)throwable2);
            this.downstream.onError((Throwable)new CompositeException(new Throwable[]{throwable, throwable2}));
            return;
        }
        this.downstream.onSuccess(object);
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.downstream.onSubscribe((Disposable)this);
    }

    public void onSuccess(T t) {
        this.downstream.onSuccess(t);
    }
}
