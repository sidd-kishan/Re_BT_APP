/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okio.Buffer
 *  okio.BufferedSink
 *  okio.Segment
 *  okio.SegmentPool
 *  okio.Sink
 *  okio.Timeout
 *  okio._UtilKt
 */
package okio;

import java.io.IOException;
import javax.crypto.Cipher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.BufferedSink;
import okio.Segment;
import okio.SegmentPool;
import okio.Sink;
import okio.Timeout;
import okio._UtilKt;

@Metadata(d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0018\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0018H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2={"Lokio/CipherSink;", "Lokio/Sink;", "sink", "Lokio/BufferedSink;", "cipher", "Ljavax/crypto/Cipher;", "(Lokio/BufferedSink;Ljavax/crypto/Cipher;)V", "blockSize", "", "getCipher", "()Ljavax/crypto/Cipher;", "closed", "", "close", "", "doFinal", "", "flush", "timeout", "Lokio/Timeout;", "update", "source", "Lokio/Buffer;", "remaining", "", "write", "byteCount", "okio"}, k=1, mv={1, 5, 1}, xi=48)
public final class CipherSink
implements Sink {
    private final int blockSize;
    private final Cipher cipher;
    private boolean closed;
    private final BufferedSink sink;

    public CipherSink(BufferedSink bufferedSink, Cipher cipher) {
        int n;
        Intrinsics.checkNotNullParameter((Object)bufferedSink, (String)"sink");
        Intrinsics.checkNotNullParameter((Object)cipher, (String)"cipher");
        this.sink = bufferedSink;
        this.cipher = cipher;
        this.blockSize = n = cipher.getBlockSize();
        n = n > 0 ? 1 : 0;
        if (n == 0) throw (Throwable)new IllegalArgumentException(Intrinsics.stringPlus((String)"Block cipher required ", (Object)this.getCipher()).toString());
    }

    private final Throwable doFinal() {
        int n = this.cipher.getOutputSize(0);
        Throwable throwable = null;
        if (n == 0) {
            return null;
        }
        Buffer buffer = this.sink.getBuffer();
        Segment segment = buffer.writableSegment$okio(n);
        try {
            n = this.cipher.doFinal(segment.data, segment.limit);
            segment.limit += n;
            buffer.setSize$okio(buffer.size() + (long)n);
        }
        catch (Throwable throwable2) {
            // empty catch block
        }
        if (segment.pos != segment.limit) return throwable;
        buffer.head = segment.pop();
        SegmentPool.recycle((Segment)segment);
        return throwable;
    }

    private final int update(Buffer object, long l) {
        Segment segment = ((Buffer)object).head;
        Intrinsics.checkNotNull((Object)segment);
        int n = (int)Math.min(l, (long)(segment.limit - segment.pos));
        Buffer buffer = this.sink.getBuffer();
        int n2 = this.cipher.getOutputSize(n);
        while (n2 > 8192) {
            boolean bl = n > this.blockSize;
            if (!bl) {
                object = new StringBuilder();
                ((StringBuilder)object).append("Unexpected output size ");
                ((StringBuilder)object).append(n2);
                ((StringBuilder)object).append(" for input size ");
                ((StringBuilder)object).append(n);
                throw (Throwable)new IllegalStateException(((StringBuilder)object).toString().toString());
            }
            n2 = this.cipher.getOutputSize(n -= this.blockSize);
        }
        Segment segment2 = buffer.writableSegment$okio(n2);
        n2 = this.cipher.update(segment.data, segment.pos, n, segment2.data, segment2.limit);
        segment2.limit += n2;
        buffer.setSize$okio(buffer.size() + (long)n2);
        if (segment2.pos == segment2.limit) {
            buffer.head = segment2.pop();
            SegmentPool.recycle((Segment)segment2);
        }
        this.sink.emitCompleteSegments();
        object.setSize$okio(object.size() - (long)n);
        segment.pos += n;
        if (segment.pos != segment.limit) return n;
        ((Buffer)object).head = segment.pop();
        SegmentPool.recycle((Segment)segment);
        return n;
    }

    public void close() throws IOException {
        Throwable throwable;
        block3: {
            if (this.closed) {
                return;
            }
            this.closed = true;
            Throwable throwable2 = this.doFinal();
            try {
                this.sink.close();
                throwable = throwable2;
            }
            catch (Throwable throwable3) {
                throwable = throwable2;
                if (throwable2 != null) break block3;
                throwable = throwable3;
            }
        }
        if (throwable != null) throw throwable;
    }

    public void flush() {
        this.sink.flush();
    }

    public final Cipher getCipher() {
        return this.cipher;
    }

    public Timeout timeout() {
        return this.sink.timeout();
    }

    public void write(Buffer object, long l) throws IOException {
        Intrinsics.checkNotNullParameter((Object)object, (String)"source");
        _UtilKt.checkOffsetAndCount((long)object.size(), (long)0L, (long)l);
        if (this.closed ^ true) {
            while (l > 0L) {
                l -= (long)this.update((Buffer)object, l);
            }
            return;
        }
        object = new IllegalStateException("closed".toString());
        throw object;
    }
}
