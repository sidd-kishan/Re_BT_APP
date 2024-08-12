/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.arch.core.internal.SafeIterableMap
 *  androidx.arch.core.internal.SafeIterableMap$Entry
 *  androidx.arch.core.internal.SafeIterableMap$SupportRemove
 */
package androidx.arch.core.internal;

import androidx.arch.core.internal.SafeIterableMap;
import java.util.Iterator;
import java.util.Map;

private class SafeIterableMap.IteratorWithAdditions
implements Iterator<Map.Entry<K, V>>,
SafeIterableMap.SupportRemove<K, V> {
    private boolean mBeforeStart;
    private SafeIterableMap.Entry<K, V> mCurrent;
    final SafeIterableMap this$0;

    SafeIterableMap.IteratorWithAdditions(SafeIterableMap safeIterableMap) {
        this.this$0 = safeIterableMap;
        this.mBeforeStart = true;
    }

    @Override
    public boolean hasNext() {
        boolean bl = this.mBeforeStart;
        boolean bl2 = true;
        boolean bl3 = true;
        if (bl) {
            bl2 = this.this$0.mStart != null ? bl3 : false;
            return bl2;
        }
        SafeIterableMap.Entry entry = this.mCurrent;
        if (entry != null && entry.mNext != null) return bl2;
        bl2 = false;
        return bl2;
    }

    @Override
    public Map.Entry<K, V> next() {
        if (this.mBeforeStart) {
            this.mBeforeStart = false;
            this.mCurrent = this.this$0.mStart;
        } else {
            Object object = this.mCurrent;
            object = object != null ? object.mNext : null;
            this.mCurrent = object;
        }
        return this.mCurrent;
    }

    public void supportRemove(SafeIterableMap.Entry<K, V> entry) {
        SafeIterableMap.Entry entry2 = this.mCurrent;
        if (entry != entry2) return;
        this.mCurrent = entry = entry2.mPrevious;
        boolean bl = entry == null;
        this.mBeforeStart = bl;
    }
}
