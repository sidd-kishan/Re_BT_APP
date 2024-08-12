/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.arch.core.internal.SafeIterableMap
 *  androidx.arch.core.internal.SafeIterableMap$Entry
 */
package androidx.arch.core.internal;

import androidx.arch.core.internal.SafeIterableMap;
import java.util.HashMap;
import java.util.Map;

public class FastSafeIterableMap<K, V>
extends SafeIterableMap<K, V> {
    private HashMap<K, SafeIterableMap.Entry<K, V>> mHashMap = new HashMap();

    public Map.Entry<K, V> ceil(K k) {
        if (!this.contains(k)) return null;
        return this.mHashMap.get(k).mPrevious;
    }

    public boolean contains(K k) {
        return this.mHashMap.containsKey(k);
    }

    protected SafeIterableMap.Entry<K, V> get(K k) {
        return this.mHashMap.get(k);
    }

    public V putIfAbsent(K k, V v) {
        SafeIterableMap.Entry<K, V> entry = this.get(k);
        if (entry != null) {
            return (V)entry.mValue;
        }
        this.mHashMap.put(k, this.put(k, v));
        return null;
    }

    public V remove(K k) {
        Object object = super.remove(k);
        this.mHashMap.remove(k);
        return (V)object;
    }
}
