/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Lambda
 *  okhttp3.internal.http2.ErrorCode
 *  okhttp3.internal.http2.Http2Connection
 *  okhttp3.internal.http2.Http2Stream
 *  okhttp3.internal.platform.Platform
 */
package okhttp3.internal.http2;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.platform.Platform;

@Metadata(d1={"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
static final class Http2Connection.ReaderRunnable.headers.1.1
extends Lambda
implements Function0<Unit> {
    final Http2Stream $newStream;
    final Http2Connection this$0;

    Http2Connection.ReaderRunnable.headers.1.1(Http2Connection http2Connection, Http2Stream http2Stream) {
        this.this$0 = http2Connection;
        this.$newStream = http2Stream;
        super(0);
    }

    /*
     * Enabled force condition propagation
     */
    public final void invoke() {
        try {
            this.this$0.getListener$okhttp().onStream(this.$newStream);
            return;
        }
        catch (IOException iOException) {
            Platform.Companion.get().log(Intrinsics.stringPlus((String)"Http2Connection.Listener failure for ", (Object)this.this$0.getConnectionName$okhttp()), 4, (Throwable)iOException);
            Http2Stream http2Stream = this.$newStream;
            try {
                http2Stream.close(ErrorCode.PROTOCOL_ERROR, iOException);
                return;
            }
            catch (IOException iOException2) {
                return;
            }
        }
    }
}
