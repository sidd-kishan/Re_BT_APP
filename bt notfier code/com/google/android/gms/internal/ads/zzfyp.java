/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfyo
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzgfm
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzggm
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfyo;
import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzgfm;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzggm;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzfyp
extends zzgga<zzfyp, zzfyo>
implements zzghj {
    private static final zzfyp zzf;
    private int zzb;
    private int zze;

    static {
        zzfyp zzfyp2;
        zzf = zzfyp2 = new zzfyp();
        zzgga.zzay(zzfyp.class, (zzgga)zzfyp2);
    }

    private zzfyp() {
    }

    public static zzfyp zzc(zzgex zzgex2, zzgfm zzgfm2) throws zzggm {
        return (zzfyp)zzgga.zzaI((zzgga)zzf, (zzgex)zzgex2, (zzgfm)zzgfm2);
    }

    public static zzfyo zzd() {
        return (zzfyo)zzf.zzas();
    }

    static /* synthetic */ zzfyp zze() {
        return zzf;
    }

    static /* synthetic */ void zzf(zzfyp zzfyp2, int n) {
        zzfyp2.zzb = n;
    }

    public final int zza() {
        return this.zzb;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n == 2) return zzfyp.zzaz((zzghi)zzf, (String)"\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002\u000b\u0003\u000b", (Object[])new Object[]{"zzb", "zze"});
        if (n == 3) return new zzfyp();
        if (n == 4) return new zzfyo(null);
        if (n == 5) return zzf;
        return null;
    }
}
