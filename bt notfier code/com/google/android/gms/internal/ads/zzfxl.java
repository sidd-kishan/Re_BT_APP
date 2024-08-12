/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfxk
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfxk;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzfxl
extends zzgga<zzfxl, zzfxk>
implements zzghj {
    private static final zzfxl zze;
    private int zzb;

    static {
        zzfxl zzfxl2;
        zze = zzfxl2 = new zzfxl();
        zzgga.zzay(zzfxl.class, (zzgga)zzfxl2);
    }

    private zzfxl() {
    }

    public static zzfxk zzc() {
        return (zzfxk)zze.zzas();
    }

    public static zzfxl zzd() {
        return zze;
    }

    static /* synthetic */ zzfxl zze() {
        return zze;
    }

    static /* synthetic */ void zzf(zzfxl zzfxl2, int n) {
        zzfxl2.zzb = 16;
    }

    public final int zza() {
        return this.zzb;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n == 2) return zzfxl.zzaz((zzghi)zze, (String)"\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", (Object[])new Object[]{"zzb"});
        if (n == 3) return new zzfxl();
        if (n == 4) return new zzfxk(null);
        if (n == 5) return zze;
        return null;
    }
}
