/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Color
 *  android.graphics.Paint
 *  android.graphics.Paint$Cap
 *  android.graphics.Paint$Style
 *  android.graphics.RectF
 *  android.view.View
 */
package com.lianhezhuli.btnotification.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class SportProgressView
extends View {
    private int mCircleSize;
    private int mInColor;
    private float mMargin;
    private int mOutColor;
    private float mProgressAngle = 0.0f;
    private Paint mProgressPaint;
    private float mStrokeWidth;

    public SportProgressView(Context context) {
        super(context);
        this.init(context);
    }

    public SportProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.init(context);
    }

    public SportProgressView(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.init(context);
    }

    public SportProgressView(Context context, AttributeSet attributeSet, int n, int n2) {
        super(context, attributeSet, n, n2);
        this.init(context);
    }

    private void drawBgCircle(Canvas canvas, RectF rectF) {
        this.mProgressPaint.setColor(this.mInColor);
        canvas.drawArc(rectF, -90.0f, 360.0f, false, this.mProgressPaint);
    }

    private void drawProgress(Canvas canvas, RectF rectF) {
        this.mProgressPaint.setColor(this.mOutColor);
        float f = this.mProgressAngle;
        if (f == 0.0f) {
            f = 1.0f;
        }
        canvas.drawArc(rectF, -90.0f, f, false, this.mProgressPaint);
    }

    private void init(Context context) {
        this.mStrokeWidth = context.getResources().getDimension(2131165249);
        this.mMargin = context.getResources().getDimension(2131165972);
        context = new Paint(1);
        this.mProgressPaint = context;
        context.setStyle(Paint.Style.STROKE);
        this.mProgressPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mProgressPaint.setStrokeWidth(this.mStrokeWidth);
        this.mOutColor = -1;
        this.mInColor = Color.parseColor((String)"#FF7C6D");
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f = this.mMargin;
        int n = this.mCircleSize;
        RectF rectF = new RectF(f, f, (float)n - f, (float)n - f);
        this.drawBgCircle(canvas, rectF);
        this.drawProgress(canvas, rectF);
    }

    protected void onMeasure(int n, int n2) {
        super.onMeasure(n, n2);
        n = this.getMeasuredHeight() > this.getMeasuredWidth() ? this.getMeasuredWidth() : this.getMeasuredHeight();
        this.mCircleSize = n;
    }

    public void setData(int n, int n2) {
        this.mProgressAngle = (float)n2 / (float)n * 360.0f;
        this.invalidate();
    }
}
