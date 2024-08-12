/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.os.Build$VERSION
 *  android.util.Log
 *  com.bumptech.glide.load.engine.bitmap_recycle.AttributeStrategy
 *  com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
 *  com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool$BitmapTracker
 *  com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool$NullBitmapTracker
 *  com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
 *  com.bumptech.glide.load.engine.bitmap_recycle.SizeConfigStrategy
 */
package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import com.bumptech.glide.load.engine.bitmap_recycle.AttributeStrategy;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy;
import com.bumptech.glide.load.engine.bitmap_recycle.SizeConfigStrategy;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class LruBitmapPool
implements BitmapPool {
    private static final Bitmap.Config DEFAULT_CONFIG = Bitmap.Config.ARGB_8888;
    private static final String TAG = "LruBitmapPool";
    private final Set<Bitmap.Config> allowedConfigs;
    private long currentSize;
    private int evictions;
    private int hits;
    private final long initialMaxSize;
    private long maxSize;
    private int misses;
    private int puts;
    private final LruPoolStrategy strategy;
    private final BitmapTracker tracker;

    public LruBitmapPool(long l) {
        this(l, LruBitmapPool.getDefaultStrategy(), LruBitmapPool.getDefaultAllowedConfigs());
    }

    LruBitmapPool(long l, LruPoolStrategy lruPoolStrategy, Set<Bitmap.Config> set) {
        this.initialMaxSize = l;
        this.maxSize = l;
        this.strategy = lruPoolStrategy;
        this.allowedConfigs = set;
        this.tracker = new NullBitmapTracker();
    }

    public LruBitmapPool(long l, Set<Bitmap.Config> set) {
        this(l, LruBitmapPool.getDefaultStrategy(), set);
    }

    private static void assertNotHardwareConfig(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        if (config != Bitmap.Config.HARDWARE) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot create a mutable Bitmap with config: ");
        stringBuilder.append(config);
        stringBuilder.append(". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    private static Bitmap createBitmap(int n, int n2, Bitmap.Config config) {
        if (config != null) return Bitmap.createBitmap((int)n, (int)n2, (Bitmap.Config)config);
        config = DEFAULT_CONFIG;
        return Bitmap.createBitmap((int)n, (int)n2, (Bitmap.Config)config);
    }

    private void dump() {
        if (!Log.isLoggable((String)TAG, (int)2)) return;
        this.dumpUnchecked();
    }

    private void dumpUnchecked() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Hits=");
        stringBuilder.append(this.hits);
        stringBuilder.append(", misses=");
        stringBuilder.append(this.misses);
        stringBuilder.append(", puts=");
        stringBuilder.append(this.puts);
        stringBuilder.append(", evictions=");
        stringBuilder.append(this.evictions);
        stringBuilder.append(", currentSize=");
        stringBuilder.append(this.currentSize);
        stringBuilder.append(", maxSize=");
        stringBuilder.append(this.maxSize);
        stringBuilder.append("\nStrategy=");
        stringBuilder.append(this.strategy);
        Log.v((String)TAG, (String)stringBuilder.toString());
    }

    private void evict() {
        this.trimToSize(this.maxSize);
    }

    private static Set<Bitmap.Config> getDefaultAllowedConfigs() {
        HashSet<Bitmap.Config> hashSet = new HashSet<Bitmap.Config>(Arrays.asList(Bitmap.Config.values()));
        if (Build.VERSION.SDK_INT >= 19) {
            hashSet.add(null);
        }
        if (Build.VERSION.SDK_INT < 26) return Collections.unmodifiableSet(hashSet);
        hashSet.remove(Bitmap.Config.HARDWARE);
        return Collections.unmodifiableSet(hashSet);
    }

    private static LruPoolStrategy getDefaultStrategy() {
        Object object = Build.VERSION.SDK_INT >= 19 ? new SizeConfigStrategy() : new AttributeStrategy();
        return object;
    }

    private Bitmap getDirtyOrNull(int n, int n2, Bitmap.Config config) {
        synchronized (this) {
            LruBitmapPool.assertNotHardwareConfig(config);
            Object object = this.strategy;
            Bitmap.Config config2 = config != null ? config : DEFAULT_CONFIG;
            config2 = object.get(n, n2, config2);
            if (config2 == null) {
                if (Log.isLoggable((String)TAG, (int)3)) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("Missing bitmap=");
                    ((StringBuilder)object).append(this.strategy.logBitmap(n, n2, config));
                    Log.d((String)TAG, (String)((StringBuilder)object).toString());
                }
                ++this.misses;
            } else {
                ++this.hits;
                this.currentSize -= (long)this.strategy.getSize((Bitmap)config2);
                this.tracker.remove((Bitmap)config2);
                LruBitmapPool.normalize((Bitmap)config2);
            }
            if (Log.isLoggable((String)TAG, (int)2)) {
                object = new StringBuilder();
                ((StringBuilder)object).append("Get bitmap=");
                ((StringBuilder)object).append(this.strategy.logBitmap(n, n2, config));
                Log.v((String)TAG, (String)((StringBuilder)object).toString());
            }
            this.dump();
            return config2;
        }
    }

    private static void maybeSetPreMultiplied(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT < 19) return;
        bitmap.setPremultiplied(true);
    }

    private static void normalize(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
        LruBitmapPool.maybeSetPreMultiplied(bitmap);
    }

    private void trimToSize(long l) {
        synchronized (this) {
            try {
                while (this.currentSize > l) {
                    Bitmap bitmap = this.strategy.removeLast();
                    if (bitmap == null) {
                        if (Log.isLoggable((String)TAG, (int)5)) {
                            Log.w((String)TAG, (String)"Size mismatch, resetting");
                            this.dumpUnchecked();
                        }
                        this.currentSize = 0L;
                        return;
                    }
                    this.tracker.remove(bitmap);
                    this.currentSize -= (long)this.strategy.getSize(bitmap);
                    ++this.evictions;
                    if (Log.isLoggable((String)TAG, (int)3)) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Evicting bitmap=");
                        stringBuilder.append(this.strategy.logBitmap(bitmap));
                        Log.d((String)TAG, (String)stringBuilder.toString());
                    }
                    this.dump();
                    bitmap.recycle();
                }
                return;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    public void clearMemory() {
        if (Log.isLoggable((String)TAG, (int)3)) {
            Log.d((String)TAG, (String)"clearMemory");
        }
        this.trimToSize(0L);
    }

    public Bitmap get(int n, int n2, Bitmap.Config config) {
        Bitmap bitmap = this.getDirtyOrNull(n, n2, config);
        if (bitmap != null) {
            bitmap.eraseColor(0);
            config = bitmap;
        } else {
            config = LruBitmapPool.createBitmap(n, n2, config);
        }
        return config;
    }

    public Bitmap getDirty(int n, int n2, Bitmap.Config config) {
        Bitmap bitmap;
        Bitmap bitmap2 = bitmap = this.getDirtyOrNull(n, n2, config);
        if (bitmap != null) return bitmap2;
        bitmap2 = LruBitmapPool.createBitmap(n, n2, config);
        return bitmap2;
    }

    public long getMaxSize() {
        return this.maxSize;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void put(Bitmap var1_1) {
        synchronized (this) {
            if (var1_1 /* !! */  == null) ** GOTO lbl42
            try {
                if (var1_1 /* !! */ .isRecycled()) {
                    var1_1 /* !! */  = new IllegalStateException("Cannot pool recycled bitmap");
                    throw var1_1 /* !! */ ;
                }
                if (var1_1 /* !! */ .isMutable() && (long)this.strategy.getSize(var1_1 /* !! */ ) <= this.maxSize && this.allowedConfigs.contains(var1_1 /* !! */ .getConfig())) {
                    var2_3 = this.strategy.getSize(var1_1 /* !! */ );
                    this.strategy.put(var1_1 /* !! */ );
                    this.tracker.add(var1_1 /* !! */ );
                    ++this.puts;
                    this.currentSize += (long)var2_3;
                    if (Log.isLoggable((String)"LruBitmapPool", (int)2)) {
                        var3_4 = new StringBuilder();
                        var3_4.append("Put bitmap in pool=");
                        var3_4.append(this.strategy.logBitmap(var1_1 /* !! */ ));
                        Log.v((String)"LruBitmapPool", (String)var3_4.toString());
                    }
                    this.dump();
                    this.evict();
                    return;
                }
                if (Log.isLoggable((String)"LruBitmapPool", (int)2)) {
                    var3_5 = new StringBuilder();
                    var3_5.append("Reject bitmap from pool, bitmap: ");
                    var3_5.append(this.strategy.logBitmap(var1_1 /* !! */ ));
                    var3_5.append(", is mutable: ");
                    var3_5.append(var1_1 /* !! */ .isMutable());
                    var3_5.append(", is allowed config: ");
                    var3_5.append(this.allowedConfigs.contains(var1_1 /* !! */ .getConfig()));
                    Log.v((String)"LruBitmapPool", (String)var3_5.toString());
                }
                var1_1 /* !! */ .recycle();
                return;
lbl42:
                // 1 sources

                var1_1 /* !! */  = new NullPointerException("Bitmap must not be null");
                throw var1_1 /* !! */ ;
            }
            catch (Throwable var1_2) {}
            throw var1_2;
        }
    }

    public void setSizeMultiplier(float f) {
        synchronized (this) {
            this.maxSize = Math.round((float)this.initialMaxSize * f);
            this.evict();
            return;
        }
    }

    public void trimMemory(int n) {
        if (Log.isLoggable((String)TAG, (int)3)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("trimMemory, level=");
            stringBuilder.append(n);
            Log.d((String)TAG, (String)stringBuilder.toString());
        }
        if (n >= 40) {
            this.clearMemory();
        } else {
            if (n < 20) return;
            this.trimToSize(this.maxSize / 2L);
        }
    }
}
