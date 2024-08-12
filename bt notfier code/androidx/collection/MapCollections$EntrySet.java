/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.collection.ContainerHelpers
 *  androidx.collection.MapCollections
 *  androidx.collection.MapCollections$MapIterator
 */
package androidx.collection;

import androidx.collection.ContainerHelpers;
import androidx.collection.MapCollections;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
 * Exception performing whole class analysis ignored.
 */
final class MapCollections.EntrySet
implements Set<Map.Entry<K, V>> {
    final MapCollections this$0;

    MapCollections.EntrySet(MapCollections mapCollections) {
        this.this$0 = mapCollections;
    }

    @Override
    public boolean add(Map.Entry<K, V> entry) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends Map.Entry<K, V>> object) {
        int n = this.this$0.colGetSize();
        Iterator iterator = object.iterator();
        while (iterator.hasNext()) {
            object = iterator.next();
            this.this$0.colPut(object.getKey(), object.getValue());
        }
        boolean bl = n != this.this$0.colGetSize();
        return bl;
    }

    @Override
    public void clear() {
        this.this$0.colClear();
    }

    @Override
    public boolean contains(Object object) {
        if (!(object instanceof Map.Entry)) {
            return false;
        }
        int n = this.this$0.colIndexOfKey((object = (Map.Entry)object).getKey());
        if (n >= 0) return ContainerHelpers.equal((Object)this.this$0.colGetEntry(n, 1), object.getValue());
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> object) {
        object = object.iterator();
        do {
            if (!object.hasNext()) return true;
        } while (this.contains(object.next()));
        return false;
    }

    @Override
    public boolean equals(Object object) {
        return MapCollections.equalsSetHelper((Set)this, (Object)object);
    }

    @Override
    public int hashCode() {
        int n = this.this$0.colGetSize() - 1;
        int n2 = 0;
        while (n >= 0) {
            Object object = this.this$0.colGetEntry(n, 0);
            Object object2 = this.this$0.colGetEntry(n, 1);
            int n3 = object == null ? 0 : object.hashCode();
            int n4 = object2 == null ? 0 : object2.hashCode();
            n2 += n3 ^ n4;
            --n;
        }
        return n2;
    }

    @Override
    public boolean isEmpty() {
        boolean bl = this.this$0.colGetSize() == 0;
        return bl;
    }

    @Override
    public Iterator<Map.Entry<K, V>> iterator() {
        return new MapCollections.MapIterator(this.this$0);
    }

    @Override
    public boolean remove(Object object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        return this.this$0.colGetSize();
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T> T[] toArray(T[] TArray) {
        throw new UnsupportedOperationException();
    }
}
