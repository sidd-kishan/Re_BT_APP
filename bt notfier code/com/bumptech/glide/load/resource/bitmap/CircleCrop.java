/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
 *  com.bumptech.glide.load.resource.bitmap.BitmapTransformation
 *  com.bumptech.glide.load.resource.bitmap.TransformationUtils
 */
package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.load.resource.bitmap.TransformationUtils;
import java.security.MessageDigest;

public class CircleCrop
extends BitmapTransformation {
    private static final String ID = "com.bumptech.glide.load.resource.bitmap.CircleCrop.1";
    private static final byte[] ID_BYTES = "com.bumptech.glide.load.resource.bitmap.CircleCrop.1".getBytes(CHARSET);
    private static final int VERSION = 1;

    public boolean equals(Object object) {
        return object instanceof CircleCrop;
    }

    public int hashCode() {
        return 1101716364;
    }

    protected Bitmap transform(BitmapPool bitmapPool, Bitmap bitmap, int n, int n2) {
        return TransformationUtils.circleCrop((BitmapPool)bitmapPool, (Bitmap)bitmap, (int)n, (int)n2);
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(ID_BYTES);
    }
}
