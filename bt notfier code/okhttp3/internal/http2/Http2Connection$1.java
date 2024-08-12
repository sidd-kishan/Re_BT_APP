/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Lambda
 *  okhttp3.internal.http2.Http2Connection
 */
package okhttp3.internal.http2;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import okhttp3.internal.http2.Http2Connection;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000\u0006\n\u0000\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u0001H\n"}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
static final class Http2Connection.1
extends Lambda
implements Function0<Long> {
    final long $pingIntervalNanos;
    final Http2Connection this$0;

    Http2Connection.1(Http2Connection http2Connection, long l) {
        this.this$0 = http2Connection;
        this.$pingIntervalNanos = l;
        super(0);
    }

    public final Long invoke() {
        Http2Connection http2Connection = this.this$0;
        synchronized (http2Connection) {
            boolean bl;
            if (Http2Connection.access$getIntervalPongsReceived$p((Http2Connection)http2Connection) < Http2Connection.access$getIntervalPingsSent$p((Http2Connection)http2Connection)) {
                bl = true;
            } else {
                Http2Connection.access$setIntervalPingsSent$p((Http2Connection)http2Connection, (long)(Http2Connection.access$getIntervalPingsSent$p((Http2Connection)http2Connection) + 1L));
                bl = false;
            }
            if (bl) {
                Http2Connection.access$failConnection((Http2Connection)this.this$0, null);
                return -1L;
            }
            this.this$0.writePing(false, 1, 0);
            return this.$pingIntervalNanos;
        }
    }
}
