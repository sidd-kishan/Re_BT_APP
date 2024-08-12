/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.internal.http1.Http1ExchangeCodec
 *  okio.Buffer
 *  okio.ForwardingTimeout
 *  okio.Source
 *  okio.Timeout
 */
package okhttp3.internal.http1;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http1.Http1ExchangeCodec;
import okio.Buffer;
import okio.ForwardingTimeout;
import okio.Source;
import okio.Timeout;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u00a2\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\u0006\u0010\u0012\u001a\u00020\u0013J\b\u0010\t\u001a\u00020\u0014H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0015"}, d2={"Lokhttp3/internal/http1/Http1ExchangeCodec$AbstractSource;", "Lokio/Source;", "(Lokhttp3/internal/http1/Http1ExchangeCodec;)V", "closed", "", "getClosed", "()Z", "setClosed", "(Z)V", "timeout", "Lokio/ForwardingTimeout;", "getTimeout", "()Lokio/ForwardingTimeout;", "read", "", "sink", "Lokio/Buffer;", "byteCount", "responseBodyComplete", "", "Lokio/Timeout;", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
private abstract class Http1ExchangeCodec.AbstractSource
implements Source {
    private boolean closed;
    final Http1ExchangeCodec this$0;
    private final ForwardingTimeout timeout;

    public Http1ExchangeCodec.AbstractSource(Http1ExchangeCodec http1ExchangeCodec) {
        Intrinsics.checkNotNullParameter((Object)http1ExchangeCodec, (String)"this$0");
        this.this$0 = http1ExchangeCodec;
        this.timeout = new ForwardingTimeout(Http1ExchangeCodec.access$getSource$p((Http1ExchangeCodec)this.this$0).timeout());
    }

    protected final boolean getClosed() {
        return this.closed;
    }

    protected final ForwardingTimeout getTimeout() {
        return this.timeout;
    }

    public long read(Buffer buffer, long l) {
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"sink");
        try {
            l = Http1ExchangeCodec.access$getSource$p((Http1ExchangeCodec)this.this$0).read(buffer, l);
            return l;
        }
        catch (IOException iOException) {
            this.this$0.getConnection().noNewExchanges$okhttp();
            this.responseBodyComplete();
            throw iOException;
        }
    }

    public final void responseBodyComplete() {
        if (Http1ExchangeCodec.access$getState$p((Http1ExchangeCodec)this.this$0) == 6) {
            return;
        }
        if (Http1ExchangeCodec.access$getState$p((Http1ExchangeCodec)this.this$0) != 5) throw new IllegalStateException(Intrinsics.stringPlus((String)"state: ", (Object)Http1ExchangeCodec.access$getState$p((Http1ExchangeCodec)this.this$0)));
        Http1ExchangeCodec.access$detachTimeout((Http1ExchangeCodec)this.this$0, (ForwardingTimeout)this.timeout);
        Http1ExchangeCodec.access$setState$p((Http1ExchangeCodec)this.this$0, (int)6);
    }

    protected final void setClosed(boolean bl) {
        this.closed = bl;
    }

    public Timeout timeout() {
        return (Timeout)this.timeout;
    }
}
