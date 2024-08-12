/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.bumptech.glide.load.engine.cache.DiskLruCacheFactory
 *  com.bumptech.glide.load.engine.cache.DiskLruCacheFactory$CacheDirectoryGetter
 */
package com.bumptech.glide.load.engine.cache;

import android.content.Context;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;

public final class ExternalPreferredCacheDiskCacheFactory
extends DiskLruCacheFactory {
    public ExternalPreferredCacheDiskCacheFactory(Context context) {
        this(context, "image_manager_disk_cache", 0xFA00000L);
    }

    public ExternalPreferredCacheDiskCacheFactory(Context context, long l) {
        this(context, "image_manager_disk_cache", l);
    }

    public ExternalPreferredCacheDiskCacheFactory(Context context, String string, long l) {
        super((DiskLruCacheFactory.CacheDirectoryGetter)new /* Unavailable Anonymous Inner Class!! */, l);
    }
}
