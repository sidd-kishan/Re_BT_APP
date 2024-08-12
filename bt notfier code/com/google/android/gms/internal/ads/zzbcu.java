/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbct
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbct;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzbcu
extends zzgga<zzbcu, zzbct>
implements zzghj {
    private static final zzbcu zzg;
    private int zzb;
    private boolean zze;
    private int zzf;

    static {
        zzbcu zzbcu2;
        zzg = zzbcu2 = new zzbcu();
        zzgga.zzay(zzbcu.class, (zzgga)zzbcu2);
    }

    private zzbcu() {
    }

    public static zzbct zzc() {
        return (zzbct)zzg.zzas();
    }

    static /* synthetic */ zzbcu zzd() {
        return zzg;
    }

    static /* synthetic */ void zze(zzbcu zzbcu2, boolean bl) {
        zzbcu2.zzb |= 1;
        zzbcu2.zze = bl;
    }

    static /* synthetic */ void zzf(zzbcu zzbcu2, int n) {
        zzbcu2.zzb |= 2;
        zzbcu2.zzf = n;
    }

    public final boolean zza() {
        return this.zze;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n == 2) return zzbcu.zzaz((zzghi)zzg, (String)"\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u1007\u0000\u0002\u1004\u0001", (Object[])new Object[]{"zzb", "zze", "zzf"});
        if (n == 3) return new zzbcu();
        if (n == 4) return new zzbct(null);
        if (n == 5) return zzg;
        return null;
    }
}
