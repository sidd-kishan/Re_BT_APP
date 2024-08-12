/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfxq
 *  com.google.android.gms.internal.ads.zzfxx
 *  com.google.android.gms.internal.ads.zzgal
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzgfm
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzggm
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfxq;
import com.google.android.gms.internal.ads.zzfxx;
import com.google.android.gms.internal.ads.zzgal;
import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzgfm;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzggm;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzfxr
extends zzgga<zzfxr, zzfxq>
implements zzghj {
    private static final zzfxr zzf;
    private zzfxx zzb;
    private zzgal zze;

    static {
        zzfxr zzfxr2;
        zzf = zzfxr2 = new zzfxr();
        zzgga.zzay(zzfxr.class, (zzgga)zzfxr2);
    }

    private zzfxr() {
    }

    public static zzfxr zzd(zzgex zzgex2, zzgfm zzgfm2) throws zzggm {
        return (zzfxr)zzgga.zzaI((zzgga)zzf, (zzgex)zzgex2, (zzgfm)zzgfm2);
    }

    public static zzfxq zze() {
        return (zzfxq)zzf.zzas();
    }

    static /* synthetic */ zzfxr zzf() {
        return zzf;
    }

    static /* synthetic */ void zzg(zzfxr zzfxr2, zzfxx zzfxx2) {
        zzfxx2.getClass();
        zzfxr2.zzb = zzfxx2;
    }

    static /* synthetic */ void zzh(zzfxr zzfxr2, zzgal zzgal2) {
        zzgal2.getClass();
        zzfxr2.zze = zzgal2;
    }

    public final zzfxx zza() {
        zzfxx zzfxx2;
        zzfxx zzfxx3 = zzfxx2 = this.zzb;
        if (zzfxx2 != null) return zzfxx3;
        zzfxx3 = zzfxx.zzf();
        return zzfxx3;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n == 2) return zzfxr.zzaz((zzghi)zzf, (String)"\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\t", (Object[])new Object[]{"zzb", "zze"});
        if (n == 3) return new zzfxr();
        if (n == 4) return new zzfxq(null);
        if (n == 5) return zzf;
        return null;
    }

    public final zzgal zzc() {
        zzgal zzgal2;
        zzgal zzgal3 = zzgal2 = this.zze;
        if (zzgal2 != null) return zzgal3;
        zzgal3 = zzgal.zzf();
        return zzgal3;
    }
}
