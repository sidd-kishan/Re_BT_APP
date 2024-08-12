/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;

static final class ObservableFlattenIterable.FlattenIterableObserver<T, R>
implements Observer<T>,
Disposable {
    final Observer<? super R> downstream;
    final Function<? super T, ? extends Iterable<? extends R>> mapper;
    Disposable upstream;

    ObservableFlattenIterable.FlattenIterableObserver(Observer<? super R> observer, Function<? super T, ? extends Iterable<? extends R>> function) {
        this.downstream = observer;
        this.mapper = function;
    }

    public void dispose() {
        this.upstream.dispose();
        this.upstream = DisposableHelper.DISPOSED;
    }

    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    public void onComplete() {
        if (this.upstream == DisposableHelper.DISPOSED) {
            return;
        }
        this.upstream = DisposableHelper.DISPOSED;
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        if (this.upstream == DisposableHelper.DISPOSED) {
            RxJavaPlugins.onError((Throwable)throwable);
            return;
        }
        this.upstream = DisposableHelper.DISPOSED;
        this.downstream.onError(throwable);
    }

    public void onNext(T object) {
        Observer<? super R> observer;
        Iterator iterator;
        if (this.upstream == DisposableHelper.DISPOSED) {
            return;
        }
        try {
            iterator = ((Iterable)this.mapper.apply(object)).iterator();
            observer = this.downstream;
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            this.upstream.dispose();
            this.onError(throwable);
            return;
        }
        while (true) {
            try {
                boolean bl = iterator.hasNext();
                if (!bl) return;
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                this.upstream.dispose();
                this.onError(throwable);
                return;
            }
            try {
                object = ObjectHelper.requireNonNull(iterator.next(), (String)"The iterator returned a null value");
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                this.upstream.dispose();
                this.onError(throwable);
                break;
            }
            observer.onNext(object);
        }
        return;
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.downstream.onSubscribe((Disposable)this);
    }
}
