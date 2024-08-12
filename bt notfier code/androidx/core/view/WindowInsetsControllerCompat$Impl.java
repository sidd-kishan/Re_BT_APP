/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.CancellationSignal
 *  android.view.animation.Interpolator
 *  androidx.core.view.WindowInsetsAnimationControlListenerCompat
 *  androidx.core.view.WindowInsetsControllerCompat$OnControllableInsetsChangedListener
 */
package androidx.core.view;

import android.os.CancellationSignal;
import android.view.animation.Interpolator;
import androidx.core.view.WindowInsetsAnimationControlListenerCompat;
import androidx.core.view.WindowInsetsControllerCompat;

private static class WindowInsetsControllerCompat.Impl {
    WindowInsetsControllerCompat.Impl() {
    }

    void addOnControllableInsetsChangedListener(WindowInsetsControllerCompat.OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
    }

    void controlWindowInsetsAnimation(int n, long l, Interpolator interpolator, CancellationSignal cancellationSignal, WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat) {
    }

    int getSystemBarsBehavior() {
        return 0;
    }

    void hide(int n) {
    }

    public boolean isAppearanceLightNavigationBars() {
        return false;
    }

    public boolean isAppearanceLightStatusBars() {
        return false;
    }

    void removeOnControllableInsetsChangedListener(WindowInsetsControllerCompat.OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
    }

    public void setAppearanceLightNavigationBars(boolean bl) {
    }

    public void setAppearanceLightStatusBars(boolean bl) {
    }

    void setSystemBarsBehavior(int n) {
    }

    void show(int n) {
    }
}
