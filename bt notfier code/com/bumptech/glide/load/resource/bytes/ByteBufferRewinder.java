/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.data.DataRewinder
 */
package com.bumptech.glide.load.resource.bytes;

import com.bumptech.glide.load.data.DataRewinder;
import java.nio.ByteBuffer;

public class ByteBufferRewinder
implements DataRewinder<ByteBuffer> {
    private final ByteBuffer buffer;

    public ByteBufferRewinder(ByteBuffer byteBuffer) {
        this.buffer = byteBuffer;
    }

    public void cleanup() {
    }

    public ByteBuffer rewindAndGet() {
        this.buffer.position(0);
        return this.buffer;
    }
}
