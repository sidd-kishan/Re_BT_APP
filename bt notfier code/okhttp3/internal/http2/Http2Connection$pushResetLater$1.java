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
 */
package okhttp3.internal.http2;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Http2Connection;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
static final class Http2Connection.pushResetLater.1
extends Lambda
implements Function0<Unit> {
    final ErrorCode $errorCode;
    final int $streamId;
    final Http2Connection this$0;

    Http2Connection.pushResetLater.1(Http2Connection http2Connection, int n, ErrorCode errorCode) {
        this.this$0 = http2Connection;
        this.$streamId = n;
        this.$errorCode = errorCode;
        super(0);
    }

    public final void invoke() {
        Http2Connection.access$getPushObserver$p((Http2Connection)this.this$0).onReset(this.$streamId, this.$errorCode);
        Http2Connection http2Connection = this.this$0;
        int n = this.$streamId;
        synchronized (http2Connection) {
            Http2Connection.access$getCurrentPushRequests$p((Http2Connection)http2Connection).remove(n);
            Unit unit = Unit.INSTANCE;
            return;
        }
    }
}
