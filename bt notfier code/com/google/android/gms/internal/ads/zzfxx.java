/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfxw
 *  com.google.android.gms.internal.ads.zzfya
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzgfm
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzggm
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfxw;
import com.google.android.gms.internal.ads.zzfya;
import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzgfm;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzggm;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzfxx
extends zzgga<zzfxx, zzfxw>
implements zzghj {
    private static final zzfxx zzf;
    private zzfya zzb;
    private int zze;

    static {
        zzfxx zzfxx2;
        zzf = zzfxx2 = new zzfxx();
        zzgga.zzay(zzfxx.class, (zzgga)zzfxx2);
    }

    private zzfxx() {
    }

    public static zzfxx zzd(zzgex zzgex2, zzgfm zzgfm2) throws zzggm {
        return (zzfxx)zzgga.zzaI((zzgga)zzf, (zzgex)zzgex2, (zzgfm)zzgfm2);
    }

    public static zzfxw zze() {
        return (zzfxw)zzf.zzas();
    }

    public static zzfxx zzf() {
        return zzf;
    }

    static /* synthetic */ zzfxx zzg() {
        return zzf;
    }

    static /* synthetic */ void zzh(zzfxx zzfxx2, zzfya zzfya2) {
        zzfya2.getClass();
        zzfxx2.zzb = zzfya2;
    }

    static /* synthetic */ void zzi(zzfxx zzfxx2, int n) {
        zzfxx2.zze = n;
    }

    public final zzfya zza() {
        zzfya zzfya2;
        zzfya zzfya3 = zzfya2 = this.zzb;
        if (zzfya2 != null) return zzfya3;
        zzfya3 = zzfya.zzd();
        return zzfya3;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n == 2) return zzfxx.zzaz((zzghi)zzf, (String)"\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u000b", (Object[])new Object[]{"zzb", "zze"});
        if (n == 3) return new zzfxx();
        if (n == 4) return new zzfxw(null);
        if (n == 5) return zzf;
        return null;
    }

    public final int zzc() {
        return this.zze;
    }
}
