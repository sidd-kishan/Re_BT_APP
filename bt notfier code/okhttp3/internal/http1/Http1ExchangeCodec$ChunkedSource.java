/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 *  okhttp3.CookieJar
 *  okhttp3.Headers
 *  okhttp3.HttpUrl
 *  okhttp3.internal.Util
 *  okhttp3.internal.http.HttpHeaders
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
import kotlin.text.StringsKt;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http1.Http1ExchangeCodec;
import okio.Buffer;
import okio.Source;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0007H\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2={"Lokhttp3/internal/http1/Http1ExchangeCodec$ChunkedSource;", "Lokhttp3/internal/http1/Http1ExchangeCodec$AbstractSource;", "Lokhttp3/internal/http1/Http1ExchangeCodec;", "url", "Lokhttp3/HttpUrl;", "(Lokhttp3/internal/http1/Http1ExchangeCodec;Lokhttp3/HttpUrl;)V", "bytesRemainingInChunk", "", "hasMoreChunks", "", "close", "", "read", "sink", "Lokio/Buffer;", "byteCount", "readChunkSize", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
private final class Http1ExchangeCodec.ChunkedSource
extends Http1ExchangeCodec.AbstractSource {
    private long bytesRemainingInChunk;
    private boolean hasMoreChunks;
    final Http1ExchangeCodec this$0;
    private final HttpUrl url;

    public Http1ExchangeCodec.ChunkedSource(Http1ExchangeCodec http1ExchangeCodec, HttpUrl httpUrl) {
        Intrinsics.checkNotNullParameter((Object)http1ExchangeCodec, (String)"this$0");
        Intrinsics.checkNotNullParameter((Object)httpUrl, (String)"url");
        this.this$0 = http1ExchangeCodec;
        super(http1ExchangeCodec);
        this.url = httpUrl;
        this.bytesRemainingInChunk = -1L;
        this.hasMoreChunks = true;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     */
    private final void readChunkSize() {
        if (this.bytesRemainingInChunk != -1L) {
            Http1ExchangeCodec.access$getSource$p((Http1ExchangeCodec)this.this$0).readUtf8LineStrict();
        }
        try {
            this.bytesRemainingInChunk = Http1ExchangeCodec.access$getSource$p((Http1ExchangeCodec)this.this$0).readHexadecimalUnsignedLong();
            var3_1 = Http1ExchangeCodec.access$getSource$p((Http1ExchangeCodec)this.this$0).readUtf8LineStrict();
            if (var3_1 == null) ** GOTO lbl38
            var5_3 = StringsKt.trim((CharSequence)((CharSequence)var3_1)).toString();
            if (this.bytesRemainingInChunk >= 0L && (!(var1_4 = ((CharSequence)var5_3).length() > 0) || (var2_5 = StringsKt.startsWith$default((String)var5_3, (String)";", (boolean)false, (int)2, null)))) {
                if (this.bytesRemainingInChunk != 0L) return;
                this.hasMoreChunks = false;
                var3_1 = this.this$0;
            }
            ** GOTO lbl-1000
        }
        catch (NumberFormatException var3_2) {
            throw new ProtocolException(var3_2.getMessage());
        }
        Http1ExchangeCodec.access$setTrailers$p((Http1ExchangeCodec)var3_1, (Headers)Http1ExchangeCodec.access$getHeadersReader$p((Http1ExchangeCodec)var3_1).readHeaders());
        var3_1 = Http1ExchangeCodec.access$getClient$p((Http1ExchangeCodec)this.this$0);
        Intrinsics.checkNotNull((Object)var3_1);
        var5_3 = var3_1.cookieJar();
        var4_6 = this.url;
        var3_1 = Http1ExchangeCodec.access$getTrailers$p((Http1ExchangeCodec)this.this$0);
        Intrinsics.checkNotNull((Object)var3_1);
        HttpHeaders.receiveHeaders((CookieJar)var5_3, (HttpUrl)var4_6, (Headers)var3_1);
        this.responseBodyComplete();
        return;
lbl-1000:
        // 1 sources

        {
            var3_1 = new StringBuilder();
            var3_1.append("expected chunk size and optional extensions but was \"");
            var3_1.append(this.bytesRemainingInChunk);
            var3_1.append(var5_3);
            var3_1.append('\"');
            var4_7 = new ProtocolException(var3_1.toString());
            throw var4_7;
lbl38:
            // 1 sources

            var3_1 = new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
            throw var3_1;
        }
    }

    public void close() {
        if (this.getClosed()) {
            return;
        }
        if (this.hasMoreChunks && !Util.discard((Source)((Source)this), (int)100, (TimeUnit)TimeUnit.MILLISECONDS)) {
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
        if (!this.hasMoreChunks) {
            return -1L;
        }
        long l2 = this.bytesRemainingInChunk;
        if (l2 == 0L || l2 == -1L) {
            this.readChunkSize();
            if (!this.hasMoreChunks) {
                return -1L;
            }
        }
        if ((l = super.read(object, Math.min(l, this.bytesRemainingInChunk))) != -1L) {
            this.bytesRemainingInChunk -= l;
            return l;
        }
        this.this$0.getConnection().noNewExchanges$okhttp();
        object = new ProtocolException("unexpected end of stream");
        this.responseBodyComplete();
        throw object;
    }
}
