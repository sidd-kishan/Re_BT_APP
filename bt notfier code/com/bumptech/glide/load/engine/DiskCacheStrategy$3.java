/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.DataSource
 *  com.bumptech.glide.load.EncodeStrategy
 *  com.bumptech.glide.load.engine.DiskCacheStrategy
 */
package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

class DiskCacheStrategy.3
extends DiskCacheStrategy {
    DiskCacheStrategy.3() {
    }

    public boolean decodeCachedData() {
        return true;
    }

    public boolean decodeCachedResource() {
        return false;
    }

    public boolean isDataCacheable(DataSource dataSource) {
        boolean bl = dataSource != DataSource.DATA_DISK_CACHE && dataSource != DataSource.MEMORY_CACHE;
        return bl;
    }

    public boolean isResourceCacheable(boolean bl, DataSource dataSource, EncodeStrategy encodeStrategy) {
        return false;
    }
}
