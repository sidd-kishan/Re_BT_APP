/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbam
 *  com.google.android.gms.internal.ads.zzbbx
 *  com.google.android.gms.internal.ads.zzbcg
 *  com.google.android.gms.internal.ads.zzbcl
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbam;
import com.google.android.gms.internal.ads.zzbbx;
import com.google.android.gms.internal.ads.zzbcg;
import com.google.android.gms.internal.ads.zzbcl;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzbcm
extends zzgga<zzbcm, zzbcl>
implements zzghj {
    private static final zzbcm zzh;
    private int zzb;
    private int zze = 1000;
    private zzbcg zzf;
    private zzbbx zzg;

    static {
        zzbcm zzbcm2;
        zzh = zzbcm2 = new zzbcm();
        zzgga.zzay(zzbcm.class, (zzgga)zzbcm2);
    }

    private zzbcm() {
    }

    static /* synthetic */ zzbcm zza() {
        return zzh;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n != 2) {
            if (n == 3) return new zzbcm();
            if (n == 4) return new zzbcl(null);
            if (n == 5) return zzh;
            return null;
        }
        object = zzbam.zza;
        return zzbcm.zzaz((zzghi)zzh, (String)"\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u100c\u0000\u0002\u1009\u0001\u0003\u1009\u0002", (Object[])new Object[]{"zzb", "zze", object, "zzf", "zzg"});
    }
}
