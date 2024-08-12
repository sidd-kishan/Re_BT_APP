/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.Window
 */
package androidx.core.view;

import android.view.Window;

private static class WindowCompat.Impl16 {
    private WindowCompat.Impl16() {
    }

    static void setDecorFitsSystemWindows(Window window, boolean bl) {
        window = window.getDecorView();
        int n = window.getSystemUiVisibility();
        n = bl ? (n &= 0xFFFFF8FF) : (n |= 0x700);
        window.setSystemUiVisibility(n);
    }
}
