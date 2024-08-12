/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.Route
 */
package okhttp3.internal.connection;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Route;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0005R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2={"Lokhttp3/internal/connection/RouteDatabase;", "", "()V", "failedRoutes", "", "Lokhttp3/Route;", "connected", "", "route", "failed", "failedRoute", "shouldPostpone", "", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class RouteDatabase {
    private final Set<Route> failedRoutes = new LinkedHashSet();

    public final void connected(Route route) {
        synchronized (this) {
            Intrinsics.checkNotNullParameter((Object)route, (String)"route");
            this.failedRoutes.remove(route);
            return;
        }
    }

    public final void failed(Route route) {
        synchronized (this) {
            Intrinsics.checkNotNullParameter((Object)route, (String)"failedRoute");
            this.failedRoutes.add(route);
            return;
        }
    }

    public final boolean shouldPostpone(Route route) {
        synchronized (this) {
            Intrinsics.checkNotNullParameter((Object)route, (String)"route");
            boolean bl = this.failedRoutes.contains(route);
            return bl;
        }
    }
}
