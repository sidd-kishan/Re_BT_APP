/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.text.SpannableStringBuilder
 *  com.qmuiteam.qmui.span.QMUIMarginImageSpan
 */
package com.qmuiteam.qmui.util;

import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import com.qmuiteam.qmui.span.QMUIMarginImageSpan;

public class QMUISpanHelper {
    public static CharSequence generateHorIconText(CharSequence charSequence, int n, Drawable drawable, int n2, Drawable drawable2) {
        return QMUISpanHelper.generateHorIconText(charSequence, n, drawable, n2, drawable2, 0);
    }

    public static CharSequence generateHorIconText(CharSequence charSequence, int n, Drawable drawable, int n2, Drawable drawable2, int n3) {
        int n4;
        if (drawable == null && drawable2 == null) {
            return charSequence;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            spannableStringBuilder.append((CharSequence)"[icon]");
            n4 = spannableStringBuilder.length();
            drawable = new QMUIMarginImageSpan(drawable, -100, 0, n, n3);
            drawable.setAvoidSuperChangeFontMetrics(true);
            spannableStringBuilder.setSpan((Object)drawable, 0, n4, 17);
        }
        spannableStringBuilder.append(charSequence);
        if (drawable2 == null) return spannableStringBuilder;
        drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
        n4 = spannableStringBuilder.length();
        spannableStringBuilder.append((CharSequence)"[icon]");
        n = spannableStringBuilder.length();
        charSequence = new QMUIMarginImageSpan(drawable2, -100, n2, 0, n3);
        charSequence.setAvoidSuperChangeFontMetrics(true);
        spannableStringBuilder.setSpan((Object)charSequence, n4, n, 17);
        return spannableStringBuilder;
    }

    public static CharSequence generateSideIconText(boolean bl, int n, CharSequence charSequence, Drawable drawable) {
        return QMUISpanHelper.generateSideIconText(bl, n, charSequence, drawable, 0);
    }

    public static CharSequence generateSideIconText(boolean bl, int n, CharSequence charSequence, Drawable drawable, int n2) {
        int n3 = bl ? n : 0;
        Object object = bl ? drawable : null;
        if (bl) {
            n = 0;
        }
        if (!bl) return QMUISpanHelper.generateHorIconText(charSequence, n3, object, n, drawable, n2);
        drawable = null;
        return QMUISpanHelper.generateHorIconText(charSequence, n3, object, n, drawable, n2);
    }
}
