/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.util.Pools$Pool
 *  com.bumptech.glide.Priority
 *  com.bumptech.glide.load.DataSource
 *  com.bumptech.glide.load.data.DataFetcher
 *  com.bumptech.glide.load.data.DataFetcher$DataCallback
 *  com.bumptech.glide.load.engine.GlideException
 *  com.bumptech.glide.util.Preconditions
 */
package com.bumptech.glide.load.model;

import androidx.core.util.Pools;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

static class MultiModelLoader.MultiFetcher<Data>
implements DataFetcher<Data>,
DataFetcher.DataCallback<Data> {
    private DataFetcher.DataCallback<? super Data> callback;
    private int currentIndex;
    private List<Throwable> exceptions;
    private final List<DataFetcher<Data>> fetchers;
    private Priority priority;
    private final Pools.Pool<List<Throwable>> throwableListPool;

    MultiModelLoader.MultiFetcher(List<DataFetcher<Data>> list, Pools.Pool<List<Throwable>> pool) {
        this.throwableListPool = pool;
        Preconditions.checkNotEmpty(list);
        this.fetchers = list;
        this.currentIndex = 0;
    }

    private void startNextOrFail() {
        if (this.currentIndex < this.fetchers.size() - 1) {
            ++this.currentIndex;
            this.loadData(this.priority, this.callback);
        } else {
            Preconditions.checkNotNull(this.exceptions);
            this.callback.onLoadFailed((Exception)new GlideException("Fetch failed", new ArrayList<Throwable>(this.exceptions)));
        }
    }

    public void cancel() {
        Iterator<DataFetcher<Data>> iterator = this.fetchers.iterator();
        while (iterator.hasNext()) {
            iterator.next().cancel();
        }
    }

    public void cleanup() {
        List<Throwable> list = this.exceptions;
        if (list != null) {
            this.throwableListPool.release(list);
        }
        this.exceptions = null;
        list = this.fetchers.iterator();
        while (list.hasNext()) {
            ((DataFetcher)list.next()).cleanup();
        }
    }

    public Class<Data> getDataClass() {
        return this.fetchers.get(0).getDataClass();
    }

    public DataSource getDataSource() {
        return this.fetchers.get(0).getDataSource();
    }

    public void loadData(Priority priority, DataFetcher.DataCallback<? super Data> dataCallback) {
        this.priority = priority;
        this.callback = dataCallback;
        this.exceptions = (List)this.throwableListPool.acquire();
        this.fetchers.get(this.currentIndex).loadData(priority, (DataFetcher.DataCallback)this);
    }

    public void onDataReady(Data Data) {
        if (Data != null) {
            this.callback.onDataReady(Data);
        } else {
            this.startNextOrFail();
        }
    }

    public void onLoadFailed(Exception exception) {
        ((List)Preconditions.checkNotNull(this.exceptions)).add(exception);
        this.startNextOrFail();
    }
}
