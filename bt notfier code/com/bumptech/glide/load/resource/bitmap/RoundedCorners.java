/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
 *  com.bumptech.glide.load.resource.bitmap.BitmapTransformation
 *  com.bumptech.glide.load.resource.bitmap.TransformationUtils
 *  com.bumptech.glide.util.Preconditions
 *  com.bumptech.glide.util.Util
 */
package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.load.resource.bitmap.TransformationUtils;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public final class RoundedCorners
extends BitmapTransformation {
    private static final String ID = "com.bumptech.glide.load.resource.bitmap.RoundedCorners";
    private static final byte[] ID_BYTES = "com.bumptech.glide.load.resource.bitmap.RoundedCorners".getBytes(CHARSET);
    private final int roundingRadius;

    public RoundedCorners(int n) {
        boolean bl = n > 0;
        Preconditions.checkArgument((boolean)bl, (String)"roundingRadius must be greater than 0.");
        this.roundingRadius = n;
    }

    public boolean equals(Object object) {
        boolean bl;
        boolean bl2 = object instanceof RoundedCorners;
        boolean bl3 = bl = false;
        if (!bl2) return bl3;
        object = (RoundedCorners)((Object)object);
        bl3 = bl;
        if (this.roundingRadius != ((RoundedCorners)((Object)object)).roundingRadius) return bl3;
        bl3 = true;
        return bl3;
    }

    public int hashCode() {
        return Util.hashCode((int)-569625254, (int)Util.hashCode((int)this.roundingRadius));
    }

    protected Bitmap transform(BitmapPool bitmapPool, Bitmap bitmap, int n, int n2) {
        return TransformationUtils.roundedCorners((BitmapPool)bitmapPool, (Bitmap)bitmap, (int)this.roundingRadius);
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(ID_BYTES);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.roundingRadius).array());
    }
}
