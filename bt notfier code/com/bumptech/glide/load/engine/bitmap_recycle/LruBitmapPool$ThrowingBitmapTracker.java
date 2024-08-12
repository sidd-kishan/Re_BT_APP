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
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

private static class LruBitmapPool.ThrowingBitmapTracker
implements LruBitmapPool.BitmapTracker {
    private final Set<Bitmap> bitmaps = Collections.synchronizedSet(new HashSet());

    private LruBitmapPool.ThrowingBitmapTracker() {
    }

    public void add(Bitmap bitmap) {
        if (!this.bitmaps.contains(bitmap)) {
            this.bitmaps.add(bitmap);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Can't add already added bitmap: ");
        stringBuilder.append(bitmap);
        stringBuilder.append(" [");
        stringBuilder.append(bitmap.getWidth());
        stringBuilder.append("x");
        stringBuilder.append(bitmap.getHeight());
        stringBuilder.append("]");
        throw new IllegalStateException(stringBuilder.toString());
    }

    public void remove(Bitmap bitmap) {
        if (!this.bitmaps.contains(bitmap)) throw new IllegalStateException("Cannot remove bitmap not in tracker");
        this.bitmaps.remove(bitmap);
    }
}
