/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbbw
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzbbx
extends zzgga<zzbbx, zzbbw>
implements zzghj {
    private static final zzbbx zzg;
    private int zzb;
    private int zze;
    private int zzf;

    static {
        zzbbx zzbbx2;
        zzg = zzbbx2 = new zzbbx();
        zzgga.zzay(zzbbx.class, (zzgga)zzbbx2);
    }

    private zzbbx() {
    }

    static /* synthetic */ zzbbx zza() {
        return zzg;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n == 2) return zzbbx.zzaz((zzghi)zzg, (String)"\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u1004\u0000\u0002\u1004\u0001", (Object[])new Object[]{"zzb", "zze", "zzf"});
        if (n == 3) return new zzbbx();
        if (n == 4) return new zzbbw(null);
        if (n == 5) return zzg;
        return null;
    }
}
