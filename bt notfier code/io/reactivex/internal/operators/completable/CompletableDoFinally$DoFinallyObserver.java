/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.CompletableObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Action
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;

static final class CompletableDoFinally.DoFinallyObserver
extends AtomicInteger
implements CompletableObserver,
Disposable {
    private static final long serialVersionUID = 4109457741734051389L;
    final CompletableObserver downstream;
    final Action onFinally;
    Disposable upstream;

    CompletableDoFinally.DoFinallyObserver(CompletableObserver completableObserver, Action action) {
        this.downstream = completableObserver;
        this.onFinally = action;
    }

    public void dispose() {
        this.upstream.dispose();
        this.runFinally();
    }

    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    public void onComplete() {
        this.downstream.onComplete();
        this.runFinally();
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
