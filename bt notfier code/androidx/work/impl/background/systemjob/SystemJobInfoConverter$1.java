/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.NetworkType
 */
package androidx.work.impl.background.systemjob;

import androidx.work.NetworkType;

static class SystemJobInfoConverter.1 {
    static final int[] $SwitchMap$androidx$work$NetworkType;

    /*
     * Enabled force condition propagation
     */
    static {
        int[] nArray = new int[NetworkType.values().length];
        $SwitchMap$androidx$work$NetworkType = nArray;
        try {
            nArray[NetworkType.NOT_REQUIRED.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            SystemJobInfoConverter.1.$SwitchMap$androidx$work$NetworkType[NetworkType.CONNECTED.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            SystemJobInfoConverter.1.$SwitchMap$androidx$work$NetworkType[NetworkType.UNMETERED.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            SystemJobInfoConverter.1.$SwitchMap$androidx$work$NetworkType[NetworkType.NOT_ROAMING.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            SystemJobInfoConverter.1.$SwitchMap$androidx$work$NetworkType[NetworkType.METERED.ordinal()] = 5;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}
