/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  com.bumptech.glide.load.Options
 *  com.bumptech.glide.load.ResourceDecoder
 *  com.bumptech.glide.load.engine.Resource
 *  com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
 *  com.bumptech.glide.load.resource.bitmap.DrawableToBitmapConverter
 *  com.bumptech.glide.load.resource.drawable.ResourceDrawableDecoder
 */
package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.DrawableToBitmapConverter;
import com.bumptech.glide.load.resource.drawable.ResourceDrawableDecoder;

public class ResourceBitmapDecoder
implements ResourceDecoder<Uri, Bitmap> {
    private final BitmapPool bitmapPool;
    private final ResourceDrawableDecoder drawableDecoder;

    public ResourceBitmapDecoder(ResourceDrawableDecoder resourceDrawableDecoder, BitmapPool bitmapPool) {
        this.drawableDecoder = resourceDrawableDecoder;
        this.bitmapPool = bitmapPool;
    }

    public Resource<Bitmap> decode(Uri uri, int n, int n2, Options options) {
        if ((uri = this.drawableDecoder.decode(uri, n, n2, options)) == null) {
            return null;
        }
        uri = (Drawable)uri.get();
        return DrawableToBitmapConverter.convert((BitmapPool)this.bitmapPool, (Drawable)uri, (int)n, (int)n2);
    }

    public boolean handles(Uri uri, Options options) {
        return "android.resource".equals(uri.getScheme());
    }
}
