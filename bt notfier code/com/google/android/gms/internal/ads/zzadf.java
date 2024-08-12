/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzade
 *  com.google.android.gms.internal.ads.zzadi
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzgfm
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzggm
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzade;
import com.google.android.gms.internal.ads.zzadi;
import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzgfm;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzggm;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzadf
extends zzgga<zzadf, zzade>
implements zzghj {
    private static final zzadf zzh;
    private int zzb;
    private zzadi zze;
    private zzgex zzf = zzgex.zzb;
    private zzgex zzg = zzgex.zzb;

    static {
        zzadf zzadf2;
        zzh = zzadf2 = new zzadf();
        zzgga.zzay(zzadf.class, (zzgga)zzadf2);
    }

    private zzadf() {
    }

    public static zzadf zze(zzgex zzgex2, zzgfm zzgfm2) throws zzggm {
        return (zzadf)zzgga.zzaI((zzgga)zzh, (zzgex)zzgex2, (zzgfm)zzgfm2);
    }

    static /* synthetic */ zzadf zzf() {
        return zzh;
    }

    public final zzadi zza() {
        zzadi zzadi2;
        zzadi zzadi3 = zzadi2 = this.zze;
        if (zzadi2 != null) return zzadi3;
        zzadi3 = zzadi.zzj();
        return zzadi3;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n == 2) return zzadf.zzaz((zzghi)zzh, (String)"\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u1009\u0000\u0002\u100a\u0001\u0003\u100a\u0002", (Object[])new Object[]{"zzb", "zze", "zzf", "zzg"});
        if (n == 3) return new zzadf();
        if (n == 4) return new zzade(null);
        if (n == 5) return zzh;
        return null;
    }

    public final zzgex zzc() {
        return this.zzf;
    }

    public final zzgex zzd() {
        return this.zzg;
    }
}
