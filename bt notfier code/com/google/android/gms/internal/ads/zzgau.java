/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgat
 *  com.google.android.gms.internal.ads.zzgbv
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgat;
import com.google.android.gms.internal.ads.zzgbv;
import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzgau
extends zzgga<zzgau, zzgat>
implements zzghj {
    private static final zzgau zzg;
    private String zzb = "";
    private zzgex zze = zzgex.zzb;
    private int zzf;

    static {
        zzgau zzgau2;
        zzg = zzgau2 = new zzgau();
        zzgga.zzay(zzgau.class, (zzgga)zzgau2);
    }

    private zzgau() {
    }

    public static zzgat zzd() {
        return (zzgat)zzg.zzas();
    }

    public static zzgau zze() {
        return zzg;
    }

    static /* synthetic */ zzgau zzf() {
        return zzg;
    }

    static /* synthetic */ void zzg(zzgau zzgau2, String string) {
        string.getClass();
        zzgau2.zzb = string;
    }

    static /* synthetic */ void zzh(zzgau zzgau2, zzgex zzgex2) {
        zzgau2.zze = zzgex2;
    }

    static /* synthetic */ void zzj(zzgau zzgau2, int n) {
        zzgau2.zzf = zzgbv.zza((int)n);
    }

    public final String zza() {
        return this.zzb;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n == 2) return zzgau.zzaz((zzghi)zzg, (String)"\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0208\u0002\n\u0003\f", (Object[])new Object[]{"zzb", "zze", "zzf"});
        if (n == 3) return new zzgau();
        if (n == 4) return new zzgat(null);
        if (n == 5) return zzg;
        return null;
    }

    public final zzgex zzc() {
        return this.zze;
    }

    public final int zzi() {
        int n;
        int n2 = n = zzgbv.zzb((int)this.zzf);
        if (n != 0) return n2;
        n2 = 1;
        return n2;
    }
}
