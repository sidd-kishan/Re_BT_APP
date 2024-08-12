/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.Address
 *  okhttp3.Call
 *  okhttp3.EventListener
 *  okhttp3.HttpUrl
 *  okhttp3.Route
 *  okhttp3.internal.Util
 *  okhttp3.internal.connection.RouteDatabase
 *  okhttp3.internal.connection.RouteSelector$Companion
 *  okhttp3.internal.connection.RouteSelector$Selection
 */
package okhttp3.internal.connection;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RouteDatabase;
import okhttp3.internal.connection.RouteSelector;

@Metadata(d1={"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 !2\u00020\u0001:\u0002!\"B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0015\u001a\u00020\u0016H\u0086\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\t\u0010\u0018\u001a\u00020\u0019H\u0086\u0002J\b\u0010\u001a\u001a\u00020\u0014H\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0014H\u0002J\u001a\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0014H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2={"Lokhttp3/internal/connection/RouteSelector;", "", "address", "Lokhttp3/Address;", "routeDatabase", "Lokhttp3/internal/connection/RouteDatabase;", "call", "Lokhttp3/Call;", "eventListener", "Lokhttp3/EventListener;", "(Lokhttp3/Address;Lokhttp3/internal/connection/RouteDatabase;Lokhttp3/Call;Lokhttp3/EventListener;)V", "inetSocketAddresses", "", "Ljava/net/InetSocketAddress;", "nextProxyIndex", "", "postponedRoutes", "", "Lokhttp3/Route;", "proxies", "Ljava/net/Proxy;", "hasNext", "", "hasNextProxy", "next", "Lokhttp3/internal/connection/RouteSelector$Selection;", "nextProxy", "resetNextInetSocketAddress", "", "proxy", "resetNextProxy", "url", "Lokhttp3/HttpUrl;", "Companion", "Selection", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class RouteSelector {
    public static final Companion Companion = new Companion(null);
    private final Address address;
    private final Call call;
    private final EventListener eventListener;
    private List<? extends InetSocketAddress> inetSocketAddresses;
    private int nextProxyIndex;
    private final List<Route> postponedRoutes;
    private List<? extends Proxy> proxies;
    private final RouteDatabase routeDatabase;

    public RouteSelector(Address address, RouteDatabase routeDatabase, Call call, EventListener eventListener) {
        Intrinsics.checkNotNullParameter((Object)address, (String)"address");
        Intrinsics.checkNotNullParameter((Object)routeDatabase, (String)"routeDatabase");
        Intrinsics.checkNotNullParameter((Object)call, (String)"call");
        Intrinsics.checkNotNullParameter((Object)eventListener, (String)"eventListener");
        this.address = address;
        this.routeDatabase = routeDatabase;
        this.call = call;
        this.eventListener = eventListener;
        this.proxies = CollectionsKt.emptyList();
        this.inetSocketAddresses = CollectionsKt.emptyList();
        this.postponedRoutes = new ArrayList();
        this.resetNextProxy(this.address.url(), this.address.proxy());
    }

    private final boolean hasNextProxy() {
        boolean bl = this.nextProxyIndex < this.proxies.size();
        return bl;
    }

    private final Proxy nextProxy() throws IOException {
        if (this.hasNextProxy()) {
            Object object = this.proxies;
            int n = this.nextProxyIndex;
            this.nextProxyIndex = n + 1;
            object = object.get(n);
            this.resetNextInetSocketAddress((Proxy)object);
            return object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("No route to ");
        stringBuilder.append(this.address.url().host());
        stringBuilder.append("; exhausted proxy configurations: ");
        stringBuilder.append(this.proxies);
        throw new SocketException(stringBuilder.toString());
    }

    private final void resetNextInetSocketAddress(Proxy object) throws IOException {
        boolean bl;
        int n;
        Object object2;
        List list;
        this.inetSocketAddresses = list = (List)new ArrayList();
        if (((Proxy)object).type() != Proxy.Type.DIRECT && ((Proxy)object).type() != Proxy.Type.SOCKS) {
            SocketAddress socketAddress = ((Proxy)object).address();
            if (!(socketAddress instanceof InetSocketAddress)) throw (Throwable)new IllegalArgumentException(Intrinsics.stringPlus((String)"Proxy.address() is not an InetSocketAddress: ", socketAddress.getClass()).toString());
            object2 = Companion;
            Intrinsics.checkNotNullExpressionValue((Object)socketAddress, (String)"proxyAddress");
            socketAddress = (InetSocketAddress)socketAddress;
            object2 = object2.getSocketHost((InetSocketAddress)socketAddress);
            n = ((InetSocketAddress)socketAddress).getPort();
        } else {
            object2 = this.address.url().host();
            n = this.address.url().port();
        }
        boolean bl2 = bl = false;
        if (1 <= n) {
            bl2 = bl;
            if (n <= 65535) {
                bl2 = true;
            }
        }
        if (!bl2) {
            object = new StringBuilder();
            ((StringBuilder)object).append("No route to ");
            ((StringBuilder)object).append((String)object2);
            ((StringBuilder)object).append(':');
            ((StringBuilder)object).append(n);
            ((StringBuilder)object).append("; port is out of range");
            object = new SocketException(((StringBuilder)object).toString());
            throw object;
        }
        if (((Proxy)object).type() == Proxy.Type.SOCKS) {
            ((Collection)list).add(InetSocketAddress.createUnresolved((String)object2, n));
            return;
        }
        this.eventListener.dnsStart(this.call, (String)object2);
        object = this.address.dns().lookup((String)object2);
        if (object.isEmpty()) {
            object = new StringBuilder();
            ((StringBuilder)object).append(this.address.dns());
            ((StringBuilder)object).append(" returned no addresses for ");
            ((StringBuilder)object).append((String)object2);
            throw new UnknownHostException(((StringBuilder)object).toString());
        }
        this.eventListener.dnsEnd(this.call, (String)object2, (List)object);
        object2 = object.iterator();
        while (object2.hasNext()) {
            object = (InetAddress)object2.next();
            ((Collection)list).add(new InetSocketAddress((InetAddress)object, n));
        }
    }

    private final void resetNextProxy(HttpUrl httpUrl, Proxy object) {
        this.eventListener.proxySelectStart(this.call, httpUrl);
        this.proxies = object = RouteSelector.resetNextProxy$selectProxies((Proxy)object, httpUrl, this);
        this.nextProxyIndex = 0;
        this.eventListener.proxySelectEnd(this.call, httpUrl, (List)object);
    }

    private static final List<Proxy> resetNextProxy$selectProxies(Proxy object, HttpUrl object2, RouteSelector routeSelector) {
        if (object != null) {
            return CollectionsKt.listOf((Object)object);
        }
        object = object2.uri();
        if (((URI)object).getHost() == null) {
            return Util.immutableListOf((Object[])new Proxy[]{Proxy.NO_PROXY});
        }
        object2 = routeSelector.address.proxySelector().select((URI)object);
        object = (Collection)object2;
        boolean bl = object == null || object.isEmpty();
        if (bl) {
            return Util.immutableListOf((Object[])new Proxy[]{Proxy.NO_PROXY});
        }
        Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"proxiesOrNull");
        return Util.toImmutableList((List)object2);
    }

    public final boolean hasNext() {
        boolean bl;
        boolean bl2 = this.hasNextProxy();
        boolean bl3 = bl = true;
        if (bl2) return bl3;
        bl3 = ((Collection)this.postponedRoutes).isEmpty() ^ true ? bl : false;
        return bl3;
    }

    public final Selection next() throws IOException {
        if (!this.hasNext()) {
            NoSuchElementException noSuchElementException = new NoSuchElementException();
            throw noSuchElementException;
        }
        List list = new ArrayList();
        while (this.hasNextProxy()) {
            Proxy proxy = this.nextProxy();
            for (InetSocketAddress inetSocketAddress : this.inetSocketAddresses) {
                Route inetSocketAddress2 = new Route(this.address, proxy, inetSocketAddress);
                if (this.routeDatabase.shouldPostpone(inetSocketAddress2)) {
                    ((Collection)this.postponedRoutes).add(inetSocketAddress2);
                    continue;
                }
                ((Collection)list).add(inetSocketAddress2);
            }
            if (!(((Collection)list).isEmpty() ^ true)) continue;
        }
        if (!list.isEmpty()) return new Selection(list);
        CollectionsKt.addAll((Collection)list, (Iterable)this.postponedRoutes);
        this.postponedRoutes.clear();
        return new Selection(list);
    }
}
