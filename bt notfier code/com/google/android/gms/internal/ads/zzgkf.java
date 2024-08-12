/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 *  com.google.android.gms.internal.ads.zzgke
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;
import com.google.android.gms.internal.ads.zzgke;

public final class zzgkf
extends zzgga<zzgkf, zzgke>
implements zzghj {
    private static final zzgkf zzh;
    private int zzb;
    private String zze = "";
    private long zzf;
    private boolean zzg;

    static {
        zzgkf zzgkf2;
        zzh = zzgkf2 = new zzgkf();
        zzgga.zzay(zzgkf.class, (zzgga)zzgkf2);
    }

    private zzgkf() {
    }

    public static zzgke zza() {
        return (zzgke)zzh.zzas();
    }

    static /* synthetic */ zzgkf zzc() {
        return zzh;
    }

    static /* synthetic */ void zzd(zzgkf zzgkf2, String string) {
        zzgkf2.zzb |= 1;
        zzgkf2.zze = string;
    }

    static /* synthetic */ void zze(zzgkf zzgkf2, long l) {
        zzgkf2.zzb |= 2;
        zzgkf2.zzf = l;
    }

    static /* synthetic */ void zzf(zzgkf zzgkf2, boolean bl) {
        zzgkf2.zzb |= 4;
        zzgkf2.zzg = bl;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n == 2) return zzgkf.zzaz((zzghi)zzh, (String)"\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u1008\u0000\u0002\u1002\u0001\u0003\u1007\u0002", (Object[])new Object[]{"zzb", "zze", "zzf", "zzg"});
        if (n == 3) return new zzgkf();
        if (n == 4) return new zzgke(null);
        if (n == 5) return zzh;
        return null;
    }
}
