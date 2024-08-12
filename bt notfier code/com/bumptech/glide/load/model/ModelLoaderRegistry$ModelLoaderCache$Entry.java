/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.model.ModelLoader
 */
package com.bumptech.glide.load.model;

import com.bumptech.glide.load.model.ModelLoader;
import java.util.List;

private static class ModelLoaderRegistry.ModelLoaderCache.Entry<Model> {
    final List<ModelLoader<Model, ?>> loaders;

    public ModelLoaderRegistry.ModelLoaderCache.Entry(List<ModelLoader<Model, ?>> list) {
        this.loaders = list;
    }
}
