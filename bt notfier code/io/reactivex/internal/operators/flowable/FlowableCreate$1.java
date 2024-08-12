/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.BackpressureStrategy
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.BackpressureStrategy;

static class FlowableCreate.1 {
    static final int[] $SwitchMap$io$reactivex$BackpressureStrategy;

    /*
     * Enabled force condition propagation
     */
    static {
        int[] nArray = new int[BackpressureStrategy.values().length];
        $SwitchMap$io$reactivex$BackpressureStrategy = nArray;
        try {
            nArray[BackpressureStrategy.MISSING.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            FlowableCreate.1.$SwitchMap$io$reactivex$BackpressureStrategy[BackpressureStrategy.ERROR.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            FlowableCreate.1.$SwitchMap$io$reactivex$BackpressureStrategy[BackpressureStrategy.DROP.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            FlowableCreate.1.$SwitchMap$io$reactivex$BackpressureStrategy[BackpressureStrategy.LATEST.ordinal()] = 4;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}
