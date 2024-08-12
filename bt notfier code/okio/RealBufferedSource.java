/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.CharsKt
 *  okio.Buffer
 *  okio.BufferedSource
 *  okio.ByteString
 *  okio.Okio
 *  okio.Options
 *  okio.PeekSource
 *  okio.Sink
 *  okio.Source
 *  okio.Timeout
 *  okio._UtilKt
 *  okio.internal._BufferKt
 */
package okio;

import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Options;
import okio.PeekSource;
import okio.Sink;
import okio.Source;
import okio.Timeout;
import okio._UtilKt;
import okio.internal._BufferKt;

@Metadata(d1={"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\rH\u0016J\b\u0010\u001e\u001a\u00020\u0001H\u0016J\u0018\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J(\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H\u0016J\u0010\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020'H\u0016J \u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020'2\u0006\u0010 \u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H\u0016J\u0018\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0012H\u0016J\u0010\u0010(\u001a\u00020\u00122\u0006\u0010%\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020\u0014H\u0016J\b\u0010+\u001a\u00020'H\u0016J\u0010\u0010+\u001a\u00020'2\u0006\u0010#\u001a\u00020\u0012H\u0016J\b\u0010,\u001a\u00020\u0018H\u0016J\u0010\u0010,\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u0012H\u0016J\b\u0010-\u001a\u00020\u0012H\u0016J\u0010\u0010.\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020'H\u0016J\u0018\u0010.\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0012H\u0016J\b\u0010/\u001a\u00020\u0012H\u0016J\b\u00100\u001a\u00020\"H\u0016J\b\u00101\u001a\u00020\"H\u0016J\b\u00102\u001a\u00020\u0012H\u0016J\b\u00103\u001a\u00020\u0012H\u0016J\b\u00104\u001a\u000205H\u0016J\b\u00106\u001a\u000205H\u0016J\u0010\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0016J\u0018\u00107\u001a\u0002082\u0006\u0010#\u001a\u00020\u00122\u0006\u00109\u001a\u00020:H\u0016J\b\u0010;\u001a\u000208H\u0016J\u0010\u0010;\u001a\u0002082\u0006\u0010#\u001a\u00020\u0012H\u0016J\b\u0010<\u001a\u00020\"H\u0016J\n\u0010=\u001a\u0004\u0018\u000108H\u0016J\b\u0010>\u001a\u000208H\u0016J\u0010\u0010>\u001a\u0002082\u0006\u0010?\u001a\u00020\u0012H\u0016J\u0010\u0010@\u001a\u00020\r2\u0006\u0010#\u001a\u00020\u0012H\u0016J\u0010\u0010A\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u0012H\u0016J\u0010\u0010B\u001a\u00020\"2\u0006\u0010C\u001a\u00020DH\u0016J\u0010\u0010E\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u0012H\u0016J\b\u0010F\u001a\u00020GH\u0016J\b\u0010H\u001a\u000208H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068\u00d6\u0002X\u0096\u0004\u00a2\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006I"}, d2={"Lokio/RealBufferedSource;", "Lokio/BufferedSource;", "source", "Lokio/Source;", "(Lokio/Source;)V", "buffer", "Lokio/Buffer;", "getBuffer$annotations", "()V", "getBuffer", "()Lokio/Buffer;", "bufferField", "closed", "", "close", "", "exhausted", "indexOf", "", "b", "", "fromIndex", "toIndex", "bytes", "Lokio/ByteString;", "indexOfElement", "targetBytes", "inputStream", "Ljava/io/InputStream;", "isOpen", "peek", "rangeEquals", "offset", "bytesOffset", "", "byteCount", "read", "sink", "Ljava/nio/ByteBuffer;", "", "readAll", "Lokio/Sink;", "readByte", "readByteArray", "readByteString", "readDecimalLong", "readFully", "readHexadecimalUnsignedLong", "readInt", "readIntLe", "readLong", "readLongLe", "readShort", "", "readShortLe", "readString", "", "charset", "Ljava/nio/charset/Charset;", "readUtf8", "readUtf8CodePoint", "readUtf8Line", "readUtf8LineStrict", "limit", "request", "require", "select", "options", "Lokio/Options;", "skip", "timeout", "Lokio/Timeout;", "toString", "okio"}, k=1, mv={1, 5, 1}, xi=48)
public final class RealBufferedSource
implements BufferedSource {
    public final Buffer bufferField;
    public boolean closed;
    public final Source source;

    public RealBufferedSource(Source source) {
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        this.source = source;
        this.bufferField = new Buffer();
    }

    public static /* synthetic */ void getBuffer$annotations() {
    }

    public Buffer buffer() {
        return this.bufferField;
    }

    public void close() {
        if (this.closed) return;
        this.closed = true;
        this.source.close();
        this.bufferField.clear();
    }

    public boolean exhausted() {
        boolean bl = this.closed;
        boolean bl2 = true;
        if (!(bl ^ true)) throw (Throwable)new IllegalStateException("closed".toString());
        if (this.bufferField.exhausted() && this.source.read(this.bufferField, 8192L) == -1L) return bl2;
        bl2 = false;
        return bl2;
    }

    public Buffer getBuffer() {
        return this.bufferField;
    }

    public long indexOf(byte by) {
        return this.indexOf(by, 0L, Long.MAX_VALUE);
    }

    public long indexOf(byte by, long l) {
        return this.indexOf(by, l, Long.MAX_VALUE);
    }

    public long indexOf(byte by, long l, long l2) {
        long l3;
        boolean bl = this.closed;
        boolean bl2 = true;
        if (!(bl ^ true)) {
            Throwable throwable = new IllegalStateException("closed".toString());
            throw throwable;
        }
        if (0L > l || l > l2) {
            bl2 = false;
        }
        if (!bl2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("fromIndex=");
            stringBuilder.append(l);
            stringBuilder.append(" toIndex=");
            stringBuilder.append(l2);
            throw (Throwable)new IllegalArgumentException(stringBuilder.toString().toString());
        }
        while (true) {
            long l4;
            l3 = l4 = -1L;
            if (l >= l2) return l3;
            l3 = this.bufferField.indexOf(by, l, l2);
            if (l3 != -1L) return l3;
            long l5 = this.bufferField.size();
            l3 = l4;
            if (l5 >= l2) return l3;
            if (this.source.read(this.bufferField, 8192L) == -1L) {
                l3 = l4;
                break;
            }
            l = Math.max(l, l5);
        }
        return l3;
    }

    public long indexOf(ByteString byteString) {
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"bytes");
        return this.indexOf(byteString, 0L);
    }

    public long indexOf(ByteString object, long l) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"bytes");
        if (!(this.closed ^ true)) {
            object = new IllegalStateException("closed".toString());
            throw object;
        }
        while (true) {
            long l2;
            if ((l2 = this.bufferField.indexOf(object, l)) != -1L) {
                l = l2;
                break;
            }
            l2 = this.bufferField.size();
            if (this.source.read(this.bufferField, 8192L) == -1L) {
                l = -1L;
                break;
            }
            l = Math.max(l, l2 - (long)object.size() + 1L);
        }
        return l;
    }

    public long indexOfElement(ByteString byteString) {
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"targetBytes");
        return this.indexOfElement(byteString, 0L);
    }

    public long indexOfElement(ByteString object, long l) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"targetBytes");
        if (!(this.closed ^ true)) {
            object = new IllegalStateException("closed".toString());
            throw object;
        }
        while (true) {
            long l2;
            if ((l2 = this.bufferField.indexOfElement(object, l)) != -1L) {
                l = l2;
                break;
            }
            l2 = this.bufferField.size();
            if (this.source.read(this.bufferField, 8192L) == -1L) {
                l = -1L;
                break;
            }
            l = Math.max(l, l2);
        }
        return l;
    }

    public InputStream inputStream() {
        return (InputStream)new /* Unavailable Anonymous Inner Class!! */;
    }

    public boolean isOpen() {
        return this.closed ^ true;
    }

    public BufferedSource peek() {
        return Okio.buffer((Source)((Source)new PeekSource((BufferedSource)this)));
    }

    public boolean rangeEquals(long l, ByteString byteString) {
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"bytes");
        return this.rangeEquals(l, byteString, 0, byteString.size());
    }

    public boolean rangeEquals(long l, ByteString object, int n, int n2) {
        boolean bl;
        block4: {
            Intrinsics.checkNotNullParameter((Object)object, (String)"bytes");
            bl = this.closed;
            boolean bl2 = true;
            if (!(bl ^ true)) {
                object = new IllegalStateException("closed".toString());
                throw object;
            }
            if (l >= 0L && n >= 0 && n2 >= 0 && object.size() - n >= n2) {
                bl = bl2;
                if (n2 <= 0) return bl;
                int n3 = 0;
                while (true) {
                    int n4 = n3 + 1;
                    long l2 = (long)n3 + l;
                    if (!this.request(1L + l2) || this.bufferField.getByte(l2) != object.getByte(n3 + n)) break;
                    if (n4 >= n2) {
                        bl = bl2;
                        break block4;
                    }
                    n3 = n4;
                }
            }
            bl = false;
        }
        return bl;
    }

    public int read(ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter((Object)byteBuffer, (String)"sink");
        if (this.bufferField.size() != 0L) return this.bufferField.read(byteBuffer);
        if (this.source.read(this.bufferField, 8192L) != -1L) return this.bufferField.read(byteBuffer);
        return -1;
    }

    public int read(byte[] byArray) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"sink");
        return this.read(byArray, 0, byArray.length);
    }

    public int read(byte[] byArray, int n, int n2) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"sink");
        long l = byArray.length;
        long l2 = n;
        long l3 = n2;
        _UtilKt.checkOffsetAndCount((long)l, (long)l2, (long)l3);
        if (this.bufferField.size() == 0L && this.source.read(this.bufferField, 8192L) == -1L) {
            n = -1;
        } else {
            n2 = (int)Math.min(l3, this.bufferField.size());
            n = this.bufferField.read(byArray, n, n2);
        }
        return n;
    }

    public long read(Buffer buffer, long l) {
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"sink");
        boolean bl = l >= 0L;
        if (!bl) throw (Throwable)new IllegalArgumentException(Intrinsics.stringPlus((String)"byteCount < 0: ", (Object)l).toString());
        if (!(true ^ this.closed)) throw (Throwable)new IllegalStateException("closed".toString());
        long l2 = this.bufferField.size();
        long l3 = -1L;
        if (l2 == 0L && this.source.read(this.bufferField, 8192L) == -1L) {
            l = l3;
        } else {
            l = Math.min(l, this.bufferField.size());
            l = this.bufferField.read(buffer, l);
        }
        return l;
    }

    public long readAll(Sink sink) {
        Intrinsics.checkNotNullParameter((Object)sink, (String)"sink");
        long l = 0L;
        while (true) {
            long l2;
            if (this.source.read(this.bufferField, 8192L) == -1L) {
                l2 = l;
                if (this.bufferField.size() <= 0L) return l2;
                l2 = l + this.bufferField.size();
                Buffer buffer = this.bufferField;
                sink.write(buffer, buffer.size());
                return l2;
            }
            l2 = this.bufferField.completeSegmentByteCount();
            if (l2 <= 0L) continue;
            l += l2;
            sink.write(this.bufferField, l2);
        }
    }

    public byte readByte() {
        this.require(1L);
        return this.bufferField.readByte();
    }

    public byte[] readByteArray() {
        this.bufferField.writeAll(this.source);
        return this.bufferField.readByteArray();
    }

    public byte[] readByteArray(long l) {
        this.require(l);
        return this.bufferField.readByteArray(l);
    }

    public ByteString readByteString() {
        this.bufferField.writeAll(this.source);
        return this.bufferField.readByteString();
    }

    public ByteString readByteString(long l) {
        this.require(l);
        return this.bufferField.readByteString(l);
    }

    public long readDecimalLong() {
        byte by;
        long l;
        block3: {
            long l2;
            this.require(1L);
            l = 0L;
            while (this.request(l2 = l + 1L)) {
                by = this.bufferField.getByte(l);
                if (by >= (byte)48 && by <= (byte)57 || l == 0L && by == (byte)45) {
                    l = l2;
                    continue;
                }
                break block3;
            }
            return this.bufferField.readDecimalLong();
        }
        if (l != 0L) {
            return this.bufferField.readDecimalLong();
        }
        String string = Integer.toString(by, CharsKt.checkRadix((int)CharsKt.checkRadix((int)16)));
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"java.lang.Integer.toStri\u2026(this, checkRadix(radix))");
        throw new NumberFormatException(Intrinsics.stringPlus((String)"Expected a digit or '-' but was 0x", (Object)string));
    }

    public void readFully(Buffer buffer, long l) {
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"sink");
        try {
            this.require(l);
        }
        catch (EOFException eOFException) {
            buffer.writeAll((Source)this.bufferField);
            throw eOFException;
        }
        this.bufferField.readFully(buffer, l);
    }

    public void readFully(byte[] byArray) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"sink");
        try {
            this.require(byArray.length);
        }
        catch (EOFException eOFException) {
            int n = 0;
            while (this.bufferField.size() > 0L) {
                Buffer buffer = this.bufferField;
                int n2 = buffer.read(byArray, n, (int)buffer.size());
                if (n2 == -1) throw new AssertionError();
                n += n2;
            }
            throw eOFException;
        }
        this.bufferField.readFully(byArray);
    }

    public long readHexadecimalUnsignedLong() {
        byte by;
        int n;
        block3: {
            int n2;
            this.require(1L);
            n = 0;
            while (this.request(n2 = n + 1)) {
                by = this.bufferField.getByte((long)n);
                if (by >= (byte)48 && by <= (byte)57 || by >= (byte)97 && by <= (byte)102 || by >= (byte)65 && by <= (byte)70) {
                    n = n2;
                    continue;
                }
                break block3;
            }
            return this.bufferField.readHexadecimalUnsignedLong();
        }
        if (n != 0) {
            return this.bufferField.readHexadecimalUnsignedLong();
        }
        String string = Integer.toString(by, CharsKt.checkRadix((int)CharsKt.checkRadix((int)16)));
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"java.lang.Integer.toStri\u2026(this, checkRadix(radix))");
        throw new NumberFormatException(Intrinsics.stringPlus((String)"Expected leading [0-9a-fA-F] character but was 0x", (Object)string));
    }

    public int readInt() {
        this.require(4L);
        return this.bufferField.readInt();
    }

    public int readIntLe() {
        this.require(4L);
        return this.bufferField.readIntLe();
    }

    public long readLong() {
        this.require(8L);
        return this.bufferField.readLong();
    }

    public long readLongLe() {
        this.require(8L);
        return this.bufferField.readLongLe();
    }

    public short readShort() {
        this.require(2L);
        return this.bufferField.readShort();
    }

    public short readShortLe() {
        this.require(2L);
        return this.bufferField.readShortLe();
    }

    public String readString(long l, Charset charset) {
        Intrinsics.checkNotNullParameter((Object)charset, (String)"charset");
        this.require(l);
        return this.bufferField.readString(l, charset);
    }

    public String readString(Charset charset) {
        Intrinsics.checkNotNullParameter((Object)charset, (String)"charset");
        this.bufferField.writeAll(this.source);
        return this.bufferField.readString(charset);
    }

    public String readUtf8() {
        this.bufferField.writeAll(this.source);
        return this.bufferField.readUtf8();
    }

    public String readUtf8(long l) {
        this.require(l);
        return this.bufferField.readUtf8(l);
    }

    public int readUtf8CodePoint() {
        this.require(1L);
        byte by = this.bufferField.getByte(0L);
        if ((by & 0xE0) == 192) {
            this.require(2L);
        } else if ((by & 0xF0) == 224) {
            this.require(3L);
        } else {
            if ((by & 0xF8) != 240) return this.bufferField.readUtf8CodePoint();
            this.require(4L);
        }
        return this.bufferField.readUtf8CodePoint();
    }

    public String readUtf8Line() {
        long l = this.indexOf((byte)10);
        String string = l == -1L ? (this.bufferField.size() != 0L ? this.readUtf8(this.bufferField.size()) : (String)null) : _BufferKt.readUtf8Line((Buffer)this.bufferField, (long)l);
        return string;
    }

    public String readUtf8LineStrict() {
        return this.readUtf8LineStrict(Long.MAX_VALUE);
    }

    public String readUtf8LineStrict(long l) {
        long l2;
        block4: {
            String string;
            block3: {
                byte by;
                block2: {
                    boolean bl = l >= 0L;
                    if (!bl) throw (Throwable)new IllegalArgumentException(Intrinsics.stringPlus((String)"limit < 0: ", (Object)l).toString());
                    l2 = l == Long.MAX_VALUE ? Long.MAX_VALUE : l + 1L;
                    by = (byte)10;
                    long l3 = this.indexOf(by, 0L, l2);
                    if (l3 == -1L) break block2;
                    string = _BufferKt.readUtf8Line((Buffer)this.bufferField, (long)l3);
                    break block3;
                }
                if (l2 >= Long.MAX_VALUE || !this.request(l2) || this.bufferField.getByte(l2 - 1L) != (byte)13 || !this.request(1L + l2) || this.bufferField.getByte(l2) != by) break block4;
                string = _BufferKt.readUtf8Line((Buffer)this.bufferField, (long)l2);
            }
            return string;
        }
        Buffer buffer = new Buffer();
        Object object = this.bufferField;
        l2 = object.size();
        object.copyTo(buffer, 0L, Math.min((long)32, l2));
        object = new StringBuilder();
        ((StringBuilder)object).append("\\n not found: limit=");
        ((StringBuilder)object).append(Math.min(this.bufferField.size(), l));
        ((StringBuilder)object).append(" content=");
        ((StringBuilder)object).append(buffer.readByteString().hex());
        ((StringBuilder)object).append('\u2026');
        throw new EOFException(((StringBuilder)object).toString());
    }

    public boolean request(long l) {
        boolean bl;
        block2: {
            bl = false;
            boolean bl2 = l >= 0L;
            if (!bl2) {
                Throwable throwable = new IllegalArgumentException(Intrinsics.stringPlus((String)"byteCount < 0: ", (Object)l).toString());
                throw throwable;
            }
            if (!(this.closed ^ true)) throw (Throwable)new IllegalStateException("closed".toString());
            while (this.bufferField.size() < l) {
                if (this.source.read(this.bufferField, 8192L) != -1L) continue;
                break block2;
            }
            bl = true;
        }
        return bl;
    }

    public void require(long l) {
        if (!this.request(l)) throw new EOFException();
    }

    public int select(Options object) {
        int n;
        block2: {
            Intrinsics.checkNotNullParameter((Object)object, (String)"options");
            if (!(this.closed ^ true)) {
                object = new IllegalStateException("closed".toString());
                throw object;
            }
            do {
                if ((n = _BufferKt.selectPrefix((Buffer)this.bufferField, (Options)object, (boolean)true)) == -2) continue;
                if (n == -1) break;
                int n2 = object.getByteStrings$okio()[n].size();
                this.bufferField.skip((long)n2);
                break block2;
            } while (this.source.read(this.bufferField, 8192L) != -1L);
            n = -1;
        }
        return n;
    }

    public void skip(long l) {
        if (!(this.closed ^ true)) {
            Throwable throwable = new IllegalStateException("closed".toString());
            throw throwable;
        }
        while (l > 0L) {
            if (this.bufferField.size() == 0L) {
                if (this.source.read(this.bufferField, 8192L) == -1L) throw new EOFException();
            }
            long l2 = Math.min(l, this.bufferField.size());
            this.bufferField.skip(l2);
            l -= l2;
        }
    }

    public Timeout timeout() {
        return this.source.timeout();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("buffer(");
        stringBuilder.append(this.source);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
