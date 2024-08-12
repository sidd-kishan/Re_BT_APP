/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzazq
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzazq;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzazr
extends zzgga<zzazr, zzazq>
implements zzghj {
    private static final zzazr zzg;
    private int zzb;
    private boolean zze;
    private int zzf;

    static {
        zzazr zzazr2;
        zzg = zzazr2 = new zzazr();
        zzgga.zzay(zzazr.class, (zzgga)zzazr2);
    }

    private zzazr() {
    }

    public static zzazq zza() {
        return (zzazq)zzg.zzas();
    }

    public static zzazr zzc() {
        return zzg;
    }

    static /* synthetic */ zzazr zzd() {
        return zzg;
    }

    static /* synthetic */ void zze(zzazr zzazr2, boolean bl) {
        zzazr2.zzb |= 1;
        zzazr2.zze = bl;
    }

    static /* synthetic */ void zzf(zzazr zzazr2, int n) {
        zzazr2.zzb |= 2;
        zzazr2.zzf = n;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n == 2) return zzazr.zzaz((zzghi)zzg, (String)"\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u1007\u0000\u0002\u100b\u0001", (Object[])new Object[]{"zzb", "zze", "zzf"});
        if (n == 3) return new zzazr();
        if (n == 4) return new zzazq(null);
        if (n == 5) return zzg;
        return null;
    }
}
