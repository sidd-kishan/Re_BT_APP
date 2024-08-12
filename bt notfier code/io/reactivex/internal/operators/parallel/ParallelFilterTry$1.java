/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.parallel.ParallelFailureHandling
 */
package io.reactivex.internal.operators.parallel;

import io.reactivex.parallel.ParallelFailureHandling;

static class ParallelFilterTry.1 {
    static final int[] $SwitchMap$io$reactivex$parallel$ParallelFailureHandling;

    /*
     * Enabled force condition propagation
     */
    static {
        int[] nArray = new int[ParallelFailureHandling.values().length];
        $SwitchMap$io$reactivex$parallel$ParallelFailureHandling = nArray;
        try {
            nArray[ParallelFailureHandling.RETRY.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            ParallelFilterTry.1.$SwitchMap$io$reactivex$parallel$ParallelFailureHandling[ParallelFailureHandling.SKIP.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            ParallelFilterTry.1.$SwitchMap$io$reactivex$parallel$ParallelFailureHandling[ParallelFailureHandling.STOP.ordinal()] = 3;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}
