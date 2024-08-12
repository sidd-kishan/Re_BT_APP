/*
 * Decompiled with CFR 0.152.
 */
package com.bumptech.glide.disklrucache;

import java.util.concurrent.ThreadFactory;

private static final class DiskLruCache.DiskLruCacheThreadFactory
implements ThreadFactory {
    private DiskLruCache.DiskLruCacheThreadFactory() {
    }

    @Override
    public Thread newThread(Runnable runnable) {
        synchronized (this) {
            Thread thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }
    }
}
