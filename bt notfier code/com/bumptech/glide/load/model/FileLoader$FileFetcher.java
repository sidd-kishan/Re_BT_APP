/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.bumptech.glide.Priority
 *  com.bumptech.glide.load.DataSource
 *  com.bumptech.glide.load.data.DataFetcher
 *  com.bumptech.glide.load.data.DataFetcher$DataCallback
 *  com.bumptech.glide.load.model.FileLoader$FileOpener
 */
package com.bumptech.glide.load.model;

import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.FileLoader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

private static final class FileLoader.FileFetcher<Data>
implements DataFetcher<Data> {
    private Data data;
    private final File file;
    private final FileLoader.FileOpener<Data> opener;

    FileLoader.FileFetcher(File file, FileLoader.FileOpener<Data> fileOpener) {
        this.file = file;
        this.opener = fileOpener;
    }

    public void cancel() {
    }

    /*
     * Enabled force condition propagation
     */
    public void cleanup() {
        Data Data = this.data;
        if (Data == null) return;
        try {
            this.opener.close(Data);
            return;
        }
        catch (IOException iOException) {
            return;
        }
    }

    public Class<Data> getDataClass() {
        return this.opener.getDataClass();
    }

    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }

    public void loadData(Priority object, DataFetcher.DataCallback<? super Data> dataCallback) {
        try {
            object = this.opener.open(this.file);
            this.data = object;
        }
        catch (FileNotFoundException fileNotFoundException) {
            if (Log.isLoggable((String)"FileLoader", (int)3)) {
                Log.d((String)"FileLoader", (String)"Failed to open file", (Throwable)fileNotFoundException);
            }
            dataCallback.onLoadFailed((Exception)fileNotFoundException);
            return;
        }
        dataCallback.onDataReady(object);
    }
}
