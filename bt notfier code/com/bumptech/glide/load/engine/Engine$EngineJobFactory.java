/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.util.Pools$Pool
 *  com.bumptech.glide.load.Key
 *  com.bumptech.glide.load.engine.EngineJob
 *  com.bumptech.glide.load.engine.EngineJobListener
 *  com.bumptech.glide.load.engine.executor.GlideExecutor
 *  com.bumptech.glide.util.Preconditions
 *  com.bumptech.glide.util.pool.FactoryPools
 *  com.bumptech.glide.util.pool.FactoryPools$Factory
 */
package com.bumptech.glide.load.engine;

import androidx.core.util.Pools;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.EngineJob;
import com.bumptech.glide.load.engine.EngineJobListener;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.pool.FactoryPools;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

static class Engine.EngineJobFactory {
    final GlideExecutor animationExecutor;
    final GlideExecutor diskCacheExecutor;
    final EngineJobListener listener;
    final Pools.Pool<EngineJob<?>> pool = FactoryPools.simple((int)150, (FactoryPools.Factory)new /* Unavailable Anonymous Inner Class!! */);
    final GlideExecutor sourceExecutor;
    final GlideExecutor sourceUnlimitedExecutor;

    Engine.EngineJobFactory(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, EngineJobListener engineJobListener) {
        this.diskCacheExecutor = glideExecutor;
        this.sourceExecutor = glideExecutor2;
        this.sourceUnlimitedExecutor = glideExecutor3;
        this.animationExecutor = glideExecutor4;
        this.listener = engineJobListener;
    }

    private static void shutdownAndAwaitTermination(ExecutorService object) {
        object.shutdown();
        try {
            if (object.awaitTermination(5L, TimeUnit.SECONDS)) return;
            object.shutdownNow();
            if (object.awaitTermination(5L, TimeUnit.SECONDS)) {
                return;
            }
            object = new RuntimeException("Failed to shutdown");
            throw object;
        }
        catch (InterruptedException interruptedException) {
            throw new RuntimeException(interruptedException);
        }
    }

    <R> EngineJob<R> build(Key key, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        return ((EngineJob)Preconditions.checkNotNull((Object)((EngineJob)this.pool.acquire()))).init(key, bl, bl2, bl3, bl4);
    }

    void shutdown() {
        Engine.EngineJobFactory.shutdownAndAwaitTermination((ExecutorService)this.diskCacheExecutor);
        Engine.EngineJobFactory.shutdownAndAwaitTermination((ExecutorService)this.sourceExecutor);
        Engine.EngineJobFactory.shutdownAndAwaitTermination((ExecutorService)this.sourceUnlimitedExecutor);
        Engine.EngineJobFactory.shutdownAndAwaitTermination((ExecutorService)this.animationExecutor);
    }
}
