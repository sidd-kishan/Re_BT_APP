/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.LinearGradient
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.Path
 *  android.graphics.Path$FillType
 *  android.graphics.RadialGradient
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.Shader
 *  android.graphics.Shader$TileMode
 *  android.graphics.drawable.Drawable
 *  androidx.cardview.R$color
 *  androidx.cardview.R$dimen
 *  androidx.cardview.widget.RoundRectDrawableWithShadow$RoundRectHelper
 */
package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.cardview.R;
import androidx.cardview.widget.RoundRectDrawableWithShadow;

class RoundRectDrawableWithShadow
extends Drawable {
    private static final double COS_45 = Math.cos(Math.toRadians(45.0));
    private static final float SHADOW_MULTIPLIER = 1.5f;
    static RoundRectHelper sRoundRectHelper;
    private boolean mAddPaddingForCorners = true;
    private ColorStateList mBackground;
    private final RectF mCardBounds;
    private float mCornerRadius;
    private Paint mCornerShadowPaint;
    private Path mCornerShadowPath;
    private boolean mDirty = true;
    private Paint mEdgeShadowPaint;
    private final int mInsetShadow;
    private Paint mPaint;
    private boolean mPrintedShadowClipWarning = false;
    private float mRawMaxShadowSize;
    private float mRawShadowSize;
    private final int mShadowEndColor;
    private float mShadowSize;
    private final int mShadowStartColor;

    RoundRectDrawableWithShadow(Resources resources, ColorStateList colorStateList, float f, float f2, float f3) {
        this.mShadowStartColor = resources.getColor(R.color.cardview_shadow_start_color);
        this.mShadowEndColor = resources.getColor(R.color.cardview_shadow_end_color);
        this.mInsetShadow = resources.getDimensionPixelSize(R.dimen.cardview_compat_inset_shadow);
        this.mPaint = new Paint(5);
        this.setBackground(colorStateList);
        resources = new Paint(5);
        this.mCornerShadowPaint = resources;
        resources.setStyle(Paint.Style.FILL);
        this.mCornerRadius = (int)(f + 0.5f);
        this.mCardBounds = new RectF();
        resources = new Paint(this.mCornerShadowPaint);
        this.mEdgeShadowPaint = resources;
        resources.setAntiAlias(false);
        this.setShadowSize(f2, f3);
    }

    private void buildComponents(Rect rect) {
        float f = this.mRawMaxShadowSize * 1.5f;
        this.mCardBounds.set((float)rect.left + this.mRawMaxShadowSize, (float)rect.top + f, (float)rect.right - this.mRawMaxShadowSize, (float)rect.bottom - f);
        this.buildShadowCorners();
    }

    private void buildShadowCorners() {
        float f = this.mCornerRadius;
        RectF rectF = new RectF(-f, -f, f, f);
        RectF rectF2 = new RectF(rectF);
        f = this.mShadowSize;
        rectF2.inset(-f, -f);
        Path path = this.mCornerShadowPath;
        if (path == null) {
            this.mCornerShadowPath = new Path();
        } else {
            path.reset();
        }
        this.mCornerShadowPath.setFillType(Path.FillType.EVEN_ODD);
        this.mCornerShadowPath.moveTo(-this.mCornerRadius, 0.0f);
        this.mCornerShadowPath.rLineTo(-this.mShadowSize, 0.0f);
        this.mCornerShadowPath.arcTo(rectF2, 180.0f, 90.0f, false);
        this.mCornerShadowPath.arcTo(rectF, 270.0f, -90.0f, false);
        this.mCornerShadowPath.close();
        f = this.mCornerRadius;
        float f2 = f / (this.mShadowSize + f);
        path = this.mCornerShadowPaint;
        float f3 = this.mCornerRadius;
        f = this.mShadowSize;
        int n = this.mShadowStartColor;
        int n2 = this.mShadowEndColor;
        rectF = Shader.TileMode.CLAMP;
        path.setShader((Shader)new RadialGradient(0.0f, 0.0f, f3 + f, new int[]{n, n, n2}, new float[]{0.0f, f2, 1.0f}, (Shader.TileMode)rectF));
        rectF = this.mEdgeShadowPaint;
        f3 = this.mCornerRadius;
        f2 = -f3;
        f = this.mShadowSize;
        f3 = -f3;
        n = this.mShadowStartColor;
        n2 = this.mShadowEndColor;
        path = Shader.TileMode.CLAMP;
        rectF.setShader((Shader)new LinearGradient(0.0f, f2 + f, 0.0f, f3 - f, new int[]{n, n, n2}, new float[]{0.0f, 0.5f, 1.0f}, (Shader.TileMode)path));
        this.mEdgeShadowPaint.setAntiAlias(false);
    }

    static float calculateHorizontalPadding(float f, float f2, boolean bl) {
        float f3 = f;
        if (!bl) return f3;
        double d = f;
        double d2 = COS_45;
        double d3 = f2;
        Double.isNaN(d3);
        Double.isNaN(d);
        f3 = (float)(d + (1.0 - d2) * d3);
        return f3;
    }

    static float calculateVerticalPadding(float f, float f2, boolean bl) {
        if (!bl) return f * 1.5f;
        double d = f * 1.5f;
        double d2 = COS_45;
        double d3 = f2;
        Double.isNaN(d3);
        Double.isNaN(d);
        return (float)(d + (1.0 - d2) * d3);
    }

    private void drawShadow(Canvas canvas) {
        float f = this.mCornerRadius;
        float f2 = -f - this.mShadowSize;
        float f3 = f + (float)this.mInsetShadow + this.mRawShadowSize / 2.0f;
        float f4 = this.mCardBounds.width();
        int n = f4 - (f = f3 * 2.0f) > 0.0f ? 1 : 0;
        boolean bl = this.mCardBounds.height() - f > 0.0f;
        int n2 = canvas.save();
        canvas.translate(this.mCardBounds.left + f3, this.mCardBounds.top + f3);
        canvas.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
        if (n != 0) {
            canvas.drawRect(0.0f, f2, this.mCardBounds.width() - f, -this.mCornerRadius, this.mEdgeShadowPaint);
        }
        canvas.restoreToCount(n2);
        n2 = canvas.save();
        canvas.translate(this.mCardBounds.right - f3, this.mCardBounds.bottom - f3);
        canvas.rotate(180.0f);
        canvas.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
        if (n != 0) {
            canvas.drawRect(0.0f, f2, this.mCardBounds.width() - f, -this.mCornerRadius + this.mShadowSize, this.mEdgeShadowPaint);
        }
        canvas.restoreToCount(n2);
        n = canvas.save();
        canvas.translate(this.mCardBounds.left + f3, this.mCardBounds.bottom - f3);
        canvas.rotate(270.0f);
        canvas.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
        if (bl) {
            canvas.drawRect(0.0f, f2, this.mCardBounds.height() - f, -this.mCornerRadius, this.mEdgeShadowPaint);
        }
        canvas.restoreToCount(n);
        n = canvas.save();
        canvas.translate(this.mCardBounds.right - f3, this.mCardBounds.top + f3);
        canvas.rotate(90.0f);
        canvas.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
        if (bl) {
            canvas.drawRect(0.0f, f2, this.mCardBounds.height() - f, -this.mCornerRadius, this.mEdgeShadowPaint);
        }
        canvas.restoreToCount(n);
    }

    private void setBackground(ColorStateList colorStateList) {
        ColorStateList colorStateList2 = colorStateList;
        if (colorStateList == null) {
            colorStateList2 = ColorStateList.valueOf((int)0);
        }
        this.mBackground = colorStateList2;
        this.mPaint.setColor(colorStateList2.getColorForState(this.getState(), this.mBackground.getDefaultColor()));
    }

    private void setShadowSize(float f, float f2) {
        if (f < 0.0f) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid shadow size ");
            stringBuilder.append(f);
            stringBuilder.append(". Must be >= 0");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        if (f2 < 0.0f) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid max shadow size ");
            stringBuilder.append(f2);
            stringBuilder.append(". Must be >= 0");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        float f3 = this.toEven(f);
        f2 = this.toEven(f2);
        f = f3;
        if (f3 > f2) {
            if (!this.mPrintedShadowClipWarning) {
                this.mPrintedShadowClipWarning = true;
            }
            f = f2;
        }
        if (this.mRawShadowSize == f && this.mRawMaxShadowSize == f2) {
            return;
        }
        this.mRawShadowSize = f;
        this.mRawMaxShadowSize = f2;
        this.mShadowSize = (int)(f * 1.5f + (float)this.mInsetShadow + 0.5f);
        this.mDirty = true;
        this.invalidateSelf();
    }

    private int toEven(float f) {
        int n;
        int n2 = n = (int)(f + 0.5f);
        if (n % 2 != 1) return n2;
        n2 = n - 1;
        return n2;
    }

    public void draw(Canvas canvas) {
        if (this.mDirty) {
            this.buildComponents(this.getBounds());
            this.mDirty = false;
        }
        canvas.translate(0.0f, this.mRawShadowSize / 2.0f);
        this.drawShadow(canvas);
        canvas.translate(0.0f, -this.mRawShadowSize / 2.0f);
        sRoundRectHelper.drawRoundRect(canvas, this.mCardBounds, this.mCornerRadius, this.mPaint);
    }

    ColorStateList getColor() {
        return this.mBackground;
    }

    float getCornerRadius() {
        return this.mCornerRadius;
    }

    void getMaxShadowAndCornerPadding(Rect rect) {
        this.getPadding(rect);
    }

    float getMaxShadowSize() {
        return this.mRawMaxShadowSize;
    }

    float getMinHeight() {
        float f = this.mRawMaxShadowSize;
        return Math.max(f, this.mCornerRadius + (float)this.mInsetShadow + f * 1.5f / 2.0f) * 2.0f + (this.mRawMaxShadowSize * 1.5f + (float)this.mInsetShadow) * 2.0f;
    }

    float getMinWidth() {
        float f = this.mRawMaxShadowSize;
        return Math.max(f, this.mCornerRadius + (float)this.mInsetShadow + f / 2.0f) * 2.0f + (this.mRawMaxShadowSize + (float)this.mInsetShadow) * 2.0f;
    }

    public int getOpacity() {
        return -3;
    }

    public boolean getPadding(Rect rect) {
        int n = (int)Math.ceil(RoundRectDrawableWithShadow.calculateVerticalPadding(this.mRawMaxShadowSize, this.mCornerRadius, this.mAddPaddingForCorners));
        int n2 = (int)Math.ceil(RoundRectDrawableWithShadow.calculateHorizontalPadding(this.mRawMaxShadowSize, this.mCornerRadius, this.mAddPaddingForCorners));
        rect.set(n2, n, n2, n);
        return true;
    }

    float getShadowSize() {
        return this.mRawShadowSize;
    }

    public boolean isStateful() {
        ColorStateList colorStateList = this.mBackground;
        boolean bl = colorStateList != null && colorStateList.isStateful() || super.isStateful();
        return bl;
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.mDirty = true;
    }

    protected boolean onStateChange(int[] nArray) {
        ColorStateList colorStateList = this.mBackground;
        int n = colorStateList.getColorForState(nArray, colorStateList.getDefaultColor());
        if (this.mPaint.getColor() == n) {
            return false;
        }
        this.mPaint.setColor(n);
        this.mDirty = true;
        this.invalidateSelf();
        return true;
    }

    void setAddPaddingForCorners(boolean bl) {
        this.mAddPaddingForCorners = bl;
        this.invalidateSelf();
    }

    public void setAlpha(int n) {
        this.mPaint.setAlpha(n);
        this.mCornerShadowPaint.setAlpha(n);
        this.mEdgeShadowPaint.setAlpha(n);
    }

    void setColor(ColorStateList colorStateList) {
        this.setBackground(colorStateList);
        this.invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    void setCornerRadius(float f) {
        if (f < 0.0f) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid radius ");
            stringBuilder.append(f);
            stringBuilder.append(". Must be >= 0");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        if (this.mCornerRadius == (f = (float)((int)(f + 0.5f)))) {
            return;
        }
        this.mCornerRadius = f;
        this.mDirty = true;
        this.invalidateSelf();
    }

    void setMaxShadowSize(float f) {
        this.setShadowSize(this.mRawShadowSize, f);
    }

    void setShadowSize(float f) {
        this.setShadowSize(f, this.mRawMaxShadowSize);
    }
}
