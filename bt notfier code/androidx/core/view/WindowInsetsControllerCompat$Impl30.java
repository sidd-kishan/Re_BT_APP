/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.CancellationSignal
 *  android.view.Window
 *  android.view.WindowInsetsAnimationControlListener
 *  android.view.WindowInsetsController
 *  android.view.WindowInsetsController$OnControllableInsetsChangedListener
 *  android.view.animation.Interpolator
 *  androidx.collection.SimpleArrayMap
 *  androidx.core.view.WindowInsetsAnimationControlListenerCompat
 *  androidx.core.view.WindowInsetsControllerCompat
 *  androidx.core.view.WindowInsetsControllerCompat$Impl
 *  androidx.core.view.WindowInsetsControllerCompat$Impl30$2
 *  androidx.core.view.WindowInsetsControllerCompat$OnControllableInsetsChangedListener
 */
package androidx.core.view;

import android.os.CancellationSignal;
import android.view.Window;
import android.view.WindowInsetsAnimationControlListener;
import android.view.WindowInsetsController;
import android.view.animation.Interpolator;
import androidx.collection.SimpleArrayMap;
import androidx.core.view.WindowInsetsAnimationControlListenerCompat;
import androidx.core.view.WindowInsetsControllerCompat;

private static class WindowInsetsControllerCompat.Impl30
extends WindowInsetsControllerCompat.Impl {
    final WindowInsetsControllerCompat mCompatController;
    final WindowInsetsController mInsetsController;
    private final SimpleArrayMap<WindowInsetsControllerCompat.OnControllableInsetsChangedListener, WindowInsetsController.OnControllableInsetsChangedListener> mListeners = new SimpleArrayMap();

    WindowInsetsControllerCompat.Impl30(Window window, WindowInsetsControllerCompat windowInsetsControllerCompat) {
        this(window.getInsetsController(), windowInsetsControllerCompat);
    }

    WindowInsetsControllerCompat.Impl30(WindowInsetsController windowInsetsController, WindowInsetsControllerCompat windowInsetsControllerCompat) {
        this.mInsetsController = windowInsetsController;
        this.mCompatController = windowInsetsControllerCompat;
    }

    void addOnControllableInsetsChangedListener(WindowInsetsControllerCompat.OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        if (this.mListeners.containsKey((Object)onControllableInsetsChangedListener)) {
            return;
        }
        2 var2_2 = new /* Unavailable Anonymous Inner Class!! */;
        this.mListeners.put((Object)onControllableInsetsChangedListener, (Object)var2_2);
        this.mInsetsController.addOnControllableInsetsChangedListener((WindowInsetsController.OnControllableInsetsChangedListener)var2_2);
    }

    void controlWindowInsetsAnimation(int n, long l, Interpolator interpolator, CancellationSignal cancellationSignal, WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat) {
        windowInsetsAnimationControlListenerCompat = new /* Unavailable Anonymous Inner Class!! */;
        this.mInsetsController.controlWindowInsetsAnimation(n, l, interpolator, cancellationSignal, (WindowInsetsAnimationControlListener)windowInsetsAnimationControlListenerCompat);
    }

    int getSystemBarsBehavior() {
        return this.mInsetsController.getSystemBarsBehavior();
    }

    void hide(int n) {
        this.mInsetsController.hide(n);
    }

    public boolean isAppearanceLightNavigationBars() {
        boolean bl = (this.mInsetsController.getSystemBarsAppearance() & 0x10) != 0;
        return bl;
    }

    public boolean isAppearanceLightStatusBars() {
        boolean bl = (this.mInsetsController.getSystemBarsAppearance() & 8) != 0;
        return bl;
    }

    void removeOnControllableInsetsChangedListener(WindowInsetsControllerCompat.OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        if ((onControllableInsetsChangedListener = (WindowInsetsController.OnControllableInsetsChangedListener)this.mListeners.remove((Object)onControllableInsetsChangedListener)) == null) return;
        this.mInsetsController.removeOnControllableInsetsChangedListener((WindowInsetsController.OnControllableInsetsChangedListener)onControllableInsetsChangedListener);
    }

    public void setAppearanceLightNavigationBars(boolean bl) {
        if (bl) {
            this.mInsetsController.setSystemBarsAppearance(16, 16);
        } else {
            this.mInsetsController.setSystemBarsAppearance(0, 16);
        }
    }

    public void setAppearanceLightStatusBars(boolean bl) {
        if (bl) {
            this.mInsetsController.setSystemBarsAppearance(8, 8);
        } else {
            this.mInsetsController.setSystemBarsAppearance(0, 8);
        }
    }

    void setSystemBarsBehavior(int n) {
        this.mInsetsController.setSystemBarsBehavior(n);
    }

    void show(int n) {
        this.mInsetsController.show(n);
    }
}
