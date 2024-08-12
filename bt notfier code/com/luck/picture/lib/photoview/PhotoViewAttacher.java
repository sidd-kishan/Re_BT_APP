/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Matrix
 *  android.graphics.Matrix$ScaleToFit
 *  android.graphics.RectF
 *  android.graphics.drawable.Drawable
 *  android.view.GestureDetector
 *  android.view.GestureDetector$OnDoubleTapListener
 *  android.view.GestureDetector$OnGestureListener
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnLayoutChangeListener
 *  android.view.View$OnLongClickListener
 *  android.view.View$OnTouchListener
 *  android.view.animation.AccelerateDecelerateInterpolator
 *  android.view.animation.Interpolator
 *  android.widget.ImageView
 *  android.widget.ImageView$ScaleType
 *  com.luck.picture.lib.photoview.CustomGestureDetector
 *  com.luck.picture.lib.photoview.OnGestureListener
 *  com.luck.picture.lib.photoview.OnMatrixChangedListener
 *  com.luck.picture.lib.photoview.OnOutsidePhotoTapListener
 *  com.luck.picture.lib.photoview.OnPhotoTapListener
 *  com.luck.picture.lib.photoview.OnScaleChangedListener
 *  com.luck.picture.lib.photoview.OnSingleFlingListener
 *  com.luck.picture.lib.photoview.OnViewDragListener
 *  com.luck.picture.lib.photoview.OnViewTapListener
 *  com.luck.picture.lib.photoview.PhotoViewAttacher$4
 *  com.luck.picture.lib.photoview.PhotoViewAttacher$AnimatedZoomRunnable
 *  com.luck.picture.lib.photoview.PhotoViewAttacher$FlingRunnable
 *  com.luck.picture.lib.photoview.Util
 */
package com.luck.picture.lib.photoview;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import com.luck.picture.lib.photoview.CustomGestureDetector;
import com.luck.picture.lib.photoview.OnGestureListener;
import com.luck.picture.lib.photoview.OnMatrixChangedListener;
import com.luck.picture.lib.photoview.OnOutsidePhotoTapListener;
import com.luck.picture.lib.photoview.OnPhotoTapListener;
import com.luck.picture.lib.photoview.OnScaleChangedListener;
import com.luck.picture.lib.photoview.OnSingleFlingListener;
import com.luck.picture.lib.photoview.OnViewDragListener;
import com.luck.picture.lib.photoview.OnViewTapListener;
import com.luck.picture.lib.photoview.PhotoViewAttacher;
import com.luck.picture.lib.photoview.Util;

