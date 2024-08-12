/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  com.bumptech.glide.load.engine.Initializable
 *  com.bumptech.glide.load.engine.Resource
 *  com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
 *  com.bumptech.glide.util.Preconditions
 *  com.bumptech.glide.util.Util
 */
package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;

public class BitmapResource
implements Resource<Bitmap>,
Initializable {
    private final Bitmap bitmap;
    private final BitmapPool bitmapPool;

    public BitmapResource(Bitmap bitmap, BitmapPool bitmapPool) {
        this.bitmap = (Bitmap)Preconditions.checkNotNull((Object)bitmap, (String)"Bitmap must not be null");
        this.bitmapPool = (BitmapPool)Preconditions.checkNotNull((Object)bitmapPool, (String)"BitmapPool must not be null");
    }

    public static BitmapResource obtain(Bitmap bitmap, BitmapPool bitmapPool) {
        if (bitmap != null) return new BitmapResource(bitmap, bitmapPool);
        return null;
    }

    public Bitmap get() {
        return this.bitmap;
    }

    public Class<Bitmap> getResourceClass() {
        return Bitmap.class;
    }

    public int getSize() {
        return Util.getBitmapByteSize((Bitmap)this.bitmap);
    }

    public void initialize() {
        this.bitmap.prepareToDraw();
    }

    public void recycle() {
        this.bitmapPool.put(this.bitmap);
    }
}
