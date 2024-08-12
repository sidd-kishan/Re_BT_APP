/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgak
 *  com.google.android.gms.internal.ads.zzgao
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzgfm
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzggm
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgak;
import com.google.android.gms.internal.ads.zzgao;
import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzgfm;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzggm;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzgal
extends zzgga<zzgal, zzgak>
implements zzghj {
    private static final zzgal zzg;
    private zzgao zzb;
    private int zze;
    private int zzf;

    static {
        zzgal zzgal2;
        zzg = zzgal2 = new zzgal();
        zzgga.zzay(zzgal.class, (zzgga)zzgal2);
    }

    private zzgal() {
    }

    public static zzgal zzd(zzgex zzgex2, zzgfm zzgfm2) throws zzggm {
        return (zzgal)zzgga.zzaI((zzgga)zzg, (zzgex)zzgex2, (zzgfm)zzgfm2);
    }

    public static zzgak zze() {
        return (zzgak)zzg.zzas();
    }

    public static zzgal zzf() {
        return zzg;
    }

    static /* synthetic */ zzgal zzg() {
        return zzg;
    }

    static /* synthetic */ void zzh(zzgal zzgal2, zzgao zzgao2) {
        zzgao2.getClass();
        zzgal2.zzb = zzgao2;
    }

    static /* synthetic */ void zzi(zzgal zzgal2, int n) {
        zzgal2.zze = n;
    }

    public final zzgao zza() {
        zzgao zzgao2;
        zzgao zzgao3 = zzgao2 = this.zzb;
        if (zzgao2 != null) return zzgao3;
        zzgao3 = zzgao.zzd();
        return zzgao3;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n == 2) return zzgal.zzaz((zzghi)zzg, (String)"\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\u000b\u0003\u000b", (Object[])new Object[]{"zzb", "zze", "zzf"});
        if (n == 3) return new zzgal();
        if (n == 4) return new zzgak(null);
        if (n == 5) return zzg;
        return null;
    }

    public final int zzc() {
        return this.zze;
    }
}
