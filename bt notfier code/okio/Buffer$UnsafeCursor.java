/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okio.Buffer
 *  okio.Segment
 *  okio.SegmentPool
 */
package okio;

import java.io.Closeable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.Segment;
import okio.SegmentPool;

@Metadata(d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u000e\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\bJ\u0006\u0010\u0018\u001a\u00020\bJ\u000e\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\nJ\u000e\u0010\u001b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0013\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2={"Lokio/Buffer$UnsafeCursor;", "Ljava/io/Closeable;", "()V", "buffer", "Lokio/Buffer;", "data", "", "end", "", "offset", "", "readWrite", "", "segment", "Lokio/Segment;", "getSegment$okio", "()Lokio/Segment;", "setSegment$okio", "(Lokio/Segment;)V", "start", "close", "", "expandBuffer", "minByteCount", "next", "resizeBuffer", "newSize", "seek", "okio"}, k=1, mv={1, 5, 1}, xi=48)
public static final class Buffer.UnsafeCursor
implements Closeable {
    public Buffer buffer;
    public byte[] data;
    public int end = -1;
    public long offset = -1L;
    public boolean readWrite;
    private Segment segment;
    public int start = -1;

    @Override
    public void close() {
        boolean bl = this.buffer != null;
        if (!bl) throw (Throwable)new IllegalStateException("not attached to a buffer".toString());
        this.buffer = null;
        this.setSegment$okio(null);
        this.offset = -1L;
        this.data = null;
        this.start = -1;
        this.end = -1;
    }

    public final long expandBuffer(int n) {
        boolean bl = true;
        boolean bl2 = n > 0;
        if (!bl2) throw (Throwable)new IllegalArgumentException(Intrinsics.stringPlus((String)"minByteCount <= 0: ", (Object)n).toString());
        bl2 = n <= 8192 ? bl : false;
        if (!bl2) throw (Throwable)new IllegalArgumentException(Intrinsics.stringPlus((String)"minByteCount > Segment.SIZE: ", (Object)n).toString());
        Buffer buffer = this.buffer;
        if (buffer == null) throw (Throwable)new IllegalStateException("not attached to a buffer".toString());
        if (!this.readWrite) throw (Throwable)new IllegalStateException("expandBuffer() only permitted for read/write buffers".toString());
        long l = buffer.size();
        Segment segment = buffer.writableSegment$okio(n);
        n = 8192 - segment.limit;
        segment.limit = 8192;
        long l2 = n;
        buffer.setSize$okio(l + l2);
        this.setSegment$okio(segment);
        this.offset = l;
        this.data = segment.data;
        this.start = 8192 - n;
        this.end = 8192;
        return l2;
    }

    public final Segment getSegment$okio() {
        return this.segment;
    }

    public final int next() {
        long l = this.offset;
        Buffer buffer = this.buffer;
        Intrinsics.checkNotNull((Object)buffer);
        boolean bl = l != buffer.size();
        if (!bl) throw (Throwable)new IllegalStateException("no more bytes".toString());
        l = this.offset;
        l = l == -1L ? 0L : (l += (long)(this.end - this.start));
        return this.seek(l);
    }

    public final long resizeBuffer(long l) {
        Object object = this.buffer;
        if (object == null) {
            object = new IllegalStateException("not attached to a buffer".toString());
            throw object;
        }
        if (!this.readWrite) throw (Throwable)new IllegalStateException("resizeBuffer() only permitted for read/write buffers".toString());
        long l2 = object.size();
        if (l <= l2) {
            long l3;
            boolean bl = l >= 0L;
            if (!bl) throw (Throwable)new IllegalArgumentException(Intrinsics.stringPlus((String)"newSize < 0: ", (Object)l).toString());
            for (long i = l2 - l; i > 0L; i -= l3) {
                Segment segment = object.head;
                Intrinsics.checkNotNull((Object)segment);
                segment = segment.prev;
                Intrinsics.checkNotNull((Object)segment);
                l3 = segment.limit - segment.pos;
                if (l3 <= i) {
                    object.head = segment.pop();
                    SegmentPool.recycle((Segment)segment);
                    continue;
                }
                segment.limit -= (int)i;
                break;
            }
            this.setSegment$okio(null);
            this.offset = l;
            this.data = null;
            this.start = -1;
            this.end = -1;
        } else if (l > l2) {
            int n;
            boolean bl = true;
            for (long i = l - l2; i > 0L; segment.limit += n, i -= (long)n) {
                Segment segment = object.writableSegment$okio(1);
                n = (int)Math.min(i, (long)(8192 - segment.limit));
                if (!bl) continue;
                this.setSegment$okio(segment);
                this.offset = l2;
                this.data = segment.data;
                this.start = segment.limit - n;
                this.end = segment.limit;
                bl = false;
            }
        }
        object.setSize$okio(l);
        return l2;
    }

    public final int seek(long l) {
        Buffer buffer = this.buffer;
        if (buffer == null) {
            Throwable throwable = new IllegalStateException("not attached to a buffer".toString());
            throw throwable;
        }
        if (l >= -1L && l <= buffer.size()) {
            int n = -1;
            if (l != -1L && l != buffer.size()) {
                long l2 = 0L;
                long l3 = buffer.size();
                Segment segment = buffer.head;
                Segment segment2 = buffer.head;
                long l4 = l2;
                long l5 = l3;
                Segment segment3 = segment;
                Segment segment4 = segment2;
                if (this.getSegment$okio() != null) {
                    l4 = this.offset;
                    n = this.start;
                    segment3 = this.getSegment$okio();
                    Intrinsics.checkNotNull((Object)segment3);
                    if ((l4 -= (long)(n - segment3.pos)) > l) {
                        segment4 = this.getSegment$okio();
                        l5 = l4;
                        l4 = l2;
                        segment3 = segment;
                    } else {
                        segment3 = this.getSegment$okio();
                        segment4 = segment2;
                        l5 = l3;
                    }
                }
                if (l5 - l > l - l4) {
                    segment4 = segment3;
                    while (true) {
                        Intrinsics.checkNotNull((Object)segment4);
                        l5 = l4;
                        segment3 = segment4;
                        if (l >= (long)(segment4.limit - segment4.pos) + l4) {
                            l4 += (long)(segment4.limit - segment4.pos);
                            segment4 = segment4.next;
                            continue;
                        }
                        break;
                    }
                } else {
                    for (l3 = l5; l3 > l; l3 -= (long)(segment4.limit - segment4.pos)) {
                        Intrinsics.checkNotNull((Object)segment4);
                        segment4 = segment4.prev;
                        Intrinsics.checkNotNull((Object)segment4);
                    }
                    l5 = l3;
                    segment3 = segment4;
                }
                segment4 = segment3;
                if (this.readWrite) {
                    Intrinsics.checkNotNull((Object)segment3);
                    segment4 = segment3;
                    if (segment3.shared) {
                        segment4 = segment3.unsharedCopy();
                        if (buffer.head == segment3) {
                            buffer.head = segment4;
                        }
                        segment4 = segment3.push(segment4);
                        segment3 = segment4.prev;
                        Intrinsics.checkNotNull((Object)segment3);
                        segment3.pop();
                    }
                }
                this.setSegment$okio(segment4);
                this.offset = l;
                Intrinsics.checkNotNull((Object)segment4);
                this.data = segment4.data;
                this.start = segment4.pos + (int)(l - l5);
                this.end = n = segment4.limit;
                n -= this.start;
            } else {
                this.setSegment$okio(null);
                this.offset = l;
                this.data = null;
                this.start = -1;
                this.end = -1;
            }
            return n;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("offset=");
        stringBuilder.append(l);
        stringBuilder.append(" > size=");
        stringBuilder.append(buffer.size());
        throw new ArrayIndexOutOfBoundsException(stringBuilder.toString());
    }

    public final void setSegment$okio(Segment segment) {
        this.segment = segment;
    }
}
