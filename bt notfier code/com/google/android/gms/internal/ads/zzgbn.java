/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgbm
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzgfm
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzggm
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgbm;
import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzgfm;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzggm;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzgbn
extends zzgga<zzgbn, zzgbm>
implements zzghj {
    private static final zzgbn zze;
    private String zzb = "";

    static {
        zzgbn zzgbn2;
        zze = zzgbn2 = new zzgbn();
        zzgga.zzay(zzgbn.class, (zzgga)zzgbn2);
    }

    private zzgbn() {
    }

    public static zzgbn zzc(zzgex zzgex2, zzgfm zzgfm2) throws zzggm {
        return (zzgbn)zzgga.zzaI((zzgga)zze, (zzgex)zzgex2, (zzgfm)zzgfm2);
    }

    public static zzgbn zzd() {
        return zze;
    }

    static /* synthetic */ zzgbn zze() {
        return zze;
    }

    public final String zza() {
        return this.zzb;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n == 2) return zzgbn.zzaz((zzghi)zze, (String)"\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0208", (Object[])new Object[]{"zzb"});
        if (n == 3) return new zzgbn();
        if (n == 4) return new zzgbm(null);
        if (n == 5) return zze;
        return null;
    }
}
