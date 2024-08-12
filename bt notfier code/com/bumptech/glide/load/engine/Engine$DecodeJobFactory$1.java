/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.engine.DecodeJob
 *  com.bumptech.glide.load.engine.Engine$DecodeJobFactory
 *  com.bumptech.glide.util.pool.FactoryPools$Factory
 */
package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.util.pool.FactoryPools;

class Engine.DecodeJobFactory.1
implements FactoryPools.Factory<DecodeJob<?>> {
    final Engine.DecodeJobFactory this$0;

    Engine.DecodeJobFactory.1(Engine.DecodeJobFactory decodeJobFactory) {
        this.this$0 = decodeJobFactory;
    }

    public DecodeJob<?> create() {
        return new DecodeJob(this.this$0.diskCacheProvider, this.this$0.pool);
    }
}
