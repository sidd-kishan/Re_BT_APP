/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  com.bumptech.glide.load.model.GlideUrl
 *  com.bumptech.glide.load.model.ModelLoader
 *  com.bumptech.glide.load.model.ModelLoaderFactory
 *  com.bumptech.glide.load.model.MultiModelLoaderFactory
 *  com.bumptech.glide.load.model.stream.HttpUriLoader
 */
package com.bumptech.glide.load.model.stream;

import android.net.Uri;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bumptech.glide.load.model.stream.HttpUriLoader;
import java.io.InputStream;

public static class HttpUriLoader.Factory
implements ModelLoaderFactory<Uri, InputStream> {
    public ModelLoader<Uri, InputStream> build(MultiModelLoaderFactory multiModelLoaderFactory) {
        return new HttpUriLoader(multiModelLoaderFactory.build(GlideUrl.class, InputStream.class));
    }

    public void teardown() {
    }
}
