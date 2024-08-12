/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.Headers
 *  okhttp3.internal.Util
 *  okhttp3.internal.http2.Http2Stream
 *  okio.Buffer
 *  okio.Sink
 *  okio.Timeout
 */
package okhttp3.internal.http2;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Http2Stream;
import okio.Buffer;
import okio.Sink;
import okio.Timeout;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0080\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0003H\u0002J\b\u0010\u0018\u001a\u00020\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001f"}, d2={"Lokhttp3/internal/http2/Http2Stream$FramingSink;", "Lokio/Sink;", "finished", "", "(Lokhttp3/internal/http2/Http2Stream;Z)V", "closed", "getClosed", "()Z", "setClosed", "(Z)V", "getFinished", "setFinished", "sendBuffer", "Lokio/Buffer;", "trailers", "Lokhttp3/Headers;", "getTrailers", "()Lokhttp3/Headers;", "setTrailers", "(Lokhttp3/Headers;)V", "close", "", "emitFrame", "outFinishedOnLastFrame", "flush", "timeout", "Lokio/Timeout;", "write", "source", "byteCount", "", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class Http2Stream.FramingSink
implements Sink {
    private boolean closed;
    private boolean finished;
    private final Buffer sendBuffer;
    final Http2Stream this$0;
    private Headers trailers;

    public Http2Stream.FramingSink(Http2Stream http2Stream, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)http2Stream, (String)"this$0");
        this.this$0 = http2Stream;
        this.finished = bl;
        this.sendBuffer = new Buffer();
    }

    public /* synthetic */ Http2Stream.FramingSink(Http2Stream http2Stream, boolean bl, int n, DefaultConstructorMarker defaultConstructorMarker) {
        this.this$0 = http2Stream;
        if ((n & 1) != 0) {
            bl = false;
        }
        this(http2Stream, bl);
    }

    /*
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    private final void emitFrame(boolean bl) throws IOException {
        long l;
        Http2Stream http2Stream = this.this$0;
        synchronized (http2Stream) {
            http2Stream.getWriteTimeout$okhttp().enter();
            while (http2Stream.getWriteBytesTotal() >= http2Stream.getWriteBytesMaximum() && !this.getFinished() && !this.getClosed() && http2Stream.getErrorCode$okhttp() == null) {
                http2Stream.waitForIo$okhttp();
            }
            http2Stream.getWriteTimeout$okhttp().exitAndThrowIfTimedOut();
            http2Stream.checkOutNotClosed$okhttp();
            l = Math.min(http2Stream.getWriteBytesMaximum() - http2Stream.getWriteBytesTotal(), this.sendBuffer.size());
            http2Stream.setWriteBytesTotal$okhttp(http2Stream.getWriteBytesTotal() + l);
            bl = bl && l == this.sendBuffer.size();
            Unit unit = Unit.INSTANCE;
        }
        this.this$0.getWriteTimeout$okhttp().enter();
        try {
            this.this$0.getConnection().writeData(this.this$0.getId(), bl, this.sendBuffer, l);
            return;
        }
        finally {
            this.this$0.getWriteTimeout$okhttp().exitAndThrowIfTimedOut();
        }
        {
            catch (Throwable throwable) {
                http2Stream.getWriteTimeout$okhttp().exitAndThrowIfTimedOut();
                throw throwable;
            }
        }
    }

    /*
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    public void close() throws IOException {
        Http2Stream http2Stream;
        Http2Stream http2Stream2;
        block15: {
            boolean bl;
            block14: {
                http2Stream2 = this.this$0;
                if (Util.assertionsEnabled && Thread.holdsLock(http2Stream2)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Thread ");
                    stringBuilder.append((Object)Thread.currentThread().getName());
                    stringBuilder.append(" MUST NOT hold lock on ");
                    stringBuilder.append(http2Stream2);
                    throw new AssertionError((Object)stringBuilder.toString());
                }
                http2Stream = this.this$0;
                // MONITORENTER : http2Stream
                bl = this.getClosed();
                if (!bl) break block14;
                // MONITOREXIT : http2Stream
                return;
            }
            bl = http2Stream.getErrorCode$okhttp() == null;
            http2Stream2 = Unit.INSTANCE;
            // MONITOREXIT : http2Stream
            if (this.this$0.getSink$okhttp().finished) break block15;
            int n = this.sendBuffer.size() > 0L ? 1 : 0;
            boolean bl2 = this.trailers != null;
            if (bl2) {
                while (this.sendBuffer.size() > 0L) {
                    this.emitFrame(false);
                }
                http2Stream2 = this.this$0.getConnection();
                n = this.this$0.getId();
                http2Stream = this.trailers;
                Intrinsics.checkNotNull((Object)http2Stream);
                http2Stream2.writeHeaders$okhttp(n, bl, Util.toHeaderList((Headers)http2Stream));
            } else if (n != 0) {
                while (this.sendBuffer.size() > 0L) {
                    this.emitFrame(true);
                }
            } else if (bl) {
                this.this$0.getConnection().writeData(this.this$0.getId(), true, null, 0L);
            }
        }
        http2Stream = this.this$0;
        // MONITORENTER : http2Stream
        this.setClosed(true);
        http2Stream2 = Unit.INSTANCE;
        // MONITOREXIT : http2Stream
        this.this$0.getConnection().flush();
        this.this$0.cancelStreamIfNecessary$okhttp();
        return;
    }

    public void flush() throws IOException {
        Http2Stream http2Stream = this.this$0;
        if (Util.assertionsEnabled && Thread.holdsLock(http2Stream)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Thread ");
            stringBuilder.append((Object)Thread.currentThread().getName());
            stringBuilder.append(" MUST NOT hold lock on ");
            stringBuilder.append(http2Stream);
            throw new AssertionError((Object)stringBuilder.toString());
        }
        Http2Stream http2Stream2 = this.this$0;
        synchronized (http2Stream2) {
            http2Stream2.checkOutNotClosed$okhttp();
            http2Stream = Unit.INSTANCE;
        }
        while (this.sendBuffer.size() > 0L) {
            this.emitFrame(false);
            this.this$0.getConnection().flush();
        }
    }

    public final boolean getClosed() {
        return this.closed;
    }

    public final boolean getFinished() {
        return this.finished;
    }

    public final Headers getTrailers() {
        return this.trailers;
    }

    public final void setClosed(boolean bl) {
        this.closed = bl;
    }

    public final void setFinished(boolean bl) {
        this.finished = bl;
    }

    public final void setTrailers(Headers headers) {
        this.trailers = headers;
    }

    public Timeout timeout() {
        return (Timeout)this.this$0.getWriteTimeout$okhttp();
    }

    public void write(Buffer object, long l) throws IOException {
        Intrinsics.checkNotNullParameter((Object)object, (String)"source");
        Http2Stream http2Stream = this.this$0;
        if (Util.assertionsEnabled && Thread.holdsLock(http2Stream)) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Thread ");
            ((StringBuilder)object).append((Object)Thread.currentThread().getName());
            ((StringBuilder)object).append(" MUST NOT hold lock on ");
            ((StringBuilder)object).append(http2Stream);
            throw new AssertionError((Object)((StringBuilder)object).toString());
        }
        this.sendBuffer.write((Buffer)object, l);
        while (this.sendBuffer.size() >= 16384L) {
            this.emitFrame(false);
        }
    }
}
