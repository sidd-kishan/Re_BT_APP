/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfxz
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfxz;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzfya
extends zzgga<zzfya, zzfxz>
implements zzghj {
    private static final zzfya zze;
    private int zzb;

    static {
        zzfya zzfya2;
        zze = zzfya2 = new zzfya();
        zzgga.zzay(zzfya.class, (zzgga)zzfya2);
    }

    private zzfya() {
    }

    public static zzfxz zzc() {
        return (zzfxz)zze.zzas();
    }

    public static zzfya zzd() {
        return zze;
    }

    static /* synthetic */ zzfya zze() {
        return zze;
    }

    static /* synthetic */ void zzf(zzfya zzfya2, int n) {
        zzfya2.zzb = 16;
    }

    public final int zza() {
        return this.zzb;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n == 2) return zzfya.zzaz((zzghi)zze, (String)"\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", (Object[])new Object[]{"zzb"});
        if (n == 3) return new zzfya();
        if (n == 4) return new zzfxz(null);
        if (n == 5) return zze;
        return null;
    }
}
