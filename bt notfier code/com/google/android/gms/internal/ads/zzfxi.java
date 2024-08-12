/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfxh
 *  com.google.android.gms.internal.ads.zzfxl
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzgfm
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzggm
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfxh;
import com.google.android.gms.internal.ads.zzfxl;
import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzgfm;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzggm;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzfxi
extends zzgga<zzfxi, zzfxh>
implements zzghj {
    private static final zzfxi zzf;
    private int zzb;
    private zzfxl zze;

    static {
        zzfxi zzfxi2;
        zzf = zzfxi2 = new zzfxi();
        zzgga.zzay(zzfxi.class, (zzgga)zzfxi2);
    }

    private zzfxi() {
    }

    public static zzfxi zzd(zzgex zzgex2, zzgfm zzgfm2) throws zzggm {
        return (zzfxi)zzgga.zzaI((zzgga)zzf, (zzgex)zzgex2, (zzgfm)zzgfm2);
    }

    public static zzfxh zze() {
        return (zzfxh)zzf.zzas();
    }

    static /* synthetic */ zzfxi zzf() {
        return zzf;
    }

    static /* synthetic */ void zzg(zzfxi zzfxi2, int n) {
        zzfxi2.zzb = 32;
    }

    static /* synthetic */ void zzh(zzfxi zzfxi2, zzfxl zzfxl2) {
        zzfxl2.getClass();
        zzfxi2.zze = zzfxl2;
    }

    public final int zza() {
        return this.zzb;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n == 2) return zzfxi.zzaz((zzghi)zzf, (String)"\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", (Object[])new Object[]{"zzb", "zze"});
        if (n == 3) return new zzfxi();
        if (n == 4) return new zzfxh(null);
        if (n == 5) return zzf;
        return null;
    }

    public final zzfxl zzc() {
        zzfxl zzfxl2;
        zzfxl zzfxl3 = zzfxl2 = this.zze;
        if (zzfxl2 != null) return zzfxl3;
        zzfxl3 = zzfxl.zzd();
        return zzfxl3;
    }
}
