/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.Function
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.functions.Function;

static final class ObservableInternalHelper.MapToInt
extends Enum<ObservableInternalHelper.MapToInt>
implements Function<Object, Object> {
    private static final ObservableInternalHelper.MapToInt[] $VALUES;
    public static final /* enum */ ObservableInternalHelper.MapToInt INSTANCE;

    static {
        ObservableInternalHelper.MapToInt mapToInt;
        INSTANCE = mapToInt = new ObservableInternalHelper.MapToInt();
        $VALUES = new ObservableInternalHelper.MapToInt[]{mapToInt};
    }

    public static ObservableInternalHelper.MapToInt valueOf(String string) {
        return Enum.valueOf(ObservableInternalHelper.MapToInt.class, string);
    }

    public static ObservableInternalHelper.MapToInt[] values() {
        return (ObservableInternalHelper.MapToInt[])$VALUES.clone();
    }

    public Object apply(Object object) throws Exception {
        return 0;
    }
}
