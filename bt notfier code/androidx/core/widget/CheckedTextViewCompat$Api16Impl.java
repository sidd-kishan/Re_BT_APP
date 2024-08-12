/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.widget.CheckedTextView
 */
package androidx.core.widget;

import android.graphics.drawable.Drawable;
import android.widget.CheckedTextView;

private static class CheckedTextViewCompat.Api16Impl {
    private CheckedTextViewCompat.Api16Impl() {
    }

    static Drawable getCheckMarkDrawable(CheckedTextView checkedTextView) {
        return checkedTextView.getCheckMarkDrawable();
    }
}
