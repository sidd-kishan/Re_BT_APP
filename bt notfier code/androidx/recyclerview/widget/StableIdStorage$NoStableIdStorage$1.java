/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.recyclerview.widget.StableIdStorage$NoStableIdStorage
 *  androidx.recyclerview.widget.StableIdStorage$StableIdLookup
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.StableIdStorage;

class StableIdStorage.NoStableIdStorage.1
implements StableIdStorage.StableIdLookup {
    final StableIdStorage.NoStableIdStorage this$0;

    StableIdStorage.NoStableIdStorage.1(StableIdStorage.NoStableIdStorage noStableIdStorage) {
        this.this$0 = noStableIdStorage;
    }

    public long localToGlobal(long l) {
        return -1L;
    }
}
