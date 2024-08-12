/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  okhttp3.internal.connection.Exchange
 *  okhttp3.internal.ws.RealWebSocket$Streams
 *  okio.BufferedSink
 *  okio.BufferedSource
 */
package okhttp3.internal.connection;

import kotlin.Metadata;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.ws.RealWebSocket;
import okio.BufferedSink;
import okio.BufferedSource;

@Metadata(d1={"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016\u00a8\u0006\u0004"}, d2={"okhttp3/internal/connection/RealConnection$newWebSocketStreams$1", "Lokhttp3/internal/ws/RealWebSocket$Streams;", "close", "", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class RealConnection.newWebSocketStreams.1
extends RealWebSocket.Streams {
    final Exchange $exchange;
    final BufferedSink $sink;
    final BufferedSource $source;

    RealConnection.newWebSocketStreams.1(Exchange exchange, BufferedSource bufferedSource, BufferedSink bufferedSink) {
        this.$exchange = exchange;
        this.$source = bufferedSource;
        this.$sink = bufferedSink;
        super(true, bufferedSource, bufferedSink);
    }

    public void close() {
        this.$exchange.bodyComplete(-1L, true, true, null);
    }
}
