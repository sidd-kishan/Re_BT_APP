/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.internal.LinkedHashTreeMap$AvlBuilder
 *  com.google.gson.internal.LinkedHashTreeMap$AvlIterator
 *  com.google.gson.internal.LinkedHashTreeMap$EntrySet
 *  com.google.gson.internal.LinkedHashTreeMap$KeySet
 *  com.google.gson.internal.LinkedHashTreeMap$Node
 */
package com.google.gson.internal;

import com.google.gson.internal.LinkedHashTreeMap;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public final class LinkedHashTreeMap<K, V>
extends AbstractMap<K, V>
implements Serializable {
    static final boolean $assertionsDisabled = false;
    private static final Comparator<Comparable> NATURAL_ORDER = new /* Unavailable Anonymous Inner Class!! */;
    Comparator<? super K> comparator;
    private EntrySet entrySet;
    final Node<K, V> header;
    private KeySet keySet;
    int modCount = 0;
    int size = 0;
    Node<K, V>[] table;
    int threshold;

    public LinkedHashTreeMap() {
        this(NATURAL_ORDER);
    }

    public LinkedHashTreeMap(Comparator<? super K> nodeArray) {
        if (nodeArray == null) {
            nodeArray = NATURAL_ORDER;
        }
        this.comparator = nodeArray;
        this.header = new Node();
        nodeArray = new Node[16];
        this.table = nodeArray;
        this.threshold = nodeArray.length / 2 + nodeArray.length / 4;
    }

    private void doubleCapacity() {
        Node<K, V>[] nodeArray = LinkedHashTreeMap.doubleCapacity(this.table);
        this.table = nodeArray;
        this.threshold = nodeArray.length / 2 + nodeArray.length / 4;
    }

    static <K, V> Node<K, V>[] doubleCapacity(Node<K, V>[] nodeArray) {
        int n = nodeArray.length;
        Node[] nodeArray2 = new Node[n * 2];
        AvlIterator avlIterator = new AvlIterator();
        AvlBuilder avlBuilder = new AvlBuilder();
        AvlBuilder avlBuilder2 = new AvlBuilder();
        int n2 = 0;
        while (n2 < n) {
            Object object = nodeArray[n2];
            if (object != null) {
                Node node;
                avlIterator.reset(object);
                int n3 = 0;
                int n4 = 0;
                while ((node = avlIterator.next()) != null) {
                    if ((node.hash & n) == 0) {
                        ++n3;
                        continue;
                    }
                    ++n4;
                }
                avlBuilder.reset(n3);
                avlBuilder2.reset(n4);
                avlIterator.reset(object);
                while ((object = avlIterator.next()) != null) {
                    if ((object.hash & n) == 0) {
                        avlBuilder.add(object);
                        continue;
                    }
                    avlBuilder2.add(object);
                }
                node = null;
                object = n3 > 0 ? avlBuilder.root() : null;
                nodeArray2[n2] = object;
                object = node;
                if (n4 > 0) {
                    object = avlBuilder2.root();
                }
                nodeArray2[n2 + n] = object;
            }
            ++n2;
        }
        return nodeArray2;
    }

    private boolean equal(Object object, Object object2) {
        boolean bl = object == object2 || object != null && object.equals(object2);
        return bl;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("Deserialization is unsupported");
    }

    private void rebalance(Node<K, V> node, boolean bl) {
        while (node != null) {
            Node node2;
            Node node3 = node.left;
            Node node4 = node.right;
            int n = 0;
            int n2 = 0;
            int n3 = node3 != null ? node3.height : 0;
            int n4 = node4 != null ? node4.height : 0;
            int n5 = n3 - n4;
            if (n5 == -2) {
                node3 = node4.left;
                node2 = node4.right;
                n3 = node2 != null ? node2.height : 0;
                n4 = n2;
                if (node3 != null) {
                    n4 = node3.height;
                }
                if ((n3 = n4 - n3) != -1 && (n3 != 0 || bl)) {
                    this.rotateRight(node4);
                    this.rotateLeft(node);
                } else {
                    this.rotateLeft(node);
                }
                if (bl) {
                    break;
                }
            } else if (n5 == 2) {
                node4 = node3.left;
                node2 = node3.right;
                n3 = node2 != null ? node2.height : 0;
                n4 = n;
                if (node4 != null) {
                    n4 = node4.height;
                }
                if ((n3 = n4 - n3) != 1 && (n3 != 0 || bl)) {
                    this.rotateLeft(node3);
                    this.rotateRight(node);
                } else {
                    this.rotateRight(node);
                }
                if (bl) {
                    break;
                }
            } else if (n5 == 0) {
                node.height = n3 + 1;
                if (bl) {
                    break;
                }
            } else {
                node.height = Math.max(n3, n4) + 1;
                if (!bl) return;
            }
            node = node.parent;
        }
        return;
    }

    private void replaceInParent(Node<K, V> nodeArray, Node<K, V> node) {
        Node node2 = nodeArray.parent;
        nodeArray.parent = null;
        if (node != null) {
            node.parent = node2;
        }
        if (node2 != null) {
            if (node2.left == nodeArray) {
                node2.left = node;
            } else {
                node2.right = node;
            }
        } else {
            int n = nodeArray.hash;
            nodeArray = this.table;
            nodeArray[n & nodeArray.length - 1] = node;
        }
    }

    private void rotateLeft(Node<K, V> node) {
        Node node2 = node.left;
        Node node3 = node.right;
        Node node4 = node3.left;
        Node node5 = node3.right;
        node.right = node4;
        if (node4 != null) {
            node4.parent = node;
        }
        this.replaceInParent(node, node3);
        node3.left = node;
        node.parent = node3;
        int n = 0;
        int n2 = node2 != null ? node2.height : 0;
        int n3 = node4 != null ? node4.height : 0;
        n3 = node.height = Math.max(n2, n3) + 1;
        n2 = n;
        if (node5 != null) {
            n2 = node5.height;
        }
        node3.height = Math.max(n3, n2) + 1;
    }

    private void rotateRight(Node<K, V> node) {
        Node node2;
        Node node3 = node.left;
        Node node4 = node.right;
        Node node5 = node3.left;
        node.left = node2 = node3.right;
        if (node2 != null) {
            node2.parent = node;
        }
        this.replaceInParent(node, node3);
        node3.right = node;
        node.parent = node3;
        int n = 0;
        int n2 = node4 != null ? node4.height : 0;
        int n3 = node2 != null ? node2.height : 0;
        n3 = node.height = Math.max(n2, n3) + 1;
        n2 = n;
        if (node5 != null) {
            n2 = node5.height;
        }
        node3.height = Math.max(n3, n2) + 1;
    }

    private static int secondaryHash(int n) {
        n ^= n >>> 20 ^ n >>> 12;
        return n >>> 4 ^ (n >>> 7 ^ n);
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }

    @Override
    public void clear() {
        Arrays.fill(this.table, null);
        this.size = 0;
        ++this.modCount;
        Node<K, V> node = this.header;
        Node node2 = node.next;
        while (true) {
            if (node2 == node) {
                node.prev = node;
                node.next = node;
                return;
            }
            Node node3 = node2.next;
            node2.prev = null;
            node2.next = null;
            node2 = node3;
        }
    }

    @Override
    public boolean containsKey(Object object) {
        boolean bl = this.findByObject(object) != null;
        return bl;
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        EntrySet entrySet = this.entrySet;
        if (entrySet != null) return entrySet;
        this.entrySet = entrySet = new EntrySet(this);
        return entrySet;
    }

    Node<K, V> find(K object, boolean bl) {
        Node<K, V> node;
        int n;
        Comparator<K> comparator = this.comparator;
        Node<K, V>[] nodeArray = this.table;
        int n2 = LinkedHashTreeMap.secondaryHash(object.hashCode());
        int n3 = nodeArray.length - 1 & n2;
        Node<K, V> node2 = nodeArray[n3];
        if (node2 == null) {
            n = 0;
        } else {
            Comparable comparable = comparator == NATURAL_ORDER ? (Comparable)object : null;
            while (true) {
                if ((n = comparable != null ? comparable.compareTo(node2.key) : comparator.compare(object, node2.key)) == 0) {
                    return node2;
                }
                node = n < 0 ? node2.left : node2.right;
                if (node == null) break;
                node2 = node;
            }
        }
        if (!bl) {
            return null;
        }
        node = this.header;
        if (node2 == null) {
            if (comparator == NATURAL_ORDER && !(object instanceof Comparable)) {
                node2 = new StringBuilder();
                node2.append(object.getClass().getName());
                node2.append(" is not Comparable");
                throw new ClassCastException(node2.toString());
            }
            object = new Node(node2, object, n2, (Node)node, node.prev);
            nodeArray[n3] = object;
        } else {
            object = new Node(node2, object, n2, node, node.prev);
            if (n < 0) {
                node2.left = object;
            } else {
                node2.right = object;
            }
            this.rebalance(node2, true);
        }
        n = this.size;
        this.size = n + 1;
        if (n > this.threshold) {
            this.doubleCapacity();
        }
        ++this.modCount;
        return object;
    }

    Node<K, V> findByEntry(Map.Entry<?, ?> entry) {
        Node<K, V> node = this.findByObject(entry.getKey());
        boolean bl = node != null && this.equal(node.value, entry.getValue());
        entry = bl ? node : null;
        return entry;
    }

    Node<K, V> findByObject(Object object) {
        Node<Object, V> node;
        Node<Object, V> node2 = node = null;
        if (object == null) return node2;
        try {
            node2 = this.find(object, false);
        }
        catch (ClassCastException classCastException) {
            node2 = node;
        }
        return node2;
    }

    @Override
    public V get(Object object) {
        object = (object = this.findByObject(object)) != null ? object.value : null;
        return (V)object;
    }

    @Override
    public Set<K> keySet() {
        KeySet keySet = this.keySet;
        if (keySet != null) return keySet;
        this.keySet = keySet = new KeySet(this);
        return keySet;
    }

    @Override
    public V put(K object, V v) {
        if (object == null) throw new NullPointerException("key == null");
        object = this.find(object, true);
        Object object2 = ((Node)object).value;
        ((Node)object).value = v;
        return (V)object2;
    }

    @Override
    public V remove(Object object) {
        object = (object = this.removeInternalByKey(object)) != null ? object.value : null;
        return (V)object;
    }

    void removeInternal(Node<K, V> node, boolean bl) {
        if (bl) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = null;
            node.next = null;
        }
        Node node2 = node.left;
        Node node3 = node.right;
        Node node4 = node.parent;
        int n = 0;
        if (node2 != null && node3 != null) {
            int n2;
            node4 = node2.height > node3.height ? node2.last() : node3.first();
            this.removeInternal(node4, false);
            node3 = node.left;
            if (node3 != null) {
                n2 = node3.height;
                node4.left = node3;
                node3.parent = node4;
                node.left = null;
            } else {
                n2 = 0;
            }
            node3 = node.right;
            if (node3 != null) {
                n = node3.height;
                node4.right = node3;
                node3.parent = node4;
                node.right = null;
            }
            node4.height = Math.max(n2, n) + 1;
            this.replaceInParent(node, node4);
            return;
        }
        if (node2 != null) {
            this.replaceInParent(node, node2);
            node.left = null;
        } else if (node3 != null) {
            this.replaceInParent(node, node3);
            node.right = null;
        } else {
            this.replaceInParent(node, null);
        }
        this.rebalance(node4, false);
        --this.size;
        ++this.modCount;
    }

    Node<K, V> removeInternalByKey(Object node) {
        if ((node = this.findByObject(node)) == null) return node;
        this.removeInternal(node, true);
        return node;
    }

    @Override
    public int size() {
        return this.size;
    }
}
