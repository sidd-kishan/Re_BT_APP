/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.drawable.BitmapDrawable
 *  com.bumptech.glide.load.EncodeStrategy
 *  com.bumptech.glide.load.Options
 *  com.bumptech.glide.load.ResourceEncoder
 *  com.bumptech.glide.load.engine.Resource
 *  com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
 *  com.bumptech.glide.load.resource.bitmap.BitmapResource
 */
package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import java.io.File;

public class BitmapDrawableEncoder
implements ResourceEncoder<BitmapDrawable> {
    private final BitmapPool bitmapPool;
    private final ResourceEncoder<Bitmap> encoder;

    public BitmapDrawableEncoder(BitmapPool bitmapPool, ResourceEncoder<Bitmap> resourceEncoder) {
        this.bitmapPool = bitmapPool;
        this.encoder = resourceEncoder;
    }

    public boolean encode(Resource<BitmapDrawable> resource, File file, Options options) {
        return this.encoder.encode((Object)new BitmapResource(((BitmapDrawable)resource.get()).getBitmap(), this.bitmapPool), file, options);
    }

    public EncodeStrategy getEncodeStrategy(Options options) {
        return this.encoder.getEncodeStrategy(options);
    }
}
