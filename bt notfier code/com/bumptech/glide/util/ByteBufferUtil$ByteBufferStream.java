/*
 * Decompiled with CFR 0.152.
 */
package com.bumptech.glide.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

private static class ByteBufferUtil.ByteBufferStream
extends InputStream {
    private static final int UNSET = -1;
    private final ByteBuffer byteBuffer;
    private int markPos = -1;

    ByteBufferUtil.ByteBufferStream(ByteBuffer byteBuffer) {
        this.byteBuffer = byteBuffer;
    }

    @Override
    public int available() {
        return this.byteBuffer.remaining();
    }

    @Override
    public void mark(int n) {
        synchronized (this) {
            this.markPos = this.byteBuffer.position();
            return;
        }
    }

    @Override
    public boolean markSupported() {
        return true;
    }

    @Override
    public int read() {
        if (this.byteBuffer.hasRemaining()) return this.byteBuffer.get();
        return -1;
    }

    @Override
    public int read(byte[] byArray, int n, int n2) throws IOException {
        if (!this.byteBuffer.hasRemaining()) {
            return -1;
        }
        n2 = Math.min(n2, this.available());
        this.byteBuffer.get(byArray, n, n2);
        return n2;
    }

    @Override
    public void reset() throws IOException {
        synchronized (this) {
            if (this.markPos != -1) {
                this.byteBuffer.position(this.markPos);
                return;
            }
            IOException iOException = new IOException("Cannot reset to unset mark position");
            throw iOException;
        }
    }

    @Override
    public long skip(long l) throws IOException {
        if (!this.byteBuffer.hasRemaining()) {
            return -1L;
        }
        l = Math.min(l, (long)this.available());
        ByteBuffer byteBuffer = this.byteBuffer;
        byteBuffer.position((int)((long)byteBuffer.position() + l));
        return l;
    }
}
