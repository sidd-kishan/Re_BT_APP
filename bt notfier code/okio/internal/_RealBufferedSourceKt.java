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
 *  okio.RealBufferedSource
 *  okio.Sink
 *  okio.Source
 *  okio.Timeout
 *  okio._UtilKt
 *  okio.internal._BufferKt
 */
package okio.internal;

import java.io.EOFException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Options;
import okio.PeekSource;
import okio.RealBufferedSource;
import okio.Sink;
import okio.Source;
import okio.Timeout;
import okio._UtilKt;
import okio.internal._BufferKt;

@Metadata(d1={"\u0000j\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0080\b\u001a\r\u0010\u0003\u001a\u00020\u0004*\u00020\u0002H\u0080\b\u001a%\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0080\b\u001a\u001d\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u0006H\u0080\b\u001a\u001d\u0010\r\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u0006H\u0080\b\u001a\r\u0010\u000f\u001a\u00020\u0010*\u00020\u0002H\u0080\b\u001a-\u0010\u0011\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0080\b\u001a%\u0010\u0016\u001a\u00020\u0014*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0080\b\u001a\u001d\u0010\u0016\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u0006H\u0080\b\u001a\u0015\u0010\u001a\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u001bH\u0080\b\u001a\r\u0010\u001c\u001a\u00020\b*\u00020\u0002H\u0080\b\u001a\r\u0010\u001d\u001a\u00020\u0018*\u00020\u0002H\u0080\b\u001a\u0015\u0010\u001d\u001a\u00020\u0018*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\u0080\b\u001a\r\u0010\u001e\u001a\u00020\f*\u00020\u0002H\u0080\b\u001a\u0015\u0010\u001e\u001a\u00020\f*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\u0080\b\u001a\r\u0010\u001f\u001a\u00020\u0006*\u00020\u0002H\u0080\b\u001a\u0015\u0010 \u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0018H\u0080\b\u001a\u001d\u0010 \u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u0006H\u0080\b\u001a\r\u0010!\u001a\u00020\u0006*\u00020\u0002H\u0080\b\u001a\r\u0010\"\u001a\u00020\u0014*\u00020\u0002H\u0080\b\u001a\r\u0010#\u001a\u00020\u0014*\u00020\u0002H\u0080\b\u001a\r\u0010$\u001a\u00020\u0006*\u00020\u0002H\u0080\b\u001a\r\u0010%\u001a\u00020\u0006*\u00020\u0002H\u0080\b\u001a\r\u0010&\u001a\u00020'*\u00020\u0002H\u0080\b\u001a\r\u0010(\u001a\u00020'*\u00020\u0002H\u0080\b\u001a\r\u0010)\u001a\u00020**\u00020\u0002H\u0080\b\u001a\u0015\u0010)\u001a\u00020**\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\u0080\b\u001a\r\u0010+\u001a\u00020\u0014*\u00020\u0002H\u0080\b\u001a\u000f\u0010,\u001a\u0004\u0018\u00010**\u00020\u0002H\u0080\b\u001a\u0015\u0010-\u001a\u00020**\u00020\u00022\u0006\u0010.\u001a\u00020\u0006H\u0080\b\u001a\u0015\u0010/\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\u0080\b\u001a\u0015\u00100\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\u0080\b\u001a\u0015\u00101\u001a\u00020\u0014*\u00020\u00022\u0006\u00102\u001a\u000203H\u0080\b\u001a\u0015\u00104\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\u0080\b\u001a\r\u00105\u001a\u000206*\u00020\u0002H\u0080\b\u001a\r\u00107\u001a\u00020**\u00020\u0002H\u0080\b\u00a8\u00068"}, d2={"commonClose", "", "Lokio/RealBufferedSource;", "commonExhausted", "", "commonIndexOf", "", "b", "", "fromIndex", "toIndex", "bytes", "Lokio/ByteString;", "commonIndexOfElement", "targetBytes", "commonPeek", "Lokio/BufferedSource;", "commonRangeEquals", "offset", "bytesOffset", "", "byteCount", "commonRead", "sink", "", "Lokio/Buffer;", "commonReadAll", "Lokio/Sink;", "commonReadByte", "commonReadByteArray", "commonReadByteString", "commonReadDecimalLong", "commonReadFully", "commonReadHexadecimalUnsignedLong", "commonReadInt", "commonReadIntLe", "commonReadLong", "commonReadLongLe", "commonReadShort", "", "commonReadShortLe", "commonReadUtf8", "", "commonReadUtf8CodePoint", "commonReadUtf8Line", "commonReadUtf8LineStrict", "limit", "commonRequest", "commonRequire", "commonSelect", "options", "Lokio/Options;", "commonSkip", "commonTimeout", "Lokio/Timeout;", "commonToString", "okio"}, k=2, mv={1, 5, 1}, xi=48)
public final class _RealBufferedSourceKt {
    public static final void commonClose(RealBufferedSource realBufferedSource) {
        Intrinsics.checkNotNullParameter((Object)realBufferedSource, (String)"<this>");
        if (realBufferedSource.closed) {
            return;
        }
        realBufferedSource.closed = true;
        realBufferedSource.source.close();
        realBufferedSource.bufferField.clear();
    }

