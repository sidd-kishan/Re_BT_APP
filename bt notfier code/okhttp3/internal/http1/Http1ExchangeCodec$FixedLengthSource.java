/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.internal.Util
 *  okhttp3.internal.http1.Http1ExchangeCodec
 *  okhttp3.internal.http1.Http1ExchangeCodec$AbstractSource
 *  okio.Buffer
 *  okio.Source
 */
package okhttp3.internal.http1;

import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okhttp3.internal.http1.Http1ExchangeCodec;
import okio.Buffer;
import okio.Source;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2={"Lokhttp3/internal/http1/Http1ExchangeCodec$FixedLengthSource;", "Lokhttp3/internal/http1/Http1ExchangeCodec$AbstractSource;", "Lokhttp3/internal/http1/Http1ExchangeCodec;", "bytesRemaining", "", "(Lokhttp3/internal/http1/Http1ExchangeCodec;J)V", "close", "", "read", "sink", "Lokio/Buffer;", "byteCount", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
private final class Http1ExchangeCodec.FixedLengthSource
extends Http1ExchangeCodec.AbstractSource {
    private long bytesRemaining;
    final Http1ExchangeCodec this$0;

    public Http1ExchangeCodec.FixedLengthSource(Http1ExchangeCodec http1ExchangeCodec, long l) {
        Intrinsics.checkNotNullParameter((Object)http1ExchangeCodec, (String)"this$0");
        this.this$0 = http1ExchangeCodec;
        super(http1ExchangeCodec);
        this.bytesRemaining = l;
        if (l != 0L) return;
        this.responseBodyComplete();
    }

    public void close() {
        if (this.getClosed()) {
            return;
        }
        if (this.bytesRemaining != 0L && !Util.discard((Source)((Source)this), (int)100, (TimeUnit)TimeUnit.MILLISECONDS)) {
            this.this$0.getConnection().noNewExchanges$okhttp();
            this.responseBodyComplete();
        }
        this.setClosed(true);
    }

    public long read(Buffer object, long l) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"sink");
        boolean bl = l >= 0L;
        if (!bl) throw (Throwable)new IllegalArgumentException(Intrinsics.stringPlus((String)"byteCount < 0: ", (Object)l).toString());
        if (!(true ^ this.getClosed())) throw (Throwable)new IllegalStateException("closed".toString());
        long l2 = this.bytesRemaining;
        if (l2 == 0L) {
            return -1L;
        }
        if ((l = super.read(object, Math.min(l2, l))) != -1L) {
            this.bytesRemaining = l2 = this.bytesRemaining - l;
            if (l2 != 0L) return l;
            this.responseBodyComplete();
            return l;
        }
        this.this$0.getConnection().noNewExchanges$okhttp();
        object = new ProtocolException("unexpected end of stream");
        this.responseBodyComplete();
        throw object;
    }
}
