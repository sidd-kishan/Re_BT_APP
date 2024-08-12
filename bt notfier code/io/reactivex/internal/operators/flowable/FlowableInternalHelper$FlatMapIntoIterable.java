/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.flowable.FlowableFromIterable
 *  org.reactivestreams.Publisher
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.flowable.FlowableFromIterable;
import org.reactivestreams.Publisher;

static final class FlowableInternalHelper.FlatMapIntoIterable<T, U>
implements Function<T, Publisher<U>> {
    private final Function<? super T, ? extends Iterable<? extends U>> mapper;

    FlowableInternalHelper.FlatMapIntoIterable(Function<? super T, ? extends Iterable<? extends U>> function) {
        this.mapper = function;
    }

    public Publisher<U> apply(T t) throws Exception {
        return new FlowableFromIterable((Iterable)ObjectHelper.requireNonNull((Object)this.mapper.apply(t), (String)"The mapper returned a null Iterable"));
    }
}
