/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.Regex
 *  okhttp3.HttpUrl
 *  okhttp3.Interceptor
 *  okhttp3.Interceptor$Chain
 *  okhttp3.OkHttpClient
 *  okhttp3.Request
 *  okhttp3.RequestBody
 *  okhttp3.Response
 *  okhttp3.Route
 *  okhttp3.internal.Util
 *  okhttp3.internal.connection.Exchange
 *  okhttp3.internal.connection.RealCall
 *  okhttp3.internal.connection.RouteException
 *  okhttp3.internal.http.HttpMethod
 *  okhttp3.internal.http.RealInterceptorChain
 *  okhttp3.internal.http.RetryAndFollowUpInterceptor$Companion
 *  okhttp3.internal.http2.ConnectionShutdownException
 */
package okhttp3.internal.http;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.Collection;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http.RetryAndFollowUpInterceptor;
import okhttp3.internal.http2.ConnectionShutdownException;

@Metadata(d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0012H\u0002J(\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0012H\u0002J\u0018\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u0006H\u0002J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2={"Lokhttp3/internal/http/RetryAndFollowUpInterceptor;", "Lokhttp3/Interceptor;", "client", "Lokhttp3/OkHttpClient;", "(Lokhttp3/OkHttpClient;)V", "buildRedirectRequest", "Lokhttp3/Request;", "userResponse", "Lokhttp3/Response;", "method", "", "followUpRequest", "exchange", "Lokhttp3/internal/connection/Exchange;", "intercept", "chain", "Lokhttp3/Interceptor$Chain;", "isRecoverable", "", "e", "Ljava/io/IOException;", "requestSendStarted", "recover", "call", "Lokhttp3/internal/connection/RealCall;", "userRequest", "requestIsOneShot", "retryAfter", "", "defaultDelay", "Companion", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class RetryAndFollowUpInterceptor
implements Interceptor {
    public static final Companion Companion = new Companion(null);
    private static final int MAX_FOLLOW_UPS = 20;
    private final OkHttpClient client;

    public RetryAndFollowUpInterceptor(OkHttpClient okHttpClient) {
        Intrinsics.checkNotNullParameter((Object)okHttpClient, (String)"client");
        this.client = okHttpClient;
    }

    private final Request buildRedirectRequest(Response response, String string) {
        boolean bl = this.client.followRedirects();
        RequestBody requestBody = null;
        if (!bl) {
            return null;
        }
        String string2 = Response.header$default((Response)response, (String)"Location", null, (int)2, null);
        if (string2 == null) {
            return null;
        }
        HttpUrl httpUrl = response.request().url().resolve(string2);
        if (httpUrl == null) {
            return null;
        }
        if (!Intrinsics.areEqual((Object)httpUrl.scheme(), (Object)response.request().url().scheme()) && !this.client.followSslRedirects()) {
            return null;
        }
        string2 = response.request().newBuilder();
        if (HttpMethod.permitsRequestBody((String)string)) {
            int n = response.code();
            boolean bl2 = HttpMethod.INSTANCE.redirectsWithBody(string) || n == 308 || n == 307;
            if (HttpMethod.INSTANCE.redirectsToGet(string) && n != 308 && n != 307) {
                string2.method("GET", null);
            } else {
                if (bl2) {
                    requestBody = response.request().body();
                }
                string2.method(string, requestBody);
            }
            if (!bl2) {
                string2.removeHeader("Transfer-Encoding");
                string2.removeHeader("Content-Length");
                string2.removeHeader("Content-Type");
            }
        }
        if (Util.canReuseConnectionFor((HttpUrl)response.request().url(), (HttpUrl)httpUrl)) return string2.url(httpUrl).build();
        string2.removeHeader("Authorization");
        return string2.url(httpUrl).build();
    }

    private final Request followUpRequest(Response response, Exchange exchange) throws IOException {
        Object object;
        object = exchange == null || (object = exchange.getConnection$okhttp()) == null ? null : object.route();
        int n = response.code();
        String string = response.request().method();
        if (n == 307) return this.buildRedirectRequest(response, string);
        if (n == 308) return this.buildRedirectRequest(response, string);
        if (n == 401) return this.client.authenticator().authenticate((Route)object, response);
        if (n != 421) {
            if (n != 503) {
                if (n == 407) {
                    Intrinsics.checkNotNull((Object)object);
                    if (object.proxy().type() != Proxy.Type.HTTP) throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                    return this.client.proxyAuthenticator().authenticate((Route)object, response);
                }
                if (n != 408) {
                    switch (n) {
                        default: {
                            return null;
                        }
                        case 300: 
                        case 301: 
                        case 302: 
                        case 303: 
                    }
                    return this.buildRedirectRequest(response, string);
                }
                if (!this.client.retryOnConnectionFailure()) {
                    return null;
                }
                exchange = response.request().body();
                if (exchange != null && exchange.isOneShot()) {
                    return null;
                }
                exchange = response.priorResponse();
                if (exchange != null && exchange.code() == 408) {
                    return null;
                }
                if (this.retryAfter(response, 0) <= 0) return response.request();
                return null;
            }
            exchange = response.priorResponse();
            if (exchange != null && exchange.code() == 503) {
                return null;
            }
            if (this.retryAfter(response, Integer.MAX_VALUE) != 0) return null;
            return response.request();
        }
        object = response.request().body();
        if (object != null && object.isOneShot()) {
            return null;
        }
        if (exchange == null) return null;
        if (!exchange.isCoalescedConnection$okhttp()) {
            return null;
        }
        exchange.getConnection$okhttp().noCoalescedConnections$okhttp();
        return response.request();
    }

    private final boolean isRecoverable(IOException iOException, boolean bl) {
        boolean bl2 = iOException instanceof ProtocolException;
        boolean bl3 = false;
        if (bl2) {
            return false;
        }
        if (iOException instanceof InterruptedIOException) {
            bl2 = bl3;
            if (!(iOException instanceof SocketTimeoutException)) return bl2;
            bl2 = bl3;
            if (bl) return bl2;
            bl2 = true;
            return bl2;
        }
        if (iOException instanceof SSLHandshakeException && iOException.getCause() instanceof CertificateException) {
            return false;
        }
        if (!(iOException instanceof SSLPeerUnverifiedException)) return true;
        return false;
    }

    private final boolean recover(IOException iOException, RealCall realCall, Request request, boolean bl) {
        if (!this.client.retryOnConnectionFailure()) {
            return false;
        }
        if (bl && this.requestIsOneShot(iOException, request)) {
            return false;
        }
        if (!this.isRecoverable(iOException, bl)) {
            return false;
        }
        if (realCall.retryAfterFailure()) return true;
        return false;
    }

    private final boolean requestIsOneShot(IOException iOException, Request request) {
        boolean bl = (request = request.body()) != null && request.isOneShot() || iOException instanceof FileNotFoundException;
        return bl;
    }

    private final int retryAfter(Response object, int n) {
        String string = Response.header$default((Response)object, (String)"Retry-After", null, (int)2, null);
        if (string == null) {
            return n;
        }
        object = string;
        if (!new Regex("\\d+").matches((CharSequence)object)) return Integer.MAX_VALUE;
        object = Integer.valueOf(string);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"valueOf(header)");
        return ((Number)object).intValue();
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    public Response intercept(Interceptor.Chain object) throws IOException {
        Intrinsics.checkNotNullParameter((Object)object, (String)"chain");
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain)object;
        Request request = realInterceptorChain.getRequest$okhttp();
        RealCall realCall = realInterceptorChain.getCall$okhttp();
        List list = CollectionsKt.emptyList();
        Exchange exchange = null;
        boolean bl = true;
        int n = 0;
        while (true) {
            void var1_11;
            block16: {
                void var1_5;
                block15: {
                    block14: {
                        Response response;
                        realCall.enterNetworkInterceptorExchange(request, bl);
                        bl = realCall.isCanceled();
                        if (bl) break;
                        Response response2 = response = realInterceptorChain.proceed(request);
                        if (exchange == null) break block14;
                        Response response3 = response.newBuilder().priorResponse(exchange.newBuilder().body(null).build()).build();
                    }
                    if ((request = this.followUpRequest((Response)var1_5, exchange = realCall.getInterceptorScopedExchange$okhttp())) == null) {
                        if (exchange != null && exchange.isDuplex$okhttp()) {
                            realCall.timeoutEarlyExit();
                        }
                        realCall.exitNetworkInterceptorExchange$okhttp(false);
                        return var1_5;
                    }
                    exchange = request.body();
                    if (exchange == null || !(bl = exchange.isOneShot())) break block15;
                    realCall.exitNetworkInterceptorExchange$okhttp(false);
                    return var1_5;
                }
                exchange = var1_5.body();
                if (exchange != null) {
                    Util.closeQuietly((Closeable)((Closeable)exchange));
                }
                if (++n > 20) break block16;
                bl = true;
                exchange = var1_5;
                continue;
            }
            ProtocolException protocolException = new ProtocolException(Intrinsics.stringPlus((String)"Too many follow-up requests: ", (Object)n));
            throw protocolException;
            catch (IOException iOException) {
                bl = !(iOException instanceof ConnectionShutdownException);
                if (!this.recover(iOException, realCall, request, bl)) throw Util.withSuppressed((Exception)iOException, (List)list);
                List list2 = CollectionsKt.plus((Collection)list, (Object)iOException);
            }
            catch (RouteException routeException) {
                if (!this.recover(routeException.getLastConnectException(), realCall, request, false)) throw Util.withSuppressed((Exception)routeException.getFirstConnectException(), (List)list);
                List list3 = CollectionsKt.plus((Collection)list, (Object)routeException.getFirstConnectException());
            }
            bl = false;
            list = var1_11;
        }
        {
            IOException iOException = new IOException("Canceled");
            throw iOException;
        }
        catch (Throwable throwable) {
            throw throwable;
        }
        {
            finally {
                realCall.exitNetworkInterceptorExchange$okhttp(true);
            }
        }
    }
}
