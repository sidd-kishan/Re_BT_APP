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
import java.util.concurrent.atomic.AtomicInteger;

static final class SingleDoFinally.DoFinallyObserver<T>
extends AtomicInteger
implements SingleObserver<T>,
Disposable {
    private static final long serialVersionUID = 4109457741734051389L;
    final SingleObserver<? super T> downstream;
    final Action onFinally;
    Disposable upstream;

    SingleDoFinally.DoFinallyObserver(SingleObserver<? super T> singleObserver, Action action) {
        this.downstream = singleObserver;
        this.onFinally = action;
    }

    public void dispose() {
        this.upstream.dispose();
        this.runFinally();
    }

    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
        this.runFinally();
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.downstream.onSubscribe((Disposable)this);
    }

    public void onSuccess(T t) {
        this.downstream.onSuccess(t);
        this.runFinally();
    }

    void runFinally() {
        if (!this.compareAndSet(0, 1)) return;
        try {
            this.onFinally.run();
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }
}
