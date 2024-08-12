/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.Authenticator
 *  okhttp3.Cache
 *  okhttp3.Call
 *  okhttp3.Call$Factory
 *  okhttp3.CertificatePinner
 *  okhttp3.ConnectionPool
 *  okhttp3.ConnectionSpec
 *  okhttp3.CookieJar
 *  okhttp3.Dispatcher
 *  okhttp3.Dns
 *  okhttp3.EventListener$Factory
 *  okhttp3.Interceptor
 *  okhttp3.OkHttpClient$Builder
 *  okhttp3.OkHttpClient$Companion
 *  okhttp3.Protocol
 *  okhttp3.Request
 *  okhttp3.WebSocket
 *  okhttp3.WebSocket$Factory
 *  okhttp3.WebSocketListener
 *  okhttp3.internal.Util
 *  okhttp3.internal.concurrent.TaskRunner
 *  okhttp3.internal.connection.RealCall
 *  okhttp3.internal.connection.RouteDatabase
 *  okhttp3.internal.platform.Platform
 *  okhttp3.internal.proxy.NullProxySelector
 *  okhttp3.internal.tls.CertificateChainCleaner
 *  okhttp3.internal.ws.RealWebSocket
 */
package okhttp3;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Authenticator;
import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.CertificatePinner;
import okhttp3.ConnectionPool;
import okhttp3.ConnectionSpec;
import okhttp3.CookieJar;
import okhttp3.Dispatcher;
import okhttp3.Dns;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RouteDatabase;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.proxy.NullProxySelector;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.ws.RealWebSocket;

