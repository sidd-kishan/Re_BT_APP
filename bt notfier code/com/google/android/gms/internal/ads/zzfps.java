/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfmj
 *  com.google.android.gms.internal.ads.zzfmm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfmj;
import com.google.android.gms.internal.ads.zzfmm;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class zzfps<K, V>
extends zzfmm<K, V> {
    final transient zzfmj<? extends List<V>> zza;

    zzfps(Map<K, Collection<V>> map, zzfmj<? extends List<V>> zzfmj2) {
        super(map);
        this.zza = zzfmj2;
    }

    final Set<K> zzk() {
        return this.zzl();
    }

    final Map<K, Collection<V>> zzp() {
        return this.zzq();
    }
}
