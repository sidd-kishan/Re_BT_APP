/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Insets
 *  android.view.WindowInsets
 *  androidx.core.graphics.Insets
 *  androidx.core.view.WindowInsetsCompat
 *  androidx.core.view.WindowInsetsCompat$Impl28
 */
package androidx.core.view;

import android.graphics.Insets;
import android.view.WindowInsets;
import androidx.core.view.WindowInsetsCompat;

/*
 * Exception performing whole class analysis ignored.
 */
private static class WindowInsetsCompat.Impl29
extends WindowInsetsCompat.Impl28 {
    private androidx.core.graphics.Insets mMandatorySystemGestureInsets = null;
    private androidx.core.graphics.Insets mSystemGestureInsets = null;
    private androidx.core.graphics.Insets mTappableElementInsets = null;

    WindowInsetsCompat.Impl29(WindowInsetsCompat windowInsetsCompat, WindowInsets windowInsets) {
        super(windowInsetsCompat, windowInsets);
    }

    WindowInsetsCompat.Impl29(WindowInsetsCompat windowInsetsCompat, WindowInsetsCompat.Impl29 impl29) {
        super(windowInsetsCompat, (WindowInsetsCompat.Impl28)impl29);
    }

    androidx.core.graphics.Insets getMandatorySystemGestureInsets() {
        if (this.mMandatorySystemGestureInsets != null) return this.mMandatorySystemGestureInsets;
        this.mMandatorySystemGestureInsets = androidx.core.graphics.Insets.toCompatInsets((Insets)this.mPlatformInsets.getMandatorySystemGestureInsets());
        return this.mMandatorySystemGestureInsets;
    }

    androidx.core.graphics.Insets getSystemGestureInsets() {
        if (this.mSystemGestureInsets != null) return this.mSystemGestureInsets;
        this.mSystemGestureInsets = androidx.core.graphics.Insets.toCompatInsets((Insets)this.mPlatformInsets.getSystemGestureInsets());
        return this.mSystemGestureInsets;
    }

    androidx.core.graphics.Insets getTappableElementInsets() {
        if (this.mTappableElementInsets != null) return this.mTappableElementInsets;
        this.mTappableElementInsets = androidx.core.graphics.Insets.toCompatInsets((Insets)this.mPlatformInsets.getTappableElementInsets());
        return this.mTappableElementInsets;
    }

    WindowInsetsCompat inset(int n, int n2, int n3, int n4) {
        return WindowInsetsCompat.toWindowInsetsCompat((WindowInsets)this.mPlatformInsets.inset(n, n2, n3, n4));
    }

    public void setStableInsets(androidx.core.graphics.Insets insets) {
    }
}
