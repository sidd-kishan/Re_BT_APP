/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgbf
 *  com.google.android.gms.internal.ads.zzgbv
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgbf;
import com.google.android.gms.internal.ads.zzgbv;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzgbg
extends zzgga<zzgbg, zzgbf>
implements zzghj {
    private static final zzgbg zzh;
    private String zzb = "";
    private int zze;
    private int zzf;
    private int zzg;

    static {
        zzgbg zzgbg2;
        zzh = zzgbg2 = new zzgbg();
        zzgga.zzay(zzgbg.class, (zzgga)zzgbg2);
    }

    private zzgbg() {
    }

    public static zzgbf zza() {
        return (zzgbf)zzh.zzas();
    }

    static /* synthetic */ zzgbg zzc() {
        return zzh;
    }

    static /* synthetic */ void zzd(zzgbg zzgbg2, String string) {
        string.getClass();
        zzgbg2.zzb = string;
    }

    static /* synthetic */ void zze(zzgbg zzgbg2, int n) {
        zzgbg2.zzf = n;
    }

    static /* synthetic */ void zzf(zzgbg zzgbg2, int n) {
        if (n == 1) throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        zzgbg2.zze = n - 2;
    }

    static /* synthetic */ void zzg(zzgbg zzgbg2, int n) {
        zzgbg2.zzg = zzgbv.zza((int)n);
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n == 2) return zzgbg.zzaz((zzghi)zzh, (String)"\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0208\u0002\f\u0003\u000b\u0004\f", (Object[])new Object[]{"zzb", "zze", "zzf", "zzg"});
        if (n == 3) return new zzgbg();
        if (n == 4) return new zzgbf(null);
        if (n == 5) return zzh;
        return null;
    }
}
