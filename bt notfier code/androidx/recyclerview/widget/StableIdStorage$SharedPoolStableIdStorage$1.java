/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.recyclerview.widget.StableIdStorage$SharedPoolStableIdStorage
 *  androidx.recyclerview.widget.StableIdStorage$StableIdLookup
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.StableIdStorage;

class StableIdStorage.SharedPoolStableIdStorage.1
implements StableIdStorage.StableIdLookup {
    final StableIdStorage.SharedPoolStableIdStorage this$0;

    StableIdStorage.SharedPoolStableIdStorage.1(StableIdStorage.SharedPoolStableIdStorage sharedPoolStableIdStorage) {
        this.this$0 = sharedPoolStableIdStorage;
    }

    public long localToGlobal(long l) {
        return l;
    }
}
