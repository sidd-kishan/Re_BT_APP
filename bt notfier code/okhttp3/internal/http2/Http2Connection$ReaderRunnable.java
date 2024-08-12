/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Ref$ObjectRef
 *  okhttp3.Headers
 *  okhttp3.internal.Util
 *  okhttp3.internal.concurrent.TaskQueue
 *  okhttp3.internal.http2.ErrorCode
 *  okhttp3.internal.http2.Header
 *  okhttp3.internal.http2.Http2Connection
 *  okhttp3.internal.http2.Http2Connection$ReaderRunnable$applyAndAckSettings$1$1$2
 *  okhttp3.internal.http2.Http2Connection$ReaderRunnable$headers$1$1
 *  okhttp3.internal.http2.Http2Reader
 *  okhttp3.internal.http2.Http2Reader$Handler
 *  okhttp3.internal.http2.Http2Stream
 *  okhttp3.internal.http2.Http2Writer
 *  okhttp3.internal.http2.Settings
 *  okio.BufferedSource
 *  okio.ByteString
 */
package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import okhttp3.Headers;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Header;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Http2Reader;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.http2.Http2Writer;
import okhttp3.internal.http2.Settings;
import okio.BufferedSource;
import okio.ByteString;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0086\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\u0003H\u0016J8\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0016\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J(\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\fH\u0016J \u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0010H\u0016J.\u0010$\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010%\u001a\u00020\f2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'H\u0016J\t\u0010)\u001a\u00020\u0003H\u0096\u0002J \u0010*\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u00172\u0006\u0010,\u001a\u00020\f2\u0006\u0010-\u001a\u00020\fH\u0016J(\u0010.\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010/\u001a\u00020\f2\u0006\u00100\u001a\u00020\f2\u0006\u00101\u001a\u00020\u0017H\u0016J&\u00102\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u00103\u001a\u00020\f2\f\u00104\u001a\b\u0012\u0004\u0012\u00020(0'H\u0016J\u0018\u00105\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010!\u001a\u00020\"H\u0016J\u0018\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u00106\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u00107\u001a\u00020\u0014H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u00068"}, d2={"Lokhttp3/internal/http2/Http2Connection$ReaderRunnable;", "Lokhttp3/internal/http2/Http2Reader$Handler;", "Lkotlin/Function0;", "", "reader", "Lokhttp3/internal/http2/Http2Reader;", "(Lokhttp3/internal/http2/Http2Connection;Lokhttp3/internal/http2/Http2Reader;)V", "getReader$okhttp", "()Lokhttp3/internal/http2/Http2Reader;", "ackSettings", "alternateService", "streamId", "", "origin", "", "protocol", "Lokio/ByteString;", "host", "port", "maxAge", "", "applyAndAckSettings", "clearPrevious", "", "settings", "Lokhttp3/internal/http2/Settings;", "data", "inFinished", "source", "Lokio/BufferedSource;", "length", "goAway", "lastGoodStreamId", "errorCode", "Lokhttp3/internal/http2/ErrorCode;", "debugData", "headers", "associatedStreamId", "headerBlock", "", "Lokhttp3/internal/http2/Header;", "invoke", "ping", "ack", "payload1", "payload2", "priority", "streamDependency", "weight", "exclusive", "pushPromise", "promisedStreamId", "requestHeaders", "rstStream", "windowUpdate", "windowSizeIncrement", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class Http2Connection.ReaderRunnable
implements Http2Reader.Handler,
Function0<Unit> {
    private final Http2Reader reader;
    final Http2Connection this$0;

    public Http2Connection.ReaderRunnable(Http2Connection http2Connection, Http2Reader http2Reader) {
        Intrinsics.checkNotNullParameter((Object)http2Connection, (String)"this$0");
        Intrinsics.checkNotNullParameter((Object)http2Reader, (String)"reader");
        this.this$0 = http2Connection;
        this.reader = http2Reader;
    }

    public void ackSettings() {
    }

    public void alternateService(int n, String string, ByteString byteString, String string2, int n2, long l) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"origin");
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"protocol");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"host");
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled unnecessary exception pruning
     */
    public final void applyAndAckSettings(boolean bl, Settings object) {
        int n;
        long l;
        Object object2;
        Intrinsics.checkNotNullParameter((Object)object, (String)"settings");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Http2Writer http2Writer = this.this$0.getWriter();
        Http2Connection http2Connection = this.this$0;
        synchronized (http2Writer) {
            synchronized (http2Connection) {
            }
            {
                Object object3 = http2Connection.getPeerSettings();
                if (!bl) {
                    object2 = new Settings();
                    object2.merge(object3);
                    object2.merge((Settings)object);
                    object = Unit.INSTANCE;
                    object = object2;
                }
                objectRef.element = object;
                l = (long)((Settings)objectRef.element).getInitialWindowSize() - (long)object3.getInitialWindowSize();
                n = 0;
                if (l != 0L && !http2Connection.getStreams$okhttp().isEmpty()) {
                    object = http2Connection.getStreams$okhttp().values().toArray(new Http2Stream[0]);
                    if (object == null) {
                        object = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                        throw object;
                    }
                    object = (Http2Stream[])object;
                } else {
                    object = null;
                }
                http2Connection.setPeerSettings((Settings)objectRef.element);
                object2 = Http2Connection.access$getSettingsListenerQueue$p((Http2Connection)http2Connection);
                object3 = Intrinsics.stringPlus((String)http2Connection.getConnectionName$okhttp(), (Object)" onSettings");
                applyAndAckSettings.1.1.2 var12_12 = new /* Unavailable Anonymous Inner Class!! */;
                TaskQueue.execute$default((TaskQueue)object2, (String)object3, (long)0L, (boolean)false, (Function0)((Function0)var12_12), (int)6, null);
                object2 = Unit.INSTANCE;
            }
            {
                try {
                    http2Connection.getWriter().applyAndAckSettings((Settings)objectRef.element);
                }
                catch (IOException iOException) {
                    Http2Connection.access$failConnection((Http2Connection)http2Connection, (IOException)iOException);
                }
                object2 = Unit.INSTANCE;
                // MONITOREXIT @DISABLED, blocks:[2, 6] lbl43 : MonitorExitStatement: MONITOREXIT : var8_5
                if (object == null) return;
            }
        }
        int n2 = ((Object)object).length;
        while (n < n2) {
            object2 = object[n];
            ++n;
            synchronized (object2) {
                object2.addBytesToWriteWindow(l);
                http2Writer = Unit.INSTANCE;
            }
        }
    }

    public void data(boolean bl, int n, BufferedSource bufferedSource, int n2) throws IOException {
        Intrinsics.checkNotNullParameter((Object)bufferedSource, (String)"source");
        if (this.this$0.pushedStream$okhttp(n)) {
            this.this$0.pushDataLater$okhttp(n, bufferedSource, n2, bl);
            return;
        }
        Http2Stream http2Stream = this.this$0.getStream(n);
        if (http2Stream == null) {
            this.this$0.writeSynResetLater$okhttp(n, ErrorCode.PROTOCOL_ERROR);
            http2Stream = this.this$0;
            long l = n2;
            http2Stream.updateConnectionFlowControl$okhttp(l);
            bufferedSource.skip(l);
            return;
        }
        http2Stream.receiveData(bufferedSource, n2);
        if (!bl) return;
        http2Stream.receiveHeaders(Util.EMPTY_HEADERS, true);
    }

    public final Http2Reader getReader$okhttp() {
        return this.reader;
    }

    /*
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    public void goAway(int n, ErrorCode http2StreamArray, ByteString object) {
        block5: {
            Intrinsics.checkNotNullParameter((Object)http2StreamArray, (String)"errorCode");
            Intrinsics.checkNotNullParameter((Object)object, (String)"debugData");
            object.size();
            http2StreamArray = this.this$0;
            // MONITORENTER : http2StreamArray
            object = http2StreamArray.getStreams$okhttp().values();
            int n2 = 0;
            object = object.toArray(new Http2Stream[0]);
            if (object == null) break block5;
            Http2Connection.access$setShutdown$p((Http2Connection)http2StreamArray, (boolean)true);
            Unit unit = Unit.INSTANCE;
            // MONITOREXIT : http2StreamArray
            http2StreamArray = (Http2Stream[])object;
            int n3 = http2StreamArray.length;
            while (n2 < n3) {
                int n4;
                object = http2StreamArray[n2];
                n2 = n4 = n2 + 1;
                if (object.getId() <= n) continue;
                n2 = n4;
                if (!object.isLocallyInitiated()) continue;
                object.receiveRstStream(ErrorCode.REFUSED_STREAM);
                this.this$0.removeStream$okhttp(object.getId());
                n2 = n4;
            }
            return;
        }
        object = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        throw object;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void headers(boolean bl, int n, int n2, List<Header> http2Stream) {
        Intrinsics.checkNotNullParameter((Object)http2Stream, (String)"headerBlock");
        if (this.this$0.pushedStream$okhttp(n)) {
            this.this$0.pushHeadersLater$okhttp(n, (List)http2Stream, bl);
            return;
        }
        Http2Connection http2Connection = this.this$0;
        synchronized (http2Connection) {
            Object object = http2Connection.getStream(n);
            if (object != null) {
                Unit unit = Unit.INSTANCE;
                // MONITOREXIT @DISABLED, blocks:[4, 8] lbl10 : MonitorExitStatement: MONITOREXIT : var6_5
                object.receiveHeaders(Util.toHeaders((List)http2Stream), bl);
                return;
            }
            boolean bl2 = Http2Connection.access$isShutdown$p((Http2Connection)http2Connection);
            if (bl2) {
                return;
            }
            n2 = http2Connection.getLastGoodStreamId$okhttp();
            if (n <= n2) {
                return;
            }
            n2 = http2Connection.getNextStreamId$okhttp();
            if (n % 2 == n2 % 2) {
                return;
            }
            Headers headers2 = Util.toHeaders((List)http2Stream);
            http2Stream = new Http2Stream(n, http2Connection, false, bl, headers2);
            http2Connection.setLastGoodStreamId$okhttp(n);
            http2Connection.getStreams$okhttp().put(n, http2Stream);
            headers2 = Http2Connection.access$getTaskRunner$p((Http2Connection)http2Connection).newQueue();
            object = new StringBuilder();
            ((StringBuilder)object).append(http2Connection.getConnectionName$okhttp());
            ((StringBuilder)object).append('[');
            ((StringBuilder)object).append(n);
            ((StringBuilder)object).append("] onStream");
            object = ((StringBuilder)object).toString();
            headers.1.1 var9_10 = new /* Unavailable Anonymous Inner Class!! */;
            TaskQueue.execute$default((TaskQueue)headers2, (String)object, (long)0L, (boolean)false, (Function0)((Function0)var9_10), (int)6, null);
            return;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void invoke() {
        ErrorCode errorCode3 = ErrorCode.INTERNAL_ERROR;
        ErrorCode errorCode = ErrorCode.INTERNAL_ERROR;
        ErrorCode errorCode4 = null;
        IOException iOException2 = null;
        Object object = errorCode3;
        IOException iOException = iOException2;
        ErrorCode errorCode2 = errorCode3;
        try {
            try {
                this.reader.readConnectionPreface((Http2Reader.Handler)this);
                do {
                    object = errorCode3;
                    iOException = iOException2;
                    errorCode2 = errorCode3;
                } while (this.reader.nextFrame(false, (Http2Reader.Handler)this));
                object = errorCode3;
                iOException = iOException2;
                errorCode2 = errorCode3;
                object = errorCode3 = ErrorCode.NO_ERROR;
                iOException = iOException2;
                errorCode2 = errorCode3;
                iOException2 = ErrorCode.CANCEL;
                errorCode2 = errorCode3;
                object = iOException2;
                errorCode3 = errorCode4;
            }
            catch (IOException iOException3) {
                object = errorCode2;
                iOException = iOException3;
                object = errorCode2 = ErrorCode.PROTOCOL_ERROR;
                iOException = iOException3;
                object = errorCode4 = ErrorCode.PROTOCOL_ERROR;
            }
        }
        catch (Throwable throwable2222) {}
        this.this$0.close$okhttp(errorCode2, object, (IOException)errorCode3);
        Util.closeQuietly((Closeable)((Closeable)this.reader));
        return;
        this.this$0.close$okhttp(object, errorCode, iOException);
        Util.closeQuietly((Closeable)((Closeable)this.reader));
        throw throwable2222;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void ping(boolean bl, int n, int n2) {
        if (!bl) {
            TaskQueue.execute$default((TaskQueue)Http2Connection.access$getWriterQueue$p((Http2Connection)this.this$0), (String)Intrinsics.stringPlus((String)this.this$0.getConnectionName$okhttp(), (Object)" ping"), (long)0L, (boolean)false, (Function0)((Function0)new /* Unavailable Anonymous Inner Class!! */), (int)6, null);
            return;
        }
        Http2Connection http2Connection = this.this$0;
        synchronized (http2Connection) {
            if (n != 1) {
                if (n != 2) {
                    if (n == 3) {
                        Http2Connection.access$setAwaitPongsReceived$p((Http2Connection)http2Connection, (long)(Http2Connection.access$getAwaitPongsReceived$p((Http2Connection)http2Connection) + 1L));
                        ((Object)http2Connection).notifyAll();
                    }
                    Unit unit = Unit.INSTANCE;
                } else {
                    long l = Http2Connection.access$getDegradedPongsReceived$p((Http2Connection)http2Connection);
                    Http2Connection.access$setDegradedPongsReceived$p((Http2Connection)http2Connection, (long)(1L + l));
                }
            } else {
                long l = Http2Connection.access$getIntervalPongsReceived$p((Http2Connection)http2Connection);
                Http2Connection.access$setIntervalPongsReceived$p((Http2Connection)http2Connection, (long)(1L + l));
            }
            return;
        }
    }

    public void priority(int n, int n2, int n3, boolean bl) {
    }

    public void pushPromise(int n, int n2, List<Header> list) {
        Intrinsics.checkNotNullParameter(list, (String)"requestHeaders");
        this.this$0.pushRequestLater$okhttp(n2, list);
    }

    public void rstStream(int n, ErrorCode errorCode) {
        Intrinsics.checkNotNullParameter((Object)errorCode, (String)"errorCode");
        if (this.this$0.pushedStream$okhttp(n)) {
            this.this$0.pushResetLater$okhttp(n, errorCode);
            return;
        }
        Http2Stream http2Stream = this.this$0.removeStream$okhttp(n);
        if (http2Stream == null) return;
        http2Stream.receiveRstStream(errorCode);
    }

    public void settings(boolean bl, Settings settings2) {
        Intrinsics.checkNotNullParameter((Object)settings2, (String)"settings");
        TaskQueue.execute$default((TaskQueue)Http2Connection.access$getWriterQueue$p((Http2Connection)this.this$0), (String)Intrinsics.stringPlus((String)this.this$0.getConnectionName$okhttp(), (Object)" applyAndAckSettings"), (long)0L, (boolean)false, (Function0)((Function0)new /* Unavailable Anonymous Inner Class!! */), (int)6, null);
    }

    public void windowUpdate(int n, long l) {
        if (n == 0) {
            Http2Connection http2Connection = this.this$0;
            synchronized (http2Connection) {
                Http2Connection.access$setWriteBytesMaximum$p((Http2Connection)http2Connection, (long)(http2Connection.getWriteBytesMaximum() + l));
                ((Object)http2Connection).notifyAll();
                Unit unit = Unit.INSTANCE;
            }
        }
        Http2Stream http2Stream = this.this$0.getStream(n);
        if (http2Stream == null) return;
        synchronized (http2Stream) {
            http2Stream.addBytesToWriteWindow(l);
            Unit unit = Unit.INSTANCE;
        }
    }
}
