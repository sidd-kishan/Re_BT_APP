/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 *  com.google.android.gms.internal.ads.zzyl
 *  com.google.android.gms.internal.ads.zzyq
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;
import com.google.android.gms.internal.ads.zzyl;
import com.google.android.gms.internal.ads.zzyq;

public final class zzym
extends zzgga<zzym, zzyl>
implements zzghj {
    private static final zzym zzf;
    private int zzb;
    private int zze;

    static {
        zzym zzym2;
        zzf = zzym2 = new zzym();
        zzgga.zzay(zzym.class, (zzgga)zzym2);
    }

    private zzym() {
    }

    static /* synthetic */ zzym zza() {
        return zzf;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n != 2) {
            if (n == 3) return new zzym();
            if (n == 4) return new zzyl(null);
            if (n == 5) return zzf;
            return null;
        }
        object = zzyq.zza;
        return zzym.zzaz((zzghi)zzf, (String)"\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u100c\u0000", (Object[])new Object[]{"zzb", "zze", object});
    }
}