    public static final boolean commonExhausted(RealBufferedSource realBufferedSource) {
        Intrinsics.checkNotNullParameter((Object)realBufferedSource, (String)"<this>");
        boolean bl = realBufferedSource.closed;
        boolean bl2 = true;
        if (!(bl ^ true)) throw (Throwable)new IllegalStateException("closed".toString());
        if (realBufferedSource.bufferField.exhausted() && realBufferedSource.source.read(realBufferedSource.bufferField, 8192L) == -1L) return bl2;
        bl2 = false;
        return bl2;
    }

    public static final long commonIndexOf(RealBufferedSource object, byte by, long l, long l2) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
        boolean bl = ((RealBufferedSource)object).closed;
        boolean bl2 = true;
        if (!(bl ^ true)) {
            object = new IllegalStateException("closed".toString());
            throw object;
        }
        if (0L > l || l > l2) {
            bl2 = false;
        }
        if (!bl2) {
            object = new StringBuilder();
            ((StringBuilder)object).append("fromIndex=");
            ((StringBuilder)object).append(l);
            ((StringBuilder)object).append(" toIndex=");
            ((StringBuilder)object).append(l2);
            throw (Throwable)new IllegalArgumentException(((StringBuilder)object).toString().toString());
        }
        while (l < l2) {
            long l3 = ((RealBufferedSource)object).bufferField.indexOf(by, l, l2);
            if (l3 != -1L) {
                return l3;
            }
            l3 = ((RealBufferedSource)object).bufferField.size();
            if (l3 >= l2) return -1L;
            if (((RealBufferedSource)object).source.read(((RealBufferedSource)object).bufferField, 8192L) == -1L) {
                return -1L;
            }
            l = Math.max(l, l3);
        }
        return -1L;
    }

    public static final long commonIndexOf(RealBufferedSource object, ByteString byteString, long l) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"bytes");
        if (!(object.closed ^ true)) {
            object = new IllegalStateException("closed".toString());
            throw object;
        }
        long l2;
        while ((l2 = object.bufferField.indexOf(byteString, l)) == -1L) {
            l2 = object.bufferField.size();
            if (object.source.read(object.bufferField, 8192L) == -1L) {
                return -1L;
            }
            l = Math.max(l, l2 - (long)byteString.size() + 1L);
        }
        return l2;
    }

    public static final long commonIndexOfElement(RealBufferedSource object, ByteString byteString, long l) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"targetBytes");
        if (!(object.closed ^ true)) {
            object = new IllegalStateException("closed".toString());
            throw object;
        }
        long l2;
        while ((l2 = object.bufferField.indexOfElement(byteString, l)) == -1L) {
            l2 = object.bufferField.size();
            if (object.source.read(object.bufferField, 8192L) == -1L) {
                return -1L;
            }
            l = Math.max(l, l2);
        }
        return l2;
    }

    public static final BufferedSource commonPeek(RealBufferedSource realBufferedSource) {
        Intrinsics.checkNotNullParameter((Object)realBufferedSource, (String)"<this>");
        return Okio.buffer((Source)((Source)new PeekSource((BufferedSource)realBufferedSource)));
    }

    public static final boolean commonRangeEquals(RealBufferedSource object, long l, ByteString byteString, int n, int n2) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"bytes");
        if (!(object.closed ^ true)) {
            object = new IllegalStateException("closed".toString());
            throw object;
        }
        if (l < 0L) return false;
        if (n < 0) return false;
        if (n2 < 0) return false;
        if (byteString.size() - n < n2) {
            return false;
        }
        if (n2 <= 0) return true;
        int n3 = 0;
        while (true) {
            int n4 = n3 + 1;
            long l2 = (long)n3 + l;
            if (!object.request(1L + l2)) {
                return false;
            }
            if (object.bufferField.getByte(l2) != byteString.getByte(n3 + n)) {
                return false;
            }
            if (n4 >= n2) {
                return true;
            }
            n3 = n4;
        }
    }

    public static final int commonRead(RealBufferedSource realBufferedSource, byte[] byArray, int n, int n2) {
        Intrinsics.checkNotNullParameter((Object)realBufferedSource, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"sink");
        long l = byArray.length;
        long l2 = n;
        long l3 = n2;
        _UtilKt.checkOffsetAndCount((long)l, (long)l2, (long)l3);
        if (realBufferedSource.bufferField.size() == 0L && realBufferedSource.source.read(realBufferedSource.bufferField, 8192L) == -1L) {
            return -1;
        }
        n2 = (int)Math.min(l3, realBufferedSource.bufferField.size());
        return realBufferedSource.bufferField.read(byArray, n, n2);
    }

    public static final long commonRead(RealBufferedSource realBufferedSource, Buffer buffer, long l) {
        Intrinsics.checkNotNullParameter((Object)realBufferedSource, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"sink");
        boolean bl = l >= 0L;
        if (!bl) throw (Throwable)new IllegalArgumentException(Intrinsics.stringPlus((String)"byteCount < 0: ", (Object)l).toString());
        if (!(true ^ realBufferedSource.closed)) throw (Throwable)new IllegalStateException("closed".toString());
        if (realBufferedSource.bufferField.size() == 0L && realBufferedSource.source.read(realBufferedSource.bufferField, 8192L) == -1L) {
            return -1L;
        }
        l = Math.min(l, realBufferedSource.bufferField.size());
        return realBufferedSource.bufferField.read(buffer, l);
    }

    public static final long commonReadAll(RealBufferedSource realBufferedSource, Sink sink) {
        Intrinsics.checkNotNullParameter((Object)realBufferedSource, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)sink, (String)"sink");
        long l = 0L;
        while (true) {
            long l2;
            if (realBufferedSource.source.read(realBufferedSource.bufferField, 8192L) == -1L) {
                l2 = l;
                if (realBufferedSource.bufferField.size() <= 0L) return l2;
                l2 = l + realBufferedSource.bufferField.size();
                sink.write(realBufferedSource.bufferField, realBufferedSource.bufferField.size());
                return l2;
            }
            l2 = realBufferedSource.bufferField.completeSegmentByteCount();
            if (l2 <= 0L) continue;
            l += l2;
            sink.write(realBufferedSource.bufferField, l2);
        }
    }

    public static final byte commonReadByte(RealBufferedSource realBufferedSource) {
        Intrinsics.checkNotNullParameter((Object)realBufferedSource, (String)"<this>");
        realBufferedSource.require(1L);
        return realBufferedSource.bufferField.readByte();
    }

    public static final byte[] commonReadByteArray(RealBufferedSource realBufferedSource) {
        Intrinsics.checkNotNullParameter((Object)realBufferedSource, (String)"<this>");
        realBufferedSource.bufferField.writeAll(realBufferedSource.source);
        return realBufferedSource.bufferField.readByteArray();
    }

    public static final byte[] commonReadByteArray(RealBufferedSource realBufferedSource, long l) {
        Intrinsics.checkNotNullParameter((Object)realBufferedSource, (String)"<this>");
        realBufferedSource.require(l);
        return realBufferedSource.bufferField.readByteArray(l);
    }

    public static final ByteString commonReadByteString(RealBufferedSource realBufferedSource) {
        Intrinsics.checkNotNullParameter((Object)realBufferedSource, (String)"<this>");
        realBufferedSource.bufferField.writeAll(realBufferedSource.source);
        return realBufferedSource.bufferField.readByteString();
    }

    public static final ByteString commonReadByteString(RealBufferedSource realBufferedSource, long l) {
        Intrinsics.checkNotNullParameter((Object)realBufferedSource, (String)"<this>");
        realBufferedSource.require(l);
        return realBufferedSource.bufferField.readByteString(l);
    }

    public static final long commonReadDecimalLong(RealBufferedSource object) {
        byte by;
        long l;
        block3: {
            long l2;
            Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
            object.require(1L);
            l = 0L;
            while (object.request(l2 = l + 1L)) {
                by = object.bufferField.getByte(l);
                if (by >= (byte)48 && by <= (byte)57 || l == 0L && by == (byte)45) {
                    l = l2;
                    continue;
                }
                break block3;
            }
            return object.bufferField.readDecimalLong();
        }
        if (l != 0L) {
            return object.bufferField.readDecimalLong();
        }
        object = Integer.toString(by, CharsKt.checkRadix((int)CharsKt.checkRadix((int)16)));
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"java.lang.Integer.toStri\u2026(this, checkRadix(radix))");
        throw new NumberFormatException(Intrinsics.stringPlus((String)"Expected a digit or '-' but was 0x", (Object)object));
    }

    public static final void commonReadFully(RealBufferedSource realBufferedSource, Buffer buffer, long l) {
        Intrinsics.checkNotNullParameter((Object)realBufferedSource, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"sink");
        try {
            realBufferedSource.require(l);
        }
        catch (EOFException eOFException) {
            buffer.writeAll((Source)realBufferedSource.bufferField);
            throw eOFException;
        }
        realBufferedSource.bufferField.readFully(buffer, l);
    }

    public static final void commonReadFully(RealBufferedSource realBufferedSource, byte[] byArray) {
        Intrinsics.checkNotNullParameter((Object)realBufferedSource, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"sink");
        try {
            realBufferedSource.require((long)byArray.length);
        }
        catch (EOFException eOFException) {
            int n = 0;
            while (realBufferedSource.bufferField.size() > 0L) {
                int n2 = realBufferedSource.bufferField.read(byArray, n, (int)realBufferedSource.bufferField.size());
                if (n2 == -1) throw new AssertionError();
                n += n2;
            }
            throw eOFException;
        }
        realBufferedSource.bufferField.readFully(byArray);
    }

    public static final long commonReadHexadecimalUnsignedLong(RealBufferedSource object) {
        byte by;
        int n;
        block3: {
            int n2;
            Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
            object.require(1L);
            n = 0;
            while (object.request((long)(n2 = n + 1))) {
                by = object.bufferField.getByte((long)n);
                if (by >= (byte)48 && by <= (byte)57 || by >= (byte)97 && by <= (byte)102 || by >= (byte)65 && by <= (byte)70) {
                    n = n2;
                    continue;
                }
                break block3;
            }
            return object.bufferField.readHexadecimalUnsignedLong();
        }
        if (n != 0) {
            return object.bufferField.readHexadecimalUnsignedLong();
        }
        object = Integer.toString(by, CharsKt.checkRadix((int)CharsKt.checkRadix((int)16)));
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"java.lang.Integer.toStri\u2026(this, checkRadix(radix))");
        throw new NumberFormatException(Intrinsics.stringPlus((String)"Expected leading [0-9a-fA-F] character but was 0x", (Object)object));
    }

    public static final int commonReadInt(RealBufferedSource realBufferedSource) {
        Intrinsics.checkNotNullParameter((Object)realBufferedSource, (String)"<this>");
        realBufferedSource.require(4L);
        return realBufferedSource.bufferField.readInt();
    }

    public static final int commonReadIntLe(RealBufferedSource realBufferedSource) {
        Intrinsics.checkNotNullParameter((Object)realBufferedSource, (String)"<this>");
        realBufferedSource.require(4L);
        return realBufferedSource.bufferField.readIntLe();
    }

    public static final long commonReadLong(RealBufferedSource realBufferedSource) {
        Intrinsics.checkNotNullParameter((Object)realBufferedSource, (String)"<this>");
        realBufferedSource.require(8L);
        return realBufferedSource.bufferField.readLong();
    }

    public static final long commonReadLongLe(RealBufferedSource realBufferedSource) {
        Intrinsics.checkNotNullParameter((Object)realBufferedSource, (String)"<this>");
        realBufferedSource.require(8L);
        return realBufferedSource.bufferField.readLongLe();
    }

    public static final short commonReadShort(RealBufferedSource realBufferedSource) {
        Intrinsics.checkNotNullParameter((Object)realBufferedSource, (String)"<this>");
        realBufferedSource.require(2L);
        return realBufferedSource.bufferField.readShort();
    }

    public static final short commonReadShortLe(RealBufferedSource realBufferedSource) {
        Intrinsics.checkNotNullParameter((Object)realBufferedSource, (String)"<this>");
        realBufferedSource.require(2L);
        return realBufferedSource.bufferField.readShortLe();
    }

    public static final String commonReadUtf8(RealBufferedSource realBufferedSource) {
        Intrinsics.checkNotNullParameter((Object)realBufferedSource, (String)"<this>");
        realBufferedSource.bufferField.writeAll(realBufferedSource.source);
        return realBufferedSource.bufferField.readUtf8();
    }

    public static final String commonReadUtf8(RealBufferedSource realBufferedSource, long l) {
        Intrinsics.checkNotNullParameter((Object)realBufferedSource, (String)"<this>");
        realBufferedSource.require(l);
        return realBufferedSource.bufferField.readUtf8(l);
    }

    public static final int commonReadUtf8CodePoint(RealBufferedSource realBufferedSource) {
        Intrinsics.checkNotNullParameter((Object)realBufferedSource, (String)"<this>");
        realBufferedSource.require(1L);
        byte by = realBufferedSource.bufferField.getByte(0L);
        if ((by & 0xE0) == 192) {
            realBufferedSource.require(2L);
        } else if ((by & 0xF0) == 224) {
            realBufferedSource.require(3L);
        } else {
            if ((by & 0xF8) != 240) return realBufferedSource.bufferField.readUtf8CodePoint();
            realBufferedSource.require(4L);
        }
        return realBufferedSource.bufferField.readUtf8CodePoint();
    }

    public static final String commonReadUtf8Line(RealBufferedSource object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
        long l = object.indexOf((byte)10);
        object = l == -1L ? (object.bufferField.size() != 0L ? object.readUtf8(object.bufferField.size()) : (String)null) : _BufferKt.readUtf8Line((Buffer)object.bufferField, (long)l);
        return object;
    }

    public static final String commonReadUtf8LineStrict(RealBufferedSource realBufferedSource, long l) {
        Intrinsics.checkNotNullParameter((Object)realBufferedSource, (String)"<this>");
        boolean bl = l >= 0L;
        if (!bl) throw (Throwable)new IllegalArgumentException(Intrinsics.stringPlus((String)"limit < 0: ", (Object)l).toString());
        long l2 = l == Long.MAX_VALUE ? Long.MAX_VALUE : l + 1L;
        byte by = (byte)10;
        long l3 = realBufferedSource.indexOf(by, 0L, l2);
        if (l3 != -1L) {
            return _BufferKt.readUtf8Line((Buffer)realBufferedSource.bufferField, (long)l3);
        }
        if (l2 < Long.MAX_VALUE && realBufferedSource.request(l2) && realBufferedSource.bufferField.getByte(l2 - 1L) == (byte)13 && realBufferedSource.request(1L + l2) && realBufferedSource.bufferField.getByte(l2) == by) {
            return _BufferKt.readUtf8Line((Buffer)realBufferedSource.bufferField, (long)l2);
        }
        Buffer buffer = new Buffer();
        Object object = realBufferedSource.bufferField;
        l2 = realBufferedSource.bufferField.size();
        object.copyTo(buffer, 0L, Math.min((long)32, l2));
        object = new StringBuilder();
        ((StringBuilder)object).append("\\n not found: limit=");
        ((StringBuilder)object).append(Math.min(realBufferedSource.bufferField.size(), l));
        ((StringBuilder)object).append(" content=");
        ((StringBuilder)object).append(buffer.readByteString().hex());
        ((StringBuilder)object).append('\u2026');
        throw new EOFException(((StringBuilder)object).toString());
    }

    public static final boolean commonRequest(RealBufferedSource object, long l) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
        boolean bl = l >= 0L;
        if (!bl) {
            object = new IllegalArgumentException(Intrinsics.stringPlus((String)"byteCount < 0: ", (Object)l).toString());
            throw object;
        }
        if (!(object.closed ^ true)) throw (Throwable)new IllegalStateException("closed".toString());
        do {
            if (object.bufferField.size() >= l) return true;
        } while (object.source.read(object.bufferField, 8192L) != -1L);
        return false;
    }

    public static final void commonRequire(RealBufferedSource realBufferedSource, long l) {
        Intrinsics.checkNotNullParameter((Object)realBufferedSource, (String)"<this>");
        if (!realBufferedSource.request(l)) throw new EOFException();
    }

    public static final int commonSelect(RealBufferedSource object, Options options) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)options, (String)"options");
        if (!(object.closed ^ true)) {
            object = new IllegalStateException("closed".toString());
            throw object;
        }
        do {
            int n;
            if ((n = _BufferKt.selectPrefix((Buffer)object.bufferField, (Options)options, (boolean)true)) == -2) continue;
            if (n == -1) return -1;
            int n2 = options.getByteStrings$okio()[n].size();
            object.bufferField.skip((long)n2);
            return n;
        } while (object.source.read(object.bufferField, 8192L) != -1L);
        return -1;
    }

    public static final void commonSkip(RealBufferedSource object, long l) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
        if (!(object.closed ^ true)) {
            object = new IllegalStateException("closed".toString());
            throw object;
        }
        while (l > 0L) {
            if (object.bufferField.size() == 0L) {
                if (object.source.read(object.bufferField, 8192L) == -1L) throw new EOFException();
            }
            long l2 = Math.min(l, object.bufferField.size());
            object.bufferField.skip(l2);
            l -= l2;
        }
    }

    public static final Timeout commonTimeout(RealBufferedSource realBufferedSource) {
        Intrinsics.checkNotNullParameter((Object)realBufferedSource, (String)"<this>");
        return realBufferedSource.source.timeout();
    }

    public static final String commonToString(RealBufferedSource realBufferedSource) {
        Intrinsics.checkNotNullParameter((Object)realBufferedSource, (String)"<this>");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("buffer(");
        stringBuilder.append(realBufferedSource.source);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
