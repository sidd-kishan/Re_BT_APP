/*
 * Decompiled with CFR 0.152.
 */
package com.bumptech.glide.load.engine.cache;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

private static class DiskCacheWriteLocker.WriteLock {
    int interestedThreads;
    final Lock lock = new ReentrantLock();

    DiskCacheWriteLocker.WriteLock() {
    }
}
