/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.ads.internal.util;

public final class zzch {
    private static zzch zzb;
    String zza;

    private zzch() {
    }

    public static zzch zza() {
        if (zzb != null) return zzb;
        zzb = new zzch();
        return zzb;
    }
}
