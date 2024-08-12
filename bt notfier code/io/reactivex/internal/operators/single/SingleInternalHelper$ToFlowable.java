/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.SingleSource
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.operators.single.SingleToFlowable
 *  org.reactivestreams.Publisher
 */
package io.reactivex.internal.operators.single;

import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.single.SingleToFlowable;
import org.reactivestreams.Publisher;

static final class SingleInternalHelper.ToFlowable
extends Enum<SingleInternalHelper.ToFlowable>
implements Function<SingleSource, Publisher> {
    private static final SingleInternalHelper.ToFlowable[] $VALUES;
    public static final /* enum */ SingleInternalHelper.ToFlowable INSTANCE;

    static {
        SingleInternalHelper.ToFlowable toFlowable;
        INSTANCE = toFlowable = new SingleInternalHelper.ToFlowable();
        $VALUES = new SingleInternalHelper.ToFlowable[]{toFlowable};
    }

    public static SingleInternalHelper.ToFlowable valueOf(String string) {
        return Enum.valueOf(SingleInternalHelper.ToFlowable.class, string);
    }

    public static SingleInternalHelper.ToFlowable[] values() {
        return (SingleInternalHelper.ToFlowable[])$VALUES.clone();
    }

    public Publisher apply(SingleSource singleSource) {
        return new SingleToFlowable(singleSource);
    }
}
