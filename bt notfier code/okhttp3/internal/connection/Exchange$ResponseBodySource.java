/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.Call
 *  okhttp3.internal.connection.Exchange
 *  okio.Buffer
 *  okio.ForwardingSource
 *  okio.Source
 */
package okhttp3.internal.connection;

import java.io.IOException;
import java.net.ProtocolException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.internal.connection.Exchange;
import okio.Buffer;
import okio.ForwardingSource;
import okio.Source;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\f\u001a\u00020\rH\u0016J\u001f\u0010\u000e\u001a\u0002H\u000f\"\n\b\u0000\u0010\u000f*\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u0002H\u000f\u00a2\u0006\u0002\u0010\u0012J\u0018\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0005H\u0016R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2={"Lokhttp3/internal/connection/Exchange$ResponseBodySource;", "Lokio/ForwardingSource;", "delegate", "Lokio/Source;", "contentLength", "", "(Lokhttp3/internal/connection/Exchange;Lokio/Source;J)V", "bytesReceived", "closed", "", "completed", "invokeStartEvent", "close", "", "complete", "E", "Ljava/io/IOException;", "e", "(Ljava/io/IOException;)Ljava/io/IOException;", "read", "sink", "Lokio/Buffer;", "byteCount", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class Exchange.ResponseBodySource
extends ForwardingSource {
    private long bytesReceived;
    private boolean closed;
    private boolean completed;
    private final long contentLength;
    private boolean invokeStartEvent;
    final Exchange this$0;

    public Exchange.ResponseBodySource(Exchange exchange, Source source, long l) {
        Intrinsics.checkNotNullParameter((Object)exchange, (String)"this$0");
        Intrinsics.checkNotNullParameter((Object)source, (String)"delegate");
        this.this$0 = exchange;
        super(source);
        this.contentLength = l;
        this.invokeStartEvent = true;
        if (l != 0L) return;
        this.complete(null);
    }

    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        this.closed = true;
        try {
            super.close();
            this.complete(null);
            return;
        }
        catch (IOException iOException) {
            throw this.complete(iOException);
        }
    }

    public final <E extends IOException> E complete(E e) {
        if (this.completed) {
            return e;
        }
        this.completed = true;
        if (e != null) return (E)this.this$0.bodyComplete(this.bytesReceived, true, false, e);
        if (!this.invokeStartEvent) return (E)this.this$0.bodyComplete(this.bytesReceived, true, false, e);
        this.invokeStartEvent = false;
        this.this$0.getEventListener$okhttp().responseBodyStart((Call)this.this$0.getCall$okhttp());
        return (E)this.this$0.bodyComplete(this.bytesReceived, true, false, e);
    }

    public long read(Buffer object, long l) throws IOException {
        Intrinsics.checkNotNullParameter((Object)object, (String)"sink");
        if (!(this.closed ^ true)) throw (Throwable)new IllegalStateException("closed".toString());
        try {
            l = this.delegate().read(object, l);
            if (this.invokeStartEvent) {
                this.invokeStartEvent = false;
                this.this$0.getEventListener$okhttp().responseBodyStart((Call)this.this$0.getCall$okhttp());
            }
            if (l == -1L) {
                this.complete(null);
                return -1L;
            }
            long l2 = this.bytesReceived + l;
            if (this.contentLength != -1L && l2 > this.contentLength) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("expected ");
                stringBuilder.append(this.contentLength);
                stringBuilder.append(" bytes but received ");
                stringBuilder.append(l2);
                object = new ProtocolException(stringBuilder.toString());
                throw object;
            }
            this.bytesReceived = l2;
            if (l2 != this.contentLength) return l;
            this.complete(null);
            return l;
        }
        catch (IOException iOException) {
            throw this.complete(iOException);
        }
    }
}
