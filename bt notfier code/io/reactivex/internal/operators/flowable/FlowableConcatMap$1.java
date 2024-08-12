/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.util.ErrorMode
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.util.ErrorMode;

static class FlowableConcatMap.1 {
    static final int[] $SwitchMap$io$reactivex$internal$util$ErrorMode;

    /*
     * Enabled force condition propagation
     */
    static {
        int[] nArray = new int[ErrorMode.values().length];
        $SwitchMap$io$reactivex$internal$util$ErrorMode = nArray;
        try {
            nArray[ErrorMode.BOUNDARY.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            FlowableConcatMap.1.$SwitchMap$io$reactivex$internal$util$ErrorMode[ErrorMode.END.ordinal()] = 2;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}
