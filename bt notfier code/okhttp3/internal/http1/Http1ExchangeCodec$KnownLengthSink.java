/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.internal.Util
 *  okhttp3.internal.http1.Http1ExchangeCodec
 *  okio.Buffer
 *  okio.ForwardingTimeout
 *  okio.Sink
 *  okio.Timeout
 */
package okhttp3.internal.http1;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okhttp3.internal.http1.Http1ExchangeCodec;
import okio.Buffer;
import okio.ForwardingTimeout;
import okio.Sink;
import okio.Timeout;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u0005\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2={"Lokhttp3/internal/http1/Http1ExchangeCodec$KnownLengthSink;", "Lokio/Sink;", "(Lokhttp3/internal/http1/Http1ExchangeCodec;)V", "closed", "", "timeout", "Lokio/ForwardingTimeout;", "close", "", "flush", "Lokio/Timeout;", "write", "source", "Lokio/Buffer;", "byteCount", "", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
private final class Http1ExchangeCodec.KnownLengthSink
implements Sink {
    private boolean closed;
    final Http1ExchangeCodec this$0;
    private final ForwardingTimeout timeout;

    public Http1ExchangeCodec.KnownLengthSink(Http1ExchangeCodec http1ExchangeCodec) {
        Intrinsics.checkNotNullParameter((Object)http1ExchangeCodec, (String)"this$0");
        this.this$0 = http1ExchangeCodec;
        this.timeout = new ForwardingTimeout(Http1ExchangeCodec.access$getSink$p((Http1ExchangeCodec)this.this$0).timeout());
    }

    public void close() {
        if (this.closed) {
            return;
        }
        this.closed = true;
        Http1ExchangeCodec.access$detachTimeout((Http1ExchangeCodec)this.this$0, (ForwardingTimeout)this.timeout);
        Http1ExchangeCodec.access$setState$p((Http1ExchangeCodec)this.this$0, (int)3);
    }

    public void flush() {
        if (this.closed) {
            return;
        }
        Http1ExchangeCodec.access$getSink$p((Http1ExchangeCodec)this.this$0).flush();
    }

    public Timeout timeout() {
        return (Timeout)this.timeout;
    }

    public void write(Buffer buffer, long l) {
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"source");
        if (!(this.closed ^ true)) throw (Throwable)new IllegalStateException("closed".toString());
        Util.checkOffsetAndCount((long)buffer.size(), (long)0L, (long)l);
        Http1ExchangeCodec.access$getSink$p((Http1ExchangeCodec)this.this$0).write(buffer, l);
    }
}
