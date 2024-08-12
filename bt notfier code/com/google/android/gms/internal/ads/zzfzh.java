/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfzg
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzgfm
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzggm
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfzg;
import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzgfm;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzggm;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzfzh
extends zzgga<zzfzh, zzfzg>
implements zzghj {
    private static final zzfzh zzb;

    static {
        zzfzh zzfzh2;
        zzb = zzfzh2 = new zzfzh();
        zzgga.zzay(zzfzh.class, (zzgga)zzfzh2);
    }

    private zzfzh() {
    }

    public static zzfzh zza(zzgex zzgex2, zzgfm zzgfm2) throws zzggm {
        return (zzfzh)zzgga.zzaI((zzgga)zzb, (zzgex)zzgex2, (zzgfm)zzgfm2);
    }

    public static zzfzh zzc() {
        return zzb;
    }

    static /* synthetic */ zzfzh zzd() {
        return zzb;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n == 2) return zzfzh.zzaz((zzghi)zzb, (String)"\u0000\u0000", null);
        if (n == 3) return new zzfzh();
        if (n == 4) return new zzfzg(null);
        if (n == 5) return zzb;
        return null;
    }
}
