/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.drawable.BitmapDrawable
 *  com.bumptech.glide.Glide
 *  com.bumptech.glide.load.engine.Initializable
 *  com.bumptech.glide.load.engine.Resource
 *  com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
 *  com.bumptech.glide.load.resource.bitmap.BitmapResource
 *  com.bumptech.glide.util.Preconditions
 */
package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.util.Preconditions;

public final class LazyBitmapDrawableResource
implements Resource<BitmapDrawable>,
Initializable {
    private final Resource<Bitmap> bitmapResource;
    private final Resources resources;

    private LazyBitmapDrawableResource(Resources resources, Resource<Bitmap> resource) {
        this.resources = (Resources)Preconditions.checkNotNull((Object)resources);
        this.bitmapResource = (Resource)Preconditions.checkNotNull(resource);
    }

    public static Resource<BitmapDrawable> obtain(Resources resources, Resource<Bitmap> resource) {
        if (resource != null) return new LazyBitmapDrawableResource(resources, resource);
        return null;
    }

    @Deprecated
    public static LazyBitmapDrawableResource obtain(Context context, Bitmap bitmap) {
        return (LazyBitmapDrawableResource)LazyBitmapDrawableResource.obtain(context.getResources(), (Resource<Bitmap>)BitmapResource.obtain((Bitmap)bitmap, (BitmapPool)Glide.get((Context)context).getBitmapPool()));
    }

    @Deprecated
    public static LazyBitmapDrawableResource obtain(Resources resources, BitmapPool bitmapPool, Bitmap bitmap) {
        return (LazyBitmapDrawableResource)LazyBitmapDrawableResource.obtain(resources, (Resource<Bitmap>)BitmapResource.obtain((Bitmap)bitmap, (BitmapPool)bitmapPool));
    }

    public BitmapDrawable get() {
        return new BitmapDrawable(this.resources, (Bitmap)this.bitmapResource.get());
    }

    public Class<BitmapDrawable> getResourceClass() {
        return BitmapDrawable.class;
    }

    public int getSize() {
        return this.bitmapResource.getSize();
    }

    public void initialize() {
        Resource<Bitmap> resource = this.bitmapResource;
        if (!(resource instanceof Initializable)) return;
        ((Initializable)resource).initialize();
    }

    public void recycle() {
        this.bitmapResource.recycle();
    }
}
