/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfpf
 *  com.google.android.gms.internal.ads.zzfpg
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfpf;
import com.google.android.gms.internal.ads.zzfpg;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

abstract class zzfph<K, V>
extends AbstractMap<K, V> {
    @CheckForNull
    private transient Set<Map.Entry<K, V>> zza;
    @CheckForNull
    private transient Set<K> zzb;
    @CheckForNull
    private transient Collection<V> zzc;

    zzfph() {
    }

    @Override
    public final Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set;
        Set<Map.Entry<K, V>> set2 = set = this.zza;
        if (set != null) return set2;
        this.zza = set2 = this.zza();
        return set2;
    }

    @Override
    public Set<K> keySet() {
        Set<K> set;
        Set<K> set2 = set = this.zzb;
        if (set != null) return set2;
        this.zzb = set2 = this.zzh();
        return set2;
    }

    @Override
    public final Collection<V> values() {
        zzfpg zzfpg2;
        zzfpg zzfpg3 = zzfpg2 = this.zzc;
        if (zzfpg2 != null) return zzfpg3;
        this.zzc = zzfpg3 = new zzfpg((Map)this);
        return zzfpg3;
    }

    abstract Set<Map.Entry<K, V>> zza();

    Set<K> zzh() {
        return new zzfpf((Map)this);
    }
}
