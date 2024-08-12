/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfo
 *  com.google.android.gms.internal.ads.zzgd
 *  com.google.android.gms.internal.ads.zzge
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfo;
import com.google.android.gms.internal.ads.zzgd;
import com.google.android.gms.internal.ads.zzge;

final class zzfv
implements zzgd {
    static final zzgd zza = new zzfv();

    private zzfv() {
    }

    public final int zza(Object object) {
        object = (zzfo)object;
        int n = zzge.zza;
        if (!((zzfo)object).zza.startsWith("OMX.google")) return 0;
        return 1;
    }
}
