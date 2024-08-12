/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.Address
 */
package okhttp3;

import java.net.InetSocketAddress;
import java.net.Proxy;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Address;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\r\u0010\u0002\u001a\u00020\u0003H\u0007\u00a2\u0006\u0002\b\fJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\r\u0010\u0004\u001a\u00020\u0005H\u0007\u00a2\u0006\u0002\b\u0012J\u0006\u0010\u0013\u001a\u00020\u000eJ\r\u0010\u0006\u001a\u00020\u0007H\u0007\u00a2\u0006\u0002\b\u0014J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0013\u0010\u0002\u001a\u00020\u00038\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\tR\u0013\u0010\u0004\u001a\u00020\u00058\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\nR\u0013\u0010\u0006\u001a\u00020\u00078\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000b\u00a8\u0006\u0017"}, d2={"Lokhttp3/Route;", "", "address", "Lokhttp3/Address;", "proxy", "Ljava/net/Proxy;", "socketAddress", "Ljava/net/InetSocketAddress;", "(Lokhttp3/Address;Ljava/net/Proxy;Ljava/net/InetSocketAddress;)V", "()Lokhttp3/Address;", "()Ljava/net/Proxy;", "()Ljava/net/InetSocketAddress;", "-deprecated_address", "equals", "", "other", "hashCode", "", "-deprecated_proxy", "requiresTunnel", "-deprecated_socketAddress", "toString", "", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class Route {
    private final Address address;
    private final Proxy proxy;
    private final InetSocketAddress socketAddress;

    public Route(Address address, Proxy proxy, InetSocketAddress inetSocketAddress) {
        Intrinsics.checkNotNullParameter((Object)address, (String)"address");
        Intrinsics.checkNotNullParameter((Object)proxy, (String)"proxy");
        Intrinsics.checkNotNullParameter((Object)inetSocketAddress, (String)"socketAddress");
        this.address = address;
        this.proxy = proxy;
        this.socketAddress = inetSocketAddress;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="address", imports={}))
    public final Address _deprecated_address() {
        return this.address;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="proxy", imports={}))
    public final Proxy _deprecated_proxy() {
        return this.proxy;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="socketAddress", imports={}))
    public final InetSocketAddress _deprecated_socketAddress() {
        return this.socketAddress;
    }

    public final Address address() {
        return this.address;
    }

    /*
     * Enabled force condition propagation
     */
    public boolean equals(Object object) {
        if (!(object instanceof Route)) return false;
        object = (Route)object;
        if (!Intrinsics.areEqual((Object)((Route)object).address, (Object)this.address)) return false;
        if (!Intrinsics.areEqual((Object)((Route)object).proxy, (Object)this.proxy)) return false;
        if (!Intrinsics.areEqual((Object)((Route)object).socketAddress, (Object)this.socketAddress)) return false;
        return true;
    }

    public int hashCode() {
        return ((527 + this.address.hashCode()) * 31 + this.proxy.hashCode()) * 31 + this.socketAddress.hashCode();
    }

    public final Proxy proxy() {
        return this.proxy;
    }

    public final boolean requiresTunnel() {
        boolean bl = this.address.sslSocketFactory() != null && this.proxy.type() == Proxy.Type.HTTP;
        return bl;
    }

    public final InetSocketAddress socketAddress() {
        return this.socketAddress;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Route{");
        stringBuilder.append(this.socketAddress);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
