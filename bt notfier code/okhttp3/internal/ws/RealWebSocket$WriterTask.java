/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.internal.concurrent.Task
 *  okhttp3.internal.ws.RealWebSocket
 */
package okhttp3.internal.ws;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.ws.RealWebSocket;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2={"Lokhttp3/internal/ws/RealWebSocket$WriterTask;", "Lokhttp3/internal/concurrent/Task;", "(Lokhttp3/internal/ws/RealWebSocket;)V", "runOnce", "", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
private final class RealWebSocket.WriterTask
extends Task {
    final RealWebSocket this$0;

    public RealWebSocket.WriterTask(RealWebSocket realWebSocket) {
        Intrinsics.checkNotNullParameter((Object)realWebSocket, (String)"this$0");
        this.this$0 = realWebSocket;
        super(Intrinsics.stringPlus((String)RealWebSocket.access$getName$p((RealWebSocket)realWebSocket), (Object)" writer"), false, 2, null);
    }

    public long runOnce() {
        try {
            boolean bl = this.this$0.writeOneFrame$okhttp();
            if (!bl) return -1L;
            return 0L;
        }
        catch (IOException iOException) {
            this.this$0.failWebSocket((Exception)iOException, null);
        }
        return -1L;
    }
}
