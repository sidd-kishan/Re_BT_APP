/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.arch.core.internal.SafeIterableMap$Entry
 *  androidx.arch.core.internal.SafeIterableMap$SupportRemove
 */
package androidx.arch.core.internal;

import androidx.arch.core.internal.SafeIterableMap;
import java.util.Iterator;
import java.util.Map;

private static abstract class SafeIterableMap.ListIterator<K, V>
implements Iterator<Map.Entry<K, V>>,
SafeIterableMap.SupportRemove<K, V> {
    SafeIterableMap.Entry<K, V> mExpectedEnd;
    SafeIterableMap.Entry<K, V> mNext;

    SafeIterableMap.ListIterator(SafeIterableMap.Entry<K, V> entry, SafeIterableMap.Entry<K, V> entry2) {
        this.mExpectedEnd = entry2;
        this.mNext = entry;
    }

    private SafeIterableMap.Entry<K, V> nextNode() {
        SafeIterableMap.Entry<K, V> entry = this.mNext;
        SafeIterableMap.Entry<K, V> entry2 = this.mExpectedEnd;
        if (entry == entry2) return null;
        if (entry2 != null) return this.forward(entry);
        return null;
    }

    abstract SafeIterableMap.Entry<K, V> backward(SafeIterableMap.Entry<K, V> var1);

    abstract SafeIterableMap.Entry<K, V> forward(SafeIterableMap.Entry<K, V> var1);

    @Override
    public boolean hasNext() {
        boolean bl = this.mNext != null;
        return bl;
    }

    @Override
    public Map.Entry<K, V> next() {
        SafeIterableMap.Entry<K, V> entry = this.mNext;
        this.mNext = this.nextNode();
        return entry;
    }

    public void supportRemove(SafeIterableMap.Entry<K, V> entry) {
        SafeIterableMap.Entry<K, V> entry2;
        if (this.mExpectedEnd == entry && entry == this.mNext) {
            this.mNext = null;
            this.mExpectedEnd = null;
        }
        if ((entry2 = this.mExpectedEnd) == entry) {
            this.mExpectedEnd = this.backward(entry2);
        }
        if (this.mNext != entry) return;
        this.mNext = this.nextNode();
    }
}
