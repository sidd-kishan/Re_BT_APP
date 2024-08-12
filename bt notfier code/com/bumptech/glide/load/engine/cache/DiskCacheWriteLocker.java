/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.engine.cache.DiskCacheWriteLocker$WriteLock
 *  com.bumptech.glide.load.engine.cache.DiskCacheWriteLocker$WriteLockPool
 *  com.bumptech.glide.util.Preconditions
 */
package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.engine.cache.DiskCacheWriteLocker;
import com.bumptech.glide.util.Preconditions;
import java.util.HashMap;
import java.util.Map;

final class DiskCacheWriteLocker {
    private final Map<String, WriteLock> locks = new HashMap<String, WriteLock>();
    private final WriteLockPool writeLockPool = new WriteLockPool();

    DiskCacheWriteLocker() {
    }

    /*
     * Enabled unnecessary exception pruning
     */
    void acquire(String string) {
        WriteLock writeLock;
        synchronized (this) {
            WriteLock writeLock2;
            writeLock = writeLock2 = this.locks.get(string);
            if (writeLock2 == null) {
                writeLock = this.writeLockPool.obtain();
                this.locks.put(string, writeLock);
            }
            ++writeLock.interestedThreads;
        }
        writeLock.lock.lock();
    }

    void release(String string) {
        synchronized (this) {
            WriteLock writeLock = (WriteLock)Preconditions.checkNotNull((Object)this.locks.get(string));
            if (writeLock.interestedThreads >= 1) {
                --writeLock.interestedThreads;
                if (writeLock.interestedThreads == 0) {
                    WriteLock writeLock2 = this.locks.remove(string);
                    if (!writeLock2.equals(writeLock)) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Removed the wrong lock, expected to remove: ");
                        stringBuilder.append(writeLock);
                        stringBuilder.append(", but actually removed: ");
                        stringBuilder.append(writeLock2);
                        stringBuilder.append(", safeKey: ");
                        stringBuilder.append(string);
                        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
                        throw illegalStateException;
                    }
                    this.writeLockPool.offer(writeLock2);
                }
                // MONITOREXIT @DISABLED, blocks:[0, 2, 6] lbl25 : MonitorExitStatement: MONITOREXIT : this
                writeLock.lock.unlock();
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Cannot release a lock that is not held, safeKey: ");
            stringBuilder.append(string);
            stringBuilder.append(", interestedThreads: ");
            stringBuilder.append(writeLock.interestedThreads);
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
            throw illegalStateException;
        }
    }
}
