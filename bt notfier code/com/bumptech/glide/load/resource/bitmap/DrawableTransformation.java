/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  com.bumptech.glide.Glide
 *  com.bumptech.glide.load.Transformation
 *  com.bumptech.glide.load.engine.Resource
 *  com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
 *  com.bumptech.glide.load.resource.bitmap.DrawableToBitmapConverter
 *  com.bumptech.glide.load.resource.bitmap.LazyBitmapDrawableResource
 */
package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.DrawableToBitmapConverter;
import com.bumptech.glide.load.resource.bitmap.LazyBitmapDrawableResource;
import java.security.MessageDigest;

public class DrawableTransformation
implements Transformation<Drawable> {
    private final boolean isRequired;
    private final Transformation<Bitmap> wrapped;

    public DrawableTransformation(Transformation<Bitmap> transformation, boolean bl) {
        this.wrapped = transformation;
        this.isRequired = bl;
    }

    private Resource<Drawable> newDrawableResource(Context context, Resource<Bitmap> resource) {
        return LazyBitmapDrawableResource.obtain((Resources)context.getResources(), resource);
    }

    public Transformation<BitmapDrawable> asBitmapDrawable() {
        return this;
    }

    public boolean equals(Object object) {
        if (!(object instanceof DrawableTransformation)) return false;
        object = (DrawableTransformation)object;
        return this.wrapped.equals(((DrawableTransformation)object).wrapped);
    }

    public int hashCode() {
        return this.wrapped.hashCode();
    }

    public Resource<Drawable> transform(Context object, Resource<Drawable> resource, int n, int n2) {
        BitmapPool bitmapPool = Glide.get((Context)object).getBitmapPool();
        Drawable drawable = (Drawable)resource.get();
        if ((bitmapPool = DrawableToBitmapConverter.convert((BitmapPool)bitmapPool, (Drawable)drawable, (int)n, (int)n2)) != null) {
            drawable = this.wrapped.transform((Context)object, (Resource)bitmapPool, n, n2);
            if (!drawable.equals(bitmapPool)) return this.newDrawableResource((Context)object, (Resource<Bitmap>)drawable);
            drawable.recycle();
            return resource;
        }
        if (!this.isRequired) {
            return resource;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Unable to convert ");
        ((StringBuilder)object).append(drawable);
        ((StringBuilder)object).append(" to a Bitmap");
        throw new IllegalArgumentException(((StringBuilder)object).toString());
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        this.wrapped.updateDiskCacheKey(messageDigest);
    }
}
