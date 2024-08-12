/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.collection.MapCollections
 */
package androidx.collection;

import androidx.collection.MapCollections;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class MapCollections.ArrayIterator<T>
implements Iterator<T> {
    boolean mCanRemove;
    int mIndex;
    final int mOffset;
    int mSize;
    final MapCollections this$0;

    MapCollections.ArrayIterator(MapCollections mapCollections, int n) {
        this.this$0 = mapCollections;
        this.mCanRemove = false;
        this.mOffset = n;
        this.mSize = mapCollections.colGetSize();
    }

    @Override
    public boolean hasNext() {
        boolean bl = this.mIndex < this.mSize;
        return bl;
    }

    @Override
    public T next() {
        if (!this.hasNext()) throw new NoSuchElementException();
        Object object = this.this$0.colGetEntry(this.mIndex, this.mOffset);
        ++this.mIndex;
        this.mCanRemove = true;
        return (T)object;
    }

    @Override
    public void remove() {
        int n;
        if (!this.mCanRemove) throw new IllegalStateException();
        this.mIndex = n = this.mIndex - 1;
        --this.mSize;
        this.mCanRemove = false;
        this.this$0.colRemoveAt(n);
    }
}
