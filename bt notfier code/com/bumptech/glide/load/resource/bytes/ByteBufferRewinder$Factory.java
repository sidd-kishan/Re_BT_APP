/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.data.DataRewinder
 *  com.bumptech.glide.load.data.DataRewinder$Factory
 *  com.bumptech.glide.load.resource.bytes.ByteBufferRewinder
 */
package com.bumptech.glide.load.resource.bytes;

import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.resource.bytes.ByteBufferRewinder;
import java.nio.ByteBuffer;

public static class ByteBufferRewinder.Factory
implements DataRewinder.Factory<ByteBuffer> {
    public DataRewinder<ByteBuffer> build(ByteBuffer byteBuffer) {
        return new ByteBufferRewinder(byteBuffer);
    }

    public Class<ByteBuffer> getDataClass() {
        return ByteBuffer.class;
    }
}
