/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.WindowInsets
 *  androidx.core.view.WindowInsetsCompat
 */
package androidx.core.view;

import android.view.View;
import android.view.WindowInsets;
import androidx.core.view.WindowInsetsCompat;

private static class ViewCompat.Api23Impl {
    private ViewCompat.Api23Impl() {
    }

    public static WindowInsetsCompat getRootWindowInsets(View view) {
        WindowInsets windowInsets = view.getRootWindowInsets();
        if (windowInsets == null) {
            return null;
        }
        windowInsets = WindowInsetsCompat.toWindowInsetsCompat((WindowInsets)windowInsets);
        windowInsets.setRootWindowInsets((WindowInsetsCompat)windowInsets);
        windowInsets.copyRootViewBounds(view.getRootView());
        return windowInsets;
    }
}
