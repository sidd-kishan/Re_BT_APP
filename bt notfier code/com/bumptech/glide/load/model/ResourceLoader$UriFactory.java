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
 *  com.bumptech.glide.load.model.UnitModelLoader
 */
package com.bumptech.glide.load.model;

import android.content.res.Resources;
import android.net.Uri;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bumptech.glide.load.model.ResourceLoader;
import com.bumptech.glide.load.model.UnitModelLoader;

public static class ResourceLoader.UriFactory
implements ModelLoaderFactory<Integer, Uri> {
    private final Resources resources;

    public ResourceLoader.UriFactory(Resources resources) {
        this.resources = resources;
    }

    public ModelLoader<Integer, Uri> build(MultiModelLoaderFactory multiModelLoaderFactory) {
        return new ResourceLoader(this.resources, (ModelLoader)UnitModelLoader.getInstance());
    }

    public void teardown() {
    }
}
