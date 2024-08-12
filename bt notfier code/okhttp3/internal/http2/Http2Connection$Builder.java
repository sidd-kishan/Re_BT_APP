/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.internal.Util
 *  okhttp3.internal.concurrent.TaskRunner
 *  okhttp3.internal.http2.Http2Connection
 *  okhttp3.internal.http2.Http2Connection$Listener
 *  okhttp3.internal.http2.PushObserver
 *  okio.BufferedSink
 *  okio.BufferedSource
 *  okio.Okio
 *  okio.Sink
 *  okio.Source
 */
package okhttp3.internal.http2;

import java.io.IOException;
import java.net.Socket;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.PushObserver;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

@Metadata(d1={"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u00107\u001a\u000208J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001eJ.\u0010)\u001a\u00020\u00002\u0006\u0010)\u001a\u00020*2\b\b\u0002\u00109\u001a\u00020\f2\b\b\u0002\u0010/\u001a\u0002002\b\b\u0002\u0010#\u001a\u00020$H\u0007R\u001a\u0010\u0002\u001a\u00020\u0003X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020$X\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020*X\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010/\u001a\u000200X\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u00106\u00a8\u0006:"}, d2={"Lokhttp3/internal/http2/Http2Connection$Builder;", "", "client", "", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "(ZLokhttp3/internal/concurrent/TaskRunner;)V", "getClient$okhttp", "()Z", "setClient$okhttp", "(Z)V", "connectionName", "", "getConnectionName$okhttp", "()Ljava/lang/String;", "setConnectionName$okhttp", "(Ljava/lang/String;)V", "listener", "Lokhttp3/internal/http2/Http2Connection$Listener;", "getListener$okhttp", "()Lokhttp3/internal/http2/Http2Connection$Listener;", "setListener$okhttp", "(Lokhttp3/internal/http2/Http2Connection$Listener;)V", "pingIntervalMillis", "", "getPingIntervalMillis$okhttp", "()I", "setPingIntervalMillis$okhttp", "(I)V", "pushObserver", "Lokhttp3/internal/http2/PushObserver;", "getPushObserver$okhttp", "()Lokhttp3/internal/http2/PushObserver;", "setPushObserver$okhttp", "(Lokhttp3/internal/http2/PushObserver;)V", "sink", "Lokio/BufferedSink;", "getSink$okhttp", "()Lokio/BufferedSink;", "setSink$okhttp", "(Lokio/BufferedSink;)V", "socket", "Ljava/net/Socket;", "getSocket$okhttp", "()Ljava/net/Socket;", "setSocket$okhttp", "(Ljava/net/Socket;)V", "source", "Lokio/BufferedSource;", "getSource$okhttp", "()Lokio/BufferedSource;", "setSource$okhttp", "(Lokio/BufferedSource;)V", "getTaskRunner$okhttp", "()Lokhttp3/internal/concurrent/TaskRunner;", "build", "Lokhttp3/internal/http2/Http2Connection;", "peerName", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class Http2Connection.Builder {
    private boolean client;
    public String connectionName;
    private Http2Connection.Listener listener;
    private int pingIntervalMillis;
    private PushObserver pushObserver;
    public BufferedSink sink;
    public Socket socket;
    public BufferedSource source;
    private final TaskRunner taskRunner;

    public Http2Connection.Builder(boolean bl, TaskRunner taskRunner) {
        Intrinsics.checkNotNullParameter((Object)taskRunner, (String)"taskRunner");
        this.client = bl;
        this.taskRunner = taskRunner;
        this.listener = Http2Connection.Listener.REFUSE_INCOMING_STREAMS;
        this.pushObserver = PushObserver.CANCEL;
    }

    public static /* synthetic */ Http2Connection.Builder socket$default(Http2Connection.Builder builder, Socket socket, String string, BufferedSource bufferedSource, BufferedSink bufferedSink, int n, Object object) throws IOException {
        if ((n & 2) != 0) {
            string = Util.peerName((Socket)socket);
        }
        if ((n & 4) != 0) {
            bufferedSource = Okio.buffer((Source)Okio.source((Socket)socket));
        }
        if ((n & 8) == 0) return builder.socket(socket, string, bufferedSource, bufferedSink);
        bufferedSink = Okio.buffer((Sink)Okio.sink((Socket)socket));
        return builder.socket(socket, string, bufferedSource, bufferedSink);
    }

    public final Http2Connection build() {
        return new Http2Connection(this);
    }

    public final boolean getClient$okhttp() {
        return this.client;
    }

    public final String getConnectionName$okhttp() {
        String string = this.connectionName;
        if (string != null) {
            return string;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"connectionName");
        return null;
    }

    public final Http2Connection.Listener getListener$okhttp() {
        return this.listener;
    }

    public final int getPingIntervalMillis$okhttp() {
        return this.pingIntervalMillis;
    }

    public final PushObserver getPushObserver$okhttp() {
        return this.pushObserver;
    }

    public final BufferedSink getSink$okhttp() {
        BufferedSink bufferedSink = this.sink;
        if (bufferedSink != null) {
            return bufferedSink;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"sink");
        return null;
    }

    public final Socket getSocket$okhttp() {
        Socket socket = this.socket;
        if (socket != null) {
            return socket;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"socket");
        return null;
    }

    public final BufferedSource getSource$okhttp() {
        BufferedSource bufferedSource = this.source;
        if (bufferedSource != null) {
            return bufferedSource;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"source");
        return null;
    }

    public final TaskRunner getTaskRunner$okhttp() {
        return this.taskRunner;
    }

    public final Http2Connection.Builder listener(Http2Connection.Listener listener) {
        Intrinsics.checkNotNullParameter((Object)listener, (String)"listener");
        Http2Connection.Builder builder = this;
        builder.setListener$okhttp(listener);
        return builder;
    }

    public final Http2Connection.Builder pingIntervalMillis(int n) {
        Http2Connection.Builder builder = this;
        builder.setPingIntervalMillis$okhttp(n);
        return builder;
    }

    public final Http2Connection.Builder pushObserver(PushObserver pushObserver) {
        Intrinsics.checkNotNullParameter((Object)pushObserver, (String)"pushObserver");
        Http2Connection.Builder builder = this;
        builder.setPushObserver$okhttp(pushObserver);
        return builder;
    }

    public final void setClient$okhttp(boolean bl) {
        this.client = bl;
    }

    public final void setConnectionName$okhttp(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"<set-?>");
        this.connectionName = string;
    }

    public final void setListener$okhttp(Http2Connection.Listener listener) {
        Intrinsics.checkNotNullParameter((Object)listener, (String)"<set-?>");
        this.listener = listener;
    }

    public final void setPingIntervalMillis$okhttp(int n) {
        this.pingIntervalMillis = n;
    }

    public final void setPushObserver$okhttp(PushObserver pushObserver) {
        Intrinsics.checkNotNullParameter((Object)pushObserver, (String)"<set-?>");
        this.pushObserver = pushObserver;
    }

    public final void setSink$okhttp(BufferedSink bufferedSink) {
        Intrinsics.checkNotNullParameter((Object)bufferedSink, (String)"<set-?>");
        this.sink = bufferedSink;
    }

    public final void setSocket$okhttp(Socket socket) {
        Intrinsics.checkNotNullParameter((Object)socket, (String)"<set-?>");
        this.socket = socket;
    }

    public final void setSource$okhttp(BufferedSource bufferedSource) {
        Intrinsics.checkNotNullParameter((Object)bufferedSource, (String)"<set-?>");
        this.source = bufferedSource;
    }

    public final Http2Connection.Builder socket(Socket socket) throws IOException {
        Intrinsics.checkNotNullParameter((Object)socket, (String)"socket");
        return Http2Connection.Builder.socket$default(this, socket, null, null, null, 14, null);
    }

    public final Http2Connection.Builder socket(Socket socket, String string) throws IOException {
        Intrinsics.checkNotNullParameter((Object)socket, (String)"socket");
        Intrinsics.checkNotNullParameter((Object)string, (String)"peerName");
        return Http2Connection.Builder.socket$default(this, socket, string, null, null, 12, null);
    }

    public final Http2Connection.Builder socket(Socket socket, String string, BufferedSource bufferedSource) throws IOException {
        Intrinsics.checkNotNullParameter((Object)socket, (String)"socket");
        Intrinsics.checkNotNullParameter((Object)string, (String)"peerName");
        Intrinsics.checkNotNullParameter((Object)bufferedSource, (String)"source");
        return Http2Connection.Builder.socket$default(this, socket, string, bufferedSource, null, 8, null);
    }

    public final Http2Connection.Builder socket(Socket object, String string, BufferedSource bufferedSource, BufferedSink bufferedSink) throws IOException {
        Intrinsics.checkNotNullParameter((Object)object, (String)"socket");
        Intrinsics.checkNotNullParameter((Object)string, (String)"peerName");
        Intrinsics.checkNotNullParameter((Object)bufferedSource, (String)"source");
        Intrinsics.checkNotNullParameter((Object)bufferedSink, (String)"sink");
        Http2Connection.Builder builder = this;
        builder.setSocket$okhttp((Socket)object);
        if (builder.getClient$okhttp()) {
            object = new StringBuilder();
            ((StringBuilder)object).append(Util.okHttpName);
            ((StringBuilder)object).append(' ');
            ((StringBuilder)object).append(string);
            object = ((StringBuilder)object).toString();
        } else {
            object = Intrinsics.stringPlus((String)"MockWebServer ", (Object)string);
        }
        builder.setConnectionName$okhttp((String)object);
        builder.setSource$okhttp(bufferedSource);
        builder.setSink$okhttp(bufferedSink);
        return builder;
    }
}
