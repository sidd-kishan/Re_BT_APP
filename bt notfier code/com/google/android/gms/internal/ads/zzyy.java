/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 *  com.google.android.gms.internal.ads.zzyx
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;
import com.google.android.gms.internal.ads.zzyx;

public final class zzyy
extends zzgga<zzyy, zzyx>
implements zzghj {
    private static final zzyy zzl;
    private int zzb;
    private long zze = -1L;
    private long zzf = -1L;
    private long zzg = -1L;
    private long zzh = -1L;
    private long zzi = -1L;
    private long zzj = -1L;
    private long zzk = -1L;

    static {
        zzyy zzyy2;
        zzl = zzyy2 = new zzyy();
        zzgga.zzay(zzyy.class, (zzgga)zzyy2);
    }

    private zzyy() {
    }

    public static zzyx zza() {
        return (zzyx)zzl.zzas();
    }

    static /* synthetic */ zzyy zzc() {
        return zzl;
    }

    static /* synthetic */ void zzd(zzyy zzyy2, long l) {
        zzyy2.zzb |= 4;
        zzyy2.zzg = l;
    }

    static /* synthetic */ void zze(zzyy zzyy2, long l) {
        zzyy2.zzb |= 8;
        zzyy2.zzh = l;
    }

    static /* synthetic */ void zzf(zzyy zzyy2, long l) {
        zzyy2.zzb |= 0x10;
        zzyy2.zzi = l;
    }

    static /* synthetic */ void zzg(zzyy zzyy2, long l) {
        zzyy2.zzb |= 0x20;
        zzyy2.zzj = l;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n == 2) return zzyy.zzaz((zzghi)zzl, (String)"\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001\u1002\u0000\u0002\u1002\u0001\u0003\u1002\u0002\u0004\u1002\u0003\u0005\u1002\u0004\u0006\u1002\u0005\u0007\u1002\u0006", (Object[])new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        if (n == 3) return new zzyy();
        if (n == 4) return new zzyx(null);
        if (n == 5) return zzl;
        return null;
    }
}
