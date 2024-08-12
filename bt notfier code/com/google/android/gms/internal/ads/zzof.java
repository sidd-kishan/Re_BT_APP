/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzoh
 *  com.google.android.gms.internal.ads.zzor
 *  com.google.android.gms.internal.ads.zzot
 *  com.google.android.gms.internal.ads.zzou
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzoh;
import com.google.android.gms.internal.ads.zzor;
import com.google.android.gms.internal.ads.zzot;
import com.google.android.gms.internal.ads.zzou;

public final class zzof
implements zzot {
    private final zzoh zza;
    private final long zzb;

    public zzof(zzoh zzoh2, long l) {
        this.zza = zzoh2;
        this.zzb = l;
    }

    private final zzou zza(long l, long l2) {
        return new zzou(l * 1000000L / (long)this.zza.zze, this.zzb + l2);
    }

    public final boolean zze() {
        return true;
    }

    public final zzor zzf(long l) {
        zzakt.zze((Object)this.zza.zzk);
        zzoh zzoh2 = this.zza;
        Object object = zzoh2.zzk;
        long[] lArray = object.zza;
        object = object.zzb;
        int n = zzamq.zzD((long[])lArray, (long)zzoh2.zzb(l), (boolean)true, (boolean)false);
        Object object2 = 0L;
        long l2 = n == -1 ? 0L : lArray[n];
        if (n != -1) {
            object2 = object[n];
        }
        zzoh2 = this.zza(l2, (long)object2);
        if (zzoh2.zzb == l) return new zzor((zzou)zzoh2, (zzou)zzoh2);
        if (n != lArray.length - 1) return new zzor((zzou)zzoh2, this.zza(lArray[++n], (long)object[n]));
        return new zzor((zzou)zzoh2, (zzou)zzoh2);
    }

    public final long zzg() {
        return this.zza.zza();
    }
}
