/*
 * Decompiled with CFR 0.152.
 */
package com.yalantis.ucrop.util;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

private static class ImageHeaderParser.RandomAccessReader {
    private final ByteBuffer data;

    public ImageHeaderParser.RandomAccessReader(byte[] byArray, int n) {
        this.data = (ByteBuffer)ByteBuffer.wrap(byArray).order(ByteOrder.BIG_ENDIAN).limit(n);
    }

    public short getInt16(int n) {
        return this.data.getShort(n);
    }

    public int getInt32(int n) {
        return this.data.getInt(n);
    }

    public int length() {
        return this.data.remaining();
    }

    public void order(ByteOrder byteOrder) {
        this.data.order(byteOrder);
    }
}
