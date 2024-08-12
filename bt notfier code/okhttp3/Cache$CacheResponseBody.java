/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.MediaType
 *  okhttp3.ResponseBody
 *  okhttp3.internal.Util
 *  okhttp3.internal.cache.DiskLruCache$Snapshot
 *  okio.BufferedSource
 *  okio.Okio
 *  okio.Source
 */
package okhttp3;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.cache.DiskLruCache;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B%\u0012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\bJ\b\u0010\u0007\u001a\u00020\rH\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0015\u0010\u0002\u001a\u00060\u0003R\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2={"Lokhttp3/Cache$CacheResponseBody;", "Lokhttp3/ResponseBody;", "snapshot", "Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "Lokhttp3/internal/cache/DiskLruCache;", "contentType", "", "contentLength", "(Lokhttp3/internal/cache/DiskLruCache$Snapshot;Ljava/lang/String;Ljava/lang/String;)V", "bodySource", "Lokio/BufferedSource;", "getSnapshot", "()Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "", "Lokhttp3/MediaType;", "source", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
private static final class Cache.CacheResponseBody
extends ResponseBody {
    private final BufferedSource bodySource;
    private final String contentLength;
    private final String contentType;
    private final DiskLruCache.Snapshot snapshot;

    public Cache.CacheResponseBody(DiskLruCache.Snapshot snapshot, String string, String string2) {
        Intrinsics.checkNotNullParameter((Object)snapshot, (String)"snapshot");
        this.snapshot = snapshot;
        this.contentType = string;
        this.contentLength = string2;
        this.bodySource = Okio.buffer((Source)((Source)new /* Unavailable Anonymous Inner Class!! */));
    }

    public long contentLength() {
        String string = this.contentLength;
        long l = -1L;
        if (string == null) return l;
        l = Util.toLongOrDefault((String)string, (long)-1L);
        return l;
    }

    public MediaType contentType() {
        String string = this.contentType;
        string = string == null ? null : MediaType.Companion.parse(string);
        return string;
    }

    public final DiskLruCache.Snapshot getSnapshot() {
        return this.snapshot;
    }

    public BufferedSource source() {
        return this.bodySource;
    }
}
