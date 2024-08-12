/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.Address
 *  okhttp3.Call
 *  okhttp3.Connection
 *  okhttp3.EventListener
 *  okhttp3.HttpUrl
 *  okhttp3.OkHttpClient
 *  okhttp3.Route
 *  okhttp3.internal.Util
 *  okhttp3.internal.connection.RealCall
 *  okhttp3.internal.connection.RealConnection
 *  okhttp3.internal.connection.RealConnectionPool
 *  okhttp3.internal.connection.RouteException
 *  okhttp3.internal.connection.RouteSelector
 *  okhttp3.internal.connection.RouteSelector$Selection
 *  okhttp3.internal.http.ExchangeCodec
 *  okhttp3.internal.http.RealInterceptorChain
 *  okhttp3.internal.http2.ConnectionShutdownException
 *  okhttp3.internal.http2.ErrorCode
 *  okhttp3.internal.http2.StreamResetException
 */
package okhttp3.internal.connection;

import java.io.IOException;
import java.net.Socket;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RealConnectionPool;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.connection.RouteSelector;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;

@Metadata(d1={"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ0\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020$H\u0002J8\u0010%\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020$2\u0006\u0010&\u001a\u00020$H\u0002J\u0006\u0010'\u001a\u00020$J\n\u0010(\u001a\u0004\u0018\u00010\u0010H\u0002J\u000e\u0010)\u001a\u00020$2\u0006\u0010*\u001a\u00020+J\u000e\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00060"}, d2={"Lokhttp3/internal/connection/ExchangeFinder;", "", "connectionPool", "Lokhttp3/internal/connection/RealConnectionPool;", "address", "Lokhttp3/Address;", "call", "Lokhttp3/internal/connection/RealCall;", "eventListener", "Lokhttp3/EventListener;", "(Lokhttp3/internal/connection/RealConnectionPool;Lokhttp3/Address;Lokhttp3/internal/connection/RealCall;Lokhttp3/EventListener;)V", "getAddress$okhttp", "()Lokhttp3/Address;", "connectionShutdownCount", "", "nextRouteToTry", "Lokhttp3/Route;", "otherFailureCount", "refusedStreamCount", "routeSelection", "Lokhttp3/internal/connection/RouteSelector$Selection;", "routeSelector", "Lokhttp3/internal/connection/RouteSelector;", "find", "Lokhttp3/internal/http/ExchangeCodec;", "client", "Lokhttp3/OkHttpClient;", "chain", "Lokhttp3/internal/http/RealInterceptorChain;", "findConnection", "Lokhttp3/internal/connection/RealConnection;", "connectTimeout", "readTimeout", "writeTimeout", "pingIntervalMillis", "connectionRetryEnabled", "", "findHealthyConnection", "doExtensiveHealthChecks", "retryAfterFailure", "retryRoute", "sameHostAndPort", "url", "Lokhttp3/HttpUrl;", "trackFailure", "", "e", "Ljava/io/IOException;", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class ExchangeFinder {
    private final Address address;
    private final RealCall call;
    private final RealConnectionPool connectionPool;
    private int connectionShutdownCount;
    private final EventListener eventListener;
    private Route nextRouteToTry;
    private int otherFailureCount;
    private int refusedStreamCount;
    private RouteSelector.Selection routeSelection;
    private RouteSelector routeSelector;

    public ExchangeFinder(RealConnectionPool realConnectionPool, Address address, RealCall realCall, EventListener eventListener) {
        Intrinsics.checkNotNullParameter((Object)realConnectionPool, (String)"connectionPool");
        Intrinsics.checkNotNullParameter((Object)address, (String)"address");
        Intrinsics.checkNotNullParameter((Object)realCall, (String)"call");
        Intrinsics.checkNotNullParameter((Object)eventListener, (String)"eventListener");
        this.connectionPool = realConnectionPool;
        this.address = address;
        this.call = realCall;
        this.eventListener = eventListener;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private final RealConnection findConnection(int var1_1, int var2_2, int var3_3, int var4_4, boolean var5_5) throws IOException {
        if (this.call.isCanceled()) {
            var7_12 = new IOException("Canceled");
            throw var7_12;
        }
        var8_6 /* !! */  = this.call.getConnection();
        var6_7 = 1;
        if (var8_6 /* !! */  != null) {
            synchronized (var8_6 /* !! */ ) {
                var7_8 /* !! */  = !var8_6 /* !! */ .getNoNewExchanges() && this.sameHostAndPort(var8_6 /* !! */ .route().address().url()) ? null : this.call.releaseConnectionNoEvents$okhttp();
                var9_13 = Unit.INSTANCE;
            }
            if (this.call.getConnection() != null) {
                var1_1 = var7_8 /* !! */  == null ? var6_7 : 0;
                if (var1_1 == 0) throw (Throwable)new IllegalStateException("Check failed.".toString());
                return var8_6 /* !! */ ;
            }
            if (var7_8 /* !! */  != null) {
                Util.closeQuietly((Socket)var7_8 /* !! */ );
            }
            this.eventListener.connectionReleased((Call)this.call, (Connection)var8_6 /* !! */ );
        }
        this.refusedStreamCount = 0;
        this.connectionShutdownCount = 0;
        this.otherFailureCount = 0;
        if (this.connectionPool.callAcquirePooledConnection(this.address, this.call, null, false)) {
            var7_8 /* !! */  = this.call.getConnection();
            Intrinsics.checkNotNull((Object)var7_8 /* !! */ );
            this.eventListener.connectionAcquired((Call)this.call, (Connection)var7_8 /* !! */ );
            return var7_8 /* !! */ ;
        }
        var7_8 /* !! */  = this.nextRouteToTry;
        if (var7_8 /* !! */  != null) {
            Intrinsics.checkNotNull((Object)var7_8 /* !! */ );
            this.nextRouteToTry = null;
lbl33:
            // 2 sources

            while (true) {
                var8_6 /* !! */  = null;
                break;
            }
        } else {
            var7_8 /* !! */  = this.routeSelection;
            if (var7_8 /* !! */  != null) {
                Intrinsics.checkNotNull((Object)var7_8 /* !! */ );
                if (var7_8 /* !! */ .hasNext()) {
                    var7_8 /* !! */  = this.routeSelection;
                    Intrinsics.checkNotNull((Object)var7_8 /* !! */ );
                    var7_8 /* !! */  = var7_8 /* !! */ .next();
                    ** continue;
                }
            }
            var8_6 /* !! */  = this.routeSelector;
            var7_8 /* !! */  = var8_6 /* !! */ ;
            if (var8_6 /* !! */  == null) {
                var7_8 /* !! */  = new RouteSelector(this.address, this.call.getClient().getRouteDatabase(), (Call)this.call, this.eventListener);
                this.routeSelector = var7_8 /* !! */ ;
            }
            var7_8 /* !! */  = var7_8 /* !! */ .next();
            this.routeSelection = var7_8 /* !! */ ;
            var8_6 /* !! */  = var7_8 /* !! */ .getRoutes();
            if (this.call.isCanceled() != false) throw new IOException("Canceled");
            if (this.connectionPool.callAcquirePooledConnection(this.address, this.call, (List)var8_6 /* !! */ , false)) {
                var7_8 /* !! */  = this.call.getConnection();
                Intrinsics.checkNotNull((Object)var7_8 /* !! */ );
                this.eventListener.connectionAcquired((Call)this.call, (Connection)var7_8 /* !! */ );
                return var7_8 /* !! */ ;
            }
            var7_8 /* !! */  = var7_8 /* !! */ .next();
        }
        var9_13 = new RealConnection(this.connectionPool, (Route)var7_8 /* !! */ );
        this.call.setConnectionToCancel((RealConnection)var9_13);
        var9_13.connect(var1_1, var2_2, var3_3, var4_4, var5_5, (Call)this.call, this.eventListener);
        this.call.getClient().getRouteDatabase().connected(var9_13.route());
        if (this.connectionPool.callAcquirePooledConnection(this.address, this.call, (List)var8_6 /* !! */ , true)) {
            var8_6 /* !! */  = this.call.getConnection();
            Intrinsics.checkNotNull((Object)var8_6 /* !! */ );
            this.nextRouteToTry = var7_8 /* !! */ ;
            Util.closeQuietly((Socket)var9_13.socket());
            this.eventListener.connectionAcquired((Call)this.call, (Connection)var8_6 /* !! */ );
            return var8_6 /* !! */ ;
        }
        synchronized (var9_13) {
            this.connectionPool.put((RealConnection)var9_13);
            this.call.acquireConnectionNoEvents((RealConnection)var9_13);
            var7_8 /* !! */  = Unit.INSTANCE;
        }
        this.eventListener.connectionAcquired((Call)this.call, (Connection)var9_13);
        return var9_13;
        finally {
            this.call.setConnectionToCancel(null);
        }
    }

    private final RealConnection findHealthyConnection(int n, int n2, int n3, int n4, boolean bl, boolean bl2) throws IOException {
        Object object;
        while (true) {
            if ((object = this.findConnection(n, n2, n3, n4, bl)).isHealthy(bl2)) {
                return object;
            }
            object.noNewExchanges$okhttp();
            if (this.nextRouteToTry != null) continue;
            object = this.routeSelection;
            boolean bl3 = true;
            boolean bl4 = object == null ? true : object.hasNext();
            if (!bl4 && !(bl4 = (object = this.routeSelector) == null ? bl3 : object.hasNext())) break;
        }
        object = new IOException("exhausted all routes");
        throw object;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    private final Route retryRoute() {
        if (this.refusedStreamCount > 1) return null;
        if (this.connectionShutdownCount > 1) return null;
        if (this.otherFailureCount > 0) {
            return null;
        }
        RealConnection realConnection = this.call.getConnection();
        if (realConnection == null) {
            return null;
        }
        synchronized (realConnection) {
            int n = realConnection.getRouteFailureCount$okhttp();
            if (n != 0) {
                return null;
            }
            boolean bl = Util.canReuseConnectionFor((HttpUrl)realConnection.route().address().url(), (HttpUrl)this.getAddress$okhttp().url());
            if (bl) return realConnection.route();
            return null;
        }
    }

    public final ExchangeCodec find(OkHttpClient okHttpClient, RealInterceptorChain realInterceptorChain) {
        Intrinsics.checkNotNullParameter((Object)okHttpClient, (String)"client");
        Intrinsics.checkNotNullParameter((Object)realInterceptorChain, (String)"chain");
        try {
            int n = realInterceptorChain.getConnectTimeoutMillis$okhttp();
            int n2 = realInterceptorChain.getReadTimeoutMillis$okhttp();
            int n3 = realInterceptorChain.getWriteTimeoutMillis$okhttp();
            int n4 = okHttpClient.pingIntervalMillis();
            boolean bl = okHttpClient.retryOnConnectionFailure();
            boolean bl2 = !Intrinsics.areEqual((Object)realInterceptorChain.getRequest$okhttp().method(), (Object)"GET");
            okHttpClient = this.findHealthyConnection(n, n2, n3, n4, bl, bl2).newCodec$okhttp(okHttpClient, realInterceptorChain);
            return okHttpClient;
        }
        catch (IOException iOException) {
            this.trackFailure(iOException);
            throw new RouteException(iOException);
        }
        catch (RouteException routeException) {
            this.trackFailure(routeException.getLastConnectException());
            throw routeException;
        }
    }

    public final Address getAddress$okhttp() {
        return this.address;
    }

    public final boolean retryAfterFailure() {
        int n = this.refusedStreamCount;
        boolean bl = false;
        if (n == 0 && this.connectionShutdownCount == 0 && this.otherFailureCount == 0) {
            return false;
        }
        if (this.nextRouteToTry != null) {
            return true;
        }
        Route route = this.retryRoute();
        if (route != null) {
            this.nextRouteToTry = route;
            return true;
        }
        route = this.routeSelection;
        if (route != null && route.hasNext()) {
            bl = true;
        }
        if (bl) {
            return true;
        }
        route = this.routeSelector;
        if (route != null) return route.hasNext();
        return true;
    }

    public final boolean sameHostAndPort(HttpUrl httpUrl) {
        Intrinsics.checkNotNullParameter((Object)httpUrl, (String)"url");
        HttpUrl httpUrl2 = this.address.url();
        boolean bl = httpUrl.port() == httpUrl2.port() && Intrinsics.areEqual((Object)httpUrl.host(), (Object)httpUrl2.host());
        return bl;
    }

    public final void trackFailure(IOException iOException) {
        Intrinsics.checkNotNullParameter((Object)iOException, (String)"e");
        this.nextRouteToTry = null;
        if (iOException instanceof StreamResetException && ((StreamResetException)iOException).errorCode == ErrorCode.REFUSED_STREAM) {
            ++this.refusedStreamCount;
        } else if (iOException instanceof ConnectionShutdownException) {
            ++this.connectionShutdownCount;
        } else {
            ++this.otherFailureCount;
        }
    }
}
