/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$FontMetricsInt
 *  android.text.style.ReplacementSpan
 *  com.qmuiteam.qmui.util.QMUIDeviceHelper
 */
package com.qmuiteam.qmui.span;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import com.qmuiteam.qmui.util.QMUIDeviceHelper;

public class QMUIBlockSpaceSpan
extends ReplacementSpan {
    private int mHeight;

    public QMUIBlockSpaceSpan(int n) {
        this.mHeight = n;
    }

    public void draw(Canvas canvas, CharSequence charSequence, int n, int n2, float f, int n3, int n4, int n5, Paint paint) {
    }

    public int getSize(Paint paint, CharSequence charSequence, int n, int n2, Paint.FontMetricsInt fontMetricsInt) {
        if (fontMetricsInt == null) return 0;
        if (QMUIDeviceHelper.isMeizu()) return 0;
        fontMetricsInt.top = n = -this.mHeight - paint.getFontMetricsInt(fontMetricsInt);
        fontMetricsInt.ascent = n;
        fontMetricsInt.bottom = 0;
        fontMetricsInt.descent = 0;
        return 0;
    }
}
