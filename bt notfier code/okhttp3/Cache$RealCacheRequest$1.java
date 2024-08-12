/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  okhttp3.Cache
 *  okhttp3.Cache$RealCacheRequest
 *  okio.ForwardingSink
 *  okio.Sink
 */
package okhttp3;

import java.io.IOException;
import kotlin.Metadata;
import okhttp3.Cache;
import okio.ForwardingSink;
import okio.Sink;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016\u00a8\u0006\u0004"}, d2={"okhttp3/Cache$RealCacheRequest$1", "Lokio/ForwardingSink;", "close", "", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class Cache.RealCacheRequest.1
extends ForwardingSink {
    final Cache this$0;
    final Cache.RealCacheRequest this$1;

    Cache.RealCacheRequest.1(Cache cache, Cache.RealCacheRequest realCacheRequest, Sink sink) {
        this.this$0 = cache;
        this.this$1 = realCacheRequest;
        super(sink);
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void close() throws IOException {
        Cache cache = this.this$0;
        Cache.RealCacheRequest realCacheRequest = this.this$1;
        synchronized (cache) {
            boolean bl = realCacheRequest.getDone();
            if (bl) {
                return;
            }
            realCacheRequest.setDone(true);
            cache.setWriteSuccessCount$okhttp(cache.getWriteSuccessCount$okhttp() + 1);
        }
        super.close();
        Cache.RealCacheRequest.access$getEditor$p((Cache.RealCacheRequest)this.this$1).commit();
    }
}
