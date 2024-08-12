/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal;

import com.google.gson.internal.LinkedTreeMap;
import java.util.AbstractSet;
import java.util.Iterator;

final class LinkedTreeMap.KeySet
extends AbstractSet<K> {
    final LinkedTreeMap this$0;

    LinkedTreeMap.KeySet(LinkedTreeMap linkedTreeMap) {
        this.this$0 = linkedTreeMap;
    }

    @Override
    public void clear() {
        this.this$0.clear();
    }

    @Override
    public boolean contains(Object object) {
        return this.this$0.containsKey(object);
    }

    @Override
    public Iterator<K> iterator() {
        return new LinkedTreeMap.LinkedTreeMapIterator<K>(){

            @Override
            public K next() {
                return this.nextNode().key;
            }
        };
    }

    @Override
    public boolean remove(Object object) {
        boolean bl = this.this$0.removeInternalByKey(object) != null;
        return bl;
    }

    @Override
    public int size() {
        return this.this$0.size;
    }
}
