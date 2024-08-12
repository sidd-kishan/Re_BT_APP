/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Insets
 *  android.view.View
 *  android.view.WindowInsetsAnimation
 *  android.view.WindowInsetsAnimation$Bounds
 *  android.view.WindowInsetsAnimation$Callback
 *  android.view.animation.Interpolator
 *  androidx.core.graphics.Insets
 *  androidx.core.view.WindowInsetsAnimationCompat$BoundsCompat
 *  androidx.core.view.WindowInsetsAnimationCompat$Callback
 *  androidx.core.view.WindowInsetsAnimationCompat$Impl
 *  androidx.core.view.WindowInsetsAnimationCompat$Impl30$ProxyCallback
 */
package androidx.core.view;

import android.graphics.Insets;
import android.view.View;
import android.view.WindowInsetsAnimation;
import android.view.animation.Interpolator;
import androidx.core.view.WindowInsetsAnimationCompat;

private static class WindowInsetsAnimationCompat.Impl30
extends WindowInsetsAnimationCompat.Impl {
    private final WindowInsetsAnimation mWrapped;

    WindowInsetsAnimationCompat.Impl30(int n, Interpolator interpolator, long l) {
        this(new WindowInsetsAnimation(n, interpolator, l));
    }

    WindowInsetsAnimationCompat.Impl30(WindowInsetsAnimation windowInsetsAnimation) {
        super(0, null, 0L);
        this.mWrapped = windowInsetsAnimation;
    }

    public static WindowInsetsAnimation.Bounds createPlatformBounds(WindowInsetsAnimationCompat.BoundsCompat boundsCompat) {
        return new WindowInsetsAnimation.Bounds(boundsCompat.getLowerBound().toPlatformInsets(), boundsCompat.getUpperBound().toPlatformInsets());
    }

    public static androidx.core.graphics.Insets getHigherBounds(WindowInsetsAnimation.Bounds bounds) {
        return androidx.core.graphics.Insets.toCompatInsets((Insets)bounds.getUpperBound());
    }

    public static androidx.core.graphics.Insets getLowerBounds(WindowInsetsAnimation.Bounds bounds) {
        return androidx.core.graphics.Insets.toCompatInsets((Insets)bounds.getLowerBound());
    }

    public static void setCallback(View view, WindowInsetsAnimationCompat.Callback object) {
        object = object != null ? new ProxyCallback(object) : null;
        view.setWindowInsetsAnimationCallback((WindowInsetsAnimation.Callback)object);
    }

    public long getDurationMillis() {
        return this.mWrapped.getDurationMillis();
    }

    public float getFraction() {
        return this.mWrapped.getFraction();
    }

    public float getInterpolatedFraction() {
        return this.mWrapped.getInterpolatedFraction();
    }

    public Interpolator getInterpolator() {
        return this.mWrapped.getInterpolator();
    }

    public int getTypeMask() {
        return this.mWrapped.getTypeMask();
    }

    public void setFraction(float f) {
        this.mWrapped.setFraction(f);
    }
}
