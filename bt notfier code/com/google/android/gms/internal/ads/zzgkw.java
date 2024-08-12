/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgla
 *  com.google.android.gms.internal.ads.zzgln
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgla;
import com.google.android.gms.internal.ads.zzgln;
import java.util.Collections;
import java.util.Map;

abstract class zzgkw<K, V, V2>
implements zzgla<Map<K, V2>> {
    private final Map<K, zzgln<V>> zza;

    zzgkw(Map<K, zzgln<V>> map) {
        this.zza = Collections.unmodifiableMap(map);
    }

    final Map<K, zzgln<V>> zza() {
        return this.zza;
    }
}
