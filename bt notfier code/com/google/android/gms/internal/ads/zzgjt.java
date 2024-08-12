/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 *  com.google.android.gms.internal.ads.zzgjs
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;
import com.google.android.gms.internal.ads.zzgjs;

public final class zzgjt
extends zzgga<zzgjt, zzgjs>
implements zzghj {
    private static final zzgjt zzh;
    private int zzb;
    private int zze;
    private zzgex zzf = zzgex.zzb;
    private zzgex zzg = zzgex.zzb;

    static {
        zzgjt zzgjt2;
        zzh = zzgjt2 = new zzgjt();
        zzgga.zzay(zzgjt.class, (zzgga)zzgjt2);
    }

    private zzgjt() {
    }

    static /* synthetic */ zzgjt zza() {
        return zzh;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n == 2) return zzgjt.zzaz((zzghi)zzh, (String)"\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u1004\u0000\u0002\u100a\u0001\u0003\u100a\u0002", (Object[])new Object[]{"zzb", "zze", "zzf", "zzg"});
        if (n == 3) return new zzgjt();
        if (n == 4) return new zzgjs(null);
        if (n == 5) return zzh;
        return null;
    }
}
