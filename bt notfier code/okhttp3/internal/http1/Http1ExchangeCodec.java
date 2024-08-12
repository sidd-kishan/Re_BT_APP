/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 *  okhttp3.Headers
 *  okhttp3.HttpUrl
 *  okhttp3.OkHttpClient
 *  okhttp3.Request
 *  okhttp3.Response
 *  okhttp3.Response$Builder
 *  okhttp3.internal.Util
 *  okhttp3.internal.connection.RealConnection
 *  okhttp3.internal.http.ExchangeCodec
 *  okhttp3.internal.http.HttpHeaders
 *  okhttp3.internal.http.RequestLine
 *  okhttp3.internal.http.StatusLine
 *  okhttp3.internal.http1.HeadersReader
 *  okhttp3.internal.http1.Http1ExchangeCodec$ChunkedSink
 *  okhttp3.internal.http1.Http1ExchangeCodec$ChunkedSource
 *  okhttp3.internal.http1.Http1ExchangeCodec$Companion
 *  okhttp3.internal.http1.Http1ExchangeCodec$FixedLengthSource
 *  okhttp3.internal.http1.Http1ExchangeCodec$KnownLengthSink
 *  okhttp3.internal.http1.Http1ExchangeCodec$UnknownLengthSource
 *  okio.BufferedSink
 *  okio.BufferedSource
 *  okio.ForwardingTimeout
 *  okio.Sink
 *  okio.Source
 *  okio.Timeout
 */
package okhttp3.internal.http1;

import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.http1.HeadersReader;
import okhttp3.internal.http1.Http1ExchangeCodec;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ForwardingTimeout;
import okio.Sink;
import okio.Source;
import okio.Timeout;

