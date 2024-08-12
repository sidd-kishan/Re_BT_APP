/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.engine.Resource
 *  com.bumptech.glide.util.Preconditions
 */
package com.bumptech.glide.load.resource.bytes;

import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;

public class BytesResource
implements Resource<byte[]> {
    private final byte[] bytes;

    public BytesResource(byte[] byArray) {
        this.bytes = (byte[])Preconditions.checkNotNull((Object)byArray);
    }

    public byte[] get() {
        return this.bytes;
    }

    public Class<byte[]> getResourceClass() {
        return byte[].class;
    }

    public int getSize() {
        return this.bytes.length;
    }

    public void recycle() {
    }
}
