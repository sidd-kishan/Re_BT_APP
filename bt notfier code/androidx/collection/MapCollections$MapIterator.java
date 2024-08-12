/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.collection.ContainerHelpers
 *  androidx.collection.MapCollections
 */
package androidx.collection;

import androidx.collection.ContainerHelpers;
import androidx.collection.MapCollections;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

final class MapCollections.MapIterator
implements Iterator<Map.Entry<K, V>>,
Map.Entry<K, V> {
    int mEnd;
    boolean mEntryValid;
    int mIndex;
    final MapCollections this$0;

    MapCollections.MapIterator(MapCollections mapCollections) {
        this.this$0 = mapCollections;
        this.mEntryValid = false;
        this.mEnd = mapCollections.colGetSize() - 1;
        this.mIndex = -1;
    }

    @Override
    public boolean equals(Object object) {
        if (!this.mEntryValid) throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        boolean bl = object instanceof Map.Entry;
        boolean bl2 = false;
        if (!bl) {
            return false;
        }
        object = (Map.Entry)object;
        bl = bl2;
        if (!ContainerHelpers.equal(object.getKey(), (Object)this.this$0.colGetEntry(this.mIndex, 0))) return bl;
        bl = bl2;
        if (!ContainerHelpers.equal(object.getValue(), (Object)this.this$0.colGetEntry(this.mIndex, 1))) return bl;
        bl = true;
        return bl;
    }

    @Override
    public K getKey() {
        if (!this.mEntryValid) throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        return this.this$0.colGetEntry(this.mIndex, 0);
    }

    @Override
    public V getValue() {
        if (!this.mEntryValid) throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        return this.this$0.colGetEntry(this.mIndex, 1);
    }

    @Override
    public boolean hasNext() {
        boolean bl = this.mIndex < this.mEnd;
        return bl;
    }

    @Override
    public int hashCode() {
        if (!this.mEntryValid) throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        Object object = this.this$0;
        int n = this.mIndex;
        int n2 = 0;
        Object object2 = object.colGetEntry(n, 0);
        object = this.this$0.colGetEntry(this.mIndex, 1);
        n = object2 == null ? 0 : object2.hashCode();
        if (object == null) return n ^ n2;
        n2 = object.hashCode();
        return n ^ n2;
    }

    @Override
    public Map.Entry<K, V> next() {
        if (!this.hasNext()) throw new NoSuchElementException();
        ++this.mIndex;
        this.mEntryValid = true;
        return this;
    }

    @Override
    public void remove() {
        if (!this.mEntryValid) throw new IllegalStateException();
        this.this$0.colRemoveAt(this.mIndex);
        --this.mIndex;
        --this.mEnd;
        this.mEntryValid = false;
    }

    @Override
    public V setValue(V v) {
        if (!this.mEntryValid) throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        return this.this$0.colSetValue(this.mIndex, v);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getKey());
        stringBuilder.append("=");
        stringBuilder.append(this.getValue());
        return stringBuilder.toString();
    }
}
