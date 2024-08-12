/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Paint
 *  android.graphics.Typeface
 *  android.os.Parcelable$Creator
 *  android.text.TextPaint
 *  android.text.style.TypefaceSpan
 */
package com.qmuiteam.qmui.span;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Parcelable;
import android.text.TextPaint;
import android.text.style.TypefaceSpan;

public class QMUICustomTypefaceSpan
extends TypefaceSpan {
    public static final Parcelable.Creator<QMUICustomTypefaceSpan> CREATOR = new /* Unavailable Anonymous Inner Class!! */;
    private final Typeface newType;

    public QMUICustomTypefaceSpan(String string, Typeface typeface) {
        super(string);
        this.newType = typeface;
    }

    private static void applyCustomTypeFace(Paint paint, Typeface typeface) {
        if (typeface == null) {
            return;
        }
        Typeface typeface2 = paint.getTypeface();
        int n = typeface2 == null ? 0 : typeface2.getStyle();
        if (((n &= ~typeface.getStyle()) & 1) != 0) {
            paint.setFakeBoldText(true);
        }
        if ((n & 2) != 0) {
            paint.setTextSkewX(-0.25f);
        }
        paint.setTypeface(typeface);
    }

    public void updateDrawState(TextPaint textPaint) {
        QMUICustomTypefaceSpan.applyCustomTypeFace((Paint)textPaint, this.newType);
    }

    public void updateMeasureState(TextPaint textPaint) {
        QMUICustomTypefaceSpan.applyCustomTypeFace((Paint)textPaint, this.newType);
    }
}
