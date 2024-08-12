/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator$AnimatorListener
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.view.View
 *  android.view.View$OnApplyWindowInsetsListener
 *  android.view.WindowInsets
 *  android.view.animation.DecelerateInterpolator
 *  android.view.animation.Interpolator
 *  androidx.core.view.OneShotPreDrawListener
 *  androidx.core.view.ViewCompat
 *  androidx.core.view.WindowInsetsAnimationCompat
 *  androidx.core.view.WindowInsetsAnimationCompat$BoundsCompat
 *  androidx.core.view.WindowInsetsAnimationCompat$Callback
 *  androidx.core.view.WindowInsetsAnimationCompat$Impl21
 *  androidx.core.view.WindowInsetsCompat
 *  androidx.core.view.WindowInsetsCompat$Builder
 */
package androidx.core.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.WindowInsets;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.Objects;

/*
 * Exception performing whole class analysis ignored.
 */
private static class WindowInsetsAnimationCompat.Impl21.Impl21OnApplyWindowInsetsListener
implements View.OnApplyWindowInsetsListener {
    private static final int COMPAT_ANIMATION_DURATION = 160;
    final WindowInsetsAnimationCompat.Callback mCallback;
    private WindowInsetsCompat mLastInsets;

    WindowInsetsAnimationCompat.Impl21.Impl21OnApplyWindowInsetsListener(View object, WindowInsetsAnimationCompat.Callback callback) {
        this.mCallback = callback;
        object = ViewCompat.getRootWindowInsets((View)object);
        object = object != null ? new WindowInsetsCompat.Builder((WindowInsetsCompat)object).build() : null;
        this.mLastInsets = object;
    }

    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        if (!view.isLaidOut()) {
            this.mLastInsets = WindowInsetsCompat.toWindowInsetsCompat((WindowInsets)windowInsets, (View)view);
            return WindowInsetsAnimationCompat.Impl21.forwardToViewIfNeeded((View)view, (WindowInsets)windowInsets);
        }
        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat((WindowInsets)windowInsets, (View)view);
        if (this.mLastInsets == null) {
            this.mLastInsets = ViewCompat.getRootWindowInsets((View)view);
        }
        if (this.mLastInsets == null) {
            this.mLastInsets = windowInsetsCompat;
            return WindowInsetsAnimationCompat.Impl21.forwardToViewIfNeeded((View)view, (WindowInsets)windowInsets);
        }
        WindowInsetsAnimationCompat.Callback callback = WindowInsetsAnimationCompat.Impl21.getCallback((View)view);
        if (callback != null && Objects.equals(callback.mDispachedInsets, windowInsets)) {
            return WindowInsetsAnimationCompat.Impl21.forwardToViewIfNeeded((View)view, (WindowInsets)windowInsets);
        }
        int n = WindowInsetsAnimationCompat.Impl21.buildAnimationMask((WindowInsetsCompat)windowInsetsCompat, (WindowInsetsCompat)this.mLastInsets);
        if (n == 0) {
            return WindowInsetsAnimationCompat.Impl21.forwardToViewIfNeeded((View)view, (WindowInsets)windowInsets);
        }
        WindowInsetsCompat windowInsetsCompat2 = this.mLastInsets;
        WindowInsetsAnimationCompat windowInsetsAnimationCompat = new WindowInsetsAnimationCompat(n, (Interpolator)new DecelerateInterpolator(), 160L);
        windowInsetsAnimationCompat.setFraction(0.0f);
        callback = ValueAnimator.ofFloat((float[])new float[]{0.0f, 1.0f}).setDuration(windowInsetsAnimationCompat.getDurationMillis());
        WindowInsetsAnimationCompat.BoundsCompat boundsCompat = WindowInsetsAnimationCompat.Impl21.computeAnimationBounds((WindowInsetsCompat)windowInsetsCompat, (WindowInsetsCompat)windowInsetsCompat2, (int)n);
        WindowInsetsAnimationCompat.Impl21.dispatchOnPrepare((View)view, (WindowInsetsAnimationCompat)windowInsetsAnimationCompat, (WindowInsets)windowInsets, (boolean)false);
        callback.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new /* Unavailable Anonymous Inner Class!! */);
        callback.addListener((Animator.AnimatorListener)new /* Unavailable Anonymous Inner Class!! */);
        OneShotPreDrawListener.add((View)view, (Runnable)new /* Unavailable Anonymous Inner Class!! */);
        this.mLastInsets = windowInsetsCompat;
        return WindowInsetsAnimationCompat.Impl21.forwardToViewIfNeeded((View)view, (WindowInsets)windowInsets);
    }
}
