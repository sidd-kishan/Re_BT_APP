/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.View$OnApplyWindowInsetsListener
 *  android.view.WindowInsets
 *  androidx.core.view.OnApplyWindowInsetsListener
 *  androidx.core.view.ViewCompat
 *  androidx.core.view.ViewCompat$Api21Impl
 *  androidx.core.view.WindowInsetsCompat
 */
package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/*
 * Exception performing whole class analysis ignored.
 */
class ViewCompat.Api21Impl.1
implements View.OnApplyWindowInsetsListener {
    WindowInsetsCompat mLastInsets;
    final OnApplyWindowInsetsListener val$listener;
    final View val$v;

    ViewCompat.Api21Impl.1(View view, OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        this.val$v = view;
        this.val$listener = onApplyWindowInsetsListener;
        this.mLastInsets = null;
    }

    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat((WindowInsets)windowInsets, (View)view);
        if (Build.VERSION.SDK_INT < 30) {
            ViewCompat.Api21Impl.callCompatInsetAnimationCallback((WindowInsets)windowInsets, (View)this.val$v);
            if (windowInsetsCompat.equals((Object)this.mLastInsets)) {
                return this.val$listener.onApplyWindowInsets(view, windowInsetsCompat).toWindowInsets();
            }
        }
        this.mLastInsets = windowInsetsCompat;
        windowInsets = this.val$listener.onApplyWindowInsets(view, windowInsetsCompat);
        if (Build.VERSION.SDK_INT >= 30) {
            return windowInsets.toWindowInsets();
        }
        ViewCompat.requestApplyInsets((View)view);
        return windowInsets.toWindowInsets();
    }
}
