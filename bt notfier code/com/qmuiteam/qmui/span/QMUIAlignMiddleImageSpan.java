/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$FontMetricsInt
 *  android.graphics.drawable.Drawable
 *  android.text.style.ImageSpan
 */
package com.qmuiteam.qmui.span;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;

public class QMUIAlignMiddleImageSpan
extends ImageSpan {
    public static final int ALIGN_MIDDLE = -100;
    private boolean mAvoidSuperChangeFontMetrics = false;
    private float mFontWidthMultiple = -1.0f;
    private int mWidth;

    public QMUIAlignMiddleImageSpan(Drawable drawable, int n) {
        super(drawable, n);
    }

    public QMUIAlignMiddleImageSpan(Drawable drawable, int n, float f) {
        this(drawable, n);
        if (!(f >= 0.0f)) return;
        this.mFontWidthMultiple = f;
    }

    public void draw(Canvas canvas, CharSequence charSequence, int n, int n2, float f, int n3, int n4, int n5, Paint paint) {
        if (this.mVerticalAlignment == -100) {
            charSequence = this.getDrawable();
            canvas.save();
            paint = paint.getFontMetricsInt();
            canvas.translate(f, (float)(n4 + paint.top + (paint.bottom - paint.top - (charSequence.getBounds().bottom - charSequence.getBounds().top)) / 2));
            charSequence.draw(canvas);
            canvas.restore();
        } else {
            super.draw(canvas, charSequence, n, n2, f, n3, n4, n5, paint);
        }
    }

    public int getSize(Paint paint, CharSequence charSequence, int n, int n2, Paint.FontMetricsInt fontMetricsInt) {
        this.mWidth = this.mAvoidSuperChangeFontMetrics ? this.getDrawable().getBounds().right : super.getSize(paint, charSequence, n, n2, fontMetricsInt);
        if (!(this.mFontWidthMultiple > 0.0f)) return this.mWidth;
        this.mWidth = (int)(paint.measureText("\u5b50") * this.mFontWidthMultiple);
        return this.mWidth;
    }

    public void setAvoidSuperChangeFontMetrics(boolean bl) {
        this.mAvoidSuperChangeFontMetrics = bl;
    }
}
