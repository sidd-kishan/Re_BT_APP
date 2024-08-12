/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.BiFunction
 *  io.reactivex.functions.Function
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;

static final class FlowableInternalHelper.FlatMapWithCombinerInner<U, R, T>
implements Function<U, R> {
    private final BiFunction<? super T, ? super U, ? extends R> combiner;
    private final T t;

    FlowableInternalHelper.FlatMapWithCombinerInner(BiFunction<? super T, ? super U, ? extends R> biFunction, T t) {
        this.combiner = biFunction;
        this.t = t;
    }

    public R apply(U u) throws Exception {
        return (R)this.combiner.apply(this.t, u);
    }
}
