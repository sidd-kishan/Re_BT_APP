/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.Call
 *  okhttp3.Callback
 *  okhttp3.Request
 *  okhttp3.Response
 *  okhttp3.WebSocket
 *  okhttp3.internal.Util
 *  okhttp3.internal.connection.Exchange
 *  okhttp3.internal.ws.RealWebSocket
 *  okhttp3.internal.ws.RealWebSocket$Streams
 *  okhttp3.internal.ws.WebSocketExtensions
 */
package okhttp3.internal.ws;

import java.io.Closeable;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.ws.RealWebSocket;
import okhttp3.internal.ws.WebSocketExtensions;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016\u00a8\u0006\u000b"}, d2={"okhttp3/internal/ws/RealWebSocket$connect$1", "Lokhttp3/Callback;", "onFailure", "", "call", "Lokhttp3/Call;", "e", "Ljava/io/IOException;", "onResponse", "response", "Lokhttp3/Response;", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class RealWebSocket.connect.1
implements Callback {
    final Request $request;
    final RealWebSocket this$0;

    RealWebSocket.connect.1(RealWebSocket realWebSocket, Request request) {
        this.this$0 = realWebSocket;
        this.$request = request;
    }

    public void onFailure(Call call, IOException iOException) {
        Intrinsics.checkNotNullParameter((Object)call, (String)"call");
        Intrinsics.checkNotNullParameter((Object)iOException, (String)"e");
        this.this$0.failWebSocket((Exception)iOException, null);
    }

    public void onResponse(Call call, Response response) {
        Intrinsics.checkNotNullParameter((Object)call, (String)"call");
        Intrinsics.checkNotNullParameter((Object)response, (String)"response");
        Object object = response.exchange();
        try {
            this.this$0.checkUpgradeSuccess$okhttp(response, (Exchange)object);
            Intrinsics.checkNotNull((Object)object);
            call = object.newWebSocketStreams();
        }
        catch (IOException iOException) {
            if (object != null) {
                object.webSocketUpgradeFailed();
            }
            this.this$0.failWebSocket((Exception)iOException, response);
            Util.closeQuietly((Closeable)((Closeable)response));
            return;
        }
        object = WebSocketExtensions.Companion.parse(response.headers());
        RealWebSocket.access$setExtensions$p((RealWebSocket)this.this$0, (WebSocketExtensions)object);
        if (!RealWebSocket.access$isValid((RealWebSocket)this.this$0, (WebSocketExtensions)object)) {
            object = this.this$0;
            synchronized (object) {
                RealWebSocket.access$getMessageAndCloseQueue$p((RealWebSocket)object).clear();
                object.close(1010, "unexpected Sec-WebSocket-Extensions in response header");
            }
        }
        try {
            object = new StringBuilder();
            ((StringBuilder)object).append(Util.okHttpName);
            ((StringBuilder)object).append(" WebSocket ");
            ((StringBuilder)object).append(this.$request.url().redact());
            object = ((StringBuilder)object).toString();
            this.this$0.initReaderAndWriter((String)object, (RealWebSocket.Streams)call);
            this.this$0.getListener$okhttp().onOpen((WebSocket)this.this$0, response);
            this.this$0.loopReader();
        }
        catch (Exception exception) {
            this.this$0.failWebSocket(exception, null);
        }
    }
}
