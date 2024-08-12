/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package okhttp3.internal.connection;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0015\u0010\u0003\u001a\u00020\u0004*\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2={"Lokhttp3/internal/connection/RouteSelector$Companion;", "", "()V", "socketHost", "", "Ljava/net/InetSocketAddress;", "getSocketHost", "(Ljava/net/InetSocketAddress;)Ljava/lang/String;", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class RouteSelector.Companion {
    private RouteSelector.Companion() {
    }

    public /* synthetic */ RouteSelector.Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final String getSocketHost(InetSocketAddress object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
        InetAddress inetAddress = ((InetSocketAddress)object).getAddress();
        if (inetAddress == null) {
            object = ((InetSocketAddress)object).getHostName();
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"hostName");
            return object;
        }
        object = inetAddress.getHostAddress();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"address.hostAddress");
        return object;
    }
}
