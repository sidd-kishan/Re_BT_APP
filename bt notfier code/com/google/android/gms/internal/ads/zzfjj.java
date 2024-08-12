/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfjf
 *  com.google.android.gms.internal.ads.zzfjh
 *  com.google.android.gms.internal.ads.zzfji
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfjf;
import com.google.android.gms.internal.ads.zzfjh;
import com.google.android.gms.internal.ads.zzfji;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzfjj
extends zzgga<zzfjj, zzfjh>
implements zzghj {
    private static final zzfjj zzi;
    private int zzb;
    private int zze;
    private String zzf = "";
    private String zzg = "";
    private zzfjf zzh;

    static {
        zzfjj zzfjj2;
        zzi = zzfjj2 = new zzfjj();
        zzgga.zzay(zzfjj.class, (zzgga)zzfjj2);
    }

    private zzfjj() {
    }

    public static zzfjh zza() {
        return (zzfjh)zzi.zzas();
    }

    static /* synthetic */ zzfjj zzc() {
        return zzi;
    }

    static /* synthetic */ void zzd(zzfjj zzfjj2, String string) {
        string.getClass();
        zzfjj2.zzb |= 2;
        zzfjj2.zzf = string;
    }

    static /* synthetic */ void zze(zzfjj zzfjj2, zzfjf zzfjf2) {
        zzfjf2.getClass();
        zzfjj2.zzh = zzfjf2;
        zzfjj2.zzb |= 8;
    }

    static /* synthetic */ void zzf(zzfjj zzfjj2, int n) {
        zzfjj2.zze = 1;
        zzfjj2.zzb = 1 | zzfjj2.zzb;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n != 2) {
            if (n == 3) return new zzfjj();
            if (n == 4) return new zzfjh(null);
            if (n == 5) return zzi;
            return null;
        }
        object = zzfji.zza;
        return zzfjj.zzaz((zzghi)zzi, (String)"\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u100c\u0000\u0002\u1008\u0001\u0003\u1008\u0002\u0004\u1009\u0003", (Object[])new Object[]{"zzb", "zze", object, "zzf", "zzg", "zzh"});
    }
}
