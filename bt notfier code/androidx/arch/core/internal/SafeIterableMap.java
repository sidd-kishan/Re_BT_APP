/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.arch.core.internal.SafeIterableMap$AscendingIterator
 *  androidx.arch.core.internal.SafeIterableMap$DescendingIterator
 *  androidx.arch.core.internal.SafeIterableMap$Entry
 *  androidx.arch.core.internal.SafeIterableMap$IteratorWithAdditions
 *  androidx.arch.core.internal.SafeIterableMap$SupportRemove
 */
package androidx.arch.core.internal;

import androidx.arch.core.internal.SafeIterableMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

public class SafeIterableMap<K, V>
implements Iterable<Map.Entry<K, V>> {
    private Entry<K, V> mEnd;
    private WeakHashMap<SupportRemove<K, V>, Boolean> mIterators = new WeakHashMap();
    private int mSize = 0;
    Entry<K, V> mStart;

    public Iterator<Map.Entry<K, V>> descendingIterator() {
        DescendingIterator descendingIterator = new DescendingIterator(this.mEnd, this.mStart);
        this.mIterators.put((SupportRemove<DescendingIterator, Boolean>)descendingIterator, false);
        return descendingIterator;
    }

    public Map.Entry<K, V> eldest() {
        return this.mStart;
    }

    public boolean equals(Object iterator) {
        boolean bl = true;
        if (iterator == this) {
            return true;
        }
        if (!(iterator instanceof SafeIterableMap)) {
            return false;
        }
        Object object = (SafeIterableMap)((Object)iterator);
        if (this.size() != ((SafeIterableMap)object).size()) {
            return false;
        }
        iterator = this.iterator();
        Iterator<Map.Entry<K, V>> iterator2 = ((SafeIterableMap)object).iterator();
        while (iterator.hasNext() && iterator2.hasNext()) {
            object = iterator.next();
            Map.Entry<K, V> entry = iterator2.next();
            if (object == null) {
                if (entry != null) return false;
            }
            if (object == null || object.equals(entry)) continue;
            return false;
        }
        if (!iterator.hasNext() && !iterator2.hasNext()) return bl;
        bl = false;
        return bl;
    }

    protected Entry<K, V> get(K k) {
        Entry entry = this.mStart;
        while (entry != null) {
            if (entry.mKey.equals(k)) {
                return entry;
            }
            entry = entry.mNext;
        }
        return entry;
    }

    public int hashCode() {
        Iterator<Map.Entry<K, V>> iterator = this.iterator();
        int n = 0;
        while (iterator.hasNext()) {
            n += iterator.next().hashCode();
        }
        return n;
    }

    @Override
    public Iterator<Map.Entry<K, V>> iterator() {
        AscendingIterator ascendingIterator = new AscendingIterator(this.mStart, this.mEnd);
        this.mIterators.put((SupportRemove<AscendingIterator, Boolean>)ascendingIterator, false);
        return ascendingIterator;
    }

    public IteratorWithAdditions iteratorWithAdditions() {
        IteratorWithAdditions iteratorWithAdditions = new IteratorWithAdditions(this);
        this.mIterators.put((SupportRemove<IteratorWithAdditions, Boolean>)iteratorWithAdditions, false);
        return iteratorWithAdditions;
    }

    public Map.Entry<K, V> newest() {
        return this.mEnd;
    }

    protected Entry<K, V> put(K object, V object2) {
        object2 = new Entry(object, object2);
        ++this.mSize;
        object = this.mEnd;
        if (object == null) {
            this.mStart = object2;
            this.mEnd = object2;
            return object2;
        }
        ((Entry)object).mNext = object2;
        ((Entry)object2).mPrevious = this.mEnd;
        this.mEnd = object2;
        return object2;
    }

    public V putIfAbsent(K k, V v) {
        Entry<K, V> entry = this.get(k);
        if (entry != null) {
            return (V)entry.mValue;
        }
        this.put(k, v);
        return null;
    }

    public V remove(K object) {
        Entry<K, V> entry = this.get(object);
        if (entry == null) {
            return null;
        }
        --this.mSize;
        if (!this.mIterators.isEmpty()) {
            object = this.mIterators.keySet().iterator();
            while (object.hasNext()) {
                ((SupportRemove)object.next()).supportRemove(entry);
            }
        }
        if (entry.mPrevious != null) {
            entry.mPrevious.mNext = entry.mNext;
        } else {
            this.mStart = entry.mNext;
        }
        if (entry.mNext != null) {
            entry.mNext.mPrevious = entry.mPrevious;
        } else {
            this.mEnd = entry.mPrevious;
        }
        entry.mNext = null;
        entry.mPrevious = null;
        return (V)entry.mValue;
    }

    public int size() {
        return this.mSize;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        Iterator<Map.Entry<K, V>> iterator = this.iterator();
        while (true) {
            if (!iterator.hasNext()) {
                stringBuilder.append("]");
                return stringBuilder.toString();
            }
            stringBuilder.append(iterator.next().toString());
            if (!iterator.hasNext()) continue;
            stringBuilder.append(", ");
        }
    }
}
