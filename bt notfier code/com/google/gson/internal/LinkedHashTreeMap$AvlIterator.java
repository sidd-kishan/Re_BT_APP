/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.internal.LinkedHashTreeMap$Node
 */
package com.google.gson.internal;

import com.google.gson.internal.LinkedHashTreeMap;

static class LinkedHashTreeMap.AvlIterator<K, V> {
    private LinkedHashTreeMap.Node<K, V> stackTop;

    LinkedHashTreeMap.AvlIterator() {
    }

    public LinkedHashTreeMap.Node<K, V> next() {
        LinkedHashTreeMap.Node<K, V> node = this.stackTop;
        if (node == null) {
            return null;
        }
        LinkedHashTreeMap.Node node2 = node.parent;
        node.parent = null;
        LinkedHashTreeMap.Node node3 = node.right;
        while (true) {
            LinkedHashTreeMap.Node node4 = node2;
            node2 = node3;
            if (node2 == null) {
                this.stackTop = node4;
                return node;
            }
            node2.parent = node4;
            node3 = node2.left;
        }
    }

    void reset(LinkedHashTreeMap.Node<K, V> node) {
        LinkedHashTreeMap.Node node2 = null;
        while (true) {
            if (node == null) {
                this.stackTop = node2;
                return;
            }
            node.parent = node2;
            LinkedHashTreeMap.Node node3 = node.left;
            node2 = node;
            node = node3;
        }
    }
}
