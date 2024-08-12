/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.internal.Util
 *  okhttp3.internal.http2.ErrorCode
 *  okhttp3.internal.http2.Header
 *  okhttp3.internal.http2.Hpack$Writer
 *  okhttp3.internal.http2.Http2
 *  okhttp3.internal.http2.Http2Writer$Companion
 *  okhttp3.internal.http2.Settings
 *  okio.Buffer
 *  okio.BufferedSink
 */
package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Header;
import okhttp3.internal.http2.Hpack;
import okhttp3.internal.http2.Http2;
import okhttp3.internal.http2.Http2Writer;
import okhttp3.internal.http2.Settings;
import okio.Buffer;
import okio.BufferedSink;

@Metadata(d1={"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u0000 :2\u00020\u0001:\u0001:B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\b\u0010\u0014\u001a\u00020\u0011H\u0016J\u0006\u0010\u0015\u001a\u00020\u0011J(\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001a\u001a\u00020\u000fJ(\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u000f2\b\u0010\u001d\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001a\u001a\u00020\u000fJ\u0006\u0010\u001e\u001a\u00020\u0011J&\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u000fJ\u001e\u0010\"\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'J$\u0010(\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u000f2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*J\u0006\u0010,\u001a\u00020\u000fJ\u001e\u0010-\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u000f2\u0006\u00100\u001a\u00020\u000fJ$\u00101\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u00102\u001a\u00020\u000f2\f\u00103\u001a\b\u0012\u0004\u0012\u00020+0*J\u0016\u00104\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020%J\u000e\u00105\u001a\u00020\u00112\u0006\u00105\u001a\u00020\u0013J\u0016\u00106\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u00107\u001a\u000208J\u0018\u00109\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u000208H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006;"}, d2={"Lokhttp3/internal/http2/Http2Writer;", "Ljava/io/Closeable;", "sink", "Lokio/BufferedSink;", "client", "", "(Lokio/BufferedSink;Z)V", "closed", "hpackBuffer", "Lokio/Buffer;", "hpackWriter", "Lokhttp3/internal/http2/Hpack$Writer;", "getHpackWriter", "()Lokhttp3/internal/http2/Hpack$Writer;", "maxFrameSize", "", "applyAndAckSettings", "", "peerSettings", "Lokhttp3/internal/http2/Settings;", "close", "connectionPreface", "data", "outFinished", "streamId", "source", "byteCount", "dataFrame", "flags", "buffer", "flush", "frameHeader", "length", "type", "goAway", "lastGoodStreamId", "errorCode", "Lokhttp3/internal/http2/ErrorCode;", "debugData", "", "headers", "headerBlock", "", "Lokhttp3/internal/http2/Header;", "maxDataLength", "ping", "ack", "payload1", "payload2", "pushPromise", "promisedStreamId", "requestHeaders", "rstStream", "settings", "windowUpdate", "windowSizeIncrement", "", "writeContinuationFrames", "Companion", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class Http2Writer
implements Closeable {
    public static final Companion Companion = new Companion(null);
    private static final Logger logger = Logger.getLogger(Http2.class.getName());
    private final boolean client;
    private boolean closed;
    private final Buffer hpackBuffer;
    private final Hpack.Writer hpackWriter;
    private int maxFrameSize;
    private final BufferedSink sink;

    public Http2Writer(BufferedSink bufferedSink, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)bufferedSink, (String)"sink");
        this.sink = bufferedSink;
        this.client = bl;
        bufferedSink = new Buffer();
        this.hpackBuffer = bufferedSink;
        this.maxFrameSize = 16384;
        this.hpackWriter = new Hpack.Writer(0, false, (Buffer)bufferedSink, 3, null);
    }

    private final void writeContinuationFrames(int n, long l) throws IOException {
        while (l > 0L) {
            long l2 = Math.min((long)this.maxFrameSize, l);
            int n2 = (int)l2;
            int n3 = (l -= l2) == 0L ? 4 : 0;
            this.frameHeader(n, n2, 9, n3);
            this.sink.write(this.hpackBuffer, l2);
        }
    }

    public final void applyAndAckSettings(Settings object) throws IOException {
        synchronized (this) {
            Intrinsics.checkNotNullParameter((Object)object, (String)"peerSettings");
            if (this.closed) {
                object = new IOException("closed");
                throw object;
            }
            this.maxFrameSize = object.getMaxFrameSize(this.maxFrameSize);
            if (object.getHeaderTableSize() != -1) {
                this.hpackWriter.resizeHeaderTable(object.getHeaderTableSize());
            }
            this.frameHeader(0, 0, 4, 1);
            this.sink.flush();
            return;
        }
    }

    @Override
    public void close() throws IOException {
        synchronized (this) {
            this.closed = true;
            this.sink.close();
            return;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void connectionPreface() throws IOException {
        synchronized (this) {
            if (this.closed) {
                IOException iOException = new IOException("closed");
                throw iOException;
            }
            boolean bl = this.client;
            if (!bl) {
                return;
            }
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(Util.format((String)Intrinsics.stringPlus((String)">> CONNECTION ", (Object)Http2.CONNECTION_PREFACE.hex()), (Object[])new Object[0]));
            }
            this.sink.write(Http2.CONNECTION_PREFACE);
            this.sink.flush();
            return;
        }
    }

    public final void data(boolean bl, int n, Buffer object, int n2) throws IOException {
        synchronized (this) {
            if (this.closed) {
                object = new IOException("closed");
                throw object;
            }
            int n3 = 0;
            if (bl) {
                n3 = 1;
            }
            this.dataFrame(n, n3, (Buffer)object, n2);
            return;
        }
    }

    public final void dataFrame(int n, int n2, Buffer buffer, int n3) throws IOException {
        this.frameHeader(n, n3, 0, n2);
        if (n3 <= 0) return;
        BufferedSink bufferedSink = this.sink;
        Intrinsics.checkNotNull((Object)buffer);
        bufferedSink.write(buffer, (long)n3);
    }

    public final void flush() throws IOException {
        synchronized (this) {
            if (!this.closed) {
                this.sink.flush();
                return;
            }
            IOException iOException = new IOException("closed");
            throw iOException;
        }
    }

    public final void frameHeader(int n, int n2, int n3, int n4) throws IOException {
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(Http2.INSTANCE.frameLog(false, n, n2, n3, n4));
        }
        int n5 = this.maxFrameSize;
        int n6 = 1;
        if ((n5 = n2 <= n5 ? 1 : 0) == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("FRAME_SIZE_ERROR length > ");
            stringBuilder.append(this.maxFrameSize);
            stringBuilder.append(": ");
            stringBuilder.append(n2);
            throw (Throwable)new IllegalArgumentException(stringBuilder.toString().toString());
        }
        n5 = (Integer.MIN_VALUE & n) == 0 ? n6 : 0;
        if (n5 == 0) throw (Throwable)new IllegalArgumentException(Intrinsics.stringPlus((String)"reserved bit set: ", (Object)n).toString());
        Util.writeMedium((BufferedSink)this.sink, (int)n2);
        this.sink.writeByte(n3 & 0xFF);
        this.sink.writeByte(n4 & 0xFF);
        this.sink.writeInt(n & Integer.MAX_VALUE);
    }

    public final Hpack.Writer getHpackWriter() {
        return this.hpackWriter;
    }

    /*
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    public final void goAway(int n, ErrorCode object, byte[] byArray) throws IOException {
        synchronized (this) {
            void var3_5;
            Intrinsics.checkNotNullParameter((Object)object, (String)"errorCode");
            Intrinsics.checkNotNullParameter((Object)var3_5, (String)"debugData");
            if (this.closed) {
                IOException iOException = new IOException("closed");
                throw iOException;
            }
            int n2 = object.getHttpCode();
            int n3 = 0;
            if ((n2 = n2 != -1 ? 1 : 0) == 0) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("errorCode.httpCode == -1".toString());
                throw (Throwable)illegalArgumentException;
            }
            this.frameHeader(0, ((void)var3_5).length + 8, 7, 0);
            this.sink.writeInt(n);
            this.sink.writeInt(object.getHttpCode());
            n = n3;
            if (((void)var3_5).length == 0) {
                n = 1;
            }
            if ((n ^ 1) != 0) {
                this.sink.write((byte[])var3_5);
            }
            this.sink.flush();
            return;
        }
    }

    public final void headers(boolean bl, int n, List<Header> object) throws IOException {
        synchronized (this) {
            Intrinsics.checkNotNullParameter(object, (String)"headerBlock");
            if (this.closed) {
                object = new IOException("closed");
                throw object;
            }
            this.hpackWriter.writeHeaders((List)object);
            long l = this.hpackBuffer.size();
            long l2 = Math.min((long)this.maxFrameSize, l);
            int n2 = l == l2 ? 4 : 0;
            int n3 = n2;
            if (bl) {
                n3 = n2 | 1;
            }
            this.frameHeader(n, (int)l2, 1, n3);
            this.sink.write(this.hpackBuffer, l2);
            if (l <= l2) return;
            this.writeContinuationFrames(n, l - l2);
            return;
        }
    }

    public final int maxDataLength() {
        return this.maxFrameSize;
    }

    public final void ping(boolean bl, int n, int n2) throws IOException {
        synchronized (this) {
            if (this.closed) {
                IOException iOException = new IOException("closed");
                throw iOException;
            }
            int n3 = bl ? 1 : 0;
            this.frameHeader(0, 8, 6, n3);
            this.sink.writeInt(n);
            this.sink.writeInt(n2);
            this.sink.flush();
            return;
        }
    }

    public final void pushPromise(int n, int n2, List<Header> object) throws IOException {
        synchronized (this) {
            Intrinsics.checkNotNullParameter(object, (String)"requestHeaders");
            if (this.closed) {
                object = new IOException("closed");
                throw object;
            }
            this.hpackWriter.writeHeaders((List)object);
            long l = this.hpackBuffer.size();
            int n3 = (int)Math.min((long)this.maxFrameSize - 4L, l);
            long l2 = n3;
            int n4 = l == l2 ? 4 : 0;
            this.frameHeader(n, n3 + 4, 5, n4);
            this.sink.writeInt(n2 & Integer.MAX_VALUE);
            this.sink.write(this.hpackBuffer, l2);
            if (l <= l2) return;
            this.writeContinuationFrames(n, l - l2);
            return;
        }
    }

    public final void rstStream(int n, ErrorCode object) throws IOException {
        synchronized (this) {
            Intrinsics.checkNotNullParameter((Object)object, (String)"errorCode");
            if (this.closed) {
                object = new IOException("closed");
                throw object;
            }
            boolean bl = object.getHttpCode() != -1;
            if (bl) {
                this.frameHeader(n, 4, 3, 0);
                this.sink.writeInt(object.getHttpCode());
                this.sink.flush();
                return;
            }
            object = new IllegalArgumentException("Failed requirement.".toString());
            throw (Throwable)object;
        }
    }

    public final void settings(Settings object) throws IOException {
        synchronized (this) {
            try {
                Intrinsics.checkNotNullParameter((Object)object, (String)"settings");
                if (this.closed) {
                    object = new IOException("closed");
                    throw object;
                }
                int n = object.size();
                int n2 = 0;
                this.frameHeader(0, n * 6, 4, 0);
                while (true) {
                    int n3 = n2 + 1;
                    if (object.isSet(n2)) {
                        n = n2 != 4 ? (n2 != 7 ? n2 : 4) : 3;
                        this.sink.writeShort(n);
                        this.sink.writeInt(object.get(n2));
                    }
                    if (n3 >= 10) {
                        this.sink.flush();
                        return;
                    }
                    n2 = n3;
                }
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    public final void windowUpdate(int n, long l) throws IOException {
        synchronized (this) {
            if (this.closed) {
                IOException iOException = new IOException("closed");
                throw iOException;
            }
            boolean bl = l != 0L && l <= Integer.MAX_VALUE;
            if (bl) {
                this.frameHeader(n, 4, 8, 0);
                this.sink.writeInt((int)l);
                this.sink.flush();
                return;
            }
            String string = Intrinsics.stringPlus((String)"windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: ", (Object)l);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string.toString());
            throw (Throwable)illegalArgumentException;
        }
    }
}
