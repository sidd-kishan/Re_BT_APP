/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 */
package com.google.android.gms.internal.common;

import android.os.Build;

public final class zzi {
    private static volatile boolean zza = zzi.zza() ^ true;

    public static boolean zza() {
        if (Build.VERSION.SDK_INT < 24) return false;
        return true;
    }
}
