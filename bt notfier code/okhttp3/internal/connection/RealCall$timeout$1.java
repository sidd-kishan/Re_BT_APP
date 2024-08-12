/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  okhttp3.internal.connection.RealCall
 *  okio.AsyncTimeout
 */
package okhttp3.internal.connection;

import kotlin.Metadata;
import okhttp3.internal.connection.RealCall;
import okio.AsyncTimeout;

@Metadata(d1={"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0014\u00a8\u0006\u0004"}, d2={"okhttp3/internal/connection/RealCall$timeout$1", "Lokio/AsyncTimeout;", "timedOut", "", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class RealCall.timeout.1
extends AsyncTimeout {
    final RealCall this$0;

    RealCall.timeout.1(RealCall realCall) {
        this.this$0 = realCall;
    }

    protected void timedOut() {
        this.this$0.cancel();
    }
}
