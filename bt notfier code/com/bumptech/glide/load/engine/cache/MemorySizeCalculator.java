/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.ActivityManager
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.text.format.Formatter
 *  android.util.Log
 *  com.bumptech.glide.load.engine.cache.MemorySizeCalculator$Builder
 */
package com.bumptech.glide.load.engine.cache;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.Log;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;

public final class MemorySizeCalculator {
    static final int BYTES_PER_ARGB_8888_PIXEL = 4;
    private static final int LOW_MEMORY_BYTE_ARRAY_POOL_DIVISOR = 2;
    private static final String TAG = "MemorySizeCalculator";
    private final int arrayPoolSize;
    private final int bitmapPoolSize;
    private final Context context;
    private final int memoryCacheSize;

    MemorySizeCalculator(Builder builder) {
        this.context = builder.context;
        int n = MemorySizeCalculator.isLowMemoryDevice(builder.activityManager) ? builder.arrayPoolSizeBytes / 2 : builder.arrayPoolSizeBytes;
        this.arrayPoolSize = n;
        int n2 = MemorySizeCalculator.getMaxSize(builder.activityManager, builder.maxSizeMultiplier, builder.lowMemoryMaxSizeMultiplier);
        float f = builder.screenDimensions.getWidthPixels() * builder.screenDimensions.getHeightPixels() * 4;
        n = Math.round(builder.bitmapPoolScreens * f);
        int n3 = Math.round(f * builder.memoryCacheScreens);
        int n4 = n2 - this.arrayPoolSize;
        int n5 = n3 + n;
        if (n5 <= n4) {
            this.memoryCacheSize = n3;
            this.bitmapPoolSize = n;
        } else {
            f = (float)n4 / (builder.bitmapPoolScreens + builder.memoryCacheScreens);
            this.memoryCacheSize = Math.round(builder.memoryCacheScreens * f);
            this.bitmapPoolSize = Math.round(f * builder.bitmapPoolScreens);
        }
        if (!Log.isLoggable((String)TAG, (int)3)) return;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Calculation complete, Calculated memory cache size: ");
        stringBuilder.append(this.toMb(this.memoryCacheSize));
        stringBuilder.append(", pool size: ");
        stringBuilder.append(this.toMb(this.bitmapPoolSize));
        stringBuilder.append(", byte array size: ");
        stringBuilder.append(this.toMb(this.arrayPoolSize));
        stringBuilder.append(", memory class limited? ");
        boolean bl = n5 > n2;
        stringBuilder.append(bl);
        stringBuilder.append(", max size: ");
        stringBuilder.append(this.toMb(n2));
        stringBuilder.append(", memoryClass: ");
        stringBuilder.append(builder.activityManager.getMemoryClass());
        stringBuilder.append(", isLowMemoryDevice: ");
        stringBuilder.append(MemorySizeCalculator.isLowMemoryDevice(builder.activityManager));
        Log.d((String)TAG, (String)stringBuilder.toString());
    }

    private static int getMaxSize(ActivityManager activityManager, float f, float f2) {
        int n = activityManager.getMemoryClass();
        boolean bl = MemorySizeCalculator.isLowMemoryDevice(activityManager);
        float f3 = n * 1024 * 1024;
        if (!bl) return Math.round(f3 * f);
        f = f2;
        return Math.round(f3 * f);
    }

    static boolean isLowMemoryDevice(ActivityManager activityManager) {
        if (Build.VERSION.SDK_INT < 19) return true;
        return activityManager.isLowRamDevice();
    }

    private String toMb(int n) {
        return Formatter.formatFileSize((Context)this.context, (long)n);
    }

    public int getArrayPoolSizeInBytes() {
        return this.arrayPoolSize;
    }

    public int getBitmapPoolSize() {
        return this.bitmapPoolSize;
    }

    public int getMemoryCacheSize() {
        return this.memoryCacheSize;
    }
}
