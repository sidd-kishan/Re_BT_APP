/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 *  com.google.android.gms.internal.ads.zzxw
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;
import com.google.android.gms.internal.ads.zzxw;

public final class zzxx
extends zzgga<zzxx, zzxw>
implements zzghj {
    private static final zzxx zzg;
    private int zzb;
    private String zze = "";
    private String zzf = "";

    static {
        zzxx zzxx2;
        zzg = zzxx2 = new zzxx();
        zzgga.zzay(zzxx.class, (zzgga)zzxx2);
    }

    private zzxx() {
    }

    static /* synthetic */ zzxx zza() {
        return zzg;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n == 2) return zzxx.zzaz((zzghi)zzg, (String)"\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u1008\u0000\u0002\u1008\u0001", (Object[])new Object[]{"zzb", "zze", "zzf"});
        if (n == 3) return new zzxx();
        if (n == 4) return new zzxw(null);
        if (n == 5) return zzg;
        return null;
    }
}
