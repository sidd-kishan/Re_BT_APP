/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfyc
 *  com.google.android.gms.internal.ads.zzfyj
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzgfm
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzggm
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfyc;
import com.google.android.gms.internal.ads.zzfyj;
import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzgfm;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzggm;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzfyd
extends zzgga<zzfyd, zzfyc>
implements zzghj {
    private static final zzfyd zzg;
    private int zzb;
    private zzfyj zze;
    private zzgex zzf = zzgex.zzb;

    static {
        zzfyd zzfyd2;
        zzg = zzfyd2 = new zzfyd();
        zzgga.zzay(zzfyd.class, (zzgga)zzfyd2);
    }

    private zzfyd() {
    }

    public static zzfyd zze(zzgex zzgex2, zzgfm zzgfm2) throws zzggm {
        return (zzfyd)zzgga.zzaI((zzgga)zzg, (zzgex)zzgex2, (zzgfm)zzgfm2);
    }

    public static zzfyc zzf() {
        return (zzfyc)zzg.zzas();
    }

    static /* synthetic */ zzfyd zzg() {
        return zzg;
    }

    static /* synthetic */ void zzh(zzfyd zzfyd2, int n) {
        zzfyd2.zzb = 0;
    }

    static /* synthetic */ void zzi(zzfyd zzfyd2, zzfyj zzfyj2) {
        zzfyj2.getClass();
        zzfyd2.zze = zzfyj2;
    }

    static /* synthetic */ void zzj(zzfyd zzfyd2, zzgex zzgex2) {
        zzfyd2.zzf = zzgex2;
    }

    public final int zza() {
        return this.zzb;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n == 2) return zzfyd.zzaz((zzghi)zzg, (String)"\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", (Object[])new Object[]{"zzb", "zze", "zzf"});
        if (n == 3) return new zzfyd();
        if (n == 4) return new zzfyc(null);
        if (n == 5) return zzg;
        return null;
    }

    public final zzfyj zzc() {
        zzfyj zzfyj2;
        zzfyj zzfyj3 = zzfyj2 = this.zze;
        if (zzfyj2 != null) return zzfyj3;
        zzfyj3 = zzfyj.zzd();
        return zzfyj3;
    }

    public final zzgex zzd() {
        return this.zzf;
    }
}
