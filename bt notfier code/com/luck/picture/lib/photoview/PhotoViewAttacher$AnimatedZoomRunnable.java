/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  com.luck.picture.lib.photoview.Compat
 *  com.luck.picture.lib.photoview.PhotoViewAttacher
 */
package com.luck.picture.lib.photoview;

import android.view.View;
import com.luck.picture.lib.photoview.Compat;
import com.luck.picture.lib.photoview.PhotoViewAttacher;

/*
 * Exception performing whole class analysis ignored.
 */
private class PhotoViewAttacher.AnimatedZoomRunnable
implements Runnable {
    private final float mFocalX;
    private final float mFocalY;
    private final long mStartTime;
    private final float mZoomEnd;
    private final float mZoomStart;
    final PhotoViewAttacher this$0;

    public PhotoViewAttacher.AnimatedZoomRunnable(PhotoViewAttacher photoViewAttacher, float f, float f2, float f3, float f4) {
        this.this$0 = photoViewAttacher;
        this.mFocalX = f3;
        this.mFocalY = f4;
        this.mStartTime = System.currentTimeMillis();
        this.mZoomStart = f;
        this.mZoomEnd = f2;
    }

    private float interpolate() {
        float f = Math.min(1.0f, (float)(System.currentTimeMillis() - this.mStartTime) * 1.0f / (float)PhotoViewAttacher.access$2300((PhotoViewAttacher)this.this$0));
        return PhotoViewAttacher.access$2400((PhotoViewAttacher)this.this$0).getInterpolation(f);
    }

    @Override
    public void run() {
        float f = this.interpolate();
        float f2 = this.mZoomStart;
        f2 = (f2 + (this.mZoomEnd - f2) * f) / this.this$0.getScale();
        PhotoViewAttacher.access$2200((PhotoViewAttacher)this.this$0).onScale(f2, this.mFocalX, this.mFocalY);
        if (!(f < 1.0f)) return;
        Compat.postOnAnimation((View)PhotoViewAttacher.access$400((PhotoViewAttacher)this.this$0), (Runnable)this);
    }
}
