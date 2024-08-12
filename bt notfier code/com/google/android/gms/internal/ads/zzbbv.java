/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbam
 *  com.google.android.gms.internal.ads.zzbbu
 *  com.google.android.gms.internal.ads.zzbbx
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbam;
import com.google.android.gms.internal.ads.zzbbu;
import com.google.android.gms.internal.ads.zzbbx;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzbbv
extends zzgga<zzbbv, zzbbu>
implements zzghj {
    private static final zzbbv zzh;
    private int zzb;
    private String zze = "";
    private int zzf;
    private zzbbx zzg;

    static {
        zzbbv zzbbv2;
        zzh = zzbbv2 = new zzbbv();
        zzgga.zzay(zzbbv.class, (zzgga)zzbbv2);
    }

    private zzbbv() {
    }

    static /* synthetic */ zzbbv zza() {
        return zzh;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n != 2) {
            if (n == 3) return new zzbbv();
            if (n == 4) return new zzbbu(null);
            if (n == 5) return zzh;
            return null;
        }
        object = zzbam.zza;
        return zzbbv.zzaz((zzghi)zzh, (String)"\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u1008\u0000\u0002\u100c\u0001\u0003\u1009\u0002", (Object[])new Object[]{"zzb", "zze", "zzf", object, "zzg"});
    }
}
