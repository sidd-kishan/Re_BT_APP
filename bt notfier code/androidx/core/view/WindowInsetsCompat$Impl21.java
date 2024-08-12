/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.WindowInsets
 *  androidx.core.graphics.Insets
 *  androidx.core.view.WindowInsetsCompat
 *  androidx.core.view.WindowInsetsCompat$Impl20
 */
package androidx.core.view;

import android.view.WindowInsets;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;

/*
 * Exception performing whole class analysis ignored.
 */
private static class WindowInsetsCompat.Impl21
extends WindowInsetsCompat.Impl20 {
    private Insets mStableInsets = null;

    WindowInsetsCompat.Impl21(WindowInsetsCompat windowInsetsCompat, WindowInsets windowInsets) {
        super(windowInsetsCompat, windowInsets);
    }

    WindowInsetsCompat.Impl21(WindowInsetsCompat windowInsetsCompat, WindowInsetsCompat.Impl21 impl21) {
        super(windowInsetsCompat, (WindowInsetsCompat.Impl20)impl21);
        this.mStableInsets = impl21.mStableInsets;
    }

    WindowInsetsCompat consumeStableInsets() {
        return WindowInsetsCompat.toWindowInsetsCompat((WindowInsets)this.mPlatformInsets.consumeStableInsets());
    }

    WindowInsetsCompat consumeSystemWindowInsets() {
        return WindowInsetsCompat.toWindowInsetsCompat((WindowInsets)this.mPlatformInsets.consumeSystemWindowInsets());
    }

    final Insets getStableInsets() {
        if (this.mStableInsets != null) return this.mStableInsets;
        this.mStableInsets = Insets.of((int)this.mPlatformInsets.getStableInsetLeft(), (int)this.mPlatformInsets.getStableInsetTop(), (int)this.mPlatformInsets.getStableInsetRight(), (int)this.mPlatformInsets.getStableInsetBottom());
        return this.mStableInsets;
    }

    boolean isConsumed() {
        return this.mPlatformInsets.isConsumed();
    }

    public void setStableInsets(Insets insets) {
        this.mStableInsets = insets;
    }
}
