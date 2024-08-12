/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Lambda
 *  okhttp3.internal.cache.DiskLruCache
 *  okhttp3.internal.cache.DiskLruCache$Editor
 */
package okhttp3.internal.cache;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import okhttp3.internal.cache.DiskLruCache;

@Metadata(d1={"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2={"<anonymous>", "", "it", "Ljava/io/IOException;"}, k=3, mv={1, 5, 1}, xi=48)
static final class DiskLruCache.Editor.newSink.1.1
extends Lambda
implements Function1<IOException, Unit> {
    final DiskLruCache this$0;
    final DiskLruCache.Editor this$1;

    DiskLruCache.Editor.newSink.1.1(DiskLruCache diskLruCache, DiskLruCache.Editor editor) {
        this.this$0 = diskLruCache;
        this.this$1 = editor;
        super(1);
    }

    public final void invoke(IOException iOException) {
        Intrinsics.checkNotNullParameter((Object)iOException, (String)"it");
        iOException = this.this$0;
        DiskLruCache.Editor editor = this.this$1;
        synchronized (iOException) {
            editor.detach$okhttp();
            editor = Unit.INSTANCE;
            return;
        }
    }
}
