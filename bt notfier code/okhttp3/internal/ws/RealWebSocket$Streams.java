/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okio.BufferedSink
 *  okio.BufferedSource
 */
package okhttp3.internal.ws;

import java.io.Closeable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSink;
import okio.BufferedSource;

@Metadata(d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2={"Lokhttp3/internal/ws/RealWebSocket$Streams;", "Ljava/io/Closeable;", "client", "", "source", "Lokio/BufferedSource;", "sink", "Lokio/BufferedSink;", "(ZLokio/BufferedSource;Lokio/BufferedSink;)V", "getClient", "()Z", "getSink", "()Lokio/BufferedSink;", "getSource", "()Lokio/BufferedSource;", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static abstract class RealWebSocket.Streams
implements Closeable {
    private final boolean client;
    private final BufferedSink sink;
    private final BufferedSource source;

    public RealWebSocket.Streams(boolean bl, BufferedSource bufferedSource, BufferedSink bufferedSink) {
        Intrinsics.checkNotNullParameter((Object)bufferedSource, (String)"source");
        Intrinsics.checkNotNullParameter((Object)bufferedSink, (String)"sink");
        this.client = bl;
        this.source = bufferedSource;
        this.sink = bufferedSink;
    }

    public final boolean getClient() {
        return this.client;
    }

    public final BufferedSink getSink() {
        return this.sink;
    }

    public final BufferedSource getSource() {
        return this.source;
    }
}
