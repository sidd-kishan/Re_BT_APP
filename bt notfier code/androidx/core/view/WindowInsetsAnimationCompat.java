/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.WindowInsetsAnimation
 *  android.view.animation.Interpolator
 *  androidx.core.view.WindowInsetsAnimationCompat$Callback
 *  androidx.core.view.WindowInsetsAnimationCompat$Impl
 *  androidx.core.view.WindowInsetsAnimationCompat$Impl21
 *  androidx.core.view.WindowInsetsAnimationCompat$Impl30
 */
package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.WindowInsetsAnimation;
import android.view.animation.Interpolator;
import androidx.core.view.WindowInsetsAnimationCompat;

/*
 * Exception performing whole class analysis ignored.
 */
public final class WindowInsetsAnimationCompat {
    private static final boolean DEBUG = false;
    private static final String TAG = "WindowInsetsAnimCompat";
    private Impl mImpl;

    public WindowInsetsAnimationCompat(int n, Interpolator interpolator, long l) {
        this.mImpl = Build.VERSION.SDK_INT >= 30 ? new Impl30(n, interpolator, l) : (Build.VERSION.SDK_INT >= 21 ? new Impl21(n, interpolator, l) : new Impl(0, interpolator, l));
    }

    private WindowInsetsAnimationCompat(WindowInsetsAnimation windowInsetsAnimation) {
        this(0, null, 0L);
        if (Build.VERSION.SDK_INT < 30) return;
        this.mImpl = new Impl30(windowInsetsAnimation);
    }

    static void setCallback(View view, Callback callback) {
        if (Build.VERSION.SDK_INT >= 30) {
            Impl30.setCallback((View)view, (Callback)callback);
        } else {
            if (Build.VERSION.SDK_INT < 21) return;
            Impl21.setCallback((View)view, (Callback)callback);
        }
    }

    static WindowInsetsAnimationCompat toWindowInsetsAnimationCompat(WindowInsetsAnimation windowInsetsAnimation) {
        return new WindowInsetsAnimationCompat(windowInsetsAnimation);
    }

    public float getAlpha() {
        return this.mImpl.getAlpha();
    }

    public long getDurationMillis() {
        return this.mImpl.getDurationMillis();
    }

    public float getFraction() {
        return this.mImpl.getFraction();
    }

    public float getInterpolatedFraction() {
        return this.mImpl.getInterpolatedFraction();
    }

    public Interpolator getInterpolator() {
        return this.mImpl.getInterpolator();
    }

    public int getTypeMask() {
        return this.mImpl.getTypeMask();
    }

    public void setAlpha(float f) {
        this.mImpl.setAlpha(f);
    }

    public void setFraction(float f) {
        this.mImpl.setFraction(f);
    }
}
