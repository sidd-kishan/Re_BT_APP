/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 *  com.google.android.gms.internal.ads.zzgjl
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;
import com.google.android.gms.internal.ads.zzgjl;

public final class zzgjm
extends zzgga<zzgjm, zzgjl>
implements zzghj {
    private static final zzgjm zzh;
    private int zzb;
    private zzgex zze;
    private zzgex zzf;
    private byte zzg = (byte)2;

    static {
        zzgjm zzgjm2;
        zzh = zzgjm2 = new zzgjm();
        zzgga.zzay(zzgjm.class, (zzgga)zzgjm2);
    }

    private zzgjm() {
        this.zze = zzgex.zzb;
        this.zzf = zzgex.zzb;
    }

    public static zzgjl zza() {
        return (zzgjl)zzh.zzas();
    }

    static /* synthetic */ zzgjm zzc() {
        return zzh;
    }

    static /* synthetic */ void zzd(zzgjm zzgjm2, zzgex zzgex2) {
        zzgjm2.zzb |= 1;
        zzgjm2.zze = zzgex2;
    }

    static /* synthetic */ void zze(zzgjm zzgjm2, zzgex zzgex2) {
        zzgjm2.zzb |= 2;
        zzgjm2.zzf = zzgex2;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return this.zzg;
        byte by = 1;
        if (n == 2) {
            return zzgjm.zzaz((zzghi)zzh, (String)"\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001\u150a\u0000\u0002\u100a\u0001", (Object[])new Object[]{"zzb", "zze", "zzf"});
        }
        if (n == 3) return new zzgjm();
        if (n == 4) return new zzgjl(null);
        if (n == 5) return zzh;
        if (object == null) {
            by = 0;
        }
        this.zzg = by;
        return null;
    }
}
