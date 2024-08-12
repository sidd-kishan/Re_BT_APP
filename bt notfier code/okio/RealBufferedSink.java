/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okio.Buffer
 *  okio.BufferedSink
 *  okio.ByteString
 *  okio.Sink
 *  okio.Source
 *  okio.Timeout
 */
package okio;

import java.io.EOFException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.Sink;
import okio.Source;
import okio.Timeout;

@Metadata(d1={"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0001H\u0016J\b\u0010\u0011\u001a\u00020\u0001H\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016J\b\u0010\u0013\u001a\u00020\rH\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001eH\u0016J \u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u001bH\u0016J\u0018\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\u001a\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020#H\u0016J \u0010\u001a\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u001bH\u0016J\u0018\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020$2\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010%\u001a\u00020!2\u0006\u0010\u001c\u001a\u00020$H\u0016J\u0010\u0010&\u001a\u00020\u00012\u0006\u0010'\u001a\u00020\u001bH\u0016J\u0010\u0010(\u001a\u00020\u00012\u0006\u0010)\u001a\u00020!H\u0016J\u0010\u0010*\u001a\u00020\u00012\u0006\u0010)\u001a\u00020!H\u0016J\u0010\u0010+\u001a\u00020\u00012\u0006\u0010,\u001a\u00020\u001bH\u0016J\u0010\u0010-\u001a\u00020\u00012\u0006\u0010,\u001a\u00020\u001bH\u0016J\u0010\u0010.\u001a\u00020\u00012\u0006\u0010)\u001a\u00020!H\u0016J\u0010\u0010/\u001a\u00020\u00012\u0006\u0010)\u001a\u00020!H\u0016J\u0010\u00100\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u001bH\u0016J\u0010\u00102\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u001bH\u0016J\u0018\u00103\u001a\u00020\u00012\u0006\u00104\u001a\u00020\u00192\u0006\u00105\u001a\u000206H\u0016J(\u00103\u001a\u00020\u00012\u0006\u00104\u001a\u00020\u00192\u0006\u00107\u001a\u00020\u001b2\u0006\u00108\u001a\u00020\u001b2\u0006\u00105\u001a\u000206H\u0016J\u0010\u00109\u001a\u00020\u00012\u0006\u00104\u001a\u00020\u0019H\u0016J \u00109\u001a\u00020\u00012\u0006\u00104\u001a\u00020\u00192\u0006\u00107\u001a\u00020\u001b2\u0006\u00108\u001a\u00020\u001bH\u0016J\u0010\u0010:\u001a\u00020\u00012\u0006\u0010;\u001a\u00020\u001bH\u0016R\u001b\u0010\u0005\u001a\u00020\u00068\u00d6\u0002X\u0096\u0004\u00a2\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006<"}, d2={"Lokio/RealBufferedSink;", "Lokio/BufferedSink;", "sink", "Lokio/Sink;", "(Lokio/Sink;)V", "buffer", "Lokio/Buffer;", "getBuffer$annotations", "()V", "getBuffer", "()Lokio/Buffer;", "bufferField", "closed", "", "close", "", "emit", "emitCompleteSegments", "flush", "isOpen", "outputStream", "Ljava/io/OutputStream;", "timeout", "Lokio/Timeout;", "toString", "", "write", "", "source", "Ljava/nio/ByteBuffer;", "", "offset", "byteCount", "", "byteString", "Lokio/ByteString;", "Lokio/Source;", "writeAll", "writeByte", "b", "writeDecimalLong", "v", "writeHexadecimalUnsignedLong", "writeInt", "i", "writeIntLe", "writeLong", "writeLongLe", "writeShort", "s", "writeShortLe", "writeString", "string", "charset", "Ljava/nio/charset/Charset;", "beginIndex", "endIndex", "writeUtf8", "writeUtf8CodePoint", "codePoint", "okio"}, k=1, mv={1, 5, 1}, xi=48)
public final class RealBufferedSink
implements BufferedSink {
    public final Buffer bufferField;
    public boolean closed;
    public final Sink sink;

    public RealBufferedSink(Sink sink) {
        Intrinsics.checkNotNullParameter((Object)sink, (String)"sink");
        this.sink = sink;
        this.bufferField = new Buffer();
    }

    public static /* synthetic */ void getBuffer$annotations() {
    }

    public Buffer buffer() {
        return this.bufferField;
    }

    public void close() {
        Throwable throwable;
        block5: {
            if (this.closed) return;
            Throwable throwable2 = throwable = null;
            try {
                if (this.bufferField.size() > 0L) {
                    this.sink.write(this.bufferField, this.bufferField.size());
                    throwable2 = throwable;
                }
            }
            catch (Throwable throwable3) {
                // empty catch block
            }
            try {
                this.sink.close();
                throwable = throwable2;
            }
            catch (Throwable throwable4) {
                throwable = throwable2;
                if (throwable2 != null) break block5;
                throwable = throwable4;
            }
        }
        this.closed = true;
        if (throwable != null) throw throwable;
    }

    public BufferedSink emit() {
        if (!(this.closed ^ true)) throw (Throwable)new IllegalStateException("closed".toString());
        long l = this.bufferField.size();
        if (l <= 0L) return this;
        this.sink.write(this.bufferField, l);
        return this;
    }

    public BufferedSink emitCompleteSegments() {
        if (!(this.closed ^ true)) throw (Throwable)new IllegalStateException("closed".toString());
        long l = this.bufferField.completeSegmentByteCount();
        if (l <= 0L) return this;
        this.sink.write(this.bufferField, l);
        return this;
    }

    public void flush() {
        if (!(this.closed ^ true)) throw (Throwable)new IllegalStateException("closed".toString());
        if (this.bufferField.size() > 0L) {
            Sink sink = this.sink;
            Buffer buffer = this.bufferField;
            sink.write(buffer, buffer.size());
        }
        this.sink.flush();
    }

    public Buffer getBuffer() {
        return this.bufferField;
    }

    public boolean isOpen() {
        return this.closed ^ true;
    }

    public OutputStream outputStream() {
        return (OutputStream)new /* Unavailable Anonymous Inner Class!! */;
    }

    public Timeout timeout() {
        return this.sink.timeout();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("buffer(");
        stringBuilder.append(this.sink);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    public int write(ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter((Object)byteBuffer, (String)"source");
        if (!(this.closed ^ true)) throw (Throwable)new IllegalStateException("closed".toString());
        int n = this.bufferField.write(byteBuffer);
        this.emitCompleteSegments();
        return n;
    }

    public BufferedSink write(ByteString byteString) {
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"byteString");
        if (!(this.closed ^ true)) throw (Throwable)new IllegalStateException("closed".toString());
        this.bufferField.write(byteString);
        return this.emitCompleteSegments();
    }

    public BufferedSink write(ByteString byteString, int n, int n2) {
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"byteString");
        if (!(this.closed ^ true)) throw (Throwable)new IllegalStateException("closed".toString());
        this.bufferField.write(byteString, n, n2);
        return this.emitCompleteSegments();
    }

    public BufferedSink write(Source source, long l) {
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        while (l > 0L) {
            long l2 = source.read(this.bufferField, l);
            if (l2 == -1L) throw new EOFException();
            l -= l2;
            this.emitCompleteSegments();
        }
        return this;
    }

    public BufferedSink write(byte[] byArray) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"source");
        if (!(this.closed ^ true)) throw (Throwable)new IllegalStateException("closed".toString());
        this.bufferField.write(byArray);
        return this.emitCompleteSegments();
    }

    public BufferedSink write(byte[] byArray, int n, int n2) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"source");
        if (!(this.closed ^ true)) throw (Throwable)new IllegalStateException("closed".toString());
        this.bufferField.write(byArray, n, n2);
        return this.emitCompleteSegments();
    }

    public void write(Buffer buffer, long l) {
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"source");
        if (!(this.closed ^ true)) throw (Throwable)new IllegalStateException("closed".toString());
        this.bufferField.write(buffer, l);
        this.emitCompleteSegments();
    }

    public long writeAll(Source source) {
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        long l = 0L;
        long l2;
        while ((l2 = source.read(this.bufferField, 8192L)) != -1L) {
            l += l2;
            this.emitCompleteSegments();
        }
        return l;
    }

    public BufferedSink writeByte(int n) {
        if (!(this.closed ^ true)) throw (Throwable)new IllegalStateException("closed".toString());
        this.bufferField.writeByte(n);
        return this.emitCompleteSegments();
    }

    public BufferedSink writeDecimalLong(long l) {
        if (!(this.closed ^ true)) throw (Throwable)new IllegalStateException("closed".toString());
        this.bufferField.writeDecimalLong(l);
        return this.emitCompleteSegments();
    }

    public BufferedSink writeHexadecimalUnsignedLong(long l) {
        if (!(this.closed ^ true)) throw (Throwable)new IllegalStateException("closed".toString());
        this.bufferField.writeHexadecimalUnsignedLong(l);
        return this.emitCompleteSegments();
    }

    public BufferedSink writeInt(int n) {
        if (!(this.closed ^ true)) throw (Throwable)new IllegalStateException("closed".toString());
        this.bufferField.writeInt(n);
        return this.emitCompleteSegments();
    }

    public BufferedSink writeIntLe(int n) {
        if (!(this.closed ^ true)) throw (Throwable)new IllegalStateException("closed".toString());
        this.bufferField.writeIntLe(n);
        return this.emitCompleteSegments();
    }

    public BufferedSink writeLong(long l) {
        if (!(this.closed ^ true)) throw (Throwable)new IllegalStateException("closed".toString());
        this.bufferField.writeLong(l);
        return this.emitCompleteSegments();
    }

    public BufferedSink writeLongLe(long l) {
        if (!(this.closed ^ true)) throw (Throwable)new IllegalStateException("closed".toString());
        this.bufferField.writeLongLe(l);
        return this.emitCompleteSegments();
    }

    public BufferedSink writeShort(int n) {
        if (!(this.closed ^ true)) throw (Throwable)new IllegalStateException("closed".toString());
        this.bufferField.writeShort(n);
        return this.emitCompleteSegments();
    }

    public BufferedSink writeShortLe(int n) {
        if (!(this.closed ^ true)) throw (Throwable)new IllegalStateException("closed".toString());
        this.bufferField.writeShortLe(n);
        return this.emitCompleteSegments();
    }

    public BufferedSink writeString(String string, int n, int n2, Charset charset) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"string");
        Intrinsics.checkNotNullParameter((Object)charset, (String)"charset");
        if (!(this.closed ^ true)) throw (Throwable)new IllegalStateException("closed".toString());
        this.bufferField.writeString(string, n, n2, charset);
        return this.emitCompleteSegments();
    }

    public BufferedSink writeString(String string, Charset charset) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"string");
        Intrinsics.checkNotNullParameter((Object)charset, (String)"charset");
        if (!(this.closed ^ true)) throw (Throwable)new IllegalStateException("closed".toString());
        this.bufferField.writeString(string, charset);
        return this.emitCompleteSegments();
    }

    public BufferedSink writeUtf8(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"string");
        if (!(this.closed ^ true)) throw (Throwable)new IllegalStateException("closed".toString());
        this.bufferField.writeUtf8(string);
        return this.emitCompleteSegments();
    }

    public BufferedSink writeUtf8(String string, int n, int n2) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"string");
        if (!(this.closed ^ true)) throw (Throwable)new IllegalStateException("closed".toString());
        this.bufferField.writeUtf8(string, n, n2);
        return this.emitCompleteSegments();
    }

    public BufferedSink writeUtf8CodePoint(int n) {
        if (!(this.closed ^ true)) throw (Throwable)new IllegalStateException("closed".toString());
        this.bufferField.writeUtf8CodePoint(n);
        return this.emitCompleteSegments();
    }
}
