/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.AssetFileDescriptor
 *  android.net.Uri
 *  com.bumptech.glide.load.model.ModelLoader
 *  com.bumptech.glide.load.model.ModelLoaderFactory
 *  com.bumptech.glide.load.model.MultiModelLoaderFactory
 *  com.bumptech.glide.load.model.StringLoader
 */
package com.bumptech.glide.load.model;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bumptech.glide.load.model.StringLoader;

public static final class StringLoader.AssetFileDescriptorFactory
implements ModelLoaderFactory<String, AssetFileDescriptor> {
    public ModelLoader<String, AssetFileDescriptor> build(MultiModelLoaderFactory multiModelLoaderFactory) {
        return new StringLoader(multiModelLoaderFactory.build(Uri.class, AssetFileDescriptor.class));
    }

    public void teardown() {
    }
}
