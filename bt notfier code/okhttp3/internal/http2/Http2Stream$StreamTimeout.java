/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.internal.http2.ErrorCode
 *  okhttp3.internal.http2.Http2Stream
 *  okio.AsyncTimeout
 */
package okhttp3.internal.http2;

import java.io.IOException;
import java.net.SocketTimeoutException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Http2Stream;
import okio.AsyncTimeout;

@Metadata(d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J\b\u0010\b\u001a\u00020\u0004H\u0014\u00a8\u0006\t"}, d2={"Lokhttp3/internal/http2/Http2Stream$StreamTimeout;", "Lokio/AsyncTimeout;", "(Lokhttp3/internal/http2/Http2Stream;)V", "exitAndThrowIfTimedOut", "", "newTimeoutException", "Ljava/io/IOException;", "cause", "timedOut", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class Http2Stream.StreamTimeout
extends AsyncTimeout {
    final Http2Stream this$0;

    public Http2Stream.StreamTimeout(Http2Stream http2Stream) {
        Intrinsics.checkNotNullParameter((Object)http2Stream, (String)"this$0");
        this.this$0 = http2Stream;
    }

    public final void exitAndThrowIfTimedOut() throws IOException {
        if (this.exit()) throw this.newTimeoutException(null);
    }

    protected IOException newTimeoutException(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException == null) return socketTimeoutException;
        socketTimeoutException.initCause(iOException);
        return socketTimeoutException;
    }

    protected void timedOut() {
        this.this$0.closeLater(ErrorCode.CANCEL);
        this.this$0.getConnection().sendDegradedPingLater$okhttp();
    }
}
