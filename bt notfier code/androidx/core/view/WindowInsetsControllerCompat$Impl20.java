/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.CancellationSignal
 *  android.view.View
 *  android.view.Window
 *  android.view.animation.Interpolator
 *  android.view.inputmethod.InputMethodManager
 *  androidx.core.view.WindowInsetsAnimationControlListenerCompat
 *  androidx.core.view.WindowInsetsControllerCompat$Impl
 *  androidx.core.view.WindowInsetsControllerCompat$OnControllableInsetsChangedListener
 */
package androidx.core.view;

import android.os.CancellationSignal;
import android.view.View;
import android.view.Window;
import android.view.animation.Interpolator;
import android.view.inputmethod.InputMethodManager;
import androidx.core.view.WindowInsetsAnimationControlListenerCompat;
import androidx.core.view.WindowInsetsControllerCompat;

private static class WindowInsetsControllerCompat.Impl20
extends WindowInsetsControllerCompat.Impl {
    private final View mView;
    protected final Window mWindow;

    WindowInsetsControllerCompat.Impl20(Window window, View view) {
        this.mWindow = window;
        this.mView = view;
    }

    private void hideForType(int n) {
        if (n == 1) {
            this.setSystemUiFlag(4);
            return;
        }
        if (n == 2) {
            this.setSystemUiFlag(2);
            return;
        }
        if (n != 8) return;
        ((InputMethodManager)this.mWindow.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.mWindow.getDecorView().getWindowToken(), 0);
    }

    private void showForType(int n) {
        if (n == 1) {
            this.unsetSystemUiFlag(4);
            this.unsetWindowFlag(1024);
            return;
        }
        if (n == 2) {
            this.unsetSystemUiFlag(2);
            return;
        }
        if (n != 8) return;
        View view = this.mView;
        if (view != null && (view.isInEditMode() || view.onCheckIsTextEditor())) {
            view.requestFocus();
        } else {
            view = this.mWindow.getCurrentFocus();
        }
        View view2 = view;
        if (view == null) {
            view2 = this.mWindow.findViewById(0x1020002);
        }
        if (view2 == null) return;
        if (!view2.hasWindowFocus()) return;
        view2.post((Runnable)new /* Unavailable Anonymous Inner Class!! */);
    }

    void addOnControllableInsetsChangedListener(WindowInsetsControllerCompat.OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
    }

    void controlWindowInsetsAnimation(int n, long l, Interpolator interpolator, CancellationSignal cancellationSignal, WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat) {
    }

    int getSystemBarsBehavior() {
        return 0;
    }

    void hide(int n) {
        int n2 = 1;
        while (n2 <= 256) {
            if ((n & n2) != 0) {
                this.hideForType(n2);
            }
            n2 <<= 1;
        }
    }

    void removeOnControllableInsetsChangedListener(WindowInsetsControllerCompat.OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
    }

    void setSystemBarsBehavior(int n) {
        if (n != 0) {
            if (n != 1) {
                if (n != 2) return;
                this.unsetSystemUiFlag(2048);
                this.setSystemUiFlag(4096);
            } else {
                this.unsetSystemUiFlag(4096);
                this.setSystemUiFlag(2048);
            }
        } else {
            this.unsetSystemUiFlag(6144);
        }
    }

    protected void setSystemUiFlag(int n) {
        View view = this.mWindow.getDecorView();
        view.setSystemUiVisibility(n | view.getSystemUiVisibility());
    }

    protected void setWindowFlag(int n) {
        this.mWindow.addFlags(n);
    }

    void show(int n) {
        int n2 = 1;
        while (n2 <= 256) {
            if ((n & n2) != 0) {
                this.showForType(n2);
            }
            n2 <<= 1;
        }
    }

    protected void unsetSystemUiFlag(int n) {
        View view = this.mWindow.getDecorView();
        view.setSystemUiVisibility(~n & view.getSystemUiVisibility());
    }

    protected void unsetWindowFlag(int n) {
        this.mWindow.clearFlags(n);
    }
}
