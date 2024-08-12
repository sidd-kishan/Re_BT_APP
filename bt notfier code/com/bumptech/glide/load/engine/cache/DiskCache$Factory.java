/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.engine.cache.DiskCache
 */
package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.engine.cache.DiskCache;

public static interface DiskCache.Factory {
    public static final String DEFAULT_DISK_CACHE_DIR = "image_manager_disk_cache";
    public static final int DEFAULT_DISK_CACHE_SIZE = 0xFA00000;

    public DiskCache build();
}
