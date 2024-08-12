/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.BackpressureOverflowStrategy
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.BackpressureOverflowStrategy;

static class FlowableOnBackpressureBufferStrategy.1 {
    static final int[] $SwitchMap$io$reactivex$BackpressureOverflowStrategy;

    /*
     * Enabled force condition propagation
     */
    static {
        int[] nArray = new int[BackpressureOverflowStrategy.values().length];
        $SwitchMap$io$reactivex$BackpressureOverflowStrategy = nArray;
        try {
            nArray[BackpressureOverflowStrategy.DROP_LATEST.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            FlowableOnBackpressureBufferStrategy.1.$SwitchMap$io$reactivex$BackpressureOverflowStrategy[BackpressureOverflowStrategy.DROP_OLDEST.ordinal()] = 2;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}
