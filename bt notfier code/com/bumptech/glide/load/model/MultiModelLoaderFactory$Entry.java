/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.model.ModelLoaderFactory
 */
package com.bumptech.glide.load.model;

import com.bumptech.glide.load.model.ModelLoaderFactory;

private static class MultiModelLoaderFactory.Entry<Model, Data> {
    final Class<Data> dataClass;
    final ModelLoaderFactory<? extends Model, ? extends Data> factory;
    private final Class<Model> modelClass;

    public MultiModelLoaderFactory.Entry(Class<Model> clazz, Class<Data> clazz2, ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        this.modelClass = clazz;
        this.dataClass = clazz2;
        this.factory = modelLoaderFactory;
    }

    public boolean handles(Class<?> clazz) {
        return this.modelClass.isAssignableFrom(clazz);
    }

    public boolean handles(Class<?> clazz, Class<?> clazz2) {
        boolean bl = this.handles(clazz) && this.dataClass.isAssignableFrom(clazz2);
        return bl;
    }
}
