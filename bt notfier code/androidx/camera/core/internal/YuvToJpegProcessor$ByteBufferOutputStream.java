/*
 * Decompiled with CFR 0.152.
 */
package androidx.camera.core.internal;

import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

private static final class YuvToJpegProcessor.ByteBufferOutputStream
extends OutputStream {
    private final ByteBuffer mByteBuffer;

    YuvToJpegProcessor.ByteBufferOutputStream(ByteBuffer byteBuffer) {
        this.mByteBuffer = byteBuffer;
    }

    @Override
    public void write(int n) throws IOException {
        if (!this.mByteBuffer.hasRemaining()) throw new EOFException("Output ByteBuffer has no bytes remaining.");
        this.mByteBuffer.put((byte)n);
    }

    @Override
    public void write(byte[] byArray, int n, int n2) throws IOException {
        if (byArray == null) throw null;
        if (n < 0) throw new IndexOutOfBoundsException();
        if (n > byArray.length) throw new IndexOutOfBoundsException();
        if (n2 < 0) throw new IndexOutOfBoundsException();
        int n3 = n + n2;
        if (n3 > byArray.length) throw new IndexOutOfBoundsException();
        if (n3 < 0) throw new IndexOutOfBoundsException();
        if (n2 == 0) {
            return;
        }
        if (this.mByteBuffer.remaining() < n2) throw new EOFException("Output ByteBuffer has insufficient bytes remaining.");
        this.mByteBuffer.put(byArray, n, n2);
    }
}
