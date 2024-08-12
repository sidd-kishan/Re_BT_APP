/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.WindowInsets
 *  androidx.core.graphics.Insets
 *  androidx.core.util.ObjectsCompat
 *  androidx.core.util.Preconditions
 *  androidx.core.view.DisplayCutoutCompat
 *  androidx.core.view.ViewCompat
 *  androidx.core.view.WindowInsetsCompat$Builder
 *  androidx.core.view.WindowInsetsCompat$Impl
 *  androidx.core.view.WindowInsetsCompat$Impl20
 *  androidx.core.view.WindowInsetsCompat$Impl21
 *  androidx.core.view.WindowInsetsCompat$Impl28
 *  androidx.core.view.WindowInsetsCompat$Impl29
 *  androidx.core.view.WindowInsetsCompat$Impl30
 *  androidx.core.view.WindowInsetsCompat$Type
 */
package androidx.core.view;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import androidx.core.graphics.Insets;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.DisplayCutoutCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/*
 * Exception performing whole class analysis ignored.
 */
public class WindowInsetsCompat {
    public static final WindowInsetsCompat CONSUMED = Build.VERSION.SDK_INT >= 30 ? Impl30.CONSUMED : Impl.CONSUMED;
    private static final String TAG = "WindowInsetsCompat";
    private final Impl mImpl;

    private WindowInsetsCompat(WindowInsets windowInsets) {
        this.mImpl = Build.VERSION.SDK_INT >= 30 ? new Impl30(this, windowInsets) : (Build.VERSION.SDK_INT >= 29 ? new Impl29(this, windowInsets) : (Build.VERSION.SDK_INT >= 28 ? new Impl28(this, windowInsets) : (Build.VERSION.SDK_INT >= 21 ? new Impl21(this, windowInsets) : (Build.VERSION.SDK_INT >= 20 ? new Impl20(this, windowInsets) : new Impl(this)))));
    }

    public WindowInsetsCompat(WindowInsetsCompat windowInsetsCompat) {
        if (windowInsetsCompat != null) {
            windowInsetsCompat = windowInsetsCompat.mImpl;
            this.mImpl = Build.VERSION.SDK_INT >= 30 && windowInsetsCompat instanceof Impl30 ? new Impl30(this, (Impl30)windowInsetsCompat) : (Build.VERSION.SDK_INT >= 29 && windowInsetsCompat instanceof Impl29 ? new Impl29(this, (Impl29)windowInsetsCompat) : (Build.VERSION.SDK_INT >= 28 && windowInsetsCompat instanceof Impl28 ? new Impl28(this, (Impl28)windowInsetsCompat) : (Build.VERSION.SDK_INT >= 21 && windowInsetsCompat instanceof Impl21 ? new Impl21(this, (Impl21)windowInsetsCompat) : (Build.VERSION.SDK_INT >= 20 && windowInsetsCompat instanceof Impl20 ? new Impl20(this, (Impl20)windowInsetsCompat) : new Impl(this)))));
            windowInsetsCompat.copyWindowDataInto(this);
        } else {
            this.mImpl = new Impl(this);
        }
    }

    static Insets insetInsets(Insets insets, int n, int n2, int n3, int n4) {
        int n5 = Math.max(0, insets.left - n);
        int n6 = Math.max(0, insets.top - n2);
        int n7 = Math.max(0, insets.right - n3);
        int n8 = Math.max(0, insets.bottom - n4);
        if (n5 != n) return Insets.of((int)n5, (int)n6, (int)n7, (int)n8);
        if (n6 != n2) return Insets.of((int)n5, (int)n6, (int)n7, (int)n8);
        if (n7 != n3) return Insets.of((int)n5, (int)n6, (int)n7, (int)n8);
        if (n8 != n4) return Insets.of((int)n5, (int)n6, (int)n7, (int)n8);
        return insets;
    }

    public static WindowInsetsCompat toWindowInsetsCompat(WindowInsets windowInsets) {
        return WindowInsetsCompat.toWindowInsetsCompat(windowInsets, null);
    }

    public static WindowInsetsCompat toWindowInsetsCompat(WindowInsets object, View view) {
        object = new WindowInsetsCompat((WindowInsets)Preconditions.checkNotNull((Object)object));
        if (view == null) return object;
        if (!view.isAttachedToWindow()) return object;
        ((WindowInsetsCompat)object).setRootWindowInsets(ViewCompat.getRootWindowInsets((View)view));
        ((WindowInsetsCompat)object).copyRootViewBounds(view.getRootView());
        return object;
    }

    @Deprecated
    public WindowInsetsCompat consumeDisplayCutout() {
        return this.mImpl.consumeDisplayCutout();
    }

    @Deprecated
    public WindowInsetsCompat consumeStableInsets() {
        return this.mImpl.consumeStableInsets();
    }

