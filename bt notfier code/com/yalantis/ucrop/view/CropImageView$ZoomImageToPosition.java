/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.yalantis.ucrop.util.CubicEasing
 *  com.yalantis.ucrop.view.CropImageView
 */
package com.yalantis.ucrop.view;

import com.yalantis.ucrop.util.CubicEasing;
import com.yalantis.ucrop.view.CropImageView;
import java.lang.ref.WeakReference;

private static class CropImageView.ZoomImageToPosition
implements Runnable {
    private final WeakReference<CropImageView> mCropImageView;
    private final float mDeltaScale;
    private final float mDestX;
    private final float mDestY;
    private final long mDurationMs;
    private final float mOldScale;
    private final long mStartTime;

    public CropImageView.ZoomImageToPosition(CropImageView cropImageView, long l, float f, float f2, float f3, float f4) {
        this.mCropImageView = new WeakReference<CropImageView>(cropImageView);
        this.mStartTime = System.currentTimeMillis();
        this.mDurationMs = l;
        this.mOldScale = f;
        this.mDeltaScale = f2;
        this.mDestX = f3;
        this.mDestY = f4;
    }

    @Override
    public void run() {
        CropImageView cropImageView = (CropImageView)this.mCropImageView.get();
        if (cropImageView == null) {
            return;
        }
        long l = System.currentTimeMillis();
        float f = Math.min(this.mDurationMs, l - this.mStartTime);
        float f2 = CubicEasing.easeInOut((float)f, (float)0.0f, (float)this.mDeltaScale, (float)this.mDurationMs);
        if (f < (float)this.mDurationMs) {
            cropImageView.zoomInImage(this.mOldScale + f2, this.mDestX, this.mDestY);
            cropImageView.post((Runnable)this);
        } else {
            cropImageView.setImageToWrapCropBounds();
        }
    }
}
