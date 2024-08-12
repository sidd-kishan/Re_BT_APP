/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Ref$IntRef
 *  okhttp3.internal.Util
 *  okhttp3.internal.concurrent.TaskQueue
 *  okhttp3.internal.concurrent.TaskRunner
 *  okhttp3.internal.http2.ConnectionShutdownException
 *  okhttp3.internal.http2.ErrorCode
 *  okhttp3.internal.http2.Header
 *  okhttp3.internal.http2.Http2Connection$Builder
 *  okhttp3.internal.http2.Http2Connection$Companion
 *  okhttp3.internal.http2.Http2Connection$Listener
 *  okhttp3.internal.http2.Http2Connection$ReaderRunnable
 *  okhttp3.internal.http2.Http2Reader
 *  okhttp3.internal.http2.Http2Stream
 *  okhttp3.internal.http2.Http2Writer
 *  okhttp3.internal.http2.PushObserver
 *  okhttp3.internal.http2.Settings
 *  okio.Buffer
 *  okio.BufferedSource
 */
package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Header;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Http2Reader;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.http2.Http2Writer;
import okhttp3.internal.http2.PushObserver;
import okhttp3.internal.http2.Settings;
import okio.Buffer;
import okio.BufferedSource;

@Metadata(d1={"\u0000\u00b4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 \u0099\u00012\u00020\u0001:\b\u0098\u0001\u0099\u0001\u009a\u0001\u009b\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010P\u001a\u00020QJ\b\u0010R\u001a\u00020QH\u0016J'\u0010R\u001a\u00020Q2\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020T2\b\u0010V\u001a\u0004\u0018\u00010WH\u0000\u00a2\u0006\u0002\bXJ\u0012\u0010Y\u001a\u00020Q2\b\u0010Z\u001a\u0004\u0018\u00010WH\u0002J\u0006\u0010[\u001a\u00020QJ\u0010\u0010\\\u001a\u0004\u0018\u00010B2\u0006\u0010]\u001a\u00020\u0012J\u000e\u0010^\u001a\u00020\t2\u0006\u0010_\u001a\u00020\u0006J&\u0010`\u001a\u00020B2\u0006\u0010a\u001a\u00020\u00122\f\u0010b\u001a\b\u0012\u0004\u0012\u00020d0c2\u0006\u0010e\u001a\u00020\tH\u0002J\u001c\u0010`\u001a\u00020B2\f\u0010b\u001a\b\u0012\u0004\u0012\u00020d0c2\u0006\u0010e\u001a\u00020\tJ\u0006\u0010f\u001a\u00020\u0012J-\u0010g\u001a\u00020Q2\u0006\u0010h\u001a\u00020\u00122\u0006\u0010i\u001a\u00020j2\u0006\u0010k\u001a\u00020\u00122\u0006\u0010l\u001a\u00020\tH\u0000\u00a2\u0006\u0002\bmJ+\u0010n\u001a\u00020Q2\u0006\u0010h\u001a\u00020\u00122\f\u0010b\u001a\b\u0012\u0004\u0012\u00020d0c2\u0006\u0010l\u001a\u00020\tH\u0000\u00a2\u0006\u0002\boJ#\u0010p\u001a\u00020Q2\u0006\u0010h\u001a\u00020\u00122\f\u0010b\u001a\b\u0012\u0004\u0012\u00020d0cH\u0000\u00a2\u0006\u0002\bqJ\u001d\u0010r\u001a\u00020Q2\u0006\u0010h\u001a\u00020\u00122\u0006\u0010s\u001a\u00020TH\u0000\u00a2\u0006\u0002\btJ$\u0010u\u001a\u00020B2\u0006\u0010a\u001a\u00020\u00122\f\u0010b\u001a\b\u0012\u0004\u0012\u00020d0c2\u0006\u0010e\u001a\u00020\tJ\u0015\u0010v\u001a\u00020\t2\u0006\u0010h\u001a\u00020\u0012H\u0000\u00a2\u0006\u0002\bwJ\u0017\u0010x\u001a\u0004\u0018\u00010B2\u0006\u0010h\u001a\u00020\u0012H\u0000\u00a2\u0006\u0002\byJ\r\u0010z\u001a\u00020QH\u0000\u00a2\u0006\u0002\b{J\u000e\u0010|\u001a\u00020Q2\u0006\u0010}\u001a\u00020&J\u000e\u0010~\u001a\u00020Q2\u0006\u0010\u007f\u001a\u00020TJ\u001e\u0010\u0080\u0001\u001a\u00020Q2\t\b\u0002\u0010\u0081\u0001\u001a\u00020\t2\b\b\u0002\u0010E\u001a\u00020FH\u0007J\u0018\u0010\u0082\u0001\u001a\u00020Q2\u0007\u0010\u0083\u0001\u001a\u00020\u0006H\u0000\u00a2\u0006\u0003\b\u0084\u0001J,\u0010\u0085\u0001\u001a\u00020Q2\u0006\u0010h\u001a\u00020\u00122\u0007\u0010\u0086\u0001\u001a\u00020\t2\n\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0088\u00012\u0006\u0010k\u001a\u00020\u0006J/\u0010\u0089\u0001\u001a\u00020Q2\u0006\u0010h\u001a\u00020\u00122\u0007\u0010\u0086\u0001\u001a\u00020\t2\r\u0010\u008a\u0001\u001a\b\u0012\u0004\u0012\u00020d0cH\u0000\u00a2\u0006\u0003\b\u008b\u0001J\u0007\u0010\u008c\u0001\u001a\u00020QJ\"\u0010\u008c\u0001\u001a\u00020Q2\u0007\u0010\u008d\u0001\u001a\u00020\t2\u0007\u0010\u008e\u0001\u001a\u00020\u00122\u0007\u0010\u008f\u0001\u001a\u00020\u0012J\u0007\u0010\u0090\u0001\u001a\u00020QJ\u001f\u0010\u0091\u0001\u001a\u00020Q2\u0006\u0010h\u001a\u00020\u00122\u0006\u0010\u007f\u001a\u00020TH\u0000\u00a2\u0006\u0003\b\u0092\u0001J\u001f\u0010\u0093\u0001\u001a\u00020Q2\u0006\u0010h\u001a\u00020\u00122\u0006\u0010s\u001a\u00020TH\u0000\u00a2\u0006\u0003\b\u0094\u0001J \u0010\u0095\u0001\u001a\u00020Q2\u0006\u0010h\u001a\u00020\u00122\u0007\u0010\u0096\u0001\u001a\u00020\u0006H\u0000\u00a2\u0006\u0003\b\u0097\u0001R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\u0012X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u001fX\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u0012X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001b\"\u0004\b$\u0010\u001dR\u0011\u0010%\u001a\u00020&\u00a2\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020&X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010(\"\u0004\b+\u0010,R\u000e\u0010-\u001a\u00020.X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u00102\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u0006@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u001e\u00105\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u0006@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u00104R\u0015\u00107\u001a\u000608R\u00020\u0000\u00a2\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u000e\u0010;\u001a\u000200X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010<\u001a\u00020=X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b>\u0010?R \u0010@\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020B0AX\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u000e\u0010E\u001a\u00020FX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010G\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u0006@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\bH\u00104R\u001e\u0010I\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u0006@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\bJ\u00104R\u0011\u0010K\u001a\u00020L\u00a2\u0006\b\n\u0000\u001a\u0004\bM\u0010NR\u000e\u0010O\u001a\u000200X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u009c\u0001"}, d2={"Lokhttp3/internal/http2/Http2Connection;", "Ljava/io/Closeable;", "builder", "Lokhttp3/internal/http2/Http2Connection$Builder;", "(Lokhttp3/internal/http2/Http2Connection$Builder;)V", "awaitPingsSent", "", "awaitPongsReceived", "client", "", "getClient$okhttp", "()Z", "connectionName", "", "getConnectionName$okhttp", "()Ljava/lang/String;", "currentPushRequests", "", "", "degradedPingsSent", "degradedPongDeadlineNs", "degradedPongsReceived", "intervalPingsSent", "intervalPongsReceived", "isShutdown", "lastGoodStreamId", "getLastGoodStreamId$okhttp", "()I", "setLastGoodStreamId$okhttp", "(I)V", "listener", "Lokhttp3/internal/http2/Http2Connection$Listener;", "getListener$okhttp", "()Lokhttp3/internal/http2/Http2Connection$Listener;", "nextStreamId", "getNextStreamId$okhttp", "setNextStreamId$okhttp", "okHttpSettings", "Lokhttp3/internal/http2/Settings;", "getOkHttpSettings", "()Lokhttp3/internal/http2/Settings;", "peerSettings", "getPeerSettings", "setPeerSettings", "(Lokhttp3/internal/http2/Settings;)V", "pushObserver", "Lokhttp3/internal/http2/PushObserver;", "pushQueue", "Lokhttp3/internal/concurrent/TaskQueue;", "<set-?>", "readBytesAcknowledged", "getReadBytesAcknowledged", "()J", "readBytesTotal", "getReadBytesTotal", "readerRunnable", "Lokhttp3/internal/http2/Http2Connection$ReaderRunnable;", "getReaderRunnable", "()Lokhttp3/internal/http2/Http2Connection$ReaderRunnable;", "settingsListenerQueue", "socket", "Ljava/net/Socket;", "getSocket$okhttp", "()Ljava/net/Socket;", "streams", "", "Lokhttp3/internal/http2/Http2Stream;", "getStreams$okhttp", "()Ljava/util/Map;", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "writeBytesMaximum", "getWriteBytesMaximum", "writeBytesTotal", "getWriteBytesTotal", "writer", "Lokhttp3/internal/http2/Http2Writer;", "getWriter", "()Lokhttp3/internal/http2/Http2Writer;", "writerQueue", "awaitPong", "", "close", "connectionCode", "Lokhttp3/internal/http2/ErrorCode;", "streamCode", "cause", "Ljava/io/IOException;", "close$okhttp", "failConnection", "e", "flush", "getStream", "id", "isHealthy", "nowNs", "newStream", "associatedStreamId", "requestHeaders", "", "Lokhttp3/internal/http2/Header;", "out", "openStreamCount", "pushDataLater", "streamId", "source", "Lokio/BufferedSource;", "byteCount", "inFinished", "pushDataLater$okhttp", "pushHeadersLater", "pushHeadersLater$okhttp", "pushRequestLater", "pushRequestLater$okhttp", "pushResetLater", "errorCode", "pushResetLater$okhttp", "pushStream", "pushedStream", "pushedStream$okhttp", "removeStream", "removeStream$okhttp", "sendDegradedPingLater", "sendDegradedPingLater$okhttp", "setSettings", "settings", "shutdown", "statusCode", "start", "sendConnectionPreface", "updateConnectionFlowControl", "read", "updateConnectionFlowControl$okhttp", "writeData", "outFinished", "buffer", "Lokio/Buffer;", "writeHeaders", "alternating", "writeHeaders$okhttp", "writePing", "reply", "payload1", "payload2", "writePingAndAwaitPong", "writeSynReset", "writeSynReset$okhttp", "writeSynResetLater", "writeSynResetLater$okhttp", "writeWindowUpdateLater", "unacknowledgedBytesRead", "writeWindowUpdateLater$okhttp", "Builder", "Companion", "Listener", "ReaderRunnable", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class Http2Connection
implements Closeable {
    public static final int AWAIT_PING = 3;
    public static final Companion Companion = new Companion(null);
    private static final Settings DEFAULT_SETTINGS;
    public static final int DEGRADED_PING = 2;
    public static final int DEGRADED_PONG_TIMEOUT_NS = 1000000000;
    public static final int INTERVAL_PING = 1;
    public static final int OKHTTP_CLIENT_WINDOW_SIZE = 0x1000000;
    private long awaitPingsSent;
    private long awaitPongsReceived;
    private final boolean client;
    private final String connectionName;
    private final Set<Integer> currentPushRequests;
    private long degradedPingsSent;
    private long degradedPongDeadlineNs;
    private long degradedPongsReceived;
    private long intervalPingsSent;
    private long intervalPongsReceived;
    private boolean isShutdown;
    private int lastGoodStreamId;
    private final Listener listener;
    private int nextStreamId;
    private final Settings okHttpSettings;
    private Settings peerSettings;
    private final PushObserver pushObserver;
    private final TaskQueue pushQueue;
    private long readBytesAcknowledged;
    private long readBytesTotal;
    private final ReaderRunnable readerRunnable;
    private final TaskQueue settingsListenerQueue;
    private final Socket socket;
    private final Map<Integer, Http2Stream> streams;
    private final TaskRunner taskRunner;
    private long writeBytesMaximum;
    private long writeBytesTotal;
    private final Http2Writer writer;
    private final TaskQueue writerQueue;

    static {
        Settings settings2 = new Settings();
        settings2.set(7, 65535);
        settings2.set(5, 16384);
        DEFAULT_SETTINGS = settings2;
    }

    public Http2Connection(Builder builder) {
        TaskRunner taskRunner;
        Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
        this.client = builder.getClient$okhttp();
        this.listener = builder.getListener$okhttp();
        this.streams = new LinkedHashMap();
        this.connectionName = builder.getConnectionName$okhttp();
        int n = builder.getClient$okhttp() ? 3 : 2;
        this.nextStreamId = n;
        this.taskRunner = taskRunner = builder.getTaskRunner$okhttp();
        this.writerQueue = taskRunner.newQueue();
        this.pushQueue = this.taskRunner.newQueue();
        this.settingsListenerQueue = this.taskRunner.newQueue();
        this.pushObserver = builder.getPushObserver$okhttp();
        Settings settings2 = new Settings();
        if (builder.getClient$okhttp()) {
            settings2.set(7, 0x1000000);
        }
        taskRunner = Unit.INSTANCE;
        this.okHttpSettings = settings2;
        taskRunner = DEFAULT_SETTINGS;
        this.peerSettings = taskRunner;
        this.writeBytesMaximum = taskRunner.getInitialWindowSize();
        this.socket = builder.getSocket$okhttp();
        this.writer = new Http2Writer(builder.getSink$okhttp(), this.client);
        this.readerRunnable = new ReaderRunnable(this, new Http2Reader(builder.getSource$okhttp(), this.client));
        this.currentPushRequests = new LinkedHashSet();
        if (builder.getPingIntervalMillis$okhttp() == 0) return;
        long l = TimeUnit.MILLISECONDS.toNanos(builder.getPingIntervalMillis$okhttp());
        this.writerQueue.schedule(Intrinsics.stringPlus((String)this.connectionName, (Object)" ping"), l, (Function0)new /* Unavailable Anonymous Inner Class!! */);
    }

    public static final /* synthetic */ void access$failConnection(Http2Connection http2Connection, IOException iOException) {
        http2Connection.failConnection(iOException);
    }

    public static final /* synthetic */ long access$getAwaitPongsReceived$p(Http2Connection http2Connection) {
        return http2Connection.awaitPongsReceived;
    }

    public static final /* synthetic */ Set access$getCurrentPushRequests$p(Http2Connection http2Connection) {
        return http2Connection.currentPushRequests;
    }

    public static final /* synthetic */ Settings access$getDEFAULT_SETTINGS$cp() {
        return DEFAULT_SETTINGS;
    }

    public static final /* synthetic */ long access$getDegradedPongsReceived$p(Http2Connection http2Connection) {
        return http2Connection.degradedPongsReceived;
    }

    public static final /* synthetic */ long access$getIntervalPingsSent$p(Http2Connection http2Connection) {
        return http2Connection.intervalPingsSent;
    }

    public static final /* synthetic */ long access$getIntervalPongsReceived$p(Http2Connection http2Connection) {
        return http2Connection.intervalPongsReceived;
    }

    public static final /* synthetic */ PushObserver access$getPushObserver$p(Http2Connection http2Connection) {
        return http2Connection.pushObserver;
    }

    public static final /* synthetic */ TaskQueue access$getSettingsListenerQueue$p(Http2Connection http2Connection) {
        return http2Connection.settingsListenerQueue;
    }

    public static final /* synthetic */ TaskRunner access$getTaskRunner$p(Http2Connection http2Connection) {
        return http2Connection.taskRunner;
    }

    public static final /* synthetic */ TaskQueue access$getWriterQueue$p(Http2Connection http2Connection) {
        return http2Connection.writerQueue;
    }

    public static final /* synthetic */ boolean access$isShutdown$p(Http2Connection http2Connection) {
        return http2Connection.isShutdown;
    }

    public static final /* synthetic */ void access$setAwaitPongsReceived$p(Http2Connection http2Connection, long l) {
        http2Connection.awaitPongsReceived = l;
    }

    public static final /* synthetic */ void access$setDegradedPongsReceived$p(Http2Connection http2Connection, long l) {
        http2Connection.degradedPongsReceived = l;
    }

    public static final /* synthetic */ void access$setIntervalPingsSent$p(Http2Connection http2Connection, long l) {
        http2Connection.intervalPingsSent = l;
    }

    public static final /* synthetic */ void access$setIntervalPongsReceived$p(Http2Connection http2Connection, long l) {
        http2Connection.intervalPongsReceived = l;
    }

    public static final /* synthetic */ void access$setShutdown$p(Http2Connection http2Connection, boolean bl) {
        http2Connection.isShutdown = bl;
    }

    public static final /* synthetic */ void access$setWriteBytesMaximum$p(Http2Connection http2Connection, long l) {
        http2Connection.writeBytesMaximum = l;
    }

    private final void failConnection(IOException iOException) {
        this.close$okhttp(ErrorCode.PROTOCOL_ERROR, ErrorCode.PROTOCOL_ERROR, iOException);
    }

    /*
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    private final Http2Stream newStream(int n, List<Header> object, boolean bl) throws IOException {
        void var3_6;
        boolean bl2 = var3_6 ^ 1;
        Http2Writer http2Writer = this.writer;
        // MONITORENTER : http2Writer
        // MONITORENTER : this
        if (this.getNextStreamId$okhttp() > 0x3FFFFFFF) {
            this.shutdown(ErrorCode.REFUSED_STREAM);
        }
        if (this.isShutdown) {
            ConnectionShutdownException connectionShutdownException = new ConnectionShutdownException();
            throw connectionShutdownException;
        }
        int n2 = this.getNextStreamId$okhttp();
        this.setNextStreamId$okhttp(this.getNextStreamId$okhttp() + 2);
        Http2Stream http2Stream = new Http2Stream(n2, this, bl2, false, null);
        boolean bl3 = var3_6 == false || this.getWriteBytesTotal() >= this.getWriteBytesMaximum() || http2Stream.getWriteBytesTotal() >= http2Stream.getWriteBytesMaximum();
        if (http2Stream.isOpen()) {
            this.getStreams$okhttp().put(n2, http2Stream);
        }
        Unit unit = Unit.INSTANCE;
        // MONITOREXIT : this
        if (n == 0) {
            this.getWriter().headers(bl2, n2, (List)object);
        } else {
            if (!(true ^ this.getClient$okhttp())) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("client streams shouldn't have associated stream IDs".toString());
                throw (Throwable)illegalArgumentException;
            }
            this.getWriter().pushPromise(n, n2, (List)object);
        }
        Unit unit2 = Unit.INSTANCE;
        // MONITOREXIT : http2Writer
        if (!bl3) return http2Stream;
        this.writer.flush();
        return http2Stream;
    }

    public static /* synthetic */ void start$default(Http2Connection http2Connection, boolean bl, TaskRunner taskRunner, int n, Object object) throws IOException {
        if ((n & 1) != 0) {
            bl = true;
        }
        if ((n & 2) != 0) {
            taskRunner = TaskRunner.INSTANCE;
        }
        http2Connection.start(bl, taskRunner);
    }

    public final void awaitPong() throws InterruptedException {
        synchronized (this) {
            try {
                while (this.awaitPongsReceived < this.awaitPingsSent) {
                    ((Object)this).wait();
                }
                return;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    @Override
    public void close() {
        this.close$okhttp(ErrorCode.NO_ERROR, ErrorCode.CANCEL, null);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public final void close$okhttp(ErrorCode var1_1, ErrorCode var2_6, IOException var3_7) {
        Intrinsics.checkNotNullParameter((Object)var1_1, (String)"connectionCode");
        Intrinsics.checkNotNullParameter((Object)var2_6, (String)"streamCode");
        if (Util.assertionsEnabled && Thread.holdsLock(this)) {
            var1_1 = new StringBuilder();
            var1_1.append("Thread ");
            var1_1.append((Object)Thread.currentThread().getName());
            var1_1.append(" MUST NOT hold lock on ");
            var1_1.append(this);
            throw new AssertionError((Object)var1_1.toString());
        }
        try {
            this.shutdown((ErrorCode)var1_1);
lbl16:
            // 2 sources

            while (true) {
                var1_1 = null;
                break;
            }
        }
        catch (IOException var1_3) {
            ** continue;
        }
        synchronized (this) {
            var6_8 = this.getStreams$okhttp().isEmpty();
            var4_9 = 0;
            if (var6_8 ^ true) {
            }
            ** GOTO lbl35
            {
                var1_1 = this.getStreams$okhttp().values().toArray(new Http2Stream[0]);
                if (var1_1 == null) {
                    var1_1 = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    throw var1_1;
                }
                this.getStreams$okhttp().clear();
lbl35:
                // 2 sources

                var7_10 /* !! */  = Unit.INSTANCE;
            }
        }
        var1_1 = (Http2Stream[])var1_1;
        if (var1_1 != null) {
            var5_12 = ((Object)var1_1).length;
            block13: while (var4_9 < var5_12) {
                var7_10 /* !! */  = var1_1[var4_9];
                try {
                    var7_10 /* !! */ .close(var2_6, var3_7);
lbl43:
                    // 2 sources

                    while (true) {
                        ++var4_9;
                        continue block13;
                        break;
                    }
                }
                catch (IOException var7_11) {
                    ** continue;
                }
            }
        }
        try {
            this.getWriter().close();
        }
        catch (IOException var1_4) {
            ** continue;
        }
lbl50:
        // 2 sources

        while (true) {
            this.getSocket$okhttp().close();
lbl53:
            // 2 sources

            while (true) {
                this.writerQueue.shutdown();
                this.pushQueue.shutdown();
                this.settingsListenerQueue.shutdown();
                return;
            }
            break;
        }
        catch (IOException var1_5) {
            ** continue;
        }
    }

    public final void flush() throws IOException {
        this.writer.flush();
    }

    public final boolean getClient$okhttp() {
        return this.client;
    }

    public final String getConnectionName$okhttp() {
        return this.connectionName;
    }

    public final int getLastGoodStreamId$okhttp() {
        return this.lastGoodStreamId;
    }

    public final Listener getListener$okhttp() {
        return this.listener;
    }

    public final int getNextStreamId$okhttp() {
        return this.nextStreamId;
    }

    public final Settings getOkHttpSettings() {
        return this.okHttpSettings;
    }

    public final Settings getPeerSettings() {
        return this.peerSettings;
    }

    public final long getReadBytesAcknowledged() {
        return this.readBytesAcknowledged;
    }

    public final long getReadBytesTotal() {
        return this.readBytesTotal;
    }

    public final ReaderRunnable getReaderRunnable() {
        return this.readerRunnable;
    }

    public final Socket getSocket$okhttp() {
        return this.socket;
    }

    public final Http2Stream getStream(int n) {
        synchronized (this) {
            Http2Stream http2Stream = this.streams.get(n);
            return http2Stream;
        }
    }

    public final Map<Integer, Http2Stream> getStreams$okhttp() {
        return this.streams;
    }

    public final long getWriteBytesMaximum() {
        return this.writeBytesMaximum;
    }

    public final long getWriteBytesTotal() {
        return this.writeBytesTotal;
    }

    public final Http2Writer getWriter() {
        return this.writer;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final boolean isHealthy(long l) {
        synchronized (this) {
            boolean bl = this.isShutdown;
            if (bl) {
                return false;
            }
            if (this.degradedPongsReceived >= this.degradedPingsSent) return true;
            long l2 = this.degradedPongDeadlineNs;
            if (l < l2) return true;
            return false;
        }
    }

    public final Http2Stream newStream(List<Header> list, boolean bl) throws IOException {
        Intrinsics.checkNotNullParameter(list, (String)"requestHeaders");
        return this.newStream(0, list, bl);
    }

    public final int openStreamCount() {
        synchronized (this) {
            int n = this.streams.size();
            return n;
        }
    }

    public final void pushDataLater$okhttp(int n, BufferedSource bufferedSource, int n2, boolean bl) throws IOException {
        Intrinsics.checkNotNullParameter((Object)bufferedSource, (String)"source");
        Buffer buffer = new Buffer();
        long l = n2;
        bufferedSource.require(l);
        bufferedSource.read(buffer, l);
        bufferedSource = this.pushQueue;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.connectionName);
        stringBuilder.append('[');
        stringBuilder.append(n);
        stringBuilder.append("] onData");
        TaskQueue.execute$default((TaskQueue)bufferedSource, (String)stringBuilder.toString(), (long)0L, (boolean)false, (Function0)((Function0)new /* Unavailable Anonymous Inner Class!! */), (int)6, null);
    }

    public final void pushHeadersLater$okhttp(int n, List<Header> list, boolean bl) {
        Intrinsics.checkNotNullParameter(list, (String)"requestHeaders");
        TaskQueue taskQueue = this.pushQueue;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.connectionName);
        stringBuilder.append('[');
        stringBuilder.append(n);
        stringBuilder.append("] onHeaders");
        TaskQueue.execute$default((TaskQueue)taskQueue, (String)stringBuilder.toString(), (long)0L, (boolean)false, (Function0)((Function0)new /* Unavailable Anonymous Inner Class!! */), (int)6, null);
    }

    public final void pushRequestLater$okhttp(int n, List<Header> list) {
        StringBuilder stringBuilder;
        TaskQueue taskQueue;
        Intrinsics.checkNotNullParameter(list, (String)"requestHeaders");
        synchronized (this) {
            if (this.currentPushRequests.contains(n)) {
                this.writeSynResetLater$okhttp(n, ErrorCode.PROTOCOL_ERROR);
                return;
            }
            this.currentPushRequests.add(n);
            // MONITOREXIT @DISABLED, blocks:[0, 1] lbl10 : MonitorExitStatement: MONITOREXIT : this
            taskQueue = this.pushQueue;
            stringBuilder = new StringBuilder();
            stringBuilder.append(this.connectionName);
        }
        stringBuilder.append('[');
        stringBuilder.append(n);
        stringBuilder.append("] onRequest");
        TaskQueue.execute$default((TaskQueue)taskQueue, (String)stringBuilder.toString(), (long)0L, (boolean)false, (Function0)((Function0)new /* Unavailable Anonymous Inner Class!! */), (int)6, null);
    }

    public final void pushResetLater$okhttp(int n, ErrorCode errorCode) {
        Intrinsics.checkNotNullParameter((Object)errorCode, (String)"errorCode");
        TaskQueue taskQueue = this.pushQueue;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.connectionName);
        stringBuilder.append('[');
        stringBuilder.append(n);
        stringBuilder.append("] onReset");
        TaskQueue.execute$default((TaskQueue)taskQueue, (String)stringBuilder.toString(), (long)0L, (boolean)false, (Function0)((Function0)new /* Unavailable Anonymous Inner Class!! */), (int)6, null);
    }

    public final Http2Stream pushStream(int n, List<Header> list, boolean bl) throws IOException {
        Intrinsics.checkNotNullParameter(list, (String)"requestHeaders");
        if (!(this.client ^ true)) throw (Throwable)new IllegalStateException("Client cannot push requests.".toString());
        return this.newStream(n, list, bl);
    }

    public final boolean pushedStream$okhttp(int n) {
        boolean bl = true;
        if (n != 0 && (n & 1) == 0) return bl;
        bl = false;
        return bl;
    }

    public final Http2Stream removeStream$okhttp(int n) {
        synchronized (this) {
            Http2Stream http2Stream = this.streams.remove(n);
            ((Object)this).notifyAll();
            return http2Stream;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void sendDegradedPingLater$okhttp() {
        synchronized (this) {
            long l = this.degradedPongsReceived;
            long l2 = this.degradedPingsSent++;
            if (l < l2) {
                return;
            }
            this.degradedPongDeadlineNs = System.nanoTime() + (long)1000000000;
            Unit unit = Unit.INSTANCE;
        }
        TaskQueue.execute$default((TaskQueue)this.writerQueue, (String)Intrinsics.stringPlus((String)this.connectionName, (Object)" ping"), (long)0L, (boolean)false, (Function0)((Function0)new /* Unavailable Anonymous Inner Class!! */), (int)6, null);
    }

    public final void setLastGoodStreamId$okhttp(int n) {
        this.lastGoodStreamId = n;
    }

    public final void setNextStreamId$okhttp(int n) {
        this.nextStreamId = n;
    }

    public final void setPeerSettings(Settings settings2) {
        Intrinsics.checkNotNullParameter((Object)settings2, (String)"<set-?>");
        this.peerSettings = settings2;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void setSettings(Settings settings2) throws IOException {
        Intrinsics.checkNotNullParameter((Object)settings2, (String)"settings");
        Http2Writer http2Writer = this.writer;
        synchronized (http2Writer) {
            synchronized (this) {
                if (!this.isShutdown) {
                    this.getOkHttpSettings().merge(settings2);
                    Unit unit = Unit.INSTANCE;
                    // MONITOREXIT @DISABLED, blocks:[4, 5, 6] lbl8 : MonitorExitStatement: MONITOREXIT : this
                    this.getWriter().settings(settings2);
                    settings2 = Unit.INSTANCE;
                    return;
                }
                settings2 = new ConnectionShutdownException();
                throw settings2;
            }
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void shutdown(ErrorCode errorCode) throws IOException {
        Intrinsics.checkNotNullParameter((Object)errorCode, (String)"statusCode");
        Http2Writer http2Writer = this.writer;
        synchronized (http2Writer) {
            Ref.IntRef intRef = new Ref.IntRef();
            synchronized (this) {
                boolean bl = this.isShutdown;
                if (bl) {
                    return;
                }
                this.isShutdown = true;
                intRef.element = this.getLastGoodStreamId$okhttp();
                Unit unit = Unit.INSTANCE;
            }
            this.getWriter().goAway(intRef.element, errorCode, Util.EMPTY_BYTE_ARRAY);
            errorCode = Unit.INSTANCE;
            return;
        }
    }

    public final void start() throws IOException {
        Http2Connection.start$default(this, false, null, 3, null);
    }

    public final void start(boolean bl) throws IOException {
        Http2Connection.start$default(this, bl, null, 2, null);
    }

    public final void start(boolean bl, TaskRunner taskRunner) throws IOException {
        Intrinsics.checkNotNullParameter((Object)taskRunner, (String)"taskRunner");
        if (bl) {
            this.writer.connectionPreface();
            this.writer.settings(this.okHttpSettings);
            int n = this.okHttpSettings.getInitialWindowSize();
            if (n != 65535) {
                this.writer.windowUpdate(0, (long)(n - 65535));
            }
        }
        TaskQueue.execute$default((TaskQueue)taskRunner.newQueue(), (String)this.connectionName, (long)0L, (boolean)false, (Function0)((Function0)this.readerRunnable), (int)6, null);
    }

    public final void updateConnectionFlowControl$okhttp(long l) {
        synchronized (this) {
            this.readBytesTotal = l = this.readBytesTotal + l;
            if ((l -= this.readBytesAcknowledged) < (long)(this.okHttpSettings.getInitialWindowSize() / 2)) return;
            this.writeWindowUpdateLater$okhttp(0, l);
            this.readBytesAcknowledged += l;
            return;
        }
    }

    /*
     * Exception decompiling
     */
    public final void writeData(int var1_1, boolean var2_2, Buffer var3_3, long var4_7) throws IOException {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 2[TRYBLOCK] [6 : 189->207)] java.lang.Throwable
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2283)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:415)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doClass(Driver.java:84)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:78)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompile(CFRDecompiler.java:91)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompileToZip(CFRDecompiler.java:122)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.decompileSaveAll(ResourceDecompiling.java:262)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.lambda$decompileSaveAll$0(ResourceDecompiling.java:127)
         *     at java.lang.Thread.run(Unknown Source)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public final void writeHeaders$okhttp(int n, boolean bl, List<Header> list) throws IOException {
        Intrinsics.checkNotNullParameter(list, (String)"alternating");
        this.writer.headers(bl, n, list);
    }

    public final void writePing() throws InterruptedException {
        synchronized (this) {
            ++this.awaitPingsSent;
            // MONITOREXIT @DISABLED, blocks:[0, 1] lbl4 : MonitorExitStatement: MONITOREXIT : this
            this.writePing(false, 3, 1330343787);
            return;
        }
    }

    public final void writePing(boolean bl, int n, int n2) {
        try {
            this.writer.ping(bl, n, n2);
        }
        catch (IOException iOException) {
            this.failConnection(iOException);
        }
    }

    public final void writePingAndAwaitPong() throws InterruptedException {
        this.writePing();
        this.awaitPong();
    }

    public final void writeSynReset$okhttp(int n, ErrorCode errorCode) throws IOException {
        Intrinsics.checkNotNullParameter((Object)errorCode, (String)"statusCode");
        this.writer.rstStream(n, errorCode);
    }

    public final void writeSynResetLater$okhttp(int n, ErrorCode errorCode) {
        Intrinsics.checkNotNullParameter((Object)errorCode, (String)"errorCode");
        TaskQueue taskQueue = this.writerQueue;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.connectionName);
        stringBuilder.append('[');
        stringBuilder.append(n);
        stringBuilder.append("] writeSynReset");
        TaskQueue.execute$default((TaskQueue)taskQueue, (String)stringBuilder.toString(), (long)0L, (boolean)false, (Function0)((Function0)new /* Unavailable Anonymous Inner Class!! */), (int)6, null);
    }

    public final void writeWindowUpdateLater$okhttp(int n, long l) {
        TaskQueue taskQueue = this.writerQueue;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.connectionName);
        stringBuilder.append('[');
        stringBuilder.append(n);
        stringBuilder.append("] windowUpdate");
        TaskQueue.execute$default((TaskQueue)taskQueue, (String)stringBuilder.toString(), (long)0L, (boolean)false, (Function0)((Function0)new /* Unavailable Anonymous Inner Class!! */), (int)6, null);
    }
}
