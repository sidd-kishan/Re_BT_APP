/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.os.TraceCompat
 *  com.bumptech.glide.load.Key
 *  com.bumptech.glide.load.Options
 *  com.bumptech.glide.load.ResourceEncoder
 *  com.bumptech.glide.load.engine.DataCacheWriter
 *  com.bumptech.glide.load.engine.DecodeJob$DiskCacheProvider
 *  com.bumptech.glide.load.engine.LockedResource
 *  com.bumptech.glide.load.engine.cache.DiskCache
 *  com.bumptech.glide.load.engine.cache.DiskCache$Writer
 */
package com.bumptech.glide.load.engine;

import androidx.core.os.TraceCompat;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.DataCacheWriter;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.LockedResource;
import com.bumptech.glide.load.engine.cache.DiskCache;

private static class DecodeJob.DeferredEncodeManager<Z> {
    private ResourceEncoder<Z> encoder;
    private Key key;
    private LockedResource<Z> toEncode;

    DecodeJob.DeferredEncodeManager() {
    }

    void clear() {
        this.key = null;
        this.encoder = null;
        this.toEncode = null;
    }

    void encode(DecodeJob.DiskCacheProvider diskCacheProvider, Options options) {
        TraceCompat.beginSection((String)"DecodeJob.encode");
        try {
            DiskCache diskCache = diskCacheProvider.getDiskCache();
            diskCacheProvider = this.key;
            DataCacheWriter dataCacheWriter = new DataCacheWriter(this.encoder, this.toEncode, options);
            diskCache.put((Key)diskCacheProvider, (DiskCache.Writer)dataCacheWriter);
            return;
        }
        finally {
            this.toEncode.unlock();
            TraceCompat.endSection();
        }
    }

    boolean hasResourceToEncode() {
        boolean bl = this.toEncode != null;
        return bl;
    }

    <X> void init(Key key, ResourceEncoder<X> resourceEncoder, LockedResource<X> lockedResource) {
        this.key = key;
        this.encoder = resourceEncoder;
        this.toEncode = lockedResource;
    }
}
