/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.internal.http2.ErrorCode
 *  okhttp3.internal.http2.Http2Connection$Listener
 *  okhttp3.internal.http2.Http2Stream
 */
package okhttp3.internal.http2;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Http2Stream;

@Metadata(d1={"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016\u00a8\u0006\u0006"}, d2={"okhttp3/internal/http2/Http2Connection$Listener$Companion$REFUSE_INCOMING_STREAMS$1", "Lokhttp3/internal/http2/Http2Connection$Listener;", "onStream", "", "stream", "Lokhttp3/internal/http2/Http2Stream;", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class Http2Connection.Listener.Companion.REFUSE_INCOMING_STREAMS.1
extends Http2Connection.Listener {
    Http2Connection.Listener.Companion.REFUSE_INCOMING_STREAMS.1() {
    }

    public void onStream(Http2Stream http2Stream) throws IOException {
        Intrinsics.checkNotNullParameter((Object)http2Stream, (String)"stream");
        http2Stream.close(ErrorCode.REFUSED_STREAM, null);
    }
}