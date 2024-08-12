/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.collection.LongSparseArray
 *  androidx.recyclerview.widget.StableIdStorage$IsolatedStableIdStorage
 *  androidx.recyclerview.widget.StableIdStorage$StableIdLookup
 */
package androidx.recyclerview.widget;

import androidx.collection.LongSparseArray;
import androidx.recyclerview.widget.StableIdStorage;

class StableIdStorage.IsolatedStableIdStorage.WrapperStableIdLookup
implements StableIdStorage.StableIdLookup {
    private final LongSparseArray<Long> mLocalToGlobalLookup;
    final StableIdStorage.IsolatedStableIdStorage this$0;

    StableIdStorage.IsolatedStableIdStorage.WrapperStableIdLookup(StableIdStorage.IsolatedStableIdStorage isolatedStableIdStorage) {
        this.this$0 = isolatedStableIdStorage;
        this.mLocalToGlobalLookup = new LongSparseArray();
    }

    public long localToGlobal(long l) {
        Long l2;
        Long l3 = l2 = (Long)this.mLocalToGlobalLookup.get(l);
        if (l2 != null) return l3;
        l3 = this.this$0.obtainId();
        this.mLocalToGlobalLookup.put(l, (Object)l3);
        return l3;
    }
}
