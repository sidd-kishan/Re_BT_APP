/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  okhttp3.internal.cache.DiskLruCache
 *  okhttp3.internal.concurrent.Task
 *  okio.BufferedSink
 *  okio.Okio
 *  okio.Sink
 */
package okhttp3.internal.cache;

import java.io.IOException;
import kotlin.Metadata;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.concurrent.Task;
import okio.BufferedSink;
import okio.Okio;
import okio.Sink;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016\u00a8\u0006\u0004"}, d2={"okhttp3/internal/cache/DiskLruCache$cleanupTask$1", "Lokhttp3/internal/concurrent/Task;", "runOnce", "", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class DiskLruCache.cleanupTask.1
extends Task {
    final DiskLruCache this$0;

    DiskLruCache.cleanupTask.1(DiskLruCache diskLruCache, String string) {
        this.this$0 = diskLruCache;
        super(string, false, 2, null);
    }

    public long runOnce() {
        DiskLruCache diskLruCache = this.this$0;
        synchronized (diskLruCache) {
            if (!DiskLruCache.access$getInitialized$p((DiskLruCache)diskLruCache)) return -1L;
            boolean bl = diskLruCache.getClosed$okhttp();
            if (bl) {
                return -1L;
            }
            try {
                diskLruCache.trimToSize();
            }
            catch (IOException iOException) {
                DiskLruCache.access$setMostRecentTrimFailed$p((DiskLruCache)diskLruCache, (boolean)true);
            }
            try {
                if (!DiskLruCache.access$journalRebuildRequired((DiskLruCache)diskLruCache)) return -1L;
                diskLruCache.rebuildJournal$okhttp();
                DiskLruCache.access$setRedundantOpCount$p((DiskLruCache)diskLruCache, (int)0);
            }
            catch (IOException iOException) {
                DiskLruCache.access$setMostRecentRebuildFailed$p((DiskLruCache)diskLruCache, (boolean)true);
                DiskLruCache.access$setJournalWriter$p((DiskLruCache)diskLruCache, (BufferedSink)Okio.buffer((Sink)Okio.blackhole()));
            }
            return -1L;
        }
    }
}
