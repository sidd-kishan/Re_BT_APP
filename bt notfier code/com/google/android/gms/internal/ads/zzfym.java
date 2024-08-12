/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfyl
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzgfm
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzggm
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfyl;
import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzgfm;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzggm;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzfym
extends zzgga<zzfym, zzfyl>
implements zzghj {
    private static final zzfym zzf;
    private int zzb;
    private zzgex zze = zzgex.zzb;

    static {
        zzfym zzfym2;
        zzf = zzfym2 = new zzfym();
        zzgga.zzay(zzfym.class, (zzgga)zzfym2);
    }

    private zzfym() {
    }

    public static zzfym zzd(zzgex zzgex2, zzgfm zzgfm2) throws zzggm {
        return (zzfym)zzgga.zzaI((zzgga)zzf, (zzgex)zzgex2, (zzgfm)zzgfm2);
    }

    public static zzfyl zze() {
        return (zzfyl)zzf.zzas();
    }

    static /* synthetic */ zzfym zzf() {
        return zzf;
    }

    static /* synthetic */ void zzg(zzfym zzfym2, int n) {
        zzfym2.zzb = 0;
    }

    static /* synthetic */ void zzh(zzfym zzfym2, zzgex zzgex2) {
        zzfym2.zze = zzgex2;
    }

    public final int zza() {
        return this.zzb;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n == 2) return zzfym.zzaz((zzghi)zzf, (String)"\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", (Object[])new Object[]{"zzb", "zze"});
        if (n == 3) return new zzfym();
        if (n == 4) return new zzfyl(null);
        if (n == 5) return zzf;
        return null;
    }

    public final zzgex zzc() {
        return this.zze;
    }
}
