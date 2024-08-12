/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 *  com.google.android.gms.internal.ads.zzyo
 *  com.google.android.gms.internal.ads.zzyr
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;
import com.google.android.gms.internal.ads.zzyo;
import com.google.android.gms.internal.ads.zzyr;

public final class zzys
extends zzgga<zzys, zzyr>
implements zzghj {
    private static final zzys zzg;
    private int zzb;
    private int zze;
    private long zzf = -1L;

    static {
        zzys zzys2;
        zzg = zzys2 = new zzys();
        zzgga.zzay(zzys.class, (zzgga)zzys2);
    }

    private zzys() {
    }

    static /* synthetic */ zzys zza() {
        return zzg;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n != 2) {
            if (n == 3) return new zzys();
            if (n == 4) return new zzyr(null);
            if (n == 5) return zzg;
            return null;
        }
        object = zzyo.zza;
        return zzys.zzaz((zzghi)zzg, (String)"\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u100c\u0000\u0002\u1002\u0001", (Object[])new Object[]{"zzb", "zze", object, "zzf"});
    }
}
