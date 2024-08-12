/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.graphics.PorterDuff$Mode
 *  android.widget.CheckedTextView
 */
package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.widget.CheckedTextView;

private static class CheckedTextViewCompat.Api21Impl {
    private CheckedTextViewCompat.Api21Impl() {
    }

    static ColorStateList getCheckMarkTintList(CheckedTextView checkedTextView) {
        return checkedTextView.getCheckMarkTintList();
    }

    static PorterDuff.Mode getCheckMarkTintMode(CheckedTextView checkedTextView) {
        return checkedTextView.getCheckMarkTintMode();
    }

    static void setCheckMarkTintList(CheckedTextView checkedTextView, ColorStateList colorStateList) {
        checkedTextView.setCheckMarkTintList(colorStateList);
    }

    static void setCheckMarkTintMode(CheckedTextView checkedTextView, PorterDuff.Mode mode) {
        checkedTextView.setCheckMarkTintMode(mode);
    }
}
