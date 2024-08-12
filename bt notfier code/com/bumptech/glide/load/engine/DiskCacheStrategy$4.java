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

class DiskCacheStrategy.4
extends DiskCacheStrategy {
    DiskCacheStrategy.4() {
    }

    public boolean decodeCachedData() {
        return false;
    }

    public boolean decodeCachedResource() {
        return true;
    }

    public boolean isDataCacheable(DataSource dataSource) {
        return false;
    }

    public boolean isResourceCacheable(boolean bl, DataSource dataSource, EncodeStrategy encodeStrategy) {
        bl = dataSource != DataSource.RESOURCE_DISK_CACHE && dataSource != DataSource.MEMORY_CACHE;
        return bl;
    }
}
