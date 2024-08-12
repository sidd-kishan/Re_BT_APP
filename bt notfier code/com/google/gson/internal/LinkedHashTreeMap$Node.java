/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal;

import java.util.Map;

static final class LinkedHashTreeMap.Node<K, V>
implements Map.Entry<K, V> {
    final int hash;
    int height;
    final K key;
    LinkedHashTreeMap.Node<K, V> left;
    LinkedHashTreeMap.Node<K, V> next;
    LinkedHashTreeMap.Node<K, V> parent;
    LinkedHashTreeMap.Node<K, V> prev;
    LinkedHashTreeMap.Node<K, V> right;
    V value;

    LinkedHashTreeMap.Node() {
        this.key = null;
        this.hash = -1;
        this.prev = this;
        this.next = this;
    }

    LinkedHashTreeMap.Node(LinkedHashTreeMap.Node<K, V> node, K k, int n, LinkedHashTreeMap.Node<K, V> node2, LinkedHashTreeMap.Node<K, V> node3) {
        this.parent = node;
        this.key = k;
        this.hash = n;
        this.height = 1;
        this.next = node2;
        this.prev = node3;
        node3.next = this;
        node2.prev = this;
    }

    @Override
    public boolean equals(Object object) {
        boolean bl;
        boolean bl2 = object instanceof Map.Entry;
        boolean bl3 = bl = false;
        if (!bl2) return bl3;
        object = (Map.Entry)object;
        Object object2 = this.key;
        if (object2 == null) {
            bl3 = bl;
            if (object.getKey() != null) return bl3;
        } else {
            bl3 = bl;
            if (!object2.equals(object.getKey())) return bl3;
        }
        object2 = this.value;
        if (object2 == null) {
            bl3 = bl;
            if (object.getValue() != null) return bl3;
        } else {
            bl3 = bl;
            if (!object2.equals(object.getValue())) return bl3;
        }
        bl3 = true;
        return bl3;
    }

    public LinkedHashTreeMap.Node<K, V> first() {
        LinkedHashTreeMap.Node<K, V> node = this.left;
        LinkedHashTreeMap.Node<K, V> node2 = this;
        while (node != null) {
            LinkedHashTreeMap.Node<K, V> node3 = node.left;
            node2 = node;
            node = node3;
        }
        return node2;
    }

    @Override
    public K getKey() {
        return this.key;
    }

    @Override
    public V getValue() {
        return this.value;
    }

    @Override
    public int hashCode() {
        Object object = this.key;
        int n = 0;
        int n2 = object == null ? 0 : object.hashCode();
        object = this.value;
        if (object == null) return n2 ^ n;
        n = object.hashCode();
        return n2 ^ n;
    }

    public LinkedHashTreeMap.Node<K, V> last() {
        LinkedHashTreeMap.Node<K, V> node = this.right;
        LinkedHashTreeMap.Node<K, V> node2 = this;
        while (node != null) {
            LinkedHashTreeMap.Node<K, V> node3 = node.right;
            node2 = node;
            node = node3;
        }
        return node2;
    }

    @Override
    public V setValue(V v) {
        V v2 = this.value;
        this.value = v;
        return v2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.key);
        stringBuilder.append("=");
        stringBuilder.append(this.value);
        return stringBuilder.toString();
    }
}
