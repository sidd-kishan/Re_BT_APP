/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfzs
 *  com.google.android.gms.internal.ads.zzfzx
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzgfm
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzggm
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfzs;
import com.google.android.gms.internal.ads.zzfzx;
import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzgfm;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzggm;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzfzy
extends zzgga<zzfzy, zzfzx>
implements zzghj {
    private static final zzfzy zzh;
    private int zzb;
    private zzfzs zze;
    private zzgex zzf = zzgex.zzb;
    private zzgex zzg = zzgex.zzb;

    static {
        zzfzy zzfzy2;
        zzh = zzfzy2 = new zzfzy();
        zzgga.zzay(zzfzy.class, (zzgga)zzfzy2);
    }

    private zzfzy() {
    }

    public static zzfzy zzf(zzgex zzgex2, zzgfm zzgfm2) throws zzggm {
        return (zzfzy)zzgga.zzaI((zzgga)zzh, (zzgex)zzgex2, (zzgfm)zzgfm2);
    }

    public static zzfzx zzg() {
        return (zzfzx)zzh.zzas();
    }

    public static zzfzy zzh() {
        return zzh;
    }

    static /* synthetic */ zzfzy zzi() {
        return zzh;
    }

    static /* synthetic */ void zzj(zzfzy zzfzy2, int n) {
        zzfzy2.zzb = 0;
    }

    static /* synthetic */ void zzk(zzfzy zzfzy2, zzfzs zzfzs2) {
        zzfzs2.getClass();
        zzfzy2.zze = zzfzs2;
    }

    static /* synthetic */ void zzl(zzfzy zzfzy2, zzgex zzgex2) {
        zzfzy2.zzf = zzgex2;
    }

    static /* synthetic */ void zzm(zzfzy zzfzy2, zzgex zzgex2) {
        zzfzy2.zzg = zzgex2;
    }

    public final int zza() {
        return this.zzb;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n == 2) return zzfzy.zzaz((zzghi)zzh, (String)"\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n\u0004\n", (Object[])new Object[]{"zzb", "zze", "zzf", "zzg"});
        if (n == 3) return new zzfzy();
        if (n == 4) return new zzfzx(null);
        if (n == 5) return zzh;
        return null;
    }

    public final zzfzs zzc() {
        zzfzs zzfzs2;
        zzfzs zzfzs3 = zzfzs2 = this.zze;
        if (zzfzs2 != null) return zzfzs3;
        zzfzs3 = zzfzs.zze();
        return zzfzs3;
    }

    public final zzgex zzd() {
        return this.zzf;
    }

    public final zzgex zze() {
        return this.zzg;
    }
}
