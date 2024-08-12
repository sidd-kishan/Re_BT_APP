/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.operators.flowable.FlowableCombineLatest
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.functions.Function;
import io.reactivex.internal.operators.flowable.FlowableCombineLatest;

final class FlowableCombineLatest.SingletonArrayFunc
implements Function<T, R> {
    final FlowableCombineLatest this$0;

    FlowableCombineLatest.SingletonArrayFunc(FlowableCombineLatest flowableCombineLatest) {
        this.this$0 = flowableCombineLatest;
    }

    public R apply(T t) throws Exception {
        return this.this$0.combiner.apply((Object)new Object[]{t});
    }
}
