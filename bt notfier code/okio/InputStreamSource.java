/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okio.Buffer
 *  okio.Okio
 *  okio.Segment
 *  okio.SegmentPool
 *  okio.Source
 *  okio.Timeout
 */
package okio;

import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.Okio;
import okio.Segment;
import okio.SegmentPool;
import okio.Source;
import okio.Timeout;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0012\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2={"Lokio/InputStreamSource;", "Lokio/Source;", "input", "Ljava/io/InputStream;", "timeout", "Lokio/Timeout;", "(Ljava/io/InputStream;Lokio/Timeout;)V", "close", "", "read", "", "sink", "Lokio/Buffer;", "byteCount", "toString", "", "okio"}, k=1, mv={1, 5, 1}, xi=48)
class InputStreamSource
implements Source {
    private final InputStream input;
    private final Timeout timeout;

    public InputStreamSource(InputStream inputStream, Timeout timeout) {
        Intrinsics.checkNotNullParameter((Object)inputStream, (String)"input");
        Intrinsics.checkNotNullParameter((Object)timeout, (String)"timeout");
        this.input = inputStream;
        this.timeout = timeout;
    }

    public void close() {
        this.input.close();
    }

    public long read(Buffer buffer, long l) {
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"sink");
        if (l == 0L) {
            return 0L;
        }
        int n = l >= 0L ? 1 : 0;
        if (n == 0) throw (Throwable)new IllegalArgumentException(Intrinsics.stringPlus((String)"byteCount < 0: ", (Object)l).toString());
        try {
            this.timeout.throwIfReached();
            Segment segment = buffer.writableSegment$okio(1);
            n = (int)Math.min(l, (long)(8192 - segment.limit));
            n = this.input.read(segment.data, segment.limit, n);
            if (n == -1) {
                if (segment.pos != segment.limit) return -1L;
                buffer.head = segment.pop();
                SegmentPool.recycle((Segment)segment);
                return -1L;
            }
            segment.limit += n;
            l = buffer.size();
            long l2 = n;
            buffer.setSize$okio(l + l2);
            return l2;
        }
        catch (AssertionError assertionError) {
            if (!Okio.isAndroidGetsocknameError((AssertionError)assertionError)) throw assertionError;
            throw new IOException((Throwable)((Object)assertionError));
        }
    }

    public Timeout timeout() {
        return this.timeout;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("source(");
        stringBuilder.append(this.input);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
