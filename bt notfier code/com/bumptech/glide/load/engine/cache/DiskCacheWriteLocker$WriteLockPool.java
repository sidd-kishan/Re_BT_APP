/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.engine.cache.DiskCacheWriteLocker$WriteLock
 */
package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.engine.cache.DiskCacheWriteLocker;
import java.util.ArrayDeque;
import java.util.Queue;

private static class DiskCacheWriteLocker.WriteLockPool {
    private static final int MAX_POOL_SIZE = 10;
    private final Queue<DiskCacheWriteLocker.WriteLock> pool = new ArrayDeque<DiskCacheWriteLocker.WriteLock>();

    DiskCacheWriteLocker.WriteLockPool() {
    }

    /*
     * Enabled unnecessary exception pruning
     */
    DiskCacheWriteLocker.WriteLock obtain() {
        DiskCacheWriteLocker.WriteLock writeLock;
        DiskCacheWriteLocker.WriteLock writeLock2 = this.pool;
        synchronized (writeLock2) {
            writeLock = this.pool.poll();
        }
        writeLock2 = writeLock;
        if (writeLock != null) return writeLock2;
        return new DiskCacheWriteLocker.WriteLock();
    }

    void offer(DiskCacheWriteLocker.WriteLock writeLock) {
        Queue<DiskCacheWriteLocker.WriteLock> queue = this.pool;
        synchronized (queue) {
            if (this.pool.size() >= 10) return;
            this.pool.offer(writeLock);
            return;
        }
    }
}
