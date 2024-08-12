/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.util.Pools$Pool
 *  com.bumptech.glide.GlideContext
 *  com.bumptech.glide.Priority
 *  com.bumptech.glide.load.Key
 *  com.bumptech.glide.load.Options
 *  com.bumptech.glide.load.Transformation
 *  com.bumptech.glide.load.engine.DecodeJob
 *  com.bumptech.glide.load.engine.DecodeJob$Callback
 *  com.bumptech.glide.load.engine.DecodeJob$DiskCacheProvider
 *  com.bumptech.glide.load.engine.DiskCacheStrategy
 *  com.bumptech.glide.load.engine.EngineKey
 *  com.bumptech.glide.util.Preconditions
 *  com.bumptech.glide.util.pool.FactoryPools
 *  com.bumptech.glide.util.pool.FactoryPools$Factory
 */
package com.bumptech.glide.load.engine;

import androidx.core.util.Pools;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.EngineKey;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.pool.FactoryPools;
import java.util.Map;

static class Engine.DecodeJobFactory {
    private int creationOrder;
    final DecodeJob.DiskCacheProvider diskCacheProvider;
    final Pools.Pool<DecodeJob<?>> pool = FactoryPools.simple((int)150, (FactoryPools.Factory)new /* Unavailable Anonymous Inner Class!! */);

    Engine.DecodeJobFactory(DecodeJob.DiskCacheProvider diskCacheProvider) {
        this.diskCacheProvider = diskCacheProvider;
    }

    <R> DecodeJob<R> build(GlideContext glideContext, Object object, EngineKey engineKey, Key key, int n, int n2, Class<?> clazz, Class<R> clazz2, Priority priority, DiskCacheStrategy diskCacheStrategy, Map<Class<?>, Transformation<?>> map, boolean bl, boolean bl2, boolean bl3, Options options, DecodeJob.Callback<R> callback) {
        DecodeJob decodeJob = (DecodeJob)Preconditions.checkNotNull((Object)((DecodeJob)this.pool.acquire()));
        int n3 = this.creationOrder;
        this.creationOrder = n3 + 1;
        return decodeJob.init(glideContext, object, engineKey, key, n, n2, clazz, clazz2, priority, diskCacheStrategy, map, bl, bl2, bl3, options, callback, n3);
    }
}
