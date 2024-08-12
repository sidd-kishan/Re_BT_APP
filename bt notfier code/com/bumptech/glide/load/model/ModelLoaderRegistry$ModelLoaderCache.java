/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.model.ModelLoader
 *  com.bumptech.glide.load.model.ModelLoaderRegistry$ModelLoaderCache$Entry
 */
package com.bumptech.glide.load.model;

import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderRegistry;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

private static class ModelLoaderRegistry.ModelLoaderCache {
    private final Map<Class<?>, Entry<?>> cachedModelLoaders = new HashMap();

    ModelLoaderRegistry.ModelLoaderCache() {
    }

    public void clear() {
        this.cachedModelLoaders.clear();
    }

    public <Model> List<ModelLoader<Model, ?>> get(Class<Model> object) {
        object = (object = this.cachedModelLoaders.get(object)) == null ? null : ((Entry)object).loaders;
        return object;
    }

    public <Model> void put(Class<Model> clazz, List<ModelLoader<Model, ?>> object) {
        if (this.cachedModelLoaders.put(clazz, new Entry(object)) == null) {
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Already cached loaders for model: ");
        ((StringBuilder)object).append(clazz);
        throw new IllegalStateException(((StringBuilder)object).toString());
    }
}
