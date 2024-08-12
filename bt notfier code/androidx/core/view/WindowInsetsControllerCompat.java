/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.os.CancellationSignal
 *  android.view.View
 *  android.view.Window
 *  android.view.WindowInsetsController
 *  android.view.animation.Interpolator
 *  androidx.core.view.WindowInsetsAnimationControlListenerCompat
 *  androidx.core.view.WindowInsetsControllerCompat$Impl
 *  androidx.core.view.WindowInsetsControllerCompat$Impl20
 *  androidx.core.view.WindowInsetsControllerCompat$Impl23
 *  androidx.core.view.WindowInsetsControllerCompat$Impl26
 *  androidx.core.view.WindowInsetsControllerCompat$Impl30
 *  androidx.core.view.WindowInsetsControllerCompat$OnControllableInsetsChangedListener
 */
package androidx.core.view;

import android.os.Build;
import android.os.CancellationSignal;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;
import android.view.animation.Interpolator;
import androidx.core.view.WindowInsetsAnimationControlListenerCompat;
import androidx.core.view.WindowInsetsControllerCompat;

public final class WindowInsetsControllerCompat {
    public static final int BEHAVIOR_SHOW_BARS_BY_SWIPE = 1;
    public static final int BEHAVIOR_SHOW_BARS_BY_TOUCH = 0;
    public static final int BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE = 2;
    private final Impl mImpl;

    public WindowInsetsControllerCompat(Window window, View view) {
        this.mImpl = Build.VERSION.SDK_INT >= 30 ? new Impl30(window, this) : (Build.VERSION.SDK_INT >= 26 ? new Impl26(window, view) : (Build.VERSION.SDK_INT >= 23 ? new Impl23(window, view) : (Build.VERSION.SDK_INT >= 20 ? new Impl20(window, view) : new Impl())));
    }

    private WindowInsetsControllerCompat(WindowInsetsController windowInsetsController) {
        this.mImpl = Build.VERSION.SDK_INT >= 30 ? new Impl30(windowInsetsController, this) : new Impl();
    }

    public static WindowInsetsControllerCompat toWindowInsetsControllerCompat(WindowInsetsController windowInsetsController) {
        return new WindowInsetsControllerCompat(windowInsetsController);
    }

    public void addOnControllableInsetsChangedListener(OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        this.mImpl.addOnControllableInsetsChangedListener(onControllableInsetsChangedListener);
    }

    public void controlWindowInsetsAnimation(int n, long l, Interpolator interpolator, CancellationSignal cancellationSignal, WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat) {
        this.mImpl.controlWindowInsetsAnimation(n, l, interpolator, cancellationSignal, windowInsetsAnimationControlListenerCompat);
    }

    public int getSystemBarsBehavior() {
        return this.mImpl.getSystemBarsBehavior();
    }

    public void hide(int n) {
        this.mImpl.hide(n);
    }

    public boolean isAppearanceLightNavigationBars() {
        return this.mImpl.isAppearanceLightNavigationBars();
    }

    public boolean isAppearanceLightStatusBars() {
        return this.mImpl.isAppearanceLightStatusBars();
    }

    public void removeOnControllableInsetsChangedListener(OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        this.mImpl.removeOnControllableInsetsChangedListener(onControllableInsetsChangedListener);
    }

    public void setAppearanceLightNavigationBars(boolean bl) {
        this.mImpl.setAppearanceLightNavigationBars(bl);
    }

    public void setAppearanceLightStatusBars(boolean bl) {
        this.mImpl.setAppearanceLightStatusBars(bl);
    }

    public void setSystemBarsBehavior(int n) {
        this.mImpl.setSystemBarsBehavior(n);
    }

    public void show(int n) {
        this.mImpl.show(n);
    }
}
