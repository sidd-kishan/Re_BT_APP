/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.Route
 *  okhttp3.internal.connection.RealConnection
 *  okhttp3.internal.connection.RealConnectionPool
 */
package okhttp3.internal.connection;

import java.net.Socket;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Route;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RealConnectionPool;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J&\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2={"Lokhttp3/internal/connection/RealConnection$Companion;", "", "()V", "IDLE_CONNECTION_HEALTHY_NS", "", "MAX_TUNNEL_ATTEMPTS", "", "NPE_THROW_WITH_NULL", "", "newTestConnection", "Lokhttp3/internal/connection/RealConnection;", "connectionPool", "Lokhttp3/internal/connection/RealConnectionPool;", "route", "Lokhttp3/Route;", "socket", "Ljava/net/Socket;", "idleAtNs", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class RealConnection.Companion {
    private RealConnection.Companion() {
    }

    public /* synthetic */ RealConnection.Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final RealConnection newTestConnection(RealConnectionPool realConnectionPool, Route route, Socket socket, long l) {
        Intrinsics.checkNotNullParameter((Object)realConnectionPool, (String)"connectionPool");
        Intrinsics.checkNotNullParameter((Object)route, (String)"route");
        Intrinsics.checkNotNullParameter((Object)socket, (String)"socket");
        realConnectionPool = new RealConnection(realConnectionPool, route);
        RealConnection.access$setSocket$p((RealConnection)realConnectionPool, (Socket)socket);
        realConnectionPool.setIdleAtNs(l);
        return realConnectionPool;
    }
}
