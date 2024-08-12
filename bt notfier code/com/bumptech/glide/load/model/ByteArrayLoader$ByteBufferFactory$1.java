/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.model.ByteArrayLoader$ByteBufferFactory
 *  com.bumptech.glide.load.model.ByteArrayLoader$Converter
 */
package com.bumptech.glide.load.model;

import com.bumptech.glide.load.model.ByteArrayLoader;
import java.nio.ByteBuffer;

class ByteArrayLoader.ByteBufferFactory.1
implements ByteArrayLoader.Converter<ByteBuffer> {
    final ByteArrayLoader.ByteBufferFactory this$0;

    ByteArrayLoader.ByteBufferFactory.1(ByteArrayLoader.ByteBufferFactory byteBufferFactory) {
        this.this$0 = byteBufferFactory;
    }

    public ByteBuffer convert(byte[] byArray) {
        return ByteBuffer.wrap(byArray);
    }

    public Class<ByteBuffer> getDataClass() {
        return ByteBuffer.class;
    }
}
