/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.Headers
 *  okhttp3.internal.Util
 *  okhttp3.internal.http2.ErrorCode
 *  okhttp3.internal.http2.Http2Stream
 *  okhttp3.internal.http2.StreamResetException
 *  okio.Buffer
 *  okio.BufferedSource
 *  okio.Source
 *  okio.Timeout
 */
package okhttp3.internal.http2;

import java.io.EOFException;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.internal.Util;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.http2.StreamResetException;
import okio.Buffer;
import okio.BufferedSource;
import okio.Source;
import okio.Timeout;

@Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u0003H\u0016J\u001d\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u0003H\u0000\u00a2\u0006\u0002\b\"J\b\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0003H\u0002R\u001a\u0010\u0007\u001a\u00020\u0005X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u0006&"}, d2={"Lokhttp3/internal/http2/Http2Stream$FramingSource;", "Lokio/Source;", "maxByteCount", "", "finished", "", "(Lokhttp3/internal/http2/Http2Stream;JZ)V", "closed", "getClosed$okhttp", "()Z", "setClosed$okhttp", "(Z)V", "getFinished$okhttp", "setFinished$okhttp", "readBuffer", "Lokio/Buffer;", "getReadBuffer", "()Lokio/Buffer;", "receiveBuffer", "getReceiveBuffer", "trailers", "Lokhttp3/Headers;", "getTrailers", "()Lokhttp3/Headers;", "setTrailers", "(Lokhttp3/Headers;)V", "close", "", "read", "sink", "byteCount", "receive", "source", "Lokio/BufferedSource;", "receive$okhttp", "timeout", "Lokio/Timeout;", "updateConnectionFlowControl", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class Http2Stream.FramingSource
implements Source {
    private boolean closed;
    private boolean finished;
    private final long maxByteCount;
    private final Buffer readBuffer;
    private final Buffer receiveBuffer;
    final Http2Stream this$0;
    private Headers trailers;

    public Http2Stream.FramingSource(Http2Stream http2Stream, long l, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)http2Stream, (String)"this$0");
        this.this$0 = http2Stream;
        this.maxByteCount = l;
        this.finished = bl;
        this.receiveBuffer = new Buffer();
        this.readBuffer = new Buffer();
    }

    private final void updateConnectionFlowControl(long l) {
        Http2Stream http2Stream = this.this$0;
        if (Util.assertionsEnabled && Thread.holdsLock(http2Stream)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Thread ");
            stringBuilder.append((Object)Thread.currentThread().getName());
            stringBuilder.append(" MUST NOT hold lock on ");
            stringBuilder.append(http2Stream);
            throw new AssertionError((Object)stringBuilder.toString());
        }
        this.this$0.getConnection().updateConnectionFlowControl$okhttp(l);
    }

    public void close() throws IOException {
        Http2Stream http2Stream = this.this$0;
        synchronized (http2Stream) {
            this.setClosed$okhttp(true);
            long l = this.getReadBuffer().size();
            this.getReadBuffer().clear();
            ((Object)http2Stream).notifyAll();
            Unit unit = Unit.INSTANCE;
            // MONITOREXIT @DISABLED, blocks:[0, 1] lbl9 : MonitorExitStatement: MONITOREXIT : var3_1
            if (l > 0L) {
                this.updateConnectionFlowControl(l);
            }
        }
        this.this$0.cancelStreamIfNecessary$okhttp();
    }

    public final boolean getClosed$okhttp() {
        return this.closed;
    }

    public final boolean getFinished$okhttp() {
        return this.finished;
    }

    public final Buffer getReadBuffer() {
        return this.readBuffer;
    }

    public final Buffer getReceiveBuffer() {
        return this.receiveBuffer;
    }

    public final Headers getTrailers() {
        return this.trailers;
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    public long read(Buffer var1_1, long var2_4) throws IOException {
        Intrinsics.checkNotNullParameter((Object)var1_1 /* !! */ , (String)"sink");
        var4_4 = var2_3 >= 0L;
        if (!var4_4) {
            var1_1 /* !! */  = new IllegalArgumentException(Intrinsics.stringPlus((String)"byteCount < 0: ", (Object)((long)var2_3)).toString());
            throw var1_1 /* !! */ ;
        }
        do {
            block19: {
                var12_9 = null;
                var13_10 = this.this$0;
                // MONITORENTER : var13_10
                var13_10.getReadTimeout$okhttp().enter();
                var11_8 = var12_9;
                if (var13_10.getErrorCode$okhttp() != null) {
                    var11_8 = var12_9;
                    if (!this.getFinished$okhttp()) {
                        var11_8 = var12_9 = var13_10.getErrorException$okhttp();
                        if (var12_9 == null) {
                            var12_9 = var13_10.getErrorCode$okhttp();
                            Intrinsics.checkNotNull((Object)var12_9);
                            var11_8 = new StreamResetException((ErrorCode)var12_9);
                        }
                    }
                }
                if (this.getClosed$okhttp()) ** break block18
                if (this.getReadBuffer().size() <= 0L) break block19;
                var7_6 = this.getReadBuffer().read(var1_1 /* !! */ , Math.min((long)var2_3, this.getReadBuffer().size()));
                var13_10.setReadBytesTotal$okhttp(var13_10.getReadBytesTotal() + var7_6);
                var9_7 = var13_10.getReadBytesTotal() - var13_10.getReadBytesAcknowledged();
                var5_5 = var7_6;
                if (var11_8 == null) {
                    var5_5 = var7_6;
                    if (var9_7 >= (long)(var13_10.getConnection().getOkHttpSettings().getInitialWindowSize() / 2)) {
                        var13_10.getConnection().writeWindowUpdateLater$okhttp(var13_10.getId(), var9_7);
                        var13_10.setReadBytesAcknowledged$okhttp(var13_10.getReadBytesTotal());
                        var5_5 = var7_6;
                    }
                }
                ** GOTO lbl42
            }
            if (!this.getFinished$okhttp() && var11_8 == null) {
                var13_10.waitForIo$okhttp();
                var5_5 = -1L;
                var4_4 = true;
            } else {
                var5_5 = -1L;
lbl42:
                // 2 sources

                var4_4 = false;
            }
            var12_9 = Unit.INSTANCE;
        } while (var4_4);
        if (var5_5 != -1L) {
            this.updateConnectionFlowControl(var5_5);
            return var5_5;
        }
        if (var11_8 != null) throw (Throwable)var11_8;
        return -1L;
        {
            var1_1 /* !! */  = new IOException("stream closed");
            throw var1_1 /* !! */ ;
        }
        finally {
            var13_10.getReadTimeout$okhttp().exitAndThrowIfTimedOut();
        }
    }

    public final void receive$okhttp(BufferedSource object, long l) throws IOException {
        Intrinsics.checkNotNullParameter((Object)object, (String)"source");
        Http2Stream http2Stream = this.this$0;
        long l2 = l;
        if (Util.assertionsEnabled) {
            if (Thread.holdsLock(http2Stream)) {
                object = new StringBuilder();
                ((StringBuilder)object).append("Thread ");
                ((StringBuilder)object).append((Object)Thread.currentThread().getName());
                ((StringBuilder)object).append(" MUST NOT hold lock on ");
                ((StringBuilder)object).append(http2Stream);
                throw new AssertionError((Object)((StringBuilder)object).toString());
            }
            l2 = l;
        }
        while (l2 > 0L) {
            Unit unit;
            boolean bl;
            boolean bl2;
            long l3;
            boolean bl3;
            block13: {
                http2Stream = this.this$0;
                synchronized (http2Stream) {
                    bl3 = this.getFinished$okhttp();
                    l = this.getReadBuffer().size();
                    l3 = this.maxByteCount;
                    bl2 = true;
                    bl = l + l2 > l3;
                    unit = Unit.INSTANCE;
                    // MONITOREXIT @DISABLED, blocks:[0, 2, 6] lbl27 : MonitorExitStatement: MONITOREXIT : var11_5
                    if (!bl) break block13;
                }
                object.skip(l2);
                this.this$0.closeLater(ErrorCode.FLOW_CONTROL_ERROR);
                return;
            }
            if (bl3) {
                object.skip(l2);
                return;
            }
            l = object.read(this.receiveBuffer, l2);
            if (l == -1L) throw new EOFException();
            l3 = l2 - l;
            http2Stream = this.this$0;
            synchronized (http2Stream) {
                if (this.getClosed$okhttp()) {
                    l = this.getReceiveBuffer().size();
                    this.getReceiveBuffer().clear();
                } else {
                    bl = this.getReadBuffer().size() == 0L ? bl2 : false;
                    this.getReadBuffer().writeAll((Source)this.getReceiveBuffer());
                    if (bl) {
                        ((Object)http2Stream).notifyAll();
                    }
                    l = 0L;
                }
                unit = Unit.INSTANCE;
                // MONITOREXIT @DISABLED, blocks:[1, 3, 6] lbl56 : MonitorExitStatement: MONITOREXIT : var11_5
                l2 = l3;
                if (l <= 0L) continue;
                this.updateConnectionFlowControl(l);
                l2 = l3;
            }
        }
    }

    public final void setClosed$okhttp(boolean bl) {
        this.closed = bl;
    }

    public final void setFinished$okhttp(boolean bl) {
        this.finished = bl;
    }

    public final void setTrailers(Headers headers) {
        this.trailers = headers;
    }

    public Timeout timeout() {
        return (Timeout)this.this$0.getReadTimeout$okhttp();
    }
}
