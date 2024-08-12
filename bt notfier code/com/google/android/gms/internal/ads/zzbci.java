/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbam
 *  com.google.android.gms.internal.ads.zzbbx
 *  com.google.android.gms.internal.ads.zzbbz
 *  com.google.android.gms.internal.ads.zzbcg
 *  com.google.android.gms.internal.ads.zzbch
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbam;
import com.google.android.gms.internal.ads.zzbbx;
import com.google.android.gms.internal.ads.zzbbz;
import com.google.android.gms.internal.ads.zzbcg;
import com.google.android.gms.internal.ads.zzbch;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzbci
extends zzgga<zzbci, zzbch>
implements zzghj {
    private static final zzbci zzi;
    private int zzb;
    private zzbbz zze;
    private int zzf = 1000;
    private zzbcg zzg;
    private zzbbx zzh;

    static {
        zzbci zzbci2;
        zzi = zzbci2 = new zzbci();
        zzgga.zzay(zzbci.class, (zzgga)zzbci2);
    }

    private zzbci() {
    }

    static /* synthetic */ zzbci zza() {
        return zzi;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n != 2) {
            if (n == 3) return new zzbci();
            if (n == 4) return new zzbch(null);
            if (n == 5) return zzi;
            return null;
        }
        object = zzbam.zza;
        return zzbci.zzaz((zzghi)zzi, (String)"\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u1009\u0000\u0002\u100c\u0001\u0003\u1009\u0002\u0004\u1009\u0003", (Object[])new Object[]{"zzb", "zze", "zzf", object, "zzg", "zzh"});
    }
}
