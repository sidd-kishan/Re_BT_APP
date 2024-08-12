/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  com.bumptech.glide.load.engine.Initializable
 *  com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
 *  com.bumptech.glide.load.resource.drawable.DrawableResource
 *  com.bumptech.glide.util.Util
 */
package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.drawable.DrawableResource;
import com.bumptech.glide.util.Util;

public class BitmapDrawableResource
extends DrawableResource<BitmapDrawable>
implements Initializable {
    private final BitmapPool bitmapPool;

    public BitmapDrawableResource(BitmapDrawable bitmapDrawable, BitmapPool bitmapPool) {
        super((Drawable)bitmapDrawable);
        this.bitmapPool = bitmapPool;
    }

    public Class<BitmapDrawable> getResourceClass() {
        return BitmapDrawable.class;
    }

    public int getSize() {
        return Util.getBitmapByteSize((Bitmap)((BitmapDrawable)this.drawable).getBitmap());
    }

    public void initialize() {
        ((BitmapDrawable)this.drawable).getBitmap().prepareToDraw();
    }

    public void recycle() {
        this.bitmapPool.put(((BitmapDrawable)this.drawable).getBitmap());
    }
}
