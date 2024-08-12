/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.model.GlideUrl
 *  com.bumptech.glide.load.model.ModelLoader
 *  com.bumptech.glide.load.model.ModelLoaderFactory
 *  com.bumptech.glide.load.model.MultiModelLoaderFactory
 *  com.bumptech.glide.load.model.stream.UrlLoader
 */
package com.bumptech.glide.load.model.stream;

import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bumptech.glide.load.model.stream.UrlLoader;
import java.io.InputStream;
import java.net.URL;

public static class UrlLoader.StreamFactory
implements ModelLoaderFactory<URL, InputStream> {
    public ModelLoader<URL, InputStream> build(MultiModelLoaderFactory multiModelLoaderFactory) {
        return new UrlLoader(multiModelLoaderFactory.build(GlideUrl.class, InputStream.class));
    }

    public void teardown() {
    }
}
