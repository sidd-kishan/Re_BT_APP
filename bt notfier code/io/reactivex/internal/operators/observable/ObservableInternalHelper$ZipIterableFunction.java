/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 *  io.reactivex.ObservableSource
 *  io.reactivex.functions.Function
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.List;

static final class ObservableInternalHelper.ZipIterableFunction<T, R>
implements Function<List<ObservableSource<? extends T>>, ObservableSource<? extends R>> {
    private final Function<? super Object[], ? extends R> zipper;

    ObservableInternalHelper.ZipIterableFunction(Function<? super Object[], ? extends R> function) {
        this.zipper = function;
    }

    public ObservableSource<? extends R> apply(List<ObservableSource<? extends T>> list) {
        return Observable.zipIterable(list, this.zipper, (boolean)false, (int)Observable.bufferSize());
    }
}
