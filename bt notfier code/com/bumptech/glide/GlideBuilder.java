/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.collection.ArrayMap
 *  com.bumptech.glide.Glide
 *  com.bumptech.glide.TransitionOptions
 *  com.bumptech.glide.load.DecodeFormat
 *  com.bumptech.glide.load.engine.Engine
 *  com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
 *  com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
 *  com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter
 *  com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool
 *  com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool
 *  com.bumptech.glide.load.engine.cache.DiskCache
 *  com.bumptech.glide.load.engine.cache.DiskCache$Factory
 *  com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory
 *  com.bumptech.glide.load.engine.cache.LruResourceCache
 *  com.bumptech.glide.load.engine.cache.MemoryCache
 *  com.bumptech.glide.load.engine.cache.MemorySizeCalculator
 *  com.bumptech.glide.load.engine.cache.MemorySizeCalculator$Builder
 *  com.bumptech.glide.load.engine.executor.GlideExecutor
 *  com.bumptech.glide.manager.ConnectivityMonitorFactory
 *  com.bumptech.glide.manager.DefaultConnectivityMonitorFactory
 *  com.bumptech.glide.manager.RequestManagerRetriever
 *  com.bumptech.glide.manager.RequestManagerRetriever$RequestManagerFactory
 *  com.bumptech.glide.request.RequestOptions
 */
package com.bumptech.glide;

import android.content.Context;
import androidx.collection.ArrayMap;
import com.bumptech.glide.Glide;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter;
import com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.request.RequestOptions;
import java.util.Map;

public final class GlideBuilder {
    private GlideExecutor animationExecutor;
    private ArrayPool arrayPool;
    private BitmapPool bitmapPool;
    private ConnectivityMonitorFactory connectivityMonitorFactory;
    private RequestOptions defaultRequestOptions;
    private final Map<Class<?>, TransitionOptions<?, ?>> defaultTransitionOptions = new ArrayMap();
    private GlideExecutor diskCacheExecutor;
    private DiskCache.Factory diskCacheFactory;
    private Engine engine;
    private boolean isActiveResourceRetentionAllowed;
    private int logLevel = 4;
    private MemoryCache memoryCache;
    private MemorySizeCalculator memorySizeCalculator;
    private RequestManagerRetriever.RequestManagerFactory requestManagerFactory;
    private GlideExecutor sourceExecutor;

    public GlideBuilder() {
        this.defaultRequestOptions = new RequestOptions();
    }

    public Glide build(Context context) {
        if (this.sourceExecutor == null) {
            this.sourceExecutor = GlideExecutor.newSourceExecutor();
        }
        if (this.diskCacheExecutor == null) {
            this.diskCacheExecutor = GlideExecutor.newDiskCacheExecutor();
        }
        if (this.animationExecutor == null) {
            this.animationExecutor = GlideExecutor.newAnimationExecutor();
        }
        if (this.memorySizeCalculator == null) {
            this.memorySizeCalculator = new MemorySizeCalculator.Builder(context).build();
        }
        if (this.connectivityMonitorFactory == null) {
            this.connectivityMonitorFactory = new DefaultConnectivityMonitorFactory();
        }
        if (this.bitmapPool == null) {
            int n = this.memorySizeCalculator.getBitmapPoolSize();
            this.bitmapPool = n > 0 ? new LruBitmapPool((long)n) : new BitmapPoolAdapter();
        }
        if (this.arrayPool == null) {
            this.arrayPool = new LruArrayPool(this.memorySizeCalculator.getArrayPoolSizeInBytes());
        }
        if (this.memoryCache == null) {
            this.memoryCache = new LruResourceCache((long)this.memorySizeCalculator.getMemoryCacheSize());
        }
        if (this.diskCacheFactory == null) {
            this.diskCacheFactory = new InternalCacheDiskCacheFactory(context);
        }
        if (this.engine == null) {
            this.engine = new Engine(this.memoryCache, this.diskCacheFactory, this.diskCacheExecutor, this.sourceExecutor, GlideExecutor.newUnlimitedSourceExecutor(), GlideExecutor.newAnimationExecutor(), this.isActiveResourceRetentionAllowed);
        }
        RequestManagerRetriever requestManagerRetriever = new RequestManagerRetriever(this.requestManagerFactory);
        return new Glide(context, this.engine, this.memoryCache, this.bitmapPool, this.arrayPool, requestManagerRetriever, this.connectivityMonitorFactory, this.logLevel, this.defaultRequestOptions.lock(), this.defaultTransitionOptions);
    }

