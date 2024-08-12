/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okio.Buffer
 *  okio.BufferedSource
 *  okio.InflaterSource
 *  okio.RealBufferedSource
 *  okio.Source
 *  okio.Timeout
 */
package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.BufferedSource;
import okio.InflaterSource;
import okio.RealBufferedSource;
import okio.Source;
import okio.Timeout;

@Metadata(d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u00a2\u0006\u0002\u0010\u0003J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0014\u001a\u00020\u000eH\u0016J\b\u0010\u0015\u001a\u00020\u000eH\u0002J\b\u0010\u0016\u001a\u00020\u000eH\u0002J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J \u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0018H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2={"Lokio/GzipSource;", "Lokio/Source;", "source", "(Lokio/Source;)V", "crc", "Ljava/util/zip/CRC32;", "inflater", "Ljava/util/zip/Inflater;", "inflaterSource", "Lokio/InflaterSource;", "section", "", "Lokio/RealBufferedSource;", "checkEqual", "", "name", "", "expected", "", "actual", "close", "consumeHeader", "consumeTrailer", "read", "", "sink", "Lokio/Buffer;", "byteCount", "timeout", "Lokio/Timeout;", "updateCrc", "buffer", "offset", "okio"}, k=1, mv={1, 5, 1}, xi=48)
public final class GzipSource
implements Source {
    private final CRC32 crc;
    private final Inflater inflater;
    private final InflaterSource inflaterSource;
    private byte section;
    private final RealBufferedSource source;

    public GzipSource(Source object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"source");
        this.source = new RealBufferedSource(object);
        object = new Inflater(true);
        this.inflater = object;
        this.inflaterSource = new InflaterSource((BufferedSource)this.source, (Inflater)object);
        this.crc = new CRC32();
    }

    private final void checkEqual(String string, int n, int n2) {
        if (n2 == n) {
            return;
        }
        string = String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(new Object[]{string, n2, n}, 3));
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"java.lang.String.format(this, *args)");
        throw new IOException(string);
    }

    private final void consumeHeader() throws IOException {
        long l;
        this.source.require(10L);
        byte by = this.source.bufferField.getByte(3L);
        boolean bl = true;
        boolean bl2 = (by >> 1 & 1) == 1;
        if (bl2) {
            this.updateCrc(this.source.bufferField, 0L, 10L);
        }
        this.checkEqual("ID1ID2", 8075, this.source.readShort());
        this.source.skip(8L);
        boolean bl3 = (by >> 2 & 1) == 1;
        if (bl3) {
            this.source.require(2L);
            if (bl2) {
                this.updateCrc(this.source.bufferField, 0L, 2L);
            }
            l = this.source.bufferField.readShortLe();
            this.source.require(l);
            if (bl2) {
                this.updateCrc(this.source.bufferField, 0L, l);
            }
            this.source.skip(l);
        }
        if (bl3 = (by >> 3 & 1) == 1) {
            l = this.source.indexOf((byte)0);
            if (l == -1L) throw new EOFException();
            if (bl2) {
                this.updateCrc(this.source.bufferField, 0L, l + 1L);
            }
            this.source.skip(l + 1L);
        }
        if (bl3 = (by >> 4 & 1) == 1 ? bl : false) {
            l = this.source.indexOf((byte)0);
            if (l == -1L) throw new EOFException();
            if (bl2) {
                this.updateCrc(this.source.bufferField, 0L, l + 1L);
            }
            this.source.skip(l + 1L);
        }
        if (!bl2) return;
        this.checkEqual("FHCRC", this.source.readShortLe(), (short)this.crc.getValue());
        this.crc.reset();
    }

    private final void consumeTrailer() throws IOException {
        this.checkEqual("CRC", this.source.readIntLe(), (int)this.crc.getValue());
        this.checkEqual("ISIZE", this.source.readIntLe(), (int)this.inflater.getBytesWritten());
    }

    private final void updateCrc(Buffer buffer, long l, long l2) {
        buffer = buffer.head;
        Intrinsics.checkNotNull((Object)buffer);
        while (true) {
            if (l < (long)(buffer.limit - buffer.pos)) {
                while (l2 > 0L) {
                    int n = (int)((long)buffer.pos + l);
                    int n2 = (int)Math.min((long)(buffer.limit - n), l2);
                    this.crc.update(buffer.data, n, n2);
                    l2 -= (long)n2;
                    buffer = buffer.next;
                    Intrinsics.checkNotNull((Object)buffer);
                    l = 0L;
                }
                return;
            }
            l -= (long)(buffer.limit - buffer.pos);
            buffer = buffer.next;
            Intrinsics.checkNotNull((Object)buffer);
        }
    }

    public void close() throws IOException {
        this.inflaterSource.close();
    }

    public long read(Buffer buffer, long l) throws IOException {
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"sink");
        boolean bl = l >= 0L;
        if (!bl) throw (Throwable)new IllegalArgumentException(Intrinsics.stringPlus((String)"byteCount < 0: ", (Object)l).toString());
        if (l == 0L) {
            return 0L;
        }
        if (this.section == 0) {
            this.consumeHeader();
            this.section = 1;
        }
        if (this.section == 1) {
            long l2 = buffer.size();
            if ((l = this.inflaterSource.read(buffer, l)) != -1L) {
                this.updateCrc(buffer, l2, l);
                return l;
            }
            this.section = (byte)2;
        }
        if (this.section != 2) return -1L;
        this.consumeTrailer();
        this.section = (byte)3;
        if (!this.source.exhausted()) throw new IOException("gzip finished without exhausting source");
        return -1L;
    }

    public Timeout timeout() {
        return this.source.timeout();
    }
}
