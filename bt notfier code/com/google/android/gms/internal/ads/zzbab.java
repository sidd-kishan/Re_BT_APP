/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzazz
 *  com.google.android.gms.internal.ads.zzbaa
 *  com.google.android.gms.internal.ads.zzbam
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzggj
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzazz;
import com.google.android.gms.internal.ads.zzbaa;
import com.google.android.gms.internal.ads.zzbam;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzggj;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzbab
extends zzgga<zzbab, zzbaa>
implements zzghj {
    private static final zzbab zzh;
    private int zzb;
    private String zze = "";
    private zzggj<zzazz> zzf = zzbab.zzaE();
    private int zzg;

    static {
        zzbab zzbab2;
        zzh = zzbab2 = new zzbab();
        zzgga.zzay(zzbab.class, (zzgga)zzbab2);
    }

    private zzbab() {
    }

    static /* synthetic */ zzbab zza() {
        return zzh;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n != 2) {
            if (n == 3) return new zzbab();
            if (n == 4) return new zzbaa(null);
            if (n == 5) return zzh;
            return null;
        }
        object = zzbam.zza;
        return zzbab.zzaz((zzghi)zzh, (String)"\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u1008\u0000\u0002\u001b\u0003\u100c\u0001", (Object[])new Object[]{"zzb", "zze", "zzf", zzazz.class, "zzg", object});
    }
}
