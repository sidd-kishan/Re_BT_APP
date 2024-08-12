/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.model.DataUrlLoader
 *  com.bumptech.glide.load.model.DataUrlLoader$DataDecoder
 *  com.bumptech.glide.load.model.ModelLoader
 *  com.bumptech.glide.load.model.ModelLoaderFactory
 *  com.bumptech.glide.load.model.MultiModelLoaderFactory
 */
package com.bumptech.glide.load.model;

import com.bumptech.glide.load.model.DataUrlLoader;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import java.io.InputStream;

public static final class DataUrlLoader.StreamFactory
implements ModelLoaderFactory<String, InputStream> {
    private final DataUrlLoader.DataDecoder<InputStream> opener = new /* Unavailable Anonymous Inner Class!! */;

    public ModelLoader<String, InputStream> build(MultiModelLoaderFactory multiModelLoaderFactory) {
        return new DataUrlLoader(this.opener);
    }

    public void teardown() {
    }
}
