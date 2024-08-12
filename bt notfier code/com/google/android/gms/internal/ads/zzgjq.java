/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzggj
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 *  com.google.android.gms.internal.ads.zzgjm
 *  com.google.android.gms.internal.ads.zzgjn
 *  com.google.android.gms.internal.ads.zzgjp
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzggj;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;
import com.google.android.gms.internal.ads.zzgjm;
import com.google.android.gms.internal.ads.zzgjn;
import com.google.android.gms.internal.ads.zzgjp;

public final class zzgjq
extends zzgga<zzgjq, zzgjn>
implements zzghj {
    private static final zzgjq zzk;
    private int zzb;
    private zzgjp zze;
    private zzggj<zzgjm> zzf;
    private zzgex zzg;
    private zzgex zzh;
    private int zzi;
    private byte zzj = (byte)2;

    static {
        zzgjq zzgjq2;
        zzk = zzgjq2 = new zzgjq();
        zzgga.zzay(zzgjq.class, (zzgga)zzgjq2);
    }

    private zzgjq() {
        this.zzf = zzgjq.zzaE();
        this.zzg = zzgex.zzb;
        this.zzh = zzgex.zzb;
    }

    public static zzgjn zza() {
        return (zzgjn)zzk.zzas();
    }

    static /* synthetic */ zzgjq zzc() {
        return zzk;
    }

    static /* synthetic */ void zzd(zzgjq zzgjq2, zzgjm zzgjm2) {
        zzgjm2.getClass();
        zzggj<zzgjm> zzggj2 = zzgjq2.zzf;
        if (!zzggj2.zza()) {
            zzgjq2.zzf = zzgga.zzaF(zzggj2);
        }
        zzgjq2.zzf.add((Object)zzgjm2);
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return this.zzj;
        byte by = 1;
        if (n == 2) {
            return zzgjq.zzaz((zzghi)zzk, (String)"\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0001\u0001\u1009\u0000\u0002\u041b\u0003\u100a\u0001\u0004\u100a\u0002\u0005\u1004\u0003", (Object[])new Object[]{"zzb", "zze", "zzf", zzgjm.class, "zzg", "zzh", "zzi"});
        }
        if (n == 3) return new zzgjq();
        if (n == 4) return new zzgjn(null);
        if (n == 5) return zzk;
        if (object == null) {
            by = 0;
        }
        this.zzj = by;
        return null;
    }
}
