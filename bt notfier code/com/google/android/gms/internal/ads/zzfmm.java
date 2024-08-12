/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfnd
 *  com.google.android.gms.internal.ads.zzfoy
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfnd;
import com.google.android.gms.internal.ads.zzfoy;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

class zzfmm<K, V>
extends zzfnd<K, V>
implements zzfoy<K, V> {
    protected zzfmm(Map<K, Collection<V>> map) {
        super(map);
    }

    final <E> Collection<E> zza(Collection<E> collection) {
        return Collections.unmodifiableList(collection);
    }

    final Collection<V> zzb(K k, Collection<V> collection) {
        return this.zzj(k, (List)collection, null);
    }
}
