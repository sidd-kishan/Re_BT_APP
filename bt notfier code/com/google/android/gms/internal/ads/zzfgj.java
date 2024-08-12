/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

public final class zzfgj
extends Enum<zzfgj> {
    public static final /* enum */ zzfgj zza;
    public static final /* enum */ zzfgj zzb;
    public static final /* enum */ zzfgj zzc;
    public static final /* enum */ zzfgj zzd;
    public static final /* enum */ zzfgj zze;
    public static final /* enum */ zzfgj zzf;
    public static final /* enum */ zzfgj zzg;
    public static final /* enum */ zzfgj zzh;
    private static final zzfgj[] zzj;
    private final String zzi;

    static {
        zzfgj zzfgj2;
        zza = new zzfgj("definedByJavaScript");
        zzb = new zzfgj("unspecified");
        zzc = new zzfgj("loaded");
        zzd = new zzfgj("beginToRender");
        zze = new zzfgj("onePixel");
        zzf = new zzfgj("viewable");
        zzg = new zzfgj("audible");
        zzh = zzfgj2 = new zzfgj("other");
        zzj = new zzfgj[]{zza, zzb, zzc, zzd, zze, zzf, zzg, zzfgj2};
    }

    private zzfgj(String string2) {
        this.zzi = string2;
    }

    public static zzfgj[] values() {
        return (zzfgj[])zzj.clone();
    }

    public final String toString() {
        return this.zzi;
    }
}
