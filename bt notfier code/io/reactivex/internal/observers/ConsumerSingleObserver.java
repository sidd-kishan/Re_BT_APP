/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.SingleObserver
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.CompositeException
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Consumer
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.functions.Functions
 *  io.reactivex.observers.LambdaConsumerIntrospection
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.observers;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.Functions;
import io.reactivex.observers.LambdaConsumerIntrospection;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class ConsumerSingleObserver<T>
extends AtomicReference<Disposable>
implements SingleObserver<T>,
Disposable,
LambdaConsumerIntrospection {
    private static final long serialVersionUID = -7012088219455310787L;
    final Consumer<? super Throwable> onError;
    final Consumer<? super T> onSuccess;

    public ConsumerSingleObserver(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2) {
        this.onSuccess = consumer;
        this.onError = consumer2;
    }

    public void dispose() {
        DisposableHelper.dispose((AtomicReference)this);
    }

    public boolean hasCustomOnError() {
        boolean bl = this.onError != Functions.ON_ERROR_MISSING;
        return bl;
    }

    public boolean isDisposed() {
        boolean bl = this.get() == DisposableHelper.DISPOSED;
        return bl;
    }

    public void onError(Throwable throwable) {
        this.lazySet(DisposableHelper.DISPOSED);
        try {
            this.onError.accept((Object)throwable);
        }
        catch (Throwable throwable2) {
            Exceptions.throwIfFatal((Throwable)throwable2);
            RxJavaPlugins.onError((Throwable)new CompositeException(new Throwable[]{throwable, throwable2}));
        }
    }

    public void onSubscribe(Disposable disposable) {
        DisposableHelper.setOnce((AtomicReference)this, (Disposable)disposable);
    }

    public void onSuccess(T t) {
        this.lazySet(DisposableHelper.DISPOSED);
        try {
            this.onSuccess.accept(t);
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }
}
