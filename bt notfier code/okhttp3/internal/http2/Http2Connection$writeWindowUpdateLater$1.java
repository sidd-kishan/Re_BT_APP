/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Lambda
 *  okhttp3.internal.http2.Http2Connection
 */
package okhttp3.internal.http2;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import okhttp3.internal.http2.Http2Connection;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
static final class Http2Connection.writeWindowUpdateLater.1
extends Lambda
implements Function0<Unit> {
    final int $streamId;
    final long $unacknowledgedBytesRead;
    final Http2Connection this$0;

    Http2Connection.writeWindowUpdateLater.1(Http2Connection http2Connection, int n, long l) {
        this.this$0 = http2Connection;
        this.$streamId = n;
        this.$unacknowledgedBytesRead = l;
        super(0);
    }

    public final void invoke() {
        try {
            this.this$0.getWriter().windowUpdate(this.$streamId, this.$unacknowledgedBytesRead);
        }
        catch (IOException iOException) {
            Http2Connection.access$failConnection((Http2Connection)this.this$0, (IOException)iOException);
        }
    }
}
