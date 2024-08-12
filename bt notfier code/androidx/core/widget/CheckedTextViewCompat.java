/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.widget.CheckedTextView
 *  androidx.core.widget.CheckedTextViewCompat$Api14Impl
 *  androidx.core.widget.CheckedTextViewCompat$Api16Impl
 *  androidx.core.widget.CheckedTextViewCompat$Api21Impl
 *  androidx.core.widget.TintableCheckedTextView
 */
package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.CheckedTextView;
import androidx.core.widget.CheckedTextViewCompat;
import androidx.core.widget.TintableCheckedTextView;

/*
 * Exception performing whole class analysis ignored.
 */
public final class CheckedTextViewCompat {
    private static final String TAG = "CheckedTextViewCompat";

    private CheckedTextViewCompat() {
    }

    public static Drawable getCheckMarkDrawable(CheckedTextView checkedTextView) {
        if (Build.VERSION.SDK_INT < 16) return Api14Impl.getCheckMarkDrawable((CheckedTextView)checkedTextView);
        return Api16Impl.getCheckMarkDrawable((CheckedTextView)checkedTextView);
    }

    public static ColorStateList getCheckMarkTintList(CheckedTextView checkedTextView) {
        if (Build.VERSION.SDK_INT >= 21) {
            return Api21Impl.getCheckMarkTintList((CheckedTextView)checkedTextView);
        }
        if (!(checkedTextView instanceof TintableCheckedTextView)) return null;
        return ((TintableCheckedTextView)checkedTextView).getSupportCheckMarkTintList();
    }

    public static PorterDuff.Mode getCheckMarkTintMode(CheckedTextView checkedTextView) {
        if (Build.VERSION.SDK_INT >= 21) {
            return Api21Impl.getCheckMarkTintMode((CheckedTextView)checkedTextView);
        }
        if (!(checkedTextView instanceof TintableCheckedTextView)) return null;
        return ((TintableCheckedTextView)checkedTextView).getSupportCheckMarkTintMode();
    }

    public static void setCheckMarkTintList(CheckedTextView checkedTextView, ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT >= 21) {
            Api21Impl.setCheckMarkTintList((CheckedTextView)checkedTextView, (ColorStateList)colorStateList);
        } else {
            if (!(checkedTextView instanceof TintableCheckedTextView)) return;
            ((TintableCheckedTextView)checkedTextView).setSupportCheckMarkTintList(colorStateList);
        }
    }

    public static void setCheckMarkTintMode(CheckedTextView checkedTextView, PorterDuff.Mode mode) {
        if (Build.VERSION.SDK_INT >= 21) {
            Api21Impl.setCheckMarkTintMode((CheckedTextView)checkedTextView, (PorterDuff.Mode)mode);
        } else {
            if (!(checkedTextView instanceof TintableCheckedTextView)) return;
            ((TintableCheckedTextView)checkedTextView).setSupportCheckMarkTintMode(mode);
        }
    }
}
