/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 *  com.google.android.gms.internal.ads.zzgjo
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;
import com.google.android.gms.internal.ads.zzgjo;

public final class zzgjp
extends zzgga<zzgjp, zzgjo>
implements zzghj {
    private static final zzgjp zzh;
    private int zzb;
    private zzgex zze = zzgex.zzb;
    private zzgex zzf = zzgex.zzb;
    private zzgex zzg = zzgex.zzb;

    static {
        zzgjp zzgjp2;
        zzh = zzgjp2 = new zzgjp();
        zzgga.zzay(zzgjp.class, (zzgga)zzgjp2);
    }

    private zzgjp() {
    }

    static /* synthetic */ zzgjp zza() {
        return zzh;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n == 2) return zzgjp.zzaz((zzghi)zzh, (String)"\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u100a\u0000\u0002\u100a\u0001\u0003\u100a\u0002", (Object[])new Object[]{"zzb", "zze", "zzf", "zzg"});
        if (n == 3) return new zzgjp();
        if (n == 4) return new zzgjo(null);
        if (n == 5) return zzh;
        return null;
    }
}
