/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfzl
 *  com.google.android.gms.internal.ads.zzgau
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfzl;
import com.google.android.gms.internal.ads.zzgau;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzfzm
extends zzgga<zzfzm, zzfzl>
implements zzghj {
    private static final zzfzm zze;
    private zzgau zzb;

    static {
        zzfzm zzfzm2;
        zze = zzfzm2 = new zzfzm();
        zzgga.zzay(zzfzm.class, (zzgga)zzfzm2);
    }

    private zzfzm() {
    }

    public static zzfzl zzc() {
        return (zzfzl)zze.zzas();
    }

    public static zzfzm zzd() {
        return zze;
    }

    static /* synthetic */ zzfzm zze() {
        return zze;
    }

    static /* synthetic */ void zzf(zzfzm zzfzm2, zzgau zzgau2) {
        zzgau2.getClass();
        zzfzm2.zzb = zzgau2;
    }

    public final zzgau zza() {
        zzgau zzgau2;
        zzgau zzgau3 = zzgau2 = this.zzb;
        if (zzgau2 != null) return zzgau3;
        zzgau3 = zzgau.zze();
        return zzgau3;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n == 2) return zzfzm.zzaz((zzghi)zze, (String)"\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0000\u0000\u0002\t", (Object[])new Object[]{"zzb"});
        if (n == 3) return new zzfzm();
        if (n == 4) return new zzfzl(null);
        if (n == 5) return zze;
        return null;
    }
}
