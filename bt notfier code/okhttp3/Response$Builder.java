/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.Handshake
 *  okhttp3.Headers
 *  okhttp3.Headers$Builder
 *  okhttp3.Protocol
 *  okhttp3.Request
 *  okhttp3.Response
 *  okhttp3.ResponseBody
 *  okhttp3.internal.connection.Exchange
 */
package okhttp3;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Handshake;
import okhttp3.Headers;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.connection.Exchange;

@Metadata(d1={"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0002B\u000f\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0018\u0010I\u001a\u00020\u00002\u0006\u0010J\u001a\u00020)2\u0006\u0010K\u001a\u00020)H\u0016J\u0012\u0010\u0006\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010L\u001a\u00020\u0004H\u0016J\u0012\u0010\f\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010M\u001a\u00020N2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010O\u001a\u00020N2\u0006\u0010J\u001a\u00020)2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0012\u0010\u001c\u001a\u00020\u00002\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0018\u0010P\u001a\u00020\u00002\u0006\u0010J\u001a\u00020)2\u0006\u0010K\u001a\u00020)H\u0016J\u0010\u0010\"\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020QH\u0016J\u0015\u0010R\u001a\u00020N2\u0006\u0010S\u001a\u00020\u0017H\u0000\u00a2\u0006\u0002\bTJ\u0010\u0010(\u001a\u00020\u00002\u0006\u0010(\u001a\u00020)H\u0016J\u0012\u0010.\u001a\u00020\u00002\b\u0010.\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u00101\u001a\u00020\u00002\b\u00101\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u00104\u001a\u00020\u00002\u0006\u00104\u001a\u000205H\u0016J\u0010\u0010:\u001a\u00020\u00002\u0006\u0010:\u001a\u00020;H\u0016J\u0010\u0010U\u001a\u00020\u00002\u0006\u0010J\u001a\u00020)H\u0016J\u0010\u0010@\u001a\u00020\u00002\u0006\u0010@\u001a\u00020AH\u0016J\u0010\u0010F\u001a\u00020\u00002\u0006\u0010F\u001a\u00020;H\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0005R\u001a\u0010\u0010\u001a\u00020\u0011X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010(\u001a\u0004\u0018\u00010)X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u0010.\u001a\u0004\u0018\u00010\u0004X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u000e\"\u0004\b0\u0010\u0005R\u001c\u00101\u001a\u0004\u0018\u00010\u0004X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u000e\"\u0004\b3\u0010\u0005R\u001c\u00104\u001a\u0004\u0018\u000105X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001a\u0010:\u001a\u00020;X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001c\u0010@\u001a\u0004\u0018\u00010AX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001a\u0010F\u001a\u00020;X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bG\u0010=\"\u0004\bH\u0010?\u00a8\u0006V"}, d2={"Lokhttp3/Response$Builder;", "", "()V", "response", "Lokhttp3/Response;", "(Lokhttp3/Response;)V", "body", "Lokhttp3/ResponseBody;", "getBody$okhttp", "()Lokhttp3/ResponseBody;", "setBody$okhttp", "(Lokhttp3/ResponseBody;)V", "cacheResponse", "getCacheResponse$okhttp", "()Lokhttp3/Response;", "setCacheResponse$okhttp", "code", "", "getCode$okhttp", "()I", "setCode$okhttp", "(I)V", "exchange", "Lokhttp3/internal/connection/Exchange;", "getExchange$okhttp", "()Lokhttp3/internal/connection/Exchange;", "setExchange$okhttp", "(Lokhttp3/internal/connection/Exchange;)V", "handshake", "Lokhttp3/Handshake;", "getHandshake$okhttp", "()Lokhttp3/Handshake;", "setHandshake$okhttp", "(Lokhttp3/Handshake;)V", "headers", "Lokhttp3/Headers$Builder;", "getHeaders$okhttp", "()Lokhttp3/Headers$Builder;", "setHeaders$okhttp", "(Lokhttp3/Headers$Builder;)V", "message", "", "getMessage$okhttp", "()Ljava/lang/String;", "setMessage$okhttp", "(Ljava/lang/String;)V", "networkResponse", "getNetworkResponse$okhttp", "setNetworkResponse$okhttp", "priorResponse", "getPriorResponse$okhttp", "setPriorResponse$okhttp", "protocol", "Lokhttp3/Protocol;", "getProtocol$okhttp", "()Lokhttp3/Protocol;", "setProtocol$okhttp", "(Lokhttp3/Protocol;)V", "receivedResponseAtMillis", "", "getReceivedResponseAtMillis$okhttp", "()J", "setReceivedResponseAtMillis$okhttp", "(J)V", "request", "Lokhttp3/Request;", "getRequest$okhttp", "()Lokhttp3/Request;", "setRequest$okhttp", "(Lokhttp3/Request;)V", "sentRequestAtMillis", "getSentRequestAtMillis$okhttp", "setSentRequestAtMillis$okhttp", "addHeader", "name", "value", "build", "checkPriorResponse", "", "checkSupportResponse", "header", "Lokhttp3/Headers;", "initExchange", "deferredTrailers", "initExchange$okhttp", "removeHeader", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static class Response.Builder {
    private ResponseBody body;
    private Response cacheResponse;
    private int code;
    private Exchange exchange;
    private Handshake handshake;
    private Headers.Builder headers;
    private String message;
    private Response networkResponse;
    private Response priorResponse;
    private Protocol protocol;
    private long receivedResponseAtMillis;
    private Request request;
    private long sentRequestAtMillis;

    public Response.Builder() {
        this.code = -1;
        this.headers = new Headers.Builder();
    }

    public Response.Builder(Response response) {
        Intrinsics.checkNotNullParameter((Object)response, (String)"response");
        this.code = -1;
        this.request = response.request();
        this.protocol = response.protocol();
        this.code = response.code();
        this.message = response.message();
        this.handshake = response.handshake();
        this.headers = response.headers().newBuilder();
        this.body = response.body();
        this.networkResponse = response.networkResponse();
        this.cacheResponse = response.cacheResponse();
        this.priorResponse = response.priorResponse();
        this.sentRequestAtMillis = response.sentRequestAtMillis();
        this.receivedResponseAtMillis = response.receivedResponseAtMillis();
        this.exchange = response.exchange();
    }

    private final void checkPriorResponse(Response response) {
        if (response == null) return;
        boolean bl = response.body() == null;
        if (!bl) throw (Throwable)new IllegalArgumentException("priorResponse.body != null".toString());
    }

    private final void checkSupportResponse(String string, Response response) {
        if (response == null) return;
        ResponseBody responseBody = response.body();
        boolean bl = true;
        boolean bl2 = responseBody == null;
        if (!bl2) throw (Throwable)new IllegalArgumentException(Intrinsics.stringPlus((String)string, (Object)".body != null").toString());
        bl2 = response.networkResponse() == null;
        if (!bl2) throw (Throwable)new IllegalArgumentException(Intrinsics.stringPlus((String)string, (Object)".networkResponse != null").toString());
        bl2 = response.cacheResponse() == null;
        if (!bl2) throw (Throwable)new IllegalArgumentException(Intrinsics.stringPlus((String)string, (Object)".cacheResponse != null").toString());
        bl2 = response.priorResponse() == null ? bl : false;
        if (!bl2) throw (Throwable)new IllegalArgumentException(Intrinsics.stringPlus((String)string, (Object)".priorResponse != null").toString());
    }

    public Response.Builder addHeader(String string, String string2) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"name");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"value");
        Response.Builder builder = this;
        builder.getHeaders$okhttp().add(string, string2);
        return builder;
    }

    public Response.Builder body(ResponseBody responseBody) {
        Response.Builder builder = this;
        builder.setBody$okhttp(responseBody);
        return builder;
    }

    public Response build() {
        boolean bl = this.code >= 0;
        if (!bl) throw (Throwable)new IllegalStateException(Intrinsics.stringPlus((String)"code < 0: ", (Object)this.getCode$okhttp()).toString());
        Request request = this.request;
        if (request == null) throw (Throwable)new IllegalStateException("request == null".toString());
        Protocol protocol = this.protocol;
        if (protocol == null) throw (Throwable)new IllegalStateException("protocol == null".toString());
        String string = this.message;
        if (string == null) throw (Throwable)new IllegalStateException("message == null".toString());
        return new Response(request, protocol, string, this.code, this.handshake, this.headers.build(), this.body, this.networkResponse, this.cacheResponse, this.priorResponse, this.sentRequestAtMillis, this.receivedResponseAtMillis, this.exchange);
    }

    public Response.Builder cacheResponse(Response response) {
        Response.Builder builder = this;
        builder.checkSupportResponse("cacheResponse", response);
        builder.setCacheResponse$okhttp(response);
        return builder;
    }

    public Response.Builder code(int n) {
        Response.Builder builder = this;
        builder.setCode$okhttp(n);
        return builder;
    }

    public final ResponseBody getBody$okhttp() {
        return this.body;
    }

    public final Response getCacheResponse$okhttp() {
        return this.cacheResponse;
    }

    public final int getCode$okhttp() {
        return this.code;
    }

    public final Exchange getExchange$okhttp() {
        return this.exchange;
    }

    public final Handshake getHandshake$okhttp() {
        return this.handshake;
    }

    public final Headers.Builder getHeaders$okhttp() {
        return this.headers;
    }

    public final String getMessage$okhttp() {
        return this.message;
    }

    public final Response getNetworkResponse$okhttp() {
        return this.networkResponse;
    }

    public final Response getPriorResponse$okhttp() {
        return this.priorResponse;
    }

    public final Protocol getProtocol$okhttp() {
        return this.protocol;
    }

    public final long getReceivedResponseAtMillis$okhttp() {
        return this.receivedResponseAtMillis;
    }

    public final Request getRequest$okhttp() {
        return this.request;
    }

    public final long getSentRequestAtMillis$okhttp() {
        return this.sentRequestAtMillis;
    }

    public Response.Builder handshake(Handshake handshake) {
        Response.Builder builder = this;
        builder.setHandshake$okhttp(handshake);
        return builder;
    }

    public Response.Builder header(String string, String string2) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"name");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"value");
        Response.Builder builder = this;
        builder.getHeaders$okhttp().set(string, string2);
        return builder;
    }

    public Response.Builder headers(Headers headers) {
        Intrinsics.checkNotNullParameter((Object)headers, (String)"headers");
        Response.Builder builder = this;
        builder.setHeaders$okhttp(headers.newBuilder());
        return builder;
    }

    public final void initExchange$okhttp(Exchange exchange) {
        Intrinsics.checkNotNullParameter((Object)exchange, (String)"deferredTrailers");
        this.exchange = exchange;
    }

    public Response.Builder message(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"message");
        Response.Builder builder = this;
        builder.setMessage$okhttp(string);
        return builder;
    }

    public Response.Builder networkResponse(Response response) {
        Response.Builder builder = this;
        builder.checkSupportResponse("networkResponse", response);
        builder.setNetworkResponse$okhttp(response);
        return builder;
    }

    public Response.Builder priorResponse(Response response) {
        Response.Builder builder = this;
        builder.checkPriorResponse(response);
        builder.setPriorResponse$okhttp(response);
        return builder;
    }

    public Response.Builder protocol(Protocol protocol) {
        Intrinsics.checkNotNullParameter((Object)protocol, (String)"protocol");
        Response.Builder builder = this;
        builder.setProtocol$okhttp(protocol);
        return builder;
    }

    public Response.Builder receivedResponseAtMillis(long l) {
        Response.Builder builder = this;
        builder.setReceivedResponseAtMillis$okhttp(l);
        return builder;
    }

    public Response.Builder removeHeader(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"name");
        Response.Builder builder = this;
        builder.getHeaders$okhttp().removeAll(string);
        return builder;
    }

    public Response.Builder request(Request request) {
        Intrinsics.checkNotNullParameter((Object)request, (String)"request");
        Response.Builder builder = this;
        builder.setRequest$okhttp(request);
        return builder;
    }

    public Response.Builder sentRequestAtMillis(long l) {
        Response.Builder builder = this;
        builder.setSentRequestAtMillis$okhttp(l);
        return builder;
    }

    public final void setBody$okhttp(ResponseBody responseBody) {
        this.body = responseBody;
    }

    public final void setCacheResponse$okhttp(Response response) {
        this.cacheResponse = response;
    }

    public final void setCode$okhttp(int n) {
        this.code = n;
    }

    public final void setExchange$okhttp(Exchange exchange) {
        this.exchange = exchange;
    }

    public final void setHandshake$okhttp(Handshake handshake) {
        this.handshake = handshake;
    }

    public final void setHeaders$okhttp(Headers.Builder builder) {
        Intrinsics.checkNotNullParameter((Object)builder, (String)"<set-?>");
        this.headers = builder;
    }

    public final void setMessage$okhttp(String string) {
        this.message = string;
    }

    public final void setNetworkResponse$okhttp(Response response) {
        this.networkResponse = response;
    }

    public final void setPriorResponse$okhttp(Response response) {
        this.priorResponse = response;
    }

    public final void setProtocol$okhttp(Protocol protocol) {
        this.protocol = protocol;
    }

    public final void setReceivedResponseAtMillis$okhttp(long l) {
        this.receivedResponseAtMillis = l;
    }

    public final void setRequest$okhttp(Request request) {
        this.request = request;
    }

    public final void setSentRequestAtMillis$okhttp(long l) {
        this.sentRequestAtMillis = l;
    }
}
