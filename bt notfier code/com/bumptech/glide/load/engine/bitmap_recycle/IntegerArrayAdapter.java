/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.engine.bitmap_recycle.ArrayAdapterInterface
 */
package com.bumptech.glide.load.engine.bitmap_recycle;

import com.bumptech.glide.load.engine.bitmap_recycle.ArrayAdapterInterface;

public final class IntegerArrayAdapter
implements ArrayAdapterInterface<int[]> {
    private static final String TAG = "IntegerArrayPool";

    public int getArrayLength(int[] nArray) {
        return nArray.length;
    }

    public int getElementSizeInBytes() {
        return 4;
    }

    public String getTag() {
        return TAG;
    }

    public int[] newArray(int n) {
        return new int[n];
    }
}
