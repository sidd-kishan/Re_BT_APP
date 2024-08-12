/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  okhttp3.internal.concurrent.Task
 *  okhttp3.internal.connection.RealConnectionPool
 */
package okhttp3.internal.connection;

import kotlin.Metadata;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.connection.RealConnectionPool;

@Metadata(d1={"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016\u00a8\u0006\u0004"}, d2={"okhttp3/internal/connection/RealConnectionPool$cleanupTask$1", "Lokhttp3/internal/concurrent/Task;", "runOnce", "", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class RealConnectionPool.cleanupTask.1
extends Task {
    final RealConnectionPool this$0;

    RealConnectionPool.cleanupTask.1(RealConnectionPool realConnectionPool, String string) {
        this.this$0 = realConnectionPool;
        super(string, false, 2, null);
    }

    public long runOnce() {
        return this.this$0.cleanup(System.nanoTime());
    }
}
