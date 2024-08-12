/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.BiFunction
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.flowable.FlowableInternalHelper$FlatMapWithCombinerInner
 *  io.reactivex.internal.operators.flowable.FlowableMapPublisher
 *  org.reactivestreams.Publisher
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.flowable.FlowableInternalHelper;
import io.reactivex.internal.operators.flowable.FlowableMapPublisher;
import org.reactivestreams.Publisher;

static final class FlowableInternalHelper.FlatMapWithCombinerOuter<T, R, U>
implements Function<T, Publisher<R>> {
    private final BiFunction<? super T, ? super U, ? extends R> combiner;
    private final Function<? super T, ? extends Publisher<? extends U>> mapper;

    FlowableInternalHelper.FlatMapWithCombinerOuter(BiFunction<? super T, ? super U, ? extends R> biFunction, Function<? super T, ? extends Publisher<? extends U>> function) {
        this.combiner = biFunction;
        this.mapper = function;
    }

    public Publisher<R> apply(T t) throws Exception {
        return new FlowableMapPublisher((Publisher)ObjectHelper.requireNonNull((Object)this.mapper.apply(t), (String)"The mapper returned a null Publisher"), (Function)new FlowableInternalHelper.FlatMapWithCombinerInner(this.combiner, t));
    }
}
