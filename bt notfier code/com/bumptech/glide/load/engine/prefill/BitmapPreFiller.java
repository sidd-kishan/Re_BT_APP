/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap$Config
 *  android.os.Handler
 *  android.os.Looper
 *  com.bumptech.glide.load.DecodeFormat
 *  com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
 *  com.bumptech.glide.load.engine.cache.MemoryCache
 *  com.bumptech.glide.load.engine.prefill.BitmapPreFillRunner
 *  com.bumptech.glide.load.engine.prefill.PreFillQueue
 *  com.bumptech.glide.load.engine.prefill.PreFillType
 *  com.bumptech.glide.load.engine.prefill.PreFillType$Builder
 *  com.bumptech.glide.util.Util
 */
package com.bumptech.glide.load.engine.prefill;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.prefill.BitmapPreFillRunner;
import com.bumptech.glide.load.engine.prefill.PreFillQueue;
import com.bumptech.glide.load.engine.prefill.PreFillType;
import com.bumptech.glide.util.Util;
import java.util.HashMap;

public final class BitmapPreFiller {
    private final BitmapPool bitmapPool;
    private BitmapPreFillRunner current;
    private final DecodeFormat defaultFormat;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private final MemoryCache memoryCache;

    public BitmapPreFiller(MemoryCache memoryCache, BitmapPool bitmapPool, DecodeFormat decodeFormat) {
        this.memoryCache = memoryCache;
        this.bitmapPool = bitmapPool;
        this.defaultFormat = decodeFormat;
    }

    private static int getSizeInBytes(PreFillType preFillType) {
        return Util.getBitmapByteSize((int)preFillType.getWidth(), (int)preFillType.getHeight(), (Bitmap.Config)preFillType.getConfig());
    }

    PreFillQueue generateAllocationOrder(PreFillType ... preFillTypeArray) {
        int n;
        long l = this.memoryCache.getMaxSize();
        long l2 = this.memoryCache.getCurrentSize();
        long l3 = this.bitmapPool.getMaxSize();
        int n2 = preFillTypeArray.length;
        int n3 = 0;
        int n4 = 0;
        for (n = 0; n < n2; n4 += preFillTypeArray[n].getWeight(), ++n) {
        }
        float f = (float)(l - l2 + l3) / (float)n4;
        HashMap<PreFillType, Integer> hashMap = new HashMap<PreFillType, Integer>();
        n4 = preFillTypeArray.length;
        n = n3;
        while (n < n4) {
            PreFillType preFillType = preFillTypeArray[n];
            hashMap.put(preFillType, Math.round((float)preFillType.getWeight() * f) / BitmapPreFiller.getSizeInBytes(preFillType));
            ++n;
        }
        return new PreFillQueue(hashMap);
    }

    public void preFill(PreFillType.Builder ... preFillQueue) {
        BitmapPreFillRunner bitmapPreFillRunner = this.current;
        if (bitmapPreFillRunner != null) {
            bitmapPreFillRunner.cancel();
        }
        PreFillType[] preFillTypeArray = new PreFillType[((PreFillType.Builder[])preFillQueue).length];
        int n = 0;
        while (true) {
            if (n >= ((PreFillType.Builder[])preFillQueue).length) {
                preFillQueue = this.generateAllocationOrder(preFillTypeArray);
                preFillQueue = new BitmapPreFillRunner(this.bitmapPool, this.memoryCache, preFillQueue);
                this.current = preFillQueue;
                this.handler.post((Runnable)preFillQueue);
                return;
            }
            PreFillType.Builder builder = preFillQueue[n];
            if (builder.getConfig() == null) {
                bitmapPreFillRunner = this.defaultFormat != DecodeFormat.PREFER_ARGB_8888 && this.defaultFormat != DecodeFormat.PREFER_ARGB_8888_DISALLOW_HARDWARE ? Bitmap.Config.RGB_565 : Bitmap.Config.ARGB_8888;
                builder.setConfig((Bitmap.Config)bitmapPreFillRunner);
            }
            preFillTypeArray[n] = builder.build();
            ++n;
        }
    }
}
