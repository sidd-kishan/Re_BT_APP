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

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import okhttp3.internal.http2.Http2Connection;

@Metadata(d1={"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
static final class Http2Connection.sendDegradedPingLater.2
extends Lambda
implements Function0<Unit> {
    final Http2Connection this$0;

    Http2Connection.sendDegradedPingLater.2(Http2Connection http2Connection) {
        this.this$0 = http2Connection;
        super(0);
    }

    public final void invoke() {
        this.this$0.writePing(false, 2, 0);
    }
}
