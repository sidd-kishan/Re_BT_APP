/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbag
 *  com.google.android.gms.internal.ads.zzbam
 *  com.google.android.gms.internal.ads.zzbbx
 *  com.google.android.gms.internal.ads.zzbbz
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzgge
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbag;
import com.google.android.gms.internal.ads.zzbam;
import com.google.android.gms.internal.ads.zzbbx;
import com.google.android.gms.internal.ads.zzbbz;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzgge;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzbah
extends zzgga<zzbah, zzbag>
implements zzghj {
    private static final zzbah zzm;
    private int zzb;
    private String zze = "";
    private zzbbx zzf;
    private int zzg;
    private zzbbz zzh;
    private int zzi;
    private int zzj = 1000;
    private int zzk = 1000;
    private int zzl = 1000;

    static {
        zzbah zzbah2;
        zzm = zzbah2 = new zzbah();
        zzgga.zzay(zzbah.class, (zzgga)zzbah2);
    }

    private zzbah() {
    }

    public static zzbah zza() {
        return zzm;
    }

    static /* synthetic */ zzbah zzc() {
        return zzm;
    }

    static /* synthetic */ void zzd(zzbah zzbah2, String string) {
        zzbah2.zzb |= 1;
        zzbah2.zze = string;
    }

    static /* synthetic */ void zze(zzbah zzbah2, zzbbz zzbbz2) {
        zzbbz2.getClass();
        zzbah2.zzh = zzbbz2;
        zzbah2.zzb |= 8;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n != 2) {
            if (n == 3) return new zzbah();
            if (n == 4) return new zzbag(null);
            if (n == 5) return zzm;
            return null;
        }
        object2 = zzbam.zza;
        zzgge zzgge2 = zzbam.zza;
        object = zzbam.zza;
        return zzbah.zzaz((zzghi)zzm, (String)"\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001\u1008\u0000\u0002\u1009\u0001\u0003\u1004\u0002\u0004\u1009\u0003\u0005\u1004\u0004\u0006\u100c\u0005\u0007\u100c\u0006\b\u100c\u0007", (Object[])new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", object2, "zzk", zzgge2, "zzl", object});
    }
}
