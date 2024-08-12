/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okio.Buffer
 *  okio.BufferedSink
 *  okio.ByteString
 *  okio.RealBufferedSink
 *  okio.Source
 *  okio.Timeout
 */
package okio.internal;

import java.io.EOFException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.RealBufferedSink;
import okio.Source;
import okio.Timeout;

@Metadata(d1={"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0080\b\u001a\r\u0010\u0003\u001a\u00020\u0004*\u00020\u0002H\u0080\b\u001a\r\u0010\u0005\u001a\u00020\u0004*\u00020\u0002H\u0080\b\u001a\r\u0010\u0006\u001a\u00020\u0001*\u00020\u0002H\u0080\b\u001a\r\u0010\u0007\u001a\u00020\b*\u00020\u0002H\u0080\b\u001a\r\u0010\t\u001a\u00020\n*\u00020\u0002H\u0080\b\u001a\u0015\u0010\u000b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0080\b\u001a%\u0010\u000b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0080\b\u001a\u001d\u0010\u000b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\f\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0012H\u0080\b\u001a\u0015\u0010\u000b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0080\b\u001a%\u0010\u000b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0080\b\u001a\u001d\u0010\u000b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\f\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0012H\u0080\b\u001a\u0015\u0010\u0016\u001a\u00020\u0012*\u00020\u00022\u0006\u0010\f\u001a\u00020\u0015H\u0080\b\u001a\u0015\u0010\u0017\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u000fH\u0080\b\u001a\u0015\u0010\u0019\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0012H\u0080\b\u001a\u0015\u0010\u001b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0012H\u0080\b\u001a\u0015\u0010\u001c\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u000fH\u0080\b\u001a\u0015\u0010\u001e\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u000fH\u0080\b\u001a\u0015\u0010\u001f\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0012H\u0080\b\u001a\u0015\u0010 \u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0012H\u0080\b\u001a\u0015\u0010!\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\"\u001a\u00020\u000fH\u0080\b\u001a\u0015\u0010#\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\"\u001a\u00020\u000fH\u0080\b\u001a\u0015\u0010$\u001a\u00020\u0004*\u00020\u00022\u0006\u0010%\u001a\u00020\nH\u0080\b\u001a%\u0010$\u001a\u00020\u0004*\u00020\u00022\u0006\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\u000fH\u0080\b\u001a\u0015\u0010(\u001a\u00020\u0004*\u00020\u00022\u0006\u0010)\u001a\u00020\u000fH\u0080\b\u00a8\u0006*"}, d2={"commonClose", "", "Lokio/RealBufferedSink;", "commonEmit", "Lokio/BufferedSink;", "commonEmitCompleteSegments", "commonFlush", "commonTimeout", "Lokio/Timeout;", "commonToString", "", "commonWrite", "source", "", "offset", "", "byteCount", "Lokio/Buffer;", "", "byteString", "Lokio/ByteString;", "Lokio/Source;", "commonWriteAll", "commonWriteByte", "b", "commonWriteDecimalLong", "v", "commonWriteHexadecimalUnsignedLong", "commonWriteInt", "i", "commonWriteIntLe", "commonWriteLong", "commonWriteLongLe", "commonWriteShort", "s", "commonWriteShortLe", "commonWriteUtf8", "string", "beginIndex", "endIndex", "commonWriteUtf8CodePoint", "codePoint", "okio"}, k=2, mv={1, 5, 1}, xi=48)
public final class _RealBufferedSinkKt {
    public static final void commonClose(RealBufferedSink realBufferedSink) {
        Throwable throwable;
        block6: {
            Intrinsics.checkNotNullParameter((Object)realBufferedSink, (String)"<this>");
            if (realBufferedSink.closed) {
                return;
            }
            Throwable throwable2 = throwable = null;
            try {
                if (realBufferedSink.bufferField.size() > 0L) {
                    realBufferedSink.sink.write(realBufferedSink.bufferField, realBufferedSink.bufferField.size());
                    throwable2 = throwable;
                }
            }
            catch (Throwable throwable3) {
                // empty catch block
            }
            try {
                realBufferedSink.sink.close();
                throwable = throwable2;
            }
            catch (Throwable throwable4) {
                throwable = throwable2;
                if (throwable2 != null) break block6;
                throwable = throwable4;
            }
        }
        realBufferedSink.closed = true;
        if (throwable != null) throw throwable;
    }

    public static final BufferedSink commonEmit(RealBufferedSink realBufferedSink) {
        Intrinsics.checkNotNullParameter((Object)realBufferedSink, (String)"<this>");
        if (!(realBufferedSink.closed ^ true)) throw (Throwable)new IllegalStateException("closed".toString());
        long l = realBufferedSink.bufferField.size();
        if (l <= 0L) return (BufferedSink)realBufferedSink;
        realBufferedSink.sink.write(realBufferedSink.bufferField, l);
        return (BufferedSink)realBufferedSink;
    }

