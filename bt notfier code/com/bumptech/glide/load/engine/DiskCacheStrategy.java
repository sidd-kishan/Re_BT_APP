/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.DataSource
 *  com.bumptech.glide.load.EncodeStrategy
 */
package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;

public abstract class DiskCacheStrategy {
    public static final DiskCacheStrategy ALL = new /* Unavailable Anonymous Inner Class!! */;
    public static final DiskCacheStrategy AUTOMATIC;
    public static final DiskCacheStrategy DATA;
    public static final DiskCacheStrategy NONE;
    public static final DiskCacheStrategy RESOURCE;

    static {
        NONE = new /* Unavailable Anonymous Inner Class!! */;
        DATA = new /* Unavailable Anonymous Inner Class!! */;
        RESOURCE = new /* Unavailable Anonymous Inner Class!! */;
        AUTOMATIC = new /* Unavailable Anonymous Inner Class!! */;
    }

    public abstract boolean decodeCachedData();

    public abstract boolean decodeCachedResource();

    public abstract boolean isDataCacheable(DataSource var1);

    public abstract boolean isResourceCacheable(boolean var1, DataSource var2, EncodeStrategy var3);
}
