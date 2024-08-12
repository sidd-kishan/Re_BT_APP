/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfyu
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzgfm
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzggm
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfyu;
import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzgfm;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzggm;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzfyv
extends zzgga<zzfyv, zzfyu>
implements zzghj {
    private static final zzfyv zzf;
    private int zzb;
    private int zze;

    static {
        zzfyv zzfyv2;
        zzf = zzfyv2 = new zzfyv();
        zzgga.zzay(zzfyv.class, (zzgga)zzfyv2);
    }

    private zzfyv() {
    }

    public static zzfyv zzc(zzgex zzgex2, zzgfm zzgfm2) throws zzggm {
        return (zzfyv)zzgga.zzaI((zzgga)zzf, (zzgex)zzgex2, (zzgfm)zzgfm2);
    }

    public static zzfyu zzd() {
        return (zzfyu)zzf.zzas();
    }

    static /* synthetic */ zzfyv zze() {
        return zzf;
    }

    static /* synthetic */ void zzf(zzfyv zzfyv2, int n) {
        zzfyv2.zzb = n;
    }

    public final int zza() {
        return this.zzb;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n == 2) return zzfyv.zzaz((zzghi)zzf, (String)"\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\u000b", (Object[])new Object[]{"zze", "zzb"});
        if (n == 3) return new zzfyv();
        if (n == 4) return new zzfyu(null);
        if (n == 5) return zzf;
        return null;
    }
}
