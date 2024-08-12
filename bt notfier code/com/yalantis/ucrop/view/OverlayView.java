/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator$AnimatorListener
 *  android.animation.TimeInterpolator
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.Path
 *  android.graphics.Path$Direction
 *  android.graphics.Point
 *  android.graphics.RectF
 *  android.graphics.Region$Op
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.animation.OvershootInterpolator
 *  com.luck.picture.lib.R$color
 *  com.luck.picture.lib.R$dimen
 *  com.luck.picture.lib.R$styleable
 *  com.yalantis.ucrop.callback.OverlayViewChangeListener
 *  com.yalantis.ucrop.util.RectUtils
 */
package com.yalantis.ucrop.view;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import com.luck.picture.lib.R;
import com.yalantis.ucrop.callback.OverlayViewChangeListener;
import com.yalantis.ucrop.util.RectUtils;

public class OverlayView
extends View {
    public static final boolean DEFAULT_CIRCLE_DIMMED_LAYER = false;
    public static final int DEFAULT_CROP_GRID_COLUMN_COUNT = 2;
    public static final int DEFAULT_CROP_GRID_ROW_COUNT = 2;
    public static final boolean DEFAULT_DRAG_FRAME = true;
    public static final int DEFAULT_FREESTYLE_CROP_MODE = 0;
    public static final boolean DEFAULT_SHOW_CROP_FRAME = true;
    public static final boolean DEFAULT_SHOW_CROP_GRID = true;
    public static final int FREESTYLE_CROP_MODE_DISABLE = 0;
    public static final int FREESTYLE_CROP_MODE_ENABLE = 1;
    public static final int FREESTYLE_CROP_MODE_ENABLE_WITH_PASS_THROUGH = 2;
    private OverlayViewChangeListener mCallback;
    private boolean mCircleDimmedLayer;
    private Path mCircularPath;
    private Paint mCropFrameCornersPaint;
    private Paint mCropFramePaint;
    protected float[] mCropGridCenter;
    private int mCropGridColumnCount;
    protected float[] mCropGridCorners;
    private Paint mCropGridPaint;
    private int mCropGridRowCount;
    private int mCropRectCornerTouchAreaLineLength;
    private int mCropRectMinSize;
    private final RectF mCropViewRect = new RectF();
    private int mCurrentTouchCornerIndex = -1;
    private int mDimmedBorderColor;
    private int mDimmedColor;
    private Paint mDimmedStrokePaint;
    private int mFreestyleCropMode = 0;
    private float[] mGridPoints = null;
    private boolean mIsDragFrame = true;
    private float mPreviousTouchX = -1.0f;
    private float mPreviousTouchY = -1.0f;
    private boolean mShouldSetupCropBounds;
    private boolean mShowCropFrame;
    private boolean mShowCropGrid;
    private int mStrokeWidth = 1;
    private float mTargetAspectRatio;
    private final RectF mTempRect = new RectF();
    protected int mThisHeight;
    protected int mThisWidth;
    private int mTouchPointThreshold;
    private ValueAnimator smoothAnimator;

    public OverlayView(Context context) {
        this(context, null);
    }

    public OverlayView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OverlayView(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.mCircularPath = new Path();
        this.mDimmedStrokePaint = new Paint(1);
        this.mCropGridPaint = new Paint(1);
        this.mCropFramePaint = new Paint(1);
        this.mCropFrameCornersPaint = new Paint(1);
        this.mTouchPointThreshold = this.getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_rect_corner_touch_threshold);
        this.mCropRectMinSize = this.getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_rect_min_size);
        this.mCropRectCornerTouchAreaLineLength = this.getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_rect_corner_touch_area_line_length);
        this.init();
    }

    static /* synthetic */ RectF access$000(OverlayView overlayView) {
        return overlayView.mCropViewRect;
    }

    static /* synthetic */ void access$100(OverlayView overlayView) {
        overlayView.updateGridPoints();
    }

    static /* synthetic */ OverlayViewChangeListener access$200(OverlayView overlayView) {
        return overlayView.mCallback;
    }

    private int getCurrentTouchIndex(float f, float f2) {
        double d = this.mTouchPointThreshold;
        int n = -1;
        int n2 = 0;
        while (true) {
            if (n2 >= 8) {
                if (this.mFreestyleCropMode != 1) return n;
                if (n >= 0) return n;
                if (!this.mCropViewRect.contains(f, f2)) return n;
                return 4;
            }
            double d2 = Math.sqrt(Math.pow(f - this.mCropGridCorners[n2], 2.0) + Math.pow(f2 - this.mCropGridCorners[n2 + 1], 2.0));
            double d3 = d;
            if (d2 < d) {
                n = n2 / 2;
                d3 = d2;
            }
            n2 += 2;
            d = d3;
        }
    }

    private void initCropFrameStyle(TypedArray typedArray) {
        int n = typedArray.getDimensionPixelSize(R.styleable.ucrop_UCropView_ucrop_frame_stroke_size, this.getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_frame_stoke_width));
        int n2 = typedArray.getColor(R.styleable.ucrop_UCropView_ucrop_frame_color, this.getResources().getColor(R.color.ucrop_color_default_crop_frame));
        this.mCropFramePaint.setStrokeWidth((float)n);
        this.mCropFramePaint.setColor(n2);
        this.mCropFramePaint.setStyle(Paint.Style.STROKE);
        this.mCropFrameCornersPaint.setStrokeWidth((float)(n * 3));
        this.mCropFrameCornersPaint.setColor(n2);
        this.mCropFrameCornersPaint.setStyle(Paint.Style.STROKE);
    }

    private void initCropGridStyle(TypedArray typedArray) {
        int n = typedArray.getDimensionPixelSize(R.styleable.ucrop_UCropView_ucrop_grid_stroke_size, this.getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_grid_stoke_width));
        int n2 = typedArray.getColor(R.styleable.ucrop_UCropView_ucrop_grid_color, this.getResources().getColor(R.color.ucrop_color_default_crop_grid));
        this.mCropGridPaint.setStrokeWidth((float)n);
        this.mCropGridPaint.setColor(n2);
        this.mCropGridRowCount = typedArray.getInt(R.styleable.ucrop_UCropView_ucrop_grid_row_count, 2);
        this.mCropGridColumnCount = typedArray.getInt(R.styleable.ucrop_UCropView_ucrop_grid_column_count, 2);
    }

    private void smoothToCenter() {
        Point point = new Point((this.getRight() + this.getLeft()) / 2, (this.getTop() + this.getBottom()) / 2);
        int n = (int)((float)point.y - this.mCropViewRect.centerY());
        int n2 = (int)((float)point.x - this.mCropViewRect.centerX());
        point = new RectF(this.mCropViewRect);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("pre");
        stringBuilder.append(this.mCropViewRect);
        Log.d((String)"pisa", (String)stringBuilder.toString());
        stringBuilder = new RectF(this.mCropViewRect);
        stringBuilder.offset(n2, n);
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("after");
        stringBuilder2.append((Object)stringBuilder);
        Log.d((String)"pisa", (String)stringBuilder2.toString());
        stringBuilder = this.smoothAnimator;
        if (stringBuilder != null) {
            stringBuilder.cancel();
        }
        stringBuilder = ValueAnimator.ofFloat((float[])new float[]{0.0f, 1.0f});
        this.smoothAnimator = stringBuilder;
        stringBuilder.setDuration(1000L);
        this.smoothAnimator.setInterpolator((TimeInterpolator)new OvershootInterpolator());
        this.smoothAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new /* Unavailable Anonymous Inner Class!! */);
        this.smoothAnimator.addListener((Animator.AnimatorListener)new /* Unavailable Anonymous Inner Class!! */);
        this.smoothAnimator.start();
    }

    private void updateCropViewRect(float f, float f2) {
        this.mTempRect.set(this.mCropViewRect);
        int n = this.mCurrentTouchCornerIndex;
        boolean bl = true;
        if (n != 0) {
            if (n != 1) {
                if (n != 2) {
                    if (n != 3) {
                        if (n == 4) {
                            this.mTempRect.offset(f - this.mPreviousTouchX, f2 - this.mPreviousTouchY);
                            if (!(this.mTempRect.left > (float)this.getLeft())) return;
                            if (!(this.mTempRect.top > (float)this.getTop())) return;
                            if (!(this.mTempRect.right < (float)this.getRight())) return;
                            if (!(this.mTempRect.bottom < (float)this.getBottom())) return;
                            this.mCropViewRect.set(this.mTempRect);
                            this.updateGridPoints();
                            this.postInvalidate();
                            return;
                        }
                    } else if (this.isDragFrame()) {
                        this.mTempRect.set(f, this.mCropViewRect.top, this.mCropViewRect.right, f2);
                    }
                } else if (this.isDragFrame()) {
                    this.mTempRect.set(this.mCropViewRect.left, this.mCropViewRect.top, f, f2);
                }
            } else if (this.isDragFrame()) {
                this.mTempRect.set(this.mCropViewRect.left, f2, f, this.mCropViewRect.bottom);
            }
        } else if (this.isDragFrame()) {
            this.mTempRect.set(f, f2, this.mCropViewRect.right, this.mCropViewRect.bottom);
        }
        n = this.mTempRect.height() >= (float)this.mCropRectMinSize ? 1 : 0;
        if (!(this.mTempRect.width() >= (float)this.mCropRectMinSize)) {
            bl = false;
        }
        RectF rectF = this.mCropViewRect;
        f = bl ? this.mTempRect.left : rectF.left;
        RectF rectF2 = n != 0 ? this.mTempRect : this.mCropViewRect;
        f2 = rectF2.top;
        rectF2 = bl ? this.mTempRect : this.mCropViewRect;
        float f3 = rectF2.right;
        rectF2 = n != 0 ? this.mTempRect : this.mCropViewRect;
        rectF.set(f, f2, f3, rectF2.bottom);
        if (n == 0) {
            if (!bl) return;
        }
        this.updateGridPoints();
        this.postInvalidate();
    }

    private void updateGridPoints() {
        this.mCropGridCorners = RectUtils.getCornersFromRect((RectF)this.mCropViewRect);
        this.mCropGridCenter = RectUtils.getCenterFromRect((RectF)this.mCropViewRect);
        this.mGridPoints = null;
        this.mCircularPath.reset();
        this.mCircularPath.addCircle(this.mCropViewRect.centerX(), this.mCropViewRect.centerY(), Math.min(this.mCropViewRect.width(), this.mCropViewRect.height()) / 2.0f, Path.Direction.CW);
    }

    protected void drawCropGrid(Canvas canvas) {
        Object object;
        int n;
        if (this.mShowCropGrid) {
            if (this.mGridPoints == null && !this.mCropViewRect.isEmpty()) {
                float f;
                float f2;
                int n2;
                int n3;
                this.mGridPoints = new float[this.mCropGridRowCount * 4 + this.mCropGridColumnCount * 4];
                int n4 = 0;
                int n5 = 0;
                n = 0;
                while (true) {
                    n3 = n;
                    if (n5 >= this.mCropGridRowCount) break;
                    object = this.mGridPoints;
                    n2 = n + 1;
                    object[n] = this.mCropViewRect.left;
                    object = this.mGridPoints;
                    n = n2 + 1;
                    f2 = this.mCropViewRect.height();
                    f = (float)n5 + 1.0f;
                    object[n2] = f2 * (f / (float)(this.mCropGridRowCount + 1)) + this.mCropViewRect.top;
                    object = this.mGridPoints;
                    n2 = n + 1;
                    object[n] = this.mCropViewRect.right;
                    this.mGridPoints[n2] = this.mCropViewRect.height() * (f / (float)(this.mCropGridRowCount + 1)) + this.mCropViewRect.top;
                    ++n5;
                    n = n2 + 1;
                }
                for (n2 = n4; n2 < this.mCropGridColumnCount; ++n2) {
                    object = this.mGridPoints;
                    n = n3 + 1;
                    f = this.mCropViewRect.width();
                    f2 = (float)n2 + 1.0f;
                    object[n3] = f * (f2 / (float)(this.mCropGridColumnCount + 1)) + this.mCropViewRect.left;
                    object = this.mGridPoints;
                    n5 = n + 1;
                    object[n] = this.mCropViewRect.top;
                    object = this.mGridPoints;
                    n = n5 + 1;
                    object[n5] = this.mCropViewRect.width() * (f2 / (float)(this.mCropGridColumnCount + 1)) + this.mCropViewRect.left;
                    object = this.mGridPoints;
                    n3 = n + 1;
                    object[n] = this.mCropViewRect.bottom;
                }
            }
            if ((object = this.mGridPoints) != null) {
                canvas.drawLines(object, this.mCropGridPaint);
            }
        }
        if (this.mShowCropFrame) {
            canvas.drawRect(this.mCropViewRect, this.mCropFramePaint);
        }
        if (this.mFreestyleCropMode == 0) return;
        canvas.save();
        this.mTempRect.set(this.mCropViewRect);
        object = this.mTempRect;
        n = this.mCropRectCornerTouchAreaLineLength;
        object.inset((float)n, (float)(-n));
        canvas.clipRect(this.mTempRect, Region.Op.DIFFERENCE);
        this.mTempRect.set(this.mCropViewRect);
        object = this.mTempRect;
        n = this.mCropRectCornerTouchAreaLineLength;
        object.inset((float)(-n), (float)n);
        canvas.clipRect(this.mTempRect, Region.Op.DIFFERENCE);
        canvas.drawRect(this.mCropViewRect, this.mCropFrameCornersPaint);
        canvas.restore();
    }

    protected void drawDimmedLayer(Canvas canvas) {
        canvas.save();
        if (this.mCircleDimmedLayer) {
            canvas.clipPath(this.mCircularPath, Region.Op.DIFFERENCE);
        } else {
            canvas.clipRect(this.mCropViewRect, Region.Op.DIFFERENCE);
        }
        canvas.drawColor(this.mDimmedColor);
        canvas.restore();
        if (!this.mCircleDimmedLayer) return;
        canvas.drawCircle(this.mCropViewRect.centerX(), this.mCropViewRect.centerY(), Math.min(this.mCropViewRect.width(), this.mCropViewRect.height()) / 2.0f, this.mDimmedStrokePaint);
    }

    public RectF getCropViewRect() {
        return this.mCropViewRect;
    }

    public int getFreestyleCropMode() {
        return this.mFreestyleCropMode;
    }

    public OverlayViewChangeListener getOverlayViewChangeListener() {
        return this.mCallback;
    }

    protected void init() {
        if (Build.VERSION.SDK_INT >= 18) return;
        this.setLayerType(1, null);
    }

    public boolean isDragFrame() {
        return this.mIsDragFrame;
    }

    @Deprecated
    public boolean isFreestyleCropEnabled() {
        int n = this.mFreestyleCropMode;
        boolean bl = true;
        if (n == 1) return bl;
        bl = false;
        return bl;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.drawDimmedLayer(canvas);
        this.drawCropGrid(canvas);
    }

    protected void onLayout(boolean bl, int n, int n2, int n3, int n4) {
        super.onLayout(bl, n, n2, n3, n4);
        if (!bl) return;
        n = this.getPaddingLeft();
        n2 = this.getPaddingTop();
        n3 = this.getWidth();
        n4 = this.getPaddingRight();
        int n5 = this.getHeight();
        int n6 = this.getPaddingBottom();
        this.mThisWidth = n3 - n4 - n;
        this.mThisHeight = n5 - n6 - n2;
        if (!this.mShouldSetupCropBounds) return;
        this.mShouldSetupCropBounds = false;
        this.setTargetAspectRatio(this.mTargetAspectRatio);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean bl = this.mCropViewRect.isEmpty();
        boolean bl2 = false;
        if (bl) return false;
        if (this.mFreestyleCropMode == 0) return false;
        float f = motionEvent.getX();
        float f2 = motionEvent.getY();
        if ((motionEvent.getAction() & 0xFF) == 0) {
            int n;
            motionEvent = this.smoothAnimator;
            if (motionEvent != null) {
                motionEvent.cancel();
            }
            this.mCurrentTouchCornerIndex = n = this.getCurrentTouchIndex(f, f2);
            bl = bl2;
            if (n != -1) {
                bl = bl2;
                if (n != 4) {
                    bl = true;
                }
            }
            if (!bl) {
                this.mPreviousTouchX = -1.0f;
                this.mPreviousTouchY = -1.0f;
            } else {
                if (!(this.mPreviousTouchX < 0.0f)) return bl;
                this.mPreviousTouchX = f;
                this.mPreviousTouchY = f2;
            }
            return bl;
        }
        if ((motionEvent.getAction() & 0xFF) == 2 && motionEvent.getPointerCount() == 1 && this.mCurrentTouchCornerIndex != -1) {
            f = Math.min(Math.max(f, (float)this.getPaddingLeft()), (float)(this.getWidth() - this.getPaddingRight()));
            f2 = Math.min(Math.max(f2, (float)this.getPaddingTop()), (float)(this.getHeight() - this.getPaddingBottom()));
            this.updateCropViewRect(f, f2);
            this.mPreviousTouchX = f;
            this.mPreviousTouchY = f2;
            return true;
        }
        if ((motionEvent.getAction() & 0xFF) != 1) return false;
        this.mPreviousTouchX = -1.0f;
        this.mPreviousTouchY = -1.0f;
        this.mCurrentTouchCornerIndex = -1;
        motionEvent = this.mCallback;
        if (motionEvent != null) {
            motionEvent.onCropRectUpdated(this.mCropViewRect);
        }
        this.smoothToCenter();
        return false;
    }

    protected void processStyledAttributes(TypedArray typedArray) {
        this.mCircleDimmedLayer = typedArray.getBoolean(R.styleable.ucrop_UCropView_ucrop_circle_dimmed_layer, false);
        this.mDimmedColor = typedArray.getColor(R.styleable.ucrop_UCropView_ucrop_dimmed_color, this.getResources().getColor(R.color.ucrop_color_default_dimmed));
        this.mDimmedStrokePaint.setColor(this.mDimmedBorderColor);
        this.mDimmedStrokePaint.setStyle(Paint.Style.STROKE);
        this.mDimmedStrokePaint.setStrokeWidth((float)this.mStrokeWidth);
        this.initCropFrameStyle(typedArray);
        this.mShowCropFrame = typedArray.getBoolean(R.styleable.ucrop_UCropView_ucrop_show_frame, true);
        this.initCropGridStyle(typedArray);
        this.mShowCropGrid = typedArray.getBoolean(R.styleable.ucrop_UCropView_ucrop_show_grid, true);
    }

    public void setCircleDimmedLayer(boolean bl) {
        this.mCircleDimmedLayer = bl;
    }

    public void setCropFrameColor(int n) {
        this.mCropFramePaint.setColor(n);
    }

    public void setCropFrameStrokeWidth(int n) {
        this.mCropFramePaint.setStrokeWidth((float)n);
    }

    public void setCropGridColor(int n) {
        this.mCropGridPaint.setColor(n);
    }

    public void setCropGridColumnCount(int n) {
        this.mCropGridColumnCount = n;
        this.mGridPoints = null;
    }

    public void setCropGridRowCount(int n) {
        this.mCropGridRowCount = n;
        this.mGridPoints = null;
    }

    public void setCropGridStrokeWidth(int n) {
        this.mCropGridPaint.setStrokeWidth((float)n);
    }

    public void setDimmedBorderColor(int n) {
        this.mDimmedBorderColor = n;
        Paint paint = this.mDimmedStrokePaint;
        if (paint == null) return;
        paint.setColor(n);
    }

    public void setDimmedColor(int n) {
        this.mDimmedColor = n;
    }

    public void setDimmedStrokeWidth(int n) {
        this.mStrokeWidth = n;
        Paint paint = this.mDimmedStrokePaint;
        if (paint == null) return;
        paint.setStrokeWidth((float)n);
    }

    public void setDragFrame(boolean bl) {
        this.mIsDragFrame = bl;
    }

    @Deprecated
    public void setFreestyleCropEnabled(boolean bl) {
        this.mFreestyleCropMode = bl ? 1 : 0;
    }

    public void setFreestyleCropMode(int n) {
        this.mFreestyleCropMode = n;
        this.postInvalidate();
    }

    public void setOverlayViewChangeListener(OverlayViewChangeListener overlayViewChangeListener) {
        this.mCallback = overlayViewChangeListener;
    }

    public void setShowCropFrame(boolean bl) {
        this.mShowCropFrame = bl;
    }

    public void setShowCropGrid(boolean bl) {
        this.mShowCropGrid = bl;
    }

    public void setTargetAspectRatio(float f) {
        this.mTargetAspectRatio = f;
        if (this.mThisWidth > 0) {
            this.setupCropBounds();
            this.postInvalidate();
        } else {
            this.mShouldSetupCropBounds = true;
        }
    }

    public void setupCropBounds() {
        int n = this.mThisWidth;
        float f = n;
        float f2 = this.mTargetAspectRatio;
        int n2 = (int)(f / f2);
        int n3 = this.mThisHeight;
        if (n2 > n3) {
            n2 = (int)((float)n3 * f2);
            n = (n - n2) / 2;
            this.mCropViewRect.set((float)(this.getPaddingLeft() + n), (float)this.getPaddingTop(), (float)(this.getPaddingLeft() + n2 + n), (float)(this.getPaddingTop() + this.mThisHeight));
        } else {
            n = (n3 - n2) / 2;
            this.mCropViewRect.set((float)this.getPaddingLeft(), (float)(this.getPaddingTop() + n), (float)(this.getPaddingLeft() + this.mThisWidth), (float)(this.getPaddingTop() + n2 + n));
        }
        OverlayViewChangeListener overlayViewChangeListener = this.mCallback;
        if (overlayViewChangeListener != null) {
            overlayViewChangeListener.onCropRectUpdated(this.mCropViewRect);
        }
        this.updateGridPoints();
    }
}
