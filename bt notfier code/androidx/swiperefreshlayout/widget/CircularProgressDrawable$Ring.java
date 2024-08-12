/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.Paint
 *  android.graphics.Paint$Cap
 *  android.graphics.Paint$Style
 *  android.graphics.Path
 *  android.graphics.Path$FillType
 *  android.graphics.Rect
 *  android.graphics.RectF
 */
package androidx.swiperefreshlayout.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;

private static class CircularProgressDrawable.Ring {
    int mAlpha = 255;
    Path mArrow;
    int mArrowHeight;
    final Paint mArrowPaint;
    float mArrowScale = 1.0f;
    int mArrowWidth;
    final Paint mCirclePaint;
    int mColorIndex;
    int[] mColors;
    int mCurrentColor;
    float mEndTrim = 0.0f;
    final Paint mPaint;
    float mRingCenterRadius;
    float mRotation = 0.0f;
    boolean mShowArrow;
    float mStartTrim = 0.0f;
    float mStartingEndTrim;
    float mStartingRotation;
    float mStartingStartTrim;
    float mStrokeWidth = 5.0f;
    final RectF mTempBounds = new RectF();

    CircularProgressDrawable.Ring() {
        this.mPaint = new Paint();
        this.mArrowPaint = new Paint();
        this.mCirclePaint = new Paint();
        this.mPaint.setStrokeCap(Paint.Cap.SQUARE);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mArrowPaint.setStyle(Paint.Style.FILL);
        this.mArrowPaint.setAntiAlias(true);
        this.mCirclePaint.setColor(0);
    }

    void draw(Canvas canvas, Rect rect) {
        RectF rectF = this.mTempBounds;
        float f = this.mRingCenterRadius;
        float f2 = this.mStrokeWidth / 2.0f + f;
        if (f <= 0.0f) {
            f2 = (float)Math.min(rect.width(), rect.height()) / 2.0f - Math.max((float)this.mArrowWidth * this.mArrowScale / 2.0f, this.mStrokeWidth / 2.0f);
        }
        rectF.set((float)rect.centerX() - f2, (float)rect.centerY() - f2, (float)rect.centerX() + f2, (float)rect.centerY() + f2);
        f2 = this.mStartTrim;
        f = this.mRotation;
        f2 = (f2 + f) * 360.0f;
        f = (this.mEndTrim + f) * 360.0f - f2;
        this.mPaint.setColor(this.mCurrentColor);
        this.mPaint.setAlpha(this.mAlpha);
        float f3 = this.mStrokeWidth / 2.0f;
        rectF.inset(f3, f3);
        canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, this.mCirclePaint);
        f3 = -f3;
        rectF.inset(f3, f3);
        canvas.drawArc(rectF, f2, f, false, this.mPaint);
        this.drawTriangle(canvas, f2, f, rectF);
    }

    void drawTriangle(Canvas canvas, float f, float f2, RectF rectF) {
        if (!this.mShowArrow) return;
        Path path = this.mArrow;
        if (path == null) {
            this.mArrow = path = new Path();
            path.setFillType(Path.FillType.EVEN_ODD);
        } else {
            path.reset();
        }
        float f3 = Math.min(rectF.width(), rectF.height()) / 2.0f;
        float f4 = (float)this.mArrowWidth * this.mArrowScale / 2.0f;
        this.mArrow.moveTo(0.0f, 0.0f);
        this.mArrow.lineTo((float)this.mArrowWidth * this.mArrowScale, 0.0f);
        path = this.mArrow;
        float f5 = this.mArrowWidth;
        float f6 = this.mArrowScale;
        path.lineTo(f5 * f6 / 2.0f, (float)this.mArrowHeight * f6);
        this.mArrow.offset(f3 + rectF.centerX() - f4, rectF.centerY() + this.mStrokeWidth / 2.0f);
        this.mArrow.close();
        this.mArrowPaint.setColor(this.mCurrentColor);
        this.mArrowPaint.setAlpha(this.mAlpha);
        canvas.save();
        canvas.rotate(f + f2, rectF.centerX(), rectF.centerY());
        canvas.drawPath(this.mArrow, this.mArrowPaint);
        canvas.restore();
    }

    int getAlpha() {
        return this.mAlpha;
    }

    float getArrowHeight() {
        return this.mArrowHeight;
    }

    float getArrowScale() {
        return this.mArrowScale;
    }

    float getArrowWidth() {
        return this.mArrowWidth;
    }

    int getBackgroundColor() {
        return this.mCirclePaint.getColor();
    }

    float getCenterRadius() {
        return this.mRingCenterRadius;
    }

    int[] getColors() {
        return this.mColors;
    }

    float getEndTrim() {
        return this.mEndTrim;
    }

    int getNextColor() {
        return this.mColors[this.getNextColorIndex()];
    }

    int getNextColorIndex() {
        return (this.mColorIndex + 1) % this.mColors.length;
    }

    float getRotation() {
        return this.mRotation;
    }

    boolean getShowArrow() {
        return this.mShowArrow;
    }

    float getStartTrim() {
        return this.mStartTrim;
    }

    int getStartingColor() {
        return this.mColors[this.mColorIndex];
    }

    float getStartingEndTrim() {
        return this.mStartingEndTrim;
    }

    float getStartingRotation() {
        return this.mStartingRotation;
    }

    float getStartingStartTrim() {
        return this.mStartingStartTrim;
    }

    Paint.Cap getStrokeCap() {
        return this.mPaint.getStrokeCap();
    }

    float getStrokeWidth() {
        return this.mStrokeWidth;
    }

    void goToNextColor() {
        this.setColorIndex(this.getNextColorIndex());
    }

    void resetOriginals() {
        this.mStartingStartTrim = 0.0f;
        this.mStartingEndTrim = 0.0f;
        this.mStartingRotation = 0.0f;
        this.setStartTrim(0.0f);
        this.setEndTrim(0.0f);
        this.setRotation(0.0f);
    }

    void setAlpha(int n) {
        this.mAlpha = n;
    }

    void setArrowDimensions(float f, float f2) {
        this.mArrowWidth = (int)f;
        this.mArrowHeight = (int)f2;
    }

    void setArrowScale(float f) {
        if (f == this.mArrowScale) return;
        this.mArrowScale = f;
    }

    void setBackgroundColor(int n) {
        this.mCirclePaint.setColor(n);
    }

    void setCenterRadius(float f) {
        this.mRingCenterRadius = f;
    }

    void setColor(int n) {
        this.mCurrentColor = n;
    }

    void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    void setColorIndex(int n) {
        this.mColorIndex = n;
        this.mCurrentColor = this.mColors[n];
    }

    void setColors(int[] nArray) {
        this.mColors = nArray;
        this.setColorIndex(0);
    }

    void setEndTrim(float f) {
        this.mEndTrim = f;
    }

    void setRotation(float f) {
        this.mRotation = f;
    }

    void setShowArrow(boolean bl) {
        if (this.mShowArrow == bl) return;
        this.mShowArrow = bl;
    }

    void setStartTrim(float f) {
        this.mStartTrim = f;
    }

    void setStrokeCap(Paint.Cap cap) {
        this.mPaint.setStrokeCap(cap);
    }

    void setStrokeWidth(float f) {
        this.mStrokeWidth = f;
        this.mPaint.setStrokeWidth(f);
    }

    void storeOriginals() {
        this.mStartingStartTrim = this.mStartTrim;
        this.mStartingEndTrim = this.mEndTrim;
        this.mStartingRotation = this.mRotation;
    }
}