    public GlideBuilder setAnimationExecutor(GlideExecutor glideExecutor) {
        this.animationExecutor = glideExecutor;
        return this;
    }

    public GlideBuilder setArrayPool(ArrayPool arrayPool) {
        this.arrayPool = arrayPool;
        return this;
    }

    public GlideBuilder setBitmapPool(BitmapPool bitmapPool) {
        this.bitmapPool = bitmapPool;
        return this;
    }

    public GlideBuilder setConnectivityMonitorFactory(ConnectivityMonitorFactory connectivityMonitorFactory) {
        this.connectivityMonitorFactory = connectivityMonitorFactory;
        return this;
    }

    @Deprecated
    public GlideBuilder setDecodeFormat(DecodeFormat decodeFormat) {
        this.defaultRequestOptions = this.defaultRequestOptions.apply(new RequestOptions().format(decodeFormat));
        return this;
    }

    public GlideBuilder setDefaultRequestOptions(RequestOptions requestOptions) {
        this.defaultRequestOptions = requestOptions;
        return this;
    }

    public <T> GlideBuilder setDefaultTransitionOptions(Class<T> clazz, TransitionOptions<?, T> transitionOptions) {
        this.defaultTransitionOptions.put(clazz, transitionOptions);
        return this;
    }

    public GlideBuilder setDiskCache(DiskCache.Factory factory) {
        this.diskCacheFactory = factory;
        return this;
    }

    @Deprecated
    public GlideBuilder setDiskCache(DiskCache diskCache) {
        return this.setDiskCache((DiskCache.Factory)new /* Unavailable Anonymous Inner Class!! */);
    }

    public GlideBuilder setDiskCacheExecutor(GlideExecutor glideExecutor) {
        this.diskCacheExecutor = glideExecutor;
        return this;
    }

    GlideBuilder setEngine(Engine engine) {
        this.engine = engine;
        return this;
    }

    public GlideBuilder setIsActiveResourceRetentionAllowed(boolean bl) {
        this.isActiveResourceRetentionAllowed = bl;
        return this;
    }

    public GlideBuilder setLogLevel(int n) {
        if (n < 2) throw new IllegalArgumentException("Log level must be one of Log.VERBOSE, Log.DEBUG, Log.INFO, Log.WARN, or Log.ERROR");
        if (n > 6) throw new IllegalArgumentException("Log level must be one of Log.VERBOSE, Log.DEBUG, Log.INFO, Log.WARN, or Log.ERROR");
        this.logLevel = n;
        return this;
    }

    public GlideBuilder setMemoryCache(MemoryCache memoryCache) {
        this.memoryCache = memoryCache;
        return this;
    }

    public GlideBuilder setMemorySizeCalculator(MemorySizeCalculator.Builder builder) {
        return this.setMemorySizeCalculator(builder.build());
    }

    public GlideBuilder setMemorySizeCalculator(MemorySizeCalculator memorySizeCalculator) {
        this.memorySizeCalculator = memorySizeCalculator;
        return this;
    }

    void setRequestManagerFactory(RequestManagerRetriever.RequestManagerFactory requestManagerFactory) {
        this.requestManagerFactory = requestManagerFactory;
    }

    @Deprecated
    public GlideBuilder setResizeExecutor(GlideExecutor glideExecutor) {
        return this.setSourceExecutor(glideExecutor);
    }

    public GlideBuilder setSourceExecutor(GlideExecutor glideExecutor) {
        this.sourceExecutor = glideExecutor;
        return this;
    }
}
