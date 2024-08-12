/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Looper
 *  androidx.core.util.Pools$Pool
 *  com.bumptech.glide.load.DataSource
 *  com.bumptech.glide.load.Key
 *  com.bumptech.glide.load.engine.DecodeJob
 *  com.bumptech.glide.load.engine.DecodeJob$Callback
 *  com.bumptech.glide.load.engine.EngineJob$EngineResourceFactory
 *  com.bumptech.glide.load.engine.EngineJob$MainThreadCallback
 *  com.bumptech.glide.load.engine.EngineJobListener
 *  com.bumptech.glide.load.engine.EngineResource
 *  com.bumptech.glide.load.engine.GlideException
 *  com.bumptech.glide.load.engine.Resource
 *  com.bumptech.glide.load.engine.executor.GlideExecutor
 *  com.bumptech.glide.request.ResourceCallback
 *  com.bumptech.glide.util.Util
 *  com.bumptech.glide.util.pool.FactoryPools$Poolable
 *  com.bumptech.glide.util.pool.StateVerifier
 */
package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import androidx.core.util.Pools;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.EngineJob;
import com.bumptech.glide.load.engine.EngineJobListener;
import com.bumptech.glide.load.engine.EngineResource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.request.ResourceCallback;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class EngineJob<R>
implements DecodeJob.Callback<R>,
FactoryPools.Poolable {
    private static final EngineResourceFactory DEFAULT_FACTORY = new EngineResourceFactory();
    private static final Handler MAIN_THREAD_HANDLER = new Handler(Looper.getMainLooper(), (Handler.Callback)new MainThreadCallback());
    private static final int MSG_CANCELLED = 3;
    private static final int MSG_COMPLETE = 1;
    private static final int MSG_EXCEPTION = 2;
    private final GlideExecutor animationExecutor;
    private final List<ResourceCallback> cbs = new ArrayList<ResourceCallback>(2);
    private DataSource dataSource;
    private DecodeJob<R> decodeJob;
    private final GlideExecutor diskCacheExecutor;
    private EngineResource<?> engineResource;
    private final EngineResourceFactory engineResourceFactory;
    private GlideException exception;
    private boolean hasLoadFailed;
    private boolean hasResource;
    private List<ResourceCallback> ignoredCallbacks;
    private boolean isCacheable;
    private volatile boolean isCancelled;
    private Key key;
    private final EngineJobListener listener;
    private boolean onlyRetrieveFromCache;
    private final Pools.Pool<EngineJob<?>> pool;
    private Resource<?> resource;
    private final GlideExecutor sourceExecutor;
    private final GlideExecutor sourceUnlimitedExecutor;
    private final StateVerifier stateVerifier = StateVerifier.newInstance();
    private boolean useAnimationPool;
    private boolean useUnlimitedSourceGeneratorPool;

    EngineJob(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, EngineJobListener engineJobListener, Pools.Pool<EngineJob<?>> pool) {
        this(glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, engineJobListener, pool, DEFAULT_FACTORY);
    }

    EngineJob(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, EngineJobListener engineJobListener, Pools.Pool<EngineJob<?>> pool, EngineResourceFactory engineResourceFactory) {
        this.diskCacheExecutor = glideExecutor;
        this.sourceExecutor = glideExecutor2;
        this.sourceUnlimitedExecutor = glideExecutor3;
        this.animationExecutor = glideExecutor4;
        this.listener = engineJobListener;
        this.pool = pool;
        this.engineResourceFactory = engineResourceFactory;
    }

    private void addIgnoredCallback(ResourceCallback resourceCallback) {
        if (this.ignoredCallbacks == null) {
            this.ignoredCallbacks = new ArrayList<ResourceCallback>(2);
        }
        if (this.ignoredCallbacks.contains(resourceCallback)) return;
        this.ignoredCallbacks.add(resourceCallback);
    }

    private GlideExecutor getActiveSourceExecutor() {
        GlideExecutor glideExecutor = this.useUnlimitedSourceGeneratorPool ? this.sourceUnlimitedExecutor : (this.useAnimationPool ? this.animationExecutor : this.sourceExecutor);
        return glideExecutor;
    }

    private boolean isInIgnoredCallbacks(ResourceCallback resourceCallback) {
        List<ResourceCallback> list = this.ignoredCallbacks;
        boolean bl = list != null && list.contains(resourceCallback);
        return bl;
    }

    private void release(boolean bl) {
        Util.assertMainThread();
        this.cbs.clear();
        this.key = null;
        this.engineResource = null;
        this.resource = null;
        List<ResourceCallback> list = this.ignoredCallbacks;
        if (list != null) {
            list.clear();
        }
        this.hasLoadFailed = false;
        this.isCancelled = false;
        this.hasResource = false;
        this.decodeJob.release(bl);
        this.decodeJob = null;
        this.exception = null;
        this.dataSource = null;
        this.pool.release((Object)this);
    }

    void addCallback(ResourceCallback resourceCallback) {
        Util.assertMainThread();
        this.stateVerifier.throwIfRecycled();
        if (this.hasResource) {
            resourceCallback.onResourceReady(this.engineResource, this.dataSource);
        } else if (this.hasLoadFailed) {
            resourceCallback.onLoadFailed(this.exception);
        } else {
            this.cbs.add(resourceCallback);
        }
    }

    void cancel() {
        if (this.hasLoadFailed) return;
        if (this.hasResource) return;
        if (this.isCancelled) return;
        this.isCancelled = true;
        this.decodeJob.cancel();
        this.listener.onEngineJobCancelled(this, this.key);
    }

    public StateVerifier getVerifier() {
        return this.stateVerifier;
    }

    void handleCancelledOnMainThread() {
        this.stateVerifier.throwIfRecycled();
        if (!this.isCancelled) throw new IllegalStateException("Not cancelled");
        this.listener.onEngineJobCancelled(this, this.key);
        this.release(false);
    }

    void handleExceptionOnMainThread() {
        this.stateVerifier.throwIfRecycled();
        if (this.isCancelled) {
            this.release(false);
            return;
        }
        if (this.cbs.isEmpty()) {
            IllegalStateException illegalStateException = new IllegalStateException("Received an exception without any callbacks to notify");
            throw illegalStateException;
        }
        if (this.hasLoadFailed) throw new IllegalStateException("Already failed once");
        this.hasLoadFailed = true;
        this.listener.onEngineJobComplete(this, this.key, null);
        Iterator<ResourceCallback> iterator = this.cbs.iterator();
        while (true) {
            if (!iterator.hasNext()) {
                this.release(false);
                return;
            }
            ResourceCallback resourceCallback = iterator.next();
            if (this.isInIgnoredCallbacks(resourceCallback)) continue;
            resourceCallback.onLoadFailed(this.exception);
        }
    }

    void handleResultOnMainThread() {
        EngineResource engineResource;
        this.stateVerifier.throwIfRecycled();
        if (this.isCancelled) {
            this.resource.recycle();
            this.release(false);
            return;
        }
        if (this.cbs.isEmpty()) {
            IllegalStateException illegalStateException = new IllegalStateException("Received a resource without any callbacks to notify");
            throw illegalStateException;
        }
        if (this.hasResource) throw new IllegalStateException("Already have resource");
        this.engineResource = engineResource = this.engineResourceFactory.build(this.resource, this.isCacheable);
        this.hasResource = true;
        engineResource.acquire();
        this.listener.onEngineJobComplete(this, this.key, this.engineResource);
        int n = this.cbs.size();
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                this.engineResource.release();
                this.release(false);
                return;
            }
            engineResource = this.cbs.get(n2);
            if (!this.isInIgnoredCallbacks((ResourceCallback)engineResource)) {
                this.engineResource.acquire();
                engineResource.onResourceReady(this.engineResource, this.dataSource);
            }
            ++n2;
        }
    }

    EngineJob<R> init(Key key, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.key = key;
        this.isCacheable = bl;
        this.useUnlimitedSourceGeneratorPool = bl2;
        this.useAnimationPool = bl3;
        this.onlyRetrieveFromCache = bl4;
        return this;
    }

    boolean isCancelled() {
        return this.isCancelled;
    }

    public void onLoadFailed(GlideException glideException) {
        this.exception = glideException;
        MAIN_THREAD_HANDLER.obtainMessage(2, (Object)this).sendToTarget();
    }

    public void onResourceReady(Resource<R> resource, DataSource dataSource) {
        this.resource = resource;
        this.dataSource = dataSource;
        MAIN_THREAD_HANDLER.obtainMessage(1, (Object)this).sendToTarget();
    }

    boolean onlyRetrieveFromCache() {
        return this.onlyRetrieveFromCache;
    }

    void removeCallback(ResourceCallback resourceCallback) {
        Util.assertMainThread();
        this.stateVerifier.throwIfRecycled();
        if (!this.hasResource && !this.hasLoadFailed) {
            this.cbs.remove(resourceCallback);
            if (!this.cbs.isEmpty()) return;
            this.cancel();
        } else {
            this.addIgnoredCallback(resourceCallback);
        }
    }

    public void reschedule(DecodeJob<?> decodeJob) {
        this.getActiveSourceExecutor().execute(decodeJob);
    }

    public void start(DecodeJob<R> decodeJob) {
        this.decodeJob = decodeJob;
        GlideExecutor glideExecutor = decodeJob.willDecodeFromCache() ? this.diskCacheExecutor : this.getActiveSourceExecutor();
        glideExecutor.execute(decodeJob);
    }
}
