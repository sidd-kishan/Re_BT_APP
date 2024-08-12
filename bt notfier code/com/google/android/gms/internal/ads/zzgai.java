/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgah
 *  com.google.android.gms.internal.ads.zzgao
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzgfm
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzggm
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgah;
import com.google.android.gms.internal.ads.zzgao;
import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzgfm;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzggm;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzgai
extends zzgga<zzgai, zzgah>
implements zzghj {
    private static final zzgai zzg;
    private int zzb;
    private zzgao zze;
    private zzgex zzf = zzgex.zzb;

    static {
        zzgai zzgai2;
        zzg = zzgai2 = new zzgai();
        zzgga.zzay(zzgai.class, (zzgga)zzgai2);
    }

    private zzgai() {
    }

    public static zzgai zze(zzgex zzgex2, zzgfm zzgfm2) throws zzggm {
        return (zzgai)zzgga.zzaI((zzgga)zzg, (zzgex)zzgex2, (zzgfm)zzgfm2);
    }

    public static zzgah zzf() {
        return (zzgah)zzg.zzas();
    }

    public static zzgai zzg() {
        return zzg;
    }

    static /* synthetic */ zzgai zzh() {
        return zzg;
    }

    static /* synthetic */ void zzi(zzgai zzgai2, int n) {
        zzgai2.zzb = 0;
    }

    static /* synthetic */ void zzj(zzgai zzgai2, zzgao zzgao2) {
        zzgao2.getClass();
        zzgai2.zze = zzgao2;
    }

    static /* synthetic */ void zzk(zzgai zzgai2, zzgex zzgex2) {
        zzgai2.zzf = zzgex2;
    }

    public final int zza() {
        return this.zzb;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n == 2) return zzgai.zzaz((zzghi)zzg, (String)"\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", (Object[])new Object[]{"zzb", "zze", "zzf"});
        if (n == 3) return new zzgai();
        if (n == 4) return new zzgah(null);
        if (n == 5) return zzg;
        return null;
    }

    public final zzgao zzc() {
        zzgao zzgao2;
        zzgao zzgao3 = zzgao2 = this.zze;
        if (zzgao2 != null) return zzgao3;
        zzgao3 = zzgao.zzd();
        return zzgao3;
    }

    public final zzgex zzd() {
        return this.zzf;
    }
}
