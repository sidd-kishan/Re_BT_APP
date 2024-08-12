/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfza
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzgfm
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzggm
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfza;
import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzgfm;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzggm;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzfzb
extends zzgga<zzfzb, zzfza>
implements zzghj {
    private static final zzfzb zzf;
    private int zzb;
    private int zze;

    static {
        zzfzb zzfzb2;
        zzf = zzfzb2 = new zzfzb();
        zzgga.zzay(zzfzb.class, (zzgga)zzfzb2);
    }

    private zzfzb() {
    }

    public static zzfzb zzc(zzgex zzgex2, zzgfm zzgfm2) throws zzggm {
        return (zzfzb)zzgga.zzaI((zzgga)zzf, (zzgex)zzgex2, (zzgfm)zzgfm2);
    }

    public static zzfza zzd() {
        return (zzfza)zzf.zzas();
    }

    static /* synthetic */ zzfzb zze() {
        return zzf;
    }

    static /* synthetic */ void zzf(zzfzb zzfzb2, int n) {
        zzfzb2.zzb = 64;
    }

    public final int zza() {
        return this.zzb;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n == 2) return zzfzb.zzaz((zzghi)zzf, (String)"\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\u000b", (Object[])new Object[]{"zzb", "zze"});
        if (n == 3) return new zzfzb();
        if (n == 4) return new zzfza(null);
        if (n == 5) return zzf;
        return null;
    }
}
