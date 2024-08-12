/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.ranges.IntRange
 *  kotlin.text.StringsKt
 *  okhttp3.Call
 *  okhttp3.Callback
 *  okhttp3.EventListener
 *  okhttp3.OkHttpClient
 *  okhttp3.Protocol
 *  okhttp3.Request
 *  okhttp3.Response
 *  okhttp3.WebSocket
 *  okhttp3.WebSocketListener
 *  okhttp3.internal.Util
 *  okhttp3.internal.concurrent.Task
 *  okhttp3.internal.concurrent.TaskQueue
 *  okhttp3.internal.concurrent.TaskRunner
 *  okhttp3.internal.connection.Exchange
 *  okhttp3.internal.connection.RealCall
 *  okhttp3.internal.ws.RealWebSocket$Close
 *  okhttp3.internal.ws.RealWebSocket$Companion
 *  okhttp3.internal.ws.RealWebSocket$Message
 *  okhttp3.internal.ws.RealWebSocket$Streams
 *  okhttp3.internal.ws.RealWebSocket$WriterTask
 *  okhttp3.internal.ws.RealWebSocket$initReaderAndWriter$1$1
 *  okhttp3.internal.ws.WebSocketExtensions
 *  okhttp3.internal.ws.WebSocketProtocol
 *  okhttp3.internal.ws.WebSocketReader
 *  okhttp3.internal.ws.WebSocketReader$FrameCallback
 *  okhttp3.internal.ws.WebSocketWriter
 *  okio.ByteString
 *  okio.ByteString$Companion
 */
package okhttp3.internal.ws;

import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.EventListener;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.ws.RealWebSocket;
import okhttp3.internal.ws.WebSocketExtensions;
import okhttp3.internal.ws.WebSocketProtocol;
import okhttp3.internal.ws.WebSocketReader;
import okhttp3.internal.ws.WebSocketWriter;
import okio.ByteString;

