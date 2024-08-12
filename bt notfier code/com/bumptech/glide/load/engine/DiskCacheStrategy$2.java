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

class DiskCacheStrategy.2
extends DiskCacheStrategy {
    DiskCacheStrategy.2() {
    }

    public boolean decodeCachedData() {
        return false;
    }

    public boolean decodeCachedResource() {
        return false;
    }

    public boolean isDataCacheable(DataSource dataSource) {
        return false;
    }

    public boolean isResourceCacheable(boolean bl, DataSource dataSource, EncodeStrategy encodeStrategy) {
        return false;
    }
}
