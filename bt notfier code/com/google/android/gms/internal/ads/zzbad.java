/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzazz
 *  com.google.android.gms.internal.ads.zzbac
 *  com.google.android.gms.internal.ads.zzbam
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzgge
 *  com.google.android.gms.internal.ads.zzggj
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzazz;
import com.google.android.gms.internal.ads.zzbac;
import com.google.android.gms.internal.ads.zzbam;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzgge;
import com.google.android.gms.internal.ads.zzggj;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzbad
extends zzgga<zzbad, zzbac>
implements zzghj {
    private static final zzbad zzj;
    private int zzb;
    private String zze = "";
    private zzggj<zzazz> zzf = zzbad.zzaE();
    private int zzg = 1000;
    private int zzh = 1000;
    private int zzi = 1000;

    static {
        zzbad zzbad2;
        zzj = zzbad2 = new zzbad();
        zzgga.zzay(zzbad.class, (zzgga)zzbad2);
    }

    private zzbad() {
    }

    public static zzbad zza() {
        return zzj;
    }

    static /* synthetic */ zzbad zzc() {
        return zzj;
    }

    static /* synthetic */ void zzd(zzbad zzbad2, String string) {
        string.getClass();
        zzbad2.zzb |= 1;
        zzbad2.zze = string;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n != 2) {
            if (n == 3) return new zzbad();
            if (n == 4) return new zzbac(null);
            if (n == 5) return zzj;
            return null;
        }
        object2 = zzbam.zza;
        zzgge zzgge2 = zzbam.zza;
        object = zzbam.zza;
        return zzbad.zzaz((zzghi)zzj, (String)"\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u1008\u0000\u0002\u001b\u0003\u100c\u0001\u0004\u100c\u0002\u0005\u100c\u0003", (Object[])new Object[]{"zzb", "zze", "zzf", zzazz.class, "zzg", object2, "zzh", zzgge2, "zzi", object});
    }
}
