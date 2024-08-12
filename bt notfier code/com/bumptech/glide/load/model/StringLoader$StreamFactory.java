/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  com.bumptech.glide.load.model.ModelLoader
 *  com.bumptech.glide.load.model.ModelLoaderFactory
 *  com.bumptech.glide.load.model.MultiModelLoaderFactory
 *  com.bumptech.glide.load.model.StringLoader
 */
package com.bumptech.glide.load.model;

import android.net.Uri;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bumptech.glide.load.model.StringLoader;
import java.io.InputStream;

public static class StringLoader.StreamFactory
implements ModelLoaderFactory<String, InputStream> {
    public ModelLoader<String, InputStream> build(MultiModelLoaderFactory multiModelLoaderFactory) {
        return new StringLoader(multiModelLoaderFactory.build(Uri.class, InputStream.class));
    }

    public void teardown() {
    }
}
