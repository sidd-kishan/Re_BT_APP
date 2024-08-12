/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.core.graphics.Insets
 *  androidx.core.util.ObjectsCompat
 *  androidx.core.view.DisplayCutoutCompat
 *  androidx.core.view.WindowInsetsCompat
 *  androidx.core.view.WindowInsetsCompat$Builder
 */
package androidx.core.view;

import android.view.View;
import androidx.core.graphics.Insets;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.DisplayCutoutCompat;
import androidx.core.view.WindowInsetsCompat;

private static class WindowInsetsCompat.Impl {
    static final WindowInsetsCompat CONSUMED = new WindowInsetsCompat.Builder().build().consumeDisplayCutout().consumeStableInsets().consumeSystemWindowInsets();
    final WindowInsetsCompat mHost;

    WindowInsetsCompat.Impl(WindowInsetsCompat windowInsetsCompat) {
        this.mHost = windowInsetsCompat;
    }

    WindowInsetsCompat consumeDisplayCutout() {
        return this.mHost;
    }

    WindowInsetsCompat consumeStableInsets() {
        return this.mHost;
    }

    WindowInsetsCompat consumeSystemWindowInsets() {
        return this.mHost;
    }

    void copyRootViewBounds(View view) {
    }

    void copyWindowDataInto(WindowInsetsCompat windowInsetsCompat) {
    }

    public boolean equals(Object object) {
        boolean bl = true;
        if (this == object) {
            return true;
        }
        if (!(object instanceof WindowInsetsCompat.Impl)) {
            return false;
        }
        object = (WindowInsetsCompat.Impl)object;
        if (this.isRound() == ((WindowInsetsCompat.Impl)object).isRound() && this.isConsumed() == ((WindowInsetsCompat.Impl)object).isConsumed() && ObjectsCompat.equals((Object)this.getSystemWindowInsets(), (Object)((WindowInsetsCompat.Impl)object).getSystemWindowInsets()) && ObjectsCompat.equals((Object)this.getStableInsets(), (Object)((WindowInsetsCompat.Impl)object).getStableInsets()) && ObjectsCompat.equals((Object)this.getDisplayCutout(), (Object)((WindowInsetsCompat.Impl)object).getDisplayCutout())) return bl;
        bl = false;
        return bl;
    }

    DisplayCutoutCompat getDisplayCutout() {
        return null;
    }

    Insets getInsets(int n) {
        return Insets.NONE;
    }

    Insets getInsetsIgnoringVisibility(int n) {
        if ((n & 8) != 0) throw new IllegalArgumentException("Unable to query the maximum insets for IME");
        return Insets.NONE;
    }

    Insets getMandatorySystemGestureInsets() {
        return this.getSystemWindowInsets();
    }

    Insets getStableInsets() {
        return Insets.NONE;
    }

    Insets getSystemGestureInsets() {
        return this.getSystemWindowInsets();
    }

    Insets getSystemWindowInsets() {
        return Insets.NONE;
    }

    Insets getTappableElementInsets() {
        return this.getSystemWindowInsets();
    }

    public int hashCode() {
        return ObjectsCompat.hash((Object[])new Object[]{this.isRound(), this.isConsumed(), this.getSystemWindowInsets(), this.getStableInsets(), this.getDisplayCutout()});
    }

    WindowInsetsCompat inset(int n, int n2, int n3, int n4) {
        return CONSUMED;
    }

    boolean isConsumed() {
        return false;
    }

    boolean isRound() {
        return false;
    }

    boolean isVisible(int n) {
        return true;
    }

    public void setOverriddenInsets(Insets[] insetsArray) {
    }

    void setRootViewData(Insets insets) {
    }

    void setRootWindowInsets(WindowInsetsCompat windowInsetsCompat) {
    }

    public void setStableInsets(Insets insets) {
    }
}
