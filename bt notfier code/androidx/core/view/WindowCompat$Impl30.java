/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.Window
 *  android.view.WindowInsetsController
 *  androidx.core.view.WindowInsetsControllerCompat
 */
package androidx.core.view;

import android.view.Window;
import android.view.WindowInsetsController;
import androidx.core.view.WindowInsetsControllerCompat;

private static class WindowCompat.Impl30 {
    private WindowCompat.Impl30() {
    }

    static WindowInsetsControllerCompat getInsetsController(Window window) {
        if ((window = window.getInsetsController()) == null) return null;
        return WindowInsetsControllerCompat.toWindowInsetsControllerCompat((WindowInsetsController)window);
    }

    static void setDecorFitsSystemWindows(Window window, boolean bl) {
        window.setDecorFitsSystemWindows(bl);
    }
}
