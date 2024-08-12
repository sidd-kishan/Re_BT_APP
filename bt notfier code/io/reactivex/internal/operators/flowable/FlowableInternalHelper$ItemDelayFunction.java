/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.functions.Functions
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.flowable.FlowableTakePublisher
 *  org.reactivestreams.Publisher
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.functions.Function;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.flowable.FlowableTakePublisher;
import org.reactivestreams.Publisher;

static final class FlowableInternalHelper.ItemDelayFunction<T, U>
implements Function<T, Publisher<T>> {
    final Function<? super T, ? extends Publisher<U>> itemDelay;

    FlowableInternalHelper.ItemDelayFunction(Function<? super T, ? extends Publisher<U>> function) {
        this.itemDelay = function;
    }

    public Publisher<T> apply(T t) throws Exception {
        return new FlowableTakePublisher((Publisher)ObjectHelper.requireNonNull((Object)this.itemDelay.apply(t), (String)"The itemDelay returned a null Publisher"), 1L).map(Functions.justFunction(t)).defaultIfEmpty(t);
    }
}
