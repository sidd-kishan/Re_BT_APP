/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Cap
 *  android.graphics.Paint$Style
 *  android.graphics.RectF
 *  android.view.View
 */
package com.lianhezhuli.btnotification.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class SleepTimeProgressView
extends View {
    private int mBadColor;
    private RectF mBgF;
    private int mExcellentColor;
    private int mGoodColor;
    private int mInColor;
    private float mMargin;
    private int mProgress = 0;
    private Paint mProgressPaint;
    private float mProgressW;
    private float mTotalH;
    private float mTotalW;

    public SleepTimeProgressView(Context context) {
        super(context);
        this.init(context);
    }

    public SleepTimeProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.init(context);
    }

    public SleepTimeProgressView(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.init(context);
    }

    public SleepTimeProgressView(Context context, AttributeSet attributeSet, int n, int n2) {
        super(context, attributeSet, n, n2);
        this.init(context);
    }

    private void init(Context context) {
        Paint paint;
        this.mBgF = new RectF();
        this.mProgressPaint = paint = new Paint(1);
        paint.setStyle(Paint.Style.STROKE);
        this.mProgressPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mExcellentColor = context.getResources().getColor(2131099722);
        this.mGoodColor = context.getResources().getColor(2131099723);
        this.mBadColor = context.getResources().getColor(2131099721);
        this.mInColor = context.getResources().getColor(2131099744);
        this.mMargin = context.getResources().getDimension(2131165972);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mProgressPaint.setStrokeWidth(this.mTotalH);
        this.mProgressPaint.setColor(this.mInColor);
        float f = this.mMargin;
        float f2 = this.mTotalH;
        canvas.drawLine(f, f2 / 2.0f, this.mTotalW - f, f2 / 2.0f, this.mProgressPaint);
        int n = this.mProgress;
        f2 = n >= 28800 ? 1.0f : (float)n / 28800.0f;
        if (f2 == 0.0f) {
            return;
        }
        n = this.mProgress;
        if (n >= 28800) {
            this.mProgressPaint.setColor(this.mExcellentColor);
        } else if (n >= 21600) {
            this.mProgressPaint.setColor(this.mGoodColor);
        } else {
            this.mProgressPaint.setColor(this.mBadColor);
        }
        f = this.mMargin;
        float f3 = this.mTotalH;
        canvas.drawLine(f, f3 / 2.0f, this.mProgressW * f2 + f, f3 / 2.0f, this.mProgressPaint);
    }

    protected void onMeasure(int n, int n2) {
        float f;
        super.onMeasure(n, n2);
        this.mTotalH = this.getMeasuredHeight();
        this.mTotalW = f = (float)this.getMeasuredWidth();
        this.mProgressW = f - this.mMargin * 2.0f;
        this.mBgF.set(0.0f, 0.0f, f, this.mTotalH);
    }

    public void setProgress(int n) {
        this.mProgress = n;
        this.invalidate();
    }
}
