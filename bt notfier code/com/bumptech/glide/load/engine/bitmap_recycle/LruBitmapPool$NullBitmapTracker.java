/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool$BitmapTracker
 */
package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;

private static final class LruBitmapPool.NullBitmapTracker
implements LruBitmapPool.BitmapTracker {
    LruBitmapPool.NullBitmapTracker() {
    }

    public void add(Bitmap bitmap) {
    }

    public void remove(Bitmap bitmap) {
    }
}
