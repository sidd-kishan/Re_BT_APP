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

final class MapCollections.ValuesCollection
implements Collection<V> {
    final MapCollections this$0;

    MapCollections.ValuesCollection(MapCollections mapCollections) {
        this.this$0 = mapCollections;
    }

    @Override
    public boolean add(V v) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends V> collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        this.this$0.colClear();
    }

    @Override
    public boolean contains(Object object) {
        boolean bl = this.this$0.colIndexOfValue(object) >= 0;
        return bl;
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
    public boolean isEmpty() {
        boolean bl = this.this$0.colGetSize() == 0;
        return bl;
    }

    @Override
    public Iterator<V> iterator() {
        return new MapCollections.ArrayIterator(this.this$0, 1);
    }

    @Override
    public boolean remove(Object object) {
        int n = this.this$0.colIndexOfValue(object);
        if (n < 0) return false;
        this.this$0.colRemoveAt(n);
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        int n = this.this$0.colGetSize();
        int n2 = 0;
        boolean bl = false;
        while (n2 < n) {
            int n3 = n;
            int n4 = n2;
            if (collection.contains(this.this$0.colGetEntry(n2, 1))) {
                this.this$0.colRemoveAt(n2);
                n4 = n2 - 1;
                n3 = n - 1;
                bl = true;
            }
            n2 = n4 + 1;
            n = n3;
        }
        return bl;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        int n = this.this$0.colGetSize();
        int n2 = 0;
        boolean bl = false;
        while (n2 < n) {
            int n3 = n;
            int n4 = n2;
            if (!collection.contains(this.this$0.colGetEntry(n2, 1))) {
                this.this$0.colRemoveAt(n2);
                n4 = n2 - 1;
                n3 = n - 1;
                bl = true;
            }
            n2 = n4 + 1;
            n = n3;
        }
        return bl;
    }

    @Override
    public int size() {
        return this.this$0.colGetSize();
    }

    @Override
    public Object[] toArray() {
        return this.this$0.toArrayHelper(1);
    }

    @Override
    public <T> T[] toArray(T[] TArray) {
        return this.this$0.toArrayHelper((Object[])TArray, 1);
    }
}
