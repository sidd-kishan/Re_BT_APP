/*
 * Decompiled with CFR 0.152.
 */
package androidx.arch.core.internal;

import java.util.Map;

static class SafeIterableMap.Entry<K, V>
implements Map.Entry<K, V> {
    final K mKey;
    SafeIterableMap.Entry<K, V> mNext;
    SafeIterableMap.Entry<K, V> mPrevious;
    final V mValue;

    SafeIterableMap.Entry(K k, V v) {
        this.mKey = k;
        this.mValue = v;
    }

    @Override
    public boolean equals(Object object) {
        boolean bl = true;
        if (object == this) {
            return true;
        }
        if (!(object instanceof SafeIterableMap.Entry)) {
            return false;
        }
        object = (SafeIterableMap.Entry)object;
        if (this.mKey.equals(((SafeIterableMap.Entry)object).mKey) && this.mValue.equals(((SafeIterableMap.Entry)object).mValue)) return bl;
        bl = false;
        return bl;
    }

    @Override
    public K getKey() {
        return this.mKey;
    }

    @Override
    public V getValue() {
        return this.mValue;
    }

    @Override
    public int hashCode() {
        return this.mKey.hashCode() ^ this.mValue.hashCode();
    }

    @Override
    public V setValue(V v) {
        throw new UnsupportedOperationException("An entry modification is not supported");
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.mKey);
        stringBuilder.append("=");
        stringBuilder.append(this.mValue);
        return stringBuilder.toString();
    }
}
