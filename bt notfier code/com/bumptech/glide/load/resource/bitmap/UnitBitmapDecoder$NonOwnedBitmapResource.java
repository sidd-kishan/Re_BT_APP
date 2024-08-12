/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  com.bumptech.glide.load.engine.Resource
 *  com.bumptech.glide.util.Util
 */
package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Util;

private static final class UnitBitmapDecoder.NonOwnedBitmapResource
implements Resource<Bitmap> {
    private final Bitmap bitmap;

    UnitBitmapDecoder.NonOwnedBitmapResource(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public Bitmap get() {
        return this.bitmap;
    }

    public Class<Bitmap> getResourceClass() {
        return Bitmap.class;
    }

    public int getSize() {
        return Util.getBitmapByteSize((Bitmap)this.bitmap);
    }

    public void recycle() {
    }
}
