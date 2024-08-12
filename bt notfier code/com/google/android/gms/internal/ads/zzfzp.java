/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfzo
 *  com.google.android.gms.internal.ads.zzfzs
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzgfm
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzggm
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfzo;
import com.google.android.gms.internal.ads.zzfzs;
import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzgfm;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzggm;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzfzp
extends zzgga<zzfzp, zzfzo>
implements zzghj {
    private static final zzfzp zze;
    private zzfzs zzb;

    static {
        zzfzp zzfzp2;
        zze = zzfzp2 = new zzfzp();
        zzgga.zzay(zzfzp.class, (zzgga)zzfzp2);
    }

    private zzfzp() {
    }

    public static zzfzp zzc(zzgex zzgex2, zzgfm zzgfm2) throws zzggm {
        return (zzfzp)zzgga.zzaI((zzgga)zze, (zzgex)zzgex2, (zzgfm)zzgfm2);
    }

    public static zzfzo zzd() {
        return (zzfzo)zze.zzas();
    }

    static /* synthetic */ zzfzp zze() {
        return zze;
    }

    static /* synthetic */ void zzf(zzfzp zzfzp2, zzfzs zzfzs2) {
        zzfzs2.getClass();
        zzfzp2.zzb = zzfzs2;
    }

    public final zzfzs zza() {
        zzfzs zzfzs2;
        zzfzs zzfzs3 = zzfzs2 = this.zzb;
        if (zzfzs2 != null) return zzfzs3;
        zzfzs3 = zzfzs.zze();
        return zzfzs3;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n == 2) return zzfzp.zzaz((zzghi)zze, (String)"\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", (Object[])new Object[]{"zzb"});
        if (n == 3) return new zzfzp();
        if (n == 4) return new zzfzo(null);
        if (n == 5) return zze;
        return null;
    }
}
