/*
 * Decompiled with CFR 0.152.
 */
package com.bumptech.glide.load.engine.bitmap_recycle;

import java.util.ArrayList;
import java.util.List;

private static class GroupedLinkedMap.LinkedEntry<K, V> {
    final K key;
    GroupedLinkedMap.LinkedEntry<K, V> next;
    GroupedLinkedMap.LinkedEntry<K, V> prev = this;
    private List<V> values;

    GroupedLinkedMap.LinkedEntry() {
        this(null);
    }

    GroupedLinkedMap.LinkedEntry(K k) {
        this.next = this;
        this.key = k;
    }

    public void add(V v) {
        if (this.values == null) {
            this.values = new ArrayList<V>();
        }
        this.values.add(v);
    }

    public V removeLast() {
        int n = this.size();
        V v = n > 0 ? (V)this.values.remove(n - 1) : null;
        return v;
    }

    public int size() {
        List<V> list = this.values;
        int n = list != null ? list.size() : 0;
        return n;
    }
}
