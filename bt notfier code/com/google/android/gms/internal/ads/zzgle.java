/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgkw
 *  com.google.android.gms.internal.ads.zzgkx
 *  com.google.android.gms.internal.ads.zzglb
 *  com.google.android.gms.internal.ads.zzglc
 *  com.google.android.gms.internal.ads.zzgld
 *  com.google.android.gms.internal.ads.zzgln
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgkw;
import com.google.android.gms.internal.ads.zzgkx;
import com.google.android.gms.internal.ads.zzglb;
import com.google.android.gms.internal.ads.zzglc;
import com.google.android.gms.internal.ads.zzgld;
import com.google.android.gms.internal.ads.zzgln;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public final class zzgle<K, V>
extends zzgkw<K, V, V> {
    private static final zzgln<Map<Object, Object>> zza = zzglb.zza(Collections.emptyMap());

    /* synthetic */ zzgle(Map map, zzglc zzglc2) {
        super(map);
    }

    public static <K, V> zzgld<K, V> zzc(int n) {
        return new zzgld(n, null);
    }

    public final Map<K, V> zzd() {
        LinkedHashMap linkedHashMap = zzgkx.zzc((int)this.zza().size());
        Iterator iterator = this.zza().entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            linkedHashMap.put(entry.getKey(), ((zzgln)entry.getValue()).zzb());
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }
}
