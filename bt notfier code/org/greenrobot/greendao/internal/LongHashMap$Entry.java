/*
 * Decompiled with CFR 0.152.
 */
package org.greenrobot.greendao.internal;

static final class LongHashMap.Entry<T> {
    final long key;
    LongHashMap.Entry<T> next;
    T value;

    LongHashMap.Entry(long l, T t, LongHashMap.Entry<T> entry) {
        this.key = l;
        this.value = t;
        this.next = entry;
    }
}
