/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  okhttp3.internal.cache.DiskLruCache
 *  okhttp3.internal.cache.DiskLruCache$Entry
 *  okio.ForwardingSource
 *  okio.Source
 */
package okhttp3.internal.cache;

import kotlin.Metadata;
import kotlin.Unit;
import okhttp3.internal.cache.DiskLruCache;
import okio.ForwardingSource;
import okio.Source;

@Metadata(d1={"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0004\u001a\u00020\u0005H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2={"okhttp3/internal/cache/DiskLruCache$Entry$newSource$1", "Lokio/ForwardingSource;", "closed", "", "close", "", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class DiskLruCache.Entry.newSource.1
extends ForwardingSource {
    final Source $fileSource;
    private boolean closed;
    final DiskLruCache this$0;
    final DiskLruCache.Entry this$1;

    DiskLruCache.Entry.newSource.1(DiskLruCache diskLruCache, DiskLruCache.Entry entry, Source source) {
        this.this$0 = diskLruCache;
        this.this$1 = entry;
        this.$fileSource = source;
        super(source);
    }

    public void close() {
        super.close();
        if (this.closed) return;
        this.closed = true;
        DiskLruCache diskLruCache = this.this$0;
        DiskLruCache.Entry entry = this.this$1;
        synchronized (diskLruCache) {
            entry.setLockingSourceCount$okhttp(entry.getLockingSourceCount$okhttp() - 1);
            if (entry.getLockingSourceCount$okhttp() == 0 && entry.getZombie$okhttp()) {
                diskLruCache.removeEntry$okhttp(entry);
            }
            entry = Unit.INSTANCE;
        }
    }
}
