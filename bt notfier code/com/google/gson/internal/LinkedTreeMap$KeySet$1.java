/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal;

import com.google.gson.internal.LinkedTreeMap;

class LinkedTreeMap.KeySet.1
extends LinkedTreeMap.LinkedTreeMapIterator<K> {
    final LinkedTreeMap.KeySet this$1;

    LinkedTreeMap.KeySet.1(LinkedTreeMap.KeySet keySet) {
        this.this$1 = keySet;
        super(keySet.this$0);
    }

    @Override
    public K next() {
        return this.nextNode().key;
    }
}
