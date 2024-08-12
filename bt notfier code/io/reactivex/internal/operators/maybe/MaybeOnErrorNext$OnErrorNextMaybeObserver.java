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
 *  io.reactivex.internal.operators.maybe.MaybeOnErrorNext$OnErrorNextMaybeObserver$NextMaybeObserver
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
import io.reactivex.internal.operators.maybe.MaybeOnErrorNext;
import java.util.concurrent.atomic.AtomicReference;

static final class MaybeOnErrorNext.OnErrorNextMaybeObserver<T>
extends AtomicReference<Disposable>
implements MaybeObserver<T>,
Disposable {
    private static final long serialVersionUID = 2026620218879969836L;
    final boolean allowFatal;
    final MaybeObserver<? super T> downstream;
    final Function<? super Throwable, ? extends MaybeSource<? extends T>> resumeFunction;

    MaybeOnErrorNext.OnErrorNextMaybeObserver(MaybeObserver<? super T> maybeObserver, Function<? super Throwable, ? extends MaybeSource<? extends T>> function, boolean bl) {
        this.downstream = maybeObserver;
        this.resumeFunction = function;
        this.allowFatal = bl;
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
        MaybeSource maybeSource;
        if (!this.allowFatal && !(throwable instanceof Exception)) {
            this.downstream.onError(throwable);
            return;
        }
        try {
            maybeSource = (MaybeSource)ObjectHelper.requireNonNull((Object)this.resumeFunction.apply((Object)throwable), (String)"The resumeFunction returned a null MaybeSource");
        }
        catch (Throwable throwable2) {
            Exceptions.throwIfFatal((Throwable)throwable2);
            this.downstream.onError((Throwable)new CompositeException(new Throwable[]{throwable, throwable2}));
            return;
        }
        DisposableHelper.replace((AtomicReference)this, null);
        maybeSource.subscribe((MaybeObserver)new NextMaybeObserver(this.downstream, (AtomicReference)this));
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.setOnce((AtomicReference)this, (Disposable)disposable)) return;
        this.downstream.onSubscribe((Disposable)this);
    }

    public void onSuccess(T t) {
        this.downstream.onSuccess(t);
    }
}
