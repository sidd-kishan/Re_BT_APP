/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.internal.LinkedHashTreeMap$EntrySet
 *  com.google.gson.internal.LinkedHashTreeMap$LinkedTreeMapIterator
 */
package com.google.gson.internal;

import com.google.gson.internal.LinkedHashTreeMap;
import java.util.Map;

class LinkedHashTreeMap.EntrySet.1
extends LinkedHashTreeMap.LinkedTreeMapIterator<Map.Entry<K, V>> {
    final LinkedHashTreeMap.EntrySet this$1;

    LinkedHashTreeMap.EntrySet.1(LinkedHashTreeMap.EntrySet entrySet) {
        this.this$1 = entrySet;
        super(entrySet.this$0);
    }

    public Map.Entry<K, V> next() {
        return this.nextNode();
    }
}
