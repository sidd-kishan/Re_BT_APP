/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.BiFunction
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.MaybeObserver;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;

static final class ObservableReduceMaybe.ReduceObserver<T>
implements Observer<T>,
Disposable {
    boolean done;
    final MaybeObserver<? super T> downstream;
    final BiFunction<T, T, T> reducer;
    Disposable upstream;
    T value;

    ObservableReduceMaybe.ReduceObserver(MaybeObserver<? super T> maybeObserver, BiFunction<T, T, T> biFunction) {
        this.downstream = maybeObserver;
        this.reducer = biFunction;
    }

    public void dispose() {
        this.upstream.dispose();
    }

    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        T t = this.value;
        this.value = null;
        if (t != null) {
            this.downstream.onSuccess(t);
        } else {
            this.downstream.onComplete();
        }
    }

    public void onError(Throwable throwable) {
        if (this.done) {
            RxJavaPlugins.onError((Throwable)throwable);
            return;
        }
        this.done = true;
        this.value = null;
        this.downstream.onError(throwable);
    }

    public void onNext(T t) {
        if (this.done) return;
        T t2 = this.value;
        if (t2 == null) {
            this.value = t;
        } else {
            try {
                this.value = ObjectHelper.requireNonNull((Object)this.reducer.apply(t2, t), (String)"The reducer returned a null value");
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                this.upstream.dispose();
                this.onError(throwable);
            }
        }
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.downstream.onSubscribe((Disposable)this);
    }
}
