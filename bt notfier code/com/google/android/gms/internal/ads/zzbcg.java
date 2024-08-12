/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbce
 *  com.google.android.gms.internal.ads.zzbcf
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbce;
import com.google.android.gms.internal.ads.zzbcf;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzbcg
extends zzgga<zzbcg, zzbce>
implements zzghj {
    private static final zzbcg zzf;
    private int zzb;
    private int zze;

    static {
        zzbcg zzbcg2;
        zzf = zzbcg2 = new zzbcg();
        zzgga.zzay(zzbcg.class, (zzgga)zzbcg2);
    }

    private zzbcg() {
    }

    static /* synthetic */ zzbcg zza() {
        return zzf;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n != 2) {
            if (n == 3) return new zzbcg();
            if (n == 4) return new zzbce(null);
            if (n == 5) return zzf;
            return null;
        }
        object = zzbcf.zza;
        return zzbcg.zzaz((zzghi)zzf, (String)"\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u100c\u0000", (Object[])new Object[]{"zzb", "zze", object});
    }
}
