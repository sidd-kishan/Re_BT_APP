/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgbj
 *  com.google.android.gms.internal.ads.zzgbn
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzgfm
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzggm
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgbj;
import com.google.android.gms.internal.ads.zzgbn;
import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzgfm;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzggm;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzgbk
extends zzgga<zzgbk, zzgbj>
implements zzghj {
    private static final zzgbk zzf;
    private int zzb;
    private zzgbn zze;

    static {
        zzgbk zzgbk2;
        zzf = zzgbk2 = new zzgbk();
        zzgga.zzay(zzgbk.class, (zzgga)zzgbk2);
    }

    private zzgbk() {
    }

    public static zzgbk zzd(zzgex zzgex2, zzgfm zzgfm2) throws zzggm {
        return (zzgbk)zzgga.zzaI((zzgga)zzf, (zzgex)zzgex2, (zzgfm)zzgfm2);
    }

    public static zzgbj zze() {
        return (zzgbj)zzf.zzas();
    }

    static /* synthetic */ zzgbk zzf() {
        return zzf;
    }

    static /* synthetic */ void zzg(zzgbk zzgbk2, int n) {
        zzgbk2.zzb = 0;
    }

    static /* synthetic */ void zzh(zzgbk zzgbk2, zzgbn zzgbn2) {
        zzgbn2.getClass();
        zzgbk2.zze = zzgbn2;
    }

    public final int zza() {
        return this.zzb;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n == 2) return zzgbk.zzaz((zzghi)zzf, (String)"\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", (Object[])new Object[]{"zzb", "zze"});
        if (n == 3) return new zzgbk();
        if (n == 4) return new zzgbj(null);
        if (n == 5) return zzf;
        return null;
    }

    public final zzgbn zzc() {
        zzgbn zzgbn2;
        zzgbn zzgbn3 = zzgbn2 = this.zze;
        if (zzgbn2 != null) return zzgbn3;
        zzgbn3 = zzgbn.zzd();
        return zzgbn3;
    }
}
