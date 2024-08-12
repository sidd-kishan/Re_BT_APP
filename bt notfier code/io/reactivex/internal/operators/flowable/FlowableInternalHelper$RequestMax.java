/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.Consumer
 *  org.reactivestreams.Subscription
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.functions.Consumer;
import org.reactivestreams.Subscription;

public static final class FlowableInternalHelper.RequestMax
extends Enum<FlowableInternalHelper.RequestMax>
implements Consumer<Subscription> {
    private static final FlowableInternalHelper.RequestMax[] $VALUES;
    public static final /* enum */ FlowableInternalHelper.RequestMax INSTANCE;

    static {
        FlowableInternalHelper.RequestMax requestMax;
        INSTANCE = requestMax = new FlowableInternalHelper.RequestMax();
        $VALUES = new FlowableInternalHelper.RequestMax[]{requestMax};
    }

    public static FlowableInternalHelper.RequestMax valueOf(String string) {
        return Enum.valueOf(FlowableInternalHelper.RequestMax.class, string);
    }

    public static FlowableInternalHelper.RequestMax[] values() {
        return (FlowableInternalHelper.RequestMax[])$VALUES.clone();
    }

    public void accept(Subscription subscription) throws Exception {
        subscription.request(Long.MAX_VALUE);
    }
}
