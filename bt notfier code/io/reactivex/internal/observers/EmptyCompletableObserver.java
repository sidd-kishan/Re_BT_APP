/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.CompletableObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.OnErrorNotImplementedException
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.observers.LambdaConsumerIntrospection
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.observers;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.LambdaConsumerIntrospection;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class EmptyCompletableObserver
extends AtomicReference<Disposable>
implements CompletableObserver,
Disposable,
LambdaConsumerIntrospection {
    private static final long serialVersionUID = -7545121636549663526L;

    public void dispose() {
        DisposableHelper.dispose((AtomicReference)this);
    }

    public boolean hasCustomOnError() {
        return false;
    }

    public boolean isDisposed() {
        boolean bl = this.get() == DisposableHelper.DISPOSED;
        return bl;
    }

    public void onComplete() {
        this.lazySet(DisposableHelper.DISPOSED);
    }

    public void onError(Throwable throwable) {
        this.lazySet(DisposableHelper.DISPOSED);
        RxJavaPlugins.onError((Throwable)new OnErrorNotImplementedException(throwable));
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce((AtomicReference)this, (Disposable)disposable);
    }
}
