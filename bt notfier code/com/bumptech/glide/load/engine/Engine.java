/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.bumptech.glide.GlideContext
 *  com.bumptech.glide.Priority
 *  com.bumptech.glide.load.DataSource
 *  com.bumptech.glide.load.Key
 *  com.bumptech.glide.load.Options
 *  com.bumptech.glide.load.Transformation
 *  com.bumptech.glide.load.engine.ActiveResources
 *  com.bumptech.glide.load.engine.DecodeJob
 *  com.bumptech.glide.load.engine.DecodeJob$Callback
 *  com.bumptech.glide.load.engine.DecodeJob$DiskCacheProvider
 *  com.bumptech.glide.load.engine.DiskCacheStrategy
 *  com.bumptech.glide.load.engine.Engine$DecodeJobFactory
 *  com.bumptech.glide.load.engine.Engine$EngineJobFactory
 *  com.bumptech.glide.load.engine.Engine$LazyDiskCacheProvider
 *  com.bumptech.glide.load.engine.Engine$LoadStatus
 *  com.bumptech.glide.load.engine.EngineJob
 *  com.bumptech.glide.load.engine.EngineJobListener
 *  com.bumptech.glide.load.engine.EngineKey
 *  com.bumptech.glide.load.engine.EngineKeyFactory
 *  com.bumptech.glide.load.engine.EngineResource
 *  com.bumptech.glide.load.engine.EngineResource$ResourceListener
 *  com.bumptech.glide.load.engine.Jobs
 *  com.bumptech.glide.load.engine.Resource
 *  com.bumptech.glide.load.engine.ResourceRecycler
 *  com.bumptech.glide.load.engine.cache.DiskCache$Factory
 *  com.bumptech.glide.load.engine.cache.MemoryCache
 *  com.bumptech.glide.load.engine.cache.MemoryCache$ResourceRemovedListener
 *  com.bumptech.glide.load.engine.executor.GlideExecutor
 *  com.bumptech.glide.request.ResourceCallback
 *  com.bumptech.glide.util.LogTime
 *  com.bumptech.glide.util.Util
 */
package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.ActiveResources;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.EngineJob;
import com.bumptech.glide.load.engine.EngineJobListener;
import com.bumptech.glide.load.engine.EngineKey;
import com.bumptech.glide.load.engine.EngineKeyFactory;
import com.bumptech.glide.load.engine.EngineResource;
import com.bumptech.glide.load.engine.Jobs;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.ResourceRecycler;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.request.ResourceCallback;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import java.util.Map;

