/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.collection.ArrayMap
 *  androidx.collection.MapCollections
 */
package androidx.collection;

import androidx.collection.ArrayMap;
import androidx.collection.MapCollections;
import java.util.Map;

class ArrayMap.1
extends MapCollections<K, V> {
    final ArrayMap this$0;

    ArrayMap.1(ArrayMap arrayMap) {
        this.this$0 = arrayMap;
    }

    protected void colClear() {
        this.this$0.clear();
    }

    protected Object colGetEntry(int n, int n2) {
        return this.this$0.mArray[(n << 1) + n2];
    }

    protected Map<K, V> colGetMap() {
        return this.this$0;
    }

    protected int colGetSize() {
        return this.this$0.mSize;
    }

    protected int colIndexOfKey(Object object) {
        return this.this$0.indexOfKey(object);
    }

    protected int colIndexOfValue(Object object) {
        return this.this$0.indexOfValue(object);
    }

    protected void colPut(K k, V v) {
        this.this$0.put(k, v);
    }

    protected void colRemoveAt(int n) {
        this.this$0.removeAt(n);
    }

    protected V colSetValue(int n, V v) {
        return this.this$0.setValueAt(n, v);
    }
}
