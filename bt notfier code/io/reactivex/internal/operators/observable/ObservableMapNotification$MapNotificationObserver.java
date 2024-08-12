/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.CompositeException
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.functions.ObjectHelper
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;

static final class ObservableMapNotification.MapNotificationObserver<T, R>
implements Observer<T>,
Disposable {
    final Observer<? super ObservableSource<? extends R>> downstream;
    final Callable<? extends ObservableSource<? extends R>> onCompleteSupplier;
    final Function<? super Throwable, ? extends ObservableSource<? extends R>> onErrorMapper;
    final Function<? super T, ? extends ObservableSource<? extends R>> onNextMapper;
    Disposable upstream;

    ObservableMapNotification.MapNotificationObserver(Observer<? super ObservableSource<? extends R>> observer, Function<? super T, ? extends ObservableSource<? extends R>> function, Function<? super Throwable, ? extends ObservableSource<? extends R>> function2, Callable<? extends ObservableSource<? extends R>> callable) {
        this.downstream = observer;
        this.onNextMapper = function;
        this.onErrorMapper = function2;
        this.onCompleteSupplier = callable;
    }

    public void dispose() {
        this.upstream.dispose();
    }

    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    public void onComplete() {
        ObservableSource observableSource;
        try {
            observableSource = (ObservableSource)ObjectHelper.requireNonNull(this.onCompleteSupplier.call(), (String)"The onComplete ObservableSource returned is null");
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            this.downstream.onError(throwable);
            return;
        }
        this.downstream.onNext((Object)observableSource);
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        ObservableSource observableSource;
        try {
            observableSource = (ObservableSource)ObjectHelper.requireNonNull((Object)this.onErrorMapper.apply((Object)throwable), (String)"The onError ObservableSource returned is null");
        }
        catch (Throwable throwable2) {
            Exceptions.throwIfFatal((Throwable)throwable2);
            this.downstream.onError((Throwable)new CompositeException(new Throwable[]{throwable, throwable2}));
            return;
        }
        this.downstream.onNext((Object)observableSource);
        this.downstream.onComplete();
    }

    public void onNext(T object) {
        try {
            object = (ObservableSource)ObjectHelper.requireNonNull((Object)this.onNextMapper.apply(object), (String)"The onNext ObservableSource returned is null");
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            this.downstream.onError(throwable);
            return;
        }
        this.downstream.onNext(object);
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.downstream.onSubscribe((Disposable)this);
    }
}
