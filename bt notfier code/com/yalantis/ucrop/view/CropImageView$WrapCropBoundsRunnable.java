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

/*
 * Exception performing whole class analysis ignored.
 */
private static class CropImageView.WrapCropBoundsRunnable
implements Runnable {
    private final float mCenterDiffX;
    private final float mCenterDiffY;
    private final WeakReference<CropImageView> mCropImageView;
    private final float mDeltaScale;
    private final long mDurationMs;
    private final float mOldScale;
    private final float mOldX;
    private final float mOldY;
    private final long mStartTime;
    private final boolean mWillBeImageInBoundsAfterTranslate;

    public CropImageView.WrapCropBoundsRunnable(CropImageView cropImageView, long l, float f, float f2, float f3, float f4, float f5, float f6, boolean bl) {
        this.mCropImageView = new WeakReference<CropImageView>(cropImageView);
        this.mDurationMs = l;
        this.mStartTime = System.currentTimeMillis();
        this.mOldX = f;
        this.mOldY = f2;
        this.mCenterDiffX = f3;
        this.mCenterDiffY = f4;
        this.mOldScale = f5;
        this.mDeltaScale = f6;
        this.mWillBeImageInBoundsAfterTranslate = bl;
    }

    @Override
    public void run() {
        CropImageView cropImageView = (CropImageView)this.mCropImageView.get();
        if (cropImageView == null) {
            return;
        }
        long l = System.currentTimeMillis();
        float f = Math.min(this.mDurationMs, l - this.mStartTime);
        float f2 = CubicEasing.easeOut((float)f, (float)0.0f, (float)this.mCenterDiffX, (float)this.mDurationMs);
        float f3 = CubicEasing.easeOut((float)f, (float)0.0f, (float)this.mCenterDiffY, (float)this.mDurationMs);
        float f4 = CubicEasing.easeInOut((float)f, (float)0.0f, (float)this.mDeltaScale, (float)this.mDurationMs);
        if (!(f < (float)this.mDurationMs)) return;
        cropImageView.postTranslate(f2 - (cropImageView.mCurrentImageCenter[0] - this.mOldX), f3 - (cropImageView.mCurrentImageCenter[1] - this.mOldY));
        if (!this.mWillBeImageInBoundsAfterTranslate) {
            cropImageView.zoomInImage(this.mOldScale + f4, CropImageView.access$000((CropImageView)cropImageView).centerX(), CropImageView.access$000((CropImageView)cropImageView).centerY());
        }
        if (cropImageView.isImageWrapCropBounds()) return;
        cropImageView.post((Runnable)this);
    }
}
