/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.Call
 *  okhttp3.EventListener
 *  okhttp3.Headers
 *  okhttp3.Request
 *  okhttp3.RequestBody
 *  okhttp3.Response
 *  okhttp3.Response$Builder
 *  okhttp3.ResponseBody
 *  okhttp3.internal.connection.Exchange$RequestBodySink
 *  okhttp3.internal.connection.Exchange$ResponseBodySource
 *  okhttp3.internal.connection.ExchangeFinder
 *  okhttp3.internal.connection.RealCall
 *  okhttp3.internal.connection.RealConnection
 *  okhttp3.internal.http.ExchangeCodec
 *  okhttp3.internal.http.RealResponseBody
 *  okhttp3.internal.ws.RealWebSocket$Streams
 *  okio.Okio
 *  okio.Sink
 *  okio.Source
 */
package okhttp3.internal.connection;

import java.io.IOException;
import java.net.SocketException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.ExchangeFinder;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealResponseBody;
import okhttp3.internal.ws.RealWebSocket;
import okio.Okio;
import okio.Sink;
import okio.Source;

@Metadata(d1={"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002CDB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ7\u0010\u001e\u001a\u0002H\u001f\"\n\b\u0000\u0010\u001f*\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\u00162\u0006\u0010%\u001a\u0002H\u001f\u00a2\u0006\u0002\u0010&J\u0006\u0010'\u001a\u00020(J\u0016\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0016J\u0006\u0010.\u001a\u00020(J\u0006\u0010/\u001a\u00020(J\u0006\u00100\u001a\u00020(J\u0006\u00101\u001a\u000202J\u0006\u00103\u001a\u00020(J\u0006\u00104\u001a\u00020(J\u000e\u00105\u001a\u0002062\u0006\u00107\u001a\u000208J\u0010\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010;\u001a\u00020\u0016J\u000e\u0010<\u001a\u00020(2\u0006\u00107\u001a\u000208J\u0006\u0010=\u001a\u00020(J\u0010\u0010>\u001a\u00020(2\u0006\u0010%\u001a\u00020 H\u0002J\u0006\u0010?\u001a\u00020@J\u0006\u0010A\u001a\u00020(J\u000e\u0010B\u001a\u00020(2\u0006\u0010+\u001a\u00020,R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000eX\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0016@BX\u0080\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00168@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u0019R\u001e\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0016@BX\u0080\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019\u00a8\u0006E"}, d2={"Lokhttp3/internal/connection/Exchange;", "", "call", "Lokhttp3/internal/connection/RealCall;", "eventListener", "Lokhttp3/EventListener;", "finder", "Lokhttp3/internal/connection/ExchangeFinder;", "codec", "Lokhttp3/internal/http/ExchangeCodec;", "(Lokhttp3/internal/connection/RealCall;Lokhttp3/EventListener;Lokhttp3/internal/connection/ExchangeFinder;Lokhttp3/internal/http/ExchangeCodec;)V", "getCall$okhttp", "()Lokhttp3/internal/connection/RealCall;", "connection", "Lokhttp3/internal/connection/RealConnection;", "getConnection$okhttp", "()Lokhttp3/internal/connection/RealConnection;", "getEventListener$okhttp", "()Lokhttp3/EventListener;", "getFinder$okhttp", "()Lokhttp3/internal/connection/ExchangeFinder;", "<set-?>", "", "hasFailure", "getHasFailure$okhttp", "()Z", "isCoalescedConnection", "isCoalescedConnection$okhttp", "isDuplex", "isDuplex$okhttp", "bodyComplete", "E", "Ljava/io/IOException;", "bytesRead", "", "responseDone", "requestDone", "e", "(JZZLjava/io/IOException;)Ljava/io/IOException;", "cancel", "", "createRequestBody", "Lokio/Sink;", "request", "Lokhttp3/Request;", "duplex", "detachWithViolence", "finishRequest", "flushRequest", "newWebSocketStreams", "Lokhttp3/internal/ws/RealWebSocket$Streams;", "noNewExchangesOnConnection", "noRequestBody", "openResponseBody", "Lokhttp3/ResponseBody;", "response", "Lokhttp3/Response;", "readResponseHeaders", "Lokhttp3/Response$Builder;", "expectContinue", "responseHeadersEnd", "responseHeadersStart", "trackFailure", "trailers", "Lokhttp3/Headers;", "webSocketUpgradeFailed", "writeRequestHeaders", "RequestBodySink", "ResponseBodySource", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class Exchange {
    private final RealCall call;
    private final ExchangeCodec codec;
    private final RealConnection connection;
    private final EventListener eventListener;
    private final ExchangeFinder finder;
    private boolean hasFailure;
    private boolean isDuplex;

    public Exchange(RealCall realCall, EventListener eventListener, ExchangeFinder exchangeFinder, ExchangeCodec exchangeCodec) {
        Intrinsics.checkNotNullParameter((Object)realCall, (String)"call");
        Intrinsics.checkNotNullParameter((Object)eventListener, (String)"eventListener");
        Intrinsics.checkNotNullParameter((Object)exchangeFinder, (String)"finder");
        Intrinsics.checkNotNullParameter((Object)exchangeCodec, (String)"codec");
        this.call = realCall;
        this.eventListener = eventListener;
        this.finder = exchangeFinder;
        this.codec = exchangeCodec;
        this.connection = exchangeCodec.getConnection();
    }

    private final void trackFailure(IOException iOException) {
        this.hasFailure = true;
        this.finder.trackFailure(iOException);
        this.codec.getConnection().trackFailure$okhttp(this.call, iOException);
    }

    public final <E extends IOException> E bodyComplete(long l, boolean bl, boolean bl2, E e) {
        if (e != null) {
            this.trackFailure(e);
        }
        if (bl2) {
            if (e != null) {
                this.eventListener.requestFailed((Call)this.call, e);
            } else {
                this.eventListener.requestBodyEnd((Call)this.call, l);
            }
        }
        if (!bl) return (E)this.call.messageDone$okhttp(this, bl2, bl, e);
        if (e != null) {
            this.eventListener.responseFailed((Call)this.call, e);
        } else {
            this.eventListener.responseBodyEnd((Call)this.call, l);
        }
        return (E)this.call.messageDone$okhttp(this, bl2, bl, e);
    }

    public final void cancel() {
        this.codec.cancel();
    }

    public final Sink createRequestBody(Request request, boolean bl) throws IOException {
        Intrinsics.checkNotNullParameter((Object)request, (String)"request");
        this.isDuplex = bl;
        RequestBody requestBody = request.body();
        Intrinsics.checkNotNull((Object)requestBody);
        long l = requestBody.contentLength();
        this.eventListener.requestBodyStart((Call)this.call);
        return (Sink)new RequestBodySink(this, this.codec.createRequestBody(request, l), l);
    }

    public final void detachWithViolence() {
        this.codec.cancel();
        this.call.messageDone$okhttp(this, true, true, null);
    }

    public final void finishRequest() throws IOException {
        try {
            this.codec.finishRequest();
            return;
        }
        catch (IOException iOException) {
            this.eventListener.requestFailed((Call)this.call, iOException);
            this.trackFailure(iOException);
            throw iOException;
        }
    }

    public final void flushRequest() throws IOException {
        try {
            this.codec.flushRequest();
            return;
        }
        catch (IOException iOException) {
            this.eventListener.requestFailed((Call)this.call, iOException);
            this.trackFailure(iOException);
            throw iOException;
        }
    }

    public final RealCall getCall$okhttp() {
        return this.call;
    }

    public final RealConnection getConnection$okhttp() {
        return this.connection;
    }

    public final EventListener getEventListener$okhttp() {
        return this.eventListener;
    }

    public final ExchangeFinder getFinder$okhttp() {
        return this.finder;
    }

    public final boolean getHasFailure$okhttp() {
        return this.hasFailure;
    }

    public final boolean isCoalescedConnection$okhttp() {
        return Intrinsics.areEqual((Object)this.finder.getAddress$okhttp().url().host(), (Object)this.connection.route().address().url().host()) ^ true;
    }

    public final boolean isDuplex$okhttp() {
        return this.isDuplex;
    }

    public final RealWebSocket.Streams newWebSocketStreams() throws SocketException {
        this.call.timeoutEarlyExit();
        return this.codec.getConnection().newWebSocketStreams$okhttp(this);
    }

    public final void noNewExchangesOnConnection() {
        this.codec.getConnection().noNewExchanges$okhttp();
    }

    public final void noRequestBody() {
        this.call.messageDone$okhttp(this, true, false, null);
    }

    public final ResponseBody openResponseBody(Response response) throws IOException {
        Intrinsics.checkNotNullParameter((Object)response, (String)"response");
        try {
            String string = Response.header$default((Response)response, (String)"Content-Type", null, (int)2, null);
            long l = this.codec.reportedContentLength(response);
            Source source = this.codec.openResponseBodySource(response);
            response = new ResponseBodySource(this, source, l);
            source = new RealResponseBody(string, l, Okio.buffer((Source)((Source)response)));
            response = (ResponseBody)source;
            return response;
        }
        catch (IOException iOException) {
            this.eventListener.responseFailed((Call)this.call, iOException);
            this.trackFailure(iOException);
            throw iOException;
        }
    }

    public final Response.Builder readResponseHeaders(boolean bl) throws IOException {
        try {
            Response.Builder builder = this.codec.readResponseHeaders(bl);
            if (builder == null) return builder;
            builder.initExchange$okhttp(this);
            return builder;
        }
        catch (IOException iOException) {
            this.eventListener.responseFailed((Call)this.call, iOException);
            this.trackFailure(iOException);
            throw iOException;
        }
    }

    public final void responseHeadersEnd(Response response) {
        Intrinsics.checkNotNullParameter((Object)response, (String)"response");
        this.eventListener.responseHeadersEnd((Call)this.call, response);
    }

    public final void responseHeadersStart() {
        this.eventListener.responseHeadersStart((Call)this.call);
    }

    public final Headers trailers() throws IOException {
        return this.codec.trailers();
    }

    public final void webSocketUpgradeFailed() {
        this.bodyComplete(-1L, true, true, null);
    }

    public final void writeRequestHeaders(Request request) throws IOException {
        Intrinsics.checkNotNullParameter((Object)request, (String)"request");
        try {
            this.eventListener.requestHeadersStart((Call)this.call);
            this.codec.writeRequestHeaders(request);
            this.eventListener.requestHeadersEnd((Call)this.call, request);
            return;
        }
        catch (IOException iOException) {
            this.eventListener.requestFailed((Call)this.call, iOException);
            this.trackFailure(iOException);
            throw iOException;
        }
    }
}