@Metadata(d1={"\u0000\u00b6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\u0018\u0000 `2\u00020\u00012\u00020\u0002:\u0005_`abcB?\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u000f\u001a\u00020\f\u00a2\u0006\u0002\u0010\u0010J\u0016\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\f2\u0006\u00105\u001a\u000206J\b\u00107\u001a\u000203H\u0016J\u001f\u00108\u001a\u0002032\u0006\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010<H\u0000\u00a2\u0006\u0002\b=J\u001a\u0010>\u001a\u00020\u00122\u0006\u0010?\u001a\u00020%2\b\u0010@\u001a\u0004\u0018\u00010\u0018H\u0016J \u0010>\u001a\u00020\u00122\u0006\u0010?\u001a\u00020%2\b\u0010@\u001a\u0004\u0018\u00010\u00182\u0006\u0010A\u001a\u00020\fJ\u000e\u0010B\u001a\u0002032\u0006\u0010C\u001a\u00020DJ\u001c\u0010E\u001a\u0002032\n\u0010F\u001a\u00060Gj\u0002`H2\b\u00109\u001a\u0004\u0018\u00010:J\u0016\u0010I\u001a\u0002032\u0006\u0010\u001e\u001a\u00020\u00182\u0006\u0010*\u001a\u00020+J\u0006\u0010J\u001a\u000203J\u0018\u0010K\u001a\u0002032\u0006\u0010?\u001a\u00020%2\u0006\u0010@\u001a\u00020\u0018H\u0016J\u0010\u0010L\u001a\u0002032\u0006\u0010M\u001a\u00020\u0018H\u0016J\u0010\u0010L\u001a\u0002032\u0006\u0010N\u001a\u00020 H\u0016J\u0010\u0010O\u001a\u0002032\u0006\u0010P\u001a\u00020 H\u0016J\u0010\u0010Q\u001a\u0002032\u0006\u0010P\u001a\u00020 H\u0016J\u000e\u0010R\u001a\u00020\u00122\u0006\u0010P\u001a\u00020 J\u0006\u0010S\u001a\u00020\u0012J\b\u0010!\u001a\u00020\fH\u0016J\u0006\u0010'\u001a\u00020%J\u0006\u0010(\u001a\u00020%J\b\u0010T\u001a\u00020\u0006H\u0016J\b\u0010U\u001a\u000203H\u0002J\u0010\u0010V\u001a\u00020\u00122\u0006\u0010M\u001a\u00020\u0018H\u0016J\u0010\u0010V\u001a\u00020\u00122\u0006\u0010N\u001a\u00020 H\u0016J\u0018\u0010V\u001a\u00020\u00122\u0006\u0010W\u001a\u00020 2\u0006\u0010X\u001a\u00020%H\u0002J\u0006\u0010)\u001a\u00020%J\u0006\u0010Y\u001a\u000203J\r\u0010Z\u001a\u00020\u0012H\u0000\u00a2\u0006\u0002\b[J\r\u0010\\\u001a\u000203H\u0000\u00a2\u0006\u0002\b]J\f\u0010^\u001a\u00020\u0012*\u00020\u000eH\u0002R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u001cX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020%X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020%X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020%X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006d"}, d2={"Lokhttp3/internal/ws/RealWebSocket;", "Lokhttp3/WebSocket;", "Lokhttp3/internal/ws/WebSocketReader$FrameCallback;", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "originalRequest", "Lokhttp3/Request;", "listener", "Lokhttp3/WebSocketListener;", "random", "Ljava/util/Random;", "pingIntervalMillis", "", "extensions", "Lokhttp3/internal/ws/WebSocketExtensions;", "minimumDeflateSize", "(Lokhttp3/internal/concurrent/TaskRunner;Lokhttp3/Request;Lokhttp3/WebSocketListener;Ljava/util/Random;JLokhttp3/internal/ws/WebSocketExtensions;J)V", "awaitingPong", "", "call", "Lokhttp3/Call;", "enqueuedClose", "failed", "key", "", "getListener$okhttp", "()Lokhttp3/WebSocketListener;", "messageAndCloseQueue", "Ljava/util/ArrayDeque;", "", "name", "pongQueue", "Lokio/ByteString;", "queueSize", "reader", "Lokhttp3/internal/ws/WebSocketReader;", "receivedCloseCode", "", "receivedCloseReason", "receivedPingCount", "receivedPongCount", "sentPingCount", "streams", "Lokhttp3/internal/ws/RealWebSocket$Streams;", "taskQueue", "Lokhttp3/internal/concurrent/TaskQueue;", "writer", "Lokhttp3/internal/ws/WebSocketWriter;", "writerTask", "Lokhttp3/internal/concurrent/Task;", "awaitTermination", "", "timeout", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "cancel", "checkUpgradeSuccess", "response", "Lokhttp3/Response;", "exchange", "Lokhttp3/internal/connection/Exchange;", "checkUpgradeSuccess$okhttp", "close", "code", "reason", "cancelAfterCloseMillis", "connect", "client", "Lokhttp3/OkHttpClient;", "failWebSocket", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "initReaderAndWriter", "loopReader", "onReadClose", "onReadMessage", "text", "bytes", "onReadPing", "payload", "onReadPong", "pong", "processNextFrame", "request", "runWriter", "send", "data", "formatOpcode", "tearDown", "writeOneFrame", "writeOneFrame$okhttp", "writePingFrame", "writePingFrame$okhttp", "isValid", "Close", "Companion", "Message", "Streams", "WriterTask", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class RealWebSocket
implements WebSocket,
WebSocketReader.FrameCallback {
    private static final long CANCEL_AFTER_CLOSE_MILLIS = 60000L;
    public static final Companion Companion = new Companion(null);
    public static final long DEFAULT_MINIMUM_DEFLATE_SIZE = 1024L;
    private static final long MAX_QUEUE_SIZE = 0x1000000L;
    private static final List<Protocol> ONLY_HTTP1 = CollectionsKt.listOf((Object)Protocol.HTTP_1_1);
    private boolean awaitingPong;
    private Call call;
    private boolean enqueuedClose;
    private WebSocketExtensions extensions;
    private boolean failed;
    private final String key;
    private final WebSocketListener listener;
    private final ArrayDeque<Object> messageAndCloseQueue;
    private long minimumDeflateSize;
    private String name;
    private final Request originalRequest;
    private final long pingIntervalMillis;
    private final ArrayDeque<ByteString> pongQueue;
    private long queueSize;
    private final Random random;
    private WebSocketReader reader;
    private int receivedCloseCode;
    private String receivedCloseReason;
    private int receivedPingCount;
    private int receivedPongCount;
    private int sentPingCount;
    private Streams streams;
    private TaskQueue taskQueue;
    private WebSocketWriter writer;
    private Task writerTask;

    public RealWebSocket(TaskRunner object, Request request, WebSocketListener webSocketListener, Random random, long l, WebSocketExtensions webSocketExtensions, long l2) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"taskRunner");
        Intrinsics.checkNotNullParameter((Object)request, (String)"originalRequest");
        Intrinsics.checkNotNullParameter((Object)webSocketListener, (String)"listener");
        Intrinsics.checkNotNullParameter((Object)random, (String)"random");
        this.originalRequest = request;
        this.listener = webSocketListener;
        this.random = random;
        this.pingIntervalMillis = l;
        this.extensions = webSocketExtensions;
        this.minimumDeflateSize = l2;
        this.taskQueue = object.newQueue();
        this.pongQueue = new ArrayDeque();
        this.messageAndCloseQueue = new ArrayDeque();
        this.receivedCloseCode = -1;
        if (!Intrinsics.areEqual((Object)"GET", (Object)this.originalRequest.method())) throw (Throwable)new IllegalArgumentException(Intrinsics.stringPlus((String)"Request must be GET: ", (Object)this.originalRequest.method()).toString());
        webSocketListener = ByteString.Companion;
        object = new byte[16];
        this.random.nextBytes((byte[])object);
        request = Unit.INSTANCE;
        this.key = ByteString.Companion.of$default((ByteString.Companion)webSocketListener, (byte[])object, (int)0, (int)0, (int)3, null).base64();
    }

    public static final /* synthetic */ ArrayDeque access$getMessageAndCloseQueue$p(RealWebSocket realWebSocket) {
        return realWebSocket.messageAndCloseQueue;
    }

    public static final /* synthetic */ String access$getName$p(RealWebSocket realWebSocket) {
        return realWebSocket.name;
    }

    public static final /* synthetic */ boolean access$isValid(RealWebSocket realWebSocket, WebSocketExtensions webSocketExtensions) {
        return realWebSocket.isValid(webSocketExtensions);
    }

    public static final /* synthetic */ void access$setExtensions$p(RealWebSocket realWebSocket, WebSocketExtensions webSocketExtensions) {
        realWebSocket.extensions = webSocketExtensions;
    }

    private final boolean isValid(WebSocketExtensions webSocketExtensions) {
        if (webSocketExtensions.unknownValues) {
            return false;
        }
        if (webSocketExtensions.clientMaxWindowBits != null) {
            return false;
        }
        if (webSocketExtensions.serverMaxWindowBits == null) return true;
        if (new IntRange(8, 15).contains(webSocketExtensions.serverMaxWindowBits.intValue())) return true;
        return false;
    }

    private final void runWriter() {
        if (Util.assertionsEnabled && !Thread.holdsLock(this)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Thread ");
            stringBuilder.append((Object)Thread.currentThread().getName());
            stringBuilder.append(" MUST hold lock on ");
            stringBuilder.append(this);
            throw new AssertionError((Object)stringBuilder.toString());
        }
        Task task = this.writerTask;
        if (task == null) return;
        TaskQueue.schedule$default((TaskQueue)this.taskQueue, (Task)task, (long)0L, (int)2, null);
    }

    private final boolean send(ByteString byteString, int n) {
        synchronized (this) {
            if (this.failed) return false;
            if (this.enqueuedClose) {
                return false;
            }
            if (this.queueSize + (long)byteString.size() > 0x1000000L) {
                this.close(1001, null);
                return false;
            }
            this.queueSize += (long)byteString.size();
            ArrayDeque<Object> arrayDeque = this.messageAndCloseQueue;
            Message message = new Message(n, byteString);
            arrayDeque.add(message);
            this.runWriter();
            return true;
        }
    }

    public final void awaitTermination(long l, TimeUnit timeUnit) throws InterruptedException {
        Intrinsics.checkNotNullParameter((Object)((Object)timeUnit), (String)"timeUnit");
        this.taskQueue.idleLatch().await(l, timeUnit);
    }

    public void cancel() {
        Call call = this.call;
        Intrinsics.checkNotNull((Object)call);
        call.cancel();
    }

    public final void checkUpgradeSuccess$okhttp(Response object, Exchange object2) throws IOException {
        Intrinsics.checkNotNullParameter((Object)object, (String)"response");
        if (object.code() != 101) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Expected HTTP 101 response but was '");
            ((StringBuilder)object2).append(object.code());
            ((StringBuilder)object2).append(' ');
            ((StringBuilder)object2).append(object.message());
            ((StringBuilder)object2).append('\'');
            throw new ProtocolException(((StringBuilder)object2).toString());
        }
        String string = Response.header$default((Response)object, (String)"Connection", null, (int)2, null);
        if (!StringsKt.equals((String)"Upgrade", (String)string, (boolean)true)) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Expected 'Connection' header value 'Upgrade' but was '");
            ((StringBuilder)object).append((Object)string);
            ((StringBuilder)object).append('\'');
            throw new ProtocolException(((StringBuilder)object).toString());
        }
        string = Response.header$default((Response)object, (String)"Upgrade", null, (int)2, null);
        if (!StringsKt.equals((String)"websocket", (String)string, (boolean)true)) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Expected 'Upgrade' header value 'websocket' but was '");
            ((StringBuilder)object).append((Object)string);
            ((StringBuilder)object).append('\'');
            throw new ProtocolException(((StringBuilder)object).toString());
        }
        object = Response.header$default((Response)object, (String)"Sec-WebSocket-Accept", null, (int)2, null);
        string = ByteString.Companion.encodeUtf8(Intrinsics.stringPlus((String)this.key, (Object)"258EAFA5-E914-47DA-95CA-C5AB0DC85B11")).sha1().base64();
        if (Intrinsics.areEqual((Object)string, (Object)object)) {
            if (object2 == null) throw new ProtocolException("Web Socket exchange missing: bad interceptor?");
            return;
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Expected 'Sec-WebSocket-Accept' header value '");
        ((StringBuilder)object2).append(string);
        ((StringBuilder)object2).append("' but was '");
        ((StringBuilder)object2).append(object);
        ((StringBuilder)object2).append('\'');
        throw new ProtocolException(((StringBuilder)object2).toString());
    }

    public boolean close(int n, String string) {
        return this.close(n, string, 60000L);
    }

    public final boolean close(int n, String object, long l) {
        synchronized (this) {
            boolean bl;
            WebSocketProtocol.INSTANCE.validateCloseCode(n);
            Object object2 = null;
            if (object != null && !(bl = (long)(object2 = ByteString.Companion.encodeUtf8((String)object)).size() <= 123L)) {
                object2 = Intrinsics.stringPlus((String)"reason.size() > 123: ", (Object)object);
                object = new IllegalArgumentException(object2.toString());
                throw (Throwable)object;
            }
            if (this.failed) return false;
            if (this.enqueuedClose) {
                return false;
            }
            this.enqueuedClose = true;
            ArrayDeque<Object> arrayDeque = this.messageAndCloseQueue;
            object = new Close(n, (ByteString)object2, l);
            arrayDeque.add(object);
            this.runWriter();
            return true;
        }
    }

    public final void connect(OkHttpClient okHttpClient) {
        Intrinsics.checkNotNullParameter((Object)okHttpClient, (String)"client");
        if (this.originalRequest.header("Sec-WebSocket-Extensions") != null) {
            this.failWebSocket(new ProtocolException("Request header not permitted: 'Sec-WebSocket-Extensions'"), null);
            return;
        }
        OkHttpClient okHttpClient2 = okHttpClient.newBuilder().eventListener(EventListener.NONE).protocols(ONLY_HTTP1).build();
        okHttpClient = this.originalRequest.newBuilder().header("Upgrade", "websocket").header("Connection", "Upgrade").header("Sec-WebSocket-Key", this.key).header("Sec-WebSocket-Version", "13").header("Sec-WebSocket-Extensions", "permessage-deflate").build();
        okHttpClient2 = (Call)new RealCall(okHttpClient2, (Request)okHttpClient, true);
        this.call = okHttpClient2;
        Intrinsics.checkNotNull((Object)okHttpClient2);
        okHttpClient2.enqueue((Callback)new /* Unavailable Anonymous Inner Class!! */);
    }

    /*
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    public final void failWebSocket(Exception exception, Response response) {
        WebSocketWriter webSocketWriter;
        WebSocketReader webSocketReader;
        Streams streams;
        Intrinsics.checkNotNullParameter((Object)exception, (String)"e");
        synchronized (this) {
            boolean bl = this.failed;
            if (bl) {
                return;
            }
            this.failed = true;
            streams = this.streams;
            this.streams = null;
            webSocketReader = this.reader;
            this.reader = null;
            webSocketWriter = this.writer;
            this.writer = null;
            this.taskQueue.shutdown();
            Unit unit = Unit.INSTANCE;
        }
        try {
            void var2_3;
            this.listener.onFailure((WebSocket)this, (Throwable)exception, (Response)var2_3);
            return;
        }
        finally {
            if (streams != null) {
                Util.closeQuietly((Closeable)((Closeable)streams));
            }
            if (webSocketReader != null) {
                Util.closeQuietly((Closeable)((Closeable)webSocketReader));
            }
            if (webSocketWriter != null) {
                Util.closeQuietly((Closeable)((Closeable)webSocketWriter));
            }
        }
    }

    public final WebSocketListener getListener$okhttp() {
        return this.listener;
    }

    public final void initReaderAndWriter(String string, Streams streams) throws IOException {
        Intrinsics.checkNotNullParameter((Object)string, (String)"name");
        Intrinsics.checkNotNullParameter((Object)streams, (String)"streams");
        WebSocketExtensions webSocketExtensions = this.extensions;
        Intrinsics.checkNotNull((Object)webSocketExtensions);
        synchronized (this) {
            WebSocketWriter webSocketWriter;
            this.name = string;
            this.streams = streams;
            this.writer = webSocketWriter = new WebSocketWriter(streams.getClient(), streams.getSink(), this.random, webSocketExtensions.perMessageDeflate, webSocketExtensions.noContextTakeover(streams.getClient()), this.minimumDeflateSize);
            webSocketWriter = new WriterTask(this);
            this.writerTask = (Task)webSocketWriter;
            if (this.pingIntervalMillis != 0L) {
                long l = TimeUnit.MILLISECONDS.toNanos(this.pingIntervalMillis);
                webSocketWriter = this.taskQueue;
                string = Intrinsics.stringPlus((String)string, (Object)" ping");
                initReaderAndWriter.1.1 var7_7 = new /* Unavailable Anonymous Inner Class!! */;
                webSocketWriter.schedule(string, l, (Function0)var7_7);
            }
            if (((Collection)this.messageAndCloseQueue).isEmpty() ^ true) {
                this.runWriter();
            }
            string = Unit.INSTANCE;
        }
        this.reader = new WebSocketReader(streams.getClient(), streams.getSource(), (WebSocketReader.FrameCallback)this, webSocketExtensions.perMessageDeflate, webSocketExtensions.noContextTakeover(streams.getClient() ^ true));
    }

    public final void loopReader() throws IOException {
        while (this.receivedCloseCode == -1) {
            WebSocketReader webSocketReader = this.reader;
            Intrinsics.checkNotNull((Object)webSocketReader);
            webSocketReader.processNextFrame();
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void onReadClose(int n, String object) {
        WebSocketWriter webSocketWriter;
        WebSocketReader webSocketReader;
        Streams streams;
        Intrinsics.checkNotNullParameter((Object)object, (String)"reason");
        boolean bl = true;
        boolean bl2 = n != -1;
        if (!bl2) throw (Throwable)new IllegalArgumentException("Failed requirement.".toString());
        synchronized (this) {
            bl2 = this.receivedCloseCode == -1 ? bl : false;
            if (!bl2) {
                object = new IllegalStateException("already closed".toString());
                throw (Throwable)object;
            }
            this.receivedCloseCode = n;
            this.receivedCloseReason = object;
            boolean bl3 = this.enqueuedClose;
            streams = null;
            if (bl3 && this.messageAndCloseQueue.isEmpty()) {
                streams = this.streams;
                this.streams = null;
                webSocketReader = this.reader;
                this.reader = null;
                webSocketWriter = this.writer;
                this.writer = null;
                this.taskQueue.shutdown();
            } else {
                webSocketReader = null;
                webSocketWriter = null;
            }
            Unit unit = Unit.INSTANCE;
        }
        try {
            this.listener.onClosing((WebSocket)this, n, (String)object);
            if (streams == null) return;
            this.listener.onClosed((WebSocket)this, n, (String)object);
            return;
        }
        finally {
            if (streams != null) {
                Util.closeQuietly((Closeable)((Closeable)streams));
            }
            if (webSocketReader != null) {
                Util.closeQuietly((Closeable)((Closeable)webSocketReader));
            }
            if (webSocketWriter != null) {
                Util.closeQuietly((Closeable)((Closeable)webSocketWriter));
            }
        }
    }

    public void onReadMessage(String string) throws IOException {
        Intrinsics.checkNotNullParameter((Object)string, (String)"text");
        this.listener.onMessage((WebSocket)this, string);
    }

    public void onReadMessage(ByteString byteString) throws IOException {
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"bytes");
        this.listener.onMessage((WebSocket)this, byteString);
    }

    public void onReadPing(ByteString byteString) {
        synchronized (this) {
            Intrinsics.checkNotNullParameter((Object)byteString, (String)"payload");
            if (this.failed) return;
            if (this.enqueuedClose && this.messageAndCloseQueue.isEmpty()) {
                return;
            }
            this.pongQueue.add(byteString);
            this.runWriter();
            ++this.receivedPingCount;
            return;
        }
    }

    public void onReadPong(ByteString byteString) {
        synchronized (this) {
            Intrinsics.checkNotNullParameter((Object)byteString, (String)"payload");
            ++this.receivedPongCount;
            this.awaitingPong = false;
            return;
        }
    }

    public final boolean pong(ByteString byteString) {
        synchronized (this) {
            Intrinsics.checkNotNullParameter((Object)byteString, (String)"payload");
            if (this.failed) return false;
            if (this.enqueuedClose && this.messageAndCloseQueue.isEmpty()) {
                return false;
            }
            this.pongQueue.add(byteString);
            this.runWriter();
            return true;
        }
    }

    public final boolean processNextFrame() throws IOException {
        boolean bl = false;
        try {
            WebSocketReader webSocketReader = this.reader;
            Intrinsics.checkNotNull((Object)webSocketReader);
            webSocketReader.processNextFrame();
            int n = this.receivedCloseCode;
            if (n != -1) return bl;
            bl = true;
        }
        catch (Exception exception) {
            this.failWebSocket(exception, null);
        }
        return bl;
    }

    public long queueSize() {
        synchronized (this) {
            long l = this.queueSize;
            return l;
        }
    }

    public final int receivedPingCount() {
        synchronized (this) {
            int n = this.receivedPingCount;
            return n;
        }
    }

    public final int receivedPongCount() {
        synchronized (this) {
            int n = this.receivedPongCount;
            return n;
        }
    }

    public Request request() {
        return this.originalRequest;
    }

    public boolean send(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"text");
        return this.send(ByteString.Companion.encodeUtf8(string), 1);
    }

    public boolean send(ByteString byteString) {
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"bytes");
        return this.send(byteString, 2);
    }

    public final int sentPingCount() {
        synchronized (this) {
            int n = this.sentPingCount;
            return n;
        }
    }

    public final void tearDown() throws InterruptedException {
        this.taskQueue.shutdown();
        this.taskQueue.idleLatch().await(10L, TimeUnit.SECONDS);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     */
    public final boolean writeOneFrame$okhttp() throws IOException {
        block29: {
            block25: {
                block26: {
                    synchronized (this) {
                        block22: {
                            block23: {
                                block24: {
                                    var4_1 = this.failed;
                                    if (var4_1) {
                                    }
                                    ** GOTO lbl-1000
                                    return false;
lbl-1000:
                                    // 1 sources

                                    {
                                        block27: {
                                            block28: {
                                                var11_2 = this.writer;
                                                var12_3 = this.pongQueue.poll();
                                                var1_4 = -1;
                                                var9_5 = null;
                                                if (var12_3 != null) break block22;
                                                var5_6 = this.messageAndCloseQueue.poll();
                                                if (!(var5_6 instanceof Close)) break block27;
                                                var1_4 = this.receivedCloseCode;
                                                var8_8 = this.receivedCloseReason;
                                                if (var1_4 == -1) break block28;
                                                var10_11 = this.streams;
                                                this.streams = null;
                                                var6_12 = this.reader;
                                                this.reader = null;
                                                var7_13 = this.writer;
                                                this.writer = null;
                                                this.taskQueue.shutdown();
                                                var9_5 = var5_6;
                                                var5_6 = var10_11;
                                                ** GOTO lbl-1000
                                            }
                                            var2_14 = ((Close)var5_6).getCancelAfterCloseMillis();
                                            var7_13 = this.taskQueue;
                                            var6_12 = Intrinsics.stringPlus((String)this.name, (Object)" cancel");
                                            var2_14 = TimeUnit.MILLISECONDS.toNanos(var2_14);
                                            var9_5 = new /* Unavailable Anonymous Inner Class!! */;
                                            TaskQueue.execute$default((TaskQueue)var7_13, (String)var6_12, (long)var2_14, (boolean)false, (Function0)((Function0)var9_5), (int)4, null);
                                            break block23;
                                        }
                                        if (var5_6 != null) break block24;
                                    }
                                    return false;
                                }
                                var8_8 = null;
                            }
                            var6_12 = null;
                            var10_11 = null;
                            var7_13 = null;
                            var9_5 = var5_6;
                            var5_6 = var10_11;
                            ** GOTO lbl-1000
                        }
                        var5_6 = null;
                        var8_8 = null;
                        var7_13 = var6_12 = var8_8;
lbl-1000:
                        // 3 sources

                        {
                            var10_11 = Unit.INSTANCE;
                            // MONITOREXIT @DISABLED, blocks:[2, 7] lbl53 : MonitorExitStatement: MONITOREXIT : this
                            if (var12_3 == null) ** GOTO lbl61
                        }
                    }
                    Intrinsics.checkNotNull((Object)var11_2);
                    var11_2.writePong(var12_3);
                    break block25;
lbl61:
                    // 1 sources

                    if (!(var9_5 instanceof Message)) break block26;
                    var8_8 = (Message)var9_5;
                    Intrinsics.checkNotNull((Object)var11_2);
                    var11_2.writeMessageFrame(var8_8.getFormatOpcode(), var8_8.getData());
                    synchronized (this) {
                    }
                    {
                        catch (Throwable var8_10) {
                            throw var8_10;
                        }
                        {
                            try {
                                this.queueSize -= (long)var8_8.getData().size();
                                var8_8 = Unit.INSTANCE;
                                break block25;
                            }
                            catch (Throwable var8_9) {}
                            ** try [egrp 5[TRYBLOCK] [10 : 334->406)] { 
lbl75:
                            // 1 sources

                            throw var8_9;
lbl76:
                            // 1 sources

                            finally {
                                if (var5_6 != null) {
                                    Util.closeQuietly((Closeable)((Closeable)var5_6));
                                }
                                if (var6_12 != null) {
                                    Util.closeQuietly((Closeable)((Closeable)var6_12));
                                }
                                if (var7_13 != null) {
                                    Util.closeQuietly((Closeable)((Closeable)var7_13));
                                }
                            }
                        }
                    }
                }
                if (!(var9_5 instanceof Close)) break block29;
                var9_5 = (Close)var9_5;
                Intrinsics.checkNotNull((Object)var11_2);
                var11_2.writeClose(var9_5.getCode(), var9_5.getReason());
                if (var5_6 == null) return true;
                var9_5 = this.listener;
                var10_11 = this;
                Intrinsics.checkNotNull((Object)var8_8);
                var9_5.onClosed((WebSocket)var10_11, var1_4, (String)var8_8);
            }
            return true;
        }
        var8_8 = new AssertionError();
        throw var8_8;
    }

    /*
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    public final void writePingFrame$okhttp() {
        // MONITORENTER : this
        boolean bl = this.failed;
        if (bl) {
            // MONITOREXIT : this
            return;
        }
        Object object = this.writer;
        if (object == null) {
            // MONITOREXIT : this
            return;
        }
        int n = this.awaitingPong ? this.sentPingCount : -1;
        ++this.sentPingCount;
        this.awaitingPong = true;
        Unit unit = Unit.INSTANCE;
        // MONITOREXIT : this
        if (n != -1) {
            object = new StringBuilder();
            ((StringBuilder)object).append("sent ping but didn't receive pong within ");
            ((StringBuilder)object).append(this.pingIntervalMillis);
            ((StringBuilder)object).append("ms (after ");
            ((StringBuilder)object).append(n - 1);
            ((StringBuilder)object).append(" successful ping/pongs)");
            this.failWebSocket(new SocketTimeoutException(((StringBuilder)object).toString()), null);
            return;
        }
        try {
            object.writePing(ByteString.EMPTY);
            return;
        }
        catch (IOException iOException) {
            this.failWebSocket(iOException, null);
        }
    }
}
