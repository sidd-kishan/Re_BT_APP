/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$FontMetricsInt
 *  android.graphics.drawable.Drawable
 *  com.qmuiteam.qmui.span.QMUIAlignMiddleImageSpan
 */
package com.qmuiteam.qmui.span;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.qmuiteam.qmui.span.QMUIAlignMiddleImageSpan;

public class QMUIMarginImageSpan
extends QMUIAlignMiddleImageSpan {
    private int mOffsetY = 0;
    private int mSpanMarginLeft = 0;
    private int mSpanMarginRight = 0;

    public QMUIMarginImageSpan(Drawable drawable, int n, int n2, int n3) {
        super(drawable, n);
        this.mSpanMarginLeft = n2;
        this.mSpanMarginRight = n3;
    }

    public QMUIMarginImageSpan(Drawable drawable, int n, int n2, int n3, int n4) {
        this(drawable, n, n2, n3);
        this.mOffsetY = n4;
    }

    public void draw(Canvas canvas, CharSequence charSequence, int n, int n2, float f, int n3, int n4, int n5, Paint paint) {
        canvas.save();
        canvas.translate(0.0f, (float)this.mOffsetY);
        super.draw(canvas, charSequence, n, n2, f + (float)this.mSpanMarginLeft, n3, n4, n5, paint);
        canvas.restore();
    }

    public int getSize(Paint paint, CharSequence charSequence, int n, int n2, Paint.FontMetricsInt fontMetricsInt) {
        if (this.mSpanMarginLeft == 0) {
            if (this.mSpanMarginRight == 0) return super.getSize(paint, charSequence, n, n2, fontMetricsInt);
        }
        super.getSize(paint, charSequence, n, n2, fontMetricsInt);
        return this.getDrawable().getIntrinsicWidth() + this.mSpanMarginLeft + this.mSpanMarginRight;
    }
}
