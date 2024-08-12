/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.net.Uri
 *  com.bumptech.glide.load.model.ModelLoader
 *  com.bumptech.glide.load.model.ModelLoaderFactory
 *  com.bumptech.glide.load.model.MultiModelLoaderFactory
 *  com.bumptech.glide.load.model.ResourceLoader
 */
package com.bumptech.glide.load.model;

import android.content.res.Resources;
import android.net.Uri;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bumptech.glide.load.model.ResourceLoader;
import java.io.InputStream;

public static class ResourceLoader.StreamFactory
implements ModelLoaderFactory<Integer, InputStream> {
    private final Resources resources;

    public ResourceLoader.StreamFactory(Resources resources) {
        this.resources = resources;
    }

    public ModelLoader<Integer, InputStream> build(MultiModelLoaderFactory multiModelLoaderFactory) {
        return new ResourceLoader(this.resources, multiModelLoaderFactory.build(Uri.class, InputStream.class));
    }

    public void teardown() {
    }
}
