/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 */
package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;

private static interface LruBitmapPool.BitmapTracker {
    public void add(Bitmap var1);

    public void remove(Bitmap var1);
}
