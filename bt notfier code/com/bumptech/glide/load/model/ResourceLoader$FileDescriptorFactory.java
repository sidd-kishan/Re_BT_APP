/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.net.Uri
 *  android.os.ParcelFileDescriptor
 *  com.bumptech.glide.load.model.ModelLoader
 *  com.bumptech.glide.load.model.ModelLoaderFactory
 *  com.bumptech.glide.load.model.MultiModelLoaderFactory
 *  com.bumptech.glide.load.model.ResourceLoader
 */
package com.bumptech.glide.load.model;

import android.content.res.Resources;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bumptech.glide.load.model.ResourceLoader;

public static class ResourceLoader.FileDescriptorFactory
implements ModelLoaderFactory<Integer, ParcelFileDescriptor> {
    private final Resources resources;

    public ResourceLoader.FileDescriptorFactory(Resources resources) {
        this.resources = resources;
    }

    public ModelLoader<Integer, ParcelFileDescriptor> build(MultiModelLoaderFactory multiModelLoaderFactory) {
        return new ResourceLoader(this.resources, multiModelLoaderFactory.build(Uri.class, ParcelFileDescriptor.class));
    }

    public void teardown() {
    }
}
