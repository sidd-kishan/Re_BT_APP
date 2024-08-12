/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.model.ByteBufferFileLoader
 *  com.bumptech.glide.load.model.ModelLoader
 *  com.bumptech.glide.load.model.ModelLoaderFactory
 *  com.bumptech.glide.load.model.MultiModelLoaderFactory
 */
package com.bumptech.glide.load.model;

import com.bumptech.glide.load.model.ByteBufferFileLoader;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import java.io.File;
import java.nio.ByteBuffer;

public static class ByteBufferFileLoader.Factory
implements ModelLoaderFactory<File, ByteBuffer> {
    public ModelLoader<File, ByteBuffer> build(MultiModelLoaderFactory multiModelLoaderFactory) {
        return new ByteBufferFileLoader();
    }

    public void teardown() {
    }
}
