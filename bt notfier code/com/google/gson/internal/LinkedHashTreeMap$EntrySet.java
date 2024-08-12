/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.internal.LinkedHashTreeMap
 *  com.google.gson.internal.LinkedHashTreeMap$Node
 */
package com.google.gson.internal;

import com.google.gson.internal.LinkedHashTreeMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

final class LinkedHashTreeMap.EntrySet
extends AbstractSet<Map.Entry<K, V>> {
    final LinkedHashTreeMap this$0;

    LinkedHashTreeMap.EntrySet(LinkedHashTreeMap linkedHashTreeMap) {
        this.this$0 = linkedHashTreeMap;
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
        return new /* Unavailable Anonymous Inner Class!! */;
    }

    @Override
    public boolean remove(Object object) {
        if (!(object instanceof Map.Entry)) {
            return false;
        }
        if ((object = this.this$0.findByEntry((Map.Entry)object)) == null) {
            return false;
        }
        this.this$0.removeInternal((LinkedHashTreeMap.Node)object, true);
        return true;
    }

    @Override
    public int size() {
        return this.this$0.size;
    }
}
