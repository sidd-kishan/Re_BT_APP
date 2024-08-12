/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 *  com.google.android.gms.internal.ads.zzyt
 *  com.google.android.gms.internal.ads.zzzf
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;
import com.google.android.gms.internal.ads.zzyt;
import com.google.android.gms.internal.ads.zzzf;

public final class zzyu
extends zzgga<zzyu, zzyt>
implements zzghj {
    private static final zzyu zzg;
    private int zzb;
    private long zze = -1L;
    private int zzf = 1000;

    static {
        zzyu zzyu2;
        zzg = zzyu2 = new zzyu();
        zzgga.zzay(zzyu.class, (zzgga)zzyu2);
    }

    private zzyu() {
    }

    static /* synthetic */ zzyu zza() {
        return zzg;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n != 2) {
            if (n == 3) return new zzyu();
            if (n == 4) return new zzyt(null);
            if (n == 5) return zzg;
            return null;
        }
        object = zzzf.zza;
        return zzyu.zzaz((zzghi)zzg, (String)"\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u1002\u0000\u0002\u100c\u0001", (Object[])new Object[]{"zzb", "zze", "zzf", object});
    }
}
