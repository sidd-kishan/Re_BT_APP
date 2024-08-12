/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzggj
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 *  com.google.android.gms.internal.ads.zzze
 *  com.google.android.gms.internal.ads.zzzg
 *  com.google.android.gms.internal.ads.zzzl
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzggj;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;
import com.google.android.gms.internal.ads.zzze;
import com.google.android.gms.internal.ads.zzzg;
import com.google.android.gms.internal.ads.zzzl;

public final class zzzm
extends zzgga<zzzm, zzzl>
implements zzghj {
    private static final zzzm zzi;
    private int zzb;
    private zzggj<zzgex> zze = zzzm.zzaE();
    private zzgex zzf = zzgex.zzb;
    private int zzg = 1;
    private int zzh = 1;

    static {
        zzzm zzzm2;
        zzi = zzzm2 = new zzzm();
        zzgga.zzay(zzzm.class, (zzgga)zzzm2);
    }

    private zzzm() {
    }

    public static zzzl zza() {
        return (zzzl)zzi.zzas();
    }

    static /* synthetic */ zzzm zzc() {
        return zzi;
    }

    static /* synthetic */ void zzd(zzzm zzzm2, zzgex zzgex2) {
        zzggj<zzgex> zzggj2 = zzzm2.zze;
        if (!zzggj2.zza()) {
            zzzm2.zze = zzgga.zzaF(zzggj2);
        }
        zzzm2.zze.add((Object)zzgex2);
    }

    static /* synthetic */ void zze(zzzm zzzm2, zzgex zzgex2) {
        zzzm2.zzb |= 1;
        zzzm2.zzf = zzgex2;
    }

    static /* synthetic */ void zzf(zzzm zzzm2, int n) {
        zzzm2.zzh = n - 1;
        zzzm2.zzb |= 4;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n != 2) {
            if (n == 3) return new zzzm();
            if (n == 4) return new zzzl(null);
            if (n == 5) return zzi;
            return null;
        }
        object2 = zzzg.zza;
        object = zzze.zza;
        return zzzm.zzaz((zzghi)zzi, (String)"\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u001c\u0002\u100a\u0000\u0003\u100c\u0001\u0004\u100c\u0002", (Object[])new Object[]{"zzb", "zze", "zzf", "zzg", object2, "zzh", object});
    }
}
