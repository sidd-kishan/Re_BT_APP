/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okio.Buffer
 *  okio.BufferedSource
 *  okio.Segment
 *  okio.SegmentPool
 *  okio.Source
 *  okio.Timeout
 */
package okio;

import java.io.IOException;
import javax.crypto.Cipher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.BufferedSource;
import okio.Segment;
import okio.SegmentPool;
import okio.Source;
import okio.Timeout;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0011H\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0011H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2={"Lokio/CipherSource;", "Lokio/Source;", "source", "Lokio/BufferedSource;", "cipher", "Ljavax/crypto/Cipher;", "(Lokio/BufferedSource;Ljavax/crypto/Cipher;)V", "blockSize", "", "buffer", "Lokio/Buffer;", "getCipher", "()Ljavax/crypto/Cipher;", "closed", "", "final", "close", "", "doFinal", "read", "", "sink", "byteCount", "refill", "timeout", "Lokio/Timeout;", "update", "okio"}, k=1, mv={1, 5, 1}, xi=48)
public final class CipherSource
implements Source {
    private final int blockSize;
    private final Buffer buffer;
    private final Cipher cipher;
    private boolean closed;
    private boolean final;
    private final BufferedSource source;

    public CipherSource(BufferedSource bufferedSource, Cipher cipher) {
        Intrinsics.checkNotNullParameter((Object)bufferedSource, (String)"source");
        Intrinsics.checkNotNullParameter((Object)cipher, (String)"cipher");
        this.source = bufferedSource;
        this.cipher = cipher;
        this.blockSize = cipher.getBlockSize();
        this.buffer = new Buffer();
        boolean bl = this.blockSize > 0;
        if (!bl) throw (Throwable)new IllegalArgumentException(Intrinsics.stringPlus((String)"Block cipher required ", (Object)this.getCipher()).toString());
    }

    private final void doFinal() {
        int n = this.cipher.getOutputSize(0);
        if (n == 0) {
            return;
        }
        Segment segment = this.buffer.writableSegment$okio(n);
        n = this.cipher.doFinal(segment.data, segment.pos);
        segment.limit += n;
        Buffer buffer = this.buffer;
        buffer.setSize$okio(buffer.size() + (long)n);
        if (segment.pos != segment.limit) return;
        this.buffer.head = segment.pop();
        SegmentPool.recycle((Segment)segment);
    }

    private final void refill() {
        while (this.buffer.size() == 0L) {
            if (this.source.exhausted()) {
                this.final = true;
                this.doFinal();
                return;
            }
            this.update();
        }
    }

    private final void update() {
        Segment segment = this.source.getBuffer().head;
        Intrinsics.checkNotNull((Object)segment);
        int n = segment.limit - segment.pos;
        int n2 = this.cipher.getOutputSize(n);
        while (true) {
            if (n2 <= 8192) {
                Segment segment2 = this.buffer.writableSegment$okio(n2);
                n2 = this.cipher.update(segment.data, segment.pos, n, segment2.data, segment2.pos);
                this.source.skip((long)n);
                segment2.limit += n2;
                segment = this.buffer;
                segment.setSize$okio(segment.size() + (long)n2);
                if (segment2.pos != segment2.limit) return;
                this.buffer.head = segment2.pop();
                SegmentPool.recycle((Segment)segment2);
                return;
            }
            boolean bl = n > this.blockSize;
            if (!bl) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unexpected output size ");
                stringBuilder.append(n2);
                stringBuilder.append(" for input size ");
                stringBuilder.append(n);
                throw (Throwable)new IllegalStateException(stringBuilder.toString().toString());
            }
            n2 = this.cipher.getOutputSize(n -= this.blockSize);
        }
    }

    public void close() throws IOException {
        this.closed = true;
        this.source.close();
    }

    public final Cipher getCipher() {
        return this.cipher;
    }

    public long read(Buffer buffer, long l) throws IOException {
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"sink");
        boolean bl = l >= 0L;
        if (!bl) throw (Throwable)new IllegalArgumentException(Intrinsics.stringPlus((String)"byteCount < 0: ", (Object)l).toString());
        if (!(true ^ this.closed)) throw (Throwable)new IllegalStateException("closed".toString());
        if (l == 0L) {
            return 0L;
        }
        if (this.final) {
            return this.buffer.read(buffer, l);
        }
        this.refill();
        return this.buffer.read(buffer, l);
    }

    public Timeout timeout() {
        return this.source.timeout();
    }
}
