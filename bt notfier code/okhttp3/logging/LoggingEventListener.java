/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.Call
 *  okhttp3.Connection
 *  okhttp3.EventListener
 *  okhttp3.Handshake
 *  okhttp3.HttpUrl
 *  okhttp3.Protocol
 *  okhttp3.Request
 *  okhttp3.Response
 *  okhttp3.logging.HttpLoggingInterceptor$Logger
 */
package okhttp3.logging;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

@Metadata(d1={"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001CB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\fH\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J*\u0010\u0016\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J2\u0010\u001d\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J \u0010\u001e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010\u001f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010 \u001a\u00020!H\u0016J\u0018\u0010\"\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010 \u001a\u00020!H\u0016J&\u0010#\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010$\u001a\u00020%2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'H\u0016J\u0018\u0010)\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020%H\u0002J&\u0010,\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010-\u001a\u00020.2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001a0'H\u0016J\u0018\u00100\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010-\u001a\u00020.H\u0016J\u0018\u00101\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u00102\u001a\u00020\u0006H\u0016J\u0010\u00103\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u00104\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u00105\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u00106\u001a\u000207H\u0016J\u0010\u00108\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u00109\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u00102\u001a\u00020\u0006H\u0016J\u0010\u0010:\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010;\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010<\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\fH\u0016J\u0010\u0010=\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010>\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\fH\u0016J\u001a\u0010?\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\u0010\u0010B\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006D"}, d2={"Lokhttp3/logging/LoggingEventListener;", "Lokhttp3/EventListener;", "logger", "Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "(Lokhttp3/logging/HttpLoggingInterceptor$Logger;)V", "startNs", "", "cacheConditionalHit", "", "call", "Lokhttp3/Call;", "cachedResponse", "Lokhttp3/Response;", "cacheHit", "response", "cacheMiss", "callEnd", "callFailed", "ioe", "Ljava/io/IOException;", "callStart", "canceled", "connectEnd", "inetSocketAddress", "Ljava/net/InetSocketAddress;", "proxy", "Ljava/net/Proxy;", "protocol", "Lokhttp3/Protocol;", "connectFailed", "connectStart", "connectionAcquired", "connection", "Lokhttp3/Connection;", "connectionReleased", "dnsEnd", "domainName", "", "inetAddressList", "", "Ljava/net/InetAddress;", "dnsStart", "logWithTime", "message", "proxySelectEnd", "url", "Lokhttp3/HttpUrl;", "proxies", "proxySelectStart", "requestBodyEnd", "byteCount", "requestBodyStart", "requestFailed", "requestHeadersEnd", "request", "Lokhttp3/Request;", "requestHeadersStart", "responseBodyEnd", "responseBodyStart", "responseFailed", "responseHeadersEnd", "responseHeadersStart", "satisfactionFailure", "secureConnectEnd", "handshake", "Lokhttp3/Handshake;", "secureConnectStart", "Factory", "okhttp-logging-interceptor"}, k=1, mv={1, 5, 1}, xi=48)
public final class LoggingEventListener
extends EventListener {
    private final HttpLoggingInterceptor.Logger logger;
    private long startNs;

    private LoggingEventListener(HttpLoggingInterceptor.Logger logger) {
        this.logger = logger;
    }

    public /* synthetic */ LoggingEventListener(HttpLoggingInterceptor.Logger logger, DefaultConstructorMarker defaultConstructorMarker) {
        this(logger);
    }

    private final void logWithTime(String string) {
        long l = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - this.startNs);
        HttpLoggingInterceptor.Logger logger = this.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        stringBuilder.append(l);
        stringBuilder.append(" ms] ");
        stringBuilder.append(string);
        logger.log(stringBuilder.toString());
    }

    public void cacheConditionalHit(Call call, Response response) {
        Intrinsics.checkNotNullParameter((Object)call, (String)"call");
        Intrinsics.checkNotNullParameter((Object)response, (String)"cachedResponse");
        this.logWithTime(Intrinsics.stringPlus((String)"cacheConditionalHit: ", (Object)response));
    }

    public void cacheHit(Call call, Response response) {
        Intrinsics.checkNotNullParameter((Object)call, (String)"call");
        Intrinsics.checkNotNullParameter((Object)response, (String)"response");
        this.logWithTime(Intrinsics.stringPlus((String)"cacheHit: ", (Object)response));
    }

    public void cacheMiss(Call call) {
        Intrinsics.checkNotNullParameter((Object)call, (String)"call");
        this.logWithTime("cacheMiss");
    }

    public void callEnd(Call call) {
        Intrinsics.checkNotNullParameter((Object)call, (String)"call");
        this.logWithTime("callEnd");
    }

    public void callFailed(Call call, IOException iOException) {
        Intrinsics.checkNotNullParameter((Object)call, (String)"call");
        Intrinsics.checkNotNullParameter((Object)iOException, (String)"ioe");
        this.logWithTime(Intrinsics.stringPlus((String)"callFailed: ", (Object)iOException));
    }

    public void callStart(Call call) {
        Intrinsics.checkNotNullParameter((Object)call, (String)"call");
        this.startNs = System.nanoTime();
        this.logWithTime(Intrinsics.stringPlus((String)"callStart: ", (Object)call.request()));
    }

    public void canceled(Call call) {
        Intrinsics.checkNotNullParameter((Object)call, (String)"call");
        this.logWithTime("canceled");
    }

    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        Intrinsics.checkNotNullParameter((Object)call, (String)"call");
        Intrinsics.checkNotNullParameter((Object)inetSocketAddress, (String)"inetSocketAddress");
        Intrinsics.checkNotNullParameter((Object)proxy, (String)"proxy");
        this.logWithTime(Intrinsics.stringPlus((String)"connectEnd: ", (Object)protocol));
    }

    public void connectFailed(Call object, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"call");
        Intrinsics.checkNotNullParameter((Object)inetSocketAddress, (String)"inetSocketAddress");
        Intrinsics.checkNotNullParameter((Object)proxy, (String)"proxy");
        Intrinsics.checkNotNullParameter((Object)iOException, (String)"ioe");
        object = new StringBuilder();
        ((StringBuilder)object).append("connectFailed: ");
        ((StringBuilder)object).append(protocol);
        ((StringBuilder)object).append(' ');
        ((StringBuilder)object).append(iOException);
        this.logWithTime(((StringBuilder)object).toString());
    }

    public void connectStart(Call object, InetSocketAddress inetSocketAddress, Proxy proxy) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"call");
        Intrinsics.checkNotNullParameter((Object)inetSocketAddress, (String)"inetSocketAddress");
        Intrinsics.checkNotNullParameter((Object)proxy, (String)"proxy");
        object = new StringBuilder();
        ((StringBuilder)object).append("connectStart: ");
        ((StringBuilder)object).append(inetSocketAddress);
        ((StringBuilder)object).append(' ');
        ((StringBuilder)object).append(proxy);
        this.logWithTime(((StringBuilder)object).toString());
    }

    public void connectionAcquired(Call call, Connection connection) {
        Intrinsics.checkNotNullParameter((Object)call, (String)"call");
        Intrinsics.checkNotNullParameter((Object)connection, (String)"connection");
        this.logWithTime(Intrinsics.stringPlus((String)"connectionAcquired: ", (Object)connection));
    }

    public void connectionReleased(Call call, Connection connection) {
        Intrinsics.checkNotNullParameter((Object)call, (String)"call");
        Intrinsics.checkNotNullParameter((Object)connection, (String)"connection");
        this.logWithTime("connectionReleased");
    }

    public void dnsEnd(Call call, String string, List<? extends InetAddress> list) {
        Intrinsics.checkNotNullParameter((Object)call, (String)"call");
        Intrinsics.checkNotNullParameter((Object)string, (String)"domainName");
        Intrinsics.checkNotNullParameter(list, (String)"inetAddressList");
        this.logWithTime(Intrinsics.stringPlus((String)"dnsEnd: ", list));
    }

    public void dnsStart(Call call, String string) {
        Intrinsics.checkNotNullParameter((Object)call, (String)"call");
        Intrinsics.checkNotNullParameter((Object)string, (String)"domainName");
        this.logWithTime(Intrinsics.stringPlus((String)"dnsStart: ", (Object)string));
    }

    public void proxySelectEnd(Call call, HttpUrl httpUrl, List<? extends Proxy> list) {
        Intrinsics.checkNotNullParameter((Object)call, (String)"call");
        Intrinsics.checkNotNullParameter((Object)httpUrl, (String)"url");
        Intrinsics.checkNotNullParameter(list, (String)"proxies");
        this.logWithTime(Intrinsics.stringPlus((String)"proxySelectEnd: ", list));
    }

    public void proxySelectStart(Call call, HttpUrl httpUrl) {
        Intrinsics.checkNotNullParameter((Object)call, (String)"call");
        Intrinsics.checkNotNullParameter((Object)httpUrl, (String)"url");
        this.logWithTime(Intrinsics.stringPlus((String)"proxySelectStart: ", (Object)httpUrl));
    }

    public void requestBodyEnd(Call call, long l) {
        Intrinsics.checkNotNullParameter((Object)call, (String)"call");
        this.logWithTime(Intrinsics.stringPlus((String)"requestBodyEnd: byteCount=", (Object)l));
    }

    public void requestBodyStart(Call call) {
        Intrinsics.checkNotNullParameter((Object)call, (String)"call");
        this.logWithTime("requestBodyStart");
    }

    public void requestFailed(Call call, IOException iOException) {
        Intrinsics.checkNotNullParameter((Object)call, (String)"call");
        Intrinsics.checkNotNullParameter((Object)iOException, (String)"ioe");
        this.logWithTime(Intrinsics.stringPlus((String)"requestFailed: ", (Object)iOException));
    }

    public void requestHeadersEnd(Call call, Request request) {
        Intrinsics.checkNotNullParameter((Object)call, (String)"call");
        Intrinsics.checkNotNullParameter((Object)request, (String)"request");
        this.logWithTime("requestHeadersEnd");
    }

    public void requestHeadersStart(Call call) {
        Intrinsics.checkNotNullParameter((Object)call, (String)"call");
        this.logWithTime("requestHeadersStart");
    }

    public void responseBodyEnd(Call call, long l) {
        Intrinsics.checkNotNullParameter((Object)call, (String)"call");
        this.logWithTime(Intrinsics.stringPlus((String)"responseBodyEnd: byteCount=", (Object)l));
    }

    public void responseBodyStart(Call call) {
        Intrinsics.checkNotNullParameter((Object)call, (String)"call");
        this.logWithTime("responseBodyStart");
    }

    public void responseFailed(Call call, IOException iOException) {
        Intrinsics.checkNotNullParameter((Object)call, (String)"call");
        Intrinsics.checkNotNullParameter((Object)iOException, (String)"ioe");
        this.logWithTime(Intrinsics.stringPlus((String)"responseFailed: ", (Object)iOException));
    }

    public void responseHeadersEnd(Call call, Response response) {
        Intrinsics.checkNotNullParameter((Object)call, (String)"call");
        Intrinsics.checkNotNullParameter((Object)response, (String)"response");
        this.logWithTime(Intrinsics.stringPlus((String)"responseHeadersEnd: ", (Object)response));
    }

    public void responseHeadersStart(Call call) {
        Intrinsics.checkNotNullParameter((Object)call, (String)"call");
        this.logWithTime("responseHeadersStart");
    }

    public void satisfactionFailure(Call call, Response response) {
        Intrinsics.checkNotNullParameter((Object)call, (String)"call");
        Intrinsics.checkNotNullParameter((Object)response, (String)"response");
        this.logWithTime(Intrinsics.stringPlus((String)"satisfactionFailure: ", (Object)response));
    }

    public void secureConnectEnd(Call call, Handshake handshake) {
        Intrinsics.checkNotNullParameter((Object)call, (String)"call");
        this.logWithTime(Intrinsics.stringPlus((String)"secureConnectEnd: ", (Object)handshake));
    }

    public void secureConnectStart(Call call) {
        Intrinsics.checkNotNullParameter((Object)call, (String)"call");
        this.logWithTime("secureConnectStart");
    }
}
