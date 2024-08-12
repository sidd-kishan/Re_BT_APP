/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser$Reader
 */
package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

private static final class DefaultImageHeaderParser.ByteBufferReader
implements DefaultImageHeaderParser.Reader {
    private final ByteBuffer byteBuffer;

    DefaultImageHeaderParser.ByteBufferReader(ByteBuffer byteBuffer) {
        this.byteBuffer = byteBuffer;
        byteBuffer.order(ByteOrder.BIG_ENDIAN);
    }

    public int getByte() throws IOException {
        if (this.byteBuffer.remaining() >= 1) return this.byteBuffer.get();
        return -1;
    }

    public int getUInt16() throws IOException {
        return this.getByte() << 8 & 0xFF00 | this.getByte() & 0xFF;
    }

    public short getUInt8() throws IOException {
        return (short)(this.getByte() & 0xFF);
    }

    public int read(byte[] byArray, int n) throws IOException {
        if ((n = Math.min(n, this.byteBuffer.remaining())) == 0) {
            return -1;
        }
        this.byteBuffer.get(byArray, 0, n);
        return n;
    }

    public long skip(long l) throws IOException {
        int n = (int)Math.min((long)this.byteBuffer.remaining(), l);
        ByteBuffer byteBuffer = this.byteBuffer;
        byteBuffer.position(byteBuffer.position() + n);
        return n;
    }
}
