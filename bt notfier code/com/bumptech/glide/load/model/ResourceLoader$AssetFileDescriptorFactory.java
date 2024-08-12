/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.AssetFileDescriptor
 *  android.content.res.Resources
 *  android.net.Uri
 *  com.bumptech.glide.load.model.ModelLoader
 *  com.bumptech.glide.load.model.ModelLoaderFactory
 *  com.bumptech.glide.load.model.MultiModelLoaderFactory
 *  com.bumptech.glide.load.model.ResourceLoader
 */
package com.bumptech.glide.load.model;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bumptech.glide.load.model.ResourceLoader;

public static final class ResourceLoader.AssetFileDescriptorFactory
implements ModelLoaderFactory<Integer, AssetFileDescriptor> {
    private final Resources resources;

    public ResourceLoader.AssetFileDescriptorFactory(Resources resources) {
        this.resources = resources;
    }

    public ModelLoader<Integer, AssetFileDescriptor> build(MultiModelLoaderFactory multiModelLoaderFactory) {
        return new ResourceLoader(this.resources, multiModelLoaderFactory.build(Uri.class, AssetFileDescriptor.class));
    }

    public void teardown() {
    }
}
