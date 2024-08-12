/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Lambda
 *  okhttp3.internal.http2.ErrorCode
 *  okhttp3.internal.http2.Http2Connection
 *  okio.Buffer
 *  okio.BufferedSource
 */
package okhttp3.internal.http2;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Http2Connection;
import okio.Buffer;
import okio.BufferedSource;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
static final class Http2Connection.pushDataLater.1
extends Lambda
implements Function0<Unit> {
    final Buffer $buffer;
    final int $byteCount;
    final boolean $inFinished;
    final int $streamId;
    final Http2Connection this$0;

    Http2Connection.pushDataLater.1(Http2Connection http2Connection, int n, Buffer buffer, int n2, boolean bl) {
        this.this$0 = http2Connection;
        this.$streamId = n;
        this.$buffer = buffer;
        this.$byteCount = n2;
        this.$inFinished = bl;
        super(0);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled unnecessary exception pruning
     */
    public final void invoke() {
        Http2Connection http2Connection = this.this$0;
        int n = this.$streamId;
        Buffer buffer = this.$buffer;
        int n2 = this.$byteCount;
        boolean bl = this.$inFinished;
        try {
            boolean bl2 = Http2Connection.access$getPushObserver$p((Http2Connection)http2Connection).onData(n, (BufferedSource)buffer, n2, bl);
            if (bl2) {
                http2Connection.getWriter().rstStream(n, ErrorCode.CANCEL);
            }
            if (!bl2) {
                if (!bl) return;
            }
            synchronized (http2Connection) {
                Http2Connection.access$getCurrentPushRequests$p((Http2Connection)http2Connection).remove(n);
            }
        }
        catch (IOException iOException) {
            return;
        }
    }
}
