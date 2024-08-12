/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.engine.bitmap_recycle.GroupedLinkedMap$LinkedEntry
 *  com.bumptech.glide.load.engine.bitmap_recycle.Poolable
 */
package com.bumptech.glide.load.engine.bitmap_recycle;

import com.bumptech.glide.load.engine.bitmap_recycle.GroupedLinkedMap;
import com.bumptech.glide.load.engine.bitmap_recycle.Poolable;
import java.util.HashMap;
import java.util.Map;

class GroupedLinkedMap<K extends Poolable, V> {
    private final LinkedEntry<K, V> head = new LinkedEntry();
    private final Map<K, LinkedEntry<K, V>> keyToEntry = new HashMap<K, LinkedEntry<K, V>>();

    GroupedLinkedMap() {
    }

    private void makeHead(LinkedEntry<K, V> linkedEntry) {
        GroupedLinkedMap.removeEntry(linkedEntry);
        linkedEntry.prev = this.head;
        linkedEntry.next = this.head.next;
        GroupedLinkedMap.updateEntry(linkedEntry);
    }

    private void makeTail(LinkedEntry<K, V> linkedEntry) {
        GroupedLinkedMap.removeEntry(linkedEntry);
        linkedEntry.prev = this.head.prev;
        linkedEntry.next = this.head;
        GroupedLinkedMap.updateEntry(linkedEntry);
    }

    private static <K, V> void removeEntry(LinkedEntry<K, V> linkedEntry) {
        linkedEntry.prev.next = linkedEntry.next;
        linkedEntry.next.prev = linkedEntry.prev;
    }

    private static <K, V> void updateEntry(LinkedEntry<K, V> linkedEntry) {
        linkedEntry.next.prev = linkedEntry;
        linkedEntry.prev.next = linkedEntry;
    }

    public V get(K object) {
        LinkedEntry linkedEntry = this.keyToEntry.get(object);
        if (linkedEntry == null) {
            linkedEntry = new LinkedEntry(object);
            this.keyToEntry.put(object, linkedEntry);
            object = linkedEntry;
        } else {
            object.offer();
            object = linkedEntry;
        }
        this.makeHead((LinkedEntry<K, V>)object);
        return (V)object.removeLast();
    }

    public void put(K object, V v) {
        LinkedEntry linkedEntry = this.keyToEntry.get(object);
        if (linkedEntry == null) {
            linkedEntry = new LinkedEntry(object);
            this.makeTail(linkedEntry);
            this.keyToEntry.put(object, linkedEntry);
            object = linkedEntry;
        } else {
            object.offer();
            object = linkedEntry;
        }
        object.add(v);
    }

    public V removeLast() {
        LinkedEntry linkedEntry = this.head.prev;
        while (!linkedEntry.equals(this.head)) {
            Object object = linkedEntry.removeLast();
            if (object != null) {
                return (V)object;
            }
            GroupedLinkedMap.removeEntry(linkedEntry);
            this.keyToEntry.remove(linkedEntry.key);
            ((Poolable)linkedEntry.key).offer();
            linkedEntry = linkedEntry.prev;
        }
        return null;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("GroupedLinkedMap( ");
        LinkedEntry linkedEntry = this.head.next;
        boolean bl = false;
        while (!linkedEntry.equals(this.head)) {
            bl = true;
            stringBuilder.append('{');
            stringBuilder.append(linkedEntry.key);
            stringBuilder.append(':');
            stringBuilder.append(linkedEntry.size());
            stringBuilder.append("}, ");
            linkedEntry = linkedEntry.next;
        }
        if (bl) {
            stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        }
        stringBuilder.append(" )");
        return stringBuilder.toString();
    }
}
