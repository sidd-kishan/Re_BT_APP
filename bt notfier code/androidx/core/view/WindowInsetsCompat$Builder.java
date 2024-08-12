/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  androidx.core.graphics.Insets
 *  androidx.core.view.DisplayCutoutCompat
 *  androidx.core.view.WindowInsetsCompat
 *  androidx.core.view.WindowInsetsCompat$BuilderImpl
 *  androidx.core.view.WindowInsetsCompat$BuilderImpl20
 *  androidx.core.view.WindowInsetsCompat$BuilderImpl29
 *  androidx.core.view.WindowInsetsCompat$BuilderImpl30
 */
package androidx.core.view;

import android.os.Build;
import androidx.core.graphics.Insets;
import androidx.core.view.DisplayCutoutCompat;
import androidx.core.view.WindowInsetsCompat;

public static final class WindowInsetsCompat.Builder {
    private final WindowInsetsCompat.BuilderImpl mImpl;

    public WindowInsetsCompat.Builder() {
        this.mImpl = Build.VERSION.SDK_INT >= 30 ? new WindowInsetsCompat.BuilderImpl30() : (Build.VERSION.SDK_INT >= 29 ? new WindowInsetsCompat.BuilderImpl29() : (Build.VERSION.SDK_INT >= 20 ? new WindowInsetsCompat.BuilderImpl20() : new WindowInsetsCompat.BuilderImpl()));
    }

    public WindowInsetsCompat.Builder(WindowInsetsCompat windowInsetsCompat) {
        this.mImpl = Build.VERSION.SDK_INT >= 30 ? new WindowInsetsCompat.BuilderImpl30(windowInsetsCompat) : (Build.VERSION.SDK_INT >= 29 ? new WindowInsetsCompat.BuilderImpl29(windowInsetsCompat) : (Build.VERSION.SDK_INT >= 20 ? new WindowInsetsCompat.BuilderImpl20(windowInsetsCompat) : new WindowInsetsCompat.BuilderImpl(windowInsetsCompat)));
    }

    public WindowInsetsCompat build() {
        return this.mImpl.build();
    }

    public WindowInsetsCompat.Builder setDisplayCutout(DisplayCutoutCompat displayCutoutCompat) {
        this.mImpl.setDisplayCutout(displayCutoutCompat);
        return this;
    }

    public WindowInsetsCompat.Builder setInsets(int n, Insets insets) {
        this.mImpl.setInsets(n, insets);
        return this;
    }

    public WindowInsetsCompat.Builder setInsetsIgnoringVisibility(int n, Insets insets) {
        this.mImpl.setInsetsIgnoringVisibility(n, insets);
        return this;
    }

    @Deprecated
    public WindowInsetsCompat.Builder setMandatorySystemGestureInsets(Insets insets) {
        this.mImpl.setMandatorySystemGestureInsets(insets);
        return this;
    }

    @Deprecated
    public WindowInsetsCompat.Builder setStableInsets(Insets insets) {
        this.mImpl.setStableInsets(insets);
        return this;
    }

    @Deprecated
    public WindowInsetsCompat.Builder setSystemGestureInsets(Insets insets) {
        this.mImpl.setSystemGestureInsets(insets);
        return this;
    }

    @Deprecated
    public WindowInsetsCompat.Builder setSystemWindowInsets(Insets insets) {
        this.mImpl.setSystemWindowInsets(insets);
        return this;
    }

    @Deprecated
    public WindowInsetsCompat.Builder setTappableElementInsets(Insets insets) {
        this.mImpl.setTappableElementInsets(insets);
        return this;
    }

    public WindowInsetsCompat.Builder setVisible(int n, boolean bl) {
        this.mImpl.setVisible(n, bl);
        return this;
    }
}
