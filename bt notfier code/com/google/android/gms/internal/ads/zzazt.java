/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzazs
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzazs;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzazt
extends zzgga<zzazt, zzazs>
implements zzghj {
    private static final zzazt zzh;
    private int zzb;
    private boolean zze;
    private boolean zzf;
    private int zzg;

    static {
        zzazt zzazt2;
        zzh = zzazt2 = new zzazt();
        zzgga.zzay(zzazt.class, (zzgga)zzazt2);
    }

    private zzazt() {
    }

    public static zzazs zza() {
        return (zzazs)zzh.zzas();
    }

    static /* synthetic */ zzazt zzc() {
        return zzh;
    }

    static /* synthetic */ void zzd(zzazt zzazt2, boolean bl) {
        zzazt2.zzb |= 1;
        zzazt2.zze = bl;
    }

    static /* synthetic */ void zze(zzazt zzazt2, boolean bl) {
        zzazt2.zzb |= 2;
        zzazt2.zzf = bl;
    }

    static /* synthetic */ void zzf(zzazt zzazt2, int n) {
        zzazt2.zzb |= 4;
        zzazt2.zzg = n;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n == 2) return zzazt.zzaz((zzghi)zzh, (String)"\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u1007\u0000\u0002\u1007\u0001\u0003\u100b\u0002", (Object[])new Object[]{"zzb", "zze", "zzf", "zzg"});
        if (n == 3) return new zzazt();
        if (n == 4) return new zzazs(null);
        if (n == 5) return zzh;
        return null;
    }
}
