/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgcd
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzgfm
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzggm
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgcd;
import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzgfm;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzggm;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzgce
extends zzgga<zzgce, zzgcd>
implements zzghj {
    private static final zzgce zze;
    private int zzb;

    static {
        zzgce zzgce2;
        zze = zzgce2 = new zzgce();
        zzgga.zzay(zzgce.class, (zzgga)zzgce2);
    }

    private zzgce() {
    }

    public static zzgce zza(zzgex zzgex2, zzgfm zzgfm2) throws zzggm {
        return (zzgce)zzgga.zzaI((zzgga)zze, (zzgex)zzgex2, (zzgfm)zzgfm2);
    }

    public static zzgce zzc() {
        return zze;
    }

    static /* synthetic */ zzgce zzd() {
        return zze;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n == 2) return zzgce.zzaz((zzghi)zze, (String)"\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", (Object[])new Object[]{"zzb"});
        if (n == 3) return new zzgce();
        if (n == 4) return new zzgcd(null);
        if (n == 5) return zze;
        return null;
    }
}
