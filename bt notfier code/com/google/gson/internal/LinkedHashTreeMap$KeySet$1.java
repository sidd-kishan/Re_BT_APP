/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.internal.LinkedHashTreeMap$KeySet
 *  com.google.gson.internal.LinkedHashTreeMap$LinkedTreeMapIterator
 */
package com.google.gson.internal;

import com.google.gson.internal.LinkedHashTreeMap;

class LinkedHashTreeMap.KeySet.1
extends LinkedHashTreeMap.LinkedTreeMapIterator<K> {
    final LinkedHashTreeMap.KeySet this$1;

    LinkedHashTreeMap.KeySet.1(LinkedHashTreeMap.KeySet keySet) {
        this.this$1 = keySet;
        super(keySet.this$0);
    }

    public K next() {
        return this.nextNode().key;
    }
}
