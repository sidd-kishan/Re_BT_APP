/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.util.Pools$Pool
 *  com.bumptech.glide.load.model.ModelLoader
 *  com.bumptech.glide.load.model.MultiModelLoader
 */
package com.bumptech.glide.load.model;

import androidx.core.util.Pools;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.MultiModelLoader;
import java.util.List;

static class MultiModelLoaderFactory.Factory {
    MultiModelLoaderFactory.Factory() {
    }

    public <Model, Data> MultiModelLoader<Model, Data> build(List<ModelLoader<Model, Data>> list, Pools.Pool<List<Throwable>> pool) {
        return new MultiModelLoader(list, pool);
    }
}
