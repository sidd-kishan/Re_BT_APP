/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.engine.DecodeJob$DiskCacheProvider
 *  com.bumptech.glide.load.engine.cache.DiskCache
 *  com.bumptech.glide.load.engine.cache.DiskCache$Factory
 *  com.bumptech.glide.load.engine.cache.DiskCacheAdapter
 */
package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.DiskCacheAdapter;

private static class Engine.LazyDiskCacheProvider
implements DecodeJob.DiskCacheProvider {
    private volatile DiskCache diskCache;
    private final DiskCache.Factory factory;

    Engine.LazyDiskCacheProvider(DiskCache.Factory factory) {
        this.factory = factory;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    void clearDiskCacheIfCreated() {
        synchronized (this) {
            DiskCache diskCache = this.diskCache;
            if (diskCache == null) {
                return;
            }
            this.diskCache.clear();
            return;
        }
    }

    public DiskCache getDiskCache() {
        if (this.diskCache != null) return this.diskCache;
        synchronized (this) {
            if (this.diskCache == null) {
                this.diskCache = this.factory.build();
            }
            if (this.diskCache != null) return this.diskCache;
            DiskCacheAdapter diskCacheAdapter = new DiskCacheAdapter();
            this.diskCache = diskCacheAdapter;
        }
        return this.diskCache;
    }
}
