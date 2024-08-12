/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.collection.MapCollections
 *  androidx.collection.MapCollections$ArrayIterator
 */
package androidx.collection;

import androidx.collection.MapCollections;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
 * Exception performing whole class analysis ignored.
 */
final class MapCollections.KeySet
implements Set<K> {
    final MapCollections this$0;

    MapCollections.KeySet(MapCollections mapCollections) {
        this.this$0 = mapCollections;
    }

    @Override
    public boolean add(K k) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends K> collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        this.this$0.colClear();
    }

    @Override
    public boolean contains(Object object) {
        boolean bl = this.this$0.colIndexOfKey(object) >= 0;
        return bl;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        return MapCollections.containsAllHelper((Map)this.this$0.colGetMap(), collection);
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
            int n3 = object == null ? 0 : object.hashCode();
            n2 += n3;
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
    public Iterator<K> iterator() {
        return new MapCollections.ArrayIterator(this.this$0, 0);
    }

    @Override
    public boolean remove(Object object) {
        int n = this.this$0.colIndexOfKey(object);
        if (n < 0) return false;
        this.this$0.colRemoveAt(n);
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        return MapCollections.removeAllHelper((Map)this.this$0.colGetMap(), collection);
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        return MapCollections.retainAllHelper((Map)this.this$0.colGetMap(), collection);
    }

    @Override
    public int size() {
        return this.this$0.colGetSize();
    }

    @Override
    public Object[] toArray() {
        return this.this$0.toArrayHelper(0);
    }

    @Override
    public <T> T[] toArray(T[] TArray) {
        return this.this$0.toArrayHelper((Object[])TArray, 0);
    }
}
