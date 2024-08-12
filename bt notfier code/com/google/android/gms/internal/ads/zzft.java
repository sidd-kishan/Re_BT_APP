/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzafv
 *  com.google.android.gms.internal.ads.zzfo
 *  com.google.android.gms.internal.ads.zzfy
 *  com.google.android.gms.internal.ads.zzgd
 *  com.google.android.gms.internal.ads.zzge
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzafv;
import com.google.android.gms.internal.ads.zzfo;
import com.google.android.gms.internal.ads.zzfy;
import com.google.android.gms.internal.ads.zzgd;
import com.google.android.gms.internal.ads.zzge;

final class zzft
implements zzgd {
    private final zzafv zza;

    zzft(zzafv zzafv2) {
        this.zza = zzafv2;
    }

    public final int zza(Object object) {
        zzafv zzafv2 = this.zza;
        object = (zzfo)object;
        int n = zzge.zza;
        try {
            boolean bl = object.zzc(zzafv2);
            if (bl) return 1;
            n = 0;
        }
        catch (zzfy zzfy2) {
            n = -1;
        }
        return n;
    }
}
