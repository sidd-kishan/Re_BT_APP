/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcxj
 *  com.google.android.gms.internal.ads.zzeec
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcxj;
import com.google.android.gms.internal.ads.zzeec;
import java.util.Map;

public final class zzcxi<AdT>
implements zzcxj<AdT> {
    private final Map<String, zzeec<AdT>> zza;

    zzcxi(Map<String, zzeec<AdT>> map) {
        this.zza = map;
    }

    public final zzeec<AdT> zza(int n, String string) {
        return this.zza.get(string);
    }
}
