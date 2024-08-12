/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.CompositeException
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Action
 *  io.reactivex.functions.Consumer
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.functions.Functions
 *  io.reactivex.observers.LambdaConsumerIntrospection
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.Functions;
import io.reactivex.observers.LambdaConsumerIntrospection;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class LambdaObserver<T>
extends AtomicReference<Disposable>
implements Observer<T>,
Disposable,
LambdaConsumerIntrospection {
    private static final long serialVersionUID = -7251123623727029452L;
    final Action onComplete;
    final Consumer<? super Throwable> onError;
    final Consumer<? super T> onNext;
    final Consumer<? super Disposable> onSubscribe;

    public LambdaObserver(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Consumer<? super Disposable> consumer3) {
        this.onNext = consumer;
        this.onError = consumer2;
        this.onComplete = action;
        this.onSubscribe = consumer3;
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

    public void onComplete() {
        if (this.isDisposed()) return;
        this.lazySet(DisposableHelper.DISPOSED);
        try {
            this.onComplete.run();
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void onError(Throwable throwable) {
        if (!this.isDisposed()) {
            this.lazySet(DisposableHelper.DISPOSED);
            try {
                this.onError.accept((Object)throwable);
            }
            catch (Throwable throwable2) {
                Exceptions.throwIfFatal((Throwable)throwable2);
                RxJavaPlugins.onError((Throwable)new CompositeException(new Throwable[]{throwable, throwable2}));
            }
        } else {
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }

    public void onNext(T t) {
        if (this.isDisposed()) return;
        try {
            this.onNext.accept(t);
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            ((Disposable)this.get()).dispose();
            this.onError(throwable);
        }
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.setOnce((AtomicReference)this, (Disposable)disposable)) return;
        try {
            this.onSubscribe.accept((Object)this);
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            disposable.dispose();
            this.onError(throwable);
        }
    }
}
