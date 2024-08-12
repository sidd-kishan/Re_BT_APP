/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfyr
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzgfm
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzggm
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfyr;
import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzgfm;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzggm;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzfys
extends zzgga<zzfys, zzfyr>
implements zzghj {
    private static final zzfys zzf;
    private int zzb;
    private zzgex zze = zzgex.zzb;

    static {
        zzfys zzfys2;
        zzf = zzfys2 = new zzfys();
        zzgga.zzay(zzfys.class, (zzgga)zzfys2);
    }

    private zzfys() {
    }

    public static zzfys zzd(zzgex zzgex2, zzgfm zzgfm2) throws zzggm {
        return (zzfys)zzgga.zzaI((zzgga)zzf, (zzgex)zzgex2, (zzgfm)zzgfm2);
    }

    public static zzfyr zze() {
        return (zzfyr)zzf.zzas();
    }

    static /* synthetic */ zzfys zzf() {
        return zzf;
    }

    static /* synthetic */ void zzg(zzfys zzfys2, int n) {
        zzfys2.zzb = 0;
    }

    static /* synthetic */ void zzh(zzfys zzfys2, zzgex zzgex2) {
        zzfys2.zze = zzgex2;
    }

    public final int zza() {
        return this.zzb;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n == 2) return zzfys.zzaz((zzghi)zzf, (String)"\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", (Object[])new Object[]{"zzb", "zze"});
        if (n == 3) return new zzfys();
        if (n == 4) return new zzfyr(null);
        if (n == 5) return zzf;
        return null;
    }

    public final zzgex zzc() {
        return this.zze;
    }
}
