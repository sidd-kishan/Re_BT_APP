/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 *  io.reactivex.SingleSource
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.operators.single.SingleToObservable
 */
package io.reactivex.internal.operators.single;

import io.reactivex.Observable;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.single.SingleToObservable;

static final class SingleInternalHelper.ToObservable
extends Enum<SingleInternalHelper.ToObservable>
implements Function<SingleSource, Observable> {
    private static final SingleInternalHelper.ToObservable[] $VALUES;
    public static final /* enum */ SingleInternalHelper.ToObservable INSTANCE;

    static {
        SingleInternalHelper.ToObservable toObservable;
        INSTANCE = toObservable = new SingleInternalHelper.ToObservable();
        $VALUES = new SingleInternalHelper.ToObservable[]{toObservable};
    }

    public static SingleInternalHelper.ToObservable valueOf(String string) {
        return Enum.valueOf(SingleInternalHelper.ToObservable.class, string);
    }

    public static SingleInternalHelper.ToObservable[] values() {
        return (SingleInternalHelper.ToObservable[])$VALUES.clone();
    }

    public Observable apply(SingleSource singleSource) {
        return new SingleToObservable(singleSource);
    }
}
