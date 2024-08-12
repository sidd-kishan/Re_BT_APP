/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.recyclerview.widget.StableIdStorage
 *  androidx.recyclerview.widget.StableIdStorage$StableIdLookup
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.StableIdStorage;

public static class StableIdStorage.NoStableIdStorage
implements StableIdStorage {
    private final StableIdStorage.StableIdLookup mNoIdLookup = new /* Unavailable Anonymous Inner Class!! */;

    public StableIdStorage.StableIdLookup createStableIdLookup() {
        return this.mNoIdLookup;
    }
}
