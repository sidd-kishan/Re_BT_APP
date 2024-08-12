/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.CompositeException
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.disposables.DisposableHelper
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;

static final class ObservableOnErrorReturn.OnErrorReturnObserver<T>
implements Observer<T>,
Disposable {
    final Observer<? super T> downstream;
    Disposable upstream;
    final Function<? super Throwable, ? extends T> valueSupplier;

    ObservableOnErrorReturn.OnErrorReturnObserver(Observer<? super T> observer, Function<? super Throwable, ? extends T> function) {
        this.downstream = observer;
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
        block2: {
            try {
                object = this.valueSupplier.apply((Object)throwable);
                if (object != null) break block2;
                object = new NullPointerException("The supplied value is null");
            }
            catch (Throwable throwable2) {
                Exceptions.throwIfFatal((Throwable)throwable2);
                this.downstream.onError((Throwable)new CompositeException(new Throwable[]{throwable, throwable2}));
                return;
            }
            ((Throwable)object).initCause(throwable);
            this.downstream.onError((Throwable)object);
            return;
        }
        this.downstream.onNext(object);
        this.downstream.onComplete();
    }

    public void onNext(T t) {
        this.downstream.onNext(t);
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.downstream.onSubscribe((Disposable)this);
    }
}
