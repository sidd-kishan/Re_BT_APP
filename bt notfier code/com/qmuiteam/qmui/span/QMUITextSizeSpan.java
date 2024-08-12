/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$FontMetricsInt
 *  android.graphics.Typeface
 *  android.text.style.ReplacementSpan
 */
package com.qmuiteam.qmui.span;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.style.ReplacementSpan;

public class QMUITextSizeSpan
extends ReplacementSpan {
    private Paint mPaint;
    private int mTextSize;
    private Typeface mTypeface;
    private int mVerticalOffset;

    public QMUITextSizeSpan(int n, int n2) {
        this(n, n2, null);
    }

    public QMUITextSizeSpan(int n, int n2, Typeface typeface) {
        this.mTextSize = n;
        this.mVerticalOffset = n2;
        this.mTypeface = typeface;
    }

    public void draw(Canvas canvas, CharSequence charSequence, int n, int n2, float f, int n3, int n4, int n5, Paint paint) {
        canvas.drawText(charSequence, n, n2, f, (float)(n4 + this.mVerticalOffset), this.mPaint);
    }

    public int getSize(Paint paint, CharSequence charSequence, int n, int n2, Paint.FontMetricsInt fontMetricsInt) {
        Paint paint2;
        this.mPaint = paint2 = new Paint(paint);
        paint2.setTextSize((float)this.mTextSize);
        this.mPaint.setTypeface(this.mTypeface);
        if (!((float)this.mTextSize > paint.getTextSize())) return (int)this.mPaint.measureText(charSequence, n, n2);
        if (fontMetricsInt == null) return (int)this.mPaint.measureText(charSequence, n, n2);
        paint = this.mPaint.getFontMetricsInt();
        fontMetricsInt.descent = paint.descent;
        fontMetricsInt.ascent = paint.ascent;
        fontMetricsInt.top = paint.top;
        fontMetricsInt.bottom = paint.bottom;
        return (int)this.mPaint.measureText(charSequence, n, n2);
    }
}
