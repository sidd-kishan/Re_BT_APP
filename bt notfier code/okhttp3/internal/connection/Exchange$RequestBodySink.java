/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.internal.connection.Exchange
 *  okio.Buffer
 *  okio.ForwardingSink
 *  okio.Sink
 */
package okhttp3.internal.connection;

import java.io.IOException;
import java.net.ProtocolException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.connection.Exchange;
import okio.Buffer;
import okio.ForwardingSink;
import okio.Sink;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016J!\u0010\r\u001a\u0002H\u000e\"\n\b\u0000\u0010\u000e*\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u0002H\u000eH\u0002\u00a2\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\fH\u0016J\u0018\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0005H\u0016R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2={"Lokhttp3/internal/connection/Exchange$RequestBodySink;", "Lokio/ForwardingSink;", "delegate", "Lokio/Sink;", "contentLength", "", "(Lokhttp3/internal/connection/Exchange;Lokio/Sink;J)V", "bytesReceived", "closed", "", "completed", "close", "", "complete", "E", "Ljava/io/IOException;", "e", "(Ljava/io/IOException;)Ljava/io/IOException;", "flush", "write", "source", "Lokio/Buffer;", "byteCount", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
private final class Exchange.RequestBodySink
extends ForwardingSink {
    private long bytesReceived;
    private boolean closed;
    private boolean completed;
    private final long contentLength;
    final Exchange this$0;

    public Exchange.RequestBodySink(Exchange exchange, Sink sink, long l) {
        Intrinsics.checkNotNullParameter((Object)exchange, (String)"this$0");
        Intrinsics.checkNotNullParameter((Object)sink, (String)"delegate");
        this.this$0 = exchange;
        super(sink);
        this.contentLength = l;
    }

    private final <E extends IOException> E complete(E e) {
        if (this.completed) {
            return e;
        }
        this.completed = true;
        return (E)this.this$0.bodyComplete(this.bytesReceived, false, true, e);
    }

    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        this.closed = true;
        long l = this.contentLength;
        if (l != -1L) {
            if (this.bytesReceived != l) throw new ProtocolException("unexpected end of stream");
        }
        try {
            super.close();
            this.complete(null);
            return;
        }
        catch (IOException iOException) {
            throw this.complete(iOException);
        }
    }

    public void flush() throws IOException {
        try {
            super.flush();
            return;
        }
        catch (IOException iOException) {
            throw this.complete(iOException);
        }
    }

    public void write(Buffer object, long l) throws IOException {
        Intrinsics.checkNotNullParameter((Object)object, (String)"source");
        if (!(this.closed ^ true)) throw (Throwable)new IllegalStateException("closed".toString());
        long l2 = this.contentLength;
        if (l2 != -1L && this.bytesReceived + l > l2) {
            object = new StringBuilder();
            ((StringBuilder)object).append("expected ");
            ((StringBuilder)object).append(this.contentLength);
            ((StringBuilder)object).append(" bytes but received ");
            ((StringBuilder)object).append(this.bytesReceived + l);
            throw new ProtocolException(((StringBuilder)object).toString());
        }
        try {
            super.write((Buffer)object, l);
            this.bytesReceived += l;
            return;
        }
        catch (IOException iOException) {
            throw this.complete(iOException);
        }
    }
}
