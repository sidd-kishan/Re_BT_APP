/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Paint
 *  android.view.View$MeasureSpec
 *  android.widget.TextView
 *  com.qmuiteam.qmui.R$styleable
 *  com.qmuiteam.qmui.util.QMUIDisplayHelper
 */
package com.qmuiteam.qmui.widget;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;

public class QMUIFontFitTextView
extends TextView {
    private Paint mTestPaint;
    private float maxSize;
    private float minSize;

    public QMUIFontFitTextView(Context context) {
        this(context, null);
    }

    public QMUIFontFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint;
        this.mTestPaint = paint = new Paint();
        paint.set((Paint)this.getPaint());
        context = context.obtainStyledAttributes(attributeSet, R.styleable.QMUIFontFitTextView);
        this.minSize = context.getDimensionPixelSize(R.styleable.QMUIFontFitTextView_qmui_minTextSize, Math.round(QMUIDisplayHelper.DENSITY * 14.0f));
        this.maxSize = context.getDimensionPixelSize(R.styleable.QMUIFontFitTextView_qmui_maxTextSize, Math.round(QMUIDisplayHelper.DENSITY * 18.0f));
        context.recycle();
    }

    private void refitText(String string, int n) {
        if (n <= 0) {
            return;
        }
        int n2 = this.getPaddingLeft();
        int n3 = this.getPaddingRight();
        float f = this.maxSize;
        float f2 = this.minSize;
        this.mTestPaint.set((Paint)this.getPaint());
        this.mTestPaint.setTextSize(this.maxSize);
        float f3 = this.mTestPaint.measureText(string);
        float f4 = n - n2 - n3;
        if (f3 <= f4) {
            f3 = this.maxSize;
        } else {
            this.mTestPaint.setTextSize(this.minSize);
            f3 = f2;
            if (this.mTestPaint.measureText(string) < f4) {
                while (true) {
                    f3 = f2;
                    if (!(f - f2 > 0.5f)) break;
                    f3 = (f + f2) / 2.0f;
                    this.mTestPaint.setTextSize(f3);
                    if (this.mTestPaint.measureText(string) >= f4) {
                        f = f3;
                        continue;
                    }
                    f2 = f3;
                }
            }
        }
        this.setTextSize(0, f3);
    }

    protected void onMeasure(int n, int n2) {
        super.onMeasure(n, n2);
        n = View.MeasureSpec.getSize((int)n);
        n2 = this.getMeasuredHeight();
        this.refitText(this.getText().toString(), n);
        this.setMeasuredDimension(n, n2);
    }

    protected void onSizeChanged(int n, int n2, int n3, int n4) {
        if (n == n3) return;
        this.refitText(this.getText().toString(), n);
    }

    protected void onTextChanged(CharSequence charSequence, int n, int n2, int n3) {
        this.refitText(charSequence.toString(), this.getWidth());
    }
}
