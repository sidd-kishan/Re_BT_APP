/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.CompletableObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.exceptions.OnErrorNotImplementedException
 *  io.reactivex.functions.Action
 *  io.reactivex.functions.Consumer
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.observers.LambdaConsumerIntrospection
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.observers;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.LambdaConsumerIntrospection;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class CallbackCompletableObserver
extends AtomicReference<Disposable>
implements CompletableObserver,
Disposable,
Consumer<Throwable>,
LambdaConsumerIntrospection {
    private static final long serialVersionUID = -4361286194466301354L;
    final Action onComplete;
    final Consumer<? super Throwable> onError;

    public CallbackCompletableObserver(Action action) {
        this.onError = this;
        this.onComplete = action;
    }

    public CallbackCompletableObserver(Consumer<? super Throwable> consumer, Action action) {
        this.onError = consumer;
        this.onComplete = action;
    }

    public void accept(Throwable throwable) {
        RxJavaPlugins.onError((Throwable)new OnErrorNotImplementedException(throwable));
    }

    public void dispose() {
        DisposableHelper.dispose((AtomicReference)this);
    }

    public boolean hasCustomOnError() {
        boolean bl = this.onError != this;
        return bl;
    }

    public boolean isDisposed() {
        boolean bl = this.get() == DisposableHelper.DISPOSED;
        return bl;
    }

    public void onComplete() {
        try {
            this.onComplete.run();
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            RxJavaPlugins.onError((Throwable)throwable);
        }
        this.lazySet(DisposableHelper.DISPOSED);
    }

    public void onError(Throwable throwable) {
        try {
            this.onError.accept((Object)throwable);
        }
        catch (Throwable throwable2) {
            Exceptions.throwIfFatal((Throwable)throwable2);
            RxJavaPlugins.onError((Throwable)throwable2);
        }
        this.lazySet(DisposableHelper.DISPOSED);
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce((AtomicReference)this, (Disposable)disposable);
    }
}
