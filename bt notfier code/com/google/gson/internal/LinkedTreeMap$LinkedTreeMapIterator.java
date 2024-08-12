/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal;

import com.google.gson.internal.LinkedTreeMap;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

private abstract class LinkedTreeMap.LinkedTreeMapIterator<T>
implements Iterator<T> {
    int expectedModCount;
    LinkedTreeMap.Node<K, V> lastReturned;
    LinkedTreeMap.Node<K, V> next;
    final LinkedTreeMap this$0;

    LinkedTreeMap.LinkedTreeMapIterator(LinkedTreeMap linkedTreeMap) {
        this.this$0 = linkedTreeMap;
        this.next = this.this$0.header.next;
        this.lastReturned = null;
        this.expectedModCount = this.this$0.modCount;
    }

    @Override
    public final boolean hasNext() {
        boolean bl = this.next != this.this$0.header;
        return bl;
    }

    final LinkedTreeMap.Node<K, V> nextNode() {
        LinkedTreeMap.Node node = this.next;
        if (node == this.this$0.header) throw new NoSuchElementException();
        if (this.this$0.modCount != this.expectedModCount) throw new ConcurrentModificationException();
        this.next = node.next;
        this.lastReturned = node;
        return node;
    }

    @Override
    public final void remove() {
        LinkedTreeMap.Node node = this.lastReturned;
        if (node == null) throw new IllegalStateException();
        this.this$0.removeInternal(node, true);
        this.lastReturned = null;
        this.expectedModCount = this.this$0.modCount;
    }
}
