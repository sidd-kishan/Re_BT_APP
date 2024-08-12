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
static final class Http2Connection.ReaderRunnable.ping.2
extends Lambda
implements Function0<Unit> {
    final int $payload1;
    final int $payload2;
    final Http2Connection this$0;

    Http2Connection.ReaderRunnable.ping.2(Http2Connection http2Connection, int n, int n2) {
        this.this$0 = http2Connection;
        this.$payload1 = n;
        this.$payload2 = n2;
        super(0);
    }

    public final void invoke() {
        this.this$0.writePing(true, this.$payload1, this.$payload2);
    }
}
