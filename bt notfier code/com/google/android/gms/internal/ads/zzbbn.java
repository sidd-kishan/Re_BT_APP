/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbbi
 *  com.google.android.gms.internal.ads.zzbbj
 *  com.google.android.gms.internal.ads.zzgeg
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzggj
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbbi;
import com.google.android.gms.internal.ads.zzbbj;
import com.google.android.gms.internal.ads.zzgeg;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzggj;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzbbn
extends zzgga<zzbbn, zzbbj>
implements zzghj {
    private static final zzbbn zzl;
    private int zzb;
    private zzggj<zzbbi> zze = zzbbn.zzaE();
    private int zzf;
    private int zzg;
    private long zzh;
    private String zzi = "";
    private String zzj = "";
    private long zzk;

    static {
        zzbbn zzbbn2;
        zzl = zzbbn2 = new zzbbn();
        zzgga.zzay(zzbbn.class, (zzgga)zzbbn2);
    }

    private zzbbn() {
    }

    public static zzbbj zza() {
        return (zzbbj)zzl.zzas();
    }

    static /* synthetic */ zzbbn zzc() {
        return zzl;
    }

    static /* synthetic */ void zzd(zzbbn zzbbn2, Iterable iterable) {
        zzggj<zzbbi> zzggj2 = zzbbn2.zze;
        if (!zzggj2.zza()) {
            zzbbn2.zze = zzgga.zzaF(zzggj2);
        }
        zzgeg.zzar((Iterable)iterable, zzbbn2.zze);
    }

    static /* synthetic */ void zze(zzbbn zzbbn2, int n) {
        zzbbn2.zzb |= 1;
        zzbbn2.zzf = n;
    }

    static /* synthetic */ void zzf(zzbbn zzbbn2, int n) {
        zzbbn2.zzb |= 2;
        zzbbn2.zzg = n;
    }

    static /* synthetic */ void zzg(zzbbn zzbbn2, long l) {
        zzbbn2.zzb |= 4;
        zzbbn2.zzh = l;
    }

    static /* synthetic */ void zzh(zzbbn zzbbn2, String string) {
        string.getClass();
        zzbbn2.zzb |= 8;
        zzbbn2.zzi = string;
    }

    static /* synthetic */ void zzi(zzbbn zzbbn2, String string) {
        string.getClass();
        zzbbn2.zzb |= 0x10;
        zzbbn2.zzj = string;
    }

    static /* synthetic */ void zzj(zzbbn zzbbn2, long l) {
        zzbbn2.zzb |= 0x20;
        zzbbn2.zzk = l;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n == 2) return zzbbn.zzaz((zzghi)zzl, (String)"\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0001\u0000\u0001\u001b\u0002\u1004\u0000\u0003\u1004\u0001\u0004\u1002\u0002\u0005\u1008\u0003\u0006\u1008\u0004\u0007\u1002\u0005", (Object[])new Object[]{"zzb", "zze", zzbbi.class, "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        if (n == 3) return new zzbbn();
        if (n == 4) return new zzbbj(null);
        if (n == 5) return zzl;
        return null;
    }
}
