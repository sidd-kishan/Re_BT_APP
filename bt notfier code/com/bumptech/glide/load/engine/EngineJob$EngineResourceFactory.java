/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.engine.EngineResource
 *  com.bumptech.glide.load.engine.Resource
 */
package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.engine.EngineResource;
import com.bumptech.glide.load.engine.Resource;

static class EngineJob.EngineResourceFactory {
    EngineJob.EngineResourceFactory() {
    }

    public <R> EngineResource<R> build(Resource<R> resource, boolean bl) {
        return new EngineResource(resource, bl, true);
    }
}
