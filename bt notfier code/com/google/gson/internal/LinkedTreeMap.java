/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public final class LinkedTreeMap<K, V>
extends AbstractMap<K, V>
implements Serializable {
    static final boolean $assertionsDisabled = false;
    private static final Comparator<Comparable> NATURAL_ORDER = new Comparator<Comparable>(){

        @Override
        public int compare(Comparable a, Comparable b) {
            return a.compareTo(b);
        }
    };
    Comparator<? super K> comparator;
    private EntrySet entrySet;
    final Node<K, V> header = new Node();
    private KeySet keySet;
    int modCount = 0;
    Node<K, V> root;
    int size = 0;

    public LinkedTreeMap() {
        this(NATURAL_ORDER);
    }

    public LinkedTreeMap(Comparator<? super K> comparator) {
        if (comparator == null) {
            comparator = NATURAL_ORDER;
        }
        this.comparator = comparator;
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
                node2 = node4.left;
                node3 = node4.right;
                n3 = node3 != null ? node3.height : 0;
                n4 = n2;
                if (node2 != null) {
                    n4 = node2.height;
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
                node2 = node3.left;
                node4 = node3.right;
                n3 = node4 != null ? node4.height : 0;
                n4 = n;
                if (node2 != null) {
                    n4 = node2.height;
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

    private void replaceInParent(Node<K, V> node, Node<K, V> node2) {
        Node node3 = node.parent;
        node.parent = null;
        if (node2 != null) {
            node2.parent = node3;
        }
        if (node3 != null) {
            if (node3.left == node) {
                node3.left = node2;
            } else {
                node3.right = node2;
            }
        } else {
            this.root = node2;
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
        Node node2 = node.left;
        Node node3 = node.right;
        Node node4 = node2.left;
        Node node5 = node2.right;
        node.left = node5;
        if (node5 != null) {
            node5.parent = node;
        }
        this.replaceInParent(node, node2);
        node2.right = node;
        node.parent = node2;
        int n = 0;
        int n2 = node3 != null ? node3.height : 0;
        int n3 = node5 != null ? node5.height : 0;
        n3 = node.height = Math.max(n2, n3) + 1;
        n2 = n;
        if (node4 != null) {
            n2 = node4.height;
        }
        node2.height = Math.max(n3, n2) + 1;
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }

    @Override
    public void clear() {
        this.root = null;
        this.size = 0;
        ++this.modCount;
        Node<K, V> node = this.header;
        node.prev = node;
        node.next = node;
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
        this.entrySet = entrySet = new EntrySet();
        return entrySet;
    }

    Node<K, V> find(K object, boolean bl) {
        Node<K, V> node;
        int n;
        Comparator<K> comparator = this.comparator;
        Node<K, V> node2 = this.root;
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
                ((StringBuilder)((Object)node2)).append(object.getClass().getName());
                ((StringBuilder)((Object)node2)).append(" is not Comparable");
                throw new ClassCastException(((StringBuilder)((Object)node2)).toString());
            }
            object = new Node(node2, object, node, node.prev);
            this.root = object;
        } else {
            object = new Node(node2, object, node, node.prev);
            if (n < 0) {
                node2.left = object;
            } else {
                node2.right = object;
            }
            this.rebalance(node2, true);
        }
        ++this.size;
        ++this.modCount;
        return object;
    }

    Node<K, V> findByEntry(Map.Entry<?, ?> entry) {
        Node<?, ?> node = this.findByObject(entry.getKey());
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
    public V get(Object node) {
        node = (node = this.findByObject(node)) != null ? node.value : null;
        return (V)node;
    }

    @Override
    public Set<K> keySet() {
        KeySet keySet = this.keySet;
        if (keySet != null) return keySet;
        this.keySet = keySet = new KeySet();
        return keySet;
    }

    @Override
    public V put(K object, V v) {
        if (object == null) throw new NullPointerException("key == null");
        object = this.find(object, true);
        Object v2 = ((Node)object).value;
        ((Node)object).value = v;
        return v2;
    }

    @Override
    public V remove(Object node) {
        node = (node = this.removeInternalByKey(node)) != null ? node.value : null;
        return (V)node;
    }

    void removeInternal(Node<K, V> node, boolean bl) {
        if (bl) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
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

    class EntrySet
    extends AbstractSet<Map.Entry<K, V>> {
        EntrySet() {
        }

        @Override
        public int size() {
            return LinkedTreeMap.this.size;
        }

        @Override
        public Iterator<Map.Entry<K, V>> iterator() {
            return new LinkedTreeMapIterator<Map.Entry<K, V>>(){

                @Override
                public Map.Entry<K, V> next() {
                    return this.nextNode();
                }
            };
        }

        @Override
        public boolean contains(Object o) {
            return o instanceof Map.Entry && LinkedTreeMap.this.findByEntry((Map.Entry)o) != null;
        }

        @Override
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Node node = LinkedTreeMap.this.findByEntry((Map.Entry)o);
            if (node == null) {
                return false;
            }
            LinkedTreeMap.this.removeInternal(node, true);
            return true;
        }

        @Override
        public void clear() {
            LinkedTreeMap.this.clear();
        }
    }

    final class KeySet
    extends AbstractSet<K> {
        KeySet() {
        }

        @Override
        public int size() {
            return LinkedTreeMap.this.size;
        }

        @Override
        public Iterator<K> iterator() {
            return new LinkedTreeMapIterator<K>(){

                @Override
                public K next() {
                    return this.nextNode().key;
                }
            };
        }

        @Override
        public boolean contains(Object o) {
            return LinkedTreeMap.this.containsKey(o);
        }

        @Override
        public boolean remove(Object key) {
            return LinkedTreeMap.this.removeInternalByKey(key) != null;
        }

        @Override
        public void clear() {
            LinkedTreeMap.this.clear();
        }
    }

    private abstract class LinkedTreeMapIterator<T>
    implements Iterator<T> {
        Node<K, V> next;
        Node<K, V> lastReturned;
        int expectedModCount;

        LinkedTreeMapIterator() {
            this.next = LinkedTreeMap.this.header.next;
            this.lastReturned = null;
            this.expectedModCount = LinkedTreeMap.this.modCount;
        }

        @Override
        public final boolean hasNext() {
            return this.next != LinkedTreeMap.this.header;
        }

        final Node<K, V> nextNode() {
            Node e = this.next;
            if (e == LinkedTreeMap.this.header) {
                throw new NoSuchElementException();
            }
            if (LinkedTreeMap.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
            this.next = e.next;
            this.lastReturned = e;
            return this.lastReturned;
        }

        @Override
        public final void remove() {
            if (this.lastReturned == null) {
                throw new IllegalStateException();
            }
            LinkedTreeMap.this.removeInternal(this.lastReturned, true);
            this.lastReturned = null;
            this.expectedModCount = LinkedTreeMap.this.modCount;
        }
    }

    static final class Node<K, V>
    implements Map.Entry<K, V> {
        Node<K, V> parent;
        Node<K, V> left;
        Node<K, V> right;
        Node<K, V> next;
        Node<K, V> prev;
        final K key;
        final boolean allowNullValue;
        V value;
        int height;

        Node(boolean allowNullValue) {
            this.key = null;
            this.allowNullValue = allowNullValue;
            this.next = this.prev = this;
        }

        Node(boolean allowNullValue, Node<K, V> parent, K key, Node<K, V> next, Node<K, V> prev) {
            this.parent = parent;
            this.key = key;
            this.allowNullValue = allowNullValue;
            this.height = 1;
            this.next = next;
            this.prev = prev;
            prev.next = this;
            next.prev = this;
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
        public V setValue(V value) {
            if (value == null && !this.allowNullValue) {
                throw new NullPointerException("value == null");
            }
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry)) return false;
            Map.Entry other = (Map.Entry)o;
            return (this.key == null ? other.getKey() == null : this.key.equals(other.getKey())) && (this.value == null ? other.getValue() == null : this.value.equals(other.getValue()));
        }

        @Override
        public int hashCode() {
            return (this.key == null ? 0 : this.key.hashCode()) ^ (this.value == null ? 0 : this.value.hashCode());
        }

        public String toString() {
            return this.key + "=" + this.value;
        }

        public Node<K, V> first() {
            Node<K, V> node = this;
            Node<K, V> child = node.left;
            while (child != null) {
                node = child;
                child = node.left;
            }
            return node;
        }

        public Node<K, V> last() {
            Node<K, V> node = this;
            Node<K, V> child = node.right;
            while (child != null) {
                node = child;
                child = node.right;
            }
            return node;
        }
    }
}
