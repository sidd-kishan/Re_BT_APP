/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$FontMetricsInt
 *  android.text.TextPaint
 *  android.view.View$MeasureSpec
 *  androidx.appcompat.widget.AppCompatTextView
 */
package com.qmuiteam.qmui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;

public class QMUIVerticalTextView
extends AppCompatTextView {
    private boolean mIsVerticalMode = true;
    private int[] mLineBreakIndex;
    private int mLineCount;
    private float[] mLineWidths;

    public QMUIVerticalTextView(Context context) {
        super(context);
        this.init();
    }

    public QMUIVerticalTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.init();
    }

    public QMUIVerticalTextView(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.init();
    }

    private void init() {
    }

    private static boolean isCJKCharacter(int n) {
        Character.UnicodeBlock unicodeBlock = Character.UnicodeBlock.of(n);
        if (unicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS) return true;
        if (unicodeBlock == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS) return true;
        if (unicodeBlock == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A) return true;
        if (unicodeBlock == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) return true;
        if (unicodeBlock == Character.UnicodeBlock.HANGUL_SYLLABLES) return true;
        if (unicodeBlock == Character.UnicodeBlock.HANGUL_JAMO) return true;
        if (unicodeBlock == Character.UnicodeBlock.HANGUL_COMPATIBILITY_JAMO) return true;
        if (unicodeBlock == Character.UnicodeBlock.HIRAGANA) return true;
        if (unicodeBlock == Character.UnicodeBlock.KATAKANA) return true;
        if (unicodeBlock != Character.UnicodeBlock.KATAKANA_PHONETIC_EXTENSIONS) return false;
        return true;
    }

    public boolean isVerticalMode() {
        return this.mIsVerticalMode;
    }

    /*
     * Unable to fully structure code
     */
    protected void onDraw(Canvas var1_1) {
        block8: {
            block7: {
                if (this.mIsVerticalMode) break block7;
                super.onDraw(var1_1);
                break block8;
            }
            if (this.mLineCount == 0) {
                return;
            }
            var16_2 = this.getPaint();
            var16_2.setColor(this.getCurrentTextColor());
            var16_2.drawableState = this.getDrawableState();
            var14_3 = var16_2.getFontMetricsInt();
            var15_4 = this.getText().toString().toCharArray();
            var1_1.save();
            var2_5 = this.getWidth() - this.getPaddingRight();
            var4_6 = this.mLineWidths[0];
            var3_7 = this.getPaddingTop();
            var5_8 = var2_5 -= var4_6;
            var6_9 = 0;
            var7_10 = 0;
            while ((var8_11 = var6_9) < var15_4.length) {
                var6_9 = Character.codePointAt(var15_4, var8_11);
                var11_14 = Character.charCount(var6_9);
                var13_16 = QMUIVerticalTextView.isCJKCharacter(var6_9);
                var10_13 = 1;
                var12_15 = var13_16 ^ true;
                var6_9 = var1_1.save();
                if (var12_15) {
                    var1_1.rotate(90.0f, var2_5, var3_7);
                }
                var4_6 = var12_15 != false ? var3_7 - (this.mLineWidths[var7_10] - (float)(var14_3.bottom - var14_3.top)) / 2.0f - (float)var14_3.descent : var3_7 - (float)var14_3.ascent;
                var1_1.drawText(var15_4, var8_11, var11_14, var2_5, var4_6, (Paint)var16_2);
                var1_1.restoreToCount(var6_9);
                var9_12 = var8_11 + var11_14;
                var6_9 = var9_12 < var15_4.length ? 1 : 0;
                var4_6 = var3_7;
                if (var6_9 == 0) ** GOTO lbl46
                var6_9 = var8_11 + 1 > this.mLineBreakIndex[var7_10] ? var10_13 : 0;
                if (var6_9 != 0 && (var6_9 = var7_10 + 1) < (var17_17 = this.mLineWidths).length) {
                    var3_7 = this.getPaddingTop();
                    var7_10 = var6_9;
                    var2_5 = var5_8 -= var17_17[var6_9] * this.getLineSpacingMultiplier() + this.getLineSpacingExtra();
                } else if (!var12_15) {
                    var3_7 += (float)(var14_3.descent - var14_3.ascent);
                } else {
                    var4_6 = var3_7 + var16_2.measureText(var15_4, var8_11, var11_14);
lbl46:
                    // 2 sources

                    var3_7 = var4_6;
                }
                var6_9 = var9_12;
            }
            var1_1.restore();
        }
    }

    protected void onMeasure(int n, int n2) {
        super.onMeasure(n, n2);
        if (!this.mIsVerticalMode) return;
        int n3 = View.MeasureSpec.getMode((int)n);
        int n4 = View.MeasureSpec.getMode((int)n2);
        int n5 = View.MeasureSpec.getSize((int)n);
        int n6 = View.MeasureSpec.getSize((int)n2);
        float f = this.getPaddingLeft() + this.getPaddingRight();
        float f2 = this.getPaddingTop() + this.getPaddingBottom();
        char[] cArray = this.getText().toString().toCharArray();
        TextPaint textPaint = this.getPaint();
        Paint.FontMetricsInt fontMetricsInt = textPaint.getFontMetricsInt();
        n = n4 == 0 ? Integer.MAX_VALUE : n6;
        int n7 = this.getPaddingBottom();
        float f3 = this.getPaddingTop();
        this.mLineCount = 0;
        this.mLineWidths = new float[cArray.length + 1];
        this.mLineBreakIndex = new int[cArray.length + 1];
        float f4 = f3;
        int n8 = 0;
        int n9 = 0;
        int n10 = 1;
        n2 = n5;
        while (n8 < cArray.length) {
            float f5;
            float f6;
            float f7;
            n10 = Character.codePointAt(cArray, n8);
            n5 = Character.charCount(n10);
            if (QMUIVerticalTextView.isCJKCharacter(n10) ^ true) {
                f7 = fontMetricsInt.descent - fontMetricsInt.ascent;
                f6 = textPaint.measureText(cArray, n8, n5);
            } else {
                f7 = textPaint.measureText(cArray, n8, n5);
                f6 = fontMetricsInt.descent - fontMetricsInt.ascent;
            }
            float f8 = f3 + f6;
            n10 = f8 > (float)(n - n7) && n8 > 0 ? 1 : 0;
            if (n10 != 0) {
                if (!(f4 < f3)) {
                    f3 = f4;
                }
                this.mLineBreakIndex[n9] = n8 - n5;
                f5 = f + this.mLineWidths[n9];
                n10 = n9 + 1;
                f4 = this.getPaddingTop();
                f = f3;
                f3 = f4 + f6;
                f6 = f;
            } else {
                float f9 = f8;
                f5 = f;
                f3 = f9;
                f6 = f4;
                n10 = n9;
                if (f4 < f8) {
                    f6 = f9;
                    n10 = n9;
                    f3 = f9;
                    f5 = f;
                }
            }
            float[] fArray = this.mLineWidths;
            if (fArray[n10] < f7) {
                fArray[n10] = f7;
            }
            f = f5;
            if ((n8 += n5) >= cArray.length) {
                f = f5 + this.mLineWidths[n10];
                f2 = (float)this.getPaddingBottom() + f6;
            }
            f4 = f6;
            n9 = n10;
            n10 = n5;
        }
        if (cArray.length > 0) {
            this.mLineCount = n9 + 1;
            this.mLineBreakIndex[n9] = cArray.length - n10;
        }
        n8 = this.mLineCount;
        f4 = f;
        if (n8 > 1) {
            n = 0;
            while (true) {
                f4 = f;
                if (n >= n8 - 1) break;
                f += this.mLineWidths[n] * (this.getLineSpacingMultiplier() - 1.0f) + this.getLineSpacingExtra();
                ++n;
            }
        }
        if (n4 == 0x40000000) {
            f = n6;
        } else {
            f = f2;
            if (n4 == Integer.MIN_VALUE) {
                f = Math.min(f2, (float)n6);
            }
        }
        if (n3 == 0x40000000) {
            f2 = n2;
        } else {
            f2 = f4;
            if (n3 == Integer.MIN_VALUE) {
                f2 = Math.min(f4, (float)n2);
            }
        }
        this.setMeasuredDimension((int)f2, (int)f);
    }

    public void setVerticalMode(boolean bl) {
        this.mIsVerticalMode = bl;
        this.requestLayout();
    }
}