public class PhotoViewAttacher
implements View.OnTouchListener,
View.OnLayoutChangeListener {
    private static float DEFAULT_MAX_SCALE = 3.0f;
    private static float DEFAULT_MID_SCALE = 1.75f;
    private static float DEFAULT_MIN_SCALE = 1.0f;
    private static int DEFAULT_ZOOM_DURATION = 200;
    private static final int HORIZONTAL_EDGE_BOTH = 2;
    private static final int HORIZONTAL_EDGE_LEFT = 0;
    private static final int HORIZONTAL_EDGE_NONE = -1;
    private static final int HORIZONTAL_EDGE_RIGHT = 1;
    private static int SINGLE_TOUCH = 1;
    private static final int VERTICAL_EDGE_BOTH = 2;
    private static final int VERTICAL_EDGE_BOTTOM = 1;
    private static final int VERTICAL_EDGE_NONE = -1;
    private static final int VERTICAL_EDGE_TOP = 0;
    private boolean mAllowParentInterceptOnEdge = true;
    private final Matrix mBaseMatrix;
    private float mBaseRotation;
    private boolean mBlockParentIntercept = false;
    private FlingRunnable mCurrentFlingRunnable;
    private final RectF mDisplayRect;
    private final Matrix mDrawMatrix;
    private GestureDetector mGestureDetector;
    private int mHorizontalScrollEdge = 2;
    private ImageView mImageView;
    private Interpolator mInterpolator = new AccelerateDecelerateInterpolator();
    private View.OnLongClickListener mLongClickListener;
    private OnMatrixChangedListener mMatrixChangeListener;
    private final float[] mMatrixValues;
    private float mMaxScale;
    private float mMidScale;
    private float mMinScale;
    private View.OnClickListener mOnClickListener;
    private OnViewDragListener mOnViewDragListener;
    private OnOutsidePhotoTapListener mOutsidePhotoTapListener;
    private OnPhotoTapListener mPhotoTapListener;
    private OnScaleChangedListener mScaleChangeListener;
    private CustomGestureDetector mScaleDragDetector;
    private ImageView.ScaleType mScaleType;
    private OnSingleFlingListener mSingleFlingListener;
    private final Matrix mSuppMatrix;
    private int mVerticalScrollEdge = 2;
    private OnViewTapListener mViewTapListener;
    private int mZoomDuration = DEFAULT_ZOOM_DURATION;
    private boolean mZoomEnabled = true;
    private OnGestureListener onGestureListener;

    public PhotoViewAttacher(ImageView imageView) {
        this.mMinScale = DEFAULT_MIN_SCALE;
        this.mMidScale = DEFAULT_MID_SCALE;
        this.mMaxScale = DEFAULT_MAX_SCALE;
        this.mBaseMatrix = new Matrix();
        this.mDrawMatrix = new Matrix();
        this.mSuppMatrix = new Matrix();
        this.mDisplayRect = new RectF();
        this.mMatrixValues = new float[9];
        this.mScaleType = ImageView.ScaleType.FIT_CENTER;
        this.onGestureListener = new /* Unavailable Anonymous Inner Class!! */;
        this.mImageView = imageView;
        imageView.setOnTouchListener((View.OnTouchListener)this);
        imageView.addOnLayoutChangeListener((View.OnLayoutChangeListener)this);
        if (imageView.isInEditMode()) {
            return;
        }
        this.mBaseRotation = 0.0f;
        this.mScaleDragDetector = new CustomGestureDetector(imageView.getContext(), this.onGestureListener);
        imageView = new GestureDetector(imageView.getContext(), (GestureDetector.OnGestureListener)new /* Unavailable Anonymous Inner Class!! */);
        this.mGestureDetector = imageView;
        imageView.setOnDoubleTapListener((GestureDetector.OnDoubleTapListener)new /* Unavailable Anonymous Inner Class!! */);
    }

    static /* synthetic */ CustomGestureDetector access$000(PhotoViewAttacher photoViewAttacher) {
        return photoViewAttacher.mScaleDragDetector;
    }

    static /* synthetic */ OnViewDragListener access$100(PhotoViewAttacher photoViewAttacher) {
        return photoViewAttacher.mOnViewDragListener;
    }

    static /* synthetic */ int access$1000(PhotoViewAttacher photoViewAttacher, ImageView imageView) {
        return photoViewAttacher.getImageViewWidth(imageView);
    }

    static /* synthetic */ int access$1100(PhotoViewAttacher photoViewAttacher, ImageView imageView) {
        return photoViewAttacher.getImageViewHeight(imageView);
    }

    static /* synthetic */ float access$1200(PhotoViewAttacher photoViewAttacher) {
        return photoViewAttacher.mMaxScale;
    }

    static /* synthetic */ OnScaleChangedListener access$1300(PhotoViewAttacher photoViewAttacher) {
        return photoViewAttacher.mScaleChangeListener;
    }

    static /* synthetic */ View.OnLongClickListener access$1400(PhotoViewAttacher photoViewAttacher) {
        return photoViewAttacher.mLongClickListener;
    }

    static /* synthetic */ OnSingleFlingListener access$1500(PhotoViewAttacher photoViewAttacher) {
        return photoViewAttacher.mSingleFlingListener;
    }

    static /* synthetic */ float access$1600() {
        return DEFAULT_MIN_SCALE;
    }

    static /* synthetic */ int access$1700() {
        return SINGLE_TOUCH;
    }

    static /* synthetic */ View.OnClickListener access$1800(PhotoViewAttacher photoViewAttacher) {
        return photoViewAttacher.mOnClickListener;
    }

    static /* synthetic */ OnViewTapListener access$1900(PhotoViewAttacher photoViewAttacher) {
        return photoViewAttacher.mViewTapListener;
    }

    static /* synthetic */ Matrix access$200(PhotoViewAttacher photoViewAttacher) {
        return photoViewAttacher.mSuppMatrix;
    }

    static /* synthetic */ OnPhotoTapListener access$2000(PhotoViewAttacher photoViewAttacher) {
        return photoViewAttacher.mPhotoTapListener;
    }

    static /* synthetic */ OnOutsidePhotoTapListener access$2100(PhotoViewAttacher photoViewAttacher) {
        return photoViewAttacher.mOutsidePhotoTapListener;
    }

    static /* synthetic */ OnGestureListener access$2200(PhotoViewAttacher photoViewAttacher) {
        return photoViewAttacher.onGestureListener;
    }

    static /* synthetic */ int access$2300(PhotoViewAttacher photoViewAttacher) {
        return photoViewAttacher.mZoomDuration;
    }

    static /* synthetic */ Interpolator access$2400(PhotoViewAttacher photoViewAttacher) {
        return photoViewAttacher.mInterpolator;
    }

    static /* synthetic */ void access$300(PhotoViewAttacher photoViewAttacher) {
        photoViewAttacher.checkAndDisplayMatrix();
    }

    static /* synthetic */ ImageView access$400(PhotoViewAttacher photoViewAttacher) {
        return photoViewAttacher.mImageView;
    }

    static /* synthetic */ boolean access$500(PhotoViewAttacher photoViewAttacher) {
        return photoViewAttacher.mAllowParentInterceptOnEdge;
    }

    static /* synthetic */ boolean access$600(PhotoViewAttacher photoViewAttacher) {
        return photoViewAttacher.mBlockParentIntercept;
    }

    static /* synthetic */ int access$700(PhotoViewAttacher photoViewAttacher) {
        return photoViewAttacher.mHorizontalScrollEdge;
    }

    static /* synthetic */ int access$800(PhotoViewAttacher photoViewAttacher) {
        return photoViewAttacher.mVerticalScrollEdge;
    }

    static /* synthetic */ FlingRunnable access$900(PhotoViewAttacher photoViewAttacher) {
        return photoViewAttacher.mCurrentFlingRunnable;
    }

    static /* synthetic */ FlingRunnable access$902(PhotoViewAttacher photoViewAttacher, FlingRunnable flingRunnable) {
        photoViewAttacher.mCurrentFlingRunnable = flingRunnable;
        return flingRunnable;
    }

    private void cancelFling() {
        FlingRunnable flingRunnable = this.mCurrentFlingRunnable;
        if (flingRunnable == null) return;
        flingRunnable.cancelFling();
        this.mCurrentFlingRunnable = null;
    }

    private void checkAndDisplayMatrix() {
        if (!this.checkMatrixBounds()) return;
        this.setImageViewMatrix(this.getDrawMatrix());
    }

    private boolean checkMatrixBounds() {
        int n;
        RectF rectF = this.getDisplayRect(this.getDrawMatrix());
        if (rectF == null) {
            return false;
        }
        float f = rectF.height();
        float f2 = rectF.width();
        float f3 = this.getImageViewHeight(this.mImageView);
        float f4 = 0.0f;
        if (f <= f3) {
            n = 4.$SwitchMap$android$widget$ImageView$ScaleType[this.mScaleType.ordinal()];
            if (n != 2) {
                if (n != 3) {
                    f3 = (f3 - f) / 2.0f;
                    f = rectF.top;
                } else {
                    f3 -= f;
                    f = rectF.top;
                }
                f3 -= f;
            } else {
                f3 = -rectF.top;
            }
            this.mVerticalScrollEdge = 2;
        } else if (rectF.top > 0.0f) {
            this.mVerticalScrollEdge = 0;
            f3 = -rectF.top;
        } else if (rectF.bottom < f3) {
            this.mVerticalScrollEdge = 1;
            f3 -= rectF.bottom;
        } else {
            this.mVerticalScrollEdge = -1;
            f3 = 0.0f;
        }
        f = this.getImageViewWidth(this.mImageView);
        if (f2 <= f) {
            n = 4.$SwitchMap$android$widget$ImageView$ScaleType[this.mScaleType.ordinal()];
            if (n != 2) {
                if (n != 3) {
                    f4 = (f - f2) / 2.0f;
                    f = rectF.left;
                } else {
                    f4 = f - f2;
                    f = rectF.left;
                }
                f = f4 - f;
            } else {
                f = -rectF.left;
            }
            this.mHorizontalScrollEdge = 2;
        } else if (rectF.left > 0.0f) {
            this.mHorizontalScrollEdge = 0;
            f = -rectF.left;
        } else if (rectF.right < f) {
            f -= rectF.right;
            this.mHorizontalScrollEdge = 1;
        } else {
            this.mHorizontalScrollEdge = -1;
            f = f4;
        }
        this.mSuppMatrix.postTranslate(f, f3);
        return true;
    }

    private RectF getDisplayRect(Matrix matrix) {
        Drawable drawable = this.mImageView.getDrawable();
        if (drawable == null) return null;
        this.mDisplayRect.set(0.0f, 0.0f, (float)drawable.getIntrinsicWidth(), (float)drawable.getIntrinsicHeight());
        matrix.mapRect(this.mDisplayRect);
        return this.mDisplayRect;
    }

    private Matrix getDrawMatrix() {
        this.mDrawMatrix.set(this.mBaseMatrix);
        this.mDrawMatrix.postConcat(this.mSuppMatrix);
        return this.mDrawMatrix;
    }

    private int getImageViewHeight(ImageView imageView) {
        return imageView.getHeight() - imageView.getPaddingTop() - imageView.getPaddingBottom();
    }

    private int getImageViewWidth(ImageView imageView) {
        return imageView.getWidth() - imageView.getPaddingLeft() - imageView.getPaddingRight();
    }

    private float getValue(Matrix matrix, int n) {
        matrix.getValues(this.mMatrixValues);
        return this.mMatrixValues[n];
    }

    private void resetMatrix() {
        this.mSuppMatrix.reset();
        this.setRotationBy(this.mBaseRotation);
        this.setImageViewMatrix(this.getDrawMatrix());
        this.checkMatrixBounds();
    }

    private void setImageViewMatrix(Matrix matrix) {
        this.mImageView.setImageMatrix(matrix);
        if (this.mMatrixChangeListener == null) return;
        if ((matrix = this.getDisplayRect(matrix)) == null) return;
        this.mMatrixChangeListener.onMatrixChanged((RectF)matrix);
    }

    private void updateBaseMatrix(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        float f = this.getImageViewWidth(this.mImageView);
        float f2 = this.getImageViewHeight(this.mImageView);
        int n = drawable.getIntrinsicWidth();
        int n2 = drawable.getIntrinsicHeight();
        this.mBaseMatrix.reset();
        float f3 = n;
        float f4 = f / f3;
        float f5 = n2;
        float f6 = f2 / f5;
        if (this.mScaleType == ImageView.ScaleType.CENTER) {
            this.mBaseMatrix.postTranslate((f - f3) / 2.0f, (f2 - f5) / 2.0f);
        } else if (this.mScaleType == ImageView.ScaleType.CENTER_CROP) {
            f4 = Math.max(f4, f6);
            this.mBaseMatrix.postScale(f4, f4);
            this.mBaseMatrix.postTranslate((f - f3 * f4) / 2.0f, (f2 - f5 * f4) / 2.0f);
        } else if (this.mScaleType == ImageView.ScaleType.CENTER_INSIDE) {
            f4 = Math.min(1.0f, Math.min(f4, f6));
            this.mBaseMatrix.postScale(f4, f4);
            this.mBaseMatrix.postTranslate((f - f3 * f4) / 2.0f, (f2 - f5 * f4) / 2.0f);
        } else {
            drawable = new RectF(0.0f, 0.0f, f3, f5);
            RectF rectF = new RectF(0.0f, 0.0f, f, f2);
            if ((int)this.mBaseRotation % 180 != 0) {
                drawable = new RectF(0.0f, 0.0f, f5, f3);
            }
            if ((n = 4.$SwitchMap$android$widget$ImageView$ScaleType[this.mScaleType.ordinal()]) != 1) {
                if (n != 2) {
                    if (n != 3) {
                        if (n == 4) {
                            this.mBaseMatrix.setRectToRect((RectF)drawable, rectF, Matrix.ScaleToFit.FILL);
                        }
                    } else {
                        this.mBaseMatrix.setRectToRect((RectF)drawable, rectF, Matrix.ScaleToFit.END);
                    }
                } else {
                    this.mBaseMatrix.setRectToRect((RectF)drawable, rectF, Matrix.ScaleToFit.START);
                }
            } else {
                this.mBaseMatrix.setRectToRect((RectF)drawable, rectF, Matrix.ScaleToFit.CENTER);
            }
        }
        this.resetMatrix();
    }

    public void getDisplayMatrix(Matrix matrix) {
        matrix.set(this.getDrawMatrix());
    }

    public RectF getDisplayRect() {
        this.checkMatrixBounds();
        return this.getDisplayRect(this.getDrawMatrix());
    }

    public Matrix getImageMatrix() {
        return this.mDrawMatrix;
    }

    public float getMaximumScale() {
        return this.mMaxScale;
    }

    public float getMediumScale() {
        return this.mMidScale;
    }

    public float getMinimumScale() {
        return this.mMinScale;
    }

    public float getScale() {
        return (float)Math.sqrt((float)Math.pow(this.getValue(this.mSuppMatrix, 0), 2.0) + (float)Math.pow(this.getValue(this.mSuppMatrix, 3), 2.0));
    }

    public ImageView.ScaleType getScaleType() {
        return this.mScaleType;
    }

    public void getSuppMatrix(Matrix matrix) {
        matrix.set(this.mSuppMatrix);
    }

    @Deprecated
    public boolean isZoomEnabled() {
        return this.mZoomEnabled;
    }

    public boolean isZoomable() {
        return this.mZoomEnabled;
    }

    public void onLayoutChange(View view, int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        if (n == n5 && n2 == n6 && n3 == n7) {
            if (n4 == n8) return;
        }
        this.updateBaseMatrix(this.mImageView.getDrawable());
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int n;
        boolean bl;
        boolean bl2;
        boolean bl3;
        boolean bl4;
        block9: {
            block6: {
                block5: {
                    block8: {
                        RectF rectF;
                        block7: {
                            bl4 = this.mZoomEnabled;
                            bl3 = false;
                            bl2 = false;
                            bl = bl3;
                            if (!bl4) return bl;
                            bl = bl3;
                            if (!Util.hasDrawable((ImageView)((ImageView)view))) return bl;
                            n = motionEvent.getAction();
                            if (n == 0) break block5;
                            if (n != 1 && n != 3) break block6;
                            if (!(this.getScale() < this.mMinScale)) break block7;
                            RectF rectF2 = this.getDisplayRect();
                            if (rectF2 == null) break block6;
                            view.post((Runnable)new AnimatedZoomRunnable(this, this.getScale(), this.mMinScale, rectF2.centerX(), rectF2.centerY()));
                            break block8;
                        }
                        if (!(this.getScale() > this.mMaxScale) || (rectF = this.getDisplayRect()) == null) break block6;
                        view.post((Runnable)new AnimatedZoomRunnable(this, this.getScale(), this.mMaxScale, rectF.centerX(), rectF.centerY()));
                    }
                    bl = true;
                    break block9;
                }
                if ((view = view.getParent()) != null) {
                    view.requestDisallowInterceptTouchEvent(true);
                }
                this.cancelFling();
            }
            bl = false;
        }
        view = this.mScaleDragDetector;
        if (view != null) {
            bl4 = view.isScaling();
            bl = this.mScaleDragDetector.isDragging();
            bl3 = this.mScaleDragDetector.onTouchEvent(motionEvent);
            n = !bl4 && !this.mScaleDragDetector.isScaling() ? 1 : 0;
            boolean bl5 = !bl && !this.mScaleDragDetector.isDragging();
            bl = bl2;
            if (n != 0) {
                bl = bl2;
                if (bl5) {
                    bl = true;
                }
            }
            this.mBlockParentIntercept = bl;
            bl2 = bl3;
        } else {
            bl2 = bl;
        }
        view = this.mGestureDetector;
        bl = bl2;
        if (view == null) return bl;
        bl = bl2;
        if (!view.onTouchEvent(motionEvent)) return bl;
        bl = true;
        return bl;
    }

    public void setAllowParentInterceptOnEdge(boolean bl) {
        this.mAllowParentInterceptOnEdge = bl;
    }

    public void setBaseRotation(float f) {
        this.mBaseRotation = f % 360.0f;
        this.update();
        this.setRotationBy(this.mBaseRotation);
        this.checkAndDisplayMatrix();
    }

    public boolean setDisplayMatrix(Matrix matrix) {
        if (matrix == null) throw new IllegalArgumentException("Matrix cannot be null");
        if (this.mImageView.getDrawable() == null) {
            return false;
        }
        this.mSuppMatrix.set(matrix);
        this.checkAndDisplayMatrix();
        return true;
    }

    public void setMaximumScale(float f) {
        Util.checkZoomLevels((float)this.mMinScale, (float)this.mMidScale, (float)f);
        this.mMaxScale = f;
    }

    public void setMediumScale(float f) {
        Util.checkZoomLevels((float)this.mMinScale, (float)f, (float)this.mMaxScale);
        this.mMidScale = f;
    }

    public void setMinimumScale(float f) {
        Util.checkZoomLevels((float)f, (float)this.mMidScale, (float)this.mMaxScale);
        this.mMinScale = f;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.mGestureDetector.setOnDoubleTapListener(onDoubleTapListener);
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mLongClickListener = onLongClickListener;
    }

    public void setOnMatrixChangeListener(OnMatrixChangedListener onMatrixChangedListener) {
        this.mMatrixChangeListener = onMatrixChangedListener;
    }

    public void setOnOutsidePhotoTapListener(OnOutsidePhotoTapListener onOutsidePhotoTapListener) {
        this.mOutsidePhotoTapListener = onOutsidePhotoTapListener;
    }

    public void setOnPhotoTapListener(OnPhotoTapListener onPhotoTapListener) {
        this.mPhotoTapListener = onPhotoTapListener;
    }

    public void setOnScaleChangeListener(OnScaleChangedListener onScaleChangedListener) {
        this.mScaleChangeListener = onScaleChangedListener;
    }

    public void setOnSingleFlingListener(OnSingleFlingListener onSingleFlingListener) {
        this.mSingleFlingListener = onSingleFlingListener;
    }

    public void setOnViewDragListener(OnViewDragListener onViewDragListener) {
        this.mOnViewDragListener = onViewDragListener;
    }

    public void setOnViewTapListener(OnViewTapListener onViewTapListener) {
        this.mViewTapListener = onViewTapListener;
    }

    public void setRotationBy(float f) {
        this.mSuppMatrix.postRotate(f % 360.0f);
        this.checkAndDisplayMatrix();
    }

    public void setRotationTo(float f) {
        this.mSuppMatrix.setRotate(f % 360.0f);
        this.checkAndDisplayMatrix();
    }

    public void setScale(float f) {
        this.setScale(f, false);
    }

    public void setScale(float f, float f2, float f3, boolean bl) {
        if (f < this.mMinScale) throw new IllegalArgumentException("Scale must be within the range of minScale and maxScale");
        if (f > this.mMaxScale) throw new IllegalArgumentException("Scale must be within the range of minScale and maxScale");
        if (bl) {
            this.mImageView.post((Runnable)new AnimatedZoomRunnable(this, this.getScale(), f, f2, f3));
        } else {
            this.mSuppMatrix.setScale(f, f, f2, f3);
            this.checkAndDisplayMatrix();
        }
    }

    public void setScale(float f, boolean bl) {
        this.setScale(f, this.mImageView.getRight() / 2, this.mImageView.getBottom() / 2, bl);
    }

    public void setScaleLevels(float f, float f2, float f3) {
        Util.checkZoomLevels((float)f, (float)f2, (float)f3);
        this.mMinScale = f;
        this.mMidScale = f2;
        this.mMaxScale = f3;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        if (!Util.isSupportedScaleType((ImageView.ScaleType)scaleType)) return;
        if (scaleType == this.mScaleType) return;
        this.mScaleType = scaleType;
        this.update();
    }

    public void setZoomInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public void setZoomTransitionDuration(int n) {
        this.mZoomDuration = n;
    }

    public void setZoomable(boolean bl) {
        this.mZoomEnabled = bl;
        this.update();
    }

    public void update() {
        if (this.mZoomEnabled) {
            this.updateBaseMatrix(this.mImageView.getDrawable());
        } else {
            this.resetMatrix();
        }
    }
}
