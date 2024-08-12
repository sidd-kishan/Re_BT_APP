/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgbe
 *  com.google.android.gms.internal.ads.zzgbg
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzggj
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgbe;
import com.google.android.gms.internal.ads.zzgbg;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzggj;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzgbh
extends zzgga<zzgbh, zzgbe>
implements zzghj {
    private static final zzgbh zzf;
    private int zzb;
    private zzggj<zzgbg> zze = zzgbh.zzaE();

    static {
        zzgbh zzgbh2;
        zzf = zzgbh2 = new zzgbh();
        zzgga.zzay(zzgbh.class, (zzgga)zzgbh2);
    }

    private zzgbh() {
    }

    public static zzgbe zza() {
        return (zzgbe)zzf.zzas();
    }

    static /* synthetic */ zzgbh zzc() {
        return zzf;
    }

    static /* synthetic */ void zzd(zzgbh zzgbh2, int n) {
        zzgbh2.zzb = n;
    }

    static /* synthetic */ void zze(zzgbh zzgbh2, zzgbg zzgbg2) {
        zzgbg2.getClass();
        zzggj<zzgbg> zzggj2 = zzgbh2.zze;
        if (!zzggj2.zza()) {
            zzgbh2.zze = zzgga.zzaF(zzggj2);
        }
        zzgbh2.zze.add((Object)zzgbg2);
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n == 2) return zzgbh.zzaz((zzghi)zzf, (String)"\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", (Object[])new Object[]{"zzb", "zze", zzgbg.class});
        if (n == 3) return new zzgbh();
        if (n == 4) return new zzgbe(null);
        if (n == 5) return zzf;
        return null;
    }
}
