/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.disklrucache.DiskLruCache
 */
package com.bumptech.glide.disklrucache;

import com.bumptech.glide.disklrucache.DiskLruCache;
import java.util.concurrent.Callable;

/*
 * Exception performing whole class analysis ignored.
 */
class DiskLruCache.1
implements Callable<Void> {
    final DiskLruCache this$0;

    DiskLruCache.1(DiskLruCache diskLruCache) {
        this.this$0 = diskLruCache;
    }

    @Override
    public Void call() throws Exception {
        DiskLruCache diskLruCache = this.this$0;
        synchronized (diskLruCache) {
            if (DiskLruCache.access$100((DiskLruCache)this.this$0) == null) {
                return null;
            }
            DiskLruCache.access$200((DiskLruCache)this.this$0);
            if (!DiskLruCache.access$300((DiskLruCache)this.this$0)) return null;
            DiskLruCache.access$400((DiskLruCache)this.this$0);
            DiskLruCache.access$502((DiskLruCache)this.this$0, (int)0);
            return null;
        }
    }
}
