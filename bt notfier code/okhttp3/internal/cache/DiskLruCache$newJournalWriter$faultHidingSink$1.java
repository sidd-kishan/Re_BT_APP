/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Lambda
 *  okhttp3.internal.Util
 *  okhttp3.internal.cache.DiskLruCache
 */
package okhttp3.internal.cache;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import okhttp3.internal.Util;
import okhttp3.internal.cache.DiskLruCache;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2={"<anonymous>", "", "it", "Ljava/io/IOException;"}, k=3, mv={1, 5, 1}, xi=48)
static final class DiskLruCache.newJournalWriter.faultHidingSink.1
extends Lambda
implements Function1<IOException, Unit> {
    final DiskLruCache this$0;

    DiskLruCache.newJournalWriter.faultHidingSink.1(DiskLruCache diskLruCache) {
        this.this$0 = diskLruCache;
        super(1);
    }

    public final void invoke(IOException serializable) {
        Intrinsics.checkNotNullParameter((Object)serializable, (String)"it");
        DiskLruCache diskLruCache = this.this$0;
        if (Util.assertionsEnabled && !Thread.holdsLock(diskLruCache)) {
            serializable = new StringBuilder();
            ((StringBuilder)serializable).append("Thread ");
            ((StringBuilder)serializable).append((Object)Thread.currentThread().getName());
            ((StringBuilder)serializable).append(" MUST hold lock on ");
            ((StringBuilder)serializable).append(diskLruCache);
            throw new AssertionError((Object)((StringBuilder)serializable).toString());
        }
        DiskLruCache.access$setHasJournalErrors$p((DiskLruCache)this.this$0, (boolean)true);
    }
}
