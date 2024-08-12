/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.ObservableSource
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.functions.Functions
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.observable.ObservableTake
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.observable.ObservableTake;

static final class ObservableInternalHelper.ItemDelayFunction<T, U>
implements Function<T, ObservableSource<T>> {
    final Function<? super T, ? extends ObservableSource<U>> itemDelay;

    ObservableInternalHelper.ItemDelayFunction(Function<? super T, ? extends ObservableSource<U>> function) {
        this.itemDelay = function;
    }

    public ObservableSource<T> apply(T t) throws Exception {
        return new ObservableTake((ObservableSource)ObjectHelper.requireNonNull((Object)this.itemDelay.apply(t), (String)"The itemDelay returned a null ObservableSource"), 1L).map(Functions.justFunction(t)).defaultIfEmpty(t);
    }
}
