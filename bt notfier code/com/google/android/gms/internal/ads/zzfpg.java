/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzflt
 *  com.google.android.gms.internal.ads.zzfpd
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzflt;
import com.google.android.gms.internal.ads.zzfpd;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

final class zzfpg<K, V>
extends AbstractCollection<V> {
    final Map<K, V> zza;

    zzfpg(Map<K, V> map) {
        this.zza = map;
    }

    @Override
    public final void clear() {
        this.zza.clear();
    }

    @Override
    public final boolean contains(@CheckForNull Object object) {
        return this.zza.containsValue(object);
    }

    @Override
    public final boolean isEmpty() {
        return this.zza.isEmpty();
    }

    @Override
    public final Iterator<V> iterator() {
        return new zzfpd(this.zza.entrySet().iterator());
    }

    @Override
    public final boolean remove(@CheckForNull Object object) {
        try {
            boolean bl = super.remove(object);
            return bl;
        }
        catch (UnsupportedOperationException unsupportedOperationException) {
            Map.Entry<K, V> entry;
            Iterator<Map.Entry<K, V>> iterator = this.zza.entrySet().iterator();
            do {
                if (!iterator.hasNext()) return false;
            } while (!zzflt.zza((Object)object, (entry = iterator.next()).getValue()));
            this.zza.remove(entry.getKey());
            return true;
        }
    }

    @Override
    public final boolean removeAll(Collection<?> collection) {
        if (collection == null) throw null;
        try {
            return super.removeAll(collection);
        }
        catch (UnsupportedOperationException unsupportedOperationException) {
            HashSet<K> hashSet = new HashSet<K>();
            Iterator<Map.Entry<K, V>> iterator = this.zza.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<K, V> entry = iterator.next();
                if (!collection.contains(entry.getValue())) continue;
                hashSet.add(entry.getKey());
            }
            return this.zza.keySet().removeAll(hashSet);
        }
    }

    @Override
    public final boolean retainAll(Collection<?> collection) {
        if (collection == null) throw null;
        try {
            return super.retainAll(collection);
        }
        catch (UnsupportedOperationException unsupportedOperationException) {
            HashSet<K> hashSet = new HashSet<K>();
            Iterator<Map.Entry<K, V>> iterator = this.zza.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<K, V> entry = iterator.next();
                if (!collection.contains(entry.getValue())) continue;
                hashSet.add(entry.getKey());
            }
            return this.zza.keySet().retainAll(hashSet);
        }
    }

    @Override
    public final int size() {
        return this.zza.size();
    }
}
