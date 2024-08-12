/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  com.bumptech.glide.load.Transformation
 *  com.bumptech.glide.load.engine.Resource
 *  com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
 *  com.bumptech.glide.load.resource.bitmap.DrawableTransformation
 *  com.bumptech.glide.util.Preconditions
 */
package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.DrawableTransformation;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;

@Deprecated
public class BitmapDrawableTransformation
implements Transformation<BitmapDrawable> {
    private final Transformation<Drawable> wrapped;

    @Deprecated
    public BitmapDrawableTransformation(Context context, Transformation<Bitmap> transformation) {
        this(transformation);
    }

    @Deprecated
    public BitmapDrawableTransformation(Context context, BitmapPool bitmapPool, Transformation<Bitmap> transformation) {
        this(transformation);
    }

    public BitmapDrawableTransformation(Transformation<Bitmap> transformation) {
        this.wrapped = (Transformation)Preconditions.checkNotNull((Object)new DrawableTransformation(transformation, false));
    }

    private static Resource<BitmapDrawable> convertToBitmapDrawableResource(Resource<Drawable> resource) {
        if (resource.get() instanceof BitmapDrawable) {
            return resource;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Wrapped transformation unexpectedly returned a non BitmapDrawable resource: ");
        stringBuilder.append(resource.get());
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    private static Resource<Drawable> convertToDrawableResource(Resource<BitmapDrawable> resource) {
        return resource;
    }

    public boolean equals(Object object) {
        if (!(object instanceof BitmapDrawableTransformation)) return false;
        object = (BitmapDrawableTransformation)object;
        return this.wrapped.equals(((BitmapDrawableTransformation)object).wrapped);
    }

    public int hashCode() {
        return this.wrapped.hashCode();
    }

    public Resource<BitmapDrawable> transform(Context context, Resource<BitmapDrawable> resource, int n, int n2) {
        resource = BitmapDrawableTransformation.convertToDrawableResource(resource);
        return BitmapDrawableTransformation.convertToBitmapDrawableResource((Resource<Drawable>)this.wrapped.transform(context, resource, n, n2));
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        this.wrapped.updateDiskCacheKey(messageDigest);
    }
}
