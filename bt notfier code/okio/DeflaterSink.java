/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okio.Buffer
 *  okio.BufferedSink
 *  okio.Okio
 *  okio.Segment
 *  okio.SegmentPool
 *  okio.Sink
 *  okio.Timeout
 *  okio._UtilKt
 */
package okio;

import java.io.IOException;
import java.util.zip.Deflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.BufferedSink;
import okio.Okio;
import okio.Segment;
import okio.SegmentPool;
import okio.Sink;
import okio.Timeout;
import okio._UtilKt;

@Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0006\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\tH\u0003J\r\u0010\u000e\u001a\u00020\u000bH\u0000\u00a2\u0006\u0002\b\u000fJ\b\u0010\u0010\u001a\u00020\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2={"Lokio/DeflaterSink;", "Lokio/Sink;", "sink", "deflater", "Ljava/util/zip/Deflater;", "(Lokio/Sink;Ljava/util/zip/Deflater;)V", "Lokio/BufferedSink;", "(Lokio/BufferedSink;Ljava/util/zip/Deflater;)V", "closed", "", "close", "", "deflate", "syncFlush", "finishDeflate", "finishDeflate$okio", "flush", "timeout", "Lokio/Timeout;", "toString", "", "write", "source", "Lokio/Buffer;", "byteCount", "", "okio"}, k=1, mv={1, 5, 1}, xi=48)
public final class DeflaterSink
implements Sink {
    private boolean closed;
    private final Deflater deflater;
    private final BufferedSink sink;

    public DeflaterSink(BufferedSink bufferedSink, Deflater deflater) {
        Intrinsics.checkNotNullParameter((Object)bufferedSink, (String)"sink");
        Intrinsics.checkNotNullParameter((Object)deflater, (String)"deflater");
        this.sink = bufferedSink;
        this.deflater = deflater;
    }

    public DeflaterSink(Sink sink, Deflater deflater) {
        Intrinsics.checkNotNullParameter((Object)sink, (String)"sink");
        Intrinsics.checkNotNullParameter((Object)deflater, (String)"deflater");
        this(Okio.buffer((Sink)sink), deflater);
    }

    private final void deflate(boolean bl) {
        Segment segment;
        Buffer buffer = this.sink.getBuffer();
        while (true) {
            segment = buffer.writableSegment$okio(1);
            int n = bl ? this.deflater.deflate(segment.data, segment.limit, 8192 - segment.limit, 2) : this.deflater.deflate(segment.data, segment.limit, 8192 - segment.limit);
            if (n > 0) {
                segment.limit += n;
                buffer.setSize$okio(buffer.size() + (long)n);
                this.sink.emitCompleteSegments();
                continue;
            }
            if (this.deflater.needsInput()) break;
        }
        if (segment.pos != segment.limit) return;
        buffer.head = segment.pop();
        SegmentPool.recycle((Segment)segment);
    }

    public void close() throws IOException {
        Throwable throwable;
        block8: {
            Throwable throwable2;
            block7: {
                if (this.closed) {
                    return;
                }
                throwable = null;
                try {
                    this.finishDeflate$okio();
                }
                catch (Throwable throwable3) {
                    // empty catch block
                }
                try {
                    this.deflater.end();
                    throwable2 = throwable;
                }
                catch (Throwable throwable4) {
                    throwable2 = throwable;
                    if (throwable != null) break block7;
                    throwable2 = throwable4;
                }
            }
            try {
                this.sink.close();
                throwable = throwable2;
            }
            catch (Throwable throwable5) {
                throwable = throwable2;
                if (throwable2 != null) break block8;
                throwable = throwable5;
            }
        }
        this.closed = true;
        if (throwable != null) throw throwable;
    }

    public final void finishDeflate$okio() {
        this.deflater.finish();
        this.deflate(false);
    }

    public void flush() throws IOException {
        this.deflate(true);
        this.sink.flush();
    }

    public Timeout timeout() {
        return this.sink.timeout();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DeflaterSink(");
        stringBuilder.append(this.sink);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    public void write(Buffer buffer, long l) throws IOException {
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"source");
        _UtilKt.checkOffsetAndCount((long)buffer.size(), (long)0L, (long)l);
        while (l > 0L) {
            Segment segment = buffer.head;
            Intrinsics.checkNotNull((Object)segment);
            int n = (int)Math.min(l, (long)(segment.limit - segment.pos));
            this.deflater.setInput(segment.data, segment.pos, n);
            this.deflate(false);
            long l2 = buffer.size();
            long l3 = n;
            buffer.setSize$okio(l2 - l3);
            segment.pos += n;
            if (segment.pos == segment.limit) {
                buffer.head = segment.pop();
                SegmentPool.recycle((Segment)segment);
            }
            l -= l3;
        }
    }
}
