/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.View$OnApplyWindowInsetsListener
 *  android.view.WindowInsets
 *  androidx.core.R$id
 *  androidx.core.view.OnApplyWindowInsetsListener
 *  androidx.core.view.WindowInsetsCompat
 *  androidx.core.view.WindowInsetsCompat$Api21ReflectionHolder
 */
package androidx.core.view;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import androidx.core.R;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;

private static class ViewCompat.Api21Impl {
    private ViewCompat.Api21Impl() {
    }

    static void callCompatInsetAnimationCallback(WindowInsets windowInsets, View view) {
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener)view.getTag(R.id.tag_window_insets_animation_callback);
        if (onApplyWindowInsetsListener == null) return;
        onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
    }

    static WindowInsetsCompat computeSystemWindowInsets(View view, WindowInsetsCompat windowInsetsCompat, Rect rect) {
        WindowInsets windowInsets = windowInsetsCompat.toWindowInsets();
        if (windowInsets != null) {
            return WindowInsetsCompat.toWindowInsetsCompat((WindowInsets)view.computeSystemWindowInsets(windowInsets, rect), (View)view);
        }
        rect.setEmpty();
        return windowInsetsCompat;
    }

    public static WindowInsetsCompat getRootWindowInsets(View view) {
        return WindowInsetsCompat.Api21ReflectionHolder.getRootWindowInsets((View)view);
    }

    static void setOnApplyWindowInsetsListener(View view, OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        if (Build.VERSION.SDK_INT < 30) {
            view.setTag(R.id.tag_on_apply_window_listener, (Object)onApplyWindowInsetsListener);
        }
        if (onApplyWindowInsetsListener == null) {
            view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener)view.getTag(R.id.tag_window_insets_animation_callback));
            return;
        }
        view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener)new /* Unavailable Anonymous Inner Class!! */);
    }
}
