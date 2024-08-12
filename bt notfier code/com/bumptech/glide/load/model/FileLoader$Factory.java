/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.model.FileLoader
 *  com.bumptech.glide.load.model.FileLoader$FileOpener
 *  com.bumptech.glide.load.model.ModelLoader
 *  com.bumptech.glide.load.model.ModelLoaderFactory
 *  com.bumptech.glide.load.model.MultiModelLoaderFactory
 */
package com.bumptech.glide.load.model;

import com.bumptech.glide.load.model.FileLoader;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import java.io.File;

public static class FileLoader.Factory<Data>
implements ModelLoaderFactory<File, Data> {
    private final FileLoader.FileOpener<Data> opener;

    public FileLoader.Factory(FileLoader.FileOpener<Data> fileOpener) {
        this.opener = fileOpener;
    }

    public final ModelLoader<File, Data> build(MultiModelLoaderFactory multiModelLoaderFactory) {
        return new FileLoader(this.opener);
    }

    public final void teardown() {
    }
}
