/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  com.bumptech.glide.load.Options
 *  com.bumptech.glide.load.ResourceDecoder
 *  com.bumptech.glide.load.engine.Resource
 *  com.bumptech.glide.load.resource.bitmap.UnitBitmapDecoder$NonOwnedBitmapResource
 */
package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bitmap.UnitBitmapDecoder;

public final class UnitBitmapDecoder
implements ResourceDecoder<Bitmap, Bitmap> {
    public Resource<Bitmap> decode(Bitmap bitmap, int n, int n2, Options options) {
        return new NonOwnedBitmapResource(bitmap);
    }

    public boolean handles(Bitmap bitmap, Options options) {
        return true;
    }
}
