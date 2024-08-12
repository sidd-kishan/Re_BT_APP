/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

public final class zzfgh
extends Enum<zzfgh> {
    public static final /* enum */ zzfgh zza;
    public static final /* enum */ zzfgh zzb;
    public static final /* enum */ zzfgh zzc;
    public static final /* enum */ zzfgh zzd;
    public static final /* enum */ zzfgh zze;
    private static final zzfgh[] zzg;
    private final String zzf;

    static {
        zzfgh zzfgh2;
        zza = new zzfgh("definedByJavaScript");
        zzb = new zzfgh("htmlDisplay");
        zzc = new zzfgh("nativeDisplay");
        zzd = new zzfgh("video");
        zze = zzfgh2 = new zzfgh("audio");
        zzg = new zzfgh[]{zza, zzb, zzc, zzd, zzfgh2};
    }

    private zzfgh(String string2) {
        this.zzf = string2;
    }

    public static zzfgh[] values() {
        return (zzfgh[])zzg.clone();
    }

    public final String toString() {
        return this.zzf;
    }
}