public class Engine
implements EngineJobListener,
MemoryCache.ResourceRemovedListener,
EngineResource.ResourceListener {
    private static final int JOB_POOL_SIZE = 150;
    private static final String TAG = "Engine";
    private final ActiveResources activeResources;
    private final MemoryCache cache;
    private final DecodeJobFactory decodeJobFactory;
    private final LazyDiskCacheProvider diskCacheProvider;
    private final EngineJobFactory engineJobFactory;
    private final Jobs jobs;
    private final EngineKeyFactory keyFactory;
    private final ResourceRecycler resourceRecycler;

    Engine(MemoryCache memoryCache, DiskCache.Factory factory, GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, Jobs jobs, EngineKeyFactory engineKeyFactory, ActiveResources activeResources, EngineJobFactory engineJobFactory, DecodeJobFactory decodeJobFactory, ResourceRecycler resourceRecycler, boolean bl) {
        this.cache = memoryCache;
        this.diskCacheProvider = new LazyDiskCacheProvider(factory);
        if (activeResources == null) {
            activeResources = new ActiveResources(bl);
        }
        this.activeResources = activeResources;
        activeResources.setListener((EngineResource.ResourceListener)this);
        if (engineKeyFactory == null) {
            engineKeyFactory = new EngineKeyFactory();
        }
        this.keyFactory = engineKeyFactory;
        factory = jobs == null ? new Jobs() : jobs;
        this.jobs = factory;
        if (engineJobFactory == null) {
            engineJobFactory = new EngineJobFactory(glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, (EngineJobListener)this);
        }
        this.engineJobFactory = engineJobFactory;
        factory = decodeJobFactory == null ? new DecodeJobFactory((DecodeJob.DiskCacheProvider)this.diskCacheProvider) : decodeJobFactory;
        this.decodeJobFactory = factory;
        factory = resourceRecycler == null ? new ResourceRecycler() : resourceRecycler;
        this.resourceRecycler = factory;
        memoryCache.setResourceRemovedListener((MemoryCache.ResourceRemovedListener)this);
    }

    public Engine(MemoryCache memoryCache, DiskCache.Factory factory, GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, boolean bl) {
        this(memoryCache, factory, glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, null, null, null, null, null, null, bl);
    }

    private EngineResource<?> getEngineResourceFromCache(Key object) {
        object = (object = this.cache.remove(object)) == null ? null : (object instanceof EngineResource ? (EngineResource)object : new EngineResource((Resource)object, true, true));
        return object;
    }

    private EngineResource<?> loadFromActiveResources(Key key, boolean bl) {
        if (!bl) {
            return null;
        }
        if ((key = this.activeResources.get(key)) == null) return key;
        key.acquire();
        return key;
    }

    private EngineResource<?> loadFromCache(Key key, boolean bl) {
        if (!bl) {
            return null;
        }
        EngineResource<?> engineResource = this.getEngineResourceFromCache(key);
        if (engineResource == null) return engineResource;
        engineResource.acquire();
        this.activeResources.activate(key, engineResource);
        return engineResource;
    }

    private static void logWithTimeAndKey(String string, long l, Key key) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(" in ");
        stringBuilder.append(LogTime.getElapsedMillis((long)l));
        stringBuilder.append("ms, key: ");
        stringBuilder.append(key);
        Log.v((String)TAG, (String)stringBuilder.toString());
    }

    public void clearDiskCache() {
        this.diskCacheProvider.getDiskCache().clear();
    }

    public <R> LoadStatus load(GlideContext glideContext, Object object, Key key, int n, int n2, Class<?> clazz, Class<R> clazz2, Priority priority, DiskCacheStrategy diskCacheStrategy, Map<Class<?>, Transformation<?>> map, boolean bl, boolean bl2, Options options, boolean bl3, boolean bl4, boolean bl5, boolean bl6, ResourceCallback resourceCallback) {
        Util.assertMainThread();
        long l = LogTime.getLogTime();
        EngineKey engineKey = this.keyFactory.buildKey(object, key, n, n2, map, clazz, clazz2, options);
        EngineResource<?> engineResource = this.loadFromActiveResources((Key)engineKey, bl3);
        if (engineResource != null) {
            resourceCallback.onResourceReady(engineResource, DataSource.MEMORY_CACHE);
            if (!Log.isLoggable((String)TAG, (int)2)) return null;
            Engine.logWithTimeAndKey("Loaded resource from active resources", l, (Key)engineKey);
            return null;
        }
        engineResource = this.loadFromCache((Key)engineKey, bl3);
        if (engineResource != null) {
            resourceCallback.onResourceReady(engineResource, DataSource.MEMORY_CACHE);
            if (!Log.isLoggable((String)TAG, (int)2)) return null;
            Engine.logWithTimeAndKey("Loaded resource from cache", l, (Key)engineKey);
            return null;
        }
        engineResource = this.jobs.get((Key)engineKey, bl6);
        if (engineResource != null) {
            engineResource.addCallback(resourceCallback);
            if (!Log.isLoggable((String)TAG, (int)2)) return new LoadStatus(resourceCallback, (EngineJob)engineResource);
            Engine.logWithTimeAndKey("Added to existing load", l, (Key)engineKey);
            return new LoadStatus(resourceCallback, (EngineJob)engineResource);
        }
        engineResource = this.engineJobFactory.build((Key)engineKey, bl3, bl4, bl5, bl6);
        glideContext = this.decodeJobFactory.build(glideContext, object, engineKey, key, n, n2, clazz, clazz2, priority, diskCacheStrategy, map, bl, bl2, bl6, options, (DecodeJob.Callback)engineResource);
        this.jobs.put((Key)engineKey, (EngineJob)engineResource);
        engineResource.addCallback(resourceCallback);
        engineResource.start((DecodeJob)glideContext);
        if (!Log.isLoggable((String)TAG, (int)2)) return new LoadStatus(resourceCallback, (EngineJob)engineResource);
        Engine.logWithTimeAndKey("Started new load", l, (Key)engineKey);
        return new LoadStatus(resourceCallback, (EngineJob)engineResource);
    }

    public void onEngineJobCancelled(EngineJob<?> engineJob, Key key) {
        Util.assertMainThread();
        this.jobs.removeIfCurrent(key, engineJob);
    }

    public void onEngineJobComplete(EngineJob<?> engineJob, Key key, EngineResource<?> engineResource) {
        Util.assertMainThread();
        if (engineResource != null) {
            engineResource.setResourceListener(key, (EngineResource.ResourceListener)this);
            if (engineResource.isCacheable()) {
                this.activeResources.activate(key, engineResource);
            }
        }
        this.jobs.removeIfCurrent(key, engineJob);
    }

    public void onResourceReleased(Key key, EngineResource<?> engineResource) {
        Util.assertMainThread();
        this.activeResources.deactivate(key);
        if (engineResource.isCacheable()) {
            this.cache.put(key, engineResource);
        } else {
            this.resourceRecycler.recycle(engineResource);
        }
    }

    public void onResourceRemoved(Resource<?> resource) {
        Util.assertMainThread();
        this.resourceRecycler.recycle(resource);
    }

    public void release(Resource<?> resource) {
        Util.assertMainThread();
        if (!(resource instanceof EngineResource)) throw new IllegalArgumentException("Cannot release anything but an EngineResource");
        ((EngineResource)resource).release();
    }

    public void shutdown() {
        this.engineJobFactory.shutdown();
        this.diskCacheProvider.clearDiskCacheIfCreated();
        this.activeResources.shutdown();
    }
}
