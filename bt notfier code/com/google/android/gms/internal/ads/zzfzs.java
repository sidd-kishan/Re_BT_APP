/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfzj
 *  com.google.android.gms.internal.ads.zzfzm
 *  com.google.android.gms.internal.ads.zzfzr
 *  com.google.android.gms.internal.ads.zzgab
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfzj;
import com.google.android.gms.internal.ads.zzfzm;
import com.google.android.gms.internal.ads.zzfzr;
import com.google.android.gms.internal.ads.zzgab;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzfzs
extends zzgga<zzfzs, zzfzr>
implements zzghj {
    private static final zzfzs zzg;
    private zzgab zzb;
    private zzfzm zze;
    private int zzf;

    static {
        zzfzs zzfzs2;
        zzg = zzfzs2 = new zzfzs();
        zzgga.zzay(zzfzs.class, (zzgga)zzfzs2);
    }

    private zzfzs() {
    }

    public static zzfzr zzd() {
        return (zzfzr)zzg.zzas();
    }

    public static zzfzs zze() {
        return zzg;
    }

    static /* synthetic */ zzfzs zzf() {
        return zzg;
    }

    static /* synthetic */ void zzg(zzfzs zzfzs2, zzgab zzgab2) {
        zzgab2.getClass();
        zzfzs2.zzb = zzgab2;
    }

    static /* synthetic */ void zzh(zzfzs zzfzs2, zzfzm zzfzm2) {
        zzfzm2.getClass();
        zzfzs2.zze = zzfzm2;
    }

    static /* synthetic */ void zzj(zzfzs zzfzs2, int n) {
        zzfzs2.zzf = zzfzj.zza((int)n);
    }

    public final zzgab zza() {
        zzgab zzgab2;
        zzgab zzgab3 = zzgab2 = this.zzb;
        if (zzgab2 != null) return zzgab3;
        zzgab3 = zzgab.zzd();
        return zzgab3;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n == 2) return zzfzs.zzaz((zzghi)zzg, (String)"\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\t\u0003\f", (Object[])new Object[]{"zzb", "zze", "zzf"});
        if (n == 3) return new zzfzs();
        if (n == 4) return new zzfzr(null);
        if (n == 5) return zzg;
        return null;
    }

    public final zzfzm zzc() {
        zzfzm zzfzm2;
        zzfzm zzfzm3 = zzfzm2 = this.zze;
        if (zzfzm2 != null) return zzfzm3;
        zzfzm3 = zzfzm.zzd();
        return zzfzm3;
    }

    public final int zzi() {
        int n = this.zzf;
        int n2 = 3;
        if (n != 0) {
            if (n != 1) {
                n2 = n != 2 ? (n != 3 ? 0 : 5) : 4;
            }
        } else {
            n2 = 2;
        }
        if (n2 != 0) return n2;
        return 1;
    }
}
