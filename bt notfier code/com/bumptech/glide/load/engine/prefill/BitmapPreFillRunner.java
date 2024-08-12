/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.os.Handler
 *  android.os.Looper
 *  android.util.Log
 *  com.bumptech.glide.load.Key
 *  com.bumptech.glide.load.engine.Resource
 *  com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
 *  com.bumptech.glide.load.engine.cache.MemoryCache
 *  com.bumptech.glide.load.engine.prefill.BitmapPreFillRunner$Clock
 *  com.bumptech.glide.load.engine.prefill.BitmapPreFillRunner$UniqueKey
 *  com.bumptech.glide.load.engine.prefill.PreFillQueue
 *  com.bumptech.glide.load.engine.prefill.PreFillType
 *  com.bumptech.glide.load.resource.bitmap.BitmapResource
 *  com.bumptech.glide.util.Util
 */
package com.bumptech.glide.load.engine.prefill;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.prefill.BitmapPreFillRunner;
import com.bumptech.glide.load.engine.prefill.PreFillQueue;
import com.bumptech.glide.load.engine.prefill.PreFillType;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.util.Util;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

final class BitmapPreFillRunner
implements Runnable {
    static final int BACKOFF_RATIO = 4;
    private static final Clock DEFAULT_CLOCK = new Clock();
    static final long INITIAL_BACKOFF_MS = 40L;
    static final long MAX_BACKOFF_MS = TimeUnit.SECONDS.toMillis(1L);
    static final long MAX_DURATION_MS = 32L;
    static final String TAG = "PreFillRunner";
    private final BitmapPool bitmapPool;
    private final Clock clock;
    private long currentDelay = 40L;
    private final Handler handler;
    private boolean isCancelled;
    private final MemoryCache memoryCache;
    private final Set<PreFillType> seenTypes = new HashSet<PreFillType>();
    private final PreFillQueue toPrefill;

    public BitmapPreFillRunner(BitmapPool bitmapPool, MemoryCache memoryCache, PreFillQueue preFillQueue) {
        this(bitmapPool, memoryCache, preFillQueue, DEFAULT_CLOCK, new Handler(Looper.getMainLooper()));
    }

    BitmapPreFillRunner(BitmapPool bitmapPool, MemoryCache memoryCache, PreFillQueue preFillQueue, Clock clock, Handler handler) {
        this.bitmapPool = bitmapPool;
        this.memoryCache = memoryCache;
        this.toPrefill = preFillQueue;
        this.clock = clock;
        this.handler = handler;
    }

    private long getFreeMemoryCacheBytes() {
        return this.memoryCache.getMaxSize() - this.memoryCache.getCurrentSize();
    }

    private long getNextDelay() {
        long l = this.currentDelay;
        this.currentDelay = Math.min(4L * l, MAX_BACKOFF_MS);
        return l;
    }

    private boolean isGcDetected(long l) {
        boolean bl = this.clock.now() - l >= 32L;
        return bl;
    }

    boolean allocate() {
        long l = this.clock.now();
        while (!this.toPrefill.isEmpty() && !this.isGcDetected(l)) {
            Object object;
            PreFillType preFillType = this.toPrefill.remove();
            if (!this.seenTypes.contains(preFillType)) {
                this.seenTypes.add(preFillType);
                object = this.bitmapPool.getDirty(preFillType.getWidth(), preFillType.getHeight(), preFillType.getConfig());
            } else {
                object = Bitmap.createBitmap((int)preFillType.getWidth(), (int)preFillType.getHeight(), (Bitmap.Config)preFillType.getConfig());
            }
            int n = Util.getBitmapByteSize((Bitmap)object);
            if (this.getFreeMemoryCacheBytes() >= (long)n) {
                UniqueKey uniqueKey = new UniqueKey();
                this.memoryCache.put((Key)uniqueKey, (Resource)BitmapResource.obtain((Bitmap)object, (BitmapPool)this.bitmapPool));
            } else {
                this.bitmapPool.put((Bitmap)object);
            }
            if (!Log.isLoggable((String)TAG, (int)3)) continue;
            object = new StringBuilder();
            ((StringBuilder)object).append("allocated [");
            ((StringBuilder)object).append(preFillType.getWidth());
            ((StringBuilder)object).append("x");
            ((StringBuilder)object).append(preFillType.getHeight());
            ((StringBuilder)object).append("] ");
            ((StringBuilder)object).append(preFillType.getConfig());
            ((StringBuilder)object).append(" size: ");
            ((StringBuilder)object).append(n);
            Log.d((String)TAG, (String)((StringBuilder)object).toString());
        }
        boolean bl = !this.isCancelled && !this.toPrefill.isEmpty();
        return bl;
    }

    public void cancel() {
        this.isCancelled = true;
    }

    @Override
    public void run() {
        if (!this.allocate()) return;
        this.handler.postDelayed((Runnable)this, this.getNextDelay());
    }
}
