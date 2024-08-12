/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Pair
 *  com.google.android.gms.internal.ads.zzbfu
 *  com.google.android.gms.internal.ads.zzexb
 */
package com.google.android.gms.internal.ads;

import android.util.Pair;
import com.google.android.gms.internal.ads.zzbfu;
import com.google.android.gms.internal.ads.zzexb;

final class zzeky
implements zzexb {
    private final Pair zza;

    zzeky(Pair pair) {
        this.zza = pair;
    }

    public final void zza(Object object) {
        Pair pair = this.zza;
        ((zzbfu)object).zzb((String)pair.first, (String)pair.second);
    }
}
