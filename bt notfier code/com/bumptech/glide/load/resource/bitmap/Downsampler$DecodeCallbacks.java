/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
 */
package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.io.IOException;

public static interface Downsampler.DecodeCallbacks {
    public void onDecodeComplete(BitmapPool var1, Bitmap var2) throws IOException;

    public void onObtainBounds();
}
