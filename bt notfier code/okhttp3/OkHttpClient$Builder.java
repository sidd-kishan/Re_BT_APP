/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.Authenticator
 *  okhttp3.Cache
 *  okhttp3.CertificatePinner
 *  okhttp3.ConnectionPool
 *  okhttp3.ConnectionSpec
 *  okhttp3.CookieJar
 *  okhttp3.Dispatcher
 *  okhttp3.Dns
 *  okhttp3.EventListener
 *  okhttp3.EventListener$Factory
 *  okhttp3.Interceptor
 *  okhttp3.Interceptor$Chain
 *  okhttp3.OkHttpClient
 *  okhttp3.Protocol
 *  okhttp3.Response
 *  okhttp3.internal.Util
 *  okhttp3.internal.connection.RouteDatabase
 *  okhttp3.internal.platform.Platform
 *  okhttp3.internal.tls.CertificateChainCleaner
 *  okhttp3.internal.tls.OkHostnameVerifier
 */
package okhttp3;

import java.net.Proxy;
import java.net.ProxySelector;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Authenticator;
import okhttp3.Cache;
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
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RouteDatabase;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.OkHostnameVerifier;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000\u00f8\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J?\u0010\u009e\u0001\u001a\u00020\u00002*\b\u0004\u0010\u009f\u0001\u001a#\u0012\u0017\u0012\u00150\u00a1\u0001\u00a2\u0006\u000f\b\u00a2\u0001\u0012\n\b\u00a3\u0001\u0012\u0005\b\b(\u00a4\u0001\u0012\u0005\u0012\u00030\u00a5\u00010\u00a0\u0001H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0003\b\u00a6\u0001J\u0010\u0010\u009e\u0001\u001a\u00020\u00002\u0007\u0010\u00a7\u0001\u001a\u00020]J?\u0010\u00a8\u0001\u001a\u00020\u00002*\b\u0004\u0010\u009f\u0001\u001a#\u0012\u0017\u0012\u00150\u00a1\u0001\u00a2\u0006\u000f\b\u00a2\u0001\u0012\n\b\u00a3\u0001\u0012\u0005\b\b(\u00a4\u0001\u0012\u0005\u0012\u00030\u00a5\u00010\u00a0\u0001H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0003\b\u00a9\u0001J\u0010\u0010\u00a8\u0001\u001a\u00020\u00002\u0007\u0010\u00a7\u0001\u001a\u00020]J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007J\u0007\u0010\u00aa\u0001\u001a\u00020\u0003J\u0010\u0010\f\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0012\u0010\u0012\u001a\u00020\u00002\b\u0010\u00ab\u0001\u001a\u00030\u00ac\u0001H\u0007J\u0019\u0010\u0012\u001a\u00020\u00002\u0007\u0010\u00ad\u0001\u001a\u00020`2\b\u0010\u00ae\u0001\u001a\u00030\u00af\u0001J\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001fJ\u0012\u0010$\u001a\u00020\u00002\b\u0010\u00ab\u0001\u001a\u00030\u00ac\u0001H\u0007J\u0019\u0010$\u001a\u00020\u00002\u0007\u0010\u00ad\u0001\u001a\u00020`2\b\u0010\u00ae\u0001\u001a\u00030\u00af\u0001J\u000e\u0010'\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(J\u0014\u0010-\u001a\u00020\u00002\f\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.J\u000e\u00104\u001a\u00020\u00002\u0006\u00104\u001a\u000205J\u000e\u0010:\u001a\u00020\u00002\u0006\u0010:\u001a\u00020;J\u000e\u0010@\u001a\u00020\u00002\u0006\u0010@\u001a\u00020AJ\u0011\u0010\u00b0\u0001\u001a\u00020\u00002\b\u0010\u00b0\u0001\u001a\u00030\u00b1\u0001J\u000e\u0010F\u001a\u00020\u00002\u0006\u0010F\u001a\u00020GJ\u000e\u0010L\u001a\u00020\u00002\u0006\u0010L\u001a\u00020MJ\u000f\u0010R\u001a\u00020\u00002\u0007\u0010\u00b2\u0001\u001a\u00020MJ\u000e\u0010U\u001a\u00020\u00002\u0006\u0010U\u001a\u00020VJ\f\u0010[\u001a\b\u0012\u0004\u0012\u00020]0\\J\u000f\u0010_\u001a\u00020\u00002\u0007\u0010\u00b3\u0001\u001a\u00020`J\f\u0010e\u001a\b\u0012\u0004\u0012\u00020]0\\J\u0012\u0010g\u001a\u00020\u00002\b\u0010\u00ab\u0001\u001a\u00030\u00ac\u0001H\u0007J\u0019\u0010g\u001a\u00020\u00002\u0007\u0010\u00b4\u0001\u001a\u00020`2\b\u0010\u00ae\u0001\u001a\u00030\u00af\u0001J\u0014\u0010j\u001a\u00020\u00002\f\u0010j\u001a\b\u0012\u0004\u0012\u00020k0.J\u0010\u0010n\u001a\u00020\u00002\b\u0010n\u001a\u0004\u0018\u00010oJ\u000e\u0010t\u001a\u00020\u00002\u0006\u0010t\u001a\u00020\u0007J\u000e\u0010w\u001a\u00020\u00002\u0006\u0010w\u001a\u00020xJ\u0012\u0010}\u001a\u00020\u00002\b\u0010\u00ab\u0001\u001a\u00030\u00ac\u0001H\u0007J\u0019\u0010}\u001a\u00020\u00002\u0007\u0010\u00ad\u0001\u001a\u00020`2\b\u0010\u00ae\u0001\u001a\u00030\u00af\u0001J\u0010\u0010\u0080\u0001\u001a\u00020\u00002\u0007\u0010\u0080\u0001\u001a\u00020MJ\u0011\u0010\u0089\u0001\u001a\u00020\u00002\b\u0010\u0089\u0001\u001a\u00030\u008a\u0001J\u0013\u0010\u00b5\u0001\u001a\u00020\u00002\b\u0010\u00b5\u0001\u001a\u00030\u0090\u0001H\u0007J\u001b\u0010\u00b5\u0001\u001a\u00020\u00002\b\u0010\u00b5\u0001\u001a\u00030\u0090\u00012\b\u0010\u00b6\u0001\u001a\u00030\u0099\u0001J\u0013\u0010\u0095\u0001\u001a\u00020\u00002\b\u0010\u00ab\u0001\u001a\u00030\u00ac\u0001H\u0007J\u001a\u0010\u0095\u0001\u001a\u00020\u00002\u0007\u0010\u00ad\u0001\u001a\u00020`2\b\u0010\u00ae\u0001\u001a\u00030\u00af\u0001R\u001a\u0010\u0006\u001a\u00020\u0007X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u0013X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0015\"\u0004\b&\u0010\u0017R\u001a\u0010'\u001a\u00020(X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R \u0010-\u001a\b\u0012\u0004\u0012\u00020/0.X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u00104\u001a\u000205X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001a\u0010:\u001a\u00020;X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001a\u0010@\u001a\u00020AX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001a\u0010F\u001a\u00020GX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001a\u0010L\u001a\u00020MX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u001a\u0010R\u001a\u00020MX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bS\u0010O\"\u0004\bT\u0010QR\u001a\u0010U\u001a\u00020VX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u001a\u0010[\u001a\b\u0012\u0004\u0012\u00020]0\\X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b^\u00101R\u001a\u0010_\u001a\u00020`X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\u001a\u0010e\u001a\b\u0012\u0004\u0012\u00020]0\\X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bf\u00101R\u001a\u0010g\u001a\u00020\u0013X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bh\u0010\u0015\"\u0004\bi\u0010\u0017R \u0010j\u001a\b\u0012\u0004\u0012\u00020k0.X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bl\u00101\"\u0004\bm\u00103R\u001c\u0010n\u001a\u0004\u0018\u00010oX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR\u001a\u0010t\u001a\u00020\u0007X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bu\u0010\t\"\u0004\bv\u0010\u000bR\u001c\u0010w\u001a\u0004\u0018\u00010xX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\by\u0010z\"\u0004\b{\u0010|R\u001a\u0010}\u001a\u00020\u0013X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b~\u0010\u0015\"\u0004\b\u007f\u0010\u0017R\u001d\u0010\u0080\u0001\u001a\u00020MX\u0080\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0081\u0001\u0010O\"\u0005\b\u0082\u0001\u0010QR\"\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0084\u0001X\u0080\u000e\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001\"\u0006\b\u0087\u0001\u0010\u0088\u0001R \u0010\u0089\u0001\u001a\u00030\u008a\u0001X\u0080\u000e\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001\"\u0006\b\u008d\u0001\u0010\u008e\u0001R\"\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u0090\u0001X\u0080\u000e\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001\"\u0006\b\u0093\u0001\u0010\u0094\u0001R\u001d\u0010\u0095\u0001\u001a\u00020\u0013X\u0080\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0096\u0001\u0010\u0015\"\u0005\b\u0097\u0001\u0010\u0017R\"\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0099\u0001X\u0080\u000e\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001\"\u0006\b\u009c\u0001\u0010\u009d\u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u00b7\u0001"}, d2={"Lokhttp3/OkHttpClient$Builder;", "", "okHttpClient", "Lokhttp3/OkHttpClient;", "(Lokhttp3/OkHttpClient;)V", "()V", "authenticator", "Lokhttp3/Authenticator;", "getAuthenticator$okhttp", "()Lokhttp3/Authenticator;", "setAuthenticator$okhttp", "(Lokhttp3/Authenticator;)V", "cache", "Lokhttp3/Cache;", "getCache$okhttp", "()Lokhttp3/Cache;", "setCache$okhttp", "(Lokhttp3/Cache;)V", "callTimeout", "", "getCallTimeout$okhttp", "()I", "setCallTimeout$okhttp", "(I)V", "certificateChainCleaner", "Lokhttp3/internal/tls/CertificateChainCleaner;", "getCertificateChainCleaner$okhttp", "()Lokhttp3/internal/tls/CertificateChainCleaner;", "setCertificateChainCleaner$okhttp", "(Lokhttp3/internal/tls/CertificateChainCleaner;)V", "certificatePinner", "Lokhttp3/CertificatePinner;", "getCertificatePinner$okhttp", "()Lokhttp3/CertificatePinner;", "setCertificatePinner$okhttp", "(Lokhttp3/CertificatePinner;)V", "connectTimeout", "getConnectTimeout$okhttp", "setConnectTimeout$okhttp", "connectionPool", "Lokhttp3/ConnectionPool;", "getConnectionPool$okhttp", "()Lokhttp3/ConnectionPool;", "setConnectionPool$okhttp", "(Lokhttp3/ConnectionPool;)V", "connectionSpecs", "", "Lokhttp3/ConnectionSpec;", "getConnectionSpecs$okhttp", "()Ljava/util/List;", "setConnectionSpecs$okhttp", "(Ljava/util/List;)V", "cookieJar", "Lokhttp3/CookieJar;", "getCookieJar$okhttp", "()Lokhttp3/CookieJar;", "setCookieJar$okhttp", "(Lokhttp3/CookieJar;)V", "dispatcher", "Lokhttp3/Dispatcher;", "getDispatcher$okhttp", "()Lokhttp3/Dispatcher;", "setDispatcher$okhttp", "(Lokhttp3/Dispatcher;)V", "dns", "Lokhttp3/Dns;", "getDns$okhttp", "()Lokhttp3/Dns;", "setDns$okhttp", "(Lokhttp3/Dns;)V", "eventListenerFactory", "Lokhttp3/EventListener$Factory;", "getEventListenerFactory$okhttp", "()Lokhttp3/EventListener$Factory;", "setEventListenerFactory$okhttp", "(Lokhttp3/EventListener$Factory;)V", "followRedirects", "", "getFollowRedirects$okhttp", "()Z", "setFollowRedirects$okhttp", "(Z)V", "followSslRedirects", "getFollowSslRedirects$okhttp", "setFollowSslRedirects$okhttp", "hostnameVerifier", "Ljavax/net/ssl/HostnameVerifier;", "getHostnameVerifier$okhttp", "()Ljavax/net/ssl/HostnameVerifier;", "setHostnameVerifier$okhttp", "(Ljavax/net/ssl/HostnameVerifier;)V", "interceptors", "", "Lokhttp3/Interceptor;", "getInterceptors$okhttp", "minWebSocketMessageToCompress", "", "getMinWebSocketMessageToCompress$okhttp", "()J", "setMinWebSocketMessageToCompress$okhttp", "(J)V", "networkInterceptors", "getNetworkInterceptors$okhttp", "pingInterval", "getPingInterval$okhttp", "setPingInterval$okhttp", "protocols", "Lokhttp3/Protocol;", "getProtocols$okhttp", "setProtocols$okhttp", "proxy", "Ljava/net/Proxy;", "getProxy$okhttp", "()Ljava/net/Proxy;", "setProxy$okhttp", "(Ljava/net/Proxy;)V", "proxyAuthenticator", "getProxyAuthenticator$okhttp", "setProxyAuthenticator$okhttp", "proxySelector", "Ljava/net/ProxySelector;", "getProxySelector$okhttp", "()Ljava/net/ProxySelector;", "setProxySelector$okhttp", "(Ljava/net/ProxySelector;)V", "readTimeout", "getReadTimeout$okhttp", "setReadTimeout$okhttp", "retryOnConnectionFailure", "getRetryOnConnectionFailure$okhttp", "setRetryOnConnectionFailure$okhttp", "routeDatabase", "Lokhttp3/internal/connection/RouteDatabase;", "getRouteDatabase$okhttp", "()Lokhttp3/internal/connection/RouteDatabase;", "setRouteDatabase$okhttp", "(Lokhttp3/internal/connection/RouteDatabase;)V", "socketFactory", "Ljavax/net/SocketFactory;", "getSocketFactory$okhttp", "()Ljavax/net/SocketFactory;", "setSocketFactory$okhttp", "(Ljavax/net/SocketFactory;)V", "sslSocketFactoryOrNull", "Ljavax/net/ssl/SSLSocketFactory;", "getSslSocketFactoryOrNull$okhttp", "()Ljavax/net/ssl/SSLSocketFactory;", "setSslSocketFactoryOrNull$okhttp", "(Ljavax/net/ssl/SSLSocketFactory;)V", "writeTimeout", "getWriteTimeout$okhttp", "setWriteTimeout$okhttp", "x509TrustManagerOrNull", "Ljavax/net/ssl/X509TrustManager;", "getX509TrustManagerOrNull$okhttp", "()Ljavax/net/ssl/X509TrustManager;", "setX509TrustManagerOrNull$okhttp", "(Ljavax/net/ssl/X509TrustManager;)V", "addInterceptor", "block", "Lkotlin/Function1;", "Lokhttp3/Interceptor$Chain;", "Lkotlin/ParameterName;", "name", "chain", "Lokhttp3/Response;", "-addInterceptor", "interceptor", "addNetworkInterceptor", "-addNetworkInterceptor", "build", "duration", "Ljava/time/Duration;", "timeout", "unit", "Ljava/util/concurrent/TimeUnit;", "eventListener", "Lokhttp3/EventListener;", "followProtocolRedirects", "bytes", "interval", "sslSocketFactory", "trustManager", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class OkHttpClient.Builder {
    private Authenticator authenticator;
    private Cache cache;
    private int callTimeout;
    private CertificateChainCleaner certificateChainCleaner;
    private CertificatePinner certificatePinner;
    private int connectTimeout;
    private ConnectionPool connectionPool;
    private List<ConnectionSpec> connectionSpecs;
    private CookieJar cookieJar;
    private Dispatcher dispatcher;
    private Dns dns;
    private EventListener.Factory eventListenerFactory;
    private boolean followRedirects;
    private boolean followSslRedirects;
    private HostnameVerifier hostnameVerifier;
    private final List<Interceptor> interceptors;
    private long minWebSocketMessageToCompress;
    private final List<Interceptor> networkInterceptors;
    private int pingInterval;
    private List<? extends Protocol> protocols;
    private Proxy proxy;
    private Authenticator proxyAuthenticator;
    private ProxySelector proxySelector;
    private int readTimeout;
    private boolean retryOnConnectionFailure;
    private RouteDatabase routeDatabase;
    private SocketFactory socketFactory;
    private SSLSocketFactory sslSocketFactoryOrNull;
    private int writeTimeout;
    private X509TrustManager x509TrustManagerOrNull;

    public OkHttpClient.Builder() {
        this.dispatcher = new Dispatcher();
        this.connectionPool = new ConnectionPool();
        this.interceptors = new ArrayList();
        this.networkInterceptors = new ArrayList();
        this.eventListenerFactory = Util.asFactory((EventListener)EventListener.NONE);
        this.retryOnConnectionFailure = true;
        this.authenticator = Authenticator.NONE;
        this.followRedirects = true;
        this.followSslRedirects = true;
        this.cookieJar = CookieJar.NO_COOKIES;
        this.dns = Dns.SYSTEM;
        this.proxyAuthenticator = Authenticator.NONE;
        SocketFactory socketFactory = SocketFactory.getDefault();
        Intrinsics.checkNotNullExpressionValue((Object)socketFactory, (String)"getDefault()");
        this.socketFactory = socketFactory;
        this.connectionSpecs = OkHttpClient.Companion.getDEFAULT_CONNECTION_SPECS$okhttp();
        this.protocols = OkHttpClient.Companion.getDEFAULT_PROTOCOLS$okhttp();
        this.hostnameVerifier = (HostnameVerifier)OkHostnameVerifier.INSTANCE;
        this.certificatePinner = CertificatePinner.DEFAULT;
        this.connectTimeout = 10000;
        this.readTimeout = 10000;
        this.writeTimeout = 10000;
        this.minWebSocketMessageToCompress = 1024L;
    }

    public OkHttpClient.Builder(OkHttpClient okHttpClient) {
        Intrinsics.checkNotNullParameter((Object)okHttpClient, (String)"okHttpClient");
        this();
        this.dispatcher = okHttpClient.dispatcher();
        this.connectionPool = okHttpClient.connectionPool();
        CollectionsKt.addAll((Collection)this.interceptors, (Iterable)okHttpClient.interceptors());
        CollectionsKt.addAll((Collection)this.networkInterceptors, (Iterable)okHttpClient.networkInterceptors());
        this.eventListenerFactory = okHttpClient.eventListenerFactory();
        this.retryOnConnectionFailure = okHttpClient.retryOnConnectionFailure();
        this.authenticator = okHttpClient.authenticator();
        this.followRedirects = okHttpClient.followRedirects();
        this.followSslRedirects = okHttpClient.followSslRedirects();
        this.cookieJar = okHttpClient.cookieJar();
        this.cache = okHttpClient.cache();
        this.dns = okHttpClient.dns();
        this.proxy = okHttpClient.proxy();
        this.proxySelector = okHttpClient.proxySelector();
        this.proxyAuthenticator = okHttpClient.proxyAuthenticator();
        this.socketFactory = okHttpClient.socketFactory();
        this.sslSocketFactoryOrNull = OkHttpClient.access$getSslSocketFactoryOrNull$p((OkHttpClient)okHttpClient);
        this.x509TrustManagerOrNull = okHttpClient.x509TrustManager();
        this.connectionSpecs = okHttpClient.connectionSpecs();
        this.protocols = okHttpClient.protocols();
        this.hostnameVerifier = okHttpClient.hostnameVerifier();
        this.certificatePinner = okHttpClient.certificatePinner();
        this.certificateChainCleaner = okHttpClient.certificateChainCleaner();
        this.callTimeout = okHttpClient.callTimeoutMillis();
        this.connectTimeout = okHttpClient.connectTimeoutMillis();
        this.readTimeout = okHttpClient.readTimeoutMillis();
        this.writeTimeout = okHttpClient.writeTimeoutMillis();
        this.pingInterval = okHttpClient.pingIntervalMillis();
        this.minWebSocketMessageToCompress = okHttpClient.minWebSocketMessageToCompress();
        this.routeDatabase = okHttpClient.getRouteDatabase();
    }

    public final OkHttpClient.Builder _addInterceptor(Function1<? super Interceptor.Chain, Response> function1) {
        Intrinsics.checkNotNullParameter(function1, (String)"block");
        return this.addInterceptor((Interceptor)new /* Unavailable Anonymous Inner Class!! */);
    }

    public final OkHttpClient.Builder _addNetworkInterceptor(Function1<? super Interceptor.Chain, Response> function1) {
        Intrinsics.checkNotNullParameter(function1, (String)"block");
        return this.addNetworkInterceptor((Interceptor)new /* Unavailable Anonymous Inner Class!! */);
    }

    public final OkHttpClient.Builder addInterceptor(Interceptor interceptor) {
        Intrinsics.checkNotNullParameter((Object)interceptor, (String)"interceptor");
        OkHttpClient.Builder builder = this;
        ((Collection)builder.getInterceptors$okhttp()).add(interceptor);
        return builder;
    }

    public final OkHttpClient.Builder addNetworkInterceptor(Interceptor interceptor) {
        Intrinsics.checkNotNullParameter((Object)interceptor, (String)"interceptor");
        OkHttpClient.Builder builder = this;
        ((Collection)builder.getNetworkInterceptors$okhttp()).add(interceptor);
        return builder;
    }

    public final OkHttpClient.Builder authenticator(Authenticator authenticator) {
        Intrinsics.checkNotNullParameter((Object)authenticator, (String)"authenticator");
        OkHttpClient.Builder builder = this;
        builder.setAuthenticator$okhttp(authenticator);
        return builder;
    }

    public final OkHttpClient build() {
        return new OkHttpClient(this);
    }

    public final OkHttpClient.Builder cache(Cache cache) {
        OkHttpClient.Builder builder = this;
        builder.setCache$okhttp(cache);
        return builder;
    }

    public final OkHttpClient.Builder callTimeout(long l, TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter((Object)((Object)timeUnit), (String)"unit");
        OkHttpClient.Builder builder = this;
        builder.setCallTimeout$okhttp(Util.checkDuration((String)"timeout", (long)l, (TimeUnit)timeUnit));
        return builder;
    }

    public final OkHttpClient.Builder callTimeout(Duration duration) {
        Intrinsics.checkNotNullParameter((Object)duration, (String)"duration");
        OkHttpClient.Builder builder = this;
        builder.callTimeout(duration.toMillis(), TimeUnit.MILLISECONDS);
        return builder;
    }

    public final OkHttpClient.Builder certificatePinner(CertificatePinner certificatePinner) {
        Intrinsics.checkNotNullParameter((Object)certificatePinner, (String)"certificatePinner");
        OkHttpClient.Builder builder = this;
        if (!Intrinsics.areEqual((Object)certificatePinner, (Object)builder.getCertificatePinner$okhttp())) {
            builder.setRouteDatabase$okhttp(null);
        }
        builder.setCertificatePinner$okhttp(certificatePinner);
        return builder;
    }

    public final OkHttpClient.Builder connectTimeout(long l, TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter((Object)((Object)timeUnit), (String)"unit");
        OkHttpClient.Builder builder = this;
        builder.setConnectTimeout$okhttp(Util.checkDuration((String)"timeout", (long)l, (TimeUnit)timeUnit));
        return builder;
    }

    public final OkHttpClient.Builder connectTimeout(Duration duration) {
        Intrinsics.checkNotNullParameter((Object)duration, (String)"duration");
        OkHttpClient.Builder builder = this;
        builder.connectTimeout(duration.toMillis(), TimeUnit.MILLISECONDS);
        return builder;
    }

    public final OkHttpClient.Builder connectionPool(ConnectionPool connectionPool) {
        Intrinsics.checkNotNullParameter((Object)connectionPool, (String)"connectionPool");
        OkHttpClient.Builder builder = this;
        builder.setConnectionPool$okhttp(connectionPool);
        return builder;
    }

    public final OkHttpClient.Builder connectionSpecs(List<ConnectionSpec> list) {
        Intrinsics.checkNotNullParameter(list, (String)"connectionSpecs");
        OkHttpClient.Builder builder = this;
        if (!Intrinsics.areEqual(list, builder.getConnectionSpecs$okhttp())) {
            builder.setRouteDatabase$okhttp(null);
        }
        builder.setConnectionSpecs$okhttp(Util.toImmutableList(list));
        return builder;
    }

    public final OkHttpClient.Builder cookieJar(CookieJar cookieJar) {
        Intrinsics.checkNotNullParameter((Object)cookieJar, (String)"cookieJar");
        OkHttpClient.Builder builder = this;
        builder.setCookieJar$okhttp(cookieJar);
        return builder;
    }

    public final OkHttpClient.Builder dispatcher(Dispatcher dispatcher) {
        Intrinsics.checkNotNullParameter((Object)dispatcher, (String)"dispatcher");
        OkHttpClient.Builder builder = this;
        builder.setDispatcher$okhttp(dispatcher);
        return builder;
    }

    public final OkHttpClient.Builder dns(Dns dns) {
        Intrinsics.checkNotNullParameter((Object)dns, (String)"dns");
        OkHttpClient.Builder builder = this;
        if (!Intrinsics.areEqual((Object)dns, (Object)builder.getDns$okhttp())) {
            builder.setRouteDatabase$okhttp(null);
        }
        builder.setDns$okhttp(dns);
        return builder;
    }

    public final OkHttpClient.Builder eventListener(EventListener eventListener) {
        Intrinsics.checkNotNullParameter((Object)eventListener, (String)"eventListener");
        OkHttpClient.Builder builder = this;
        builder.setEventListenerFactory$okhttp(Util.asFactory((EventListener)eventListener));
        return builder;
    }

    public final OkHttpClient.Builder eventListenerFactory(EventListener.Factory factory) {
        Intrinsics.checkNotNullParameter((Object)factory, (String)"eventListenerFactory");
        OkHttpClient.Builder builder = this;
        builder.setEventListenerFactory$okhttp(factory);
        return builder;
    }

    public final OkHttpClient.Builder followRedirects(boolean bl) {
        OkHttpClient.Builder builder = this;
        builder.setFollowRedirects$okhttp(bl);
        return builder;
    }

    public final OkHttpClient.Builder followSslRedirects(boolean bl) {
        OkHttpClient.Builder builder = this;
        builder.setFollowSslRedirects$okhttp(bl);
        return builder;
    }

    public final Authenticator getAuthenticator$okhttp() {
        return this.authenticator;
    }

    public final Cache getCache$okhttp() {
        return this.cache;
    }

    public final int getCallTimeout$okhttp() {
        return this.callTimeout;
    }

    public final CertificateChainCleaner getCertificateChainCleaner$okhttp() {
        return this.certificateChainCleaner;
    }

    public final CertificatePinner getCertificatePinner$okhttp() {
        return this.certificatePinner;
    }

    public final int getConnectTimeout$okhttp() {
        return this.connectTimeout;
    }

    public final ConnectionPool getConnectionPool$okhttp() {
        return this.connectionPool;
    }

    public final List<ConnectionSpec> getConnectionSpecs$okhttp() {
        return this.connectionSpecs;
    }

    public final CookieJar getCookieJar$okhttp() {
        return this.cookieJar;
    }

    public final Dispatcher getDispatcher$okhttp() {
        return this.dispatcher;
    }

    public final Dns getDns$okhttp() {
        return this.dns;
    }

    public final EventListener.Factory getEventListenerFactory$okhttp() {
        return this.eventListenerFactory;
    }

    public final boolean getFollowRedirects$okhttp() {
        return this.followRedirects;
    }

    public final boolean getFollowSslRedirects$okhttp() {
        return this.followSslRedirects;
    }

    public final HostnameVerifier getHostnameVerifier$okhttp() {
        return this.hostnameVerifier;
    }

    public final List<Interceptor> getInterceptors$okhttp() {
        return this.interceptors;
    }

    public final long getMinWebSocketMessageToCompress$okhttp() {
        return this.minWebSocketMessageToCompress;
    }

    public final List<Interceptor> getNetworkInterceptors$okhttp() {
        return this.networkInterceptors;
    }

    public final int getPingInterval$okhttp() {
        return this.pingInterval;
    }

    public final List<Protocol> getProtocols$okhttp() {
        return this.protocols;
    }

    public final Proxy getProxy$okhttp() {
        return this.proxy;
    }

    public final Authenticator getProxyAuthenticator$okhttp() {
        return this.proxyAuthenticator;
    }

    public final ProxySelector getProxySelector$okhttp() {
        return this.proxySelector;
    }

    public final int getReadTimeout$okhttp() {
        return this.readTimeout;
    }

    public final boolean getRetryOnConnectionFailure$okhttp() {
        return this.retryOnConnectionFailure;
    }

    public final RouteDatabase getRouteDatabase$okhttp() {
        return this.routeDatabase;
    }

    public final SocketFactory getSocketFactory$okhttp() {
        return this.socketFactory;
    }

    public final SSLSocketFactory getSslSocketFactoryOrNull$okhttp() {
        return this.sslSocketFactoryOrNull;
    }

    public final int getWriteTimeout$okhttp() {
        return this.writeTimeout;
    }

    public final X509TrustManager getX509TrustManagerOrNull$okhttp() {
        return this.x509TrustManagerOrNull;
    }

    public final OkHttpClient.Builder hostnameVerifier(HostnameVerifier hostnameVerifier) {
        Intrinsics.checkNotNullParameter((Object)hostnameVerifier, (String)"hostnameVerifier");
        OkHttpClient.Builder builder = this;
        if (!Intrinsics.areEqual((Object)hostnameVerifier, (Object)builder.getHostnameVerifier$okhttp())) {
            builder.setRouteDatabase$okhttp(null);
        }
        builder.setHostnameVerifier$okhttp(hostnameVerifier);
        return builder;
    }

    public final List<Interceptor> interceptors() {
        return this.interceptors;
    }

    public final OkHttpClient.Builder minWebSocketMessageToCompress(long l) {
        OkHttpClient.Builder builder = this;
        boolean bl = l >= 0L;
        if (!bl) throw (Throwable)new IllegalArgumentException(Intrinsics.stringPlus((String)"minWebSocketMessageToCompress must be positive: ", (Object)l).toString());
        builder.setMinWebSocketMessageToCompress$okhttp(l);
        return builder;
    }

    public final List<Interceptor> networkInterceptors() {
        return this.networkInterceptors;
    }

    public final OkHttpClient.Builder pingInterval(long l, TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter((Object)((Object)timeUnit), (String)"unit");
        OkHttpClient.Builder builder = this;
        builder.setPingInterval$okhttp(Util.checkDuration((String)"interval", (long)l, (TimeUnit)timeUnit));
        return builder;
    }

    public final OkHttpClient.Builder pingInterval(Duration duration) {
        Intrinsics.checkNotNullParameter((Object)duration, (String)"duration");
        OkHttpClient.Builder builder = this;
        builder.pingInterval(duration.toMillis(), TimeUnit.MILLISECONDS);
        return builder;
    }

    public final OkHttpClient.Builder protocols(List<? extends Protocol> list) {
        boolean bl;
        OkHttpClient.Builder builder;
        block5: {
            block4: {
                Intrinsics.checkNotNullParameter(list, (String)"protocols");
                builder = this;
                list = CollectionsKt.toMutableList((Collection)list);
                boolean bl2 = list.contains(Protocol.H2_PRIOR_KNOWLEDGE);
                boolean bl3 = false;
                bl = bl2 || list.contains(Protocol.HTTP_1_1);
                if (!bl) throw (Throwable)new IllegalArgumentException(Intrinsics.stringPlus((String)"protocols must contain h2_prior_knowledge or http/1.1: ", (Object)list).toString());
                if (!list.contains(Protocol.H2_PRIOR_KNOWLEDGE)) break block4;
                bl = bl3;
                if (list.size() > 1) break block5;
            }
            bl = true;
        }
        if (!bl) throw (Throwable)new IllegalArgumentException(Intrinsics.stringPlus((String)"protocols containing h2_prior_knowledge cannot use other protocols: ", (Object)list).toString());
        if (!(list.contains(Protocol.HTTP_1_0) ^ true)) throw (Throwable)new IllegalArgumentException(Intrinsics.stringPlus((String)"protocols must not contain http/1.0: ", (Object)list).toString());
        if (!(list.contains(null) ^ true)) throw (Throwable)new IllegalArgumentException("protocols must not contain null".toString());
        list.remove(Protocol.SPDY_3);
        if (!Intrinsics.areEqual((Object)list, builder.getProtocols$okhttp())) {
            builder.setRouteDatabase$okhttp(null);
        }
        list = Collections.unmodifiableList(list);
        Intrinsics.checkNotNullExpressionValue(list, (String)"unmodifiableList(protocolsCopy)");
        builder.setProtocols$okhttp(list);
        return builder;
    }

    public final OkHttpClient.Builder proxy(Proxy proxy) {
        OkHttpClient.Builder builder = this;
        if (!Intrinsics.areEqual((Object)proxy, (Object)builder.getProxy$okhttp())) {
            builder.setRouteDatabase$okhttp(null);
        }
        builder.setProxy$okhttp(proxy);
        return builder;
    }

    public final OkHttpClient.Builder proxyAuthenticator(Authenticator authenticator) {
        Intrinsics.checkNotNullParameter((Object)authenticator, (String)"proxyAuthenticator");
        OkHttpClient.Builder builder = this;
        if (!Intrinsics.areEqual((Object)authenticator, (Object)builder.getProxyAuthenticator$okhttp())) {
            builder.setRouteDatabase$okhttp(null);
        }
        builder.setProxyAuthenticator$okhttp(authenticator);
        return builder;
    }

    public final OkHttpClient.Builder proxySelector(ProxySelector proxySelector) {
        Intrinsics.checkNotNullParameter((Object)proxySelector, (String)"proxySelector");
        OkHttpClient.Builder builder = this;
        if (!Intrinsics.areEqual((Object)proxySelector, (Object)builder.getProxySelector$okhttp())) {
            builder.setRouteDatabase$okhttp(null);
        }
        builder.setProxySelector$okhttp(proxySelector);
        return builder;
    }

    public final OkHttpClient.Builder readTimeout(long l, TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter((Object)((Object)timeUnit), (String)"unit");
        OkHttpClient.Builder builder = this;
        builder.setReadTimeout$okhttp(Util.checkDuration((String)"timeout", (long)l, (TimeUnit)timeUnit));
        return builder;
    }

    public final OkHttpClient.Builder readTimeout(Duration duration) {
        Intrinsics.checkNotNullParameter((Object)duration, (String)"duration");
        OkHttpClient.Builder builder = this;
        builder.readTimeout(duration.toMillis(), TimeUnit.MILLISECONDS);
        return builder;
    }

    public final OkHttpClient.Builder retryOnConnectionFailure(boolean bl) {
        OkHttpClient.Builder builder = this;
        builder.setRetryOnConnectionFailure$okhttp(bl);
        return builder;
    }

    public final void setAuthenticator$okhttp(Authenticator authenticator) {
        Intrinsics.checkNotNullParameter((Object)authenticator, (String)"<set-?>");
        this.authenticator = authenticator;
    }

    public final void setCache$okhttp(Cache cache) {
        this.cache = cache;
    }

    public final void setCallTimeout$okhttp(int n) {
        this.callTimeout = n;
    }

    public final void setCertificateChainCleaner$okhttp(CertificateChainCleaner certificateChainCleaner) {
        this.certificateChainCleaner = certificateChainCleaner;
    }

    public final void setCertificatePinner$okhttp(CertificatePinner certificatePinner) {
        Intrinsics.checkNotNullParameter((Object)certificatePinner, (String)"<set-?>");
        this.certificatePinner = certificatePinner;
    }

    public final void setConnectTimeout$okhttp(int n) {
        this.connectTimeout = n;
    }

    public final void setConnectionPool$okhttp(ConnectionPool connectionPool) {
        Intrinsics.checkNotNullParameter((Object)connectionPool, (String)"<set-?>");
        this.connectionPool = connectionPool;
    }

    public final void setConnectionSpecs$okhttp(List<ConnectionSpec> list) {
        Intrinsics.checkNotNullParameter(list, (String)"<set-?>");
        this.connectionSpecs = list;
    }

    public final void setCookieJar$okhttp(CookieJar cookieJar) {
        Intrinsics.checkNotNullParameter((Object)cookieJar, (String)"<set-?>");
        this.cookieJar = cookieJar;
    }

    public final void setDispatcher$okhttp(Dispatcher dispatcher) {
        Intrinsics.checkNotNullParameter((Object)dispatcher, (String)"<set-?>");
        this.dispatcher = dispatcher;
    }

    public final void setDns$okhttp(Dns dns) {
        Intrinsics.checkNotNullParameter((Object)dns, (String)"<set-?>");
        this.dns = dns;
    }

    public final void setEventListenerFactory$okhttp(EventListener.Factory factory) {
        Intrinsics.checkNotNullParameter((Object)factory, (String)"<set-?>");
        this.eventListenerFactory = factory;
    }

    public final void setFollowRedirects$okhttp(boolean bl) {
        this.followRedirects = bl;
    }

    public final void setFollowSslRedirects$okhttp(boolean bl) {
        this.followSslRedirects = bl;
    }

    public final void setHostnameVerifier$okhttp(HostnameVerifier hostnameVerifier) {
        Intrinsics.checkNotNullParameter((Object)hostnameVerifier, (String)"<set-?>");
        this.hostnameVerifier = hostnameVerifier;
    }

    public final void setMinWebSocketMessageToCompress$okhttp(long l) {
        this.minWebSocketMessageToCompress = l;
    }

    public final void setPingInterval$okhttp(int n) {
        this.pingInterval = n;
    }

    public final void setProtocols$okhttp(List<? extends Protocol> list) {
        Intrinsics.checkNotNullParameter(list, (String)"<set-?>");
        this.protocols = list;
    }

    public final void setProxy$okhttp(Proxy proxy) {
        this.proxy = proxy;
    }

    public final void setProxyAuthenticator$okhttp(Authenticator authenticator) {
        Intrinsics.checkNotNullParameter((Object)authenticator, (String)"<set-?>");
        this.proxyAuthenticator = authenticator;
    }

    public final void setProxySelector$okhttp(ProxySelector proxySelector) {
        this.proxySelector = proxySelector;
    }

    public final void setReadTimeout$okhttp(int n) {
        this.readTimeout = n;
    }

    public final void setRetryOnConnectionFailure$okhttp(boolean bl) {
        this.retryOnConnectionFailure = bl;
    }

    public final void setRouteDatabase$okhttp(RouteDatabase routeDatabase) {
        this.routeDatabase = routeDatabase;
    }

    public final void setSocketFactory$okhttp(SocketFactory socketFactory) {
        Intrinsics.checkNotNullParameter((Object)socketFactory, (String)"<set-?>");
        this.socketFactory = socketFactory;
    }

    public final void setSslSocketFactoryOrNull$okhttp(SSLSocketFactory sSLSocketFactory) {
        this.sslSocketFactoryOrNull = sSLSocketFactory;
    }

    public final void setWriteTimeout$okhttp(int n) {
        this.writeTimeout = n;
    }

    public final void setX509TrustManagerOrNull$okhttp(X509TrustManager x509TrustManager) {
        this.x509TrustManagerOrNull = x509TrustManager;
    }

    public final OkHttpClient.Builder socketFactory(SocketFactory socketFactory) {
        Intrinsics.checkNotNullParameter((Object)socketFactory, (String)"socketFactory");
        OkHttpClient.Builder builder = this;
        if (!(socketFactory instanceof SSLSocketFactory ^ true)) throw (Throwable)new IllegalArgumentException("socketFactory instanceof SSLSocketFactory".toString());
        if (!Intrinsics.areEqual((Object)socketFactory, (Object)builder.getSocketFactory$okhttp())) {
            builder.setRouteDatabase$okhttp(null);
        }
        builder.setSocketFactory$okhttp(socketFactory);
        return builder;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Use the sslSocketFactory overload that accepts a X509TrustManager.")
    public final OkHttpClient.Builder sslSocketFactory(SSLSocketFactory object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"sslSocketFactory");
        Object object2 = this;
        if (!Intrinsics.areEqual((Object)object, (Object)((OkHttpClient.Builder)object2).getSslSocketFactoryOrNull$okhttp())) {
            ((OkHttpClient.Builder)object2).setRouteDatabase$okhttp(null);
        }
        ((OkHttpClient.Builder)object2).setSslSocketFactoryOrNull$okhttp((SSLSocketFactory)object);
        X509TrustManager x509TrustManager = Platform.Companion.get().trustManager((SSLSocketFactory)object);
        if (x509TrustManager != null) {
            ((OkHttpClient.Builder)object2).setX509TrustManagerOrNull$okhttp(x509TrustManager);
            x509TrustManager = Platform.Companion.get();
            object = ((OkHttpClient.Builder)object2).getX509TrustManagerOrNull$okhttp();
            Intrinsics.checkNotNull((Object)object);
            ((OkHttpClient.Builder)object2).setCertificateChainCleaner$okhttp(x509TrustManager.buildCertificateChainCleaner((X509TrustManager)object));
            return object2;
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Unable to extract the trust manager on ");
        ((StringBuilder)object2).append(Platform.Companion.get());
        ((StringBuilder)object2).append(", sslSocketFactory is ");
        ((StringBuilder)object2).append(object.getClass());
        throw new IllegalStateException(((StringBuilder)object2).toString());
    }

    public final OkHttpClient.Builder sslSocketFactory(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager) {
        Intrinsics.checkNotNullParameter((Object)sSLSocketFactory, (String)"sslSocketFactory");
        Intrinsics.checkNotNullParameter((Object)x509TrustManager, (String)"trustManager");
        OkHttpClient.Builder builder = this;
        if (!Intrinsics.areEqual((Object)sSLSocketFactory, (Object)builder.getSslSocketFactoryOrNull$okhttp()) || !Intrinsics.areEqual((Object)x509TrustManager, (Object)builder.getX509TrustManagerOrNull$okhttp())) {
            builder.setRouteDatabase$okhttp(null);
        }
        builder.setSslSocketFactoryOrNull$okhttp(sSLSocketFactory);
        builder.setCertificateChainCleaner$okhttp(CertificateChainCleaner.Companion.get(x509TrustManager));
        builder.setX509TrustManagerOrNull$okhttp(x509TrustManager);
        return builder;
    }

    public final OkHttpClient.Builder writeTimeout(long l, TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter((Object)((Object)timeUnit), (String)"unit");
        OkHttpClient.Builder builder = this;
        builder.setWriteTimeout$okhttp(Util.checkDuration((String)"timeout", (long)l, (TimeUnit)timeUnit));
        return builder;
    }

    public final OkHttpClient.Builder writeTimeout(Duration duration) {
        Intrinsics.checkNotNullParameter((Object)duration, (String)"duration");
        OkHttpClient.Builder builder = this;
        builder.writeTimeout(duration.toMillis(), TimeUnit.MILLISECONDS);
        return builder;
    }
}
