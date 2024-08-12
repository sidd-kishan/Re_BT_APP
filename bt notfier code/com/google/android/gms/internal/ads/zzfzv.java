/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfzu
 *  com.google.android.gms.internal.ads.zzfzy
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzgfm
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzggm
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfzu;
import com.google.android.gms.internal.ads.zzfzy;
import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzgfm;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzggm;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzfzv
extends zzgga<zzfzv, zzfzu>
implements zzghj {
    private static final zzfzv zzg;
    private int zzb;
    private zzfzy zze;
    private zzgex zzf = zzgex.zzb;

    static {
        zzfzv zzfzv2;
        zzg = zzfzv2 = new zzfzv();
        zzgga.zzay(zzfzv.class, (zzgga)zzfzv2);
    }

    private zzfzv() {
    }

    public static zzfzv zze(zzgex zzgex2, zzgfm zzgfm2) throws zzggm {
        return (zzfzv)zzgga.zzaI((zzgga)zzg, (zzgex)zzgex2, (zzgfm)zzgfm2);
    }

    public static zzfzu zzf() {
        return (zzfzu)zzg.zzas();
    }

    static /* synthetic */ zzfzv zzg() {
        return zzg;
    }

    static /* synthetic */ void zzh(zzfzv zzfzv2, int n) {
        zzfzv2.zzb = 0;
    }

    static /* synthetic */ void zzi(zzfzv zzfzv2, zzfzy zzfzy2) {
        zzfzy2.getClass();
        zzfzv2.zze = zzfzy2;
    }

    static /* synthetic */ void zzj(zzfzv zzfzv2, zzgex zzgex2) {
        zzfzv2.zzf = zzgex2;
    }

    public final int zza() {
        return this.zzb;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n == 2) return zzfzv.zzaz((zzghi)zzg, (String)"\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", (Object[])new Object[]{"zzb", "zze", "zzf"});
        if (n == 3) return new zzfzv();
        if (n == 4) return new zzfzu(null);
        if (n == 5) return zzg;
        return null;
    }

    public final zzfzy zzc() {
        zzfzy zzfzy2;
        zzfzy zzfzy3 = zzfzy2 = this.zze;
        if (zzfzy2 != null) return zzfzy3;
        zzfzy3 = zzfzy.zzh();
        return zzfzy3;
    }

    public final zzgex zzd() {
        return this.zzf;
    }
}
