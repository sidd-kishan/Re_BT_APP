/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.internal.http1.Http1ExchangeCodec
 *  okhttp3.internal.http1.Http1ExchangeCodec$AbstractSource
 *  okio.Buffer
 */
package okhttp3.internal.http1;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http1.Http1ExchangeCodec;
import okio.Buffer;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2={"Lokhttp3/internal/http1/Http1ExchangeCodec$UnknownLengthSource;", "Lokhttp3/internal/http1/Http1ExchangeCodec$AbstractSource;", "Lokhttp3/internal/http1/Http1ExchangeCodec;", "(Lokhttp3/internal/http1/Http1ExchangeCodec;)V", "inputExhausted", "", "close", "", "read", "", "sink", "Lokio/Buffer;", "byteCount", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
private final class Http1ExchangeCodec.UnknownLengthSource
extends Http1ExchangeCodec.AbstractSource {
    private boolean inputExhausted;
    final Http1ExchangeCodec this$0;

    public Http1ExchangeCodec.UnknownLengthSource(Http1ExchangeCodec http1ExchangeCodec) {
        Intrinsics.checkNotNullParameter((Object)http1ExchangeCodec, (String)"this$0");
        this.this$0 = http1ExchangeCodec;
        super(http1ExchangeCodec);
    }

    public void close() {
        if (this.getClosed()) {
            return;
        }
        if (!this.inputExhausted) {
            this.responseBodyComplete();
        }
        this.setClosed(true);
    }

    public long read(Buffer buffer, long l) {
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"sink");
        boolean bl = l >= 0L;
        if (!bl) throw (Throwable)new IllegalArgumentException(Intrinsics.stringPlus((String)"byteCount < 0: ", (Object)l).toString());
        if (!(this.getClosed() ^ true)) throw (Throwable)new IllegalStateException("closed".toString());
        if (this.inputExhausted) {
            return -1L;
        }
        if ((l = super.read(buffer, l)) != -1L) return l;
        this.inputExhausted = true;
        this.responseBodyComplete();
        return -1L;
    }
}