@Metadata(d1={"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 ?2\u00020\u0001:\u0007<=>?@ABB'\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020\u001cH\u0016J\b\u0010&\u001a\u00020\u001cH\u0016J\b\u0010'\u001a\u00020\u001eH\u0002J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0002J\u0010\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020!H\u0002J\b\u0010.\u001a\u00020\u001eH\u0002J\b\u0010/\u001a\u00020)H\u0002J\u0010\u00100\u001a\u00020)2\u0006\u00101\u001a\u00020\u0019H\u0016J\u0012\u00102\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u00020\u0010H\u0016J\u0010\u00105\u001a\u00020!2\u0006\u00101\u001a\u00020\u0019H\u0016J\u000e\u00106\u001a\u00020\u001c2\u0006\u00101\u001a\u00020\u0019J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0016\u00107\u001a\u00020\u001c2\u0006\u00108\u001a\u00020\u00152\u0006\u00109\u001a\u00020:J\u0010\u0010;\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u0017H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u00108F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0011R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u0016\u001a\u00020\u0010*\u00020\u00178BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0018R\u0018\u0010\u0016\u001a\u00020\u0010*\u00020\u00198BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u001a\u00a8\u0006C"}, d2={"Lokhttp3/internal/http1/Http1ExchangeCodec;", "Lokhttp3/internal/http/ExchangeCodec;", "client", "Lokhttp3/OkHttpClient;", "connection", "Lokhttp3/internal/connection/RealConnection;", "source", "Lokio/BufferedSource;", "sink", "Lokio/BufferedSink;", "(Lokhttp3/OkHttpClient;Lokhttp3/internal/connection/RealConnection;Lokio/BufferedSource;Lokio/BufferedSink;)V", "getConnection", "()Lokhttp3/internal/connection/RealConnection;", "headersReader", "Lokhttp3/internal/http1/HeadersReader;", "isClosed", "", "()Z", "state", "", "trailers", "Lokhttp3/Headers;", "isChunked", "Lokhttp3/Request;", "(Lokhttp3/Request;)Z", "Lokhttp3/Response;", "(Lokhttp3/Response;)Z", "cancel", "", "createRequestBody", "Lokio/Sink;", "request", "contentLength", "", "detachTimeout", "timeout", "Lokio/ForwardingTimeout;", "finishRequest", "flushRequest", "newChunkedSink", "newChunkedSource", "Lokio/Source;", "url", "Lokhttp3/HttpUrl;", "newFixedLengthSource", "length", "newKnownLengthSink", "newUnknownLengthSource", "openResponseBodySource", "response", "readResponseHeaders", "Lokhttp3/Response$Builder;", "expectContinue", "reportedContentLength", "skipConnectBody", "writeRequest", "headers", "requestLine", "", "writeRequestHeaders", "AbstractSource", "ChunkedSink", "ChunkedSource", "Companion", "FixedLengthSource", "KnownLengthSink", "UnknownLengthSource", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class Http1ExchangeCodec
implements ExchangeCodec {
    public static final Companion Companion = new Companion(null);
    private static final long NO_CHUNK_YET = -1L;
    private static final int STATE_CLOSED = 6;
    private static final int STATE_IDLE = 0;
    private static final int STATE_OPEN_REQUEST_BODY = 1;
    private static final int STATE_OPEN_RESPONSE_BODY = 4;
    private static final int STATE_READING_RESPONSE_BODY = 5;
    private static final int STATE_READ_RESPONSE_HEADERS = 3;
    private static final int STATE_WRITING_REQUEST_BODY = 2;
    private final OkHttpClient client;
    private final RealConnection connection;
    private final HeadersReader headersReader;
    private final BufferedSink sink;
    private final BufferedSource source;
    private int state;
    private Headers trailers;

    public Http1ExchangeCodec(OkHttpClient okHttpClient, RealConnection realConnection, BufferedSource bufferedSource, BufferedSink bufferedSink) {
        Intrinsics.checkNotNullParameter((Object)realConnection, (String)"connection");
        Intrinsics.checkNotNullParameter((Object)bufferedSource, (String)"source");
        Intrinsics.checkNotNullParameter((Object)bufferedSink, (String)"sink");
        this.client = okHttpClient;
        this.connection = realConnection;
        this.source = bufferedSource;
        this.sink = bufferedSink;
        this.headersReader = new HeadersReader(this.source);
    }

    public static final /* synthetic */ void access$detachTimeout(Http1ExchangeCodec http1ExchangeCodec, ForwardingTimeout forwardingTimeout) {
        http1ExchangeCodec.detachTimeout(forwardingTimeout);
    }

    public static final /* synthetic */ OkHttpClient access$getClient$p(Http1ExchangeCodec http1ExchangeCodec) {
        return http1ExchangeCodec.client;
    }

    public static final /* synthetic */ HeadersReader access$getHeadersReader$p(Http1ExchangeCodec http1ExchangeCodec) {
        return http1ExchangeCodec.headersReader;
    }

    public static final /* synthetic */ BufferedSink access$getSink$p(Http1ExchangeCodec http1ExchangeCodec) {
        return http1ExchangeCodec.sink;
    }

    public static final /* synthetic */ BufferedSource access$getSource$p(Http1ExchangeCodec http1ExchangeCodec) {
        return http1ExchangeCodec.source;
    }

    public static final /* synthetic */ int access$getState$p(Http1ExchangeCodec http1ExchangeCodec) {
        return http1ExchangeCodec.state;
    }

    public static final /* synthetic */ Headers access$getTrailers$p(Http1ExchangeCodec http1ExchangeCodec) {
        return http1ExchangeCodec.trailers;
    }

    public static final /* synthetic */ void access$setState$p(Http1ExchangeCodec http1ExchangeCodec, int n) {
        http1ExchangeCodec.state = n;
    }

    public static final /* synthetic */ void access$setTrailers$p(Http1ExchangeCodec http1ExchangeCodec, Headers headers) {
        http1ExchangeCodec.trailers = headers;
    }

    private final void detachTimeout(ForwardingTimeout forwardingTimeout) {
        Timeout timeout = forwardingTimeout.delegate();
        forwardingTimeout.setDelegate(Timeout.NONE);
        timeout.clearDeadline();
        timeout.clearTimeout();
    }

    private final boolean isChunked(Request request) {
        return StringsKt.equals((String)"chunked", (String)request.header("Transfer-Encoding"), (boolean)true);
    }

    private final boolean isChunked(Response response) {
        return StringsKt.equals((String)"chunked", (String)Response.header$default((Response)response, (String)"Transfer-Encoding", null, (int)2, null), (boolean)true);
    }

    private final Sink newChunkedSink() {
        int n = this.state;
        boolean bl = true;
        if (n != 1) {
            bl = false;
        }
        if (!bl) throw (Throwable)new IllegalStateException(Intrinsics.stringPlus((String)"state: ", (Object)this.state).toString());
        this.state = 2;
        return (Sink)new ChunkedSink(this);
    }

    private final Source newChunkedSource(HttpUrl httpUrl) {
        boolean bl = this.state == 4;
        if (!bl) throw (Throwable)new IllegalStateException(Intrinsics.stringPlus((String)"state: ", (Object)this.state).toString());
        this.state = 5;
        return (Source)new ChunkedSource(this, httpUrl);
    }

    private final Source newFixedLengthSource(long l) {
        boolean bl = this.state == 4;
        if (!bl) throw (Throwable)new IllegalStateException(Intrinsics.stringPlus((String)"state: ", (Object)this.state).toString());
        this.state = 5;
        return (Source)new FixedLengthSource(this, l);
    }

    private final Sink newKnownLengthSink() {
        int n = this.state;
        boolean bl = true;
        if (n != 1) {
            bl = false;
        }
        if (!bl) throw (Throwable)new IllegalStateException(Intrinsics.stringPlus((String)"state: ", (Object)this.state).toString());
        this.state = 2;
        return (Sink)new KnownLengthSink(this);
    }

    private final Source newUnknownLengthSource() {
        boolean bl = this.state == 4;
        if (!bl) throw (Throwable)new IllegalStateException(Intrinsics.stringPlus((String)"state: ", (Object)this.state).toString());
        this.state = 5;
        this.getConnection().noNewExchanges$okhttp();
        return (Source)new UnknownLengthSource(this);
    }

    public void cancel() {
        this.getConnection().cancel();
    }

    public Sink createRequestBody(Request request, long l) {
        Intrinsics.checkNotNullParameter((Object)request, (String)"request");
        if (request.body() != null) {
            if (request.body().isDuplex()) throw new ProtocolException("Duplex connections are not supported for HTTP/1");
        }
        if (this.isChunked(request)) {
            request = this.newChunkedSink();
        } else {
            if (l == -1L) throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
            request = this.newKnownLengthSink();
        }
        return request;
    }

    public void finishRequest() {
        this.sink.flush();
    }

    public void flushRequest() {
        this.sink.flush();
    }

    public RealConnection getConnection() {
        return this.connection;
    }

    public final boolean isClosed() {
        boolean bl = this.state == 6;
        return bl;
    }

    public Source openResponseBodySource(Response response) {
        long l;
        Intrinsics.checkNotNullParameter((Object)response, (String)"response");
        response = !HttpHeaders.promisesBody((Response)response) ? this.newFixedLengthSource(0L) : (this.isChunked(response) ? this.newChunkedSource(response.request().url()) : ((l = Util.headersContentLength((Response)response)) != -1L ? this.newFixedLengthSource(l) : this.newUnknownLengthSource()));
        return response;
    }

    public Response.Builder readResponseHeaders(boolean bl) {
        boolean bl2;
        int n = this.state;
        boolean bl3 = bl2 = true;
        if (n != 1) {
            bl3 = bl2;
            if (n != 2) {
                bl3 = n == 3 ? bl2 : false;
            }
        }
        if (!bl3) throw (Throwable)new IllegalStateException(Intrinsics.stringPlus((String)"state: ", (Object)this.state).toString());
        try {
            StatusLine statusLine = StatusLine.Companion.parse(this.headersReader.readLine());
            Response.Builder builder = new Response.Builder();
            builder = builder.protocol(statusLine.protocol).code(statusLine.code).message(statusLine.message).headers(this.headersReader.readHeaders());
            if (bl && statusLine.code == 100) {
                builder = null;
            } else {
                this.state = statusLine.code == 100 ? 3 : 4;
            }
            return builder;
        }
        catch (EOFException eOFException) {
            throw new IOException(Intrinsics.stringPlus((String)"unexpected end of stream on ", (Object)this.getConnection().route().address().url().redact()), eOFException);
        }
    }

    public long reportedContentLength(Response response) {
        Intrinsics.checkNotNullParameter((Object)response, (String)"response");
        long l = !HttpHeaders.promisesBody((Response)response) ? 0L : (this.isChunked(response) ? -1L : Util.headersContentLength((Response)response));
        return l;
    }

    public final void skipConnectBody(Response response) {
        Intrinsics.checkNotNullParameter((Object)response, (String)"response");
        long l = Util.headersContentLength((Response)response);
        if (l == -1L) {
            return;
        }
        response = this.newFixedLengthSource(l);
        Util.skipAll((Source)response, (int)Integer.MAX_VALUE, (TimeUnit)TimeUnit.MILLISECONDS);
        response.close();
    }

    public Headers trailers() {
        Headers headers;
        boolean bl = this.state == 6;
        if (!bl) throw (Throwable)new IllegalStateException("too early; can't read the trailers yet".toString());
        Headers headers2 = headers = this.trailers;
        if (headers != null) return headers2;
        headers2 = Util.EMPTY_HEADERS;
        return headers2;
    }

    public final void writeRequest(Headers object, String string) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"headers");
        Intrinsics.checkNotNullParameter((Object)string, (String)"requestLine");
        int n = this.state;
        int n2 = 0;
        n = n == 0 ? 1 : 0;
        if (n == 0) {
            object = new IllegalStateException(Intrinsics.stringPlus((String)"state: ", (Object)this.state).toString());
            throw object;
        }
        this.sink.writeUtf8(string).writeUtf8("\r\n");
        int n3 = object.size();
        if (n3 > 0) {
            n = n2;
            while (true) {
                n2 = n + 1;
                this.sink.writeUtf8(object.name(n)).writeUtf8(": ").writeUtf8(object.value(n)).writeUtf8("\r\n");
                if (n2 >= n3) break;
                n = n2;
            }
        }
        this.sink.writeUtf8("\r\n");
        this.state = 1;
    }

    public void writeRequestHeaders(Request request) {
        Intrinsics.checkNotNullParameter((Object)request, (String)"request");
        RequestLine requestLine = RequestLine.INSTANCE;
        Object object = this.getConnection().route().proxy().type();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"connection.route().proxy.type()");
        object = requestLine.get(request, object);
        this.writeRequest(request.headers(), (String)object);
    }
}
