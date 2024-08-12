/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbam
 *  com.google.android.gms.internal.ads.zzbas
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzggf
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbam;
import com.google.android.gms.internal.ads.zzbas;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzggf;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzbat
extends zzgga<zzbat, zzbas>
implements zzghj {
    private static final zzbat zzg;
    private int zzb;
    private int zze;
    private zzggf zzf = zzbat.zzaB();

    static {
        zzbat zzbat2;
        zzg = zzbat2 = new zzbat();
        zzgga.zzay(zzbat.class, (zzgga)zzbat2);
    }

    private zzbat() {
    }

    static /* synthetic */ zzbat zza() {
        return zzg;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n != 2) {
            if (n == 3) return new zzbat();
            if (n == 4) return new zzbas(null);
            if (n == 5) return zzg;
            return null;
        }
        object = zzbam.zza;
        return zzbat.zzaz((zzghi)zzg, (String)"\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u100c\u0000\u0002\u0016", (Object[])new Object[]{"zzb", "zze", object, "zzf"});
    }
}
