/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.TimeInterpolator
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Cap
 *  android.view.View
 *  android.view.animation.LinearInterpolator
 *  com.qmuiteam.qmui.R$attr
 *  com.qmuiteam.qmui.R$styleable
 *  com.qmuiteam.qmui.util.QMUIDisplayHelper
 */
package com.qmuiteam.qmui.widget;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;

public class QMUILoadingView
extends View {
    private static final int DEGREE_PER_LINE = 30;
    private static final int LINE_COUNT = 12;
    private int mAnimateValue = 0;
    private ValueAnimator mAnimator;
    private Paint mPaint;
    private int mPaintColor;
    private int mSize;
    private ValueAnimator.AnimatorUpdateListener mUpdateListener = new /* Unavailable Anonymous Inner Class!! */;

    public QMUILoadingView(Context context) {
        this(context, null);
    }

    public QMUILoadingView(Context context, int n, int n2) {
        super(context);
        this.mSize = n;
        this.mPaintColor = n2;
        this.initPaint();
    }

    public QMUILoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.QMUILoadingStyle);
    }

    public QMUILoadingView(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        attributeSet = this.getContext().obtainStyledAttributes(attributeSet, R.styleable.QMUILoadingView, n, 0);
        this.mSize = attributeSet.getDimensionPixelSize(R.styleable.QMUILoadingView_qmui_loading_view_size, QMUIDisplayHelper.dp2px((Context)context, (int)32));
        this.mPaintColor = attributeSet.getInt(R.styleable.QMUILoadingView_android_color, -1);
        attributeSet.recycle();
        this.initPaint();
    }

    static /* synthetic */ int access$002(QMUILoadingView qMUILoadingView, int n) {
        qMUILoadingView.mAnimateValue = n;
        return n;
    }

    private void drawLoading(Canvas canvas, int n) {
        int n2 = this.mSize;
        int n3 = n2 / 12;
        n2 /= 6;
        this.mPaint.setStrokeWidth((float)n3);
        float f = n;
        n = this.mSize;
        canvas.rotate(f, (float)(n / 2), (float)(n / 2));
        n = this.mSize;
        canvas.translate((float)(n / 2), (float)(n / 2));
        n = 0;
        while (n < 12) {
            canvas.rotate(30.0f);
            Paint paint = this.mPaint;
            paint.setAlpha((int)((float)(++n) * 255.0f / 12.0f));
            int n4 = -this.mSize / 2;
            int n5 = n3 / 2;
            canvas.translate(0.0f, (float)(n4 + n5));
            canvas.drawLine(0.0f, 0.0f, 0.0f, (float)n2, this.mPaint);
            canvas.translate(0.0f, (float)(this.mSize / 2 - n5));
        }
    }

    private void initPaint() {
        Paint paint;
        this.mPaint = paint = new Paint();
        paint.setColor(this.mPaintColor);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.start();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.stop();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int n = canvas.saveLayer(0.0f, 0.0f, (float)this.getWidth(), (float)this.getHeight(), null, 31);
        this.drawLoading(canvas, this.mAnimateValue * 30);
        canvas.restoreToCount(n);
    }

    protected void onMeasure(int n, int n2) {
        n = this.mSize;
        this.setMeasuredDimension(n, n);
    }

    protected void onVisibilityChanged(View view, int n) {
        super.onVisibilityChanged(view, n);
        if (n == 0) {
            this.start();
        } else {
            this.stop();
        }
    }

    public void setColor(int n) {
        this.mPaintColor = n;
        this.mPaint.setColor(n);
        this.invalidate();
    }

    public void setSize(int n) {
        this.mSize = n;
        this.requestLayout();
    }

    public void start() {
        ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator == null) {
            this.mAnimator = valueAnimator = ValueAnimator.ofInt((int[])new int[]{0, 11});
            valueAnimator.addUpdateListener(this.mUpdateListener);
            this.mAnimator.setDuration(600L);
            this.mAnimator.setRepeatMode(1);
            this.mAnimator.setRepeatCount(-1);
            this.mAnimator.setInterpolator((TimeInterpolator)new LinearInterpolator());
            this.mAnimator.start();
        } else {
            if (valueAnimator.isStarted()) return;
            this.mAnimator.start();
        }
    }

    public void stop() {
        ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator == null) return;
        valueAnimator.removeUpdateListener(this.mUpdateListener);
        this.mAnimator.removeAllUpdateListeners();
        this.mAnimator.cancel();
        this.mAnimator = null;
    }
}
