/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

public final class zzfgf
extends Enum<zzfgf> {
    public static final /* enum */ zzfgf zza;
    public static final /* enum */ zzfgf zzb;
    public static final /* enum */ zzfgf zzc;
    private static final zzfgf[] zze;
    private final String zzd;

    static {
        zzfgf zzfgf2;
        zza = new zzfgf("html");
        zzb = new zzfgf("native");
        zzc = zzfgf2 = new zzfgf("javascript");
        zze = new zzfgf[]{zza, zzb, zzfgf2};
    }

    private zzfgf(String string2) {
        this.zzd = string2;
    }

    public static zzfgf[] values() {
        return (zzfgf[])zze.clone();
    }

    public final String toString() {
        return this.zzd;
    }
}
