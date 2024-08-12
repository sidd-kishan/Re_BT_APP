/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Pair
 *  com.google.android.gms.ads.nonagon.signalgeneration.zzb
 */
package com.google.android.gms.ads.nonagon.signalgeneration;

import android.util.Pair;
import com.google.android.gms.ads.nonagon.signalgeneration.zzb;
import java.util.LinkedHashMap;
import java.util.Map;

final class zza
extends LinkedHashMap<String, Pair<Long, String>> {
    final zzb zza;

    zza(zzb zzb2) {
        this.zza = zzb2;
    }

    @Override
    protected final boolean removeEldestEntry(Map.Entry<String, Pair<Long, String>> entry) {
        if (this.size() <= zzb.zza((zzb)this.zza)) return false;
        return true;
    }
}
