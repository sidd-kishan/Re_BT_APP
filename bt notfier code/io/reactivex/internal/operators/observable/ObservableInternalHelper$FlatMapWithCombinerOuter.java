/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.ObservableSource
 *  io.reactivex.functions.BiFunction
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.observable.ObservableInternalHelper$FlatMapWithCombinerInner
 *  io.reactivex.internal.operators.observable.ObservableMap
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.observable.ObservableInternalHelper;
import io.reactivex.internal.operators.observable.ObservableMap;

static final class ObservableInternalHelper.FlatMapWithCombinerOuter<T, R, U>
implements Function<T, ObservableSource<R>> {
    private final BiFunction<? super T, ? super U, ? extends R> combiner;
    private final Function<? super T, ? extends ObservableSource<? extends U>> mapper;

    ObservableInternalHelper.FlatMapWithCombinerOuter(BiFunction<? super T, ? super U, ? extends R> biFunction, Function<? super T, ? extends ObservableSource<? extends U>> function) {
        this.combiner = biFunction;
        this.mapper = function;
    }

    public ObservableSource<R> apply(T t) throws Exception {
        return new ObservableMap((ObservableSource)ObjectHelper.requireNonNull((Object)this.mapper.apply(t), (String)"The mapper returned a null ObservableSource"), (Function)new ObservableInternalHelper.FlatMapWithCombinerInner(this.combiner, t));
    }
}
