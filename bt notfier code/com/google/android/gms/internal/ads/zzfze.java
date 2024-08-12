/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfzd
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzgfm
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzggm
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfzd;
import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzgfm;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzggm;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzfze
extends zzgga<zzfze, zzfzd>
implements zzghj {
    private static final zzfze zzf;
    private int zzb;
    private zzgex zze = zzgex.zzb;

    static {
        zzfze zzfze2;
        zzf = zzfze2 = new zzfze();
        zzgga.zzay(zzfze.class, (zzgga)zzfze2);
    }

    private zzfze() {
    }

    public static zzfze zzd(zzgex zzgex2, zzgfm zzgfm2) throws zzggm {
        return (zzfze)zzgga.zzaI((zzgga)zzf, (zzgex)zzgex2, (zzgfm)zzgfm2);
    }

    public static zzfzd zze() {
        return (zzfzd)zzf.zzas();
    }

    static /* synthetic */ zzfze zzf() {
        return zzf;
    }

    static /* synthetic */ void zzg(zzfze zzfze2, int n) {
        zzfze2.zzb = 0;
    }

    static /* synthetic */ void zzh(zzfze zzfze2, zzgex zzgex2) {
        zzfze2.zze = zzgex2;
    }

    public final int zza() {
        return this.zzb;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n == 2) return zzfze.zzaz((zzghi)zzf, (String)"\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\n", (Object[])new Object[]{"zzb", "zze"});
        if (n == 3) return new zzfze();
        if (n == 4) return new zzfzd(null);
        if (n == 5) return zzf;
        return null;
    }

    public final zzgex zzc() {
        return this.zze;
    }
}
