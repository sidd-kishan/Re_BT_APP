/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.arch.core.internal.SafeIterableMap$Entry
 *  androidx.arch.core.internal.SafeIterableMap$ListIterator
 */
package androidx.arch.core.internal;

import androidx.arch.core.internal.SafeIterableMap;

private static class SafeIterableMap.DescendingIterator<K, V>
extends SafeIterableMap.ListIterator<K, V> {
    SafeIterableMap.DescendingIterator(SafeIterableMap.Entry<K, V> entry, SafeIterableMap.Entry<K, V> entry2) {
        super(entry, entry2);
    }

    SafeIterableMap.Entry<K, V> backward(SafeIterableMap.Entry<K, V> entry) {
        return entry.mNext;
    }

    SafeIterableMap.Entry<K, V> forward(SafeIterableMap.Entry<K, V> entry) {
        return entry.mPrevious;
    }
}