/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.internal.Util
 *  okhttp3.internal.cache.DiskLruCache
 *  okhttp3.internal.cache.DiskLruCache$Editor
 *  okio.Source
 */
package okhttp3.internal.cache;

import java.io.Closeable;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okhttp3.internal.cache.DiskLruCache;
import okio.Source;

@Metadata(d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B-\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0016J\f\u0010\u000e\u001a\b\u0018\u00010\u000fR\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0002\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2={"Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "Ljava/io/Closeable;", "key", "", "sequenceNumber", "", "sources", "", "Lokio/Source;", "lengths", "", "(Lokhttp3/internal/cache/DiskLruCache;Ljava/lang/String;JLjava/util/List;[J)V", "close", "", "edit", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "Lokhttp3/internal/cache/DiskLruCache;", "getLength", "index", "", "getSource", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class DiskLruCache.Snapshot
implements Closeable {
    private final String key;
    private final long[] lengths;
    private final long sequenceNumber;
    private final List<Source> sources;
    final DiskLruCache this$0;

    public DiskLruCache.Snapshot(DiskLruCache diskLruCache, String string, long l, List<? extends Source> list, long[] lArray) {
        Intrinsics.checkNotNullParameter((Object)diskLruCache, (String)"this$0");
        Intrinsics.checkNotNullParameter((Object)string, (String)"key");
        Intrinsics.checkNotNullParameter(list, (String)"sources");
        Intrinsics.checkNotNullParameter((Object)lArray, (String)"lengths");
        this.this$0 = diskLruCache;
        this.key = string;
        this.sequenceNumber = l;
        this.sources = list;
        this.lengths = lArray;
    }

    @Override
    public void close() {
        Iterator<Source> iterator = this.sources.iterator();
        while (iterator.hasNext()) {
            Util.closeQuietly((Closeable)((Closeable)iterator.next()));
        }
    }

    public final DiskLruCache.Editor edit() throws IOException {
        return this.this$0.edit(this.key, this.sequenceNumber);
    }

    public final long getLength(int n) {
        return this.lengths[n];
    }

    public final Source getSource(int n) {
        return this.sources.get(n);
    }

    public final String key() {
        return this.key;
    }
}
