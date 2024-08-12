/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.text.TextPaint
 *  com.qmuiteam.qmui.link.QMUILinkify$StyleableURLSpan
 *  com.qmuiteam.qmui.span.QMUIOnSpanClickListener
 */
package com.qmuiteam.qmui.link;

import android.content.res.ColorStateList;
import android.text.TextPaint;
import com.qmuiteam.qmui.link.QMUILinkify;
import com.qmuiteam.qmui.span.QMUIOnSpanClickListener;

static final class QMUILinkify.6
extends QMUILinkify.StyleableURLSpan {
    final ColorStateList val$bgColor;
    final ColorStateList val$linkColor;

    QMUILinkify.6(String string, QMUIOnSpanClickListener qMUIOnSpanClickListener, ColorStateList colorStateList, ColorStateList colorStateList2) {
        this.val$linkColor = colorStateList;
        this.val$bgColor = colorStateList2;
        super(string, qMUIOnSpanClickListener);
    }

    public void updateDrawState(TextPaint textPaint) {
        int n;
        int n2;
        ColorStateList colorStateList = this.val$linkColor;
        if (colorStateList != null) {
            n2 = colorStateList.getColorForState(new int[]{16842910, -16842919}, 0);
            n = this.val$linkColor.getColorForState(new int[]{16842919}, n2);
            if (this.mPressed) {
                n2 = n;
            }
            textPaint.linkColor = n2;
        }
        if ((colorStateList = this.val$bgColor) != null) {
            n2 = colorStateList.getColorForState(new int[]{16842910, -16842919}, 0);
            n = this.val$bgColor.getColorForState(new int[]{16842919}, n2);
            if (this.mPressed) {
                n2 = n;
            }
            textPaint.bgColor = n2;
        }
        super.updateDrawState(textPaint);
        textPaint.setUnderlineText(false);
    }
}
