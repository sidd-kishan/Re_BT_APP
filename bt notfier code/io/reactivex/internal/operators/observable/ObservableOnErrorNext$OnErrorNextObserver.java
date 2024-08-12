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
 *  io.reactivex.internal.disposables.SequentialDisposable
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.plugins.RxJavaPlugins;

static final class ObservableOnErrorNext.OnErrorNextObserver<T>
implements Observer<T> {
    final boolean allowFatal;
    final SequentialDisposable arbiter;
    boolean done;
    final Observer<? super T> downstream;
    final Function<? super Throwable, ? extends ObservableSource<? extends T>> nextSupplier;
    boolean once;

    ObservableOnErrorNext.OnErrorNextObserver(Observer<? super T> observer, Function<? super Throwable, ? extends ObservableSource<? extends T>> function, boolean bl) {
        this.downstream = observer;
        this.nextSupplier = function;
        this.allowFatal = bl;
        this.arbiter = new SequentialDisposable();
    }

    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        this.once = true;
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        Object object;
        block5: {
            if (this.once) {
                if (this.done) {
                    RxJavaPlugins.onError((Throwable)throwable);
                    return;
                }
                this.downstream.onError(throwable);
                return;
            }
            this.once = true;
            if (this.allowFatal && !(throwable instanceof Exception)) {
                this.downstream.onError(throwable);
                return;
            }
            try {
                object = (ObservableSource)this.nextSupplier.apply((Object)throwable);
                if (object != null) break block5;
                object = new NullPointerException("Observable is null");
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
        object.subscribe((Observer)this);
    }

    public void onNext(T t) {
        if (this.done) {
            return;
        }
        this.downstream.onNext(t);
    }

    public void onSubscribe(Disposable disposable) {
        this.arbiter.replace(disposable);
    }
}
