/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.Headers
 *  okhttp3.OkHttpClient
 *  okhttp3.Protocol
 *  okhttp3.Request
 *  okhttp3.Response
 *  okhttp3.Response$Builder
 *  okhttp3.internal.Util
 *  okhttp3.internal.connection.RealConnection
 *  okhttp3.internal.http.ExchangeCodec
 *  okhttp3.internal.http.HttpHeaders
 *  okhttp3.internal.http.RealInterceptorChain
 *  okhttp3.internal.http2.ErrorCode
 *  okhttp3.internal.http2.Http2Connection
 *  okhttp3.internal.http2.Http2ExchangeCodec$Companion
 *  okhttp3.internal.http2.Http2Stream
 *  okio.Sink
 *  okio.Source
 */
package okhttp3.internal.http2;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Http2ExchangeCodec;
import okhttp3.internal.http2.Http2Stream;
import okio.Sink;
import okio.Source;

@Metadata(d1={"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 (2\u00020\u0001:\u0001(B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0014H\u0016J\b\u0010\u001c\u001a\u00020\u0014H\u0016J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0012\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020\fH\u0016J\u0010\u0010$\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006)"}, d2={"Lokhttp3/internal/http2/Http2ExchangeCodec;", "Lokhttp3/internal/http/ExchangeCodec;", "client", "Lokhttp3/OkHttpClient;", "connection", "Lokhttp3/internal/connection/RealConnection;", "chain", "Lokhttp3/internal/http/RealInterceptorChain;", "http2Connection", "Lokhttp3/internal/http2/Http2Connection;", "(Lokhttp3/OkHttpClient;Lokhttp3/internal/connection/RealConnection;Lokhttp3/internal/http/RealInterceptorChain;Lokhttp3/internal/http2/Http2Connection;)V", "canceled", "", "getConnection", "()Lokhttp3/internal/connection/RealConnection;", "protocol", "Lokhttp3/Protocol;", "stream", "Lokhttp3/internal/http2/Http2Stream;", "cancel", "", "createRequestBody", "Lokio/Sink;", "request", "Lokhttp3/Request;", "contentLength", "", "finishRequest", "flushRequest", "openResponseBodySource", "Lokio/Source;", "response", "Lokhttp3/Response;", "readResponseHeaders", "Lokhttp3/Response$Builder;", "expectContinue", "reportedContentLength", "trailers", "Lokhttp3/Headers;", "writeRequestHeaders", "Companion", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class Http2ExchangeCodec
implements ExchangeCodec {
    private static final String CONNECTION = "connection";
    public static final Companion Companion = new Companion(null);
    private static final String ENCODING = "encoding";
    private static final String HOST = "host";
    private static final List<String> HTTP_2_SKIPPED_REQUEST_HEADERS = Util.immutableListOf((Object[])new String[]{"connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority"});
    private static final List<String> HTTP_2_SKIPPED_RESPONSE_HEADERS = Util.immutableListOf((Object[])new String[]{"connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade"});
    private static final String KEEP_ALIVE = "keep-alive";
    private static final String PROXY_CONNECTION = "proxy-connection";
    private static final String TE = "te";
    private static final String TRANSFER_ENCODING = "transfer-encoding";
    private static final String UPGRADE = "upgrade";
    private volatile boolean canceled;
    private final RealInterceptorChain chain;
    private final RealConnection connection;
    private final Http2Connection http2Connection;
    private final Protocol protocol;
    private volatile Http2Stream stream;

    public Http2ExchangeCodec(OkHttpClient okHttpClient, RealConnection realConnection, RealInterceptorChain realInterceptorChain, Http2Connection http2Connection) {
        Intrinsics.checkNotNullParameter((Object)okHttpClient, (String)"client");
        Intrinsics.checkNotNullParameter((Object)realConnection, (String)CONNECTION);
        Intrinsics.checkNotNullParameter((Object)realInterceptorChain, (String)"chain");
        Intrinsics.checkNotNullParameter((Object)http2Connection, (String)"http2Connection");
        this.connection = realConnection;
        this.chain = realInterceptorChain;
        this.http2Connection = http2Connection;
        okHttpClient = okHttpClient.protocols().contains(Protocol.H2_PRIOR_KNOWLEDGE) ? Protocol.H2_PRIOR_KNOWLEDGE : Protocol.HTTP_2;
        this.protocol = okHttpClient;
    }

    public static final /* synthetic */ List access$getHTTP_2_SKIPPED_REQUEST_HEADERS$cp() {
        return HTTP_2_SKIPPED_REQUEST_HEADERS;
    }

    public static final /* synthetic */ List access$getHTTP_2_SKIPPED_RESPONSE_HEADERS$cp() {
        return HTTP_2_SKIPPED_RESPONSE_HEADERS;
    }

    public void cancel() {
        this.canceled = true;
        Http2Stream http2Stream = this.stream;
        if (http2Stream == null) return;
        http2Stream.closeLater(ErrorCode.CANCEL);
    }

    public Sink createRequestBody(Request request, long l) {
        Intrinsics.checkNotNullParameter((Object)request, (String)"request");
        request = this.stream;
        Intrinsics.checkNotNull((Object)request);
        return request.getSink();
    }

    public void finishRequest() {
        Http2Stream http2Stream = this.stream;
        Intrinsics.checkNotNull((Object)http2Stream);
        http2Stream.getSink().close();
    }

    public void flushRequest() {
        this.http2Connection.flush();
    }

    public RealConnection getConnection() {
        return this.connection;
    }

    public Source openResponseBodySource(Response response) {
        Intrinsics.checkNotNullParameter((Object)response, (String)"response");
        response = this.stream;
        Intrinsics.checkNotNull((Object)response);
        return (Source)response.getSource$okhttp();
    }

    public Response.Builder readResponseHeaders(boolean bl) {
        Http2Stream http2Stream = this.stream;
        if (http2Stream == null) throw new IOException("stream wasn't created");
        http2Stream = http2Stream.takeHeaders();
        Response.Builder builder = Companion.readHttp2HeadersList((Headers)http2Stream, this.protocol);
        http2Stream = builder;
        if (!bl) return http2Stream;
        http2Stream = builder;
        if (builder.getCode$okhttp() != 100) return http2Stream;
        http2Stream = null;
        return http2Stream;
    }

    public long reportedContentLength(Response response) {
        Intrinsics.checkNotNullParameter((Object)response, (String)"response");
        long l = !HttpHeaders.promisesBody((Response)response) ? 0L : Util.headersContentLength((Response)response);
        return l;
    }

    public Headers trailers() {
        Http2Stream http2Stream = this.stream;
        Intrinsics.checkNotNull((Object)http2Stream);
        return http2Stream.trailers();
    }

    public void writeRequestHeaders(Request object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"request");
        if (this.stream != null) {
            return;
        }
        boolean bl = object.body() != null;
        object = Companion.http2HeadersList(object);
        this.stream = this.http2Connection.newStream((List)object, bl);
        if (!this.canceled) {
            object = this.stream;
            Intrinsics.checkNotNull((Object)object);
            object.readTimeout().timeout((long)this.chain.getReadTimeoutMillis$okhttp(), TimeUnit.MILLISECONDS);
            object = this.stream;
            Intrinsics.checkNotNull((Object)object);
            object.writeTimeout().timeout((long)this.chain.getWriteTimeoutMillis$okhttp(), TimeUnit.MILLISECONDS);
            return;
        }
        object = this.stream;
        Intrinsics.checkNotNull((Object)object);
        object.closeLater(ErrorCode.CANCEL);
        throw new IOException("Canceled");
    }
}
