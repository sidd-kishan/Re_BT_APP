/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.internal.LinkedHashTreeMap$Node
 */
package com.google.gson.internal;

import com.google.gson.internal.LinkedHashTreeMap;

static final class LinkedHashTreeMap.AvlBuilder<K, V> {
    private int leavesSkipped;
    private int leavesToSkip;
    private int size;
    private LinkedHashTreeMap.Node<K, V> stack;

    LinkedHashTreeMap.AvlBuilder() {
    }

    void add(LinkedHashTreeMap.Node<K, V> node) {
        int n;
        int n2;
        node.right = null;
        node.parent = null;
        node.left = null;
        node.height = 1;
        int n3 = this.leavesToSkip;
        if (n3 > 0 && ((n2 = this.size) & 1) == 0) {
            this.size = n2 + 1;
            this.leavesToSkip = n3 - 1;
            ++this.leavesSkipped;
        }
        node.parent = this.stack;
        this.stack = node;
        this.size = n3 = this.size + 1;
        n2 = this.leavesToSkip;
        if (n2 > 0 && (n3 & 1) == 0) {
            this.size = n3 + 1;
            this.leavesToSkip = n2 - 1;
            ++this.leavesSkipped;
        }
        n3 = 4;
        while (((n2 = this.size) & (n = n3 - 1)) == n) {
            LinkedHashTreeMap.Node node2;
            n2 = this.leavesSkipped;
            if (n2 == 0) {
                LinkedHashTreeMap.Node<K, V> node3 = this.stack;
                node = node3.parent;
                node2 = node.parent;
                node.parent = node2.parent;
                this.stack = node;
                node.left = node2;
                node.right = node3;
                node.height = node3.height + 1;
                node2.parent = node;
                node3.parent = node;
            } else if (n2 == 1) {
                node2 = this.stack;
                this.stack = node = node2.parent;
                node.right = node2;
                node.height = node2.height + 1;
                node2.parent = node;
                this.leavesSkipped = 0;
            } else if (n2 == 2) {
                this.leavesSkipped = 0;
            }
            n3 *= 2;
        }
    }

    void reset(int n) {
        this.leavesToSkip = Integer.highestOneBit(n) * 2 - 1 - n;
        this.size = 0;
        this.leavesSkipped = 0;
        this.stack = null;
    }

    LinkedHashTreeMap.Node<K, V> root() {
        LinkedHashTreeMap.Node<K, V> node = this.stack;
        if (node.parent != null) throw new IllegalStateException();
        return node;
    }
}
