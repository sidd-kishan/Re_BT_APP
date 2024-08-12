/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbam
 *  com.google.android.gms.internal.ads.zzbcg
 *  com.google.android.gms.internal.ads.zzbcn
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbam;
import com.google.android.gms.internal.ads.zzbcg;
import com.google.android.gms.internal.ads.zzbcn;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzbco
extends zzgga<zzbco, zzbcn>
implements zzghj {
    private static final zzbco zzk;
    private int zzb;
    private int zze = 1000;
    private zzbcg zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private long zzj;

    static {
        zzbco zzbco2;
        zzk = zzbco2 = new zzbco();
        zzgga.zzay(zzbco.class, (zzgga)zzbco2);
    }

    private zzbco() {
    }

    static /* synthetic */ zzbco zza() {
        return zzk;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n != 2) {
            if (n == 3) return new zzbco();
            if (n == 4) return new zzbcn(null);
            if (n == 5) return zzk;
            return null;
        }
        object = zzbam.zza;
        return zzbco.zzaz((zzghi)zzk, (String)"\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\u100c\u0000\u0002\u1009\u0001\u0003\u1004\u0002\u0004\u1004\u0003\u0005\u1004\u0004\u0006\u1003\u0005", (Object[])new Object[]{"zzb", "zze", object, "zzf", "zzg", "zzh", "zzi", "zzj"});
    }
}
