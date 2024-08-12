/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.SingleObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Action
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.single;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

static final class SingleDoOnDispose.DoOnDisposeObserver<T>
extends AtomicReference<Action>
implements SingleObserver<T>,
Disposable {
    private static final long serialVersionUID = -8583764624474935784L;
    final SingleObserver<? super T> downstream;
    Disposable upstream;

    SingleDoOnDispose.DoOnDisposeObserver(SingleObserver<? super T> singleObserver, Action action) {
        this.downstream = singleObserver;
        this.lazySet(action);
    }

    public void dispose() {
        Action action = this.getAndSet(null);
        if (action == null) return;
        try {
            action.run();
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            RxJavaPlugins.onError((Throwable)throwable);
        }
        this.upstream.dispose();
    }

    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
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
