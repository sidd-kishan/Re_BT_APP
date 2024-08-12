/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 *  okhttp3.Address
 *  okhttp3.Call
 *  okhttp3.CertificatePinner
 *  okhttp3.CipherSuite
 *  okhttp3.Connection
 *  okhttp3.ConnectionSpec
 *  okhttp3.EventListener
 *  okhttp3.Handshake
 *  okhttp3.HttpUrl
 *  okhttp3.OkHttpClient
 *  okhttp3.Protocol
 *  okhttp3.Request
 *  okhttp3.Request$Builder
 *  okhttp3.Response
 *  okhttp3.Response$Builder
 *  okhttp3.Route
 *  okhttp3.TlsVersion
 *  okhttp3.internal.Util
 *  okhttp3.internal.concurrent.TaskRunner
 *  okhttp3.internal.connection.ConnectionSpecSelector
 *  okhttp3.internal.connection.Exchange
 *  okhttp3.internal.connection.RealCall
 *  okhttp3.internal.connection.RealConnection$Companion
 *  okhttp3.internal.connection.RealConnection$WhenMappings
 *  okhttp3.internal.connection.RealConnection$connectTls$1
 *  okhttp3.internal.connection.RealConnectionPool
 *  okhttp3.internal.connection.RouteException
 *  okhttp3.internal.http.ExchangeCodec
 *  okhttp3.internal.http.RealInterceptorChain
 *  okhttp3.internal.http1.Http1ExchangeCodec
 *  okhttp3.internal.http2.ConnectionShutdownException
 *  okhttp3.internal.http2.ErrorCode
 *  okhttp3.internal.http2.Http2Connection
 *  okhttp3.internal.http2.Http2Connection$Builder
 *  okhttp3.internal.http2.Http2Connection$Listener
 *  okhttp3.internal.http2.Http2ExchangeCodec
 *  okhttp3.internal.http2.Http2Stream
 *  okhttp3.internal.http2.Settings
 *  okhttp3.internal.http2.StreamResetException
 *  okhttp3.internal.platform.Platform
 *  okhttp3.internal.tls.OkHostnameVerifier
 *  okhttp3.internal.ws.RealWebSocket$Streams
 *  okio.BufferedSink
 *  okio.BufferedSource
 *  okio.Okio
 *  okio.Sink
 *  okio.Source
 */
package okhttp3.internal.connection;

import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownServiceException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.CertificatePinner;
import okhttp3.CipherSuite;
import okhttp3.Connection;
import okhttp3.ConnectionSpec;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.TlsVersion;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.ConnectionSpecSelector;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RealConnectionPool;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http1.Http1ExchangeCodec;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Http2ExchangeCodec;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.http2.Settings;
import okhttp3.internal.http2.StreamResetException;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.tls.OkHostnameVerifier;
import okhttp3.internal.ws.RealWebSocket;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

