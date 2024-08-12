/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.Cache
 *  okhttp3.internal.Util
 *  okhttp3.internal.cache.CacheRequest
 *  okhttp3.internal.cache.DiskLruCache$Editor
 *  okio.Sink
 */
package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Cache;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheRequest;
import okhttp3.internal.cache.DiskLruCache;
import okio.Sink;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0012\u0010\u0002\u001a\u00060\u0003R\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2={"Lokhttp3/Cache$RealCacheRequest;", "Lokhttp3/internal/cache/CacheRequest;", "editor", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "Lokhttp3/internal/cache/DiskLruCache;", "(Lokhttp3/Cache;Lokhttp3/internal/cache/DiskLruCache$Editor;)V", "body", "Lokio/Sink;", "cacheOut", "done", "", "getDone", "()Z", "setDone", "(Z)V", "abort", "", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
private final class Cache.RealCacheRequest
implements CacheRequest {
    private final Sink body;
    private final Sink cacheOut;
    private boolean done;
    private final DiskLruCache.Editor editor;
    final Cache this$0;

    public Cache.RealCacheRequest(Cache cache, DiskLruCache.Editor editor) {
        Intrinsics.checkNotNullParameter((Object)cache, (String)"this$0");
        Intrinsics.checkNotNullParameter((Object)editor, (String)"editor");
        this.this$0 = cache;
        this.editor = editor;
        cache = editor.newSink(1);
        this.cacheOut = cache;
        this.body = (Sink)new /* Unavailable Anonymous Inner Class!! */;
    }

    public static final /* synthetic */ DiskLruCache.Editor access$getEditor$p(Cache.RealCacheRequest realCacheRequest) {
        return realCacheRequest.editor;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void abort() {
        Cache cache = this.this$0;
        synchronized (cache) {
            boolean bl = this.getDone();
            if (bl) {
                return;
            }
            this.setDone(true);
            cache.setWriteAbortCount$okhttp(cache.getWriteAbortCount$okhttp() + 1);
        }
        Util.closeQuietly((Closeable)((Closeable)this.cacheOut));
        try {
            this.editor.abort();
            return;
        }
        catch (IOException iOException) {
            return;
        }
    }

    public Sink body() {
        return this.body;
    }

    public final boolean getDone() {
        return this.done;
    }

    public final void setDone(boolean bl) {
        this.done = bl;
    }
}
