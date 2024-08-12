/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbam
 *  com.google.android.gms.internal.ads.zzbcg
 *  com.google.android.gms.internal.ads.zzbcj
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbam;
import com.google.android.gms.internal.ads.zzbcg;
import com.google.android.gms.internal.ads.zzbcj;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzbck
extends zzgga<zzbck, zzbcj>
implements zzghj {
    private static final zzbck zzj;
    private int zzb;
    private int zze = 1000;
    private zzbcg zzf;
    private int zzg;
    private int zzh;
    private int zzi;

    static {
        zzbck zzbck2;
        zzj = zzbck2 = new zzbck();
        zzgga.zzay(zzbck.class, (zzgga)zzbck2);
    }

    private zzbck() {
    }

    static /* synthetic */ zzbck zza() {
        return zzj;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n != 2) {
            if (n == 3) return new zzbck();
            if (n == 4) return new zzbcj(null);
            if (n == 5) return zzj;
            return null;
        }
        object = zzbam.zza;
        return zzbck.zzaz((zzghi)zzj, (String)"\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\u100c\u0000\u0002\u1009\u0001\u0003\u1004\u0002\u0004\u1004\u0003\u0005\u1004\u0004", (Object[])new Object[]{"zzb", "zze", object, "zzf", "zzg", "zzh", "zzi"});
    }
}
