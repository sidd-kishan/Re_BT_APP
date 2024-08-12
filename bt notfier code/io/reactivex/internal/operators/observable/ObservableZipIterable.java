/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 *  io.reactivex.Observer
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.BiFunction
 *  io.reactivex.internal.disposables.EmptyDisposable
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.observable.ObservableZipIterable$ZipIterableObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.observable.ObservableZipIterable;
import java.util.Iterator;

public final class ObservableZipIterable<T, U, V>
extends Observable<V> {
    final Iterable<U> other;
    final Observable<? extends T> source;
    final BiFunction<? super T, ? super U, ? extends V> zipper;

    public ObservableZipIterable(Observable<? extends T> observable, Iterable<U> iterable, BiFunction<? super T, ? super U, ? extends V> biFunction) {
        this.source = observable;
        this.other = iterable;
        this.zipper = biFunction;
    }

    public void subscribeActual(Observer<? super V> observer) {
        Iterator iterator;
        block4: {
            try {
                iterator = (Iterator)ObjectHelper.requireNonNull(this.other.iterator(), (String)"The iterator returned by other is null");
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                EmptyDisposable.error((Throwable)throwable, observer);
                return;
            }
            try {
                boolean bl = iterator.hasNext();
                if (bl) break block4;
            }
            catch (Throwable throwable) {
                Exceptions.throwIfFatal((Throwable)throwable);
                EmptyDisposable.error((Throwable)throwable, observer);
                return;
            }
            EmptyDisposable.complete(observer);
            return;
        }
        this.source.subscribe((Observer)new ZipIterableObserver(observer, iterator, this.zipper));
    }
}
