/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.animation.Interpolator
 */
package androidx.core.view;

import android.view.animation.Interpolator;

private static class WindowInsetsAnimationCompat.Impl {
    private float mAlpha;
    private final long mDurationMillis;
    private float mFraction;
    private final Interpolator mInterpolator;
    private final int mTypeMask;

    WindowInsetsAnimationCompat.Impl(int n, Interpolator interpolator, long l) {
        this.mTypeMask = n;
        this.mInterpolator = interpolator;
        this.mDurationMillis = l;
    }

    public float getAlpha() {
        return this.mAlpha;
    }

    public long getDurationMillis() {
        return this.mDurationMillis;
    }

    public float getFraction() {
        return this.mFraction;
    }

    public float getInterpolatedFraction() {
        Interpolator interpolator = this.mInterpolator;
        if (interpolator == null) return this.mFraction;
        return interpolator.getInterpolation(this.mFraction);
    }

    public Interpolator getInterpolator() {
        return this.mInterpolator;
    }

    public int getTypeMask() {
        return this.mTypeMask;
    }

    public void setAlpha(float f) {
        this.mAlpha = f;
    }

    public void setFraction(float f) {
        this.mFraction = f;
    }
}
