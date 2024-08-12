/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

public final class zzfgk
extends Enum<zzfgk> {
    public static final /* enum */ zzfgk zza;
    public static final /* enum */ zzfgk zzb;
    public static final /* enum */ zzfgk zzc;
    private static final zzfgk[] zze;
    private final String zzd;

    static {
        zzfgk zzfgk2;
        zza = new zzfgk("native");
        zzb = new zzfgk("javascript");
        zzc = zzfgk2 = new zzfgk("none");
        zze = new zzfgk[]{zza, zzb, zzfgk2};
    }

    private zzfgk(String string2) {
        this.zzd = string2;
    }

    public static zzfgk[] values() {
        return (zzfgk[])zze.clone();
    }

    public final String toString() {
        return this.zzd;
    }
}
