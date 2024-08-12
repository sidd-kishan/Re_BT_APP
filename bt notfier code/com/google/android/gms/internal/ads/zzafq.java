/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 */
package com.google.android.gms.internal.ads;

import android.os.Build;
import java.util.HashSet;

public final class zzafq {
    @Deprecated
    public static final String zza;
    private static final HashSet<String> zzb;
    private static final String zzc;

    static {
        String string = Build.VERSION.RELEASE;
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(string).length() + 57);
        stringBuilder.append("ExoPlayerLib/2.15.0 (Linux; Android ");
        stringBuilder.append(string);
        stringBuilder.append(") ExoPlayerLib/2.15.0");
        zza = stringBuilder.toString();
        zzb = new HashSet();
        zzc = "goog.exo.core";
    }

    public static String zza() {
        synchronized (zzafq.class) {
            String string = zzc;
            return string;
        }
    }
}
