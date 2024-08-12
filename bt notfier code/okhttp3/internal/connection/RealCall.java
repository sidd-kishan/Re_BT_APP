/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.Address
 *  okhttp3.Call
 *  okhttp3.Callback
 *  okhttp3.CertificatePinner
 *  okhttp3.Connection
 *  okhttp3.EventListener
 *  okhttp3.HttpUrl
 *  okhttp3.OkHttpClient
 *  okhttp3.Request
 *  okhttp3.Response
 *  okhttp3.internal.Util
 *  okhttp3.internal.cache.CacheInterceptor
 *  okhttp3.internal.connection.ConnectInterceptor
 *  okhttp3.internal.connection.Exchange
 *  okhttp3.internal.connection.ExchangeFinder
 *  okhttp3.internal.connection.RealCall$AsyncCall
 *  okhttp3.internal.connection.RealCall$CallReference
 *  okhttp3.internal.connection.RealCall$timeout$1
 *  okhttp3.internal.connection.RealConnection
 *  okhttp3.internal.connection.RealConnectionPool
 *  okhttp3.internal.http.BridgeInterceptor
 *  okhttp3.internal.http.CallServerInterceptor
 *  okhttp3.internal.http.ExchangeCodec
 *  okhttp3.internal.http.RealInterceptorChain
 *  okhttp3.internal.http.RetryAndFollowUpInterceptor
 *  okhttp3.internal.platform.Platform
 *  okio.Timeout
 */
package okhttp3.internal.connection;

import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.CertificatePinner;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheInterceptor;
import okhttp3.internal.connection.ConnectInterceptor;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.ExchangeFinder;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RealConnectionPool;
import okhttp3.internal.http.BridgeInterceptor;
import okhttp3.internal.http.CallServerInterceptor;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http.RetryAndFollowUpInterceptor;
import okhttp3.internal.platform.Platform;
import okio.Timeout;

