/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal;

import com.google.gson.internal.LinkedTreeMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

class LinkedTreeMap.EntrySet
extends AbstractSet<Map.Entry<K, V>> {
    final LinkedTreeMap this$0;

    LinkedTreeMap.EntrySet(LinkedTreeMap linkedTreeMap) {
        this.this$0 = linkedTreeMap;
    }

    @Override
    public void clear() {
        this.this$0.clear();
    }

    @Override
    public boolean contains(Object object) {
        boolean bl = object instanceof Map.Entry && this.this$0.findByEntry((Map.Entry)object) != null;
        return bl;
    }

    @Override
    public Iterator<Map.Entry<K, V>> iterator() {
        return new LinkedTreeMap.LinkedTreeMapIterator<Map.Entry<K, V>>(){

            @Override
            public Map.Entry<K, V> next() {
                return this.nextNode();
            }
        };
    }

    @Override
    public boolean remove(Object node) {
        if (!(node instanceof Map.Entry)) {
            return false;
        }
        if ((node = this.this$0.findByEntry(node)) == null) {
            return false;
        }
        this.this$0.removeInternal(node, true);
        return true;
    }

    @Override
    public int size() {
        return this.this$0.size;
    }
}
