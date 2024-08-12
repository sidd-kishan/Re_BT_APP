/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.drawable.Animatable
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  android.util.Log
 *  com.bumptech.glide.load.engine.Resource
 *  com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
 *  com.bumptech.glide.load.resource.bitmap.BitmapResource
 *  com.bumptech.glide.load.resource.bitmap.TransformationUtils
 */
package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.load.resource.bitmap.TransformationUtils;
import java.util.concurrent.locks.Lock;

final class DrawableToBitmapConverter {
    private static final BitmapPool NO_RECYCLE_BITMAP_POOL = new /* Unavailable Anonymous Inner Class!! */;
    private static final String TAG = "DrawableToBitmap";

    private DrawableToBitmapConverter() {
    }

    static Resource<Bitmap> convert(BitmapPool bitmapPool, Drawable drawable, int n, int n2) {
        drawable = drawable.getCurrent();
        boolean bl = drawable instanceof BitmapDrawable;
        int n3 = 0;
        if (bl) {
            drawable = ((BitmapDrawable)drawable).getBitmap();
            n = n3;
        } else if (!(drawable instanceof Animatable)) {
            drawable = DrawableToBitmapConverter.drawToBitmap(bitmapPool, drawable, n, n2);
            n = 1;
        } else {
            drawable = null;
            n = n3;
        }
        if (n != 0) return BitmapResource.obtain((Bitmap)drawable, (BitmapPool)bitmapPool);
        bitmapPool = NO_RECYCLE_BITMAP_POOL;
        return BitmapResource.obtain((Bitmap)drawable, (BitmapPool)bitmapPool);
    }

    private static Bitmap drawToBitmap(BitmapPool object, Drawable drawable, int n, int n2) {
        if (n == Integer.MIN_VALUE && drawable.getIntrinsicWidth() <= 0) {
            if (!Log.isLoggable((String)TAG, (int)5)) return null;
            object = new StringBuilder();
            ((StringBuilder)object).append("Unable to draw ");
            ((StringBuilder)object).append(drawable);
            ((StringBuilder)object).append(" to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width");
            Log.w((String)TAG, (String)((StringBuilder)object).toString());
            return null;
        }
        if (n2 == Integer.MIN_VALUE && drawable.getIntrinsicHeight() <= 0) {
            if (!Log.isLoggable((String)TAG, (int)5)) return null;
            object = new StringBuilder();
            ((StringBuilder)object).append("Unable to draw ");
            ((StringBuilder)object).append(drawable);
            ((StringBuilder)object).append(" to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height");
            Log.w((String)TAG, (String)((StringBuilder)object).toString());
            return null;
        }
        if (drawable.getIntrinsicWidth() > 0) {
            n = drawable.getIntrinsicWidth();
        }
        if (drawable.getIntrinsicHeight() > 0) {
            n2 = drawable.getIntrinsicHeight();
        }
        Lock lock = TransformationUtils.getBitmapDrawableLock();
        lock.lock();
        Bitmap bitmap = object.get(n, n2, Bitmap.Config.ARGB_8888);
        try {
            object = new Canvas(bitmap);
            drawable.setBounds(0, 0, n, n2);
            drawable.draw((Canvas)object);
            object.setBitmap(null);
            return bitmap;
        }
        finally {
            lock.unlock();
        }
    }
}
