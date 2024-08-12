/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 *  com.google.android.gms.internal.ads.zzzj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;
import com.google.android.gms.internal.ads.zzzj;

public final class zzzk
extends zzgga<zzzk, zzzj>
implements zzghj {
    private static final zzzk zzf;
    private int zzb;
    private String zze = "";

    static {
        zzzk zzzk2;
        zzf = zzzk2 = new zzzk();
        zzgga.zzay(zzzk.class, (zzgga)zzzk2);
    }

    private zzzk() {
    }

    static /* synthetic */ zzzk zza() {
        return zzf;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n == 2) return zzzk.zzaz((zzghi)zzf, (String)"\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u1008\u0000", (Object[])new Object[]{"zzb", "zze"});
        if (n == 3) return new zzzk();
        if (n == 4) return new zzzj(null);
        if (n == 5) return zzf;
        return null;
    }
}
