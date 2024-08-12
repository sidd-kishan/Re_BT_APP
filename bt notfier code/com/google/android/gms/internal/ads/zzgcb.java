/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgca
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzgfm
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzggm
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgca;
import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzgfm;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzggm;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzgcb
extends zzgga<zzgcb, zzgca>
implements zzghj {
    private static final zzgcb zzf;
    private int zzb;
    private zzgex zze = zzgex.zzb;

    static {
        zzgcb zzgcb2;
        zzf = zzgcb2 = new zzgcb();
        zzgga.zzay(zzgcb.class, (zzgga)zzgcb2);
    }

    private zzgcb() {
    }

    public static zzgcb zzd(zzgex zzgex2, zzgfm zzgfm2) throws zzggm {
        return (zzgcb)zzgga.zzaI((zzgga)zzf, (zzgex)zzgex2, (zzgfm)zzgfm2);
    }

    public static zzgca zze() {
        return (zzgca)zzf.zzas();
    }

    static /* synthetic */ zzgcb zzf() {
        return zzf;
    }

    static /* synthetic */ void zzg(zzgcb zzgcb2, int n) {
        zzgcb2.zzb = 0;
    }

    static /* synthetic */ void zzh(zzgcb zzgcb2, zzgex zzgex2) {
        zzgcb2.zze = zzgex2;
    }

    public final int zza() {
        return this.zzb;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n == 2) return zzgcb.zzaz((zzghi)zzf, (String)"\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", (Object[])new Object[]{"zzb", "zze"});
        if (n == 3) return new zzgcb();
        if (n == 4) return new zzgca(null);
        if (n == 5) return zzf;
        return null;
    }

    public final zzgex zzc() {
        return this.zze;
    }
}
