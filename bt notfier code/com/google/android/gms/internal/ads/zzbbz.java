/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbby
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbby;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzbbz
extends zzgga<zzbbz, zzbby>
implements zzghj {
    private static final zzbbz zzh;
    private int zzb;
    private int zze;
    private int zzf;
    private int zzg;

    static {
        zzbbz zzbbz2;
        zzh = zzbbz2 = new zzbbz();
        zzgga.zzay(zzbbz.class, (zzgga)zzbbz2);
    }

    private zzbbz() {
    }

    public static zzbby zza() {
        return (zzbby)zzh.zzas();
    }

    static /* synthetic */ zzbbz zzc() {
        return zzh;
    }

    static /* synthetic */ void zzd(zzbbz zzbbz2, int n) {
        zzbbz2.zzb |= 1;
        zzbbz2.zze = n;
    }

    static /* synthetic */ void zze(zzbbz zzbbz2, int n) {
        zzbbz2.zzb |= 2;
        zzbbz2.zzf = n;
    }

    static /* synthetic */ void zzf(zzbbz zzbbz2, int n) {
        zzbbz2.zzb |= 4;
        zzbbz2.zzg = n;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n == 2) return zzbbz.zzaz((zzghi)zzh, (String)"\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u1004\u0000\u0002\u1004\u0001\u0003\u1004\u0002", (Object[])new Object[]{"zzb", "zze", "zzf", "zzg"});
        if (n == 3) return new zzbbz();
        if (n == 4) return new zzbby(null);
        if (n == 5) return zzh;
        return null;
    }
}
