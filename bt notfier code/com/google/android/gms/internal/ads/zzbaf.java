/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbae
 *  com.google.android.gms.internal.ads.zzbbx
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzggj
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbae;
import com.google.android.gms.internal.ads.zzbbx;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzggj;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzbaf
extends zzgga<zzbaf, zzbae>
implements zzghj {
    private static final zzbaf zzk;
    private int zzb;
    private int zze;
    private zzbbx zzf;
    private zzbbx zzg;
    private zzbbx zzh;
    private zzggj<zzbbx> zzi = zzbaf.zzaE();
    private int zzj;

    static {
        zzbaf zzbaf2;
        zzk = zzbaf2 = new zzbaf();
        zzgga.zzay(zzbaf.class, (zzgga)zzbaf2);
    }

    private zzbaf() {
    }

    static /* synthetic */ zzbaf zza() {
        return zzk;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n == 2) return zzbaf.zzaz((zzghi)zzk, (String)"\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001\u1004\u0000\u0002\u1009\u0001\u0003\u1009\u0002\u0004\u1009\u0003\u0005\u001b\u0006\u1004\u0004", (Object[])new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi", zzbbx.class, "zzj"});
        if (n == 3) return new zzbaf();
        if (n == 4) return new zzbae(null);
        if (n == 5) return zzk;
        return null;
    }
}
