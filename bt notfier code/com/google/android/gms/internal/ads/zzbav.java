/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbam
 *  com.google.android.gms.internal.ads.zzbar
 *  com.google.android.gms.internal.ads.zzbau
 *  com.google.android.gms.internal.ads.zzbbv
 *  com.google.android.gms.internal.ads.zzbbx
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzggj
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbam;
import com.google.android.gms.internal.ads.zzbar;
import com.google.android.gms.internal.ads.zzbau;
import com.google.android.gms.internal.ads.zzbbv;
import com.google.android.gms.internal.ads.zzbbx;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzggj;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzbav
extends zzgga<zzbav, zzbau>
implements zzghj {
    private static final zzbav zzi;
    private int zzb;
    private zzbar zze;
    private zzggj<zzbbv> zzf = zzbav.zzaE();
    private int zzg;
    private zzbbx zzh;

    static {
        zzbav zzbav2;
        zzi = zzbav2 = new zzbav();
        zzgga.zzay(zzbav.class, (zzgga)zzbav2);
    }

    private zzbav() {
    }

    static /* synthetic */ zzbav zza() {
        return zzi;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n != 2) {
            if (n == 3) return new zzbav();
            if (n == 4) return new zzbau(null);
            if (n == 5) return zzi;
            return null;
        }
        object = zzbam.zza;
        return zzbav.zzaz((zzghi)zzi, (String)"\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u1009\u0000\u0002\u001b\u0003\u100c\u0001\u0004\u1009\u0002", (Object[])new Object[]{"zzb", "zze", "zzf", zzbbv.class, "zzg", object, "zzh"});
    }
}
