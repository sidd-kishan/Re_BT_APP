/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.Window
 *  androidx.core.view.WindowCompat$Impl16
 *  androidx.core.view.WindowCompat$Impl30
 *  androidx.core.view.WindowInsetsControllerCompat
 */
package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;

/*
 * Exception performing whole class analysis ignored.
 */
public final class WindowCompat {
    public static final int FEATURE_ACTION_BAR = 8;
    public static final int FEATURE_ACTION_BAR_OVERLAY = 9;
    public static final int FEATURE_ACTION_MODE_OVERLAY = 10;

    private WindowCompat() {
    }

    public static WindowInsetsControllerCompat getInsetsController(Window window, View view) {
        if (Build.VERSION.SDK_INT < 30) return new WindowInsetsControllerCompat(window, view);
        return Impl30.getInsetsController((Window)window);
    }

    public static <T extends View> T requireViewById(Window window, int n) {
        if (Build.VERSION.SDK_INT >= 28) {
            return (T)window.requireViewById(n);
        }
        if ((window = window.findViewById(n)) == null) throw new IllegalArgumentException("ID does not reference a View inside this Window");
        return (T)window;
    }

    public static void setDecorFitsSystemWindows(Window window, boolean bl) {
        if (Build.VERSION.SDK_INT >= 30) {
            Impl30.setDecorFitsSystemWindows((Window)window, (boolean)bl);
        } else {
            if (Build.VERSION.SDK_INT < 16) return;
            Impl16.setDecorFitsSystemWindows((Window)window, (boolean)bl);
        }
    }
}
