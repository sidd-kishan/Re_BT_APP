/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzazm
 *  com.google.android.gms.internal.ads.zzazp
 *  com.google.android.gms.internal.ads.zzazr
 *  com.google.android.gms.internal.ads.zzazt
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzazm;
import com.google.android.gms.internal.ads.zzazp;
import com.google.android.gms.internal.ads.zzazr;
import com.google.android.gms.internal.ads.zzazt;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzazn
extends zzgga<zzazn, zzazm>
implements zzghj {
    private static final zzazn zzh;
    private int zzb;
    private int zze;
    private zzazr zzf;
    private zzazt zzg;

    static {
        zzazn zzazn2;
        zzh = zzazn2 = new zzazn();
        zzgga.zzay(zzazn.class, (zzgga)zzazn2);
    }

    private zzazn() {
    }

    public static zzazm zza() {
        return (zzazm)zzh.zzas();
    }

    static /* synthetic */ zzazn zzc() {
        return zzh;
    }

    static /* synthetic */ void zzd(zzazn zzazn2, zzazr zzazr2) {
        zzazr2.getClass();
        zzazn2.zzf = zzazr2;
        zzazn2.zzb |= 2;
    }

    static /* synthetic */ void zze(zzazn zzazn2, zzazt zzazt2) {
        zzazt2.getClass();
        zzazn2.zzg = zzazt2;
        zzazn2.zzb |= 4;
    }

    static /* synthetic */ void zzf(zzazn zzazn2, int n) {
        zzazn2.zze = 1;
        zzazn2.zzb = 1 | zzazn2.zzb;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n != 2) {
            if (n == 3) return new zzazn();
            if (n == 4) return new zzazm(null);
            if (n == 5) return zzh;
            return null;
        }
        object = zzazp.zza;
        return zzazn.zzaz((zzghi)zzh, (String)"\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u100c\u0000\u0002\u1009\u0001\u0003\u1009\u0002", (Object[])new Object[]{"zzb", "zze", object, "zzf", "zzg"});
    }
}
