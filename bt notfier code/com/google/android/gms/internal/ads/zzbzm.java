/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

public final class zzbzm
extends Enum<zzbzm> {
    public static final /* enum */ zzbzm zza;
    public static final /* enum */ zzbzm zzb;
    public static final /* enum */ zzbzm zzc;
    public static final /* enum */ zzbzm zzd;
    private static final zzbzm[] zzf;
    private final String zze;

    static {
        zzbzm zzbzm2;
        zza = new zzbzm("beginToRender");
        zzb = new zzbzm("definedByJavascript");
        zzc = new zzbzm("onePixel");
        zzd = zzbzm2 = new zzbzm("unspecified");
        zzf = new zzbzm[]{zza, zzb, zzc, zzbzm2};
    }

    private zzbzm(String string2) {
        this.zze = string2;
    }

    public static zzbzm[] values() {
        return (zzbzm[])zzf.clone();
    }

    public final String toString() {
        return this.zze;
    }
}
