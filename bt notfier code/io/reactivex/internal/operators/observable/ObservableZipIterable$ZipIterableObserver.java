/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.BiFunction
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;

static final class ObservableZipIterable.ZipIterableObserver<T, U, V>
implements Observer<T>,
Disposable {
    boolean done;
    final Observer<? super V> downstream;
    final Iterator<U> iterator;
    Disposable upstream;
    final BiFunction<? super T, ? super U, ? extends V> zipper;

    ObservableZipIterable.ZipIterableObserver(Observer<? super V> observer, Iterator<U> iterator, BiFunction<? super T, ? super U, ? extends V> biFunction) {
        this.downstream = observer;
        this.iterator = iterator;
        this.zipper = biFunction;
    }

    public void dispose() {
        this.upstream.dispose();
    }

    void error(Throwable throwable) {
        this.done = true;
        this.upstream.dispose();
        this.downstream.onError(throwable);
    }

    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        if (this.done) {
            RxJavaPlugins.onError((Throwable)throwable);
            return;
        }
        this.done = true;
        this.downstream.onError(throwable);
    }

    public void onNext(T object) {
        Object object2;
        if (this.done) {
            return;
        }
        try {
            object2 = ObjectHelper.requireNonNull(this.iterator.next(), (String)"The iterator returned a null value");
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            this.error(throwable);
            return;
        }
        try {
            object = ObjectHelper.requireNonNull((Object)this.zipper.apply(object, object2), (String)"The zipper function returned a null value");
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            this.error(throwable);
            return;
        }
        this.downstream.onNext(object);
        try {
            boolean bl = this.iterator.hasNext();
            if (bl) return;
            this.done = true;
        }
        catch (Throwable throwable) {
            Exceptions.throwIfFatal((Throwable)throwable);
            this.error(throwable);
            return;
        }
        this.upstream.dispose();
        this.downstream.onComplete();
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.downstream.onSubscribe((Disposable)this);
    }
}
