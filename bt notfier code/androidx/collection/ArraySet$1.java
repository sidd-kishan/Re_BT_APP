/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.collection.ArraySet
 *  androidx.collection.MapCollections
 */
package androidx.collection;

import androidx.collection.ArraySet;
import androidx.collection.MapCollections;
import java.util.Map;

class ArraySet.1
extends MapCollections<E, E> {
    final ArraySet this$0;

    ArraySet.1(ArraySet arraySet) {
        this.this$0 = arraySet;
    }

    protected void colClear() {
        this.this$0.clear();
    }

    protected Object colGetEntry(int n, int n2) {
        return this.this$0.mArray[n];
    }

    protected Map<E, E> colGetMap() {
        throw new UnsupportedOperationException("not a map");
    }

    protected int colGetSize() {
        return this.this$0.mSize;
    }

    protected int colIndexOfKey(Object object) {
        return this.this$0.indexOf(object);
    }

    protected int colIndexOfValue(Object object) {
        return this.this$0.indexOf(object);
    }

    protected void colPut(E e, E e2) {
        this.this$0.add(e);
    }

    protected void colRemoveAt(int n) {
        this.this$0.removeAt(n);
    }

    protected E colSetValue(int n, E e) {
        throw new UnsupportedOperationException("not a map");
    }
}
