/*
 * Decompiled with CFR 0.152.
 */
package androidx.camera.core.impl.utils;

import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;

final class ByteOrderedDataInputStream
extends InputStream
implements DataInput {
    private static final ByteOrder BIG_ENDIAN;
    private static final ByteOrder LITTLE_ENDIAN;
    private ByteOrder mByteOrder = ByteOrder.BIG_ENDIAN;
    private final DataInputStream mDataInputStream;
    final int mLength;
    int mPosition;

    static {
        LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        BIG_ENDIAN = ByteOrder.BIG_ENDIAN;
    }

    ByteOrderedDataInputStream(InputStream inputStream) throws IOException {
        this(inputStream, ByteOrder.BIG_ENDIAN);
    }

    ByteOrderedDataInputStream(InputStream inputStream, ByteOrder byteOrder) throws IOException {
        int n;
        inputStream = new DataInputStream(inputStream);
        this.mDataInputStream = inputStream;
        this.mLength = n = ((FilterInputStream)inputStream).available();
        this.mPosition = 0;
        this.mDataInputStream.mark(n);
        this.mByteOrder = byteOrder;
    }

    ByteOrderedDataInputStream(byte[] byArray) throws IOException {
        this(new ByteArrayInputStream(byArray));
    }

    @Override
    public int available() throws IOException {
        return this.mDataInputStream.available();
    }

    public int getLength() {
        return this.mLength;
    }

    @Override
    public void mark(int n) {
        DataInputStream dataInputStream = this.mDataInputStream;
        synchronized (dataInputStream) {
            this.mDataInputStream.mark(n);
            return;
        }
    }

    public int peek() {
        return this.mPosition;
    }

    @Override
    public int read() throws IOException {
        ++this.mPosition;
        return this.mDataInputStream.read();
    }

    @Override
    public int read(byte[] byArray, int n, int n2) throws IOException {
        n = this.mDataInputStream.read(byArray, n, n2);
        this.mPosition += n;
        return n;
    }

    @Override
    public boolean readBoolean() throws IOException {
        ++this.mPosition;
        return this.mDataInputStream.readBoolean();
    }

    @Override
    public byte readByte() throws IOException {
        int n;
        this.mPosition = n = this.mPosition + 1;
        if (n > this.mLength) throw new EOFException();
        n = this.mDataInputStream.read();
        if (n < 0) throw new EOFException();
        return (byte)n;
    }

    @Override
    public char readChar() throws IOException {
        this.mPosition += 2;
        return this.mDataInputStream.readChar();
    }

    @Override
    public double readDouble() throws IOException {
        return Double.longBitsToDouble(this.readLong());
    }

    @Override
    public float readFloat() throws IOException {
        return Float.intBitsToFloat(this.readInt());
    }

    @Override
    public void readFully(byte[] byArray) throws IOException {
        int n;
        this.mPosition = n = this.mPosition + byArray.length;
        if (n > this.mLength) throw new EOFException();
        if (this.mDataInputStream.read(byArray, 0, byArray.length) != byArray.length) throw new IOException("Couldn't read up to the length of buffer");
    }

    @Override
    public void readFully(byte[] byArray, int n, int n2) throws IOException {
        int n3;
        this.mPosition = n3 = this.mPosition + n2;
        if (n3 > this.mLength) throw new EOFException();
        if (this.mDataInputStream.read(byArray, n, n2) != n2) throw new IOException("Couldn't read up to the length of buffer");
    }

    @Override
    public int readInt() throws IOException {
        int n;
        int n2;
        int n3;
        this.mPosition = n3 = this.mPosition + 4;
        if (n3 > this.mLength) throw new EOFException();
        int n4 = this.mDataInputStream.read();
        if ((n4 | (n3 = this.mDataInputStream.read()) | (n2 = this.mDataInputStream.read()) | (n = this.mDataInputStream.read())) < 0) throw new EOFException();
        Object object = this.mByteOrder;
        if (object == LITTLE_ENDIAN) {
            return (n << 24) + (n2 << 16) + (n3 << 8) + n4;
        }
        if (object == BIG_ENDIAN) {
            return (n4 << 24) + (n3 << 16) + (n2 << 8) + n;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Invalid byte order: ");
        ((StringBuilder)object).append(this.mByteOrder);
        throw new IOException(((StringBuilder)object).toString());
    }

    @Override
    public String readLine() {
        throw new UnsupportedOperationException("readLine() not implemented.");
    }

    @Override
    public long readLong() throws IOException {
        int n;
        int n2;
        int n3;
        int n4;
        int n5;
        int n6;
        int n7;
        this.mPosition = n7 = this.mPosition + 8;
        if (n7 > this.mLength) throw new EOFException();
        int n8 = this.mDataInputStream.read();
        if ((n8 | (n6 = this.mDataInputStream.read()) | (n5 = this.mDataInputStream.read()) | (n4 = this.mDataInputStream.read()) | (n7 = this.mDataInputStream.read()) | (n3 = this.mDataInputStream.read()) | (n2 = this.mDataInputStream.read()) | (n = this.mDataInputStream.read())) < 0) throw new EOFException();
        Object object = this.mByteOrder;
        if (object == LITTLE_ENDIAN) {
            return ((long)n << 56) + ((long)n2 << 48) + ((long)n3 << 40) + ((long)n7 << 32) + ((long)n4 << 24) + ((long)n5 << 16) + ((long)n6 << 8) + (long)n8;
        }
        if (object == BIG_ENDIAN) {
            return ((long)n8 << 56) + ((long)n6 << 48) + ((long)n5 << 40) + ((long)n4 << 32) + ((long)n7 << 24) + ((long)n3 << 16) + ((long)n2 << 8) + (long)n;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Invalid byte order: ");
        ((StringBuilder)object).append(this.mByteOrder);
        throw new IOException(((StringBuilder)object).toString());
    }

    @Override
    public short readShort() throws IOException {
        int n;
        this.mPosition = n = this.mPosition + 2;
        if (n > this.mLength) throw new EOFException();
        int n2 = this.mDataInputStream.read();
        if ((n2 | (n = this.mDataInputStream.read())) < 0) throw new EOFException();
        Object object = this.mByteOrder;
        if (object == LITTLE_ENDIAN) {
            return (short)((n << 8) + n2);
        }
        if (object == BIG_ENDIAN) {
            return (short)((n2 << 8) + n);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Invalid byte order: ");
        ((StringBuilder)object).append(this.mByteOrder);
        throw new IOException(((StringBuilder)object).toString());
    }

    @Override
    public String readUTF() throws IOException {
        this.mPosition += 2;
        return this.mDataInputStream.readUTF();
    }

    @Override
    public int readUnsignedByte() throws IOException {
        ++this.mPosition;
        return this.mDataInputStream.readUnsignedByte();
    }

    public long readUnsignedInt() throws IOException {
        return (long)this.readInt() & 0xFFFFFFFFL;
    }

    @Override
    public int readUnsignedShort() throws IOException {
        int n;
        int n2;
        this.mPosition = n2 = this.mPosition + 2;
        if (n2 > this.mLength) throw new EOFException();
        n2 = this.mDataInputStream.read();
        if ((n2 | (n = this.mDataInputStream.read())) < 0) throw new EOFException();
        Object object = this.mByteOrder;
        if (object == LITTLE_ENDIAN) {
            return (n << 8) + n2;
        }
        if (object == BIG_ENDIAN) {
            return (n2 << 8) + n;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Invalid byte order: ");
        ((StringBuilder)object).append(this.mByteOrder);
        throw new IOException(((StringBuilder)object).toString());
    }

    public void seek(long l) throws IOException {
        int n = this.mPosition;
        if ((long)n > l) {
            this.mPosition = 0;
            this.mDataInputStream.reset();
            this.mDataInputStream.mark(this.mLength);
        } else {
            l -= (long)n;
        }
        n = (int)l;
        if (this.skipBytes(n) != n) throw new IOException("Couldn't seek up to the byteCount");
    }

    public void setByteOrder(ByteOrder byteOrder) {
        this.mByteOrder = byteOrder;
    }

    @Override
    public int skipBytes(int n) throws IOException {
        int n2 = Math.min(n, this.mLength - this.mPosition);
        n = 0;
        while (true) {
            if (n >= n2) {
                this.mPosition += n;
                return n;
            }
            n += this.mDataInputStream.skipBytes(n2 - n);
        }
    }
}
