/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.ConnectionPool
 *  okhttp3.internal.connection.RealConnectionPool
 */
package okhttp3.internal.connection;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ConnectionPool;
import okhttp3.internal.connection.RealConnectionPool;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2={"Lokhttp3/internal/connection/RealConnectionPool$Companion;", "", "()V", "get", "Lokhttp3/internal/connection/RealConnectionPool;", "connectionPool", "Lokhttp3/ConnectionPool;", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class RealConnectionPool.Companion {
    private RealConnectionPool.Companion() {
    }

    public /* synthetic */ RealConnectionPool.Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final RealConnectionPool get(ConnectionPool connectionPool) {
        Intrinsics.checkNotNullParameter((Object)connectionPool, (String)"connectionPool");
        return connectionPool.getDelegate$okhttp();
    }
}