@Metadata(d1={"\u0000\u00a7\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001.\u0018\u00002\u00020\u0001:\u0002deB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u000e\u00101\u001a\u0002022\u0006\u0010\u0010\u001a\u00020\u000fJ!\u00103\u001a\u0002H4\"\n\b\u0000\u00104*\u0004\u0018\u0001052\u0006\u00106\u001a\u0002H4H\u0002\u00a2\u0006\u0002\u00107J\b\u00108\u001a\u000202H\u0002J\b\u00109\u001a\u000202H\u0016J\b\u0010:\u001a\u00020\u0001H\u0016J\u0010\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>H\u0002J\u0010\u0010?\u001a\u0002022\u0006\u0010@\u001a\u00020AH\u0016J\u0016\u0010B\u001a\u0002022\u0006\u0010C\u001a\u00020\u00052\u0006\u0010D\u001a\u00020\u0007J\b\u0010E\u001a\u00020FH\u0016J\u0015\u0010G\u001a\u0002022\u0006\u0010H\u001a\u00020\u0007H\u0000\u00a2\u0006\u0002\bIJ\r\u0010J\u001a\u00020FH\u0000\u00a2\u0006\u0002\bKJ\u0015\u0010L\u001a\u00020\u001e2\u0006\u0010M\u001a\u00020NH\u0000\u00a2\u0006\u0002\bOJ\b\u0010P\u001a\u00020\u0007H\u0016J\b\u0010Q\u001a\u00020\u0007H\u0016J;\u0010R\u001a\u0002H4\"\n\b\u0000\u00104*\u0004\u0018\u0001052\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010S\u001a\u00020\u00072\u0006\u0010T\u001a\u00020\u00072\u0006\u00106\u001a\u0002H4H\u0000\u00a2\u0006\u0004\bU\u0010VJ\u0019\u0010W\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u000105H\u0000\u00a2\u0006\u0002\bXJ\r\u0010Y\u001a\u00020ZH\u0000\u00a2\u0006\u0002\b[J\u000f\u0010\\\u001a\u0004\u0018\u00010]H\u0000\u00a2\u0006\u0002\b^J\b\u0010C\u001a\u00020\u0005H\u0016J\u0006\u0010_\u001a\u00020\u0007J\b\u0010-\u001a\u00020`H\u0016J\u0006\u00100\u001a\u000202J!\u0010a\u001a\u0002H4\"\n\b\u0000\u00104*\u0004\u0018\u0001052\u0006\u0010b\u001a\u0002H4H\u0002\u00a2\u0006\u0002\u00107J\b\u0010c\u001a\u00020ZH\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\"\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001aX\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\"\u0010&\u001a\u0004\u0018\u00010\u001e2\b\u0010\u000e\u001a\u0004\u0018\u00010\u001e@BX\u0080\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u00020.X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010/R\u000e\u00100\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006f"}, d2={"Lokhttp3/internal/connection/RealCall;", "Lokhttp3/Call;", "client", "Lokhttp3/OkHttpClient;", "originalRequest", "Lokhttp3/Request;", "forWebSocket", "", "(Lokhttp3/OkHttpClient;Lokhttp3/Request;Z)V", "callStackTrace", "", "canceled", "getClient", "()Lokhttp3/OkHttpClient;", "<set-?>", "Lokhttp3/internal/connection/RealConnection;", "connection", "getConnection", "()Lokhttp3/internal/connection/RealConnection;", "connectionPool", "Lokhttp3/internal/connection/RealConnectionPool;", "connectionToCancel", "getConnectionToCancel", "setConnectionToCancel", "(Lokhttp3/internal/connection/RealConnection;)V", "eventListener", "Lokhttp3/EventListener;", "getEventListener$okhttp", "()Lokhttp3/EventListener;", "exchange", "Lokhttp3/internal/connection/Exchange;", "exchangeFinder", "Lokhttp3/internal/connection/ExchangeFinder;", "executed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "expectMoreExchanges", "getForWebSocket", "()Z", "interceptorScopedExchange", "getInterceptorScopedExchange$okhttp", "()Lokhttp3/internal/connection/Exchange;", "getOriginalRequest", "()Lokhttp3/Request;", "requestBodyOpen", "responseBodyOpen", "timeout", "okhttp3/internal/connection/RealCall$timeout$1", "Lokhttp3/internal/connection/RealCall$timeout$1;", "timeoutEarlyExit", "acquireConnectionNoEvents", "", "callDone", "E", "Ljava/io/IOException;", "e", "(Ljava/io/IOException;)Ljava/io/IOException;", "callStart", "cancel", "clone", "createAddress", "Lokhttp3/Address;", "url", "Lokhttp3/HttpUrl;", "enqueue", "responseCallback", "Lokhttp3/Callback;", "enterNetworkInterceptorExchange", "request", "newExchangeFinder", "execute", "Lokhttp3/Response;", "exitNetworkInterceptorExchange", "closeExchange", "exitNetworkInterceptorExchange$okhttp", "getResponseWithInterceptorChain", "getResponseWithInterceptorChain$okhttp", "initExchange", "chain", "Lokhttp3/internal/http/RealInterceptorChain;", "initExchange$okhttp", "isCanceled", "isExecuted", "messageDone", "requestDone", "responseDone", "messageDone$okhttp", "(Lokhttp3/internal/connection/Exchange;ZZLjava/io/IOException;)Ljava/io/IOException;", "noMoreExchanges", "noMoreExchanges$okhttp", "redactedUrl", "", "redactedUrl$okhttp", "releaseConnectionNoEvents", "Ljava/net/Socket;", "releaseConnectionNoEvents$okhttp", "retryAfterFailure", "Lokio/Timeout;", "timeoutExit", "cause", "toLoggableString", "AsyncCall", "CallReference", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class RealCall
implements Call {
    private Object callStackTrace;
    private volatile boolean canceled;
    private final OkHttpClient client;
    private RealConnection connection;
    private final RealConnectionPool connectionPool;
    private volatile RealConnection connectionToCancel;
    private final EventListener eventListener;
    private volatile Exchange exchange;
    private ExchangeFinder exchangeFinder;
    private final AtomicBoolean executed;
    private boolean expectMoreExchanges;
    private final boolean forWebSocket;
    private Exchange interceptorScopedExchange;
    private final Request originalRequest;
    private boolean requestBodyOpen;
    private boolean responseBodyOpen;
    private final timeout.1 timeout;
    private boolean timeoutEarlyExit;

    public RealCall(OkHttpClient okHttpClient, Request request, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)okHttpClient, (String)"client");
        Intrinsics.checkNotNullParameter((Object)request, (String)"originalRequest");
        this.client = okHttpClient;
        this.originalRequest = request;
        this.forWebSocket = bl;
        this.connectionPool = okHttpClient.connectionPool().getDelegate$okhttp();
        this.eventListener = this.client.eventListenerFactory().create((Call)this);
        okHttpClient = new /* Unavailable Anonymous Inner Class!! */;
        okHttpClient.timeout((long)this.getClient().callTimeoutMillis(), TimeUnit.MILLISECONDS);
        request = Unit.INSTANCE;
        this.timeout = okHttpClient;
        this.executed = new AtomicBoolean();
        this.expectMoreExchanges = true;
    }

    public static final /* synthetic */ timeout.1 access$getTimeout$p(RealCall realCall) {
        return realCall.timeout;
    }

    public static final /* synthetic */ String access$toLoggableString(RealCall realCall) {
        return realCall.toLoggableString();
    }

    private final <E extends IOException> E callDone(E object) {
        Socket socket;
        Object object2;
        block11: {
            if (Util.assertionsEnabled && Thread.holdsLock(this)) {
                object = new StringBuilder();
                ((StringBuilder)object).append("Thread ");
                ((StringBuilder)object).append((Object)Thread.currentThread().getName());
                ((StringBuilder)object).append(" MUST NOT hold lock on ");
                ((StringBuilder)object).append(this);
                throw new AssertionError((Object)((StringBuilder)object).toString());
            }
            object2 = this.connection;
            if (object2 != null) {
                block8: {
                    block10: {
                        block9: {
                            if (Util.assertionsEnabled && Thread.holdsLock(object2)) {
                                object = new StringBuilder();
                                ((StringBuilder)object).append("Thread ");
                                ((StringBuilder)object).append((Object)Thread.currentThread().getName());
                                ((StringBuilder)object).append(" MUST NOT hold lock on ");
                                ((StringBuilder)object).append(object2);
                                throw new AssertionError((Object)((StringBuilder)object).toString());
                            }
                            synchronized (object2) {
                                socket = this.releaseConnectionNoEvents$okhttp();
                                // MONITOREXIT @DISABLED, blocks:[0, 1, 7] lbl28 : MonitorExitStatement: MONITOREXIT : var3_3 /* !! */ 
                                if (this.connection != null) break block8;
                                if (socket != null) break block9;
                                break block10;
                            }
                        }
                        Util.closeQuietly((Socket)socket);
                    }
                    this.eventListener.connectionReleased((Call)this, (Connection)object2);
                    break block11;
                }
                boolean bl = socket == null;
                if (!bl) throw (Throwable)new IllegalStateException("Check failed.".toString());
            }
        }
        object2 = this.timeoutExit(object);
        if (object != null) {
            socket = this.eventListener;
            object = this;
            Intrinsics.checkNotNull((Object)object2);
            socket.callFailed((Call)object, (IOException)object2);
        } else {
            this.eventListener.callEnd((Call)this);
        }
        return (E)object2;
    }

    private final void callStart() {
        this.callStackTrace = Platform.Companion.get().getStackTraceForCloseable("response.body().close()");
        this.eventListener.callStart((Call)this);
    }

    private final Address createAddress(HttpUrl httpUrl) {
        HostnameVerifier hostnameVerifier;
        HostnameVerifier hostnameVerifier2;
        SSLSocketFactory sSLSocketFactory;
        if (httpUrl.isHttps()) {
            sSLSocketFactory = this.client.sslSocketFactory();
            hostnameVerifier2 = this.client.hostnameVerifier();
            hostnameVerifier = this.client.certificatePinner();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = hostnameVerifier2 = null;
        }
        return new Address(httpUrl.host(), httpUrl.port(), this.client.dns(), this.client.socketFactory(), sSLSocketFactory, hostnameVerifier2, (CertificatePinner)hostnameVerifier, this.client.proxyAuthenticator(), this.client.proxy(), this.client.protocols(), this.client.connectionSpecs(), this.client.proxySelector());
    }

    private final <E extends IOException> E timeoutExit(E e) {
        if (this.timeoutEarlyExit) {
            return e;
        }
        if (!this.timeout.exit()) {
            return e;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (e == null) return (E)interruptedIOException;
        interruptedIOException.initCause(e);
        return (E)interruptedIOException;
    }

    private final String toLoggableString() {
        StringBuilder stringBuilder = new StringBuilder();
        String string = this.isCanceled() ? "canceled " : "";
        stringBuilder.append(string);
        string = this.forWebSocket ? "web socket" : "call";
        stringBuilder.append(string);
        stringBuilder.append(" to ");
        stringBuilder.append(this.redactedUrl$okhttp());
        return stringBuilder.toString();
    }

    public final void acquireConnectionNoEvents(RealConnection realConnection) {
        Intrinsics.checkNotNullParameter((Object)realConnection, (String)"connection");
        if (Util.assertionsEnabled && !Thread.holdsLock(realConnection)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Thread ");
            stringBuilder.append((Object)Thread.currentThread().getName());
            stringBuilder.append(" MUST hold lock on ");
            stringBuilder.append(realConnection);
            throw new AssertionError((Object)stringBuilder.toString());
        }
        boolean bl = this.connection == null;
        if (!bl) throw (Throwable)new IllegalStateException("Check failed.".toString());
        this.connection = realConnection;
        realConnection.getCalls().add(new CallReference(this, this.callStackTrace));
    }

    public void cancel() {
        if (this.canceled) {
            return;
        }
        this.canceled = true;
        Exchange exchange = this.exchange;
        if (exchange != null) {
            exchange.cancel();
        }
        exchange = this.connectionToCancel;
        if (exchange != null) {
            exchange.cancel();
        }
        this.eventListener.canceled((Call)this);
    }

    public Call clone() {
        return new RealCall(this.client, this.originalRequest, this.forWebSocket);
    }

    public void enqueue(Callback callback) {
        Intrinsics.checkNotNullParameter((Object)callback, (String)"responseCallback");
        if (!this.executed.compareAndSet(false, true)) throw (Throwable)new IllegalStateException("Already Executed".toString());
        this.callStart();
        this.client.dispatcher().enqueue$okhttp(new AsyncCall(this, callback));
    }

    /*
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    public final void enterNetworkInterceptorExchange(Request object, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"request");
        boolean bl2 = this.interceptorScopedExchange == null;
        if (!bl2) throw (Throwable)new IllegalStateException("Check failed.".toString());
        synchronized (this) {
            if (!(this.responseBodyOpen ^ true)) {
                object = new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()".toString());
                throw (Throwable)object;
            }
            if (this.requestBodyOpen ^ true) {
                void var2_2;
                Unit unit = Unit.INSTANCE;
                // MONITOREXIT @DISABLED, blocks:[2, 3] lbl10 : MonitorExitStatement: MONITOREXIT : this
                if (var2_2 == false) return;
                this.exchangeFinder = new ExchangeFinder(this.connectionPool, this.createAddress(object.url()), this, this.eventListener);
                return;
            }
            object = new IllegalStateException("Check failed.".toString());
            throw (Throwable)object;
        }
    }

    public Response execute() {
        if (!this.executed.compareAndSet(false, true)) throw (Throwable)new IllegalStateException("Already Executed".toString());
        this.timeout.enter();
        this.callStart();
        try {
            this.client.dispatcher().executed$okhttp(this);
            Response response = this.getResponseWithInterceptorChain$okhttp();
            return response;
        }
        finally {
            this.client.dispatcher().finished$okhttp(this);
        }
    }

    /*
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    public final void exitNetworkInterceptorExchange$okhttp(boolean bl) {
        // MONITORENTER : this
        if (!this.expectMoreExchanges) {
            IllegalStateException illegalStateException = new IllegalStateException("released".toString());
            throw (Throwable)illegalStateException;
        }
        Unit unit = Unit.INSTANCE;
        // MONITOREXIT : this
        if (bl && (unit = this.exchange) != null) {
            unit.detachWithViolence();
        }
        this.interceptorScopedExchange = null;
    }

    public final OkHttpClient getClient() {
        return this.client;
    }

    public final RealConnection getConnection() {
        return this.connection;
    }

    public final RealConnection getConnectionToCancel() {
        return this.connectionToCancel;
    }

    public final EventListener getEventListener$okhttp() {
        return this.eventListener;
    }

    public final boolean getForWebSocket() {
        return this.forWebSocket;
    }

    public final Exchange getInterceptorScopedExchange$okhttp() {
        return this.interceptorScopedExchange;
    }

    public final Request getOriginalRequest() {
        return this.originalRequest;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     */
    public final Response getResponseWithInterceptorChain$okhttp() throws IOException {
        boolean bl;
        boolean bl2;
        Object object;
        block7: {
            List list = new ArrayList();
            object = list;
            CollectionsKt.addAll((Collection)object, (Iterable)this.client.interceptors());
            object.add(new RetryAndFollowUpInterceptor(this.client));
            object.add(new BridgeInterceptor(this.client.cookieJar()));
            object.add(new CacheInterceptor(this.client.cache()));
            object.add(ConnectInterceptor.INSTANCE);
            if (!this.forWebSocket) {
                CollectionsKt.addAll((Collection)object, (Iterable)this.client.networkInterceptors());
            }
            object.add(new CallServerInterceptor(this.forWebSocket));
            object = new RealInterceptorChain(this, list, 0, null, this.originalRequest, this.client.connectTimeoutMillis(), this.client.readTimeoutMillis(), this.client.writeTimeoutMillis());
            bl = bl2 = false;
            try {
                object = object.proceed(this.originalRequest);
                bl = bl2;
                boolean bl3 = this.isCanceled();
                if (bl3) break block7;
                this.noMoreExchanges$okhttp(null);
            }
            catch (IOException iOException) {
                bl = bl2 = true;
                Exception exception = this.noMoreExchanges$okhttp(iOException);
                if (exception == null) {
                    bl = bl2;
                    bl = bl2;
                    exception = new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
                    bl = bl2;
                    throw exception;
                }
                bl = bl2;
                throw (Throwable)exception;
            }
            return object;
        }
        bl = bl2;
        {
            Util.closeQuietly((Closeable)((Closeable)object));
            bl = bl2;
            bl = bl2;
            object = new IOException("Canceled");
            bl = bl2;
            throw object;
        }
        catch (Throwable throwable222222) {}
        if (bl) throw throwable222222;
        this.noMoreExchanges$okhttp(null);
        throw throwable222222;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final Exchange initExchange$okhttp(RealInterceptorChain object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"chain");
        synchronized (this) {
            if (!this.expectMoreExchanges) {
                object = new IllegalStateException("released".toString());
                throw (Throwable)object;
            }
            if (!(this.responseBodyOpen ^ true)) {
                object = new IllegalStateException("Check failed.".toString());
                throw (Throwable)object;
            }
            if (this.requestBodyOpen ^ true) {
                Unit unit = Unit.INSTANCE;
                // MONITOREXIT @DISABLED, blocks:[3, 5] lbl11 : MonitorExitStatement: MONITOREXIT : this
                unit = this.exchangeFinder;
                Intrinsics.checkNotNull((Object)unit);
                object = unit.find(this.client, object);
                object = new Exchange(this, this.eventListener, (ExchangeFinder)unit, (ExchangeCodec)object);
                this.interceptorScopedExchange = object;
                this.exchange = object;
                synchronized (this) {
                    this.requestBodyOpen = true;
                    this.responseBodyOpen = true;
                    unit = Unit.INSTANCE;
                }
                if (this.canceled) throw new IOException("Canceled");
                return object;
            }
            object = new IllegalStateException("Check failed.".toString());
            throw (Throwable)object;
        }
    }

    public boolean isCanceled() {
        return this.canceled;
    }

    public boolean isExecuted() {
        return this.executed.get();
    }

    /*
     * Unable to fully structure code
     */
    public final <E extends IOException> E messageDone$okhttp(Exchange var1_1, boolean var2_3, boolean var3_4, E var4_5) {
        block11: {
            block12: {
                Intrinsics.checkNotNullParameter((Object)var1_1, (String)"exchange");
                if (!Intrinsics.areEqual((Object)var1_1, (Object)this.exchange)) {
                    return var4_5;
                }
                synchronized (this) {
                    var5_6 = false;
                    var7_7 = false;
                    if (!var2_3) ** GOTO lbl10
                    try {
                        if (this.requestBodyOpen) ** GOTO lbl-1000
lbl10:
                        // 2 sources

                        if (var3_4 && this.responseBodyOpen) lbl-1000:
                        // 2 sources

                        {
                            if (var2_3) {
                                this.requestBodyOpen = false;
                            }
                            if (var3_4) {
                                this.responseBodyOpen = false;
                            }
                            var5_6 = this.requestBodyOpen == false && this.responseBodyOpen == false;
                            var6_8 = var7_7;
                            if (!this.requestBodyOpen) {
                                var6_8 = var7_7;
                                if (!this.responseBodyOpen) {
                                    var6_8 = var7_7;
                                    if (!this.expectMoreExchanges) {
                                        var6_8 = true;
                                    }
                                }
                            }
                        } else {
                            var6_8 = false;
                        }
                        var1_1 = Unit.INSTANCE;
                        // MONITOREXIT @DISABLED, blocks:[0, 1] lbl28 : MonitorExitStatement: MONITOREXIT : this
                        if (!var5_6) break block11;
                        this.exchange = null;
                        var1_1 = this.connection;
                        if (var1_1 != null) break block12;
                        break block11;
                    }
                    catch (Throwable var1_2) {
                        ** break block13
                    }
                }
            }
            var1_1.incrementSuccessCount$okhttp();
        }
        if (var6_8 == false) return var4_5;
        return this.callDone(var4_5);
lbl-1000:
        // 1 sources

        {
            throw var1_2;
        }
    }

    public final IOException noMoreExchanges$okhttp(IOException iOException) {
        synchronized (this) {
            boolean bl;
            boolean bl2 = this.expectMoreExchanges;
            boolean bl3 = bl = false;
            if (bl2) {
                this.expectMoreExchanges = false;
                bl3 = bl;
                if (!this.requestBodyOpen) {
                    bl3 = bl;
                    if (!this.responseBodyOpen) {
                        bl3 = true;
                    }
                }
            }
            Object object = Unit.INSTANCE;
            // MONITOREXIT @DISABLED, blocks:[0, 1] lbl13 : MonitorExitStatement: MONITOREXIT : this
            object = iOException;
            if (!bl3) return object;
            object = this.callDone(iOException);
            return object;
        }
    }

    public final String redactedUrl$okhttp() {
        return this.originalRequest.url().redact();
    }

    public final Socket releaseConnectionNoEvents$okhttp() {
        int n;
        boolean bl;
        List list;
        Object object;
        block5: {
            object = this.connection;
            Intrinsics.checkNotNull((Object)object);
            if (Util.assertionsEnabled && !Thread.holdsLock(object)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Thread ");
                stringBuilder.append((Object)Thread.currentThread().getName());
                stringBuilder.append(" MUST hold lock on ");
                stringBuilder.append(object);
                throw new AssertionError((Object)stringBuilder.toString());
            }
            list = object.getCalls();
            Iterator iterator = list.iterator();
            bl = false;
            n = 0;
            while (iterator.hasNext()) {
                if (!Intrinsics.areEqual(((Reference)iterator.next()).get(), (Object)this)) {
                    ++n;
                    continue;
                }
                break block5;
            }
            n = -1;
        }
        if (n != -1) {
            bl = true;
        }
        if (bl) {
            list.remove(n);
            this.connection = null;
            if (!list.isEmpty()) return null;
            object.setIdleAtNs(System.nanoTime());
            if (!this.connectionPool.connectionBecameIdle(object)) return null;
            return object.socket();
        }
        object = new IllegalStateException("Check failed.".toString());
        throw object;
    }

    public Request request() {
        return this.originalRequest;
    }

    public final boolean retryAfterFailure() {
        ExchangeFinder exchangeFinder = this.exchangeFinder;
        Intrinsics.checkNotNull((Object)exchangeFinder);
        return exchangeFinder.retryAfterFailure();
    }

    public final void setConnectionToCancel(RealConnection realConnection) {
        this.connectionToCancel = realConnection;
    }

    public Timeout timeout() {
        return (Timeout)this.timeout;
    }

    public final void timeoutEarlyExit() {
        if (!(this.timeoutEarlyExit ^ true)) throw (Throwable)new IllegalStateException("Check failed.".toString());
        this.timeoutEarlyExit = true;
        this.timeout.exit();
    }
}