    public static final BufferedSink commonEmitCompleteSegments(RealBufferedSink realBufferedSink) {
        Intrinsics.checkNotNullParameter((Object)realBufferedSink, (String)"<this>");
        if (!(realBufferedSink.closed ^ true)) throw (Throwable)new IllegalStateException("closed".toString());
        long l = realBufferedSink.bufferField.completeSegmentByteCount();
        if (l <= 0L) return (BufferedSink)realBufferedSink;
        realBufferedSink.sink.write(realBufferedSink.bufferField, l);
        return (BufferedSink)realBufferedSink;
    }

    public static final void commonFlush(RealBufferedSink realBufferedSink) {
        Intrinsics.checkNotNullParameter((Object)realBufferedSink, (String)"<this>");
        if (!(realBufferedSink.closed ^ true)) throw (Throwable)new IllegalStateException("closed".toString());
        if (realBufferedSink.bufferField.size() > 0L) {
            realBufferedSink.sink.write(realBufferedSink.bufferField, realBufferedSink.bufferField.size());
        }
        realBufferedSink.sink.flush();
    }

    public static final Timeout commonTimeout(RealBufferedSink realBufferedSink) {
        Intrinsics.checkNotNullParameter((Object)realBufferedSink, (String)"<this>");
        return realBufferedSink.sink.timeout();
    }

