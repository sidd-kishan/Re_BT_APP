/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.internal.LinkedHashTreeMap
 *  com.google.gson.internal.LinkedHashTreeMap$Node
 */
package com.google.gson.internal;

import com.google.gson.internal.LinkedHashTreeMap;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

private abstract class LinkedHashTreeMap.LinkedTreeMapIterator<T>
implements Iterator<T> {
    int expectedModCount;
    LinkedHashTreeMap.Node<K, V> lastReturned;
    LinkedHashTreeMap.Node<K, V> next;
    final LinkedHashTreeMap this$0;

    LinkedHashTreeMap.LinkedTreeMapIterator(LinkedHashTreeMap linkedHashTreeMap) {
        this.this$0 = linkedHashTreeMap;
        this.next = this.this$0.header.next;
        this.lastReturned = null;
        this.expectedModCount = this.this$0.modCount;
    }

    @Override
    public final boolean hasNext() {
        boolean bl = this.next != this.this$0.header;
        return bl;
    }

    final LinkedHashTreeMap.Node<K, V> nextNode() {
        LinkedHashTreeMap.Node node = this.next;
        if (node == this.this$0.header) throw new NoSuchElementException();
        if (this.this$0.modCount != this.expectedModCount) throw new ConcurrentModificationException();
        this.next = node.next;
        this.lastReturned = node;
        return node;
    }

    @Override
    public final void remove() {
        LinkedHashTreeMap.Node node = this.lastReturned;
        if (node == null) throw new IllegalStateException();
        this.this$0.removeInternal(node, true);
        this.lastReturned = null;
        this.expectedModCount = this.this$0.modCount;
    }
}
