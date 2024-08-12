/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 *  com.google.android.gms.internal.ads.zzyd
 *  com.google.android.gms.internal.ads.zzyf
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;
import com.google.android.gms.internal.ads.zzyd;
import com.google.android.gms.internal.ads.zzyf;

public final class zzye
extends zzgga<zzye, zzyd>
implements zzghj {
    private static final zzye zzf;
    private int zzb;
    private int zze = 2;

    static {
        zzye zzye2;
        zzf = zzye2 = new zzye();
        zzgga.zzay(zzye.class, (zzgga)zzye2);
    }

    private zzye() {
    }

    static /* synthetic */ zzye zza() {
        return zzf;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n != 2) {
            if (n == 3) return new zzye();
            if (n == 4) return new zzyd(null);
            if (n == 5) return zzf;
            return null;
        }
        object = zzyf.zza;
        return zzye.zzaz((zzghi)zzf, (String)"\u0001\u0001\u0000\u0001\u001b\u001b\u0001\u0000\u0000\u0000\u001b\u100c\u0000", (Object[])new Object[]{"zzb", "zze", object});
    }
}
