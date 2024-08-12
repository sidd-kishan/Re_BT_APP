/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.recyclerview.widget.StableIdStorage
 *  androidx.recyclerview.widget.StableIdStorage$StableIdLookup
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.StableIdStorage;

public static class StableIdStorage.SharedPoolStableIdStorage
implements StableIdStorage {
    private final StableIdStorage.StableIdLookup mSameIdLookup = new /* Unavailable Anonymous Inner Class!! */;

    public StableIdStorage.StableIdLookup createStableIdLookup() {
        return this.mSameIdLookup;
    }
}
