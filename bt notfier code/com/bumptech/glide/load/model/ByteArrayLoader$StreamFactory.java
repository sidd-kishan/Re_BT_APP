/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.model.ByteArrayLoader
 *  com.bumptech.glide.load.model.ByteArrayLoader$Converter
 *  com.bumptech.glide.load.model.ModelLoader
 *  com.bumptech.glide.load.model.ModelLoaderFactory
 *  com.bumptech.glide.load.model.MultiModelLoaderFactory
 */
package com.bumptech.glide.load.model;

import com.bumptech.glide.load.model.ByteArrayLoader;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import java.io.InputStream;

public static class ByteArrayLoader.StreamFactory
implements ModelLoaderFactory<byte[], InputStream> {
    public ModelLoader<byte[], InputStream> build(MultiModelLoaderFactory multiModelLoaderFactory) {
        return new ByteArrayLoader((ByteArrayLoader.Converter)new /* Unavailable Anonymous Inner Class!! */);
    }

    public void teardown() {
    }
}