    @Deprecated
    public WindowInsetsCompat consumeSystemWindowInsets() {
        return this.mImpl.consumeSystemWindowInsets();
    }

    void copyRootViewBounds(View view) {
        this.mImpl.copyRootViewBounds(view);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof WindowInsetsCompat)) {
            return false;
        }
        object = (WindowInsetsCompat)object;
        return ObjectsCompat.equals((Object)this.mImpl, (Object)((WindowInsetsCompat)object).mImpl);
    }

    public DisplayCutoutCompat getDisplayCutout() {
        return this.mImpl.getDisplayCutout();
    }

    public Insets getInsets(int n) {
        return this.mImpl.getInsets(n);
    }

    public Insets getInsetsIgnoringVisibility(int n) {
        return this.mImpl.getInsetsIgnoringVisibility(n);
    }

    @Deprecated
    public Insets getMandatorySystemGestureInsets() {
        return this.mImpl.getMandatorySystemGestureInsets();
    }

    @Deprecated
    public int getStableInsetBottom() {
        return this.mImpl.getStableInsets().bottom;
    }

    @Deprecated
    public int getStableInsetLeft() {
        return this.mImpl.getStableInsets().left;
    }

    @Deprecated
    public int getStableInsetRight() {
        return this.mImpl.getStableInsets().right;
    }

    @Deprecated
    public int getStableInsetTop() {
        return this.mImpl.getStableInsets().top;
    }

    @Deprecated
    public Insets getStableInsets() {
        return this.mImpl.getStableInsets();
    }

    @Deprecated
    public Insets getSystemGestureInsets() {
        return this.mImpl.getSystemGestureInsets();
    }

    @Deprecated
    public int getSystemWindowInsetBottom() {
        return this.mImpl.getSystemWindowInsets().bottom;
    }

    @Deprecated
    public int getSystemWindowInsetLeft() {
        return this.mImpl.getSystemWindowInsets().left;
    }

    @Deprecated
    public int getSystemWindowInsetRight() {
        return this.mImpl.getSystemWindowInsets().right;
    }

    @Deprecated
    public int getSystemWindowInsetTop() {
        return this.mImpl.getSystemWindowInsets().top;
    }

    @Deprecated
    public Insets getSystemWindowInsets() {
        return this.mImpl.getSystemWindowInsets();
    }

    @Deprecated
    public Insets getTappableElementInsets() {
        return this.mImpl.getTappableElementInsets();
    }

    public boolean hasInsets() {
        boolean bl = !this.getInsets(Type.all()).equals((Object)Insets.NONE) || !this.getInsetsIgnoringVisibility(Type.all() ^ Type.ime()).equals((Object)Insets.NONE) || this.getDisplayCutout() != null;
        return bl;
    }

    @Deprecated
    public boolean hasStableInsets() {
        return this.mImpl.getStableInsets().equals((Object)Insets.NONE) ^ true;
    }

    @Deprecated
    public boolean hasSystemWindowInsets() {
        return this.mImpl.getSystemWindowInsets().equals((Object)Insets.NONE) ^ true;
    }

    public int hashCode() {
        Impl impl = this.mImpl;
        int n = impl == null ? 0 : impl.hashCode();
        return n;
    }

    public WindowInsetsCompat inset(int n, int n2, int n3, int n4) {
        return this.mImpl.inset(n, n2, n3, n4);
    }

    public WindowInsetsCompat inset(Insets insets) {
        return this.inset(insets.left, insets.top, insets.right, insets.bottom);
    }

    public boolean isConsumed() {
        return this.mImpl.isConsumed();
    }

    public boolean isRound() {
        return this.mImpl.isRound();
    }

    public boolean isVisible(int n) {
        return this.mImpl.isVisible(n);
    }

    @Deprecated
    public WindowInsetsCompat replaceSystemWindowInsets(int n, int n2, int n3, int n4) {
        return new Builder(this).setSystemWindowInsets(Insets.of((int)n, (int)n2, (int)n3, (int)n4)).build();
    }

    @Deprecated
    public WindowInsetsCompat replaceSystemWindowInsets(Rect rect) {
        return new Builder(this).setSystemWindowInsets(Insets.of((Rect)rect)).build();
    }

    void setOverriddenInsets(Insets[] insetsArray) {
        this.mImpl.setOverriddenInsets(insetsArray);
    }

    void setRootViewData(Insets insets) {
        this.mImpl.setRootViewData(insets);
    }

    void setRootWindowInsets(WindowInsetsCompat windowInsetsCompat) {
        this.mImpl.setRootWindowInsets(windowInsetsCompat);
    }

    void setStableInsets(Insets insets) {
        this.mImpl.setStableInsets(insets);
    }

    public WindowInsets toWindowInsets() {
        Object object = this.mImpl;
        object = object instanceof Impl20 ? ((Impl20)object).mPlatformInsets : null;
        return object;
    }
}
