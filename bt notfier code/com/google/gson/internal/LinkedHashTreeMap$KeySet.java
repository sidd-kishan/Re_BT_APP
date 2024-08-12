/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.internal.LinkedHashTreeMap
 */
package com.google.gson.internal;

import com.google.gson.internal.LinkedHashTreeMap;
import java.util.AbstractSet;
import java.util.Iterator;

final class LinkedHashTreeMap.KeySet
extends AbstractSet<K> {
    final LinkedHashTreeMap this$0;

    LinkedHashTreeMap.KeySet(LinkedHashTreeMap linkedHashTreeMap) {
        this.this$0 = linkedHashTreeMap;
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
        return new /* Unavailable Anonymous Inner Class!! */;
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
