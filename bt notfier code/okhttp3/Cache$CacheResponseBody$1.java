/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  okhttp3.Cache$CacheResponseBody
 *  okio.ForwardingSource
 *  okio.Source
 */
package okhttp3;

import java.io.IOException;
import kotlin.Metadata;
import okhttp3.Cache;
import okio.ForwardingSource;
import okio.Source;

@Metadata(d1={"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016\u00a8\u0006\u0004"}, d2={"okhttp3/Cache$CacheResponseBody$1", "Lokio/ForwardingSource;", "close", "", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class Cache.CacheResponseBody.1
extends ForwardingSource {
    final Source $source;
    final Cache.CacheResponseBody this$0;

    Cache.CacheResponseBody.1(Cache.CacheResponseBody cacheResponseBody, Source source) {
        this.this$0 = cacheResponseBody;
        this.$source = source;
        super(source);
    }

    public void close() throws IOException {
        this.this$0.getSnapshot().close();
        super.close();
    }
}
