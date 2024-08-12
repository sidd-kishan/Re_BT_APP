/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.greenrobot.greendao.DaoLog
 *  org.greenrobot.greendao.internal.LongHashMap$Entry
 */
package org.greenrobot.greendao.internal;

import java.util.Arrays;
import org.greenrobot.greendao.DaoLog;
import org.greenrobot.greendao.internal.LongHashMap;

public final class LongHashMap<T> {
    private int capacity;
    private int size;
    private Entry<T>[] table;
    private int threshold;

    public LongHashMap() {
        this(16);
    }

    public LongHashMap(int n) {
        this.capacity = n;
        this.threshold = n * 4 / 3;
        this.table = new Entry[n];
    }

    public void clear() {
        this.size = 0;
        Arrays.fill(this.table, null);
    }

    public boolean containsKey(long l) {
        int n = (int)(l >>> 32);
        int n2 = (int)l;
        int n3 = this.capacity;
        Entry entry = this.table[((n2 ^ n) & Integer.MAX_VALUE) % n3];
        while (entry != null) {
            if (entry.key == l) {
                return true;
            }
            entry = entry.next;
        }
        return false;
    }

    public T get(long l) {
        int n = (int)(l >>> 32);
        int n2 = (int)l;
        int n3 = this.capacity;
        Entry entry = this.table[((n2 ^ n) & Integer.MAX_VALUE) % n3];
        while (entry != null) {
            if (entry.key == l) {
                return (T)entry.value;
            }
            entry = entry.next;
        }
        return null;
    }

    public void logStats() {
        Entry<T>[] entryArray = this.table;
        int n = entryArray.length;
        int n2 = 0;
        int n3 = 0;
        while (true) {
            Object object;
            if (n2 >= n) {
                object = new StringBuilder();
                ((StringBuilder)object).append("load: ");
                ((StringBuilder)object).append((float)this.size / (float)this.capacity);
                ((StringBuilder)object).append(", size: ");
                ((StringBuilder)object).append(this.size);
                ((StringBuilder)object).append(", capa: ");
                ((StringBuilder)object).append(this.capacity);
                ((StringBuilder)object).append(", collisions: ");
                ((StringBuilder)object).append(n3);
                ((StringBuilder)object).append(", collision ratio: ");
                ((StringBuilder)object).append((float)n3 / (float)this.size);
                DaoLog.d((String)((StringBuilder)object).toString());
                return;
            }
            object = entryArray[n2];
            while (object != null && ((Entry)object).next != null) {
                ++n3;
                object = ((Entry)object).next;
            }
            ++n2;
        }
    }

    public T put(long l, T t) {
        Object object;
        int n = (int)(l >>> 32);
        n = (((int)l ^ n) & Integer.MAX_VALUE) % this.capacity;
        Entry entry = object = this.table[n];
        while (true) {
            if (entry == null) {
                this.table[n] = new Entry(l, t, object);
                this.size = n = this.size + 1;
                if (n <= this.threshold) return null;
                this.setCapacity(this.capacity * 2);
                return null;
            }
            if (entry.key == l) {
                object = entry.value;
                entry.value = t;
                return (T)object;
            }
            entry = entry.next;
        }
    }

    public T remove(long l) {
        Entry entry;
        block4: {
            int n = (int)(l >>> 32);
            n = (((int)l ^ n) & Integer.MAX_VALUE) % this.capacity;
            entry = this.table[n];
            Entry entry2 = null;
            while (entry != null) {
                Entry entry3 = entry.next;
                if (entry.key == l) {
                    if (entry2 == null) {
                        this.table[n] = entry3;
                    } else {
                        entry2.next = entry3;
                    }
                    break block4;
                }
                entry2 = entry;
                entry = entry3;
            }
            return null;
        }
        --this.size;
        return (T)entry.value;
    }

    public void reserveRoom(int n) {
        this.setCapacity(n * 5 / 3);
    }

    public void setCapacity(int n) {
        Entry[] entryArray = new Entry[n];
        int n2 = this.table.length;
        int n3 = 0;
        while (true) {
            if (n3 >= n2) {
                this.table = entryArray;
                this.capacity = n;
                this.threshold = n * 4 / 3;
                return;
            }
            Entry entry = this.table[n3];
            while (entry != null) {
                long l = entry.key;
                int n4 = (((int)(l >>> 32) ^ (int)l) & Integer.MAX_VALUE) % n;
                Entry entry2 = entry.next;
                entry.next = entryArray[n4];
                entryArray[n4] = entry;
                entry = entry2;
            }
            ++n3;
        }
    }

    public int size() {
        return this.size;
    }
}
