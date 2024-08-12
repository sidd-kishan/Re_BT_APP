/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.drawable.BitmapDrawable
 *  com.bumptech.glide.load.Options
 *  com.bumptech.glide.load.engine.Resource
 *  com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
 *  com.bumptech.glide.load.resource.bitmap.LazyBitmapDrawableResource
 *  com.bumptech.glide.load.resource.transcode.ResourceTranscoder
 *  com.bumptech.glide.util.Preconditions
 */
package com.bumptech.glide.load.resource.transcode;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.LazyBitmapDrawableResource;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.util.Preconditions;

public class BitmapDrawableTranscoder
implements ResourceTranscoder<Bitmap, BitmapDrawable> {
    private final Resources resources;

    public BitmapDrawableTranscoder(Context context) {
        this(context.getResources());
    }

    public BitmapDrawableTranscoder(Resources resources) {
        this.resources = (Resources)Preconditions.checkNotNull((Object)resources);
    }

    @Deprecated
    public BitmapDrawableTranscoder(Resources resources, BitmapPool bitmapPool) {
        this(resources);
    }

    public Resource<BitmapDrawable> transcode(Resource<Bitmap> resource, Options options) {
        return LazyBitmapDrawableResource.obtain((Resources)this.resources, resource);
    }
}
