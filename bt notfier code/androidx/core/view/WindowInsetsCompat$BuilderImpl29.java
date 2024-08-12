/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.DisplayCutout
 *  android.view.WindowInsets
 *  android.view.WindowInsets$Builder
 *  androidx.core.graphics.Insets
 *  androidx.core.view.DisplayCutoutCompat
 *  androidx.core.view.WindowInsetsCompat
 *  androidx.core.view.WindowInsetsCompat$BuilderImpl
 */
package androidx.core.view;

import android.view.DisplayCutout;
import android.view.WindowInsets;
import androidx.core.graphics.Insets;
import androidx.core.view.DisplayCutoutCompat;
import androidx.core.view.WindowInsetsCompat;

/*
 * Exception performing whole class analysis ignored.
 */
private static class WindowInsetsCompat.BuilderImpl29
extends WindowInsetsCompat.BuilderImpl {
    final WindowInsets.Builder mPlatBuilder;

    WindowInsetsCompat.BuilderImpl29() {
        this.mPlatBuilder = new WindowInsets.Builder();
    }

    WindowInsetsCompat.BuilderImpl29(WindowInsetsCompat windowInsetsCompat) {
        super(windowInsetsCompat);
        windowInsetsCompat = windowInsetsCompat.toWindowInsets();
        windowInsetsCompat = windowInsetsCompat != null ? new WindowInsets.Builder((WindowInsets)windowInsetsCompat) : new WindowInsets.Builder();
        this.mPlatBuilder = windowInsetsCompat;
    }

    WindowInsetsCompat build() {
        this.applyInsetTypes();
        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat((WindowInsets)this.mPlatBuilder.build());
        windowInsetsCompat.setOverriddenInsets(this.mInsetsTypeMask);
        return windowInsetsCompat;
    }

    void setDisplayCutout(DisplayCutoutCompat object) {
        WindowInsets.Builder builder = this.mPlatBuilder;
        object = object != null ? object.unwrap() : null;
        builder.setDisplayCutout((DisplayCutout)object);
    }

    void setMandatorySystemGestureInsets(Insets insets) {
        this.mPlatBuilder.setMandatorySystemGestureInsets(insets.toPlatformInsets());
    }

    void setStableInsets(Insets insets) {
        this.mPlatBuilder.setStableInsets(insets.toPlatformInsets());
    }

    void setSystemGestureInsets(Insets insets) {
        this.mPlatBuilder.setSystemGestureInsets(insets.toPlatformInsets());
    }

    void setSystemWindowInsets(Insets insets) {
        this.mPlatBuilder.setSystemWindowInsets(insets.toPlatformInsets());
    }

    void setTappableElementInsets(Insets insets) {
        this.mPlatBuilder.setTappableElementInsets(insets.toPlatformInsets());
    }
}
