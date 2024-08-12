/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  com.bumptech.glide.Glide
 *  com.bumptech.glide.load.Transformation
 *  com.bumptech.glide.load.engine.Resource
 *  com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
 *  com.bumptech.glide.load.resource.bitmap.BitmapResource
 *  com.bumptech.glide.load.resource.gif.GifDrawable
 *  com.bumptech.glide.util.Preconditions
 */
package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;

public class GifDrawableTransformation
implements Transformation<GifDrawable> {
    private final Transformation<Bitmap> wrapped;

    @Deprecated
    public GifDrawableTransformation(Context context, Transformation<Bitmap> transformation) {
        this(transformation);
    }

    public GifDrawableTransformation(Transformation<Bitmap> transformation) {
        this.wrapped = (Transformation)Preconditions.checkNotNull(transformation);
    }

    @Deprecated
    public GifDrawableTransformation(Transformation<Bitmap> transformation, BitmapPool bitmapPool) {
        this(transformation);
    }

    public boolean equals(Object object) {
        if (!(object instanceof GifDrawableTransformation)) return false;
        object = (GifDrawableTransformation)object;
        return this.wrapped.equals(((GifDrawableTransformation)object).wrapped);
    }

    public int hashCode() {
        return this.wrapped.hashCode();
    }

    public Resource<GifDrawable> transform(Context context, Resource<GifDrawable> resource, int n, int n2) {
        GifDrawable gifDrawable = (GifDrawable)resource.get();
        BitmapPool bitmapPool = Glide.get((Context)context).getBitmapPool();
        bitmapPool = new BitmapResource(gifDrawable.getFirstFrame(), bitmapPool);
        if (!bitmapPool.equals(context = this.wrapped.transform(context, (Resource)bitmapPool, n, n2))) {
            bitmapPool.recycle();
        }
        context = (Bitmap)context.get();
        gifDrawable.setFrameTransformation(this.wrapped, (Bitmap)context);
        return resource;
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        this.wrapped.updateDiskCacheKey(messageDigest);
    }
}
