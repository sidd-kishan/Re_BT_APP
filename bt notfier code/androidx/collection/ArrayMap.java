/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.collection.MapCollections
 *  androidx.collection.SimpleArrayMap
 */
package androidx.collection;

import androidx.collection.MapCollections;
import androidx.collection.SimpleArrayMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class ArrayMap<K, V>
extends SimpleArrayMap<K, V>
implements Map<K, V> {
    MapCollections<K, V> mCollections;

    public ArrayMap() {
    }

    public ArrayMap(int n) {
        super(n);
    }

    public ArrayMap(SimpleArrayMap simpleArrayMap) {
        super(simpleArrayMap);
    }

    private MapCollections<K, V> getCollection() {
        if (this.mCollections != null) return this.mCollections;
        this.mCollections = new /* Unavailable Anonymous Inner Class!! */;
        return this.mCollections;
    }

    public boolean containsAll(Collection<?> collection) {
        return MapCollections.containsAllHelper((Map)this, collection);
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        return this.getCollection().getEntrySet();
    }

    @Override
    public Set<K> keySet() {
        return this.getCollection().getKeySet();
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> object) {
        this.ensureCapacity(this.mSize + object.size());
        object = object.entrySet().iterator();
        while (object.hasNext()) {
            Map.Entry entry = (Map.Entry)object.next();
            this.put(entry.getKey(), entry.getValue());
        }
    }

    public boolean removeAll(Collection<?> collection) {
        return MapCollections.removeAllHelper((Map)this, collection);
    }

    public boolean retainAll(Collection<?> collection) {
        return MapCollections.retainAllHelper((Map)this, collection);
    }

    @Override
    public Collection<V> values() {
        return this.getCollection().getValues();
    }
}