@Metadata(d1={"\u0000\u00ec\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 {2\u00020\u00012\u00020\u0002:\u0001{B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0006\u00105\u001a\u000206J\u0018\u00107\u001a\u00020\u001d2\u0006\u00108\u001a\u0002092\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J>\u0010:\u001a\u0002062\u0006\u0010;\u001a\u00020\t2\u0006\u0010<\u001a\u00020\t2\u0006\u0010=\u001a\u00020\t2\u0006\u0010>\u001a\u00020\t2\u0006\u0010?\u001a\u00020\u001d2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CJ%\u0010D\u001a\u0002062\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u00062\u0006\u0010H\u001a\u00020IH\u0000\u00a2\u0006\u0002\bJJ(\u0010K\u001a\u0002062\u0006\u0010;\u001a\u00020\t2\u0006\u0010<\u001a\u00020\t2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CH\u0002J\u0010\u0010L\u001a\u0002062\u0006\u0010M\u001a\u00020NH\u0002J0\u0010O\u001a\u0002062\u0006\u0010;\u001a\u00020\t2\u0006\u0010<\u001a\u00020\t2\u0006\u0010=\u001a\u00020\t2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CH\u0002J*\u0010P\u001a\u0004\u0018\u00010Q2\u0006\u0010<\u001a\u00020\t2\u0006\u0010=\u001a\u00020\t2\u0006\u0010R\u001a\u00020Q2\u0006\u00108\u001a\u000209H\u0002J\b\u0010S\u001a\u00020QH\u0002J(\u0010T\u001a\u0002062\u0006\u0010M\u001a\u00020N2\u0006\u0010>\u001a\u00020\t2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CH\u0002J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\r\u0010U\u001a\u000206H\u0000\u00a2\u0006\u0002\bVJ%\u0010W\u001a\u00020\u001d2\u0006\u0010X\u001a\u00020Y2\u000e\u0010Z\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010[H\u0000\u00a2\u0006\u0002\b\\J\u000e\u0010]\u001a\u00020\u001d2\u0006\u0010^\u001a\u00020\u001dJ\u001d\u0010_\u001a\u00020`2\u0006\u0010E\u001a\u00020F2\u0006\u0010a\u001a\u00020bH\u0000\u00a2\u0006\u0002\bcJ\u0015\u0010d\u001a\u00020e2\u0006\u0010f\u001a\u00020gH\u0000\u00a2\u0006\u0002\bhJ\r\u0010 \u001a\u000206H\u0000\u00a2\u0006\u0002\biJ\r\u0010!\u001a\u000206H\u0000\u00a2\u0006\u0002\bjJ\u0018\u0010k\u001a\u0002062\u0006\u0010l\u001a\u00020\u00152\u0006\u0010m\u001a\u00020nH\u0016J\u0010\u0010o\u001a\u0002062\u0006\u0010p\u001a\u00020qH\u0016J\b\u0010%\u001a\u00020&H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0016\u0010r\u001a\u00020\u001d2\f\u0010s\u001a\b\u0012\u0004\u0012\u00020\u00060[H\u0002J\b\u00101\u001a\u00020(H\u0016J\u0010\u0010t\u001a\u0002062\u0006\u0010>\u001a\u00020\tH\u0002J\u0010\u0010u\u001a\u00020\u001d2\u0006\u00108\u001a\u000209H\u0002J\b\u0010v\u001a\u00020wH\u0016J\u001f\u0010x\u001a\u0002062\u0006\u0010@\u001a\u00020\r2\b\u0010y\u001a\u0004\u0018\u00010IH\u0000\u00a2\u0006\u0002\bzR\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001d\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u001d8@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u00020\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001f\"\u0004\b#\u0010$R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010*\u001a\u00020\tX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u00010(X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006|"}, d2={"Lokhttp3/internal/connection/RealConnection;", "Lokhttp3/internal/http2/Http2Connection$Listener;", "Lokhttp3/Connection;", "connectionPool", "Lokhttp3/internal/connection/RealConnectionPool;", "route", "Lokhttp3/Route;", "(Lokhttp3/internal/connection/RealConnectionPool;Lokhttp3/Route;)V", "allocationLimit", "", "calls", "", "Ljava/lang/ref/Reference;", "Lokhttp3/internal/connection/RealCall;", "getCalls", "()Ljava/util/List;", "getConnectionPool", "()Lokhttp3/internal/connection/RealConnectionPool;", "handshake", "Lokhttp3/Handshake;", "http2Connection", "Lokhttp3/internal/http2/Http2Connection;", "idleAtNs", "", "getIdleAtNs", "()J", "setIdleAtNs", "(J)V", "isMultiplexed", "", "isMultiplexed$okhttp", "()Z", "noCoalescedConnections", "noNewExchanges", "getNoNewExchanges", "setNoNewExchanges", "(Z)V", "protocol", "Lokhttp3/Protocol;", "rawSocket", "Ljava/net/Socket;", "refusedStreamCount", "routeFailureCount", "getRouteFailureCount$okhttp", "()I", "setRouteFailureCount$okhttp", "(I)V", "sink", "Lokio/BufferedSink;", "socket", "source", "Lokio/BufferedSource;", "successCount", "cancel", "", "certificateSupportHost", "url", "Lokhttp3/HttpUrl;", "connect", "connectTimeout", "readTimeout", "writeTimeout", "pingIntervalMillis", "connectionRetryEnabled", "call", "Lokhttp3/Call;", "eventListener", "Lokhttp3/EventListener;", "connectFailed", "client", "Lokhttp3/OkHttpClient;", "failedRoute", "failure", "Ljava/io/IOException;", "connectFailed$okhttp", "connectSocket", "connectTls", "connectionSpecSelector", "Lokhttp3/internal/connection/ConnectionSpecSelector;", "connectTunnel", "createTunnel", "Lokhttp3/Request;", "tunnelRequest", "createTunnelRequest", "establishProtocol", "incrementSuccessCount", "incrementSuccessCount$okhttp", "isEligible", "address", "Lokhttp3/Address;", "routes", "", "isEligible$okhttp", "isHealthy", "doExtensiveChecks", "newCodec", "Lokhttp3/internal/http/ExchangeCodec;", "chain", "Lokhttp3/internal/http/RealInterceptorChain;", "newCodec$okhttp", "newWebSocketStreams", "Lokhttp3/internal/ws/RealWebSocket$Streams;", "exchange", "Lokhttp3/internal/connection/Exchange;", "newWebSocketStreams$okhttp", "noCoalescedConnections$okhttp", "noNewExchanges$okhttp", "onSettings", "connection", "settings", "Lokhttp3/internal/http2/Settings;", "onStream", "stream", "Lokhttp3/internal/http2/Http2Stream;", "routeMatchesAny", "candidates", "startHttp2", "supportsUrl", "toString", "", "trackFailure", "e", "trackFailure$okhttp", "Companion", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class RealConnection
extends Http2Connection.Listener
implements Connection {
    public static final Companion Companion = new Companion(null);
    public static final long IDLE_CONNECTION_HEALTHY_NS = 10000000000L;
    private static final int MAX_TUNNEL_ATTEMPTS = 21;
    private static final String NPE_THROW_WITH_NULL = "throw with null exception";
    private int allocationLimit;
    private final List<Reference<RealCall>> calls;
    private final RealConnectionPool connectionPool;
    private Handshake handshake;
    private Http2Connection http2Connection;
    private long idleAtNs;
    private boolean noCoalescedConnections;
    private boolean noNewExchanges;
    private Protocol protocol;
    private Socket rawSocket;
    private int refusedStreamCount;
    private final Route route;
    private int routeFailureCount;
    private BufferedSink sink;
    private Socket socket;
    private BufferedSource source;
    private int successCount;

    public RealConnection(RealConnectionPool realConnectionPool, Route route) {
        Intrinsics.checkNotNullParameter((Object)realConnectionPool, (String)"connectionPool");
        Intrinsics.checkNotNullParameter((Object)route, (String)"route");
        this.connectionPool = realConnectionPool;
        this.route = route;
        this.allocationLimit = 1;
        this.calls = new ArrayList();
        this.idleAtNs = Long.MAX_VALUE;
    }

    public static final /* synthetic */ Handshake access$getHandshake$p(RealConnection realConnection) {
        return realConnection.handshake;
    }

    public static final /* synthetic */ void access$setSocket$p(RealConnection realConnection, Socket socket) {
        realConnection.socket = socket;
    }

    private final boolean certificateSupportHost(HttpUrl httpUrl, Handshake object) {
        object = object.peerCertificates();
        boolean bl = ((Collection)object).isEmpty();
        boolean bl2 = true;
        if (bl ^ true && OkHostnameVerifier.INSTANCE.verify(httpUrl.host(), (X509Certificate)object.get(0))) return bl2;
        bl2 = false;
        return bl2;
    }

    private final void connectSocket(int n, int n2, Call object, EventListener eventListener) throws IOException {
        Proxy proxy = this.route.proxy();
        Address address = this.route.address();
        Object object2 = proxy.type();
        int n3 = object2 == null ? -1 : WhenMappings.$EnumSwitchMapping$0[object2.ordinal()];
        if (n3 != 1 && n3 != 2) {
            object2 = new Socket(proxy);
        } else {
            object2 = address.socketFactory().createSocket();
            Intrinsics.checkNotNull((Object)object2);
        }
        this.rawSocket = object2;
        eventListener.connectStart((Call)object, this.route.socketAddress(), proxy);
        ((Socket)object2).setSoTimeout(n2);
        try {
            Platform.Companion.get().connectSocket((Socket)object2, this.route.socketAddress(), n);
        }
        catch (ConnectException connectException) {
            object = new ConnectException(Intrinsics.stringPlus((String)"Failed to connect to ", (Object)this.route.socketAddress()));
            ((Throwable)object).initCause(connectException);
            throw (Throwable)object;
        }
        try {
            this.source = Okio.buffer((Source)Okio.source((Socket)object2));
            this.sink = Okio.buffer((Sink)Okio.sink((Socket)object2));
        }
        catch (NullPointerException nullPointerException) {
            if (Intrinsics.areEqual((Object)nullPointerException.getMessage(), (Object)NPE_THROW_WITH_NULL)) throw new IOException(nullPointerException);
        }
    }

    /*
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    private final void connectTls(ConnectionSpecSelector object) throws IOException {
        void var1_4;
        Object object2;
        block11: {
            Object object3;
            block10: {
                Address address = this.route.address();
                object2 = address.sslSocketFactory();
                object3 = null;
                Intrinsics.checkNotNull((Object)object2);
                object2 = ((SSLSocketFactory)object2).createSocket(this.rawSocket, address.url().host(), address.url().port(), true);
                if (object2 == null) break block10;
                object2 = (SSLSocket)object2;
                try {
                    Handshake handshake;
                    object = object.configureSecureSocket((SSLSocket)object2);
                    if (object.supportsTlsExtensions()) {
                        Platform.Companion.get().configureTlsExtensions((SSLSocket)object2, address.url().host(), address.protocols());
                    }
                    ((SSLSocket)object2).startHandshake();
                    object3 = ((SSLSocket)object2).getSession();
                    Object object4 = Handshake.Companion;
                    Intrinsics.checkNotNullExpressionValue((Object)object3, (String)"sslSocketSession");
                    object4 = object4.get((SSLSession)object3);
                    Object object5 = address.hostnameVerifier();
                    Intrinsics.checkNotNull((Object)object5);
                    if (!object5.verify(address.url().host(), (SSLSession)object3)) {
                        object = object4.peerCertificates();
                        if (((Collection)object).isEmpty() ^ true) {
                            object = (X509Certificate)object.get(0);
                            object4 = new StringBuilder();
                            ((StringBuilder)object4).append("\n              |Hostname ");
                            ((StringBuilder)object4).append(address.url().host());
                            ((StringBuilder)object4).append(" not verified:\n              |    certificate: ");
                            ((StringBuilder)object4).append(CertificatePinner.Companion.pin((Certificate)object));
                            ((StringBuilder)object4).append("\n              |    DN: ");
                            ((StringBuilder)object4).append((Object)((X509Certificate)object).getSubjectDN().getName());
                            ((StringBuilder)object4).append("\n              |    subjectAltNames: ");
                            ((StringBuilder)object4).append(OkHostnameVerifier.INSTANCE.allSubjectAltNames((X509Certificate)object));
                            ((StringBuilder)object4).append("\n              ");
                            object3 = new SSLPeerUnverifiedException(StringsKt.trimMargin$default((String)((StringBuilder)object4).toString(), null, (int)1, null));
                            throw object3;
                        }
                        object = new StringBuilder();
                        ((StringBuilder)object).append("Hostname ");
                        ((StringBuilder)object).append(address.url().host());
                        ((StringBuilder)object).append(" not verified (no certificates)");
                        object3 = new SSLPeerUnverifiedException(((StringBuilder)object).toString());
                        throw object3;
                    }
                    object3 = address.certificatePinner();
                    Intrinsics.checkNotNull((Object)object3);
                    TlsVersion tlsVersion = object4.tlsVersion();
                    CipherSuite cipherSuite = object4.cipherSuite();
                    object5 = object4.localCertificates();
                    connectTls.1 var8_14 = new /* Unavailable Anonymous Inner Class!! */;
                    this.handshake = handshake = new Handshake(tlsVersion, cipherSuite, (List)object5, (Function0)var8_14);
                    String string = address.url().host();
                    object4 = new /* Unavailable Anonymous Inner Class!! */;
                    object3.check$okhttp(string, (Function0)object4);
                    object = object.supportsTlsExtensions() ? Platform.Companion.get().getSelectedProtocol((SSLSocket)object2) : (String)null;
                    this.socket = (Socket)object2;
                    this.source = Okio.buffer((Source)Okio.source((Socket)((Socket)object2)));
                    this.sink = Okio.buffer((Sink)Okio.sink((Socket)((Socket)object2)));
                    object = object != null ? Protocol.Companion.get((String)object) : Protocol.HTTP_1_1;
                    this.protocol = object;
                }
                catch (Throwable throwable) {}
                Platform.Companion.get().afterHandshake((SSLSocket)object2);
                return;
                break block11;
            }
            try {
                object = new NullPointerException("null cannot be cast to non-null type javax.net.ssl.SSLSocket");
                throw object;
            }
            catch (Throwable throwable) {
                object2 = object3;
            }
        }
        if (object2 != null) {
            Platform.Companion.get().afterHandshake((SSLSocket)object2);
        }
        if (object2 == null) {
            throw var1_4;
        }
        Util.closeQuietly((Socket)((Socket)object2));
        throw var1_4;
    }

    private final void connectTunnel(int n, int n2, int n3, Call call, EventListener eventListener) throws IOException {
        int n4;
        Request request = this.createTunnelRequest();
        HttpUrl httpUrl = request.url();
        int n5 = 0;
        do {
            n4 = n5 + 1;
            this.connectSocket(n, n2, call, eventListener);
            request = this.createTunnel(n2, n3, request, httpUrl);
            if (request == null) return;
            Socket socket = this.rawSocket;
            if (socket != null) {
                Util.closeQuietly((Socket)socket);
            }
            this.rawSocket = null;
            this.sink = null;
            this.source = null;
            eventListener.connectEnd(call, this.route.socketAddress(), this.route.proxy(), null);
            n5 = n4;
        } while (n4 < 21);
    }

    private final Request createTunnel(int n, int n2, Request object, HttpUrl object2) throws IOException {
        BufferedSource bufferedSource;
        StringBuilder stringBuilder;
        block2: {
            Response.Builder builder;
            stringBuilder = new StringBuilder();
            stringBuilder.append("CONNECT ");
            stringBuilder.append(Util.toHostHeader((HttpUrl)object2, (boolean)true));
            stringBuilder.append(" HTTP/1.1");
            object2 = stringBuilder.toString();
            do {
                bufferedSource = this.source;
                Intrinsics.checkNotNull((Object)bufferedSource);
                stringBuilder = this.sink;
                Intrinsics.checkNotNull((Object)stringBuilder);
                Http1ExchangeCodec http1ExchangeCodec = new Http1ExchangeCodec(null, this, bufferedSource, (BufferedSink)stringBuilder);
                bufferedSource.timeout().timeout((long)n, TimeUnit.MILLISECONDS);
                stringBuilder.timeout().timeout((long)n2, TimeUnit.MILLISECONDS);
                http1ExchangeCodec.writeRequest(object.headers(), (String)object2);
                http1ExchangeCodec.finishRequest();
                builder = http1ExchangeCodec.readResponseHeaders(false);
                Intrinsics.checkNotNull((Object)builder);
                builder = builder.request(object).build();
                http1ExchangeCodec.skipConnectBody((Response)builder);
                int n3 = builder.code();
                if (n3 == 200) break block2;
                if (n3 != 407) throw new IOException(Intrinsics.stringPlus((String)"Unexpected response code for CONNECT: ", (Object)builder.code()));
                object = this.route.address().proxyAuthenticator().authenticate(this.route, (Response)builder);
                if (object == null) throw new IOException("Failed to authenticate with proxy");
            } while (!StringsKt.equals((String)"close", (String)Response.header$default((Response)builder, (String)"Connection", null, (int)2, null), (boolean)true));
            return object;
        }
        if (bufferedSource.getBuffer().exhausted() && stringBuilder.getBuffer().exhausted()) {
            return null;
        }
        object = new IOException("TLS tunnel buffered too many bytes!");
        throw object;
    }

    private final Request createTunnelRequest() throws IOException {
        Request request = new Request.Builder().url(this.route.address().url()).method("CONNECT", null).header("Host", Util.toHostHeader((HttpUrl)this.route.address().url(), (boolean)true)).header("Proxy-Connection", "Keep-Alive").header("User-Agent", "okhttp/5.0.0-alpha.3").build();
        Response response = new Response.Builder().request(request).protocol(Protocol.HTTP_1_1).code(407).message("Preemptive Authenticate").body(Util.EMPTY_RESPONSE).sentRequestAtMillis(-1L).receivedResponseAtMillis(-1L).header("Proxy-Authenticate", "OkHttp-Preemptive").build();
        response = this.route.address().proxyAuthenticator().authenticate(this.route, response);
        if (response == null) return request;
        request = response;
        return request;
    }

    private final void establishProtocol(ConnectionSpecSelector connectionSpecSelector, int n, Call call, EventListener eventListener) throws IOException {
        if (this.route.address().sslSocketFactory() != null) {
            eventListener.secureConnectStart(call);
            this.connectTls(connectionSpecSelector);
            eventListener.secureConnectEnd(call, this.handshake);
            if (this.protocol != Protocol.HTTP_2) return;
            this.startHttp2(n);
            return;
        }
        if (this.route.address().protocols().contains(Protocol.H2_PRIOR_KNOWLEDGE)) {
            this.socket = this.rawSocket;
            this.protocol = Protocol.H2_PRIOR_KNOWLEDGE;
            this.startHttp2(n);
            return;
        }
        this.socket = this.rawSocket;
        this.protocol = Protocol.HTTP_1_1;
    }

    /*
     * Enabled force condition propagation
     */
    private final boolean routeMatchesAny(List<Route> iterator) {
        Route route;
        boolean bl;
        iterator = (Iterable)((Object)iterator);
        boolean bl2 = iterator instanceof Collection;
        boolean bl3 = true;
        if (bl2) {
            if (((Collection)((Object)iterator)).isEmpty()) return false;
        }
        iterator = iterator.iterator();
        do {
            if (iterator.hasNext()) continue;
            return false;
        } while (!(bl = (route = (Route)iterator.next()).proxy().type() == Proxy.Type.DIRECT && this.route.proxy().type() == Proxy.Type.DIRECT && Intrinsics.areEqual((Object)this.route.socketAddress(), (Object)route.socketAddress())));
        return bl3;
    }

    private final void startHttp2(int n) throws IOException {
        Socket socket = this.socket;
        Intrinsics.checkNotNull((Object)socket);
        BufferedSource bufferedSource = this.source;
        Intrinsics.checkNotNull((Object)bufferedSource);
        BufferedSink bufferedSink = this.sink;
        Intrinsics.checkNotNull((Object)bufferedSink);
        socket.setSoTimeout(0);
        bufferedSource = new Http2Connection.Builder(true, TaskRunner.INSTANCE).socket(socket, this.route.address().url().host(), bufferedSource, bufferedSink).listener((Http2Connection.Listener)this).pingIntervalMillis(n).build();
        this.http2Connection = bufferedSource;
        this.allocationLimit = Http2Connection.Companion.getDEFAULT_SETTINGS().getMaxConcurrentStreams();
        Http2Connection.start$default((Http2Connection)bufferedSource, (boolean)false, null, (int)3, null);
    }

    private final boolean supportsUrl(HttpUrl object) {
        if (Util.assertionsEnabled && !Thread.holdsLock((Object)this)) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Thread ");
            ((StringBuilder)object).append((Object)Thread.currentThread().getName());
            ((StringBuilder)object).append(" MUST hold lock on ");
            ((StringBuilder)object).append((Object)this);
            throw new AssertionError((Object)((StringBuilder)object).toString());
        }
        HttpUrl httpUrl = this.route.address().url();
        int n = object.port();
        int n2 = httpUrl.port();
        boolean bl = false;
        if (n != n2) {
            return false;
        }
        if (Intrinsics.areEqual((Object)object.host(), (Object)httpUrl.host())) {
            return true;
        }
        boolean bl2 = bl;
        if (this.noCoalescedConnections) return bl2;
        httpUrl = this.handshake;
        bl2 = bl;
        if (httpUrl == null) return bl2;
        Intrinsics.checkNotNull((Object)httpUrl);
        bl2 = bl;
        if (!this.certificateSupportHost((HttpUrl)object, (Handshake)httpUrl)) return bl2;
        bl2 = true;
        return bl2;
    }

    public final void cancel() {
        Socket socket = this.rawSocket;
        if (socket == null) return;
        Util.closeQuietly((Socket)socket);
    }

    public final void connect(int n, int n2, int n3, int n4, boolean bl, Call object, EventListener eventListener) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"call");
        Intrinsics.checkNotNullParameter((Object)eventListener, (String)"eventListener");
        boolean bl2 = this.protocol == null;
        if (!bl2) {
            object = new IllegalStateException("already connected".toString());
            throw object;
        }
        Object object2 = this.route.address().connectionSpecs();
        ConnectionSpecSelector connectionSpecSelector = new ConnectionSpecSelector((List)object2);
        if (this.route.address().sslSocketFactory() == null) {
            if (!object2.contains(ConnectionSpec.CLEARTEXT)) throw new RouteException((IOException)new UnknownServiceException("CLEARTEXT communication not enabled for client"));
            object2 = this.route.address().url().host();
            if (!Platform.Companion.get().isCleartextTrafficPermitted((String)object2)) {
                object = new StringBuilder();
                ((StringBuilder)object).append("CLEARTEXT communication to ");
                ((StringBuilder)object).append((String)object2);
                ((StringBuilder)object).append(" not permitted by network security policy");
                throw new RouteException((IOException)new UnknownServiceException(((StringBuilder)object).toString()));
            }
        } else if (this.route.address().protocols().contains(Protocol.H2_PRIOR_KNOWLEDGE)) throw new RouteException((IOException)new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"));
        RouteException routeException = null;
        while (true) {
            block19: {
                block18: {
                    block17: {
                        block16: {
                            try {
                                if (!this.route.requiresTunnel()) break block16;
                                this.connectTunnel(n, n2, n3, (Call)object, eventListener);
                                object2 = this.rawSocket;
                                if (object2 != null) break block17;
                                break block18;
                            }
                            catch (IOException iOException) {
                                // empty catch block
                                break block19;
                            }
                        }
                        try {
                            this.connectSocket(n, n2, (Call)object, eventListener);
                        }
                        catch (IOException iOException) {
                            break block19;
                        }
                    }
                    try {
                        this.establishProtocol(connectionSpecSelector, n4, (Call)object, eventListener);
                        eventListener.connectEnd((Call)object, this.route.socketAddress(), this.route.proxy(), this.protocol);
                    }
                    catch (IOException iOException) {
                        break block19;
                    }
                }
                if (this.route.requiresTunnel()) {
                    if (this.rawSocket == null) throw new RouteException((IOException)new ProtocolException("Too many tunnel connections attempted: 21"));
                }
                this.idleAtNs = System.nanoTime();
                return;
            }
            Socket socket = this.socket;
            if (socket != null) {
                Util.closeQuietly((Socket)socket);
            }
            socket = this.rawSocket;
            if (socket != null) {
                Util.closeQuietly((Socket)socket);
            }
            this.socket = null;
            this.rawSocket = null;
            this.source = null;
            this.sink = null;
            this.handshake = null;
            this.protocol = null;
            this.http2Connection = null;
            this.allocationLimit = 1;
            eventListener.connectFailed((Call)object, this.route.socketAddress(), this.route.proxy(), null, (IOException)object2);
            if (routeException == null) {
                routeException = new RouteException((IOException)object2);
            } else {
                routeException.addConnectException((IOException)object2);
            }
            if (!bl) throw routeException;
            if (!connectionSpecSelector.connectionFailed((IOException)object2)) throw routeException;
        }
    }

    public final void connectFailed$okhttp(OkHttpClient okHttpClient, Route route, IOException iOException) {
        Intrinsics.checkNotNullParameter((Object)okHttpClient, (String)"client");
        Intrinsics.checkNotNullParameter((Object)route, (String)"failedRoute");
        Intrinsics.checkNotNullParameter((Object)iOException, (String)"failure");
        if (route.proxy().type() != Proxy.Type.DIRECT) {
            Address address = route.address();
            address.proxySelector().connectFailed(address.url().uri(), route.proxy().address(), iOException);
        }
        okHttpClient.getRouteDatabase().failed(route);
    }

    public final List<Reference<RealCall>> getCalls() {
        return this.calls;
    }

    public final RealConnectionPool getConnectionPool() {
        return this.connectionPool;
    }

    public final long getIdleAtNs() {
        return this.idleAtNs;
    }

    public final boolean getNoNewExchanges() {
        return this.noNewExchanges;
    }

    public final int getRouteFailureCount$okhttp() {
        return this.routeFailureCount;
    }

    public Handshake handshake() {
        return this.handshake;
    }

    public final void incrementSuccessCount$okhttp() {
        synchronized (this) {
            ++this.successCount;
            return;
        }
    }

    public final boolean isEligible$okhttp(Address object, List<Route> certificatePinner) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"address");
        if (Util.assertionsEnabled && !Thread.holdsLock((Object)this)) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Thread ");
            ((StringBuilder)object).append((Object)Thread.currentThread().getName());
            ((StringBuilder)object).append(" MUST hold lock on ");
            ((StringBuilder)object).append((Object)this);
            throw new AssertionError((Object)((StringBuilder)object).toString());
        }
        if (this.calls.size() >= this.allocationLimit) return false;
        if (this.noNewExchanges) return false;
        if (!this.route.address().equalsNonHost$okhttp((Address)object)) {
            return false;
        }
        if (Intrinsics.areEqual((Object)object.url().host(), (Object)this.route().address().url().host())) {
            return true;
        }
        if (this.http2Connection == null) {
            return false;
        }
        if (certificatePinner == null) return false;
        if (!this.routeMatchesAny((List<Route>)certificatePinner)) return false;
        if (object.hostnameVerifier() != OkHostnameVerifier.INSTANCE) {
            return false;
        }
        if (!this.supportsUrl(object.url())) {
            return false;
        }
        try {
            certificatePinner = object.certificatePinner();
            Intrinsics.checkNotNull((Object)certificatePinner);
            object = object.url().host();
            Handshake handshake = this.handshake();
            Intrinsics.checkNotNull((Object)handshake);
            certificatePinner.check((String)object, handshake.peerCertificates());
            return true;
        }
        catch (SSLPeerUnverifiedException sSLPeerUnverifiedException) {
        }
        return false;
    }

    public final boolean isHealthy(boolean bl) {
        if (Util.assertionsEnabled && Thread.holdsLock((Object)this)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Thread ");
            stringBuilder.append((Object)Thread.currentThread().getName());
            stringBuilder.append(" MUST NOT hold lock on ");
            stringBuilder.append((Object)this);
            throw new AssertionError((Object)stringBuilder.toString());
        }
        long l = System.nanoTime();
        Socket socket = this.rawSocket;
        Intrinsics.checkNotNull((Object)socket);
        Socket socket2 = this.socket;
        Intrinsics.checkNotNull((Object)socket2);
        BufferedSource bufferedSource = this.source;
        Intrinsics.checkNotNull((Object)bufferedSource);
        if (socket.isClosed()) return false;
        if (socket2.isClosed()) return false;
        if (socket2.isInputShutdown()) return false;
        if (socket2.isOutputShutdown()) {
            return false;
        }
        socket = this.http2Connection;
        if (socket != null) {
            return socket.isHealthy(l);
        }
        synchronized (this) {
            long l2 = this.getIdleAtNs();
            // MONITOREXIT @DISABLED, blocks:[0, 1] lbl30 : MonitorExitStatement: MONITOREXIT : this
            if (l - l2 < 10000000000L) return true;
            if (!bl) return true;
        }
        return Util.isHealthy((Socket)socket2, (BufferedSource)bufferedSource);
    }

    public final boolean isMultiplexed$okhttp() {
        boolean bl = this.http2Connection != null;
        return bl;
    }

    public final ExchangeCodec newCodec$okhttp(OkHttpClient okHttpClient, RealInterceptorChain realInterceptorChain) throws SocketException {
        Intrinsics.checkNotNullParameter((Object)okHttpClient, (String)"client");
        Intrinsics.checkNotNullParameter((Object)realInterceptorChain, (String)"chain");
        Socket socket = this.socket;
        Intrinsics.checkNotNull((Object)socket);
        BufferedSource bufferedSource = this.source;
        Intrinsics.checkNotNull((Object)bufferedSource);
        BufferedSink bufferedSink = this.sink;
        Intrinsics.checkNotNull((Object)bufferedSink);
        Http2Connection http2Connection = this.http2Connection;
        if (http2Connection != null) {
            okHttpClient = (ExchangeCodec)new Http2ExchangeCodec(okHttpClient, this, realInterceptorChain, http2Connection);
        } else {
            socket.setSoTimeout(realInterceptorChain.readTimeoutMillis());
            bufferedSource.timeout().timeout((long)realInterceptorChain.getReadTimeoutMillis$okhttp(), TimeUnit.MILLISECONDS);
            bufferedSink.timeout().timeout((long)realInterceptorChain.getWriteTimeoutMillis$okhttp(), TimeUnit.MILLISECONDS);
            okHttpClient = (ExchangeCodec)new Http1ExchangeCodec(okHttpClient, this, bufferedSource, bufferedSink);
        }
        return okHttpClient;
    }

    public final RealWebSocket.Streams newWebSocketStreams$okhttp(Exchange exchange) throws SocketException {
        Intrinsics.checkNotNullParameter((Object)exchange, (String)"exchange");
        Socket socket = this.socket;
        Intrinsics.checkNotNull((Object)socket);
        BufferedSource bufferedSource = this.source;
        Intrinsics.checkNotNull((Object)bufferedSource);
        BufferedSink bufferedSink = this.sink;
        Intrinsics.checkNotNull((Object)bufferedSink);
        socket.setSoTimeout(0);
        this.noNewExchanges$okhttp();
        return (RealWebSocket.Streams)new /* Unavailable Anonymous Inner Class!! */;
    }

    public final void noCoalescedConnections$okhttp() {
        synchronized (this) {
            this.noCoalescedConnections = true;
            return;
        }
    }

    public final void noNewExchanges$okhttp() {
        synchronized (this) {
            this.noNewExchanges = true;
            return;
        }
    }

    public void onSettings(Http2Connection http2Connection, Settings settings) {
        synchronized (this) {
            Intrinsics.checkNotNullParameter((Object)http2Connection, (String)"connection");
            Intrinsics.checkNotNullParameter((Object)settings, (String)"settings");
            this.allocationLimit = settings.getMaxConcurrentStreams();
            return;
        }
    }

    public void onStream(Http2Stream http2Stream) throws IOException {
        Intrinsics.checkNotNullParameter((Object)http2Stream, (String)"stream");
        http2Stream.close(ErrorCode.REFUSED_STREAM, null);
    }

    public Protocol protocol() {
        Protocol protocol = this.protocol;
        Intrinsics.checkNotNull((Object)protocol);
        return protocol;
    }

    public Route route() {
        return this.route;
    }

    public final void setIdleAtNs(long l) {
        this.idleAtNs = l;
    }

    public final void setNoNewExchanges(boolean bl) {
        this.noNewExchanges = bl;
    }

    public final void setRouteFailureCount$okhttp(int n) {
        this.routeFailureCount = n;
    }

    public Socket socket() {
        Socket socket = this.socket;
        Intrinsics.checkNotNull((Object)socket);
        return socket;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Connection{");
        stringBuilder.append(this.route.address().url().host());
        stringBuilder.append(':');
        stringBuilder.append(this.route.address().url().port());
        stringBuilder.append(", proxy=");
        stringBuilder.append(this.route.proxy());
        stringBuilder.append(" hostAddress=");
        stringBuilder.append(this.route.socketAddress());
        stringBuilder.append(" cipherSuite=");
        Handshake handshake = this.handshake;
        String string = "none";
        if (handshake != null && (handshake = handshake.cipherSuite()) != null) {
            string = handshake;
        }
        stringBuilder.append((Object)string);
        stringBuilder.append(" protocol=");
        stringBuilder.append(this.protocol);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public final void trackFailure$okhttp(RealCall realCall, IOException iOException) {
        synchronized (this) {
            Intrinsics.checkNotNullParameter((Object)realCall, (String)"call");
            if (iOException instanceof StreamResetException) {
                if (((StreamResetException)iOException).errorCode == ErrorCode.REFUSED_STREAM) {
                    int n;
                    this.refusedStreamCount = n = this.refusedStreamCount + 1;
                    if (n <= 1) return;
                    this.noNewExchanges = true;
                    ++this.routeFailureCount;
                } else if (((StreamResetException)iOException).errorCode != ErrorCode.CANCEL || !realCall.isCanceled()) {
                    this.noNewExchanges = true;
                    ++this.routeFailureCount;
                }
            } else {
                if (this.isMultiplexed$okhttp()) {
                    if (!(iOException instanceof ConnectionShutdownException)) return;
                }
                this.noNewExchanges = true;
                if (this.successCount != 0) return;
                if (iOException != null) {
                    this.connectFailed$okhttp(realCall.getClient(), this.route, iOException);
                }
                ++this.routeFailureCount;
            }
            return;
        }
    }
}
