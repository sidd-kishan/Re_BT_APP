/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfyf
 *  com.google.android.gms.internal.ads.zzfyj
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzgfm
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzggm
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfyf;
import com.google.android.gms.internal.ads.zzfyj;
import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzgfm;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzggm;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzfyg
extends zzgga<zzfyg, zzfyf>
implements zzghj {
    private static final zzfyg zzf;
    private zzfyj zzb;
    private int zze;

    static {
        zzfyg zzfyg2;
        zzf = zzfyg2 = new zzfyg();
        zzgga.zzay(zzfyg.class, (zzgga)zzfyg2);
    }

    private zzfyg() {
    }

    public static zzfyg zzd(zzgex zzgex2, zzgfm zzgfm2) throws zzggm {
        return (zzfyg)zzgga.zzaI((zzgga)zzf, (zzgex)zzgex2, (zzgfm)zzgfm2);
    }

    public static zzfyf zze() {
        return (zzfyf)zzf.zzas();
    }

    static /* synthetic */ zzfyg zzf() {
        return zzf;
    }

    static /* synthetic */ void zzg(zzfyg zzfyg2, zzfyj zzfyj2) {
        zzfyj2.getClass();
        zzfyg2.zzb = zzfyj2;
    }

    static /* synthetic */ void zzh(zzfyg zzfyg2, int n) {
        zzfyg2.zze = n;
    }

    public final zzfyj zza() {
        zzfyj zzfyj2;
        zzfyj zzfyj3 = zzfyj2 = this.zzb;
        if (zzfyj2 != null) return zzfyj3;
        zzfyj3 = zzfyj.zzd();
        return zzfyj3;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n == 2) return zzfyg.zzaz((zzghi)zzf, (String)"\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u000b", (Object[])new Object[]{"zzb", "zze"});
        if (n == 3) return new zzfyg();
        if (n == 4) return new zzfyf(null);
        if (n == 5) return zzf;
        return null;
    }

    public final int zzc() {
        return this.zze;
    }
}
