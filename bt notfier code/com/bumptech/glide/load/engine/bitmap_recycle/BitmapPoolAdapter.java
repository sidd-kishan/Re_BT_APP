/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
 */
package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;

public class BitmapPoolAdapter
implements BitmapPool {
    public void clearMemory() {
    }

    public Bitmap get(int n, int n2, Bitmap.Config config) {
        return Bitmap.createBitmap((int)n, (int)n2, (Bitmap.Config)config);
    }

    public Bitmap getDirty(int n, int n2, Bitmap.Config config) {
        return this.get(n, n2, config);
    }

    public long getMaxSize() {
        return 0L;
    }

    public void put(Bitmap bitmap) {
        bitmap.recycle();
    }

    public void setSizeMultiplier(float f) {
    }

    public void trimMemory(int n) {
    }
}
