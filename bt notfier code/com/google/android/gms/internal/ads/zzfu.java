/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzfo
 *  com.google.android.gms.internal.ads.zzgd
 *  com.google.android.gms.internal.ads.zzge
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzfo;
import com.google.android.gms.internal.ads.zzgd;
import com.google.android.gms.internal.ads.zzge;

final class zzfu
implements zzgd {
    static final zzgd zza = new zzfu();

    private zzfu() {
    }

    public final int zza(Object object) {
        object = (zzfo)object;
        int n = zzge.zza;
        object = ((zzfo)object).zza;
        boolean bl = ((String)object).startsWith("OMX.google");
        n = 0;
        if (!bl && !((String)object).startsWith("c2.android")) {
            if (zzamq.zza >= 26) return n;
            if (!((String)object).equals("OMX.MTK.AUDIO.DECODER.RAW")) return 0;
            n = -1;
        } else {
            n = 1;
        }
        return n;
    }
}
