/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.WindowInsets
 *  android.view.WindowInsetsAnimation
 *  android.view.WindowInsetsAnimation$Bounds
 *  android.view.WindowInsetsAnimation$Callback
 *  androidx.core.view.WindowInsetsAnimationCompat
 *  androidx.core.view.WindowInsetsAnimationCompat$BoundsCompat
 *  androidx.core.view.WindowInsetsAnimationCompat$Callback
 *  androidx.core.view.WindowInsetsCompat
 */
package androidx.core.view;

import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/*
 * Exception performing whole class analysis ignored.
 */
private static class WindowInsetsAnimationCompat.Impl30.ProxyCallback
extends WindowInsetsAnimation.Callback {
    private final HashMap<WindowInsetsAnimation, WindowInsetsAnimationCompat> mAnimations = new HashMap();
    private final WindowInsetsAnimationCompat.Callback mCompat;
    private List<WindowInsetsAnimationCompat> mRORunningAnimations;
    private ArrayList<WindowInsetsAnimationCompat> mTmpRunningAnimations;

    WindowInsetsAnimationCompat.Impl30.ProxyCallback(WindowInsetsAnimationCompat.Callback callback) {
        super(callback.getDispatchMode());
        this.mCompat = callback;
    }

    private WindowInsetsAnimationCompat getWindowInsetsAnimationCompat(WindowInsetsAnimation windowInsetsAnimation) {
        WindowInsetsAnimationCompat windowInsetsAnimationCompat;
        WindowInsetsAnimationCompat windowInsetsAnimationCompat2 = windowInsetsAnimationCompat = this.mAnimations.get(windowInsetsAnimation);
        if (windowInsetsAnimationCompat != null) return windowInsetsAnimationCompat2;
        windowInsetsAnimationCompat2 = WindowInsetsAnimationCompat.toWindowInsetsAnimationCompat((WindowInsetsAnimation)windowInsetsAnimation);
        this.mAnimations.put(windowInsetsAnimation, windowInsetsAnimationCompat2);
        return windowInsetsAnimationCompat2;
    }

    public void onEnd(WindowInsetsAnimation windowInsetsAnimation) {
        this.mCompat.onEnd(this.getWindowInsetsAnimationCompat(windowInsetsAnimation));
        this.mAnimations.remove(windowInsetsAnimation);
    }

    public void onPrepare(WindowInsetsAnimation windowInsetsAnimation) {
        this.mCompat.onPrepare(this.getWindowInsetsAnimationCompat(windowInsetsAnimation));
    }

    public WindowInsets onProgress(WindowInsets windowInsets, List<WindowInsetsAnimation> list) {
        Object object = this.mTmpRunningAnimations;
        if (object == null) {
            object = new ArrayList(list.size());
            this.mTmpRunningAnimations = object;
            this.mRORunningAnimations = Collections.unmodifiableList(object);
        } else {
            object.clear();
        }
        int n = list.size() - 1;
        while (n >= 0) {
            WindowInsetsAnimation windowInsetsAnimation = list.get(n);
            object = this.getWindowInsetsAnimationCompat(windowInsetsAnimation);
            object.setFraction(windowInsetsAnimation.getFraction());
            this.mTmpRunningAnimations.add((WindowInsetsAnimationCompat)object);
            --n;
        }
        return this.mCompat.onProgress(WindowInsetsCompat.toWindowInsetsCompat((WindowInsets)windowInsets), this.mRORunningAnimations).toWindowInsets();
    }

    public WindowInsetsAnimation.Bounds onStart(WindowInsetsAnimation windowInsetsAnimation, WindowInsetsAnimation.Bounds bounds) {
        return this.mCompat.onStart(this.getWindowInsetsAnimationCompat(windowInsetsAnimation), WindowInsetsAnimationCompat.BoundsCompat.toBoundsCompat((WindowInsetsAnimation.Bounds)bounds)).toBounds();
    }
}
