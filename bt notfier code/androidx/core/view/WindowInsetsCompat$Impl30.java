/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Insets
 *  android.view.View
 *  android.view.WindowInsets
 *  androidx.core.graphics.Insets
 *  androidx.core.view.WindowInsetsCompat
 *  androidx.core.view.WindowInsetsCompat$Impl29
 *  androidx.core.view.WindowInsetsCompat$TypeImpl30
 */
package androidx.core.view;

import android.graphics.Insets;
import android.view.View;
import android.view.WindowInsets;
import androidx.core.view.WindowInsetsCompat;

/*
 * Exception performing whole class analysis ignored.
 */
private static class WindowInsetsCompat.Impl30
extends WindowInsetsCompat.Impl29 {
    static final WindowInsetsCompat CONSUMED = WindowInsetsCompat.toWindowInsetsCompat((WindowInsets)WindowInsets.CONSUMED);

    WindowInsetsCompat.Impl30(WindowInsetsCompat windowInsetsCompat, WindowInsets windowInsets) {
        super(windowInsetsCompat, windowInsets);
    }

    WindowInsetsCompat.Impl30(WindowInsetsCompat windowInsetsCompat, WindowInsetsCompat.Impl30 impl30) {
        super(windowInsetsCompat, (WindowInsetsCompat.Impl29)impl30);
    }

    final void copyRootViewBounds(View view) {
    }

    public androidx.core.graphics.Insets getInsets(int n) {
        return androidx.core.graphics.Insets.toCompatInsets((Insets)this.mPlatformInsets.getInsets(WindowInsetsCompat.TypeImpl30.toPlatformType((int)n)));
    }

    public androidx.core.graphics.Insets getInsetsIgnoringVisibility(int n) {
        return androidx.core.graphics.Insets.toCompatInsets((Insets)this.mPlatformInsets.getInsetsIgnoringVisibility(WindowInsetsCompat.TypeImpl30.toPlatformType((int)n)));
    }

    public boolean isVisible(int n) {
        return this.mPlatformInsets.isVisible(WindowInsetsCompat.TypeImpl30.toPlatformType((int)n));
    }
}
