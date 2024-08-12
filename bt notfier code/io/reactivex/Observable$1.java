/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.BackpressureStrategy
 */
package io.reactivex;

import io.reactivex.BackpressureStrategy;

static class Observable.1 {
    static final int[] $SwitchMap$io$reactivex$BackpressureStrategy;

    /*
     * Enabled force condition propagation
     */
    static {
        int[] nArray = new int[BackpressureStrategy.values().length];
        $SwitchMap$io$reactivex$BackpressureStrategy = nArray;
        try {
            nArray[BackpressureStrategy.DROP.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            Observable.1.$SwitchMap$io$reactivex$BackpressureStrategy[BackpressureStrategy.LATEST.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            Observable.1.$SwitchMap$io$reactivex$BackpressureStrategy[BackpressureStrategy.MISSING.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            Observable.1.$SwitchMap$io$reactivex$BackpressureStrategy[BackpressureStrategy.ERROR.ordinal()] = 4;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}
