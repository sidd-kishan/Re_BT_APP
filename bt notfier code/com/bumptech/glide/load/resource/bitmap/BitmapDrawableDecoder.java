/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.drawable.BitmapDrawable
 *  com.bumptech.glide.load.Options
 *  com.bumptech.glide.load.ResourceDecoder
 *  com.bumptech.glide.load.engine.Resource
 *  com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
 *  com.bumptech.glide.load.resource.bitmap.LazyBitmapDrawableResource
 *  com.bumptech.glide.util.Preconditions
 */
package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.LazyBitmapDrawableResource;
import com.bumptech.glide.util.Preconditions;
import java.io.IOException;

public class BitmapDrawableDecoder<DataType>
implements ResourceDecoder<DataType, BitmapDrawable> {
    private final ResourceDecoder<DataType, Bitmap> decoder;
    private final Resources resources;

    public BitmapDrawableDecoder(Context context, ResourceDecoder<DataType, Bitmap> resourceDecoder) {
        this(context.getResources(), resourceDecoder);
    }

    public BitmapDrawableDecoder(Resources resources, ResourceDecoder<DataType, Bitmap> resourceDecoder) {
        this.resources = (Resources)Preconditions.checkNotNull((Object)resources);
        this.decoder = (ResourceDecoder)Preconditions.checkNotNull(resourceDecoder);
    }

    @Deprecated
    public BitmapDrawableDecoder(Resources resources, BitmapPool bitmapPool, ResourceDecoder<DataType, Bitmap> resourceDecoder) {
        this(resources, resourceDecoder);
    }

    public Resource<BitmapDrawable> decode(DataType object, int n, int n2, Options options) throws IOException {
        object = this.decoder.decode(object, n, n2, options);
        return LazyBitmapDrawableResource.obtain((Resources)this.resources, object);
    }

    public boolean handles(DataType DataType, Options options) throws IOException {
        return this.decoder.handles(DataType, options);
    }
}
