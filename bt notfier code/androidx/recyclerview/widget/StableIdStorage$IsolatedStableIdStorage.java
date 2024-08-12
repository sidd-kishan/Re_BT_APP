/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.recyclerview.widget.StableIdStorage
 *  androidx.recyclerview.widget.StableIdStorage$IsolatedStableIdStorage$WrapperStableIdLookup
 *  androidx.recyclerview.widget.StableIdStorage$StableIdLookup
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.StableIdStorage;

public static class StableIdStorage.IsolatedStableIdStorage
implements StableIdStorage {
    long mNextStableId = 0L;

    public StableIdStorage.StableIdLookup createStableIdLookup() {
        return new WrapperStableIdLookup(this);
    }

    long obtainId() {
        long l = this.mNextStableId;
        this.mNextStableId = 1L + l;
        return l;
    }
}