@Metadata(d1={"\u0000\u00ee\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 y2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002xyB\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0004B\u000f\b\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\r\u0010\b\u001a\u00020\tH\u0007\u00a2\u0006\u0002\bSJ\u000f\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007\u00a2\u0006\u0002\bTJ\r\u0010\u000e\u001a\u00020\u000fH\u0007\u00a2\u0006\u0002\bUJ\r\u0010\u0014\u001a\u00020\u0015H\u0007\u00a2\u0006\u0002\bVJ\r\u0010\u0017\u001a\u00020\u000fH\u0007\u00a2\u0006\u0002\bWJ\r\u0010\u0018\u001a\u00020\u0019H\u0007\u00a2\u0006\u0002\bXJ\u0013\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0007\u00a2\u0006\u0002\bYJ\r\u0010\u001f\u001a\u00020 H\u0007\u00a2\u0006\u0002\bZJ\r\u0010\"\u001a\u00020#H\u0007\u00a2\u0006\u0002\b[J\r\u0010%\u001a\u00020&H\u0007\u00a2\u0006\u0002\b\\J\r\u0010(\u001a\u00020)H\u0007\u00a2\u0006\u0002\b]J\r\u0010+\u001a\u00020,H\u0007\u00a2\u0006\u0002\b^J\r\u0010.\u001a\u00020,H\u0007\u00a2\u0006\u0002\b_J\r\u0010/\u001a\u000200H\u0007\u00a2\u0006\u0002\b`J\u0013\u00102\u001a\b\u0012\u0004\u0012\u0002030\u001cH\u0007\u00a2\u0006\u0002\baJ\u0013\u00107\u001a\b\u0012\u0004\u0012\u0002030\u001cH\u0007\u00a2\u0006\u0002\bbJ\b\u0010c\u001a\u00020\u0006H\u0016J\u0010\u0010d\u001a\u00020e2\u0006\u0010f\u001a\u00020gH\u0016J\u0018\u0010h\u001a\u00020i2\u0006\u0010f\u001a\u00020g2\u0006\u0010j\u001a\u00020kH\u0016J\r\u00108\u001a\u00020\u000fH\u0007\u00a2\u0006\u0002\blJ\u0013\u00109\u001a\b\u0012\u0004\u0012\u00020:0\u001cH\u0007\u00a2\u0006\u0002\bmJ\u000f\u0010;\u001a\u0004\u0018\u00010<H\u0007\u00a2\u0006\u0002\bnJ\r\u0010>\u001a\u00020\tH\u0007\u00a2\u0006\u0002\boJ\r\u0010?\u001a\u00020@H\u0007\u00a2\u0006\u0002\bpJ\r\u0010B\u001a\u00020\u000fH\u0007\u00a2\u0006\u0002\bqJ\r\u0010C\u001a\u00020,H\u0007\u00a2\u0006\u0002\brJ\r\u0010H\u001a\u00020IH\u0007\u00a2\u0006\u0002\bsJ\r\u0010K\u001a\u00020LH\u0007\u00a2\u0006\u0002\btJ\b\u0010u\u001a\u00020vH\u0002J\r\u0010O\u001a\u00020\u000fH\u0007\u00a2\u0006\u0002\bwR\u0013\u0010\b\u001a\u00020\t8G\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\nR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f8G\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\rR\u0013\u0010\u000e\u001a\u00020\u000f8G\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0010R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u00128G\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0013R\u0013\u0010\u0014\u001a\u00020\u00158G\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0016R\u0013\u0010\u0017\u001a\u00020\u000f8G\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0013\u0010\u0018\u001a\u00020\u00198G\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u001aR\u0019\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8G\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001eR\u0013\u0010\u001f\u001a\u00020 8G\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010!R\u0013\u0010\"\u001a\u00020#8G\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010$R\u0013\u0010%\u001a\u00020&8G\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010'R\u0013\u0010(\u001a\u00020)8G\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010*R\u0013\u0010+\u001a\u00020,8G\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010-R\u0013\u0010.\u001a\u00020,8G\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010-R\u0013\u0010/\u001a\u0002008G\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u00101R\u0019\u00102\u001a\b\u0012\u0004\u0012\u0002030\u001c8G\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001eR\u0013\u00104\u001a\u0002058G\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u00106R\u0019\u00107\u001a\b\u0012\u0004\u0012\u0002030\u001c8G\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u0010\u001eR\u0013\u00108\u001a\u00020\u000f8G\u00a2\u0006\b\n\u0000\u001a\u0004\b8\u0010\u0010R\u0019\u00109\u001a\b\u0012\u0004\u0012\u00020:0\u001c8G\u00a2\u0006\b\n\u0000\u001a\u0004\b9\u0010\u001eR\u0015\u0010;\u001a\u0004\u0018\u00010<8G\u00a2\u0006\b\n\u0000\u001a\u0004\b;\u0010=R\u0013\u0010>\u001a\u00020\t8G\u00a2\u0006\b\n\u0000\u001a\u0004\b>\u0010\nR\u0013\u0010?\u001a\u00020@8G\u00a2\u0006\b\n\u0000\u001a\u0004\b?\u0010AR\u0013\u0010B\u001a\u00020\u000f8G\u00a2\u0006\b\n\u0000\u001a\u0004\bB\u0010\u0010R\u0013\u0010C\u001a\u00020,8G\u00a2\u0006\b\n\u0000\u001a\u0004\bC\u0010-R\u0011\u0010D\u001a\u00020E\u00a2\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u0013\u0010H\u001a\u00020I8G\u00a2\u0006\b\n\u0000\u001a\u0004\bH\u0010JR\u0011\u0010K\u001a\u00020L8G\u00a2\u0006\u0006\u001a\u0004\bK\u0010MR\u0010\u0010N\u001a\u0004\u0018\u00010LX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0013\u0010O\u001a\u00020\u000f8G\u00a2\u0006\b\n\u0000\u001a\u0004\bO\u0010\u0010R\u0015\u0010P\u001a\u0004\u0018\u00010Q8G\u00a2\u0006\b\n\u0000\u001a\u0004\bP\u0010R\u00a8\u0006z"}, d2={"Lokhttp3/OkHttpClient;", "", "Lokhttp3/Call$Factory;", "Lokhttp3/WebSocket$Factory;", "()V", "builder", "Lokhttp3/OkHttpClient$Builder;", "(Lokhttp3/OkHttpClient$Builder;)V", "authenticator", "Lokhttp3/Authenticator;", "()Lokhttp3/Authenticator;", "cache", "Lokhttp3/Cache;", "()Lokhttp3/Cache;", "callTimeoutMillis", "", "()I", "certificateChainCleaner", "Lokhttp3/internal/tls/CertificateChainCleaner;", "()Lokhttp3/internal/tls/CertificateChainCleaner;", "certificatePinner", "Lokhttp3/CertificatePinner;", "()Lokhttp3/CertificatePinner;", "connectTimeoutMillis", "connectionPool", "Lokhttp3/ConnectionPool;", "()Lokhttp3/ConnectionPool;", "connectionSpecs", "", "Lokhttp3/ConnectionSpec;", "()Ljava/util/List;", "cookieJar", "Lokhttp3/CookieJar;", "()Lokhttp3/CookieJar;", "dispatcher", "Lokhttp3/Dispatcher;", "()Lokhttp3/Dispatcher;", "dns", "Lokhttp3/Dns;", "()Lokhttp3/Dns;", "eventListenerFactory", "Lokhttp3/EventListener$Factory;", "()Lokhttp3/EventListener$Factory;", "followRedirects", "", "()Z", "followSslRedirects", "hostnameVerifier", "Ljavax/net/ssl/HostnameVerifier;", "()Ljavax/net/ssl/HostnameVerifier;", "interceptors", "Lokhttp3/Interceptor;", "minWebSocketMessageToCompress", "", "()J", "networkInterceptors", "pingIntervalMillis", "protocols", "Lokhttp3/Protocol;", "proxy", "Ljava/net/Proxy;", "()Ljava/net/Proxy;", "proxyAuthenticator", "proxySelector", "Ljava/net/ProxySelector;", "()Ljava/net/ProxySelector;", "readTimeoutMillis", "retryOnConnectionFailure", "routeDatabase", "Lokhttp3/internal/connection/RouteDatabase;", "getRouteDatabase", "()Lokhttp3/internal/connection/RouteDatabase;", "socketFactory", "Ljavax/net/SocketFactory;", "()Ljavax/net/SocketFactory;", "sslSocketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "()Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactoryOrNull", "writeTimeoutMillis", "x509TrustManager", "Ljavax/net/ssl/X509TrustManager;", "()Ljavax/net/ssl/X509TrustManager;", "-deprecated_authenticator", "-deprecated_cache", "-deprecated_callTimeoutMillis", "-deprecated_certificatePinner", "-deprecated_connectTimeoutMillis", "-deprecated_connectionPool", "-deprecated_connectionSpecs", "-deprecated_cookieJar", "-deprecated_dispatcher", "-deprecated_dns", "-deprecated_eventListenerFactory", "-deprecated_followRedirects", "-deprecated_followSslRedirects", "-deprecated_hostnameVerifier", "-deprecated_interceptors", "-deprecated_networkInterceptors", "newBuilder", "newCall", "Lokhttp3/Call;", "request", "Lokhttp3/Request;", "newWebSocket", "Lokhttp3/WebSocket;", "listener", "Lokhttp3/WebSocketListener;", "-deprecated_pingIntervalMillis", "-deprecated_protocols", "-deprecated_proxy", "-deprecated_proxyAuthenticator", "-deprecated_proxySelector", "-deprecated_readTimeoutMillis", "-deprecated_retryOnConnectionFailure", "-deprecated_socketFactory", "-deprecated_sslSocketFactory", "verifyClientState", "", "-deprecated_writeTimeoutMillis", "Builder", "Companion", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public class OkHttpClient
implements Cloneable,
Call.Factory,
WebSocket.Factory {
    public static final Companion Companion = new Companion(null);
    private static final List<ConnectionSpec> DEFAULT_CONNECTION_SPECS;
    private static final List<Protocol> DEFAULT_PROTOCOLS;
    private final Authenticator authenticator;
    private final Cache cache;
    private final int callTimeoutMillis;
    private final CertificateChainCleaner certificateChainCleaner;
    private final CertificatePinner certificatePinner;
    private final int connectTimeoutMillis;
    private final ConnectionPool connectionPool;
    private final List<ConnectionSpec> connectionSpecs;
    private final CookieJar cookieJar;
    private final Dispatcher dispatcher;
    private final Dns dns;
    private final EventListener.Factory eventListenerFactory;
    private final boolean followRedirects;
    private final boolean followSslRedirects;
    private final HostnameVerifier hostnameVerifier;
    private final List<Interceptor> interceptors;
    private final long minWebSocketMessageToCompress;
    private final List<Interceptor> networkInterceptors;
    private final int pingIntervalMillis;
    private final List<Protocol> protocols;
    private final Proxy proxy;
    private final Authenticator proxyAuthenticator;
    private final ProxySelector proxySelector;
    private final int readTimeoutMillis;
    private final boolean retryOnConnectionFailure;
    private final RouteDatabase routeDatabase;
    private final SocketFactory socketFactory;
    private final SSLSocketFactory sslSocketFactoryOrNull;
    private final int writeTimeoutMillis;
    private final X509TrustManager x509TrustManager;

    static {
        DEFAULT_PROTOCOLS = Util.immutableListOf((Object[])new Protocol[]{Protocol.HTTP_2, Protocol.HTTP_1_1});
        DEFAULT_CONNECTION_SPECS = Util.immutableListOf((Object[])new ConnectionSpec[]{ConnectionSpec.MODERN_TLS, ConnectionSpec.CLEARTEXT});
    }

    public OkHttpClient() {
        this(new Builder());
    }

    public OkHttpClient(Builder builder) {
        boolean bl;
        Object object;
        Object object2;
        block12: {
            Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
            this.dispatcher = builder.getDispatcher$okhttp();
            this.connectionPool = builder.getConnectionPool$okhttp();
            this.interceptors = Util.toImmutableList((List)builder.getInterceptors$okhttp());
            this.networkInterceptors = Util.toImmutableList((List)builder.getNetworkInterceptors$okhttp());
            this.eventListenerFactory = builder.getEventListenerFactory$okhttp();
            this.retryOnConnectionFailure = builder.getRetryOnConnectionFailure$okhttp();
            this.authenticator = builder.getAuthenticator$okhttp();
            this.followRedirects = builder.getFollowRedirects$okhttp();
            this.followSslRedirects = builder.getFollowSslRedirects$okhttp();
            this.cookieJar = builder.getCookieJar$okhttp();
            this.cache = builder.getCache$okhttp();
            this.dns = builder.getDns$okhttp();
            this.proxy = builder.getProxy$okhttp();
            if (builder.getProxy$okhttp() != null) {
                object2 = (ProxySelector)NullProxySelector.INSTANCE;
            } else {
                object2 = builder.getProxySelector$okhttp();
                object = object2;
                if (object2 == null) {
                    object = ProxySelector.getDefault();
                }
                object2 = object;
                if (object == null) {
                    object2 = (ProxySelector)NullProxySelector.INSTANCE;
                }
            }
            this.proxySelector = object2;
            this.proxyAuthenticator = builder.getProxyAuthenticator$okhttp();
            this.socketFactory = builder.getSocketFactory$okhttp();
            this.connectionSpecs = builder.getConnectionSpecs$okhttp();
            this.protocols = builder.getProtocols$okhttp();
            this.hostnameVerifier = builder.getHostnameVerifier$okhttp();
            this.callTimeoutMillis = builder.getCallTimeout$okhttp();
            this.connectTimeoutMillis = builder.getConnectTimeout$okhttp();
            this.readTimeoutMillis = builder.getReadTimeout$okhttp();
            this.writeTimeoutMillis = builder.getWriteTimeout$okhttp();
            this.pingIntervalMillis = builder.getPingInterval$okhttp();
            this.minWebSocketMessageToCompress = builder.getMinWebSocketMessageToCompress$okhttp();
            object2 = builder.getRouteDatabase$okhttp();
            object = object2;
            if (object2 == null) {
                object = new RouteDatabase();
            }
            this.routeDatabase = object;
            object = this.connectionSpecs;
            boolean bl2 = object instanceof Collection;
            boolean bl3 = true;
            if (bl2 && ((Collection)object).isEmpty()) {
                bl = bl3;
            } else {
                object = object.iterator();
                do {
                    bl = bl3;
                    if (!object.hasNext()) break block12;
                } while (!((ConnectionSpec)object.next()).isTls());
                bl = false;
            }
        }
        if (bl) {
            this.sslSocketFactoryOrNull = null;
            this.certificateChainCleaner = null;
            this.x509TrustManager = null;
            this.certificatePinner = CertificatePinner.DEFAULT;
        } else if (builder.getSslSocketFactoryOrNull$okhttp() != null) {
            this.sslSocketFactoryOrNull = builder.getSslSocketFactoryOrNull$okhttp();
            object = builder.getCertificateChainCleaner$okhttp();
            Intrinsics.checkNotNull((Object)object);
            this.certificateChainCleaner = object;
            object = builder.getX509TrustManagerOrNull$okhttp();
            Intrinsics.checkNotNull((Object)object);
            this.x509TrustManager = object;
            builder = builder.getCertificatePinner$okhttp();
            object = this.certificateChainCleaner;
            Intrinsics.checkNotNull((Object)object);
            this.certificatePinner = builder.withCertificateChainCleaner$okhttp(object);
        } else {
            this.x509TrustManager = Platform.Companion.get().platformTrustManager();
            object = Platform.Companion.get();
            object2 = this.x509TrustManager;
            Intrinsics.checkNotNull((Object)object2);
            this.sslSocketFactoryOrNull = object.newSslSocketFactory((X509TrustManager)object2);
            object2 = CertificateChainCleaner.Companion;
            object = this.x509TrustManager;
            Intrinsics.checkNotNull((Object)object);
            this.certificateChainCleaner = object2.get((X509TrustManager)object);
            builder = builder.getCertificatePinner$okhttp();
            object = this.certificateChainCleaner;
            Intrinsics.checkNotNull((Object)object);
            this.certificatePinner = builder.withCertificateChainCleaner$okhttp(object);
        }
        this.verifyClientState();
    }

    public static final /* synthetic */ List access$getDEFAULT_CONNECTION_SPECS$cp() {
        return DEFAULT_CONNECTION_SPECS;
    }

    public static final /* synthetic */ List access$getDEFAULT_PROTOCOLS$cp() {
        return DEFAULT_PROTOCOLS;
    }

    public static final /* synthetic */ SSLSocketFactory access$getSslSocketFactoryOrNull$p(OkHttpClient okHttpClient) {
        return okHttpClient.sslSocketFactoryOrNull;
    }

    private final void verifyClientState() {
        boolean bl;
        boolean bl2 = this.interceptors.contains(null);
        boolean bl3 = true;
        if (!(bl2 ^ true)) {
            Throwable throwable = new IllegalStateException(Intrinsics.stringPlus((String)"Null interceptor: ", this.interceptors()).toString());
            throw throwable;
        }
        if (!(this.networkInterceptors.contains(null) ^ true)) throw (Throwable)new IllegalStateException(Intrinsics.stringPlus((String)"Null network interceptor: ", this.networkInterceptors()).toString());
        Object object = this.connectionSpecs;
        if (!(object instanceof Collection) || !((Collection)object).isEmpty()) {
            object = object.iterator();
            while (object.hasNext()) {
                if (!((ConnectionSpec)object.next()).isTls()) continue;
                bl = false;
                break;
            }
        } else {
            bl = true;
        }
        if (bl) {
            bl = this.sslSocketFactoryOrNull == null;
            if (!bl) throw (Throwable)new IllegalStateException("Check failed.".toString());
            bl = this.certificateChainCleaner == null;
            if (!bl) throw (Throwable)new IllegalStateException("Check failed.".toString());
            bl = this.x509TrustManager == null ? bl3 : false;
            if (!bl) throw (Throwable)new IllegalStateException("Check failed.".toString());
            if (!Intrinsics.areEqual((Object)this.certificatePinner, (Object)CertificatePinner.DEFAULT)) throw (Throwable)new IllegalStateException("Check failed.".toString());
        } else {
            if (this.sslSocketFactoryOrNull == null) throw (Throwable)new IllegalStateException("sslSocketFactory == null".toString());
            if (this.certificateChainCleaner == null) throw (Throwable)new IllegalStateException("certificateChainCleaner == null".toString());
            if (this.x509TrustManager == null) throw (Throwable)new IllegalStateException("x509TrustManager == null".toString());
        }
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="authenticator", imports={}))
    public final Authenticator _deprecated_authenticator() {
        return this.authenticator;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="cache", imports={}))
    public final Cache _deprecated_cache() {
        return this.cache;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="callTimeoutMillis", imports={}))
    public final int _deprecated_callTimeoutMillis() {
        return this.callTimeoutMillis;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="certificatePinner", imports={}))
    public final CertificatePinner _deprecated_certificatePinner() {
        return this.certificatePinner;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="connectTimeoutMillis", imports={}))
    public final int _deprecated_connectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="connectionPool", imports={}))
    public final ConnectionPool _deprecated_connectionPool() {
        return this.connectionPool;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="connectionSpecs", imports={}))
    public final List<ConnectionSpec> _deprecated_connectionSpecs() {
        return this.connectionSpecs;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="cookieJar", imports={}))
    public final CookieJar _deprecated_cookieJar() {
        return this.cookieJar;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="dispatcher", imports={}))
    public final Dispatcher _deprecated_dispatcher() {
        return this.dispatcher;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="dns", imports={}))
    public final Dns _deprecated_dns() {
        return this.dns;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="eventListenerFactory", imports={}))
    public final EventListener.Factory _deprecated_eventListenerFactory() {
        return this.eventListenerFactory;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="followRedirects", imports={}))
    public final boolean _deprecated_followRedirects() {
        return this.followRedirects;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="followSslRedirects", imports={}))
    public final boolean _deprecated_followSslRedirects() {
        return this.followSslRedirects;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="hostnameVerifier", imports={}))
    public final HostnameVerifier _deprecated_hostnameVerifier() {
        return this.hostnameVerifier;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="interceptors", imports={}))
    public final List<Interceptor> _deprecated_interceptors() {
        return this.interceptors;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="networkInterceptors", imports={}))
    public final List<Interceptor> _deprecated_networkInterceptors() {
        return this.networkInterceptors;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="pingIntervalMillis", imports={}))
    public final int _deprecated_pingIntervalMillis() {
        return this.pingIntervalMillis;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="protocols", imports={}))
    public final List<Protocol> _deprecated_protocols() {
        return this.protocols;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="proxy", imports={}))
    public final Proxy _deprecated_proxy() {
        return this.proxy;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="proxyAuthenticator", imports={}))
    public final Authenticator _deprecated_proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="proxySelector", imports={}))
    public final ProxySelector _deprecated_proxySelector() {
        return this.proxySelector;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="readTimeoutMillis", imports={}))
    public final int _deprecated_readTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="retryOnConnectionFailure", imports={}))
    public final boolean _deprecated_retryOnConnectionFailure() {
        return this.retryOnConnectionFailure;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="socketFactory", imports={}))
    public final SocketFactory _deprecated_socketFactory() {
        return this.socketFactory;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="sslSocketFactory", imports={}))
    public final SSLSocketFactory _deprecated_sslSocketFactory() {
        return this.sslSocketFactory();
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="writeTimeoutMillis", imports={}))
    public final int _deprecated_writeTimeoutMillis() {
        return this.writeTimeoutMillis;
    }

    public final Authenticator authenticator() {
        return this.authenticator;
    }

    public final Cache cache() {
        return this.cache;
    }

    public final int callTimeoutMillis() {
        return this.callTimeoutMillis;
    }

    public final CertificateChainCleaner certificateChainCleaner() {
        return this.certificateChainCleaner;
    }

    public final CertificatePinner certificatePinner() {
        return this.certificatePinner;
    }

    public Object clone() {
        return super.clone();
    }

    public final int connectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    public final ConnectionPool connectionPool() {
        return this.connectionPool;
    }

    public final List<ConnectionSpec> connectionSpecs() {
        return this.connectionSpecs;
    }

    public final CookieJar cookieJar() {
        return this.cookieJar;
    }

    public final Dispatcher dispatcher() {
        return this.dispatcher;
    }

    public final Dns dns() {
        return this.dns;
    }

    public final EventListener.Factory eventListenerFactory() {
        return this.eventListenerFactory;
    }

    public final boolean followRedirects() {
        return this.followRedirects;
    }

    public final boolean followSslRedirects() {
        return this.followSslRedirects;
    }

    public final RouteDatabase getRouteDatabase() {
        return this.routeDatabase;
    }

    public final HostnameVerifier hostnameVerifier() {
        return this.hostnameVerifier;
    }

    public final List<Interceptor> interceptors() {
        return this.interceptors;
    }

    public final long minWebSocketMessageToCompress() {
        return this.minWebSocketMessageToCompress;
    }

    public final List<Interceptor> networkInterceptors() {
        return this.networkInterceptors;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    public Call newCall(Request request) {
        Intrinsics.checkNotNullParameter((Object)request, (String)"request");
        return (Call)new RealCall(this, request, false);
    }

    public WebSocket newWebSocket(Request request, WebSocketListener webSocketListener) {
        Intrinsics.checkNotNullParameter((Object)request, (String)"request");
        Intrinsics.checkNotNullParameter((Object)webSocketListener, (String)"listener");
        request = new RealWebSocket(TaskRunner.INSTANCE, request, webSocketListener, new Random(), (long)this.pingIntervalMillis, null, this.minWebSocketMessageToCompress);
        request.connect(this);
        return (WebSocket)request;
    }

    public final int pingIntervalMillis() {
        return this.pingIntervalMillis;
    }

    public final List<Protocol> protocols() {
        return this.protocols;
    }

    public final Proxy proxy() {
        return this.proxy;
    }

    public final Authenticator proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    public final ProxySelector proxySelector() {
        return this.proxySelector;
    }

    public final int readTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    public final boolean retryOnConnectionFailure() {
        return this.retryOnConnectionFailure;
    }

    public final SocketFactory socketFactory() {
        return this.socketFactory;
    }

    public final SSLSocketFactory sslSocketFactory() {
        SSLSocketFactory sSLSocketFactory = this.sslSocketFactoryOrNull;
        if (sSLSocketFactory == null) throw new IllegalStateException("CLEARTEXT-only client");
        return sSLSocketFactory;
    }

    public final int writeTimeoutMillis() {
        return this.writeTimeoutMillis;
    }

    public final X509TrustManager x509TrustManager() {
        return this.x509TrustManager;
    }
}
