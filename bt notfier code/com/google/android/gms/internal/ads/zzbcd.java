/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbam
 *  com.google.android.gms.internal.ads.zzbbx
 *  com.google.android.gms.internal.ads.zzbcc
 *  com.google.android.gms.internal.ads.zzbcg
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbam;
import com.google.android.gms.internal.ads.zzbbx;
import com.google.android.gms.internal.ads.zzbcc;
import com.google.android.gms.internal.ads.zzbcg;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzbcd
extends zzgga<zzbcd, zzbcc>
implements zzghj {
    private static final zzbcd zzh;
    private int zzb;
    private int zze = 1000;
    private zzbcg zzf;
    private zzbbx zzg;

    static {
        zzbcd zzbcd2;
        zzh = zzbcd2 = new zzbcd();
        zzgga.zzay(zzbcd.class, (zzgga)zzbcd2);
    }

    private zzbcd() {
    }

    static /* synthetic */ zzbcd zza() {
        return zzh;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n != 2) {
            if (n == 3) return new zzbcd();
            if (n == 4) return new zzbcc(null);
            if (n == 5) return zzh;
            return null;
        }
        object = zzbam.zza;
        return zzbcd.zzaz((zzghi)zzh, (String)"\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u100c\u0000\u0002\u1009\u0001\u0003\u1009\u0002", (Object[])new Object[]{"zzb", "zze", object, "zzf", "zzg"});
    }
}