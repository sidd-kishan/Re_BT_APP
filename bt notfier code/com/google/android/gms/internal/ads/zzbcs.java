/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbam
 *  com.google.android.gms.internal.ads.zzbcg
 *  com.google.android.gms.internal.ads.zzbcr
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbam;
import com.google.android.gms.internal.ads.zzbcg;
import com.google.android.gms.internal.ads.zzbcr;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzbcs
extends zzgga<zzbcs, zzbcr>
implements zzghj {
    private static final zzbcs zzg;
    private int zzb;
    private int zze = 1000;
    private zzbcg zzf;

    static {
        zzbcs zzbcs2;
        zzg = zzbcs2 = new zzbcs();
        zzgga.zzay(zzbcs.class, (zzgga)zzbcs2);
    }

    private zzbcs() {
    }

    static /* synthetic */ zzbcs zza() {
        return zzg;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n != 2) {
            if (n == 3) return new zzbcs();
            if (n == 4) return new zzbcr(null);
            if (n == 5) return zzg;
            return null;
        }
        object = zzbam.zza;
        return zzbcs.zzaz((zzghi)zzg, (String)"\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u100c\u0000\u0002\u1009\u0001", (Object[])new Object[]{"zzb", "zze", object, "zzf"});
    }
}
