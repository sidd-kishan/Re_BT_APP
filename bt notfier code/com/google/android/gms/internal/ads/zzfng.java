/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfpj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfpj;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

abstract class zzfng<K, V>
implements zzfpj<K, V> {
    @CheckForNull
    private transient Set<K> zza;
    @CheckForNull
    private transient Collection<V> zzb;
    @CheckForNull
    private transient Map<K, Collection<V>> zzc;

    zzfng() {
    }

    public final boolean equals(@CheckForNull Object object) {
        boolean bl;
        if (object == this) {
            bl = true;
        } else {
            if (object instanceof zzfpj) {
                object = (zzfpj)object;
                return this.zzu().equals(object.zzu());
            }
            bl = false;
        }
        return bl;
    }

    public final int hashCode() {
        return this.zzu().hashCode();
    }

    public final String toString() {
        return this.zzu().toString();
    }

    public boolean zzh(K k, V v) {
        throw null;
    }

    abstract Set<K> zzk();

    abstract Collection<V> zzn();

    Iterator<V> zzo() {
        throw null;
    }

    abstract Map<K, Collection<V>> zzp();

    public boolean zzr(@CheckForNull Object object) {
        Iterator<Collection<V>> iterator = this.zzu().values().iterator();
        do {
            if (!iterator.hasNext()) return false;
        } while (!iterator.next().contains(object));
        return true;
    }

    public final Set<K> zzs() {
        Set<K> set;
        Set<K> set2 = set = this.zza;
        if (set != null) return set2;
        this.zza = set2 = this.zzk();
        return set2;
    }

    public Collection<V> zzt() {
        Collection<V> collection;
        Collection<V> collection2 = collection = this.zzb;
        if (collection != null) return collection2;
        this.zzb = collection2 = this.zzn();
        return collection2;
    }

    public Map<K, Collection<V>> zzu() {
        Map<K, Collection<Collection<Collection<Collection<V>>>>> map;
        Map<K, Collection<Collection<Collection<Collection<V>>>>> map2 = map = this.zzc;
        if (map != null) return map2;
        map2 = this.zzp();
        this.zzc = map2;
        return map2;
    }
}
