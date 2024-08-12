/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgbp
 *  com.google.android.gms.internal.ads.zzgbt
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzgfm
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzggm
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgbp;
import com.google.android.gms.internal.ads.zzgbt;
import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzgfm;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzggm;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzgbq
extends zzgga<zzgbq, zzgbp>
implements zzghj {
    private static final zzgbq zzf;
    private int zzb;
    private zzgbt zze;

    static {
        zzgbq zzgbq2;
        zzf = zzgbq2 = new zzgbq();
        zzgga.zzay(zzgbq.class, (zzgga)zzgbq2);
    }

    private zzgbq() {
    }

    public static zzgbq zzd(zzgex zzgex2, zzgfm zzgfm2) throws zzggm {
        return (zzgbq)zzgga.zzaI((zzgga)zzf, (zzgex)zzgex2, (zzgfm)zzgfm2);
    }

    public static zzgbp zze() {
        return (zzgbp)zzf.zzas();
    }

    static /* synthetic */ zzgbq zzf() {
        return zzf;
    }

    static /* synthetic */ void zzg(zzgbq zzgbq2, int n) {
        zzgbq2.zzb = 0;
    }

    static /* synthetic */ void zzh(zzgbq zzgbq2, zzgbt zzgbt2) {
        zzgbt2.getClass();
        zzgbq2.zze = zzgbt2;
    }

    public final int zza() {
        return this.zzb;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n == 2) return zzgbq.zzaz((zzghi)zzf, (String)"\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", (Object[])new Object[]{"zzb", "zze"});
        if (n == 3) return new zzgbq();
        if (n == 4) return new zzgbp(null);
        if (n == 5) return zzf;
        return null;
    }

    public final zzgbt zzc() {
        zzgbt zzgbt2;
        zzgbt zzgbt3 = zzgbt2 = this.zze;
        if (zzgbt2 != null) return zzgbt3;
        zzgbt3 = zzgbt.zzf();
        return zzgbt3;
    }
}
