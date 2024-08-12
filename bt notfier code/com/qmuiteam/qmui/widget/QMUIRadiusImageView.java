/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.BitmapShader
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.Matrix
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffColorFilter
 *  android.graphics.RectF
 *  android.graphics.Shader
 *  android.graphics.Shader$TileMode
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.view.MotionEvent
 *  android.view.View$MeasureSpec
 *  android.widget.ImageView$ScaleType
 *  androidx.appcompat.widget.AppCompatImageView
 *  com.qmuiteam.qmui.R$attr
 *  com.qmuiteam.qmui.R$styleable
 */
package com.qmuiteam.qmui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.qmuiteam.qmui.R;

public class QMUIRadiusImageView
extends AppCompatImageView {
    private static final Bitmap.Config BITMAP_CONFIG = Bitmap.Config.ARGB_8888;
    private static final int COLOR_DRAWABLE_DIMEN = 2;
    private static final int DEFAULT_BORDER_COLOR = -7829368;
    private Bitmap mBitmap;
    private Paint mBitmapPaint;
    private BitmapShader mBitmapShader;
    private int mBorderColor;
    private Paint mBorderPaint;
    private int mBorderWidth;
    private ColorFilter mColorFilter;
    private int mCornerRadius;
    private RectF mDrawRectF;
    private int mHeight;
    private boolean mIsCircle = false;
    private boolean mIsOval = false;
    private boolean mIsSelected = false;
    private boolean mIsTouchSelectModeEnabled = true;
    private ImageView.ScaleType mLastCalculateScaleType;
    private Matrix mMatrix;
    private boolean mNeedResetShader = false;
    private RectF mRectF = new RectF();
    private int mSelectedBorderColor;
    private int mSelectedBorderWidth;
    private ColorFilter mSelectedColorFilter;
    private int mSelectedMaskColor;
    private int mWidth;

    public QMUIRadiusImageView(Context context) {
        this(context, null, R.attr.QMUIRadiusImageViewStyle);
    }

    public QMUIRadiusImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.QMUIRadiusImageViewStyle);
    }

    public QMUIRadiusImageView(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        boolean bl;
        Paint paint;
        this.mDrawRectF = new RectF();
        this.mBorderPaint = paint = new Paint();
        paint.setAntiAlias(true);
        this.mBorderPaint.setStyle(Paint.Style.STROKE);
        this.mMatrix = new Matrix();
        this.setScaleType(ImageView.ScaleType.CENTER_CROP);
        context = context.obtainStyledAttributes(attributeSet, R.styleable.QMUIRadiusImageView, n, 0);
        this.mBorderWidth = context.getDimensionPixelSize(R.styleable.QMUIRadiusImageView_qmui_border_width, 0);
        this.mBorderColor = context.getColor(R.styleable.QMUIRadiusImageView_qmui_border_color, -7829368);
        this.mSelectedBorderWidth = context.getDimensionPixelSize(R.styleable.QMUIRadiusImageView_qmui_selected_border_width, this.mBorderWidth);
        this.mSelectedBorderColor = context.getColor(R.styleable.QMUIRadiusImageView_qmui_selected_border_color, this.mBorderColor);
        this.mSelectedMaskColor = n = context.getColor(R.styleable.QMUIRadiusImageView_qmui_selected_mask_color, 0);
        if (n != 0) {
            this.mSelectedColorFilter = new PorterDuffColorFilter(this.mSelectedMaskColor, PorterDuff.Mode.DARKEN);
        }
        this.mIsTouchSelectModeEnabled = context.getBoolean(R.styleable.QMUIRadiusImageView_qmui_is_touch_select_mode_enabled, true);
        this.mIsCircle = bl = context.getBoolean(R.styleable.QMUIRadiusImageView_qmui_is_circle, false);
        if (!bl) {
            this.mIsOval = context.getBoolean(R.styleable.QMUIRadiusImageView_qmui_is_oval, false);
        }
        if (!this.mIsOval) {
            this.mCornerRadius = context.getDimensionPixelSize(R.styleable.QMUIRadiusImageView_qmui_corner_radius, 0);
        }
        context.recycle();
    }

    private void drawBitmap(Canvas canvas, int n) {
        float f = (float)n * 1.0f / 2.0f;
        Paint paint = this.mBitmapPaint;
        ColorFilter colorFilter = this.mIsSelected ? this.mSelectedColorFilter : this.mColorFilter;
        paint.setColorFilter(colorFilter);
        if (this.mIsCircle) {
            canvas.drawCircle(this.mRectF.centerX(), this.mRectF.centerY(), Math.min(this.mRectF.width() / 2.0f, this.mRectF.height() / 2.0f) - f, this.mBitmapPaint);
        } else {
            this.mDrawRectF.left = this.mRectF.left + f;
            this.mDrawRectF.top = this.mRectF.top + f;
            this.mDrawRectF.right = this.mRectF.right - f;
            this.mDrawRectF.bottom = this.mRectF.bottom - f;
            if (this.mIsOval) {
                canvas.drawOval(this.mDrawRectF, this.mBitmapPaint);
            } else {
                colorFilter = this.mDrawRectF;
                n = this.mCornerRadius;
                canvas.drawRoundRect((RectF)colorFilter, (float)n, (float)n, this.mBitmapPaint);
            }
        }
    }

    private void drawBorder(Canvas canvas, int n) {
        if (n <= 0) {
            return;
        }
        float f = n;
        float f2 = 1.0f * f / 2.0f;
        Paint paint = this.mBorderPaint;
        n = this.mIsSelected ? this.mSelectedBorderColor : this.mBorderColor;
        paint.setColor(n);
        this.mBorderPaint.setStrokeWidth(f);
        if (this.mIsCircle) {
            canvas.drawCircle(this.mRectF.centerX(), this.mRectF.centerY(), Math.min(this.mRectF.width(), this.mRectF.height()) - f2, this.mBorderPaint);
        } else {
            this.mDrawRectF.left = this.mRectF.left + f2;
            this.mDrawRectF.top = this.mRectF.top + f2;
            this.mDrawRectF.right = this.mRectF.right - f2;
            this.mDrawRectF.bottom = this.mRectF.bottom - f2;
            if (this.mIsOval) {
                canvas.drawOval(this.mDrawRectF, this.mBorderPaint);
            } else {
                paint = this.mDrawRectF;
                n = this.mCornerRadius;
                canvas.drawRoundRect((RectF)paint, (float)n, (float)n, this.mBorderPaint);
            }
        }
    }

    private Bitmap getBitmap() {
        Drawable drawable = this.getDrawable();
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable)drawable).getBitmap();
            if (bitmap == null) {
                return null;
            }
            float f = bitmap.getWidth();
            float f2 = bitmap.getHeight();
            if (f == 0.0f) return null;
            if (f2 == 0.0f) {
                return null;
            }
            if (Build.VERSION.SDK_INT < 16) return bitmap;
            float f3 = (float)this.getMinimumWidth() / f;
            float f4 = (float)this.getMinimumHeight() / f2;
            if (!(f3 > 1.0f)) {
                if (!(f4 > 1.0f)) return bitmap;
            }
            f4 = Math.max(f3, f4);
            drawable = new Matrix();
            drawable.postScale(f4, f4);
            return Bitmap.createBitmap((Bitmap)bitmap, (int)0, (int)0, (int)((int)f), (int)((int)f2), (Matrix)drawable, (boolean)false);
        }
        try {
            Bitmap bitmap = drawable instanceof ColorDrawable ? Bitmap.createBitmap((int)2, (int)2, (Bitmap.Config)BITMAP_CONFIG) : Bitmap.createBitmap((int)drawable.getIntrinsicWidth(), (int)drawable.getIntrinsicHeight(), (Bitmap.Config)BITMAP_CONFIG);
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return bitmap;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    private void updateBitmapShader() {
        this.mMatrix.reset();
        this.mNeedResetShader = false;
        if (this.mBitmapShader == null) return;
        Bitmap bitmap = this.mBitmap;
        if (bitmap == null) return;
        this.updateMatrix(this.mMatrix, bitmap, this.mRectF);
        this.mBitmapShader.setLocalMatrix(this.mMatrix);
        this.mBitmapPaint.setShader((Shader)this.mBitmapShader);
    }

    private void updateMatrix(Matrix matrix, Bitmap bitmap, RectF rectF) {
        float f = bitmap.getWidth();
        float f2 = bitmap.getHeight();
        ImageView.ScaleType scaleType = this.getScaleType();
        if (scaleType == ImageView.ScaleType.MATRIX) {
            this.updateScaleTypeMatrix(matrix, bitmap, rectF);
        } else if (scaleType == ImageView.ScaleType.CENTER) {
            float f3 = ((float)this.mWidth - f) / 2.0f;
            float f4 = ((float)this.mHeight - f2) / 2.0f;
            matrix.postTranslate(f3, f4);
            rectF.set(Math.max(0.0f, f3), Math.max(0.0f, f4), Math.min(f3 + f, (float)this.mWidth), Math.min(f4 + f2, (float)this.mHeight));
        } else if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            float f5 = Math.max((float)this.mWidth / f, (float)this.mHeight / f2);
            matrix.setScale(f5, f5);
            matrix.postTranslate(-(f * f5 - (float)this.mWidth) / 2.0f, -(f5 * f2 - (float)this.mHeight) / 2.0f);
            rectF.set(0.0f, 0.0f, (float)this.mWidth, (float)this.mHeight);
        } else if (scaleType == ImageView.ScaleType.CENTER_INSIDE) {
            int n = this.mWidth;
            float f6 = (float)n / f;
            int n2 = this.mHeight;
            float f7 = (float)n2 / f2;
            if (f6 >= 1.0f && f7 >= 1.0f) {
                f6 = ((float)n - f) / 2.0f;
                f7 = ((float)n2 - f2) / 2.0f;
                matrix.postTranslate(f6, f7);
                rectF.set(f6, f7, f + f6, f2 + f7);
            } else {
                f6 = Math.min(f6, f7);
                matrix.setScale(f6, f6);
                f2 *= f6;
                f7 = ((float)this.mWidth - (f *= f6)) / 2.0f;
                f6 = ((float)this.mHeight - f2) / 2.0f;
                matrix.postTranslate(f7, f6);
                rectF.set(f7, f6, f + f7, f2 + f6);
            }
        } else if (scaleType == ImageView.ScaleType.FIT_XY) {
            matrix.setScale((float)this.mWidth / f, (float)this.mHeight / f2);
            rectF.set(0.0f, 0.0f, (float)this.mWidth, (float)this.mHeight);
        } else {
            float f8 = Math.min((float)this.mWidth / f, (float)this.mHeight / f2);
            matrix.setScale(f8, f8);
            f *= f8;
            f2 *= f8;
            if (scaleType == ImageView.ScaleType.FIT_START) {
                rectF.set(0.0f, 0.0f, f, f2);
            } else if (scaleType == ImageView.ScaleType.FIT_CENTER) {
                f8 = ((float)this.mWidth - f) / 2.0f;
                float f9 = ((float)this.mHeight - f2) / 2.0f;
                matrix.postTranslate(f8, f9);
                rectF.set(f8, f9, f + f8, f2 + f9);
            } else {
                matrix.postTranslate((float)this.mWidth - f, (float)this.mHeight - f2);
                int n = this.mWidth;
                f8 = n;
                int n3 = this.mHeight;
                rectF.set(f8 - f, (float)n3 - f2, (float)n, (float)n3);
            }
        }
    }

    public int getBorderColor() {
        return this.mBorderColor;
    }

    public int getBorderWidth() {
        return this.mBorderWidth;
    }

    public int getCornerRadius() {
        return this.mCornerRadius;
    }

    public int getSelectedBorderColor() {
        return this.mSelectedBorderColor;
    }

    public int getSelectedBorderWidth() {
        return this.mSelectedBorderWidth;
    }

    public int getSelectedMaskColor() {
        return this.mSelectedMaskColor;
    }

    public boolean isCircle() {
        return this.mIsCircle;
    }

    public boolean isOval() {
        boolean bl = !this.mIsCircle && this.mIsOval;
        return bl;
    }

    public boolean isSelected() {
        return this.mIsSelected;
    }

    public boolean isTouchSelectModeEnabled() {
        return this.mIsTouchSelectModeEnabled;
    }

    protected void onDraw(Canvas canvas) {
        int n = this.getWidth();
        int n2 = this.getHeight();
        if (n <= 0) return;
        if (n2 <= 0) return;
        int n3 = this.mIsSelected ? this.mSelectedBorderWidth : this.mBorderWidth;
        if (this.mBitmap != null && this.mBitmapShader != null) {
            if (this.mWidth != n || this.mHeight != n2 || this.mLastCalculateScaleType != this.getScaleType() || this.mNeedResetShader) {
                this.mWidth = n;
                this.mHeight = n2;
                this.mLastCalculateScaleType = this.getScaleType();
                this.updateBitmapShader();
            }
            this.drawBitmap(canvas, n3);
            this.drawBorder(canvas, n3);
            return;
        }
        this.drawBorder(canvas, n3);
    }

    protected void onMeasure(int n, int n2) {
        int n3 = View.MeasureSpec.getMode((int)n);
        int n4 = View.MeasureSpec.getMode((int)n2);
        int n5 = View.MeasureSpec.getSize((int)n);
        int n6 = View.MeasureSpec.getSize((int)n2);
        if (n3 == 0x40000000 && n4 == 0x40000000) {
            this.setMeasuredDimension(n5, n6);
            return;
        }
        if (!this.mIsCircle) {
            super.onMeasure(n, n2);
            return;
        }
        if (n3 == 0x40000000) {
            this.setMeasuredDimension(n5, n5);
        } else if (n4 == 0x40000000) {
            this.setMeasuredDimension(n6, n6);
        } else {
            Bitmap bitmap = this.mBitmap;
            if (bitmap == null) {
                this.setMeasuredDimension(0, 0);
            } else {
                n = Math.min(Math.min(bitmap.getWidth(), n5), Math.min(this.mBitmap.getHeight(), n6));
                this.setMeasuredDimension(n, n);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.isClickable()) {
            this.setSelected(false);
            return super.onTouchEvent(motionEvent);
        }
        if (!this.mIsTouchSelectModeEnabled) {
            return super.onTouchEvent(motionEvent);
        }
        int n = motionEvent.getAction();
        if (n != 0) {
            if (n != 1 && n != 3 && n != 4 && n != 8) return super.onTouchEvent(motionEvent);
            this.setSelected(false);
        } else {
            this.setSelected(true);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setAdjustViewBounds(boolean bl) {
        if (bl) throw new IllegalArgumentException("\u4e0d\u652f\u6301adjustViewBounds");
    }

    public void setBorderColor(int n) {
        if (this.mBorderColor == n) return;
        this.mBorderColor = n;
        this.invalidate();
    }

    public void setBorderWidth(int n) {
        if (this.mBorderWidth == n) return;
        this.mBorderWidth = n;
        this.invalidate();
    }

    public void setCircle(boolean bl) {
        if (this.mIsCircle == bl) return;
        this.mIsCircle = bl;
        this.requestLayout();
        this.invalidate();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.mColorFilter == colorFilter) {
            return;
        }
        this.mColorFilter = colorFilter;
        if (this.mIsSelected) return;
        this.invalidate();
    }

    public void setCornerRadius(int n) {
        if (this.mCornerRadius == n) return;
        this.mCornerRadius = n;
        if (this.mIsCircle) return;
        if (this.mIsOval) return;
        this.invalidate();
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        this.setupBitmap();
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        this.setupBitmap();
    }

    public void setOval(boolean bl) {
        boolean bl2;
        boolean bl3 = bl2 = false;
        if (bl) {
            bl3 = bl2;
            if (this.mIsCircle) {
                this.mIsCircle = false;
                bl3 = true;
            }
        }
        if (this.mIsOval == bl) {
            if (!bl3) return;
        }
        this.mIsOval = bl;
        this.requestLayout();
        this.invalidate();
    }

    public void setSelected(boolean bl) {
        if (this.mIsSelected == bl) return;
        this.mIsSelected = bl;
        this.invalidate();
    }

    public void setSelectedBorderColor(int n) {
        if (this.mSelectedBorderColor == n) return;
        this.mSelectedBorderColor = n;
        if (!this.mIsSelected) return;
        this.invalidate();
    }

    public void setSelectedBorderWidth(int n) {
        if (this.mSelectedBorderWidth == n) return;
        this.mSelectedBorderWidth = n;
        if (!this.mIsSelected) return;
        this.invalidate();
    }

    public void setSelectedColorFilter(ColorFilter colorFilter) {
        if (this.mSelectedColorFilter == colorFilter) {
            return;
        }
        this.mSelectedColorFilter = colorFilter;
        if (!this.mIsSelected) return;
        this.invalidate();
    }

    public void setSelectedMaskColor(int n) {
        if (this.mSelectedMaskColor != n) {
            this.mSelectedMaskColor = n;
            this.mSelectedColorFilter = n != 0 ? new PorterDuffColorFilter(this.mSelectedMaskColor, PorterDuff.Mode.DARKEN) : null;
            if (this.mIsSelected) {
                this.invalidate();
            }
        }
        this.mSelectedMaskColor = n;
    }

    public void setTouchSelectModeEnabled(boolean bl) {
        this.mIsTouchSelectModeEnabled = bl;
    }

    public void setupBitmap() {
        Bitmap bitmap = this.getBitmap();
        if (bitmap == this.mBitmap) {
            return;
        }
        this.mBitmap = bitmap;
        if (bitmap == null) {
            this.mBitmapShader = null;
            this.invalidate();
            return;
        }
        this.mNeedResetShader = true;
        this.mBitmapShader = new BitmapShader(this.mBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        if (this.mBitmapPaint == null) {
            bitmap = new Paint();
            this.mBitmapPaint = bitmap;
            bitmap.setAntiAlias(true);
        }
        this.mBitmapPaint.setShader((Shader)this.mBitmapShader);
        this.requestLayout();
        this.invalidate();
    }

    protected void updateScaleTypeMatrix(Matrix matrix, Bitmap bitmap, RectF rectF) {
        matrix.set(this.getImageMatrix());
        rectF.set(0.0f, 0.0f, (float)this.mWidth, (float)this.mHeight);
    }
}
