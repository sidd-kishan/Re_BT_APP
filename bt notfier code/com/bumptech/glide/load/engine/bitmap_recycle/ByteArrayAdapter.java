/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.engine.bitmap_recycle.ArrayAdapterInterface
 */
package com.bumptech.glide.load.engine.bitmap_recycle;

import com.bumptech.glide.load.engine.bitmap_recycle.ArrayAdapterInterface;

public final class ByteArrayAdapter
implements ArrayAdapterInterface<byte[]> {
    private static final String TAG = "ByteArrayPool";

    public int getArrayLength(byte[] byArray) {
        return byArray.length;
    }

    public int getElementSizeInBytes() {
        return 1;
    }

    public String getTag() {
        return TAG;
    }

    public byte[] newArray(int n) {
        return new byte[n];
    }
}
