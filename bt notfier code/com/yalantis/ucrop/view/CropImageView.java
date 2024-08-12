/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.graphics.Bitmap$CompressFormat
 *  android.graphics.Matrix
 *  android.graphics.RectF
 *  android.graphics.drawable.Drawable
 *  com.luck.picture.lib.R$styleable
 *  com.yalantis.ucrop.callback.BitmapCropCallback
 *  com.yalantis.ucrop.callback.CropBoundsChangeListener
 *  com.yalantis.ucrop.model.CropParameters
 *  com.yalantis.ucrop.model.ImageState
 *  com.yalantis.ucrop.task.BitmapCropTask
 *  com.yalantis.ucrop.util.RectUtils
 *  com.yalantis.ucrop.view.CropImageView$WrapCropBoundsRunnable
 *  com.yalantis.ucrop.view.CropImageView$ZoomImageToPosition
 *  com.yalantis.ucrop.view.TransformImageView
 */
package com.yalantis.ucrop.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.luck.picture.lib.R;
import com.yalantis.ucrop.callback.BitmapCropCallback;
import com.yalantis.ucrop.callback.CropBoundsChangeListener;
import com.yalantis.ucrop.model.CropParameters;
import com.yalantis.ucrop.model.ImageState;
import com.yalantis.ucrop.task.BitmapCropTask;
import com.yalantis.ucrop.util.RectUtils;
import com.yalantis.ucrop.view.CropImageView;
import com.yalantis.ucrop.view.TransformImageView;
import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class CropImageView
extends TransformImageView {
    public static final float DEFAULT_ASPECT_RATIO = 0.0f;
    public static final int DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION = 500;
    public static final int DEFAULT_MAX_BITMAP_SIZE = 0;
    public static final float DEFAULT_MAX_SCALE_MULTIPLIER = 10.0f;
    public static final float SOURCE_IMAGE_ASPECT_RATIO = 0.0f;
    private CropBoundsChangeListener mCropBoundsChangeListener;
    private final RectF mCropRect = new RectF();
    private long mImageToWrapCropBoundsAnimDuration = 500L;
    private int mMaxResultImageSizeX = 0;
    private int mMaxResultImageSizeY = 0;
    private float mMaxScale;
    private float mMaxScaleMultiplier = 10.0f;
    private float mMinScale;
    private float mTargetAspectRatio;
    private final Matrix mTempMatrix = new Matrix();
    private Runnable mWrapCropBoundsRunnable;
    private Runnable mZoomImageToPositionRunnable = null;

    public CropImageView(Context context) {
        this(context, null);
    }

    public CropImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CropImageView(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
    }

    static /* synthetic */ RectF access$000(CropImageView cropImageView) {
        return cropImageView.mCropRect;
    }

    private float[] calculateImageIndents() {
        this.mTempMatrix.reset();
        this.mTempMatrix.setRotate(-this.getCurrentAngle());
        Object object = Arrays.copyOf(this.mCurrentImageCorners, this.mCurrentImageCorners.length);
        Object object2 = RectUtils.getCornersFromRect((RectF)this.mCropRect);
        this.mTempMatrix.mapPoints(object);
        this.mTempMatrix.mapPoints(object2);
        object = RectUtils.trapToRect((float[])object);
        object2 = RectUtils.trapToRect((float[])object2);
        float f = object.left - object2.left;
        float f2 = object.top - object2.top;
        float f3 = object.right - object2.right;
        float f4 = object.bottom - object2.bottom;
        object = new float[4];
        if (!(f > 0.0f)) {
            f = 0.0f;
        }
        object[0] = f;
        f = f2 > 0.0f ? f2 : 0.0f;
        object[1] = f;
        f = f3 < 0.0f ? f3 : 0.0f;
        object[2] = f;
        f = f4 < 0.0f ? f4 : 0.0f;
        object[3] = f;
        this.mTempMatrix.reset();
        this.mTempMatrix.setRotate(this.getCurrentAngle());
        this.mTempMatrix.mapPoints(object);
        return object;
    }

    private void calculateImageScaleBounds() {
        Drawable drawable = this.getDrawable();
        if (drawable == null) {
            return;
        }
        this.calculateImageScaleBounds(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
    }

    private void calculateImageScaleBounds(float f, float f2) {
        this.mMinScale = f = Math.min(Math.min(this.mCropRect.width() / f, this.mCropRect.width() / f2), Math.min(this.mCropRect.height() / f2, this.mCropRect.height() / f));
        this.mMaxScale = f * this.mMaxScaleMultiplier;
    }

    private void setupInitialImagePosition(float f, float f2) {
        float f3 = this.mCropRect.width();
        float f4 = this.mCropRect.height();
        float f5 = Math.max(this.mCropRect.width() / f, this.mCropRect.height() / f2);
        f = (f3 - f * f5) / 2.0f;
        f3 = this.mCropRect.left;
        f2 = (f4 - f2 * f5) / 2.0f;
        f4 = this.mCropRect.top;
        this.mCurrentImageMatrix.reset();
        this.mCurrentImageMatrix.postScale(f5, f5);
        this.mCurrentImageMatrix.postTranslate(f + f3, f2 + f4);
        this.setImageMatrix(this.mCurrentImageMatrix);
    }

    public void cancelAllAnimations() {
        this.removeCallbacks(this.mWrapCropBoundsRunnable);
        this.removeCallbacks(this.mZoomImageToPositionRunnable);
    }

    public void cropAndSaveImage(Bitmap.CompressFormat compressFormat, int n, BitmapCropCallback bitmapCropCallback) {
        this.cancelAllAnimations();
        this.setImageToWrapCropBounds(false);
        ImageState imageState = new ImageState(this.mCropRect, RectUtils.trapToRect((float[])this.mCurrentImageCorners), this.getCurrentScale(), this.getCurrentAngle());
        compressFormat = new CropParameters(this.mMaxResultImageSizeX, this.mMaxResultImageSizeY, compressFormat, n, this.getImageInputPath(), this.getImageOutputPath(), this.getExifInfo());
        new BitmapCropTask(this.getContext(), this.getViewBitmap(), imageState, (CropParameters)compressFormat, bitmapCropCallback).executeOnExecutor((Executor)Executors.newCachedThreadPool(), (Object[])new Void[0]);
    }

    public CropBoundsChangeListener getCropBoundsChangeListener() {
        return this.mCropBoundsChangeListener;
    }

    public float getMaxScale() {
        return this.mMaxScale;
    }

    public float getMinScale() {
        return this.mMinScale;
    }

    public float getTargetAspectRatio() {
        return this.mTargetAspectRatio;
    }

    protected boolean isImageWrapCropBounds() {
        return this.isImageWrapCropBounds(this.mCurrentImageCorners);
    }

    protected boolean isImageWrapCropBounds(float[] fArray) {
        this.mTempMatrix.reset();
        this.mTempMatrix.setRotate(-this.getCurrentAngle());
        float[] fArray2 = Arrays.copyOf(fArray, fArray.length);
        this.mTempMatrix.mapPoints(fArray2);
        fArray = RectUtils.getCornersFromRect((RectF)this.mCropRect);
        this.mTempMatrix.mapPoints(fArray);
        return RectUtils.trapToRect((float[])fArray2).contains(RectUtils.trapToRect((float[])fArray));
    }

    protected void onImageLaidOut() {
        int n;
        super.onImageLaidOut();
        Drawable drawable = this.getDrawable();
        if (drawable == null) {
            return;
        }
        float f = drawable.getIntrinsicWidth();
        float f2 = drawable.getIntrinsicHeight();
        if (this.mTargetAspectRatio == 0.0f) {
            this.mTargetAspectRatio = f / f2;
        }
        if ((n = (int)((float)this.mThisWidth / this.mTargetAspectRatio)) > this.mThisHeight) {
            n = (int)((float)this.mThisHeight * this.mTargetAspectRatio);
            int n2 = (this.mThisWidth - n) / 2;
            this.mCropRect.set((float)n2, 0.0f, (float)(n + n2), (float)this.mThisHeight);
        } else {
            int n3 = (this.mThisHeight - n) / 2;
            this.mCropRect.set(0.0f, (float)n3, (float)this.mThisWidth, (float)(n + n3));
        }
        this.calculateImageScaleBounds(f, f2);
        this.setupInitialImagePosition(f, f2);
        drawable = this.mCropBoundsChangeListener;
        if (drawable != null) {
            drawable.onCropAspectRatioChanged(this.mTargetAspectRatio);
        }
        if (this.mTransformImageListener == null) return;
        this.mTransformImageListener.onScale(this.getCurrentScale());
        this.mTransformImageListener.onRotate(this.getCurrentAngle());
    }

    public void postRotate(float f) {
        this.postRotate(f, this.mCropRect.centerX(), this.mCropRect.centerY());
    }

    public void postScale(float f, float f2, float f3) {
        if (f > 1.0f && this.getCurrentScale() * f <= this.getMaxScale()) {
            super.postScale(f, f2, f3);
        } else {
            if (!(f < 1.0f)) return;
            if (!(this.getCurrentScale() * f >= this.getMinScale())) return;
            super.postScale(f, f2, f3);
        }
    }

    protected void processStyledAttributes(TypedArray typedArray) {
        float f = Math.abs(typedArray.getFloat(R.styleable.ucrop_UCropView_ucrop_aspect_ratio_x, 0.0f));
        float f2 = Math.abs(typedArray.getFloat(R.styleable.ucrop_UCropView_ucrop_aspect_ratio_y, 0.0f));
        this.mTargetAspectRatio = f != 0.0f && f2 != 0.0f ? f / f2 : 0.0f;
    }

    public void setCropBoundsChangeListener(CropBoundsChangeListener cropBoundsChangeListener) {
        this.mCropBoundsChangeListener = cropBoundsChangeListener;
    }

    public void setCropRect(RectF rectF) {
        this.mTargetAspectRatio = rectF.width() / rectF.height();
        this.mCropRect.set(rectF.left - (float)this.getPaddingLeft(), rectF.top - (float)this.getPaddingTop(), rectF.right - (float)this.getPaddingRight(), rectF.bottom - (float)this.getPaddingBottom());
        this.calculateImageScaleBounds();
        this.setImageToWrapCropBounds();
    }

    public void setImageToWrapCropBounds() {
        this.setImageToWrapCropBounds(true);
    }

    public void setImageToWrapCropBounds(boolean bl) {
        float f;
        if (!this.mBitmapLaidOut) return;
        if (this.isImageWrapCropBounds()) return;
        float f2 = this.mCurrentImageCenter[0];
        float f3 = this.mCurrentImageCenter[1];
        float f4 = this.getCurrentScale();
        float f5 = this.mCropRect.centerX() - f2;
        float f6 = this.mCropRect.centerY() - f3;
        this.mTempMatrix.reset();
        this.mTempMatrix.setTranslate(f5, f6);
        Object object = Arrays.copyOf(this.mCurrentImageCorners, this.mCurrentImageCorners.length);
        this.mTempMatrix.mapPoints(object);
        boolean bl2 = this.isImageWrapCropBounds((float[])object);
        if (bl2) {
            object = this.calculateImageIndents();
            f5 = -(object[0] + object[2]);
            f6 = -(object[1] + object[3]);
            f = 0.0f;
        } else {
            object = new RectF(this.mCropRect);
            this.mTempMatrix.reset();
            this.mTempMatrix.setRotate(this.getCurrentAngle());
            this.mTempMatrix.mapRect((RectF)object);
            float[] fArray = RectUtils.getRectSidesFromCorners((float[])this.mCurrentImageCorners);
            f = Math.max(object.width() / fArray[0], object.height() / fArray[1]);
            f = f * f4 - f4;
        }
        if (bl) {
            object = new WrapCropBoundsRunnable(this, this.mImageToWrapCropBoundsAnimDuration, f2, f3, f5, f6, f4, f, bl2);
            this.mWrapCropBoundsRunnable = object;
            this.post((Runnable)object);
        } else {
            this.postTranslate(f5, f6);
            if (bl2) return;
            this.zoomInImage(f4 + f, this.mCropRect.centerX(), this.mCropRect.centerY());
        }
    }

    public void setImageToWrapCropBoundsAnimDuration(long l) {
        if (l <= 0L) throw new IllegalArgumentException("Animation duration cannot be negative value.");
        this.mImageToWrapCropBoundsAnimDuration = l;
    }

    public void setMaxResultImageSizeX(int n) {
        this.mMaxResultImageSizeX = n;
    }

    public void setMaxResultImageSizeY(int n) {
        this.mMaxResultImageSizeY = n;
    }

    public void setMaxScaleMultiplier(float f) {
        this.mMaxScaleMultiplier = f;
    }

    public void setTargetAspectRatio(float f) {
        Drawable drawable = this.getDrawable();
        if (drawable == null) {
            this.mTargetAspectRatio = f;
            return;
        }
        this.mTargetAspectRatio = f == 0.0f ? (float)drawable.getIntrinsicWidth() / (float)drawable.getIntrinsicHeight() : f;
        drawable = this.mCropBoundsChangeListener;
        if (drawable == null) return;
        drawable.onCropAspectRatioChanged(this.mTargetAspectRatio);
    }

    protected void zoomImageToPosition(float f, float f2, float f3, long l) {
        float f4 = f;
        if (f > this.getMaxScale()) {
            f4 = this.getMaxScale();
        }
        f = this.getCurrentScale();
        ZoomImageToPosition zoomImageToPosition = new ZoomImageToPosition(this, l, f, f4 - f, f2, f3);
        this.mZoomImageToPositionRunnable = zoomImageToPosition;
        this.post((Runnable)zoomImageToPosition);
    }

    public void zoomInImage(float f) {
        this.zoomInImage(f, this.mCropRect.centerX(), this.mCropRect.centerY());
    }

    public void zoomInImage(float f, float f2, float f3) {
        if (!(f <= this.getMaxScale())) return;
        this.postScale(f / this.getCurrentScale(), f2, f3);
    }

    public void zoomOutImage(float f) {
        this.zoomOutImage(f, this.mCropRect.centerX(), this.mCropRect.centerY());
    }

    public void zoomOutImage(float f, float f2, float f3) {
        if (!(f >= this.getMinScale())) return;
        this.postScale(f / this.getCurrentScale(), f2, f3);
    }
}
