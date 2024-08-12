/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.engine.Engine$EngineJobFactory
 *  com.bumptech.glide.load.engine.EngineJob
 *  com.bumptech.glide.util.pool.FactoryPools$Factory
 */
package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.EngineJob;
import com.bumptech.glide.util.pool.FactoryPools;

class Engine.EngineJobFactory.1
implements FactoryPools.Factory<EngineJob<?>> {
    final Engine.EngineJobFactory this$0;

    Engine.EngineJobFactory.1(Engine.EngineJobFactory engineJobFactory) {
        this.this$0 = engineJobFactory;
    }

    public EngineJob<?> create() {
        return new EngineJob(this.this$0.diskCacheExecutor, this.this$0.sourceExecutor, this.this$0.sourceUnlimitedExecutor, this.this$0.animationExecutor, this.this$0.listener, this.this$0.pool);
    }
}
