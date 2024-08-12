/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzgfm
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzggm
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 *  com.google.android.gms.internal.ads.zzzc
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzgfm;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzggm;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;
import com.google.android.gms.internal.ads.zzzc;

public final class zzzd
extends zzgga<zzzd, zzzc>
implements zzghj {
    private static final zzzd zzi;
    private int zzb;
    private zzgex zze = zzgex.zzb;
    private zzgex zzf = zzgex.zzb;
    private zzgex zzg = zzgex.zzb;
    private zzgex zzh = zzgex.zzb;

    static {
        zzzd zzzd2;
        zzi = zzzd2 = new zzzd();
        zzgga.zzay(zzzd.class, (zzgga)zzzd2);
    }

    private zzzd() {
    }

    public static zzzd zzf(byte[] byArray, zzgfm zzgfm2) throws zzggm {
        return (zzzd)zzgga.zzaK((zzgga)zzi, (byte[])byArray, (zzgfm)zzgfm2);
    }

    public static zzzc zzg() {
        return (zzzc)zzi.zzas();
    }

    static /* synthetic */ zzzd zzh() {
        return zzi;
    }

    static /* synthetic */ void zzi(zzzd zzzd2, zzgex zzgex2) {
        zzzd2.zzb |= 1;
        zzzd2.zze = zzgex2;
    }

    static /* synthetic */ void zzj(zzzd zzzd2, zzgex zzgex2) {
        zzzd2.zzb |= 2;
        zzzd2.zzf = zzgex2;
    }

    static /* synthetic */ void zzk(zzzd zzzd2, zzgex zzgex2) {
        zzzd2.zzb |= 4;
        zzzd2.zzg = zzgex2;
    }

    static /* synthetic */ void zzl(zzzd zzzd2, zzgex zzgex2) {
        zzzd2.zzb |= 8;
        zzzd2.zzh = zzgex2;
    }

    public final zzgex zza() {
        return this.zze;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n == 2) return zzzd.zzaz((zzghi)zzi, (String)"\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u100a\u0000\u0002\u100a\u0001\u0003\u100a\u0002\u0004\u100a\u0003", (Object[])new Object[]{"zzb", "zze", "zzf", "zzg", "zzh"});
        if (n == 3) return new zzzd();
        if (n == 4) return new zzzc(null);
        if (n == 5) return zzi;
        return null;
    }

    public final zzgex zzc() {
        return this.zzf;
    }

    public final zzgex zzd() {
        return this.zzg;
    }

    public final zzgex zze() {
        return this.zzh;
    }
}
