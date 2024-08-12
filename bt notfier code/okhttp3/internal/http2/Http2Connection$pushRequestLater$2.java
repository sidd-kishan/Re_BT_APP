/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Lambda
 *  okhttp3.internal.http2.ErrorCode
 *  okhttp3.internal.http2.Header
 *  okhttp3.internal.http2.Http2Connection
 */
package okhttp3.internal.http2;

import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Header;
import okhttp3.internal.http2.Http2Connection;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
static final class Http2Connection.pushRequestLater.2
extends Lambda
implements Function0<Unit> {
    final List<Header> $requestHeaders;
    final int $streamId;
    final Http2Connection this$0;

    Http2Connection.pushRequestLater.2(Http2Connection http2Connection, int n, List<Header> list) {
        this.this$0 = http2Connection;
        this.$streamId = n;
        this.$requestHeaders = list;
        super(0);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled unnecessary exception pruning
     */
    public final void invoke() {
        boolean bl = Http2Connection.access$getPushObserver$p((Http2Connection)this.this$0).onRequest(this.$streamId, this.$requestHeaders);
        Http2Connection http2Connection = this.this$0;
        int n = this.$streamId;
        if (!bl) return;
        try {
            http2Connection.getWriter().rstStream(n, ErrorCode.CANCEL);
            synchronized (http2Connection) {
                Http2Connection.access$getCurrentPushRequests$p((Http2Connection)http2Connection).remove(n);
            }
        }
        catch (IOException throwable) {
            return;
        }
    }
}
