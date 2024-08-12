/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.model.ModelLoader
 *  com.bumptech.glide.load.model.ModelLoaderFactory
 *  com.bumptech.glide.load.model.MultiModelLoaderFactory
 *  com.bumptech.glide.load.model.UnitModelLoader
 */
package com.bumptech.glide.load.model;

import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bumptech.glide.load.model.UnitModelLoader;

/*
 * Exception performing whole class analysis ignored.
 */
public static class UnitModelLoader.Factory<Model>
implements ModelLoaderFactory<Model, Model> {
    private static final UnitModelLoader.Factory<?> FACTORY = new UnitModelLoader.Factory();

    @Deprecated
    public UnitModelLoader.Factory() {
    }

    public static <T> UnitModelLoader.Factory<T> getInstance() {
        return FACTORY;
    }

    public ModelLoader<Model, Model> build(MultiModelLoaderFactory multiModelLoaderFactory) {
        return UnitModelLoader.getInstance();
    }

    public void teardown() {
    }
}
