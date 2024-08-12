/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 *  com.google.android.gms.internal.ads.zzgjv
 *  com.google.android.gms.internal.ads.zzgjw
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;
import com.google.android.gms.internal.ads.zzgjv;
import com.google.android.gms.internal.ads.zzgjw;

public final class zzgjx
extends zzgga<zzgjx, zzgjv>
implements zzghj {
    private static final zzgjx zzh;
    private int zzb;
    private int zze;
    private String zzf = "";
    private zzgex zzg = zzgex.zzb;

    static {
        zzgjx zzgjx2;
        zzh = zzgjx2 = new zzgjx();
        zzgga.zzay(zzgjx.class, (zzgga)zzgjx2);
    }

    private zzgjx() {
    }

    public static zzgjv zza() {
        return (zzgjv)zzh.zzas();
    }

    static /* synthetic */ zzgjx zzc() {
        return zzh;
    }

    static /* synthetic */ void zzd(zzgjx zzgjx2, String string) {
        zzgjx2.zzb |= 2;
        zzgjx2.zzf = "image/png";
    }

    static /* synthetic */ void zze(zzgjx zzgjx2, zzgex zzgex2) {
        zzgex2.getClass();
        zzgjx2.zzb |= 4;
        zzgjx2.zzg = zzgex2;
    }

    static /* synthetic */ void zzf(zzgjx zzgjx2, int n) {
        zzgjx2.zze = 1;
        zzgjx2.zzb = 1 | zzgjx2.zzb;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n != 2) {
            if (n == 3) return new zzgjx();
            if (n == 4) return new zzgjv(null);
            if (n == 5) return zzh;
            return null;
        }
        object = zzgjw.zza;
        return zzgjx.zzaz((zzghi)zzh, (String)"\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u100c\u0000\u0002\u1008\u0001\u0003\u100a\u0002", (Object[])new Object[]{"zzb", "zze", object, "zzf", "zzg"});
    }
}
