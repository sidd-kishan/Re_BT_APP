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
 *  com.bumptech.glide.util.Util
 */
package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.util.Util;

public abstract class BitmapTransformation
implements Transformation<Bitmap> {
    public BitmapTransformation() {
    }

    @Deprecated
    public BitmapTransformation(Context context) {
        this();
    }

    protected abstract Bitmap transform(BitmapPool var1, Bitmap var2, int var3, int var4);

    public final Resource<Bitmap> transform(Context object, Resource<Bitmap> bitmapResource, int n, int n2) {
        if (!Util.isValidDimensions((int)n, (int)n2)) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Cannot apply transformation on width: ");
            ((StringBuilder)object).append(n);
            ((StringBuilder)object).append(" or height: ");
            ((StringBuilder)object).append(n2);
            ((StringBuilder)object).append(" less than or equal to zero and not Target.SIZE_ORIGINAL");
            throw new IllegalArgumentException(((StringBuilder)object).toString());
        }
        BitmapPool bitmapPool = Glide.get((Context)object).getBitmapPool();
        Bitmap bitmap = (Bitmap)bitmapResource.get();
        int n3 = n;
        if (n == Integer.MIN_VALUE) {
            n3 = bitmap.getWidth();
        }
        n = n2;
        if (n2 == Integer.MIN_VALUE) {
            n = bitmap.getHeight();
        }
        if (bitmap.equals(object = this.transform(bitmapPool, bitmap, n3, n))) return bitmapResource;
        bitmapResource = BitmapResource.obtain((Bitmap)object, (BitmapPool)bitmapPool);
        return bitmapResource;
    }
}
