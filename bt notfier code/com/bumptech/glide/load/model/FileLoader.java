/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.load.Key
 *  com.bumptech.glide.load.Options
 *  com.bumptech.glide.load.data.DataFetcher
 *  com.bumptech.glide.load.model.FileLoader$FileFetcher
 *  com.bumptech.glide.load.model.FileLoader$FileOpener
 *  com.bumptech.glide.load.model.ModelLoader
 *  com.bumptech.glide.load.model.ModelLoader$LoadData
 *  com.bumptech.glide.signature.ObjectKey
 */
package com.bumptech.glide.load.model;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.FileLoader;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import java.io.File;

public class FileLoader<Data>
implements ModelLoader<File, Data> {
    private static final String TAG = "FileLoader";
    private final FileOpener<Data> fileOpener;

    public FileLoader(FileOpener<Data> fileOpener) {
        this.fileOpener = fileOpener;
    }

    public ModelLoader.LoadData<Data> buildLoadData(File file, int n, int n2, Options options) {
        return new ModelLoader.LoadData((Key)new ObjectKey((Object)file), (DataFetcher)new FileFetcher(file, this.fileOpener));
    }

    public boolean handles(File file) {
        return true;
    }
}
