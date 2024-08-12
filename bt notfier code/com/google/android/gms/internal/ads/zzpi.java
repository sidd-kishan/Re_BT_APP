/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzni
 *  com.google.android.gms.internal.ads.zznk
 *  com.google.android.gms.internal.ads.zznl
 *  com.google.android.gms.internal.ads.zzoh
 *  com.google.android.gms.internal.ads.zzpf
 *  com.google.android.gms.internal.ads.zzpg
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzni;
import com.google.android.gms.internal.ads.zznk;
import com.google.android.gms.internal.ads.zznl;
import com.google.android.gms.internal.ads.zzoh;
import com.google.android.gms.internal.ads.zzpf;
import com.google.android.gms.internal.ads.zzpg;

final class zzpi
extends zznl {
    public zzpi(zzoh zzoh2, int n, long l, long l2) {
        long l3;
        zzni zzni2 = zzpf.zzb((zzoh)zzoh2);
        zzpg zzpg2 = new zzpg(zzoh2, n, null);
        long l4 = zzoh2.zza();
        long l5 = zzoh2.zzj;
        n = zzoh2.zzd;
        if (n > 0) {
            l3 = ((long)n + (long)zzoh2.zzc) / 2L + 1L;
        } else {
            long l6;
            n = zzoh2.zza;
            int n2 = zzoh2.zzb;
            l3 = l6 = 4096L;
            if (n == n2) {
                l3 = l6;
                if (n > 0) {
                    l3 = n;
                }
            }
            l3 = l3 * (long)zzoh2.zzg * (long)zzoh2.zzh / 8L + 64L;
        }
        super(zzni2, (zznk)zzpg2, l4, 0L, l5, l, l2, l3, Math.max(6, zzoh2.zzc));
    }
}
