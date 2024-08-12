/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okio.Buffer
 *  okio.BufferedSource
 *  okio.Segment
 *  okio.Source
 *  okio.Timeout
 */
package okio;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.BufferedSource;
import okio.Segment;
import okio.Source;
import okio.Timeout;

@Metadata(d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2={"Lokio/PeekSource;", "Lokio/Source;", "upstream", "Lokio/BufferedSource;", "(Lokio/BufferedSource;)V", "buffer", "Lokio/Buffer;", "closed", "", "expectedPos", "", "expectedSegment", "Lokio/Segment;", "pos", "", "close", "", "read", "sink", "byteCount", "timeout", "Lokio/Timeout;", "okio"}, k=1, mv={1, 5, 1}, xi=48)
public final class PeekSource
implements Source {
    private final Buffer buffer;
    private boolean closed;
    private int expectedPos;
    private Segment expectedSegment;
    private long pos;
    private final BufferedSource upstream;

    public PeekSource(BufferedSource bufferedSource) {
        Intrinsics.checkNotNullParameter((Object)bufferedSource, (String)"upstream");
        this.upstream = bufferedSource;
        bufferedSource = bufferedSource.getBuffer();
        this.buffer = bufferedSource;
        this.expectedSegment = bufferedSource.head;
        bufferedSource = this.buffer.head;
        int n = bufferedSource == null ? -1 : bufferedSource.pos;
        this.expectedPos = n;
    }

    public void close() {
        this.closed = true;
    }

    public long read(Buffer buffer, long l) {
        Segment segment;
        boolean bl;
        block7: {
            block6: {
                Intrinsics.checkNotNullParameter((Object)buffer, (String)"sink");
                boolean bl2 = false;
                bl = l >= 0L;
                if (!bl) throw (Throwable)new IllegalArgumentException(Intrinsics.stringPlus((String)"byteCount < 0: ", (Object)l).toString());
                if (!(this.closed ^ true)) throw (Throwable)new IllegalStateException("closed".toString());
                segment = this.expectedSegment;
                if (segment == null) break block6;
                bl = bl2;
                if (segment != this.buffer.head) break block7;
                int n = this.expectedPos;
                segment = this.buffer.head;
                Intrinsics.checkNotNull((Object)segment);
                bl = bl2;
                if (n != segment.pos) break block7;
            }
            bl = true;
        }
        if (!bl) throw (Throwable)new IllegalStateException("Peek source is invalid because upstream source was used".toString());
        if (l == 0L) {
            return 0L;
        }
        if (!this.upstream.request(this.pos + 1L)) {
            return -1L;
        }
        if (this.expectedSegment == null && this.buffer.head != null) {
            this.expectedSegment = this.buffer.head;
            segment = this.buffer.head;
            Intrinsics.checkNotNull((Object)segment);
            this.expectedPos = segment.pos;
        }
        l = Math.min(l, this.buffer.size() - this.pos);
        this.buffer.copyTo(buffer, this.pos, l);
        this.pos += l;
        return l;
    }

    public Timeout timeout() {
        return this.upstream.timeout();
    }
}
