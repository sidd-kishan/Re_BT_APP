/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.Options
 *  com.bumptech.glide.load.model.ModelLoader
 *  com.bumptech.glide.load.model.ModelLoader$LoadData
 */
package com.bumptech.glide.load.model;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;

private static class MultiModelLoaderFactory.EmptyModelLoader
implements ModelLoader<Object, Object> {
    MultiModelLoaderFactory.EmptyModelLoader() {
    }

    public ModelLoader.LoadData<Object> buildLoadData(Object object, int n, int n2, Options options) {
        return null;
    }

    public boolean handles(Object object) {
        return false;
    }
}
