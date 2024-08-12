/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfxt
 *  com.google.android.gms.internal.ads.zzfya
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzgfm
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzggm
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfxt;
import com.google.android.gms.internal.ads.zzfya;
import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzgfm;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzggm;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzfxu
extends zzgga<zzfxu, zzfxt>
implements zzghj {
    private static final zzfxu zzg;
    private int zzb;
    private zzfya zze;
    private zzgex zzf = zzgex.zzb;

    static {
        zzfxu zzfxu2;
        zzg = zzfxu2 = new zzfxu();
        zzgga.zzay(zzfxu.class, (zzgga)zzfxu2);
    }

    private zzfxu() {
    }

    public static zzfxu zze(zzgex zzgex2, zzgfm zzgfm2) throws zzggm {
        return (zzfxu)zzgga.zzaI((zzgga)zzg, (zzgex)zzgex2, (zzgfm)zzgfm2);
    }

    public static zzfxt zzf() {
        return (zzfxt)zzg.zzas();
    }

    public static zzfxu zzg() {
        return zzg;
    }

    static /* synthetic */ zzfxu zzh() {
        return zzg;
    }

    static /* synthetic */ void zzi(zzfxu zzfxu2, int n) {
        zzfxu2.zzb = 0;
    }

    static /* synthetic */ void zzj(zzfxu zzfxu2, zzfya zzfya2) {
        zzfya2.getClass();
        zzfxu2.zze = zzfya2;
    }

    static /* synthetic */ void zzk(zzfxu zzfxu2, zzgex zzgex2) {
        zzfxu2.zzf = zzgex2;
    }

    public final int zza() {
        return this.zzb;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n == 2) return zzfxu.zzaz((zzghi)zzg, (String)"\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", (Object[])new Object[]{"zzb", "zze", "zzf"});
        if (n == 3) return new zzfxu();
        if (n == 4) return new zzfxt(null);
        if (n == 5) return zzg;
        return null;
    }

    public final zzfya zzc() {
        zzfya zzfya2;
        zzfya zzfya3 = zzfya2 = this.zze;
        if (zzfya2 != null) return zzfya3;
        zzfya3 = zzfya.zzd();
        return zzfya3;
    }

    public final zzgex zzd() {
        return this.zzf;
    }
}
