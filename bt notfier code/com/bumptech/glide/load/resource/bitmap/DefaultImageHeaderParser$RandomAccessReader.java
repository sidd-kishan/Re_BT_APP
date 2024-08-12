/*
 * Decompiled with CFR 0.152.
 */
package com.bumptech.glide.load.resource.bitmap;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

private static final class DefaultImageHeaderParser.RandomAccessReader {
    private final ByteBuffer data;

    DefaultImageHeaderParser.RandomAccessReader(byte[] byArray, int n) {
        this.data = (ByteBuffer)ByteBuffer.wrap(byArray).order(ByteOrder.BIG_ENDIAN).limit(n);
    }

    private boolean isAvailable(int n, int n2) {
        boolean bl = this.data.remaining() - n >= n2;
        return bl;
    }

    short getInt16(int n) {
        short s = this.isAvailable(n, 2) ? this.data.getShort(n) : (short)-1;
        return s;
    }

    int getInt32(int n) {
        n = this.isAvailable(n, 4) ? this.data.getInt(n) : -1;
        return n;
    }

    int length() {
        return this.data.remaining();
    }

    void order(ByteOrder byteOrder) {
        this.data.order(byteOrder);
    }
}
