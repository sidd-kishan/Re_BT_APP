/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfxe
 *  com.google.android.gms.internal.ads.zzfxl
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzgfm
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzggm
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfxe;
import com.google.android.gms.internal.ads.zzfxl;
import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzgfm;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzggm;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzfxf
extends zzgga<zzfxf, zzfxe>
implements zzghj {
    private static final zzfxf zzg;
    private int zzb;
    private zzgex zze = zzgex.zzb;
    private zzfxl zzf;

    static {
        zzfxf zzfxf2;
        zzg = zzfxf2 = new zzfxf();
        zzgga.zzay(zzfxf.class, (zzgga)zzfxf2);
    }

    private zzfxf() {
    }

    public static zzfxf zze(zzgex zzgex2, zzgfm zzgfm2) throws zzggm {
        return (zzfxf)zzgga.zzaI((zzgga)zzg, (zzgex)zzgex2, (zzgfm)zzgfm2);
    }

    public static zzfxe zzf() {
        return (zzfxe)zzg.zzas();
    }

    static /* synthetic */ zzfxf zzg() {
        return zzg;
    }

    static /* synthetic */ void zzh(zzfxf zzfxf2, int n) {
        zzfxf2.zzb = 0;
    }

    static /* synthetic */ void zzi(zzfxf zzfxf2, zzgex zzgex2) {
        zzfxf2.zze = zzgex2;
    }

    static /* synthetic */ void zzj(zzfxf zzfxf2, zzfxl zzfxl2) {
        zzfxl2.getClass();
        zzfxf2.zzf = zzfxl2;
    }

    public final int zza() {
        return this.zzb;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n == 2) return zzfxf.zzaz((zzghi)zzg, (String)"\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\n\u0003\t", (Object[])new Object[]{"zzb", "zze", "zzf"});
        if (n == 3) return new zzfxf();
        if (n == 4) return new zzfxe(null);
        if (n == 5) return zzg;
        return null;
    }

    public final zzgex zzc() {
        return this.zze;
    }

    public final zzfxl zzd() {
        zzfxl zzfxl2;
        zzfxl zzfxl3 = zzfxl2 = this.zzf;
        if (zzfxl2 != null) return zzfxl3;
        zzfxl3 = zzfxl.zzd();
        return zzfxl3;
    }
}