    public static final String commonToString(RealBufferedSink realBufferedSink) {
        Intrinsics.checkNotNullParameter((Object)realBufferedSink, (String)"<this>");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("buffer(");
        stringBuilder.append(realBufferedSink.sink);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    public static final BufferedSink commonWrite(RealBufferedSink realBufferedSink, ByteString byteString) {
        Intrinsics.checkNotNullParameter((Object)realBufferedSink, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"byteString");
        if (!(realBufferedSink.closed ^ true)) throw (Throwable)new IllegalStateException("closed".toString());
        realBufferedSink.bufferField.write(byteString);
        return realBufferedSink.emitCompleteSegments();
    }

    public static final BufferedSink commonWrite(RealBufferedSink realBufferedSink, ByteString byteString, int n, int n2) {
        Intrinsics.checkNotNullParameter((Object)realBufferedSink, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"byteString");
        if (!(realBufferedSink.closed ^ true)) throw (Throwable)new IllegalStateException("closed".toString());
        realBufferedSink.bufferField.write(byteString, n, n2);
        return realBufferedSink.emitCompleteSegments();
    }

    public static final BufferedSink commonWrite(RealBufferedSink realBufferedSink, Source source, long l) {
        Intrinsics.checkNotNullParameter((Object)realBufferedSink, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        while (l > 0L) {
            long l2 = source.read(realBufferedSink.bufferField, l);
            if (l2 == -1L) throw new EOFException();
            l -= l2;
            realBufferedSink.emitCompleteSegments();
        }
        return (BufferedSink)realBufferedSink;
    }

    public static final BufferedSink commonWrite(RealBufferedSink realBufferedSink, byte[] byArray) {
        Intrinsics.checkNotNullParameter((Object)realBufferedSink, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"source");
        if (!(realBufferedSink.closed ^ true)) throw (Throwable)new IllegalStateException("closed".toString());
        realBufferedSink.bufferField.write(byArray);
        return realBufferedSink.emitCompleteSegments();
    }

    public static final BufferedSink commonWrite(RealBufferedSink realBufferedSink, byte[] byArray, int n, int n2) {
        Intrinsics.checkNotNullParameter((Object)realBufferedSink, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"source");
        if (!(realBufferedSink.closed ^ true)) throw (Throwable)new IllegalStateException("closed".toString());
        realBufferedSink.bufferField.write(byArray, n, n2);
        return realBufferedSink.emitCompleteSegments();
    }

    public static final void commonWrite(RealBufferedSink realBufferedSink, Buffer buffer, long l) {
        Intrinsics.checkNotNullParameter((Object)realBufferedSink, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"source");
        if (!(realBufferedSink.closed ^ true)) throw (Throwable)new IllegalStateException("closed".toString());
        realBufferedSink.bufferField.write(buffer, l);
        realBufferedSink.emitCompleteSegments();
    }

    public static final long commonWriteAll(RealBufferedSink realBufferedSink, Source source) {
        Intrinsics.checkNotNullParameter((Object)realBufferedSink, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        long l = 0L;
        long l2;
        while ((l2 = source.read(realBufferedSink.bufferField, 8192L)) != -1L) {
            l += l2;
            realBufferedSink.emitCompleteSegments();
        }
        return l;
    }

    public static final BufferedSink commonWriteByte(RealBufferedSink realBufferedSink, int n) {
        Intrinsics.checkNotNullParameter((Object)realBufferedSink, (String)"<this>");
        if (!(realBufferedSink.closed ^ true)) throw (Throwable)new IllegalStateException("closed".toString());
        realBufferedSink.bufferField.writeByte(n);
        return realBufferedSink.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteDecimalLong(RealBufferedSink realBufferedSink, long l) {
        Intrinsics.checkNotNullParameter((Object)realBufferedSink, (String)"<this>");
        if (!(realBufferedSink.closed ^ true)) throw (Throwable)new IllegalStateException("closed".toString());
        realBufferedSink.bufferField.writeDecimalLong(l);
        return realBufferedSink.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteHexadecimalUnsignedLong(RealBufferedSink realBufferedSink, long l) {
        Intrinsics.checkNotNullParameter((Object)realBufferedSink, (String)"<this>");
        if (!(realBufferedSink.closed ^ true)) throw (Throwable)new IllegalStateException("closed".toString());
        realBufferedSink.bufferField.writeHexadecimalUnsignedLong(l);
        return realBufferedSink.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteInt(RealBufferedSink realBufferedSink, int n) {
        Intrinsics.checkNotNullParameter((Object)realBufferedSink, (String)"<this>");
        if (!(realBufferedSink.closed ^ true)) throw (Throwable)new IllegalStateException("closed".toString());
        realBufferedSink.bufferField.writeInt(n);
        return realBufferedSink.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteIntLe(RealBufferedSink realBufferedSink, int n) {
        Intrinsics.checkNotNullParameter((Object)realBufferedSink, (String)"<this>");
        if (!(realBufferedSink.closed ^ true)) throw (Throwable)new IllegalStateException("closed".toString());
        realBufferedSink.bufferField.writeIntLe(n);
        return realBufferedSink.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteLong(RealBufferedSink realBufferedSink, long l) {
        Intrinsics.checkNotNullParameter((Object)realBufferedSink, (String)"<this>");
        if (!(realBufferedSink.closed ^ true)) throw (Throwable)new IllegalStateException("closed".toString());
        realBufferedSink.bufferField.writeLong(l);
        return realBufferedSink.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteLongLe(RealBufferedSink realBufferedSink, long l) {
        Intrinsics.checkNotNullParameter((Object)realBufferedSink, (String)"<this>");
        if (!(realBufferedSink.closed ^ true)) throw (Throwable)new IllegalStateException("closed".toString());
        realBufferedSink.bufferField.writeLongLe(l);
        return realBufferedSink.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteShort(RealBufferedSink realBufferedSink, int n) {
        Intrinsics.checkNotNullParameter((Object)realBufferedSink, (String)"<this>");
        if (!(realBufferedSink.closed ^ true)) throw (Throwable)new IllegalStateException("closed".toString());
        realBufferedSink.bufferField.writeShort(n);
        return realBufferedSink.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteShortLe(RealBufferedSink realBufferedSink, int n) {
        Intrinsics.checkNotNullParameter((Object)realBufferedSink, (String)"<this>");
        if (!(realBufferedSink.closed ^ true)) throw (Throwable)new IllegalStateException("closed".toString());
        realBufferedSink.bufferField.writeShortLe(n);
        return realBufferedSink.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteUtf8(RealBufferedSink realBufferedSink, String string) {
        Intrinsics.checkNotNullParameter((Object)realBufferedSink, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)string, (String)"string");
        if (!(realBufferedSink.closed ^ true)) throw (Throwable)new IllegalStateException("closed".toString());
        realBufferedSink.bufferField.writeUtf8(string);
        return realBufferedSink.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteUtf8(RealBufferedSink realBufferedSink, String string, int n, int n2) {
        Intrinsics.checkNotNullParameter((Object)realBufferedSink, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)string, (String)"string");
        if (!(realBufferedSink.closed ^ true)) throw (Throwable)new IllegalStateException("closed".toString());
        realBufferedSink.bufferField.writeUtf8(string, n, n2);
        return realBufferedSink.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteUtf8CodePoint(RealBufferedSink realBufferedSink, int n) {
        Intrinsics.checkNotNullParameter((Object)realBufferedSink, (String)"<this>");
        if (!(realBufferedSink.closed ^ true)) throw (Throwable)new IllegalStateException("closed".toString());
        realBufferedSink.bufferField.writeUtf8CodePoint(n);
        return realBufferedSink.emitCompleteSegments();
    }
}
