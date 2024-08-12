/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbbs
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbbs;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzbbt
extends zzgga<zzbbt, zzbbs>
implements zzghj {
    private static final zzbbt zzg;
    private int zzb;
    private int zze;
    private int zzf;

    static {
        zzbbt zzbbt2;
        zzg = zzbbt2 = new zzbbt();
        zzgga.zzay(zzbbt.class, (zzgga)zzbbt2);
    }

    private zzbbt() {
    }

    static /* synthetic */ zzbbt zza() {
        return zzg;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n == 2) return zzbbt.zzaz((zzghi)zzg, (String)"\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u1004\u0000\u0002\u1004\u0001", (Object[])new Object[]{"zzb", "zze", "zzf"});
        if (n == 3) return new zzbbt();
        if (n == 4) return new zzbbs(null);
        if (n == 5) return zzg;
        return null;
    }
}
