/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbbq
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbbq;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzbbr
extends zzgga<zzbbr, zzbbq>
implements zzghj {
    private static final zzbbr zzg;
    private int zzb;
    private int zze;
    private int zzf;

    static {
        zzbbr zzbbr2;
        zzg = zzbbr2 = new zzbbr();
        zzgga.zzay(zzbbr.class, (zzgga)zzbbr2);
    }

    private zzbbr() {
    }

    static /* synthetic */ zzbbr zza() {
        return zzg;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n == 2) return zzbbr.zzaz((zzghi)zzg, (String)"\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u1004\u0000\u0002\u1004\u0001", (Object[])new Object[]{"zzb", "zze", "zzf"});
        if (n == 3) return new zzbbr();
        if (n == 4) return new zzbbq(null);
        if (n == 5) return zzg;
        return null;
    }
}
