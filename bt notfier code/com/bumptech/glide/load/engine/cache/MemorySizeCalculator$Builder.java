/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.ActivityManager
 *  android.content.Context
 *  android.os.Build$VERSION
 *  com.bumptech.glide.load.engine.cache.MemorySizeCalculator
 *  com.bumptech.glide.load.engine.cache.MemorySizeCalculator$DisplayMetricsScreenDimensions
 *  com.bumptech.glide.load.engine.cache.MemorySizeCalculator$ScreenDimensions
 *  com.bumptech.glide.util.Preconditions
 */
package com.bumptech.glide.load.engine.cache;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
import com.bumptech.glide.util.Preconditions;

/*
 * Exception performing whole class analysis ignored.
 */
public static final class MemorySizeCalculator.Builder {
    static final int ARRAY_POOL_SIZE_BYTES = 0x400000;
    static final int BITMAP_POOL_TARGET_SCREENS;
    static final float LOW_MEMORY_MAX_SIZE_MULTIPLIER = 0.33f;
    static final float MAX_SIZE_MULTIPLIER = 0.4f;
    static final int MEMORY_CACHE_TARGET_SCREENS = 2;
    ActivityManager activityManager;
    int arrayPoolSizeBytes = 0x400000;
    float bitmapPoolScreens = BITMAP_POOL_TARGET_SCREENS;
    final Context context;
    float lowMemoryMaxSizeMultiplier = 0.33f;
    float maxSizeMultiplier = 0.4f;
    float memoryCacheScreens = 2.0f;
    MemorySizeCalculator.ScreenDimensions screenDimensions;

    static {
        int n = Build.VERSION.SDK_INT < 26 ? 4 : 1;
        BITMAP_POOL_TARGET_SCREENS = n;
    }

    public MemorySizeCalculator.Builder(Context context) {
        this.context = context;
        this.activityManager = (ActivityManager)context.getSystemService("activity");
        this.screenDimensions = new MemorySizeCalculator.DisplayMetricsScreenDimensions(context.getResources().getDisplayMetrics());
        if (Build.VERSION.SDK_INT < 26) return;
        if (!MemorySizeCalculator.isLowMemoryDevice((ActivityManager)this.activityManager)) return;
        this.bitmapPoolScreens = 0.0f;
    }

    public MemorySizeCalculator build() {
        return new MemorySizeCalculator(this);
    }

    MemorySizeCalculator.Builder setActivityManager(ActivityManager activityManager) {
        this.activityManager = activityManager;
        return this;
    }

    public MemorySizeCalculator.Builder setArrayPoolSize(int n) {
        this.arrayPoolSizeBytes = n;
        return this;
    }

    public MemorySizeCalculator.Builder setBitmapPoolScreens(float f) {
        boolean bl = f >= 0.0f;
        Preconditions.checkArgument((boolean)bl, (String)"Bitmap pool screens must be greater than or equal to 0");
        this.bitmapPoolScreens = f;
        return this;
    }

    public MemorySizeCalculator.Builder setLowMemoryMaxSizeMultiplier(float f) {
        boolean bl = f >= 0.0f && f <= 1.0f;
        Preconditions.checkArgument((boolean)bl, (String)"Low memory max size multiplier must be between 0 and 1");
        this.lowMemoryMaxSizeMultiplier = f;
        return this;
    }

    public MemorySizeCalculator.Builder setMaxSizeMultiplier(float f) {
        boolean bl = f >= 0.0f && f <= 1.0f;
        Preconditions.checkArgument((boolean)bl, (String)"Size multiplier must be between 0 and 1");
        this.maxSizeMultiplier = f;
        return this;
    }

    public MemorySizeCalculator.Builder setMemoryCacheScreens(float f) {
        boolean bl = this.bitmapPoolScreens >= 0.0f;
        Preconditions.checkArgument((boolean)bl, (String)"Memory cache screens must be greater than or equal to 0");
        this.memoryCacheScreens = f;
        return this;
    }

    MemorySizeCalculator.Builder setScreenDimensions(MemorySizeCalculator.ScreenDimensions screenDimensions) {
        this.screenDimensions = screenDimensions;
        return this;
    }
}
