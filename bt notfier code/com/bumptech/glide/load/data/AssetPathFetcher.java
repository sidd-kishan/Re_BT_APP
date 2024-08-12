/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.AssetManager
 *  android.util.Log
 *  com.bumptech.glide.Priority
 *  com.bumptech.glide.load.DataSource
 *  com.bumptech.glide.load.data.DataFetcher
 *  com.bumptech.glide.load.data.DataFetcher$DataCallback
 */
package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import java.io.IOException;

public abstract class AssetPathFetcher<T>
implements DataFetcher<T> {
    private static final String TAG = "AssetPathFetcher";
    private final AssetManager assetManager;
    private final String assetPath;
    private T data;

    public AssetPathFetcher(AssetManager assetManager, String string) {
        this.assetManager = assetManager;
        this.assetPath = string;
    }

    public void cancel() {
    }

    /*
     * Enabled force condition propagation
     */
    public void cleanup() {
        T t = this.data;
        if (t == null) {
            return;
        }
        try {
            this.close(t);
            return;
        }
        catch (IOException iOException) {
            return;
        }
    }

    protected abstract void close(T var1) throws IOException;

    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }

    public void loadData(Priority object, DataFetcher.DataCallback<? super T> dataCallback) {
        try {
            object = this.loadResource(this.assetManager, this.assetPath);
            this.data = object;
        }
        catch (IOException iOException) {
            if (Log.isLoggable((String)TAG, (int)3)) {
                Log.d((String)TAG, (String)"Failed to load data from asset manager", (Throwable)iOException);
            }
            dataCallback.onLoadFailed((Exception)iOException);
            return;
        }
        dataCallback.onDataReady(object);
    }

    protected abstract T loadResource(AssetManager var1, String var2) throws IOException;
}
