/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

public final class zzbzl
extends Enum<zzbzl> {
    public static final /* enum */ zzbzl zza;
    public static final /* enum */ zzbzl zzb;
    public static final /* enum */ zzbzl zzc;
    private static final zzbzl[] zze;
    private final String zzd;

    static {
        zzbzl zzbzl2;
        zza = new zzbzl("htmlDisplay");
        zzb = new zzbzl("nativeDisplay");
        zzc = zzbzl2 = new zzbzl("video");
        zze = new zzbzl[]{zza, zzb, zzbzl2};
    }

    private zzbzl(String string2) {
        this.zzd = string2;
    }

    public static zzbzl[] values() {
        return (zzbzl[])zze.clone();
    }

    public final String toString() {
        return this.zzd;
    }
}
