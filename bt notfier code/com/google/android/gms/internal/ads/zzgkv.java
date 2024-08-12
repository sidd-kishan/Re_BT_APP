/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgkx
 *  com.google.android.gms.internal.ads.zzgli
 *  com.google.android.gms.internal.ads.zzgln
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgkx;
import com.google.android.gms.internal.ads.zzgli;
import com.google.android.gms.internal.ads.zzgln;
import java.util.LinkedHashMap;

public class zzgkv<K, V, V2> {
    final LinkedHashMap<K, zzgln<V>> zza;

    zzgkv(int n) {
        this.zza = zzgkx.zzc((int)n);
    }

    final zzgkv<K, V, V2> zza(K k, zzgln<V> zzgln2) {
        LinkedHashMap<K, zzgln<zzgln<V>>> linkedHashMap = this.zza;
        zzgli.zza(k, (String)"key");
        zzgli.zza(zzgln2, (String)"provider");
        linkedHashMap.put(k, zzgln2);
        return this;
    }
}
