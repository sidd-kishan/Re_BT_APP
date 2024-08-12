/*
 * Decompiled with CFR 0.152.
 */
package androidx.camera.core.impl.utils;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteOrder;

class ByteOrderedDataOutputStream
extends FilterOutputStream {
    private ByteOrder mByteOrder;
    final OutputStream mOutputStream;

    ByteOrderedDataOutputStream(OutputStream outputStream, ByteOrder byteOrder) {
        super(outputStream);
        this.mOutputStream = outputStream;
        this.mByteOrder = byteOrder;
    }

    public void setByteOrder(ByteOrder byteOrder) {
        this.mByteOrder = byteOrder;
    }

    @Override
    public void write(byte[] byArray) throws IOException {
        this.mOutputStream.write(byArray);
    }

    @Override
    public void write(byte[] byArray, int n, int n2) throws IOException {
        this.mOutputStream.write(byArray, n, n2);
    }

    public void writeByte(int n) throws IOException {
        this.mOutputStream.write(n);
    }

    public void writeInt(int n) throws IOException {
        if (this.mByteOrder == ByteOrder.LITTLE_ENDIAN) {
            this.mOutputStream.write(n >>> 0 & 0xFF);
            this.mOutputStream.write(n >>> 8 & 0xFF);
            this.mOutputStream.write(n >>> 16 & 0xFF);
            this.mOutputStream.write(n >>> 24 & 0xFF);
        } else {
            if (this.mByteOrder != ByteOrder.BIG_ENDIAN) return;
            this.mOutputStream.write(n >>> 24 & 0xFF);
            this.mOutputStream.write(n >>> 16 & 0xFF);
            this.mOutputStream.write(n >>> 8 & 0xFF);
            this.mOutputStream.write(n >>> 0 & 0xFF);
        }
    }

    public void writeShort(short s) throws IOException {
        if (this.mByteOrder == ByteOrder.LITTLE_ENDIAN) {
            this.mOutputStream.write(s >>> 0 & 0xFF);
            this.mOutputStream.write(s >>> 8 & 0xFF);
        } else {
            if (this.mByteOrder != ByteOrder.BIG_ENDIAN) return;
            this.mOutputStream.write(s >>> 8 & 0xFF);
            this.mOutputStream.write(s >>> 0 & 0xFF);
        }
    }

    public void writeUnsignedInt(long l) throws IOException {
        this.writeInt((int)l);
    }

    public void writeUnsignedShort(int n) throws IOException {
        this.writeShort((short)n);
    }
}
