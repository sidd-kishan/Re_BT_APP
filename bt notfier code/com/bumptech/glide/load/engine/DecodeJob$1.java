/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.EncodeStrategy
 *  com.bumptech.glide.load.engine.DecodeJob$RunReason
 *  com.bumptech.glide.load.engine.DecodeJob$Stage
 */
package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.engine.DecodeJob;

/*
 * Exception performing whole class analysis ignored.
 */
static class DecodeJob.1 {
    static final int[] $SwitchMap$com$bumptech$glide$load$EncodeStrategy;
    static final int[] $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$RunReason;
    static final int[] $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage;

    /*
     * Enabled force condition propagation
     */
    static {
        int[] nArray = new int[EncodeStrategy.values().length];
        $SwitchMap$com$bumptech$glide$load$EncodeStrategy = nArray;
        try {
            nArray[EncodeStrategy.SOURCE.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            DecodeJob.1.$SwitchMap$com$bumptech$glide$load$EncodeStrategy[EncodeStrategy.TRANSFORMED.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        nArray = new int[DecodeJob.Stage.values().length];
        $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage = nArray;
        try {
            nArray[DecodeJob.Stage.RESOURCE_CACHE.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            DecodeJob.1.$SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage[DecodeJob.Stage.DATA_CACHE.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            DecodeJob.1.$SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage[DecodeJob.Stage.SOURCE.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            DecodeJob.1.$SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage[DecodeJob.Stage.FINISHED.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            DecodeJob.1.$SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage[DecodeJob.Stage.INITIALIZE.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        nArray = new int[DecodeJob.RunReason.values().length];
        $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$RunReason = nArray;
        try {
            nArray[DecodeJob.RunReason.INITIALIZE.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            DecodeJob.1.$SwitchMap$com$bumptech$glide$load$engine$DecodeJob$RunReason[DecodeJob.RunReason.SWITCH_TO_SOURCE_SERVICE.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            DecodeJob.1.$SwitchMap$com$bumptech$glide$load$engine$DecodeJob$RunReason[DecodeJob.RunReason.DECODE_DATA.ordinal()] = 3;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}
