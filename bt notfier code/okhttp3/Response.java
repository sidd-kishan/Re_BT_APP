/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.CacheControl
 *  okhttp3.Challenge
 *  okhttp3.Handshake
 *  okhttp3.Headers
 *  okhttp3.Protocol
 *  okhttp3.Request
 *  okhttp3.Response$Builder
 *  okhttp3.ResponseBody
 *  okhttp3.internal.connection.Exchange
 *  okhttp3.internal.http.HttpHeaders
 *  okio.Buffer
 *  okio.BufferedSource
 *  okio.Source
 */
package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.CacheControl;
import okhttp3.Challenge;
import okhttp3.Handshake;
import okhttp3.Headers;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.http.HttpHeaders;
import okio.Buffer;
import okio.BufferedSource;
import okio.Source;

@Metadata(d1={"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0001FB{\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0000\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0000\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0000\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u00a2\u0006\u0002\u0010\u0018J\u000f\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007\u00a2\u0006\u0002\b+J\r\u0010\u001a\u001a\u00020\u001bH\u0007\u00a2\u0006\u0002\b,J\u000f\u0010\u0011\u001a\u0004\u0018\u00010\u0000H\u0007\u00a2\u0006\u0002\b-J\f\u0010.\u001a\b\u0012\u0004\u0012\u0002000/J\b\u00101\u001a\u000202H\u0016J\r\u0010\b\u001a\u00020\tH\u0007\u00a2\u0006\u0002\b3J\u000f\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007\u00a2\u0006\u0002\b4J\u001e\u00105\u001a\u0004\u0018\u00010\u00072\u0006\u00106\u001a\u00020\u00072\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0007H\u0007J\r\u0010\f\u001a\u00020\rH\u0007\u00a2\u0006\u0002\b8J\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070/2\u0006\u00106\u001a\u00020\u0007J\r\u0010\u0006\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\b9J\u000f\u0010\u0010\u001a\u0004\u0018\u00010\u0000H\u0007\u00a2\u0006\u0002\b:J\u0006\u0010;\u001a\u00020<J\u000e\u0010=\u001a\u00020\u000f2\u0006\u0010>\u001a\u00020\u0014J\u000f\u0010\u0012\u001a\u0004\u0018\u00010\u0000H\u0007\u00a2\u0006\u0002\b?J\r\u0010\u0004\u001a\u00020\u0005H\u0007\u00a2\u0006\u0002\b@J\r\u0010\u0015\u001a\u00020\u0014H\u0007\u00a2\u0006\u0002\bAJ\r\u0010\u0002\u001a\u00020\u0003H\u0007\u00a2\u0006\u0002\bBJ\r\u0010\u0013\u001a\u00020\u0014H\u0007\u00a2\u0006\u0002\bCJ\b\u0010D\u001a\u00020\u0007H\u0016J\u0006\u0010E\u001a\u00020\rR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u001b8G\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001cR\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u00008\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u001dR\u0013\u0010\b\u001a\u00020\t8\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u001eR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0001X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u001fR\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010 R\u0013\u0010\f\u001a\u00020\r8\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010!R\u0011\u0010\"\u001a\u00020#8F\u00a2\u0006\u0006\u001a\u0004\b\"\u0010$R\u0011\u0010%\u001a\u00020#8F\u00a2\u0006\u0006\u001a\u0004\b%\u0010$R\u0010\u0010&\u001a\u0004\u0018\u00010\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0013\u0010\u0006\u001a\u00020\u00078\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010'R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u00008\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u001dR\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u00008\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u001dR\u0013\u0010\u0004\u001a\u00020\u00058\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010(R\u0013\u0010\u0015\u001a\u00020\u00148\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010)R\u0013\u0010\u0002\u001a\u00020\u00038\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010*R\u0013\u0010\u0013\u001a\u00020\u00148\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010)\u00a8\u0006G"}, d2={"Lokhttp3/Response;", "Ljava/io/Closeable;", "request", "Lokhttp3/Request;", "protocol", "Lokhttp3/Protocol;", "message", "", "code", "", "handshake", "Lokhttp3/Handshake;", "headers", "Lokhttp3/Headers;", "body", "Lokhttp3/ResponseBody;", "networkResponse", "cacheResponse", "priorResponse", "sentRequestAtMillis", "", "receivedResponseAtMillis", "exchange", "Lokhttp3/internal/connection/Exchange;", "(Lokhttp3/Request;Lokhttp3/Protocol;Ljava/lang/String;ILokhttp3/Handshake;Lokhttp3/Headers;Lokhttp3/ResponseBody;Lokhttp3/Response;Lokhttp3/Response;Lokhttp3/Response;JJLokhttp3/internal/connection/Exchange;)V", "()Lokhttp3/ResponseBody;", "cacheControl", "Lokhttp3/CacheControl;", "()Lokhttp3/CacheControl;", "()Lokhttp3/Response;", "()I", "()Lokhttp3/internal/connection/Exchange;", "()Lokhttp3/Handshake;", "()Lokhttp3/Headers;", "isRedirect", "", "()Z", "isSuccessful", "lazyCacheControl", "()Ljava/lang/String;", "()Lokhttp3/Protocol;", "()J", "()Lokhttp3/Request;", "-deprecated_body", "-deprecated_cacheControl", "-deprecated_cacheResponse", "challenges", "", "Lokhttp3/Challenge;", "close", "", "-deprecated_code", "-deprecated_handshake", "header", "name", "defaultValue", "-deprecated_headers", "-deprecated_message", "-deprecated_networkResponse", "newBuilder", "Lokhttp3/Response$Builder;", "peekBody", "byteCount", "-deprecated_priorResponse", "-deprecated_protocol", "-deprecated_receivedResponseAtMillis", "-deprecated_request", "-deprecated_sentRequestAtMillis", "toString", "trailers", "Builder", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class Response
implements Closeable {
    private final ResponseBody body;
    private final Response cacheResponse;
    private final int code;
    private final Exchange exchange;
    private final Handshake handshake;
    private final Headers headers;
    private CacheControl lazyCacheControl;
    private final String message;
    private final Response networkResponse;
    private final Response priorResponse;
    private final Protocol protocol;
    private final long receivedResponseAtMillis;
    private final Request request;
    private final long sentRequestAtMillis;

    public Response(Request request, Protocol protocol, String string, int n, Handshake handshake, Headers headers, ResponseBody responseBody, Response response, Response response2, Response response3, long l, long l2, Exchange exchange) {
        Intrinsics.checkNotNullParameter((Object)request, (String)"request");
        Intrinsics.checkNotNullParameter((Object)protocol, (String)"protocol");
        Intrinsics.checkNotNullParameter((Object)string, (String)"message");
        Intrinsics.checkNotNullParameter((Object)headers, (String)"headers");
        this.request = request;
        this.protocol = protocol;
        this.message = string;
        this.code = n;
        this.handshake = handshake;
        this.headers = headers;
        this.body = responseBody;
        this.networkResponse = response;
        this.cacheResponse = response2;
        this.priorResponse = response3;
        this.sentRequestAtMillis = l;
        this.receivedResponseAtMillis = l2;
        this.exchange = exchange;
    }

    public static /* synthetic */ String header$default(Response response, String string, String string2, int n, Object object) {
        if ((n & 2) == 0) return response.header(string, string2);
        string2 = null;
        return response.header(string, string2);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="body", imports={}))
    public final ResponseBody _deprecated_body() {
        return this.body;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="cacheControl", imports={}))
    public final CacheControl _deprecated_cacheControl() {
        return this.cacheControl();
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="cacheResponse", imports={}))
    public final Response _deprecated_cacheResponse() {
        return this.cacheResponse;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="code", imports={}))
    public final int _deprecated_code() {
        return this.code;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="handshake", imports={}))
    public final Handshake _deprecated_handshake() {
        return this.handshake;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="headers", imports={}))
    public final Headers _deprecated_headers() {
        return this.headers;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="message", imports={}))
    public final String _deprecated_message() {
        return this.message;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="networkResponse", imports={}))
    public final Response _deprecated_networkResponse() {
        return this.networkResponse;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="priorResponse", imports={}))
    public final Response _deprecated_priorResponse() {
        return this.priorResponse;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="protocol", imports={}))
    public final Protocol _deprecated_protocol() {
        return this.protocol;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="receivedResponseAtMillis", imports={}))
    public final long _deprecated_receivedResponseAtMillis() {
        return this.receivedResponseAtMillis;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="request", imports={}))
    public final Request _deprecated_request() {
        return this.request;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="sentRequestAtMillis", imports={}))
    public final long _deprecated_sentRequestAtMillis() {
        return this.sentRequestAtMillis;
    }

    public final ResponseBody body() {
        return this.body;
    }

    public final CacheControl cacheControl() {
        CacheControl cacheControl;
        CacheControl cacheControl2 = cacheControl = this.lazyCacheControl;
        if (cacheControl != null) return cacheControl2;
        this.lazyCacheControl = cacheControl2 = CacheControl.Companion.parse(this.headers);
        return cacheControl2;
    }

    public final Response cacheResponse() {
        return this.cacheResponse;
    }

    public final List<Challenge> challenges() {
        String string;
        Headers headers = this.headers;
        int n = this.code;
        if (n != 401) {
            if (n != 407) {
                return CollectionsKt.emptyList();
            }
            string = "Proxy-Authenticate";
        } else {
            string = "WWW-Authenticate";
        }
        return HttpHeaders.parseChallenges((Headers)headers, (String)string);
    }

    @Override
    public void close() {
        ResponseBody responseBody = this.body;
        if (responseBody == null) throw (Throwable)new IllegalStateException("response is not eligible for a body and must not be closed".toString());
        responseBody.close();
    }

    public final int code() {
        return this.code;
    }

    public final Exchange exchange() {
        return this.exchange;
    }

    public final Handshake handshake() {
        return this.handshake;
    }

    public final String header(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"name");
        return Response.header$default(this, string, null, 2, null);
    }

    public final String header(String string, String string2) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"name");
        string = this.headers.get(string);
        if (string != null) return string;
        string = string2;
        return string;
    }

    public final List<String> headers(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"name");
        return this.headers.values(string);
    }

    public final Headers headers() {
        return this.headers;
    }

    /*
     * Enabled force condition propagation
     */
    public final boolean isRedirect() {
        int n = this.code;
        if (n == 307) return true;
        if (n == 308) return true;
        switch (n) {
            default: {
                return false;
            }
            case 300: 
            case 301: 
            case 302: 
            case 303: 
        }
        return true;
    }

    public final boolean isSuccessful() {
        boolean bl;
        int n = this.code;
        boolean bl2 = bl = false;
        if (200 > n) return bl2;
        bl2 = bl;
        if (n > 299) return bl2;
        bl2 = true;
        return bl2;
    }

    public final String message() {
        return this.message;
    }

    public final Response networkResponse() {
        return this.networkResponse;
    }

    public final Builder newBuilder() {
        return new Builder(this);
    }

    public final ResponseBody peekBody(long l) throws IOException {
        ResponseBody responseBody = this.body;
        Intrinsics.checkNotNull((Object)responseBody);
        BufferedSource bufferedSource = responseBody.source().peek();
        responseBody = new Buffer();
        bufferedSource.request(l);
        responseBody.write((Source)bufferedSource, Math.min(l, bufferedSource.getBuffer().size()));
        return ResponseBody.Companion.create((BufferedSource)responseBody, this.body.contentType(), responseBody.size());
    }

    public final Response priorResponse() {
        return this.priorResponse;
    }

    public final Protocol protocol() {
        return this.protocol;
    }

    public final long receivedResponseAtMillis() {
        return this.receivedResponseAtMillis;
    }

    public final Request request() {
        return this.request;
    }

    public final long sentRequestAtMillis() {
        return this.sentRequestAtMillis;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Response{protocol=");
        stringBuilder.append(this.protocol);
        stringBuilder.append(", code=");
        stringBuilder.append(this.code);
        stringBuilder.append(", message=");
        stringBuilder.append(this.message);
        stringBuilder.append(", url=");
        stringBuilder.append(this.request.url());
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public final Headers trailers() throws IOException {
        Exchange exchange = this.exchange;
        if (exchange == null) throw (Throwable)new IllegalStateException("trailers not available".toString());
        return exchange.trailers();
    }
}
