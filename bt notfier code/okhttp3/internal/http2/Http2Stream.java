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
 *  okhttp3.internal.http2.Header
 *  okhttp3.internal.http2.Http2Connection
 *  okhttp3.internal.http2.Http2Stream$Companion
 *  okhttp3.internal.http2.Http2Stream$FramingSink
 *  okhttp3.internal.http2.Http2Stream$FramingSource
 *  okhttp3.internal.http2.Http2Stream$StreamTimeout
 *  okhttp3.internal.http2.StreamResetException
 *  okio.BufferedSource
 *  okio.Sink
 *  okio.Source
 *  okio.Timeout
 */
package okhttp3.internal.http2;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.internal.Util;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Header;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.http2.StreamResetException;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.Timeout;

@Metadata(d1={"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 _2\u00020\u0001:\u0004_`abB1\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0002\u0010\u000bJ\u000e\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020#J\r\u0010C\u001a\u00020AH\u0000\u00a2\u0006\u0002\bDJ\r\u0010E\u001a\u00020AH\u0000\u00a2\u0006\u0002\bFJ\u0018\u0010G\u001a\u00020A2\u0006\u0010H\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u001a\u0010I\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\u000e\u0010J\u001a\u00020A2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010K\u001a\u00020A2\u0006\u0010L\u001a\u00020\nJ\u0006\u0010M\u001a\u00020NJ\u0006\u0010O\u001a\u00020PJ\u0006\u0010,\u001a\u00020QJ\u0016\u0010R\u001a\u00020A2\u0006\u00104\u001a\u00020S2\u0006\u0010T\u001a\u00020\u0003J\u0016\u0010U\u001a\u00020A2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010V\u001a\u00020A2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010W\u001a\u00020\nJ\u0006\u0010L\u001a\u00020\nJ\r\u0010X\u001a\u00020AH\u0000\u00a2\u0006\u0002\bYJ$\u0010Z\u001a\u00020A2\f\u0010[\u001a\b\u0012\u0004\u0012\u00020]0\\2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010^\u001a\u00020\u0007J\u0006\u0010>\u001a\u00020QR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000f8@X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\n0\u001cX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020\u00078F\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\u00078F\u00a2\u0006\u0006\u001a\u0004\b!\u0010 R$\u0010$\u001a\u00020#2\u0006\u0010\"\u001a\u00020#@@X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u0010)\u001a\u00020#2\u0006\u0010\"\u001a\u00020#@@X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010&\"\u0004\b+\u0010(R\u0018\u0010,\u001a\u00060-R\u00020\u0000X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0018\u00100\u001a\u000601R\u00020\u0000X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0018\u00104\u001a\u000605R\u00020\u0000X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u00107R$\u00108\u001a\u00020#2\u0006\u0010\"\u001a\u00020#@@X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u0010&\"\u0004\b:\u0010(R$\u0010;\u001a\u00020#2\u0006\u0010\"\u001a\u00020#@@X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b<\u0010&\"\u0004\b=\u0010(R\u0018\u0010>\u001a\u00060-R\u00020\u0000X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b?\u0010/\u00a8\u0006c"}, d2={"Lokhttp3/internal/http2/Http2Stream;", "", "id", "", "connection", "Lokhttp3/internal/http2/Http2Connection;", "outFinished", "", "inFinished", "headers", "Lokhttp3/Headers;", "(ILokhttp3/internal/http2/Http2Connection;ZZLokhttp3/Headers;)V", "getConnection", "()Lokhttp3/internal/http2/Http2Connection;", "errorCode", "Lokhttp3/internal/http2/ErrorCode;", "getErrorCode$okhttp", "()Lokhttp3/internal/http2/ErrorCode;", "setErrorCode$okhttp", "(Lokhttp3/internal/http2/ErrorCode;)V", "errorException", "Ljava/io/IOException;", "getErrorException$okhttp", "()Ljava/io/IOException;", "setErrorException$okhttp", "(Ljava/io/IOException;)V", "hasResponseHeaders", "headersQueue", "Ljava/util/ArrayDeque;", "getId", "()I", "isLocallyInitiated", "()Z", "isOpen", "<set-?>", "", "readBytesAcknowledged", "getReadBytesAcknowledged", "()J", "setReadBytesAcknowledged$okhttp", "(J)V", "readBytesTotal", "getReadBytesTotal", "setReadBytesTotal$okhttp", "readTimeout", "Lokhttp3/internal/http2/Http2Stream$StreamTimeout;", "getReadTimeout$okhttp", "()Lokhttp3/internal/http2/Http2Stream$StreamTimeout;", "sink", "Lokhttp3/internal/http2/Http2Stream$FramingSink;", "getSink$okhttp", "()Lokhttp3/internal/http2/Http2Stream$FramingSink;", "source", "Lokhttp3/internal/http2/Http2Stream$FramingSource;", "getSource$okhttp", "()Lokhttp3/internal/http2/Http2Stream$FramingSource;", "writeBytesMaximum", "getWriteBytesMaximum", "setWriteBytesMaximum$okhttp", "writeBytesTotal", "getWriteBytesTotal", "setWriteBytesTotal$okhttp", "writeTimeout", "getWriteTimeout$okhttp", "addBytesToWriteWindow", "", "delta", "cancelStreamIfNecessary", "cancelStreamIfNecessary$okhttp", "checkOutNotClosed", "checkOutNotClosed$okhttp", "close", "rstStatusCode", "closeInternal", "closeLater", "enqueueTrailers", "trailers", "getSink", "Lokio/Sink;", "getSource", "Lokio/Source;", "Lokio/Timeout;", "receiveData", "Lokio/BufferedSource;", "length", "receiveHeaders", "receiveRstStream", "takeHeaders", "waitForIo", "waitForIo$okhttp", "writeHeaders", "responseHeaders", "", "Lokhttp3/internal/http2/Header;", "flushHeaders", "Companion", "FramingSink", "FramingSource", "StreamTimeout", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class Http2Stream {
    public static final Companion Companion = new Companion(null);
    public static final long EMIT_BUFFER_SIZE = 16384L;
    private final Http2Connection connection;
    private ErrorCode errorCode;
    private IOException errorException;
    private boolean hasResponseHeaders;
    private final ArrayDeque<Headers> headersQueue;
    private final int id;
    private long readBytesAcknowledged;
    private long readBytesTotal;
    private final StreamTimeout readTimeout;
    private final FramingSink sink;
    private final FramingSource source;
    private long writeBytesMaximum;
    private long writeBytesTotal;
    private final StreamTimeout writeTimeout;

    public Http2Stream(int n, Http2Connection http2Connection, boolean bl, boolean bl2, Headers headers) {
        Intrinsics.checkNotNullParameter((Object)http2Connection, (String)"connection");
        this.id = n;
        this.connection = http2Connection;
        this.writeBytesMaximum = http2Connection.getPeerSettings().getInitialWindowSize();
        this.headersQueue = new ArrayDeque();
        this.source = new FramingSource(this, (long)this.connection.getOkHttpSettings().getInitialWindowSize(), bl2);
        this.sink = new FramingSink(this, bl);
        this.readTimeout = new StreamTimeout(this);
        this.writeTimeout = new StreamTimeout(this);
        if (headers != null) {
            if (!(this.isLocallyInitiated() ^ true)) throw (Throwable)new IllegalStateException("locally-initiated streams shouldn't have headers yet".toString());
            ((Collection)this.headersQueue).add(headers);
        } else if (!this.isLocallyInitiated()) throw (Throwable)new IllegalStateException("remotely-initiated streams should have headers".toString());
    }

    /*
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    private final boolean closeInternal(ErrorCode object, IOException iOException) {
        if (Util.assertionsEnabled && Thread.holdsLock(this)) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Thread ");
            ((StringBuilder)object).append((Object)Thread.currentThread().getName());
            ((StringBuilder)object).append(" MUST NOT hold lock on ");
            ((StringBuilder)object).append(this);
            throw new AssertionError((Object)((StringBuilder)object).toString());
        }
        synchronized (this) {
            void var2_2;
            boolean bl;
            ErrorCode errorCode = this.getErrorCode$okhttp();
            if (errorCode != null) {
                return false;
            }
            if (this.getSource$okhttp().getFinished$okhttp() && (bl = this.getSink$okhttp().getFinished())) {
                return false;
            }
            this.setErrorCode$okhttp((ErrorCode)object);
            this.setErrorException$okhttp((IOException)var2_2);
            ((Object)this).notifyAll();
            object = Unit.INSTANCE;
        }
        this.connection.removeStream$okhttp(this.id);
        return true;
    }

    public final void addBytesToWriteWindow(long l) {
        this.writeBytesMaximum += l;
        if (l <= 0L) return;
        ((Object)this).notifyAll();
    }

    public final void cancelStreamIfNecessary$okhttp() throws IOException {
        block5: {
            boolean bl;
            block4: {
                if (Util.assertionsEnabled && Thread.holdsLock(this)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Thread ");
                    stringBuilder.append((Object)Thread.currentThread().getName());
                    stringBuilder.append(" MUST NOT hold lock on ");
                    stringBuilder.append(this);
                    throw new AssertionError((Object)stringBuilder.toString());
                }
                synchronized (this) {
                    boolean bl2 = !this.getSource$okhttp().getFinished$okhttp() && this.getSource$okhttp().getClosed$okhttp() && (this.getSink$okhttp().getFinished() || this.getSink$okhttp().getClosed());
                    bl = this.isOpen();
                    Unit unit = Unit.INSTANCE;
                    // MONITOREXIT @DISABLED, blocks:[0, 1] lbl17 : MonitorExitStatement: MONITOREXIT : this
                    if (!bl2) break block4;
                }
                this.close(ErrorCode.CANCEL, null);
                break block5;
            }
            if (bl) return;
            this.connection.removeStream$okhttp(this.id);
        }
    }

    public final void checkOutNotClosed$okhttp() throws IOException {
        IOException iOException;
        if (this.sink.getClosed()) throw new IOException("stream closed");
        if (this.sink.getFinished()) throw new IOException("stream finished");
        if (this.errorCode == null) return;
        IOException iOException2 = iOException = this.errorException;
        if (iOException != null) throw (Throwable)iOException2;
        iOException2 = this.errorCode;
        Intrinsics.checkNotNull((Object)iOException2);
        iOException2 = new StreamResetException((ErrorCode)iOException2);
        throw (Throwable)iOException2;
    }

    public final void close(ErrorCode errorCode, IOException iOException) throws IOException {
        Intrinsics.checkNotNullParameter((Object)errorCode, (String)"rstStatusCode");
        if (!this.closeInternal(errorCode, iOException)) {
            return;
        }
        this.connection.writeSynReset$okhttp(this.id, errorCode);
    }

    public final void closeLater(ErrorCode errorCode) {
        Intrinsics.checkNotNullParameter((Object)errorCode, (String)"errorCode");
        if (!this.closeInternal(errorCode, null)) {
            return;
        }
        this.connection.writeSynResetLater$okhttp(this.id, errorCode);
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void enqueueTrailers(Headers object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"trailers");
        synchronized (this) {
            boolean bl = this.getSink$okhttp().getFinished();
            boolean bl2 = true;
            if (!(bl ^ true)) {
                IllegalStateException illegalStateException = new IllegalStateException("already finished".toString());
                throw (Throwable)illegalStateException;
            }
            if (object.size() == 0) {
                bl2 = false;
            }
            if (bl2) {
                this.getSink$okhttp().setTrailers(object);
                Unit unit = Unit.INSTANCE;
                return;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("trailers.size() == 0".toString());
            throw (Throwable)illegalArgumentException;
        }
    }

    public final Http2Connection getConnection() {
        return this.connection;
    }

    public final ErrorCode getErrorCode$okhttp() {
        synchronized (this) {
            ErrorCode errorCode = this.errorCode;
            return errorCode;
        }
    }

    public final IOException getErrorException$okhttp() {
        return this.errorException;
    }

    public final int getId() {
        return this.id;
    }

    public final long getReadBytesAcknowledged() {
        return this.readBytesAcknowledged;
    }

    public final long getReadBytesTotal() {
        return this.readBytesTotal;
    }

    public final StreamTimeout getReadTimeout$okhttp() {
        return this.readTimeout;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled force condition propagation
     */
    public final Sink getSink() {
        synchronized (this) {
            boolean bl = this.hasResponseHeaders || this.isLocallyInitiated();
            if (bl) {
                Unit unit = Unit.INSTANCE;
                return (Sink)this.sink;
            }
            {
                IllegalStateException illegalStateException = new IllegalStateException("reply before requesting the sink".toString());
                throw (Throwable)illegalStateException;
            }
        }
    }

    public final FramingSink getSink$okhttp() {
        return this.sink;
    }

    public final Source getSource() {
        return (Source)this.source;
    }

    public final FramingSource getSource$okhttp() {
        return this.source;
    }

    public final long getWriteBytesMaximum() {
        return this.writeBytesMaximum;
    }

    public final long getWriteBytesTotal() {
        return this.writeBytesTotal;
    }

    public final StreamTimeout getWriteTimeout$okhttp() {
        return this.writeTimeout;
    }

    public final boolean isLocallyInitiated() {
        int n = this.id;
        boolean bl = true;
        boolean bl2 = (n & 1) == 1;
        bl2 = this.connection.getClient$okhttp() == bl2 ? bl : false;
        return bl2;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final boolean isOpen() {
        synchronized (this) {
            boolean bl;
            ErrorCode errorCode = this.errorCode;
            if (errorCode != null) {
                return false;
            }
            if (!this.source.getFinished$okhttp()) {
                if (!this.source.getClosed$okhttp()) return true;
            }
            if (!this.sink.getFinished()) {
                if (!this.sink.getClosed()) return true;
            }
            if (!(bl = this.hasResponseHeaders)) return true;
            return false;
        }
    }

    public final Timeout readTimeout() {
        return (Timeout)this.readTimeout;
    }

    public final void receiveData(BufferedSource object, int n) throws IOException {
        Intrinsics.checkNotNullParameter((Object)object, (String)"source");
        if (Util.assertionsEnabled && Thread.holdsLock(this)) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Thread ");
            ((StringBuilder)object).append((Object)Thread.currentThread().getName());
            ((StringBuilder)object).append(" MUST NOT hold lock on ");
            ((StringBuilder)object).append(this);
            throw new AssertionError((Object)((StringBuilder)object).toString());
        }
        this.source.receive$okhttp((BufferedSource)object, (long)n);
    }

    public final void receiveHeaders(Headers object, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"headers");
        if (Util.assertionsEnabled && Thread.holdsLock(this)) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Thread ");
            ((StringBuilder)object).append((Object)Thread.currentThread().getName());
            ((StringBuilder)object).append(" MUST NOT hold lock on ");
            ((StringBuilder)object).append(this);
            throw new AssertionError((Object)((StringBuilder)object).toString());
        }
        synchronized (this) {
            if (this.hasResponseHeaders && bl) {
                this.getSource$okhttp().setTrailers((Headers)object);
            } else {
                this.hasResponseHeaders = true;
                ((Collection)this.headersQueue).add(object);
            }
            if (bl) {
                this.getSource$okhttp().setFinished$okhttp(true);
            }
            bl = this.isOpen();
            ((Object)this).notifyAll();
            object = Unit.INSTANCE;
            // MONITOREXIT @DISABLED, blocks:[0, 1] lbl26 : MonitorExitStatement: MONITOREXIT : this
            if (bl) return;
        }
        this.connection.removeStream$okhttp(this.id);
    }

    public final void receiveRstStream(ErrorCode errorCode) {
        synchronized (this) {
            Intrinsics.checkNotNullParameter((Object)errorCode, (String)"errorCode");
            if (this.errorCode != null) return;
            this.errorCode = errorCode;
            ((Object)this).notifyAll();
            return;
        }
    }

    public final void setErrorCode$okhttp(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public final void setErrorException$okhttp(IOException iOException) {
        this.errorException = iOException;
    }

    public final void setReadBytesAcknowledged$okhttp(long l) {
        this.readBytesAcknowledged = l;
    }

    public final void setReadBytesTotal$okhttp(long l) {
        this.readBytesTotal = l;
    }

    public final void setWriteBytesMaximum$okhttp(long l) {
        this.writeBytesMaximum = l;
    }

    public final void setWriteBytesTotal$okhttp(long l) {
        this.writeBytesTotal = l;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     */
    public final Headers takeHeaders() throws IOException {
        synchronized (this) {
            this.readTimeout.enter();
            try {
                while (this.headersQueue.isEmpty() && this.errorCode == null) {
                    this.waitForIo$okhttp();
                }
            }
            finally {
                this.readTimeout.exitAndThrowIfTimedOut();
            }
            {
                IOException iOException;
                if (((Collection)this.headersQueue).isEmpty() ^ true) {
                    Headers headers = this.headersQueue.removeFirst();
                    Intrinsics.checkNotNullExpressionValue((Object)headers, (String)"headersQueue.removeFirst()");
                    return headers;
                }
                IOException iOException2 = iOException = this.errorException;
                if (iOException != null) throw (Throwable)iOException2;
                iOException = this.errorCode;
                Intrinsics.checkNotNull((Object)iOException);
                iOException2 = new StreamResetException((ErrorCode)iOException);
                throw (Throwable)iOException2;
            }
        }
    }

    public final Headers trailers() throws IOException {
        synchronized (this) {
            if (this.source.getFinished$okhttp() && this.source.getReceiveBuffer().exhausted() && this.source.getReadBuffer().exhausted()) {
                Headers headers;
                Headers headers2 = headers = this.source.getTrailers();
                if (headers != null) return headers2;
                headers2 = Util.EMPTY_HEADERS;
                return headers2;
            }
            if (this.errorCode != null) {
                IOException iOException;
                IOException iOException2 = iOException = this.errorException;
                if (iOException != null) throw (Throwable)iOException2;
                iOException = this.errorCode;
                Intrinsics.checkNotNull((Object)iOException);
                iOException2 = new StreamResetException((ErrorCode)iOException);
                throw (Throwable)iOException2;
            }
            IllegalStateException illegalStateException = new IllegalStateException("too early; can't read the trailers yet");
            throw illegalStateException;
        }
    }

    public final void waitForIo$okhttp() throws InterruptedIOException {
        try {
            ((Object)this).wait();
            return;
        }
        catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    public final void writeHeaders(List<Header> object, boolean bl, boolean bl2) throws IOException {
        boolean bl3;
        block8: {
            Unit unit;
            boolean bl4;
            Intrinsics.checkNotNullParameter(object, (String)"responseHeaders");
            if (Util.assertionsEnabled && Thread.holdsLock(this)) {
                object = new StringBuilder();
                ((StringBuilder)object).append("Thread ");
                ((StringBuilder)object).append((Object)Thread.currentThread().getName());
                ((StringBuilder)object).append(" MUST NOT hold lock on ");
                ((StringBuilder)object).append(this);
                throw new AssertionError((Object)((StringBuilder)object).toString());
            }
            synchronized (this) {
                bl4 = true;
                this.hasResponseHeaders = true;
                if (bl) {
                    this.getSink$okhttp().setFinished(true);
                }
                unit = Unit.INSTANCE;
                // MONITOREXIT @DISABLED, blocks:[0, 2] lbl20 : MonitorExitStatement: MONITOREXIT : this
                bl3 = bl2;
                if (bl2) break block8;
                unit = this.connection;
            }
            synchronized (unit) {
                bl2 = this.getConnection().getWriteBytesTotal() >= this.getConnection().getWriteBytesMaximum() ? bl4 : false;
                Unit unit2 = Unit.INSTANCE;
                // MONITOREXIT @DISABLED, blocks:[1, 3] lbl32 : MonitorExitStatement: MONITOREXIT : var6_7
                bl3 = bl2;
            }
        }
        this.connection.writeHeaders$okhttp(this.id, bl, (List)object);
        if (!bl3) return;
        this.connection.flush();
    }

    public final Timeout writeTimeout() {
        return (Timeout)this.writeTimeout;
    }
}
