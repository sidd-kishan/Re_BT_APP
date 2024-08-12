/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.jvm.internal.Intrinsics
 *  okio.Buffer
 *  okio.BufferedSink
 *  okio.DeflaterSink
 *  okio.RealBufferedSink
 *  okio.Sink
 *  okio.Timeout
 */
package okio;

import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.BufferedSink;
import okio.DeflaterSink;
import okio.RealBufferedSink;
import okio.Sink;
import okio.Timeout;

@Metadata(d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\r\u0010\b\u001a\u00020\tH\u0007\u00a2\u0006\u0002\b\u0010J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0018\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u000fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0013\u0010\b\u001a\u00020\t8G\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2={"Lokio/GzipSink;", "Lokio/Sink;", "sink", "(Lokio/Sink;)V", "closed", "", "crc", "Ljava/util/zip/CRC32;", "deflater", "Ljava/util/zip/Deflater;", "()Ljava/util/zip/Deflater;", "deflaterSink", "Lokio/DeflaterSink;", "Lokio/RealBufferedSink;", "close", "", "-deprecated_deflater", "flush", "timeout", "Lokio/Timeout;", "updateCrc", "buffer", "Lokio/Buffer;", "byteCount", "", "write", "source", "writeFooter", "okio"}, k=1, mv={1, 5, 1}, xi=48)
public final class GzipSink
implements Sink {
    private boolean closed;
    private final CRC32 crc;
    private final Deflater deflater;
    private final DeflaterSink deflaterSink;
    private final RealBufferedSink sink;

    public GzipSink(Sink object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"sink");
        this.sink = new RealBufferedSink(object);
        object = new Deflater(-1, true);
        this.deflater = object;
        this.deflaterSink = new DeflaterSink((BufferedSink)this.sink, (Deflater)object);
        this.crc = new CRC32();
        object = this.sink.bufferField;
        object.writeShort(8075);
        object.writeByte(8);
        object.writeByte(0);
        object.writeInt(0);
        object.writeByte(0);
        object.writeByte(0);
    }

    private final void updateCrc(Buffer buffer, long l) {
        buffer = buffer.head;
        Intrinsics.checkNotNull((Object)buffer);
        while (l > 0L) {
            int n = (int)Math.min(l, (long)(buffer.limit - buffer.pos));
            this.crc.update(buffer.data, buffer.pos, n);
            l -= (long)n;
            buffer = buffer.next;
            Intrinsics.checkNotNull((Object)buffer);
        }
    }

    private final void writeFooter() {
        this.sink.writeIntLe((int)this.crc.getValue());
        this.sink.writeIntLe((int)this.deflater.getBytesRead());
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="deflater", imports={}))
    public final Deflater _deprecated_deflater() {
        return this.deflater;
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
                    this.deflaterSink.finishDeflate$okio();
                    this.writeFooter();
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

    public final Deflater deflater() {
        return this.deflater;
    }

    public void flush() throws IOException {
        this.deflaterSink.flush();
    }

    public Timeout timeout() {
        return this.sink.timeout();
    }

    public void write(Buffer buffer, long l) throws IOException {
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"source");
        boolean bl = l >= 0L;
        if (!bl) throw (Throwable)new IllegalArgumentException(Intrinsics.stringPlus((String)"byteCount < 0: ", (Object)l).toString());
        if (l == 0L) {
            return;
        }
        this.updateCrc(buffer, l);
        this.deflaterSink.write(buffer, l);
    }
}
