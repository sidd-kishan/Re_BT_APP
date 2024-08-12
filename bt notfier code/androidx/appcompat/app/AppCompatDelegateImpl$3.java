/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.appcompat.app.AppCompatDelegateImpl
 *  androidx.core.view.OnApplyWindowInsetsListener
 *  androidx.core.view.ViewCompat
 *  androidx.core.view.WindowInsetsCompat
 */
package androidx.appcompat.app;

import android.view.View;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

class AppCompatDelegateImpl.3
implements OnApplyWindowInsetsListener {
    final AppCompatDelegateImpl this$0;

    AppCompatDelegateImpl.3(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.this$0 = appCompatDelegateImpl;
    }

    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        int n = windowInsetsCompat.getSystemWindowInsetTop();
        int n2 = this.this$0.updateStatusGuard(windowInsetsCompat, null);
        WindowInsetsCompat windowInsetsCompat2 = windowInsetsCompat;
        if (n == n2) return ViewCompat.onApplyWindowInsets((View)view, (WindowInsetsCompat)windowInsetsCompat2);
        windowInsetsCompat2 = windowInsetsCompat.replaceSystemWindowInsets(windowInsetsCompat.getSystemWindowInsetLeft(), n2, windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom());
        return ViewCompat.onApplyWindowInsets((View)view, (WindowInsetsCompat)windowInsetsCompat2);
    }
}
