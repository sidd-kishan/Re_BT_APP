/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbam
 *  com.google.android.gms.internal.ads.zzbbe
 *  com.google.android.gms.internal.ads.zzbbx
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbam;
import com.google.android.gms.internal.ads.zzbbe;
import com.google.android.gms.internal.ads.zzbbx;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzbbf
extends zzgga<zzbbf, zzbbe>
implements zzghj {
    private static final zzbbf zzg;
    private int zzb;
    private int zze;
    private zzbbx zzf;

    static {
        zzbbf zzbbf2;
        zzg = zzbbf2 = new zzbbf();
        zzgga.zzay(zzbbf.class, (zzgga)zzbbf2);
    }

    private zzbbf() {
    }

    static /* synthetic */ zzbbf zza() {
        return zzg;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n != 2) {
            if (n == 3) return new zzbbf();
            if (n == 4) return new zzbbe(null);
            if (n == 5) return zzg;
            return null;
        }
        object = zzbam.zza;
        return zzbbf.zzaz((zzghi)zzg, (String)"\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u100c\u0000\u0002\u1009\u0001", (Object[])new Object[]{"zzb", "zze", object, "zzf"});
    }
}
