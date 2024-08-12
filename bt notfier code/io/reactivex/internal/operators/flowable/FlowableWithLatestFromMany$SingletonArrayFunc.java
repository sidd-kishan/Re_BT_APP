/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.functions.ObjectHelper
 *  io.reactivex.internal.operators.flowable.FlowableWithLatestFromMany
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.flowable.FlowableWithLatestFromMany;

final class FlowableWithLatestFromMany.SingletonArrayFunc
implements Function<T, R> {
    final FlowableWithLatestFromMany this$0;

    FlowableWithLatestFromMany.SingletonArrayFunc(FlowableWithLatestFromMany flowableWithLatestFromMany) {
        this.this$0 = flowableWithLatestFromMany;
    }

    public R apply(T t) throws Exception {
        return ObjectHelper.requireNonNull((Object)this.this$0.combiner.apply((Object)new Object[]{t}), (String)"The combiner returned a null value");
    }
}
