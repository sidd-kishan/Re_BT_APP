/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.ObservableSource
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.observable.ObservableFromIterable
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.observable.ObservableFromIterable;

static final class ObservableInternalHelper.FlatMapIntoIterable<T, U>
implements Function<T, ObservableSource<U>> {
    private final Function<? super T, ? extends Iterable<? extends U>> mapper;

    ObservableInternalHelper.FlatMapIntoIterable(Function<? super T, ? extends Iterable<? extends U>> function) {
        this.mapper = function;
    }

    public ObservableSource<U> apply(T t) throws Exception {
        return new ObservableFromIterable((Iterable)ObjectHelper.requireNonNull((Object)this.mapper.apply(t), (String)"The mapper returned a null Iterable"));
    }
}
