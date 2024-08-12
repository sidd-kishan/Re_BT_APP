/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.view.View
 *  androidx.core.view.OnApplyWindowInsetsListener
 *  androidx.core.view.ViewCompat
 *  androidx.core.view.WindowInsetsCompat
 *  androidx.viewpager.widget.ViewPager
 */
package androidx.viewpager.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.ViewPager;

class ViewPager.4
implements OnApplyWindowInsetsListener {
    private final Rect mTempRect;
    final ViewPager this$0;

    ViewPager.4(ViewPager viewPager) {
        this.this$0 = viewPager;
        this.mTempRect = new Rect();
    }

    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat windowInsetsCompat2 = ViewCompat.onApplyWindowInsets((View)view, (WindowInsetsCompat)windowInsetsCompat);
        if (windowInsetsCompat2.isConsumed()) {
            return windowInsetsCompat2;
        }
        view = this.mTempRect;
        view.left = windowInsetsCompat2.getSystemWindowInsetLeft();
        view.top = windowInsetsCompat2.getSystemWindowInsetTop();
        view.right = windowInsetsCompat2.getSystemWindowInsetRight();
        view.bottom = windowInsetsCompat2.getSystemWindowInsetBottom();
        int n = 0;
        int n2 = this.this$0.getChildCount();
        while (n < n2) {
            windowInsetsCompat = ViewCompat.dispatchApplyWindowInsets((View)this.this$0.getChildAt(n), (WindowInsetsCompat)windowInsetsCompat2);
            view.left = Math.min(windowInsetsCompat.getSystemWindowInsetLeft(), view.left);
            view.top = Math.min(windowInsetsCompat.getSystemWindowInsetTop(), view.top);
            view.right = Math.min(windowInsetsCompat.getSystemWindowInsetRight(), view.right);
            view.bottom = Math.min(windowInsetsCompat.getSystemWindowInsetBottom(), view.bottom);
            ++n;
        }
        return windowInsetsCompat2.replaceSystemWindowInsets(view.left, view.top, view.right, view.bottom);
    }
}
