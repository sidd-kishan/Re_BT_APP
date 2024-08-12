/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.internal.Util
 *  okhttp3.internal.http2.Http2
 *  okhttp3.internal.http2.Http2Reader
 *  okio.Buffer
 *  okio.BufferedSource
 *  okio.Source
 *  okio.Timeout
 */
package okhttp3.internal.http2;

import java.io.IOException;
import java.util.logging.Level;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Http2;
import okhttp3.internal.http2.Http2Reader;
import okio.Buffer;
import okio.BufferedSource;
import okio.Source;
import okio.Timeout;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u0018H\u0002J\b\u0010\u001f\u001a\u00020 H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\u001a\u0010\u0011\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\b\"\u0004\b\u0016\u0010\n\u00a8\u0006!"}, d2={"Lokhttp3/internal/http2/Http2Reader$ContinuationSource;", "Lokio/Source;", "source", "Lokio/BufferedSource;", "(Lokio/BufferedSource;)V", "flags", "", "getFlags", "()I", "setFlags", "(I)V", "left", "getLeft", "setLeft", "length", "getLength", "setLength", "padding", "getPadding", "setPadding", "streamId", "getStreamId", "setStreamId", "close", "", "read", "", "sink", "Lokio/Buffer;", "byteCount", "readContinuationHeader", "timeout", "Lokio/Timeout;", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class Http2Reader.ContinuationSource
implements Source {
    private int flags;
    private int left;
    private int length;
    private int padding;
    private final BufferedSource source;
    private int streamId;

    public Http2Reader.ContinuationSource(BufferedSource bufferedSource) {
        Intrinsics.checkNotNullParameter((Object)bufferedSource, (String)"source");
        this.source = bufferedSource;
    }

    private final void readContinuationHeader() throws IOException {
        int n;
        int n2 = this.streamId;
        this.left = n = Util.readMedium((BufferedSource)this.source);
        this.length = n;
        int n3 = Util.and((byte)this.source.readByte(), (int)255);
        this.flags = Util.and((byte)this.source.readByte(), (int)255);
        if (Http2Reader.Companion.getLogger().isLoggable(Level.FINE)) {
            Http2Reader.Companion.getLogger().fine(Http2.INSTANCE.frameLog(true, this.streamId, this.length, n3, this.flags));
        }
        this.streamId = n = this.source.readInt() & Integer.MAX_VALUE;
        if (n3 == 9) {
            if (n != n2) throw new IOException("TYPE_CONTINUATION streamId changed");
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(n3);
        stringBuilder.append(" != TYPE_CONTINUATION");
        throw new IOException(stringBuilder.toString());
    }

    public void close() throws IOException {
    }

    public final int getFlags() {
        return this.flags;
    }

    public final int getLeft() {
        return this.left;
    }

    public final int getLength() {
        return this.length;
    }

    public final int getPadding() {
        return this.padding;
    }

    public final int getStreamId() {
        return this.streamId;
    }

    public long read(Buffer buffer, long l) throws IOException {
        int n;
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"sink");
        while ((n = this.left) == 0) {
            this.source.skip((long)this.padding);
            this.padding = 0;
            if ((this.flags & 4) != 0) {
                return -1L;
            }
            this.readContinuationHeader();
        }
        if ((l = this.source.read(buffer, Math.min(l, (long)n))) == -1L) {
            return -1L;
        }
        this.left -= (int)l;
        return l;
    }

    public final void setFlags(int n) {
        this.flags = n;
    }

    public final void setLeft(int n) {
        this.left = n;
    }

    public final void setLength(int n) {
        this.length = n;
    }

    public final void setPadding(int n) {
        this.padding = n;
    }

    public final void setStreamId(int n) {
        this.streamId = n;
    }

    public Timeout timeout() {
        return this.source.timeout();
    }
}
