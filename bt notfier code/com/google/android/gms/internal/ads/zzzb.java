/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzggf
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 *  com.google.android.gms.internal.ads.zzza
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzggf;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;
import com.google.android.gms.internal.ads.zzza;

public final class zzzb
extends zzgga<zzzb, zzza>
implements zzghj {
    private static final zzzb zzj;
    private int zzb;
    private long zze;
    private int zzf;
    private boolean zzg;
    private zzggf zzh = zzzb.zzaB();
    private long zzi;

    static {
        zzzb zzzb2;
        zzj = zzzb2 = new zzzb();
        zzgga.zzay(zzzb.class, (zzgga)zzzb2);
    }

    private zzzb() {
    }

    static /* synthetic */ zzzb zza() {
        return zzj;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n == 2) return zzzb.zzaz((zzghi)zzj, (String)"\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u1002\u0000\u0002\u1004\u0001\u0003\u1007\u0002\u0004\u0016\u0005\u1003\u0003", (Object[])new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi"});
        if (n == 3) return new zzzb();
        if (n == 4) return new zzza(null);
        if (n == 5) return zzj;
        return null;
    }
}
