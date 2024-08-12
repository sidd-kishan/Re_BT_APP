/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.model.GlideUrl
 *  com.bumptech.glide.load.model.ModelCache
 *  com.bumptech.glide.load.model.ModelLoader
 *  com.bumptech.glide.load.model.ModelLoaderFactory
 *  com.bumptech.glide.load.model.MultiModelLoaderFactory
 *  com.bumptech.glide.load.model.stream.HttpGlideUrlLoader
 */
package com.bumptech.glide.load.model.stream;

import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelCache;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bumptech.glide.load.model.stream.HttpGlideUrlLoader;
import java.io.InputStream;

public static class HttpGlideUrlLoader.Factory
implements ModelLoaderFactory<GlideUrl, InputStream> {
    private final ModelCache<GlideUrl, GlideUrl> modelCache = new ModelCache(500L);

    public ModelLoader<GlideUrl, InputStream> build(MultiModelLoaderFactory multiModelLoaderFactory) {
        return new HttpGlideUrlLoader(this.modelCache);
    }

    public void teardown() {
    }
}
