/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfyx
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzgfm
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzggm
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfyx;
import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzgfm;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzggm;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzfyy
extends zzgga<zzfyy, zzfyx>
implements zzghj {
    private static final zzfyy zzf;
    private int zzb;
    private zzgex zze = zzgex.zzb;

    static {
        zzfyy zzfyy2;
        zzf = zzfyy2 = new zzfyy();
        zzgga.zzay(zzfyy.class, (zzgga)zzfyy2);
    }

    private zzfyy() {
    }

    public static zzfyy zzd(zzgex zzgex2, zzgfm zzgfm2) throws zzggm {
        return (zzfyy)zzgga.zzaI((zzgga)zzf, (zzgex)zzgex2, (zzgfm)zzgfm2);
    }

    public static zzfyx zze() {
        return (zzfyx)zzf.zzas();
    }

    static /* synthetic */ zzfyy zzf() {
        return zzf;
    }

    static /* synthetic */ void zzg(zzfyy zzfyy2, int n) {
        zzfyy2.zzb = 0;
    }

    static /* synthetic */ void zzh(zzfyy zzfyy2, zzgex zzgex2) {
        zzfyy2.zze = zzgex2;
    }

    public final int zza() {
        return this.zzb;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n == 2) return zzfyy.zzaz((zzghi)zzf, (String)"\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\n", (Object[])new Object[]{"zzb", "zze"});
        if (n == 3) return new zzfyy();
        if (n == 4) return new zzfyx(null);
        if (n == 5) return zzf;
        return null;
    }

    public final zzgex zzc() {
        return this.zze;
    }
}
