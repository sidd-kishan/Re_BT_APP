/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.webkit.ConsoleMessage$MessageLevel
 */
package com.google.android.gms.internal.ads;

import android.webkit.ConsoleMessage;

final class zzcmj {
    static final int[] zza;

    /*
     * Enabled force condition propagation
     */
    static {
        int[] nArray = new int[ConsoleMessage.MessageLevel.values().length];
        zza = nArray;
        try {
            nArray[ConsoleMessage.MessageLevel.ERROR.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            zzcmj.zza[ConsoleMessage.MessageLevel.WARNING.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            zzcmj.zza[ConsoleMessage.MessageLevel.LOG.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            zzcmj.zza[ConsoleMessage.MessageLevel.TIP.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            zzcmj.zza[ConsoleMessage.MessageLevel.DEBUG.ordinal()] = 5;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}
